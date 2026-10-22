package a7;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class e implements SsCall, IMetricsCollect, IRequestInfo {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f82t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static ICronetClient f83u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpURLConnection f84a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w6.a f85b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f86m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f87n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Request f88o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f89p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RetrofitMetrics f90q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f91r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f92s;

    public e(Request r14, ICronetClient r15) {
        w6.a r8 = w6.a.E.a();
        this.f85b = r8;
        this.f87n = null;
        this.f89p = false;
        this.f91r = 0;
        this.f88o = r14;
        f83u = r15;
        String r10 = r14.getUrl();
        this.f84a = null;
        RetrofitMetrics r16 = r14.getMetrics();
        this.f90q = r16;
        if (r16 == null) goto L5;
        r8.f12992c = r16.appLevelRequestStart;
        r8.f12993d = r16.beforeAllInterceptors;
    L5:
        long r11 = System.currentTimeMillis();
        this.f86m = r11;
        r8.f12994e = r11;
        r8.f13009t = 0;
        if (r14.isResponseStreaming() == false) goto L8;
        r8.f13014y = true;
    L10:
        if ((r14.getExtraInfo() instanceof w6.b) == false) goto L21;
        T r17 = (T) r14.getExtraInfo();
        r8.f12991b = r17;
        r17.getClass();
    L21:
        this.f84a = i.c(r10, r14, r8, this.f91r);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        i.p(r10, this.f86m, this.f85b, this.f87n, e, this.f84a, this.f90q);
        this.f89p = true;
        if ((e instanceof IOException) == false) goto L20;
        throw ((IOException) e);
    L20:
        throw new IOException(e.getMessage(), e.getCause());
    L8:
        r8.f13014y = false;
        goto L10
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final void cancel() {
        HttpURLConnection r8 = this.f84a;
        if (r8 == null) goto L30;
        r8.disconnect();
        Request r10 = this.f88o;
        if (r10.isResponseStreaming() == true) goto L7;
    L26:
        this.f89p = true;
        return;
    L7:
        if (this.f89p == true) goto L26;
        doCollect();
        String r11 = i.h(this.f92s);
        w6.a r12 = this.f85b;
        r12.D = r11;
        long r13 = System.currentTimeMillis();
        r12.f12997h = r13;
        T r14 = r12.f12991b;
        if (r14 != 0) goto L11;
    L12:
        long r15 = this.f86m;
        w6.e.d(r13 - r15, r15, r10.getUrl(), this.f87n, this.f85b);
    L14:
        if (j.f117a == null) goto L16;
    L25:
        j r16 = j.f117a;
        String r17 = r10.getUrl();
        long r18 = r12.f13007r;
        long r19 = r12.f13008s;
        r16.a(r17, r12.D, r12.f13012w, r18, r19);
        goto L26
    L16:
        monitor-enter(j.class);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (j.f117a != null) goto L20;
        j.f117a = new j();     // Catch: Throwable -> L22
    L20:
        monitor-exit(j.class);     // Catch: Throwable -> L22
        goto L25
    L11:
        if (r14.f13017b == false) goto L14;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public final void doCollect() {
        i.k(this.f84a, this.f85b, this.f90q);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final Response execute() {
        w6.a r8 = this.f85b;
        RetrofitMetrics r10 = this.f90q;
        if (r10 == null) goto L5;
        r10.callExecuteStartTime = System.currentTimeMillis();
    L5:
        Request r11 = this.f88o;
        String r13 = r11.getUrl();
        if (this.f89p == true) goto L115;
        d r12 = null;
        i.b(null);
        boolean r15 = false;
    L82:
        e = e;
    L118:
    L100:
        th = th;
        boolean r17 = r15;
        r15 = true;
    L103:
        if (r11.isResponseStreaming() == false) goto L105;
        if (r15 == true) goto L105;
    L110:
        if (r11.isResponseStreaming() == true) goto L113;
        if (r17 == false) goto L113;
        u6.c.a.f12494a.c();
    L113:
        throw th;
    L105:
        HttpURLConnection r14 = this.f84a;
        if (r14 == null) goto L110;
        r14.disconnect();
        goto L110
    L84:
        if ((e instanceof b7.b) == false) goto L90;
        b7.b r16 = (b7.b) e;     // Catch: Throwable -> L100
        if (r16.f3131a != 304) goto L90;
        throw r16;     // Catch: Throwable -> L100
    L90:
        if ((e instanceof IOException) == false) goto L96;
        if ("request canceled".equals(e.getMessage()) == false) goto L96;
        throw e;     // Catch: Throwable -> L100
    L96:
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(e.getClass().getName()) == false) goto L98;
        doCollect();     // Catch: Throwable -> L100
    L98:
        i.p(r13, this.f86m, this.f85b, this.f87n, e, this.f84a, this.f90q);     // Catch: Throwable -> L100
        i.b(e.getMessage());     // Catch: Throwable -> L100
        throw new c(e);     // Catch: Throwable -> L100
    L16:
        th = th;
        r17 = false;
        goto L103
    L9:
        if (r11.isResponseStreaming() == true) goto L18;
        w6.e.d r18 = w6.e.f13020a;     // Catch: Throwable -> L16 Exception -> L82
        if (r18 == null) goto L18;
        if (((x8.c) r18).p(r13) == false) goto L18;
        u6.c.a.f12494a.b();     // Catch: Throwable -> L16 Exception -> L82
        r17 = true;
    L121:
        HttpURLConnection r19 = this.f84a;     // Catch: Throwable -> L25 Exception -> L27
        if (r19 != null) goto L22;
        int r110 = -1;
    L30:
        i.t(this.f84a, r8, r110);     // Catch: Throwable -> L25 Exception -> L27
        if (r8.f13015z == false) goto L33;
        f82t = true;     // Catch: Throwable -> L25 Exception -> L27
    L33:
        r8.f12995f = System.currentTimeMillis();     // Catch: Throwable -> L25 Exception -> L27
        r8.f12998i = -1;     // Catch: Throwable -> L25 Exception -> L27
        this.f87n = i.o(this.f84a, r8);     // Catch: Throwable -> L25 Exception -> L27
        this.f92s = i.i("Content-Type", this.f84a);     // Catch: Throwable -> L25 Exception -> L27
        if (r11.isResponseStreaming() == false) goto L66;
        boolean r20 = "gzip".equalsIgnoreCase(i.i("Content-Encoding", this.f84a));     // Catch: Throwable -> L25 Exception -> L27
        ICronetClient r21 = f83u;     // Catch: Throwable -> L25 Exception -> L27
        if (r21 == null) goto L41;
        if (r21.isCronetHttpURLConnection(this.f84a) == false) goto L41;
        r20 = false;
    L41:
        if (r110 >= 200) goto L43;
    L52:
        String r111 = this.f84a.getResponseMessage();     // Catch: Throwable -> L25 Exception -> L27
        int r22 = r11.getMaxLength();     // Catch: Throwable -> L59
        InputStream r23 = this.f84a.getInputStream();     // Catch: Exception -> L56 Throwable -> L59
    L55:
        InputStream r24 = r23;
        this.f84a.getHeaderFields();     // Catch: Throwable -> L59
        i.q(r20, r22, r24, this.f92s, r13, this.f90q);     // Catch: Throwable -> L59
    L64:
        this.f84a.disconnect();     // Catch: Throwable -> L25 Exception -> L27
        throw new b7.b(r110, r111);     // Catch: Throwable -> L25 Exception -> L27
    L56:
        r23 = this.f84a.getErrorStream();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25 Exception -> L27
        StringBuilder r25 = new StringBuilder("reason = ");     // Catch: Throwable -> L25 Exception -> L27
        if (r111 != null) goto L63;
        r111 = "";
    L63:
        r25.append(r111);     // Catch: Throwable -> L25 Exception -> L27
        r25.append("  exception = ");     // Catch: Throwable -> L25 Exception -> L27
        r25.append(th.getMessage());     // Catch: Throwable -> L25 Exception -> L27
        r111 = r25.toString();     // Catch: Throwable -> L25 Exception -> L27
        goto L64
    L43:
        if (r110 >= 300) goto L52;
        HttpURLConnection r26 = this.f84a;     // Catch: Throwable -> L25 Exception -> L27
        if (r26 != null) goto L48;
    L51:
        TypedInput r27 = r12;
    L67:
        Response r28 = new Response(r13, r110, this.f84a.getResponseMessage(), i.e(this.f84a, f82t), r27);     // Catch: Throwable -> L25 Exception -> L27
        r28.setExtraInfo(r8);     // Catch: Throwable -> L25 Exception -> L27
        if (r11.isResponseStreaming() == true) goto L76;
        HttpURLConnection r29 = this.f84a;
        if (r29 == null) goto L76;
        r29.disconnect();
    L76:
        if (r11.isResponseStreaming() == true) goto L79;
        if (r17 == false) goto L79;
        u6.c.a.f12494a.c();
    L79:
        return r28;
    L48:
        if (r26.getContentLength() != 0) goto L50;
        cancel();     // Catch: Throwable -> L25 Exception -> L27
        goto L51
    L50:
        r12 = new d(this, r26, r20);     // Catch: Throwable -> L25 Exception -> L27
        goto L51
    L66:
        int r30 = r11.getMaxLength();     // Catch: Throwable -> L25 Exception -> L27
        r8.D = i.h(this.f92s);     // Catch: Throwable -> L25 Exception -> L27
        r27 = new TypedByteArray(this.f92s, i.r(r13, r30, this.f84a, this.f86m, this.f85b, this.f87n, r110, this.f90q), new String[0]);     // Catch: Throwable -> L25 Exception -> L27
        goto L67
    L22:
        TypedOutput r31 = r11.getBody();     // Catch: Throwable -> L25 Exception -> L27
        if (r31 == null) goto L29;
        r31.writeTo(r19.getOutputStream());     // Catch: Throwable -> L25 Exception -> L27
    L29:
        w6.e.d r32 = w6.e.f13020a;     // Catch: Throwable -> L25 Exception -> L27
        r110 = r19.getResponseCode();     // Catch: Throwable -> L25 Exception -> L27
    L27:
        e = e;
        r15 = r17;
    L25:
        th = th;
        goto L103
    L18:
        r17 = false;
        goto L121
    L115:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final Request getRequest() {
        return this.f88o;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public final Object getRequestInfo() {
        return this.f85b;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final boolean setThrottleNetSpeed(long r8) {
        this.f91r = r8;
        HttpURLConnection r10 = this.f84a;
        if (r10 != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(r10).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r8)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
