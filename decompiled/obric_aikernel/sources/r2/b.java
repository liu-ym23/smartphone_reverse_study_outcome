package r2;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.m;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends com.bytedance.frameworks.baselib.network.http.impl.a implements m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static volatile boolean f12591n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static volatile boolean f12592o = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected volatile int f12593l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile long f12594m;

    static {
    }

    b(n4.c r10) {
        super(r10);
        this.f12593l = 0;
        this.f12594m = 0;
        o2.b r11 = this.f1631g;     // Catch: Exception -> L5
        r11.f11417x = 0;     // Catch: Exception -> L5
        r11.f11403j = o2.a.b();     // Catch: Exception -> L5
        this.f1631g.B.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L5
        this.f1631g.B.put("hcv", i.o());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void U(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110) {
        g0(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    private static void V(JSONObject r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (i.n() == null) goto L7;
        JSONObject r11 = i.n().j();
    L8:
        if (r11 == null) goto L16;
        r10.put("ab_test", r11);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r11 = null;
        goto L8
    }

    private void Y(boolean r10, String r11, String r12) {
        if (r10 == true) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (r11.contains("net::ERR_INTERNET_DISCONNECTED") == false) goto L12;
        NetworkNotAvailabeException r13 = new NetworkNotAvailabeException("network not available for " + r12 + ", message:" + r11);
        r13.setShouldReport(true);
        throw r13;
    }

    private int d0(n4.c r10) {
        return i.k(r10.A(), this.f1631g);
    }

    private static String e0(r4.f r10) {
        if ((r10 instanceof com.bytedance.retrofit2.mime.a) == false) goto L5;
        com.bytedance.retrofit2.mime.a r11 = (com.bytedance.retrofit2.mime.a) r10;
        if (TextUtils.isEmpty(r11.e()) == true) goto L9;
        String r12 = r11.g();
        if (TextUtils.isEmpty(r12) == false) goto L13;
        Logger.e("BaseCronetSsCall", "Request compress body md5 shouldn't be null.");
    L13:
        return r12;
    L9:
        return r10.d();
    L5:
        return r10.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T f0(Object r10, Class<T> r11, T r12) {
        if (r10 != 0) goto L4;
    L6:
        return r12;
    L4:
        if (r10.getClass().equals(r11) == false) goto L6;
        return r10;
    }

    private static /* synthetic */ void g0(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110) {
        i.A(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void h0(n4.c r10) {
        if (r10.z() != null) goto L5;
        return;
    L5:
        n4.b r11 = r10.u("x-bd-content-encoding");
        if (r11 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11.b()) == true) goto L19;
        JSONObject r12 = r10.z().f2458q0;
        if (r12 != null) goto L16;
        return;
    L16:
        r12.put("encode", r11.b());     // Catch: JSONException -> L15
        r12.put("disableReason", TTRequestCompressManager.DisableCompress.REMOVE_ENCODING.getReason());     // Catch: JSONException -> L15
        return;
    L20:
        return;
    }

    private static void i0(long r10, long r11, int r12, long r13, n4.c r14, TTRequestCompressManager.b r15) {
        if (r14.z() != null) goto L5;
        return;
    L5:
        JSONObject r16 = new JSONObject();
        r16.put("beforeSize", r10);     // Catch: JSONException -> L10
        if (r12 == 0) goto L12;
        r16.put("disableReason", r12);     // Catch: JSONException -> L10
    L12:
        if (r15 != null) goto L33;
    L13:
        r14.z().f2458q0 = r16;
        return;
    L33:
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L16:
        if (TextUtils.isEmpty(r15.f2549b) == true) goto L18;
        r16.put(WsConstants.KEY_CONNECTION_TYPE, r15.f2549b);     // Catch: JSONException -> L29
        r16.put("afterSize", r11);     // Catch: JSONException -> L29
    L18:
        int r17 = r15.f2550c;     // Catch: JSONException -> L29
        if (r17 == 0) goto L27;
        r16.put("disableReason", r17);     // Catch: JSONException -> L29
        if (r15.f2550c == TTRequestCompressManager.DisableCompress.GZIP_PREFIX_MISMATCH.getReason()) goto L25;
        if (r15.f2550c != TTRequestCompressManager.DisableCompress.ZSTD_PREFIX_MISMATCH.getReason()) goto L27;
    L25:
        if (TextUtils.isEmpty(r15.f2551d) == true) goto L27;
        r16.put("prefix", r15.f2551d);     // Catch: JSONException -> L29
    L27:
        r16.put("duration", System.currentTimeMillis() - r13);     // Catch: JSONException -> L29
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void k0(boolean r10) {
        f12591n = r10;
    }

    public static void l0(boolean r10) {
        f12592o = r10;
    }

    private static boolean m0(n4.c r10) {
        n4.b r11 = r10.u("x-metasec-content-encoding");
        if (r11 != null) goto L7;
        return false;
    L7:
        return NetConst.ENCRYPT_VERISON_CODE.equals(r11.b());
    }

    private static String n0(r4.f r11, n4.c r12) {
        if ((r11 instanceof com.bytedance.retrofit2.mime.a) == false) goto L28;
        if (r12 == null) goto L28;
        com.bytedance.retrofit2.mime.a r10 = (com.bytedance.retrofit2.mime.a) r11;
        if (TextUtils.isEmpty(r10.e()) == false) goto L9;
        long r13 = r11.length();
        n4.b r14 = r12.u("x-metasec-bp-body-compress");
        if (r14 != null) goto L13;
    L17:
        long r15 = System.currentTimeMillis();
        if (r10.i() == true) goto L20;
    L23:
        TTRequestCompressManager.b r16 = r10.f(r12.w(), r12.A(), m0(r12));
        if (r16 != null) goto L26;
        long r17 = 0;
        TTRequestCompressManager.DisableCompress r18 = TTRequestCompressManager.DisableCompress.DATA_NULL;
    L22:
        int r19 = r18.getReason();
    L15:
        i0(r13, r17, r19, r15, r12, null);
        return null;
    L26:
        i0(r13, r11.length(), 0, r15, r12, r16);
        return r16.f2549b;
    L20:
        if (TTRequestCompressManager.h() == false) goto L23;
        r17 = 0;
        r18 = TTRequestCompressManager.DisableCompress.BODY_ENCRYPTED;
        goto L22
    L13:
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r14.b()) == false) goto L17;
        r17 = 0;
        r19 = TTRequestCompressManager.DisableCompress.USER_DISABLE.getReason();
        r15 = 0;
        goto L15
    L9:
        return r10.e();
    L28:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void H(r4.e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1630c.N() == false) goto L6;
        return;
    L6:
        if ((r10 instanceof com.bytedance.retrofit2.mime.c) == false) goto L14;
        c3.b.m().s(a0(), ((com.bytedance.retrofit2.mime.c) r10).j(), a.f12590a);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void I(String r10, n4.c r11, o2.b r12, Map<String, String> r13) {
        r12.f11396c = d0(r11);     // Catch: Exception -> L18
        if (f12591n == true) goto L6;
    L12:
        boolean r14 = false;
    L13:
        r12.f11395b = r14;     // Catch: Exception -> L18
        if (Logger.debug() == false) goto L16;
        Logger.e("BaseCronetSsCall", "url is " + r10 + " useCronetInputStreamWithTTBuffer: " + r12.f11395b);     // Catch: Exception -> L18
    L16:
        HttpURLConnection r15 = b0(r10, r12);     // Catch: Exception -> L18
        Z(r11, r12, r15, r13);     // Catch: Exception -> L18
        j0(r15);     // Catch: Exception -> L18
        return;
    L6:
        if (f12592o == false) goto L12;
        if (r12.f11396c > 0) goto L12;
        if (r12.C == true) goto L12;
        r14 = true;
    L18:
        e = move-exception;
        com.bytedance.frameworks.baselib.network.http.impl.a.T(r10, r12, this, this, e);
        this.f1633i = true;
        if ((e instanceof TTNetExceptionStorage) == false) goto L22;
        throw e;
    L22:
        TTNetExceptionStorage r16 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r16.setInfo(true, false, true, r10, r12.P, r12);
        throw r16;
    }

    protected void W(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1633i == true) goto L17;
        r10.disconnect();
        this.f1633i = true;
        if (this.f1630c.N() == false) goto L16;
        b();
        o2.b r11 = this.f1631g;
        r11.f11405l = System.currentTimeMillis();
        o2.b r12 = this.f1631g;
        r12.f11403j = o2.a.b();
        T r13 = this.f1631g.f11398e;
        if (r13 != 0) goto L11;
    L12:
        o2.f.C(this.f1630c.G(), this.f1631g);
    L13:
        j r14 = j.a();
        String r15 = this.f1630c.G();
        o2.b r16 = this.f1631g;
        r14.c(r15, r16.f11415v, r16.f11416w, r16.N, r16.A);
        return;
    L11:
        if (r13.f11442w == false) goto L13;
    L16:
        return;
    }

    protected void X(HttpURLConnection r10, Throwable r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1633i == true) goto L17;
        r10.disconnect();
        this.f1633i = true;
        b();
        o2.b r13 = this.f1631g;
        r13.f11405l = System.currentTimeMillis();
        o2.b r14 = this.f1631g;
        r14.f11403j = o2.a.b();
        o2.b r15 = this.f1631g;
        T r16 = r15.f11398e;
        if (r16 != 0) goto L9;
    L10:
        o2.f.F(this.f1630c, r15, r11, Boolean.valueOf(r12));
    L12:
        if (this.f1630c.N() == false) goto L16;
        j r17 = j.a();
        String r18 = this.f1630c.G();
        o2.b r19 = this.f1631g;
        r17.c(r18, r19.f11415v, r19.f11416w, r19.N, r19.A);
        return;
    L16:
        return;
    L9:
        if (r16.f11442w == false) goto L12;
    }

    protected void Z(n4.c r17, o2.b r18, HttpURLConnection r19, Map<String, String> r20) {
        long r10 = SystemClock.uptimeMillis();
        r19.setRequestMethod(r17.y());
        r19.setDoInput(true);
        r19.setInstanceFollowRedirects(true);
        T r11 = r18.f11398e;
        if (r11 == 0) goto L5;
        r19.setInstanceFollowRedirects(r11.f11440u);
    L5:
        String r12 = r17.A();
        T r13 = r18.f11398e;
        if (r13 != 0) goto L8;
        int r14 = 0;
    L9:
        int r15 = i.m(r12, r14);
        if (r15 <= 0) goto L18;
        Reflect.on(r19).call("setOutputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r15)});     // Catch: Throwable -> L15
        if (r17.z() == null) goto L18;
        r17.z().f2460r0 = r15;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        if (r18.f11396c > 0) goto L161;
    L23:
        T r16 = r18.f11398e;
        if (r16 == 0) goto L64;
        long r110 = r16.f11422c;
        if (r110 <= 0) goto L28;
        r19.setConnectTimeout((int) r110);
    L28:
        long r111 = r16.f11423d;
        if (r111 <= 0) goto L32;
        r19.setReadTimeout((int) r111);
    L32:
        if (r16.f11428i > 0) goto L157;
    L43:
        int r21 = r16.f11433n;
        int r22 = r16.f11438s;
        if (r16.f11441v == true) goto L46;
    L47:
        r22 = r22 | 16;
    L49:
        if (r16.f11445z == false) goto L51;
        r22 = r22 | 128;
    L51:
        if (r22 <= 0) goto L57;
        Reflect.on(r19).call("setRequestFlag", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r22)});     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.printStackTrace();
    L57:
        if (r16.f11444y == false) goto L59;
        r21 = r21 | 2;
    L59:
        if (r21 <= 0) goto L64;
        Reflect.on(r19).call("setRequestTypeFlags", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r21)});     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        th.printStackTrace();
        goto L64
    L46:
        if ((r21 & 1) > 0) goto L49;
    L157:
        Reflect r23 = Reflect.on(r19);     // Catch: Throwable -> L41
        Class<?> r112 = Integer.TYPE;     // Catch: Throwable -> L41
        r23.call("setRequestTimeout", new Class[]{r112}, new Object[]{Integer.valueOf((int) r16.f11428i)});     // Catch: Throwable -> L41
        r19.setConnectTimeout(0);     // Catch: Throwable -> L41
        r19.setReadTimeout(0);     // Catch: Throwable -> L41
        if (r16.f11425f <= 0) goto L36;
    L39:
        Reflect.on(r19).call("setSocketConnectTimeout", new Class[]{r112}, new Object[]{Integer.valueOf((int) r16.f11425f)});     // Catch: Throwable -> L41
        Reflect.on(r19).call("setSocketReadTimeout", new Class[]{r112}, new Object[]{Integer.valueOf((int) r16.f11427h)});     // Catch: Throwable -> L41
        Reflect.on(r19).call("setSocketWriteTimeout", new Class[]{r112}, new Object[]{Integer.valueOf((int) r16.f11426g)});     // Catch: Throwable -> L41
        goto L43
    L36:
        if (r16.f11427h > 0) goto L39;
        if (r16.f11426g <= 0) goto L43;
    L41:
        th = move-exception;
        th.printStackTrace();
    L64:
        T r24 = r18.f11398e;
        if (r24 != 0) goto L67;
    L68:
        int r25 = z2.c.a(r19.getURL());
        r19.addRequestProperty("x-ttnet-bypass-to", Integer.toString(r25));
        if (r25 <= 0) goto L169;
        Reflect.on(r19).call("setRequestTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r25 * 1000)});     // Catch: Throwable -> L72
        r19.setConnectTimeout(0);     // Catch: Throwable -> L72
        r19.setReadTimeout(0);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        th.printStackTrace();
    L169:
        Reflect.on(r19).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r17.E())});     // Catch: Throwable -> L76
    L78:
        T r26 = r18.f11398e;
        if (r26 == 0) goto L83;
        long r27 = r26.f11439t;
        long r113 = 0;
        if (r27 > 0) goto L86;
    L84:
        r27 = this.f12594m;
    L86:
        if (r27 > r113) goto L151;
    L91:
        Iterator<n4.b> r28 = r17.v().iterator();
        String r29 = "";
    L93:
        if (r28.hasNext() == false) goto L109;
        n4.b r30 = r28.next();
        if (com.bytedance.common.utility.g.b(r30.a()) == true) goto L93;
        if (com.bytedance.common.utility.g.b(r30.b()) == true) goto L93;
        if (TTRequestCompressManager.h() == false) goto L105;
        if ("x-bd-content-encoding".equalsIgnoreCase(r30.a()) == true) goto L93;
    L105:
        if ("User-Agent".equalsIgnoreCase(r30.a()) == false) goto L107;
        r29 = r30.b();
    L107:
        r19.setRequestProperty(r30.a(), r30.b());
        goto L93
    L109:
        if (com.bytedance.common.utility.g.b(r29) == false) goto L159;
        r29 = o2.f.s();
        if (com.bytedance.common.utility.g.b(r29) == true) goto L159;
        r29 = r29 + " cronet/" + i.o();     // Catch: Exception -> L114
    L116:
        r19.setRequestProperty("User-Agent", r29);
    L114:
        e = move-exception;
        e.printStackTrace();
    L159:
        r18.B.put("ua", r29);     // Catch: Exception -> L119
    L121:
        r4.f r31 = r17.s();
        if (r31 == null) goto L136;
        r19.setDoOutput(true);
        r19.setRequestProperty(NetConst.KEY_CONTENT_TYPE, r31.a());
        String r32 = e0(r31);
        if (r32 == null) goto L126;
        r19.setRequestProperty("X-SS-STUB", r32);
    L126:
        String r33 = n0(r31, r17);
        if (TextUtils.isEmpty(r33) == true) goto L130;
        r19.setRequestProperty("x-bd-content-encoding", r33);
    L132:
        long r34 = r31.length();
        if (r34 == (-1)) goto L135;
        r19.setFixedLengthStreamingMode((int) r34);
        r19.setRequestProperty("Content-Length", String.valueOf(r34));
        goto L136
    L135:
        r19.setChunkedStreamingMode(4096);
        goto L136
    L130:
        if (TTRequestCompressManager.h() == false) goto L132;
        h0(r17);
    L136:
        if (r20 != null) goto L138;
    L147:
        r18.f11394a = r19.getURL();
        RetrofitMetrics r35 = r18.O;
        if (r35 == null) goto L188;
        r35.f2472x0 = SystemClock.uptimeMillis() - r10;
        r18.O.f2425a = r18.f11394a;
        return;
    L188:
        return;
    L138:
        if (r20.isEmpty() == true) goto L147;
        Iterator<Map.Entry<String, String>> r36 = r20.entrySet().iterator();
    L141:
        if (r36.hasNext() == false) goto L147;
        Map.Entry<String, String> r37 = r36.next();
        String r38 = r37.getKey();
        String r39 = r37.getValue();
        if (TextUtils.isEmpty(r38) == true) goto L141;
        if (TextUtils.isEmpty(r39) == true) goto L141;
        r19.setRequestProperty(r38, r39);
    L119:
        e = move-exception;
        e.printStackTrace();
        goto L121
    L151:
        Reflect.on(r19).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r27)});     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        th.printStackTrace();
        goto L91
    L83:
        r113 = 0;
    L76:
        th = move-exception;
        th.printStackTrace();
        goto L78
    L67:
        if (r24.f11428i > 0) goto L169;
    L161:
        Reflect.on(r19).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r18.f11396c)});     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L8:
        r14 = r13.f11437r;
        goto L9
    }

    abstract HttpURLConnection a0();

    protected HttpURLConnection b0(String r10, o2.b r11) {
        long r12 = SystemClock.uptimeMillis();
        HttpURLConnection r13 = i.E(r10, r11);
        RetrofitMetrics r14 = r11.O;
        if (r14 == null) goto L5;
        r14.f2468v0 = SystemClock.uptimeMillis() - r12;
    L5:
        return r13;
    }

    @Override // n4.e
    public boolean c(long r10) {
        this.f12594m = r10;
        return true;
    }

    protected int c0(HttpURLConnection r10) {
        r4.f r11 = this.f1630c.s();
        if (r11 == null) goto L6;
        r11.writeTo(r10.getOutputStream());
    L6:
        return r10.getResponseCode();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public InputStream d() {
        if (a0() != null) goto L7;
        return null;
    L7:
        return a0().getInputStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public int e() {
        return this.f12593l;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public String f(String r10) {
        if (a0() != null) goto L6;
        return null;
    L6:
        String r11 = a0().getHeaderField(r10);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return a0().getHeaderField(r10.toLowerCase());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public InputStream g() {
        if (a0() != null) goto L7;
        return null;
    L7:
        return a0().getErrorStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public String h() {
        return f(NetConst.KEY_CONTENT_TYPE);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public boolean i() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.i
    public void j(o2.b r11) {
        Map<String, Object> r10 = i.v(a0());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L16;
        r11.f11397d = (String) f0(r10.get(ICronetClient.KEY_REMOTE_IP), String.class, "");
        r11.f11407n = ((Long) f0(r10.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();
        r11.f11408o = ((Long) f0(r10.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();
        r11.f11409p = ((Long) f0(r10.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();
        r11.f11410q = ((Long) f0(r10.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();
        ((Long) f0(r10.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L)).longValue();
        r11.f11411r = ((Long) f0(r10.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();
        Object r12 = r10.get(ICronetClient.KEY_SOCKET_REUSED);
        Boolean r13 = Boolean.FALSE;
        r11.f11412s = ((Boolean) f0(r12, Boolean.class, r13)).booleanValue();
        r11.f11413t = ((Long) f0(r10.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();
        r11.f11414u = ((Long) f0(r10.get(ICronetClient.KEY_TOTAL_TIME), Long.class, -1L)).longValue();
        r11.f11415v = ((Long) f0(r10.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();
        r11.f11416w = ((Long) f0(r10.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();
        r11.A = (String) f0(r10.get(ICronetClient.KEY_REQUEST_LOG), String.class, "");
        ((Long) f0(r10.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L)).longValue();
        String r14 = (String) f0(r10.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");
        String r15 = (String) f0(r10.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");
        ((Long) f0(r10.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L)).longValue();
        ((Long) f0(r10.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L)).longValue();
        ((Long) f0(r10.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L)).longValue();
        ((Boolean) f0(r10.get(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE), Boolean.class, r13)).booleanValue();
        r11.Q = ((Boolean) f0(r10.get(ICronetClient.KEY_BYPASS_API_REPORT), Boolean.class, r13)).booleanValue();
        RetrofitMetrics r16 = r11.O;
        if (r16 == null) goto L11;
        r16.f2474y0 = ((Long) f0(r10.get(ICronetClient.KEY_UPPER_ADD_COOKIE_US), Long.class, -1L)).longValue();
        RetrofitMetrics r17 = r11.O;
        r17.f2476z0 = ((Long) f0(r10.get(ICronetClient.KEY_UPPER_SAVE_COOKIE_US), Long.class, -1L)).longValue();
        RetrofitMetrics r18 = r11.O;
        r18.A0 = ((Integer) f0(r10.get(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE), Integer.class, -1)).intValue();
    L11:
        if (TextUtils.isEmpty(r11.A) == false) goto L15;
        V(r11.B);
        return;
    L15:
        return;
    }

    void j0(HttpURLConnection r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public long k() {
        if (a0() != null) goto L7;
        return 0;
    L7:
        return a0().getContentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public String l() {
        if (a0() != null) goto L7;
        return "";
    L7:
        return a0().getResponseMessage();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public void n() {
        if (a0() == null) goto L6;
        a0().disconnect();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public Map<String, List<String>> o() {
        if (a0() != null) goto L7;
        return null;
    L7:
        return a0().getHeaderFields();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected boolean p() {
        if (this.f1632h == false) goto L5;
    L8:
        return true;
    L5:
        if (i.q() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void q(n4.c r10, Exception r11) {
        Y(i.q(), r11.getMessage(), this.f1630c.A());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void v() {
        this.f12593l = c0(a0());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected Context x() {
        return i.j();
    }
}
