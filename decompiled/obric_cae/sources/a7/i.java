package a7;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.obric.cae.userAware.datacollection.NetworkClient;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UnknownFormatConversionException;
import java.util.regex.Pattern;
import org.json.JSONObject;
import r1.s;

/* JADX INFO: loaded from: classes.dex */
public final class i implements w6.c, ICronetClient.ICronetBootFailureChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ICronetClient f111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile i f112c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f113d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile int f114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b f116g;

    public interface a {
        boolean isCronetBootFailureExpected();
    }

    public interface b {
        boolean g();
    }

    public i(Context r8) {
        f110a = r8.getApplicationContext();
    }

    public static void a() {
        if (f111b == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void b(String r8) {
        if (f113d == true) goto L12;
        Context r10 = f110a;
        if (r10 == null) goto L12;
        if (r5.e.e(r10) == true) goto L12;
        throw new b7.c();
    L12:
        if (f113d == true) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r8) == false) goto L16;
        return;
    L16:
        if (r8.contains("net::ERR_INTERNET_DISCONNECTED") == true) goto L19;
        return;
    L19:
        throw new b7.c();
    }

    public static HttpURLConnection c(String r10, Request r11, w6.a r12, long r13) {
        w6.e.a r8 = w6.e.f13022c;
        if (r8 == null) goto L5;
        r8.onTryInit();
    L5:
        Object r14 = r11.getExtraInfo();
        if (r14 != null) goto L8;
    L10:
        w6.e.f();
        Logger.d("i", "newCookieBlockPositionEnabled false:" + r11.getUrl());
        u();
        ICronetClient r15 = f111b;
        if (r15 == null) goto L73;
        r15.setCronetBootFailureChecker(f112c);
        ICronetClient r16 = f111b;
        Context r17 = f110a;
        b r18 = f116g;
        boolean r19 = false;
        if (r18 != null) goto L15;
        boolean r20 = false;
    L16:
        HttpURLConnection r21 = r16.openConnection(r17, r10, r20, w6.e.f13021b, new i7.c());
        r21.setConnectTimeout(BWDLInnerConstant.DATA_LINK_TOUT);
        r21.setReadTimeout(BWDLInnerConstant.DATA_LINK_TOUT);
        int r22 = f114e;
        if (r22 < 8192) goto L20;
        if (r22 > 20971520) goto L20;
        boolean r23 = true;
    L22:
        if (r23 == true) goto L74;
    L27:
        r21.setInstanceFollowRedirects(true);
        T r24 = r12.f12991b;
        if ((r24 instanceof w6.b) == false) goto L76;
        r24.getClass();
        int r25 = f114e;
        if (r24.f13016a == true) goto L76;
        r21.setInstanceFollowRedirects(false);
    L76:
        Reflect.on(r21).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r11.getRequestPriorityLevel())});     // Catch: Throwable -> L34
    L37:
        if (r13 > 0) goto L78;
    L42:
        r21.setRequestMethod(r11.getMethod());
        r21.setDoInput(true);
        Iterator<Header> r110 = r11.getHeaders().iterator();
    L44:
        if (r110.hasNext() == false) goto L54;
        Header r111 = r110.next();
        if (r5.f.b(r111.getName()) == true) goto L44;
        if (r5.f.b(r111.getValue()) == true) goto L44;
        if ("User-Agent".equalsIgnoreCase(r111.getName()) == false) goto L53;
        r19 = true;
    L53:
        r21.setRequestProperty(r111.getName(), r111.getValue());
        goto L44
    L54:
        if (r19 == true) goto L61;
        String r112 = w6.e.f13021b;
        if (r5.f.b(r112) == true) goto L61;
        if (f111b == null) goto L60;
        StringBuilder r113 = android.aimedia.a.k(r112, " cronet/");
        r113.append(f111b.getCronetVersion());
        r112 = r113.toString();
    L60:
        r21.setRequestProperty("User-Agent", r112);
    L61:
        TypedOutput r114 = r11.getBody();
        if (r114 == null) goto L70;
        r21.setDoOutput(true);
        r21.setRequestProperty("Content-Type", r114.mimeType());
        String r115 = r114.md5Stub();
        if (r115 == null) goto L66;
        r21.setRequestProperty("X-SS-STUB", r115);
    L66:
        long r116 = r114.length();
        if (r116 == (-1)) goto L69;
        r21.setFixedLengthStreamingMode((int) r116);
        r21.setRequestProperty("Content-Length", String.valueOf(r116));
        goto L70
    L69:
        r21.setChunkedStreamingMode(4096);
    L70:
        r12.f13013x = d(r21);
        return r21;
    L78:
        Reflect.on(r21).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r13)});     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L74:
        Reflect.on(r21).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(f114e)});     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L20:
        r23 = false;
        goto L22
    L15:
        r20 = r18.g();
        goto L16
    L73:
        throw new IllegalArgumentException("CronetClient is null");
    L8:
        if ((r14 instanceof w6.b) == false) goto L10;
        w6.b r26 = (w6.b) r14;
        goto L10
    }

    public static JSONObject d(HttpURLConnection r8) {
        JSONObject r10 = new JSONObject();
        if (r8 != null) goto L13;
        return r10;
    L13:
        r10.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L10
        ICronetClient r11 = f111b;     // Catch: Exception -> L10
        if (r11 == null) goto L8;
        r10.put("hcv", r11.getCronetVersion());     // Catch: Exception -> L10
    L8:
        r10.put("ua", r8.getRequestProperty("User-Agent"));     // Catch: Exception -> L10
    L12:
        return r10;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static ArrayList e(HttpURLConnection r8, boolean r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r12 = r8.getHeaderFields().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L14;
        if (r14.equalsIgnoreCase("bdturing-verify") == false) goto L14;
        if (r10 == true) goto L7;
    L14:
        Iterator<String> r15 = r13.getValue().iterator();
    L16:
        if (r15.hasNext() == false) goto L7;
        r11.add(new Header(r14, r15.next()));
        goto L16
    L18:
        return r11;
    }

    public static void f(boolean r8, String r10, String r11, String r12, boolean r13, String r14) {
        ICronetClient r15 = f111b;
        if (r15 == null) goto L7;
        Reflect r16 = Reflect.on(r15);
        Class r17 = Boolean.TYPE;
        r16.call("enableTTBizHttpDns", new Class[]{r17, String.class, String.class, String.class, r17, String.class}, new Object[]{Boolean.valueOf(r8), r10, r11, r12, Boolean.valueOf(r13), r14}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static String g(HttpURLConnection r8) {
        if (r8 != null) goto L41;
        return "";
    L41:
        Map<String, List<String>> r10 = r8.getHeaderFields();     // Catch: Throwable -> L38
        if (r10 != null) goto L8;
    L37:
        return "";
    L8:
        if (r10.isEmpty() == true) goto L37;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L38
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();     // Catch: Throwable -> L38
    L12:
        if (r12.hasNext() == false) goto L35;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L38
        if (r13 == null) goto L12;
        String r14 = r13.getKey();     // Catch: Throwable -> L38
        if (r5.f.b(r14) == true) goto L12;
        List<String> r15 = r13.getValue();     // Catch: Throwable -> L38
        if (r15 == null) goto L12;
        if (r15.isEmpty() == true) goto L12;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L38
        Iterator<String> r17 = r15.iterator();     // Catch: Throwable -> L38
        int r18 = 0;
    L26:
        if (r17.hasNext() == false) goto L34;
        String r19 = r17.next();     // Catch: Throwable -> L38
        if (r5.f.b(r19) == true) goto L26;
        if (r18 != 0) goto L32;
    L31:
        r16.append(r19);     // Catch: Throwable -> L38
        r18 = r18 + 1;     // Catch: Throwable -> L38
        goto L26
    L32:
        r16.append("; ");     // Catch: Throwable -> L38
        goto L31
    L34:
        r11.put(r14, r16.toString());     // Catch: Throwable -> L38
        goto L12
    L35:
        return r11.toString();
    L38:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String h(String r8) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (r5.f.b(r8) == true) goto L12;
        return new h7.a(r8).a();
    L12:
        return "";
    }

    public static String i(String r8, HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r8) == true) goto L13;
        String r11 = r10.getHeaderField(r8);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return r10.getHeaderField(r8.toLowerCase());
    L13:
        return null;
    }

    public static void j(String r8, w6.a r10) {
        if (r5.f.b(r8) == true) goto L16;
        if (r10 == null) goto L18;
        if (Logger.debug() == false) goto L9;
        Logger.d("i", "getRequestInfo remoteIp = " + r8);     // Catch: Throwable -> L13
    L9:
        r10.f12990a = r8;     // Catch: Throwable -> L13
        T r11 = r10.f12991b;     // Catch: Throwable -> L13
        if (r11 == 0) goto L17;
        r11.getClass();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void k(HttpURLConnection r8, w6.a r10, RetrofitMetrics r11) {
        if (r8 == null) goto L25;
        if (r10 == null) goto L27;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (f111b == null) goto L11;
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L20
        f111b.getRequestMetrics(r8, r12);     // Catch: Throwable -> L20
        if (r12.isEmpty() == true) goto L11;
        r10.f12990a = (String) l(String.class, r12.get(ICronetClient.KEY_REMOTE_IP), "");     // Catch: Throwable -> L20
        r10.f12999j = ((Long) l(Long.class, r12.get(ICronetClient.KEY_DNS_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13000k = ((Long) l(Long.class, r12.get(ICronetClient.KEY_CONNECT_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13001l = ((Long) l(Long.class, r12.get(ICronetClient.KEY_SSL_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13002m = ((Long) l(Long.class, r12.get(ICronetClient.KEY_SEND_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        ((Long) l(Long.class, r12.get(ICronetClient.KEY_PUSH_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13003n = ((Long) l(Long.class, r12.get(ICronetClient.KEY_RECEIVE_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13004o = ((Boolean) l(Boolean.class, r12.get(ICronetClient.KEY_SOCKET_REUSED), Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L20
        r10.f13005p = ((Long) l(Long.class, r12.get(ICronetClient.KEY_TTFB), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13006q = ((Long) l(Long.class, r12.get(ICronetClient.KEY_TOTAL_TIME), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13007r = ((Long) l(Long.class, r12.get(ICronetClient.KEY_SEND_BYTE_COUNT), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13008s = ((Long) l(Long.class, r12.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), -1L)).longValue();     // Catch: Throwable -> L20
        r10.f13012w = (String) l(String.class, r12.get("request_log"), "");     // Catch: Throwable -> L20
        ((Long) l(Long.class, r12.get(ICronetClient.KEY_RETRY_ATTEMPTS), -1L)).longValue();     // Catch: Throwable -> L20
        String r13 = (String) l(String.class, r12.get(ICronetClient.KEY_REQUEST_HEADERS), "");     // Catch: Throwable -> L20
        String r14 = (String) l(String.class, r12.get(ICronetClient.KEY_RESPONSE_HEADERS), "");     // Catch: Throwable -> L20
        ((Long) l(Long.class, r12.get(ICronetClient.KEY_POST_TASK_START), -1L)).longValue();     // Catch: Throwable -> L20
        ((Long) l(Long.class, r12.get(ICronetClient.KEY_REQUEST_START), -1L)).longValue();     // Catch: Throwable -> L20
        ((Long) l(Long.class, r12.get(ICronetClient.KEY_WAIT_CONTEXT), -1L)).longValue();     // Catch: Throwable -> L20
    L11:
        if (r11 == null) goto L26;
        r11.fallbackReason = r10.f13010u;     // Catch: Throwable -> L20
        r11.executeCallEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
        r11.retrofitLogReportTime = System.currentTimeMillis();     // Catch: Throwable -> L20
        r11.ttnetVersion = "4.0.76.2";     // Catch: Throwable -> L20
        r11.extra.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(r10.f13007r));     // Catch: Throwable -> L20
        r11.extra.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(r10.f13008s));     // Catch: Throwable -> L20
        JSONObject r15 = r10.f13013x;     // Catch: Throwable -> L20
        if (r10.f13015z == false) goto L16;
        r15.put("turing_callback", r10.A);     // Catch: Throwable -> L20
    L16:
        if (r10.B == false) goto L18;
        r15.put("turing_retry", "1");     // Catch: Throwable -> L20
    L18:
        r15.put("retrofit", r11.getRetrofitLog());     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L27:
        return;
    }

    public static Object l(Class r8, Object r10, Object r11) {
        if (r10 != null) goto L4;
    L6:
        return r11;
    L4:
        if (r10.getClass().equals(r8) == false) goto L6;
        return r10;
    }

    public static i m(Context r8) {
        if (f112c != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f112c != null) goto L9;
        f112c = new i(r8);     // Catch: Throwable -> L11
        u();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f112c;
    }

    public static void n(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        ICronetClient r8 = f111b;
        if (r8 == null) goto L7;
        Reflect.on(r8).call("notifyStoreRegionUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r10, r11, r12, r13, r14, r15, r16, r17}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static String o(HttpURLConnection r8, w6.a r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        j(i("x-net-info.remoteaddr", r8), r10);
        return i("X-TT-LOGID", r8);
    }

    public static void p(String r11, long r12, w6.a r14, String r15, Exception r16, HttpURLConnection r17, RetrofitMetrics r18) {
        if (r11 == null) goto L44;
        if (r14 != null) goto L42;
    L8:
        r14.f13013x.put("ex", r16.getMessage());     // Catch: Throwable -> L12
        String r8 = g(r17);     // Catch: Throwable -> L12
        if (r5.f.b(r8) == true) goto L14;
        r14.f13013x.put("response-headers", r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        if (r14 != null) goto L16;
    L34:
        long r10 = System.currentTimeMillis() - r12;
        r14.f12997h = System.currentTimeMillis();
        k(r17, r14, r18);
        w6.e.b(r10, r12, r11, r15, r14, r16);
        if (r14.f13014y == false) goto L37;
        r14.C.set(true);
    L37:
        if (r17 == null) goto L45;
        r17.disconnect();
        return;
    L45:
        return;
    L16:
        if (r5.f.b(r14.f12990a) == false) goto L34;
        String r13 = r16.getMessage();     // Catch: Throwable -> L30
        if (r13 == null) goto L32;
        String[] r19 = r13.split("\\|");     // Catch: Throwable -> L30
        if (r19 == null) goto L32;
        if (r19.length < 2) goto L32;
        if (Logger.debug() == false) goto L28;
        Logger.d("i", "getHostAddress remoteIp = " + r19[0]);     // Catch: Throwable -> L30
    L28:
        String r20 = r19[0];     // Catch: Throwable -> L30
    L33:
        j(r20, r14);
    L32:
        r20 = "";
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L42:
        if (r14.f13013x != null) goto L8;
        r14.f13013x = d(r17);     // Catch: Throwable -> L12
        goto L8
    }

    public static void q(boolean r8, int r10, InputStream r11, String r12, String r13, RetrofitMetrics r14) {
        if (r11 != null) goto L5;
        return;
    L5:
        int[] r15 = {0};
        byte[] r16 = h7.c.b(r8, r10, r11, r15, r14);     // Catch: Throwable -> L31
        h7.c.c(r11);
        int r17 = r15[0];
        byte[] r18 = new byte[r17];
        if (r16 == null) goto L11;
        if (r17 <= 0) goto L11;
        System.arraycopy(r16, 0, r18, 0, r17);
    L11:
        if (r17 > 0) goto L13;
        return;
    L13:
        if (r5.f.b(r12) == false) goto L15;
        return;
    L15:
        if (Logger.debug() == false) goto L40;
        h7.a r19 = new h7.a(r12);     // Catch: Throwable -> L28
        if ("text".equalsIgnoreCase(r19.f7917a) == false) goto L19;
    L20:
        String r20 = r19.b();     // Catch: Throwable -> L28
        if (r5.f.b(r20) == false) goto L23;
        r20 = "utf-8";
    L23:
        StringBuilder r21 = new StringBuilder(" response body = ");     // Catch: Throwable -> L28
        r21.append(new String(r18, r20));     // Catch: Throwable -> L28
        r21.append(" for url = ");     // Catch: Throwable -> L28
        if (r13 != null) goto L26;
        r13 = "";
    L26:
        r21.append(r13);     // Catch: Throwable -> L28
        Logger.d("i", r21.toString());     // Catch: Throwable -> L28
        return;
    L19:
        if (NetworkClient.UPLOAD_FILE_TYPE_JSON.equalsIgnoreCase(r19.a()) == true) goto L20;
        return;
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    L40:
        return;
    L31:
        th = move-exception;
        h7.c.c(r11);
        throw th;
    }

    public static byte[] r(String r13, int r14, HttpURLConnection r15, long r16, w6.a r18, String r19, int r20, RetrofitMetrics r21) {
        if (r15 == null) goto L5;
        boolean r8 = "gzip".equals(i("Content-Encoding", r15));
        ICronetClient r10 = f111b;
        if (r10 != null) goto L9;
    L11:
        boolean r11 = r8;
    L12:
        String r12 = i("Content-Type", r15);
        if (r20 != 200) goto L15;
        r18.f12996g = System.currentTimeMillis();
        InputStream r17 = r15.getInputStream();
        int[] r22 = {0};
        r15.getHeaderFields();     // Catch: Throwable -> L43
        byte[] r23 = h7.c.b(r11, r14, r17, r22, r21);     // Catch: Throwable -> L43
        h7.c.c(r17);
        int r24 = r22[0];
        byte[] r25 = new byte[r24];
        if (r23 == null) goto L38;
        if (r24 <= 0) goto L38;
        System.arraycopy(r23, 0, r25, 0, r24);
    L38:
        if (h7.c.d(r12) == false) goto L40;
        h7.c.a(r24, r25);
    L40:
        long r26 = System.currentTimeMillis() - r16;
        r18.f12997h = System.currentTimeMillis();
        k(r15, r18, r21);
        w6.e.d(r26, r16, r13, r19, r18);
        k7.b.e().g(r15, r25, new s(1));     // Catch: Throwable -> L46
    L42:
        return r25;
    L43:
        th = move-exception;
        h7.c.c(r17);
        throw th;
    L15:
        if (r20 != 304) goto L17;
        r18.f12996g = System.currentTimeMillis();
        long r27 = System.currentTimeMillis() - r16;
        r18.f12997h = System.currentTimeMillis();
        k(r15, r18, r21);
        w6.e.d(r27, r16, r13, r19, r18);
    L17:
        String r28 = r15.getResponseMessage();
        InputStream r29 = r15.getInputStream();     // Catch: Throwable -> L20 Exception -> L22
    L19:
        InputStream r30 = r29;
        r15.getHeaderFields();     // Catch: Throwable -> L20
        q(r11, r14, r30, r12, r13, r21);     // Catch: Throwable -> L20
    L29:
        r15.disconnect();
        throw new b7.b(r20, r28);
    L22:
        r29 = r15.getErrorStream();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
        StringBuilder r31 = new StringBuilder("reason = ");
        if (r28 != null) goto L28;
        r28 = "";
    L28:
        r31.append(r28);
        r31.append("  exception = ");
        r31.append(th.getMessage());
        r28 = r31.toString();
        goto L29
    L9:
        if (r10.isCronetHttpURLConnection(r15) == false) goto L11;
        r11 = false;
        goto L12
    L5:
        return new byte[0];
    }

    public static void t(HttpURLConnection r8, w6.a r10, int r11) {
        Map<String, List<String>> r12 = r8.getHeaderFields();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.containsKey("bdturing-verify") == false) goto L16;
        TreeMap r13 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r13.putAll(r12);
        long r14 = SystemClock.uptimeMillis();
        w6.e.d r15 = w6.e.f13020a;
        if (r11 != 200) goto L10;
        Looper.getMainLooper();
        Looper.myLooper();
    L10:
        r10.A = SystemClock.uptimeMillis() - r14;
        if (r13.containsKey("bdturing-verify") == true) goto L15;
        r10.f13015z = true;
        return;
    L15:
        return;
    }

    public static void u() {
        if (f111b != null) goto L18;
        String r8 = "";
        if (r5.f.b("") == false) goto L8;
        r8 = "org.chromium.CronetClient";
    L8:
        Logger.w("i", "tryResolveImpl:".concat(r8));
        Object r10 = Class.forName(r8).newInstance();     // Catch: Throwable -> L13
        if ((r10 instanceof ICronetClient) == false) goto L19;
        f111b = (ICronetClient) r10;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w("i", "load CronetClient exception: " + th);
        return;
    }

    public static void v(String[] r8, int r10, int r11) {
        ICronetClient r12 = f111b;
        if (r12 == null) goto L7;
        Reflect r13 = Reflect.on(r12);
        Class r14 = Integer.TYPE;
        r13.call("tryStartNetDetect", new Class[]{String[].class, r14, r14}, new Object[]{r8, Integer.valueOf(r10), Integer.valueOf(r11)}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static k w(String r8) {
        ICronetClient r10 = f111b;
        if (r10 == null) goto L13;
        String[] r11 = (String[]) Reflect.on(r10).call("ttUrlDispatch", new Class[]{String.class}, new Object[]{r8}).get();
        if (r11.length != 3) goto L11;
        if (TextUtils.isEmpty(r11[0]) == true) goto L11;
        new URL(r11[0]).toURI();
        String r12 = r11[0];
        return new k(r11[1], r11[2]);
    L11:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L13:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureChecker
    public final boolean isCronetBootFailureExpected() {
        a r8 = f115f;
        if (r8 != null) goto L6;
        return false;
    L6:
        return r8.isCronetBootFailureExpected();
    }

    @Override // com.bytedance.retrofit2.client.Client
    public final SsCall newSsCall(Request r10) {
        long r8 = SystemClock.uptimeMillis();
        Request r11 = m7.c.c().b(r10);
        if (r10.getMetrics() == null) goto L5;
        r10.getMetrics().queryFilterDuration = SystemClock.uptimeMillis() - r8;
    L5:
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        if (f.c().f94a <= 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L104;
        if (r10.getUrl().contains("no_retry=1") == true) goto L104;
        f r13 = f.c();
        Iterator r14 = r13.f97d.iterator();
    L16:
        if (r14.hasNext() == false) goto L25;
        f.a r15 = (f.a) r14.next();
        if (r15.f109l == false) goto L16;
        long r16 = SystemClock.uptimeMillis() - r15.f108k;
        if (r16 <= (r15.f104g * 1000)) goto L23;
        r15.f109l = false;
    L23:
        if (Logger.debug() == false) goto L16;
        Logger.d("f", "Rule id: " + r15.f106i + " has forbidden duration: " + r16 + " fail count: " + r15.f107j + " forbidden duration: " + (r15.f104g * 1000));
        goto L16
    L25:
        Iterator r17 = r13.f97d.iterator();
    L27:
        if (r17.hasNext() == false) goto L95;
        f.a r18 = (f.a) r17.next();
        if (r18.f104g > 0) goto L31;
    L33:
        String r19 = r10.getUrl();
        if (TextUtils.isEmpty(r19) == true) goto L92;
        Iterator<String> r20 = r18.f98a.iterator();
    L38:
        if (r20.hasNext() == false) goto L42;
        if (l7.g.b(r10.getHost(), r20.next()) == false) goto L38;
        boolean r21 = true;
    L43:
        if (r21 == true) goto L45;
        Logger.d("f", "host not match: " + r19);
        goto L92
    L45:
        String r22 = r10.getPath();
        if (TextUtils.isEmpty(r22) == true) goto L92;
        ArrayList r23 = r18.f100c;
        if (r23 != null) goto L51;
    L54:
        boolean r24 = true;
    L55:
        if (r24 == true) goto L62;
        Iterator r25 = r18.f100c.iterator();
    L58:
        if (r25.hasNext() == false) goto L62;
        if (r22.equals((String) r25.next()) == false) goto L58;
    L91:
        boolean r26 = true;
    L93:
        if (r26 == false) goto L27;
    L96:
        if (r18 == null) goto L104;
        List<String> r27 = r18.f99b;
        if (r27 == null) goto L104;
        if (r27.size() < 2) goto L104;
        return new a7.b(r10, r18.f99b, r18.f106i);
    L62:
        ArrayList r28 = r18.f101d;
        if (r28 != null) goto L65;
    L68:
        boolean r29 = true;
    L69:
        if (r29 == true) goto L76;
        Iterator r30 = r18.f101d.iterator();
    L72:
        if (r30.hasNext() == false) goto L76;
        if (r22.startsWith((String) r30.next()) == false) goto L72;
    L76:
        ArrayList r31 = r18.f102e;
        if (r31 != null) goto L79;
    L82:
        boolean r32 = true;
    L83:
        if (r32 == true) goto L92;
        Iterator r33 = r18.f102e.iterator();
    L86:
        if (r33.hasNext() == false) goto L92;
        Pattern r34 = (Pattern) r33.next();
        if (r34 == null) goto L86;
        if (r34.matcher(r22).matches() == false) goto L86;
    L79:
        if (r31.isEmpty() == true) goto L82;
        r32 = false;
        goto L83
    L65:
        if (r28.isEmpty() == true) goto L68;
        r29 = false;
        goto L69
    L51:
        if (r23.isEmpty() == true) goto L54;
        r24 = false;
        goto L55
    L42:
        r21 = false;
    L92:
        r26 = false;
        goto L93
    L31:
        if (r18.f109l == false) goto L33;
    L95:
        r18 = null;
    L104:
        return new e(r10, f111b);
    L10:
        r12 = false;
        goto L11
    }

    public final void s(boolean r10, boolean r11, boolean r12) {
        u();
        ICronetClient r8 = f111b;
        if (r8 == null) goto L6;
        r8.setCronetBootFailureChecker(this);
        f111b.setCronetEngine(f110a, false, r10, false, r11, w6.e.f13021b, new i7.c(), r12);
        return;
    }
}
