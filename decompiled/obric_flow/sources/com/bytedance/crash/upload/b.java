package com.bytedance.crash.upload;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.MonitorCrash;
import com.bytedance.crash.entity.Header;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.services.slardar.config.IConfigManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.anniex.worker.a f4093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f4094b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IConfigManager f4095c = null;
    public static boolean d = true;
    public static File e = null;
    public static boolean f = false;
    public static boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.android.anniex.worker.a f4096h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map f4097i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f4098j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f4099k = 100;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f4100l;

    static {
        f4093a = new com.bytedance.android.anniex.worker.a(6);
        f4096h = new com.bytedance.android.anniex.worker.a(8);
    }

    public static t a(String r5, String r10, String r11, File r12, c5.a... r13) {
        if (com.bytedance.crash.p.f4084h == true) goto L5;
        String r14 = f(r10, "have_dump=true&encrypt=true");     // Catch: IOException -> L10
        long r15 = s.c(null, new URL(r14));     // Catch: IOException -> L10
        if (r15 < 0) goto L9;
        if (r15 > 0) goto L14;
        ce.b r16 = new ce.b(r14, true);     // Catch: IOException -> L10
        r16.e("json", r11, true);     // Catch: IOException -> L10
        r16.k(r13);     // Catch: IOException -> L10
        if (r12 == null) goto L19;
        r16.b(r12, "minidmp");     // Catch: IOException -> L10
    L19:
        return r16.a(r5);
    L14:
        return new t(214);
    L9:
        return new t(213);
    L10:
        e = move-exception;
        e.printStackTrace();
        io.reactivex.exceptions.a.l("err upload crash log " + e);
        return new t(ComposerKt.reuseKey);
    L5:
        return new t(201);
    }

    public static t b(String r5, String r10, boolean r11) {
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        return new t(th);
    L3:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        if (TextUtils.isEmpty(r5) == true) goto L12;
        return d(r5, r10.getBytes(), r11);
    L12:
        return new t(201);
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [byte[], java.lang.Cloneable] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    public static t c(String r10, byte[] r11, String r12, String r13, String r14, boolean r15) {
        HttpsURLConnection r5 = null;
        GZIPInputStream r16 = null;
        SSLContext r17 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L6
        r17.init(null, null, null);     // Catch: Throwable -> L100
    L108:
        URL r18 = new URL(r10);     // Catch: Throwable -> L11
        long r19 = s.c(null, r18);     // Catch: Throwable -> L11
        if (r19 < 0) goto L10;
        if (r19 > 0) goto L15;
        HttpsURLConnection r20 = (HttpsURLConnection) r18.openConnection();     // Catch: Throwable -> L11
        if (r17 == null) goto L22;
        io.reactivex.exceptions.a.l("executeRequestInner:setSSLSocketFactory");     // Catch: Throwable -> L19
        r20.setSSLSocketFactory(new u(r17.getSocketFactory()));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r5 = r20;
        th = th;
        InputStream r110 = null;
    L115:
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L95
        t r111 = new t(th);     // Catch: Throwable -> L95
        if (r5 != null) goto L129;
    L93:
        com.bytedance.android.anniex.base.service.f.h(r110);
        return r111;
    L129:
        r5.disconnect();     // Catch: Exception -> L103
    L95:
        th = move-exception;
        if (r5 != null) goto L122;
    L98:
        com.bytedance.android.anniex.base.service.f.h(r110);
        throw th;
    L122:
        r5.disconnect();     // Catch: Exception -> L104
    L22:
        if (r15 == false) goto L24;
        r20.setDoOutput(true);     // Catch: Throwable -> L19
    L25:
        r20.setRequestProperty("Content-Type", r12);     // Catch: Throwable -> L19
        if (r13 == null) goto L28;
        r20.setRequestProperty("Content-Encoding", r13);     // Catch: Throwable -> L19
    L28:
        r20.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L19
        r20.setRequestMethod(r14);     // Catch: Throwable -> L19
        if (r11 != null) goto L31;
    L41:
        int r112 = r20.getResponseCode();     // Catch: Throwable -> L19
        t r113 = new t(0);     // Catch: Throwable -> L19
        r113.f4161c = r112;     // Catch: Throwable -> L19
        r113.f = r20.getHeaderFields();     // Catch: Throwable -> L19
        if (r112 != 200) goto L87;
        r110 = r20.getInputStream();     // Catch: Throwable -> L19
    L59:
        th = move-exception;
        r5 = r20;
        th = th;
        goto L115
    L46:
        if ("gzip".equalsIgnoreCase(r20.getContentEncoding()) == true) goto L109;
        ByteArrayOutputStream r114 = new ByteArrayOutputStream();     // Catch: Throwable -> L59
        byte[] r115 = new byte[8192];     // Catch: Throwable -> L59
    L69:
        int r21 = r110.read(r115);     // Catch: Throwable -> L59
        if ((-1) == r21) goto L72;
        r114.write(r115, 0, r21);     // Catch: Throwable -> L59
        goto L69
    L72:
        r110.close();     // Catch: Throwable -> L59
        byte[] r116 = r114.toByteArray();     // Catch: Throwable -> L84
        com.bytedance.android.anniex.base.service.f.h(r114);     // Catch: Throwable -> L59
        ?? r117 = r116;
    L75:
        if (r117 == 0) goto L80;
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L59
        r118 = new JSONObject(new String(r117));     // Catch: Throwable -> L101
    L79:
        r113.a(r118);     // Catch: Throwable -> L59
    L80:
        s.k(r18, r113);     // Catch: Throwable -> L59
        r113.e = r117;     // Catch: Throwable -> L59
        r20.disconnect();     // Catch: Exception -> L102
    L82:
        com.bytedance.android.anniex.base.service.f.h(r110);
        return r113;
    L84:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r114);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L109:
        GZIPInputStream r119 = new GZIPInputStream(r110);     // Catch: Throwable -> L65
        ByteArrayOutputStream r22 = new ByteArrayOutputStream();     // Catch: Throwable -> L52
        byte[] r120 = new byte[8192];     // Catch: Throwable -> L52
    L49:
        int r23 = r119.read(r120);     // Catch: Throwable -> L52
        if ((-1) == r23) goto L54;
        r22.write(r120, 0, r23);     // Catch: Throwable -> L52
        goto L49
    L54:
        r119.close();     // Catch: Throwable -> L52
        byte[] r121 = r22.toByteArray();     // Catch: Throwable -> L61
        com.bytedance.android.anniex.base.service.f.h(r22);     // Catch: Throwable -> L52
        com.bytedance.android.anniex.base.service.f.h(r119);     // Catch: Throwable -> L59
        r117 = r121;
        goto L75
    L61:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r22);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L52:
        th = th;
        r16 = r119;
    L66:
        com.bytedance.android.anniex.base.service.f.h(r16);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L65:
        th = th;
        goto L66
    L87:
        s.k(r18, r113);     // Catch: Throwable -> L19
        r113.f4160b = ComposerKt.referenceKey;     // Catch: Throwable -> L19
        r20.disconnect();     // Catch: Exception -> L105
    L89:
        return r113;
    L31:
        if (r11.length <= 0) goto L41;
        DataOutputStream r122 = new DataOutputStream(r20.getOutputStream());     // Catch: Throwable -> L37
        r122.write(r11);     // Catch: Throwable -> L35
        r122.flush();     // Catch: Throwable -> L35
        com.bytedance.android.anniex.base.service.f.h(r122);     // Catch: Throwable -> L19
    L35:
        th = th;
    L39:
        com.bytedance.android.anniex.base.service.f.h(r122);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L37:
        th = th;
        r122 = null;
        goto L39
    L24:
        r20.setDoOutput(false);     // Catch: Throwable -> L19
        goto L25
    L15:
        return new t(214);
    L10:
        return new t(213);
    L11:
        th = th;
        r110 = null;
    L6:
        r17 = null;
        goto L108
    }

    public static t d(String r10, byte[] r11, boolean r12) {
        if (com.bytedance.crash.p.f4084h == true) goto L5;
        if (r10 == null) goto L8;
        if (r11 != null) goto L11;
        r11 = new byte[0];
    L11:
        String r5 = null;
        if (r11.length <= 128) goto L20;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r14 = new GZIPOutputStream(r13);
        r14.write(r11);     // Catch: Throwable -> L16
        r14.close();
        r11 = r13.toByteArray();
    L19:
        r5 = "gzip";
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);     // Catch: Throwable -> L21
        r14.close();
        r11 = null;
    L21:
        th = move-exception;
        r14.close();
        throw th;
    L20:
        byte[] r15 = r11;
        String r16 = r5;
        if (r15 != null) goto L28;
        return new t(ComposerKt.compositionLocalMapKey);
    L28:
        if (r12 == false) goto L44;
        ((com.lynx.tasm.behavior.d) com.bytedance.crash.n.f4062j.getEncryptImpl()).getClass();
        byte[] r17 = EncryptorUtil.a(r15.length, r15);
        if (r17 != null) goto L32;
        byte[] r18 = r15;
        String r19 = "application/json; charset=utf-8";
        String r20 = r10;
    L42:
        return c(r20, r18, r19, r16, "POST", true);
    L32:
        if (TextUtils.isEmpty(new URL(r10).getQuery()) == false) goto L37;
        if (r10.endsWith("?") == true) goto L39;
        r10 = r10.concat("?");
    L39:
        r20 = io.reactivex.internal.observers.h.b(r10, "tt_data=a");
        r18 = r17;
        r19 = "application/octet-stream;tt-data=a";
        goto L42
    L37:
        if (r10.endsWith("&") == true) goto L39;
        r10 = r10.concat("&");
        goto L39
    L44:
        return c(r10, r15, "application/json; charset=utf-8", r16, "POST", true);
    L8:
        return new t(201);
    L5:
        return new t(201);
    }

    public static File e() {
        return new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.s);
    }

    public static String f(String r5, String r10) {
        if (TextUtils.isEmpty(new URL(r5).getQuery()) == false) goto L9;
        if (r5.endsWith("?") == true) goto L11;
        r5 = r5.concat("?");     // Catch: Throwable -> L13
    L11:
        return r5 + r10;
    L9:
        if (r5.endsWith("&") == true) goto L11;
        r5 = r5.concat("&");     // Catch: Throwable -> L13
    L16:
        return r5;
    }

    public static String g(String r5, String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = com.bytedance.crash.n.d().i();
    L5:
        String r12 = "";
        if (TextUtils.isEmpty(r11) == false) goto L11;
        i4.a r13 = com.bytedance.crash.n.d();
        r13.getClass();
        r11 = ((ICommonParams) r13.f17503c).getDeviceId();     // Catch: Throwable -> L10
    L10:
        r11 = "";
    L11:
        StringBuilder r14 = com.lynx.tasm.base.a.e("aid=", r10, "&os=Android&device_id=", r11, "&app_version=");
        i4.a r15 = com.bytedance.crash.n.d();
        r15.getClass();
        String r16 = String.valueOf(((ICommonParams) r15.f17503c).getCommonParams().get("app_version"));     // Catch: Throwable -> L14
    L15:
        r14.append(r16);
        r14.append("&update_version_code=");
        i4.a r17 = com.bytedance.crash.n.d();
        r17.getClass();
        r12 = String.valueOf(((ICommonParams) r17.f17503c).getCommonParams().get("update_version_code"));     // Catch: Throwable -> L19
    L17:
        r14.append(r12);
        r14.append("&sdk_version=");
        r14.append(String.valueOf(30107139));
        return f(r5, r14.toString());
    L14:
        r16 = "";
        goto L15
    }

    public static String h(String r5, HashMap r10) {
        if (TextUtils.isDigitsOnly(r5) == false) goto L5;
        return r5;
    L5:
        if (r10.isEmpty() == true) goto L43;
        StringBuilder r11 = new StringBuilder(r5);
        if (r5.contains("?") == true) goto L34;
        r11.append("?");
    L34:
        Iterator r12 = r10.entrySet().iterator();     // Catch: Exception -> L31
    L12:
        if (r12.hasNext() == false) goto L30;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Exception -> L31
        if (r13.getValue() == null) goto L12;
        if (r11.toString().endsWith("?") == true) goto L32;
        r11.append("&");     // Catch: Exception -> L31
    L32:
        r11.append(URLEncoder.encode(r13.getKey().toString(), "UTF-8"));     // Catch: Exception -> L31
        r11.append("=");     // Catch: Exception -> L31
        r11.append(URLEncoder.encode(r13.getValue().toString(), "UTF-8"));     // Catch: Exception -> L31
        goto L12
    L23:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: Exception -> L31
    L26:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: Exception -> L31
    L30:
        return r11.toString();
    L44:
        return r5;
    L43:
        return r5;
    }

    public static String i(String r13, JSONObject r14) {
        String[] r5 = {WsConstants.KEY_APP_ID, "4444", "os", "Android", WsConstants.KEY_DEVICE_ID, com.bytedance.crash.n.g().e(), "app_version", "unknown", "update_version_code", "unknown", WsConstants.KEY_SDK_VERSION, String.valueOf(30107139)};
        HashMap r10 = new HashMap();
        if (r14 == null) goto L10;
        Iterator<String> r11 = r14.keys();
    L7:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();
        r10.put(r12, r14.opt(r12));
    L10:
        return h(r13, i4.a.j(r10, r5));
    }

    public static void j(MonitorCrash r11, Throwable r12, StackTraceElement[] r13, int r14, String r15, Thread r16, String r17) {
        String r5 = r16.getName();
        if (n.f() == false) goto L5;
        return;
    L5:
        TextUtils.isEmpty("core_exception_monitor");
        if (com.bytedance.crash.p.f4081a == false) goto L8;
    L11:
        boolean r10 = true;
        f4100l++;
        String r18 = z8.d.a(r11);
        HashMap r19 = n9.a.f;
        if (r19.get(r18) == null) goto L14;
        boolean r20 = true;
    L15:
        if (r20 == false) goto L37;
        ConcurrentLinkedQueue r21 = l9.c.f19554a;
        String r22 = z8.d.a(r11);
        n9.a r23 = null;
        if (TextUtils.isEmpty(r22) == false) goto L19;
        n9.a r24 = null;
    L20:
        if (r24 != null) goto L22;
        boolean r25 = false;
    L23:
        if (r25 == true) goto L26;
        io.reactivex.exceptions.a.i("exception has been discard due to not sampled: ".concat("core_exception_monitor"));
        return;
    L26:
        String r26 = z8.d.a(r11);
        if (TextUtils.isEmpty(r26) == true) goto L30;
        r23 = (n9.a) r19.get(r26);
    L30:
        if (r23 != null) goto L32;
        boolean r27 = false;
    L33:
        if (r27 == true) goto L37;
        io.reactivex.exceptions.a.i("exception has been discard due to not sampled message: " + r15);
        return;
    L32:
        r27 = r23.b(r15);
        goto L33
    L22:
        r25 = r24.c("core_exception_monitor");
        goto L23
    L19:
        r24 = (n9.a) r19.get(r22);
    L37:
        if (com.bytedance.crash.p.f4081a == true) goto L39;
    L41:
        if (r10 == true) goto L44;
        io.reactivex.exceptions.a.l("exception has been discard due to exceed limit: core_exception_monitor msg: " + r15);
        return;
    L44:
        l9.o.e().b(new j(r20, r15, r5, r12, r13, r14, r17, r11));
        return;
    L39:
        if (l9.i.f19565i == false) goto L41;
        l9.i r28 = l9.i.a();
        r10 = r28.d("exception", r28.f19569c, false);
        l9.i.c(r10);
        goto L41
    L14:
        r20 = false;
        goto L15
    L8:
        if (f4100l < f4099k) goto L11;
        io.reactivex.exceptions.a.i("exception has been discard due to exceed limit before Npth.init: ".concat("core_exception_monitor"));
    }

    public static void k(String r5, boolean r10) {
        if (f4097i != null) goto L6;
        f4097i = new HashMap();
    L6:
        if (g == true) goto L11;
        g = true;
        boolean r11 = o(null);
        r();
        if (r11 == false) goto L11;
        io.reactivex.exceptions.a.i("start fetch apmConfig");
        f4094b = 40;
        l9.o.e().b(f4093a);
    L11:
        if (r10 == false) goto L13;
    L16:
        f4097i.put(r5, String.valueOf(System.currentTimeMillis()));
        io.reactivex.exceptions.a.i("udpate config time for aid " + r5);
        return;
    L13:
        if (f4097i.containsKey(r5) == false) goto L16;
    }

    public static void l(JSONObject r5, JSONArray r10, z8.a r11) {
        if (mh.e.m(r10) == false) goto L6;
        io.reactivex.exceptions.a.i("uploadFromFile with empty aid Data ");
        r11.a(r5);
        return;
    L6:
        int r12 = 0;
    L8:
        if (r12 >= r10.length()) goto L13;
        JSONObject r13 = r10.optJSONObject(r12);
        if (r13 == null) goto L16;
        JSONObject r14 = new JSONObject();
        z8.c.n(r14, r5);
        z8.c.n(r14, r13);
        io.reactivex.exceptions.a.i("uploadFromFile with aidData " + r13);
        r11.a(r14);
        r12 = r12 + 1;
        goto L8
    L16:
        return;
    }

    public static boolean m(File r10, String r11) {
        return n(r10, g(com.bytedance.crash.n.f4062j.getCoreDumpUrl(), "", ""), Header.f().f4029a.toString(), new JSONObject().put("event_type", "raphael_file").put("timestamp", System.currentTimeMillis()).put("uuid", r11).toString());
    L5:
        return false;
    }

    public static boolean n(File r10, String r11, String r12, String r13) {
        String r5 = "";
        r5 = new JSONObject(r12).optString(WsConstants.KEY_APP_ID);     // Catch: IOException -> L6 JSONException -> L18
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L9:
        if (s.c(r5, new URL(r11)) == 0) goto L11;
        return true;
    L11:
        ce.b r14 = new ce.b(r11, false);     // Catch: IOException -> L6
        r14.e("data", r13, false);     // Catch: IOException -> L6
        r14.e("header", r12, false);     // Catch: IOException -> L6
        r14.b(r10, "file");     // Catch: IOException -> L6
        t r15 = r14.a("coredump");     // Catch: IOException -> L6
        if (r15 == null) goto L15;
        return r15.c();
    L15:
        return true;
    }

    public static boolean o(String r5) {
        if (e != null) goto L5;
        e = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22993p);
    L5:
        File r10 = e;
        Map r11 = f4097i;     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        r11 = cl.a.H(r10);     // Catch: Throwable -> L9
    L11:
        f4097i = r11;     // Catch: Throwable -> L9
        return l9.d.d(r5, r11);
    L9:
        th = move-exception;
        if (com.bytedance.crash.n.f4062j.isDebugMode() == false) goto L20;
        Log.e("npth", "npth err", th);
        return true;
    L20:
        return true;
    }

    public static boolean p(String r11, String r12, String r13, String r14, ArrayList r15) {
        if (com.bytedance.crash.p.f4084h == false) goto L37;
        return false;
    L37:
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L20
        r5.put(WsConstants.KEY_APP_ID, r12);     // Catch: Throwable -> L20
        r5.put(WsConstants.KEY_DEVICE_ID, r13);     // Catch: Throwable -> L20
        r5.put("os", "Android");     // Catch: Throwable -> L20
        r5.put("process_name", r14);     // Catch: Throwable -> L20
        r5.toString();     // Catch: Throwable -> L20
        if (s.c(r12, new URL(r11)) == 0) goto L8;
        return true;
    L8:
        ce.b r10 = new ce.b(r11, false);     // Catch: Throwable -> L20
        r10.e(WsConstants.KEY_APP_ID, r12, false);     // Catch: Throwable -> L20
        r10.e(WsConstants.KEY_DEVICE_ID, r13, false);     // Catch: Throwable -> L20
        r10.e("os", "Android", false);     // Catch: Throwable -> L20
        r10.e("process_name", r14, false);     // Catch: Throwable -> L20
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L20
    L11:
        if (r16.hasNext() == false) goto L24;
        File r17 = new File((String) r16.next());     // Catch: Throwable -> L20
        if (r17.exists() == false) goto L11;
        HashMap r18 = new HashMap();     // Catch: Throwable -> L20
        r18.put("logtype", "alog");     // Catch: Throwable -> L20
        r18.put("scene", "crash");     // Catch: Throwable -> L20
        r10.f(r17.getName(), r18);     // Catch: Throwable -> L20
        FileInputStream r19 = new FileInputStream(r17);     // Catch: Throwable -> L20
        byte[] r110 = new byte[8192];     // Catch: Throwable -> L20
    L15:
        int r111 = r19.read(r110);     // Catch: Throwable -> L20
        if (r111 == (-1)) goto L23;
        if (r10.f1175b == true) goto L19;
        ((i) r10.d).write(r110, 0, r111);     // Catch: Throwable -> L20
        goto L15
    L19:
        ((v) r10.e).write(r110, 0, r111);     // Catch: Throwable -> L20
        goto L15
    L23:
        r19.close();     // Catch: Throwable -> L20
        r10.j("\r\n".getBytes());     // Catch: Throwable -> L20
        goto L11
    L24:
        JSONObject r112 = (JSONObject) r10.a("alog").d;     // Catch: Throwable -> L34
        if (r112 == null) goto L31;
        if (r112.optInt("errno", -1) != 200) goto L31;
        return true;
    L31:
        return false;
    L20:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        return false;
    }

    public static void q() {
        if (d == true) goto L5;
        return;
    L5:
        if (f4095c != null) goto L16;
        f4095c = (IConfigManager) og.a.a(IConfigManager.class);     // Catch: Throwable -> L8
    L9:
        IConfigManager r5 = f4095c;
        if (r5 == null) goto L17;
        r5.registerConfigListener(new a());
        return;
    L17:
        return;
    L8:
        d = false;
        goto L9
    }

    public static void r() {
        if (f == true) goto L14;
        File r5 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22991n);
        if (r5.exists() == false) goto L15;
        l9.c.a(new JSONArray(cl.a.c(-1, r5, "\n")), false);     // Catch: Throwable -> L10
        f = true;     // Catch: Throwable -> L10
        return;
    L10:
        ConcurrentLinkedQueue r10 = l9.c.f19554a;
        return;
    L15:
        return;
    }

    public static void s() {
        io.reactivex.exceptions.a.i("try updateWhenCrash");
        CountDownLatch r5 = new CountDownLatch(1);
        a6.a r10 = new a6.a(r5, 12);
        if (Looper.getMainLooper() == Looper.myLooper()) goto L11;
        r10.run();
        return;
    L11:
        new Thread(r10).start();     // Catch: Throwable -> L9
    L13:
        r5.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        return;
    }
}
