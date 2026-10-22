package com.ss.android.lark.monitor;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import javax.net.ssl.SSLException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class OkHttpMonitorInterceptor implements Interceptor {
    private static final String TAG = "OkHttpInterceptor";

    public class a implements b {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public a(String r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface b {
    }

    public class c extends ResponseBody {
        public final ResponseBody a;
        public BufferedSource b;
        public long c;
        public final b d;

        public final long contentLength() {
            return this.a.contentLength();
        }

        public final MediaType contentType() {
            return this.a.contentType();
        }

        public final BufferedSource source() {
            if (this.b != null) goto L6;
            this.b = Okio.buffer(new x(this, this.a.source()));
        L6:
            return this.b;
        }

        public c(Response r3, a r4) {
            this.c = 0;
            this.a = r3.body();
            this.d = r4;
        }
    }

    public OkHttpMonitorInterceptor() {
    }

    private long requestBytes(Request r7) {
        if (r7 != null) goto L5;
    L21:
        return 0;
    L5:
        if (r7.url() == null) goto L21;
        long r2 = r7.url().toString().getBytes().length;
        if (r2 > 0) goto L10;
        return r2;
    L10:
        RequestBody r8 = r7.body();
        if (r8 != null) goto L22;
        return r2;
    L22:
        long r4 = r8.contentLength();     // Catch: IOException -> L15
    L17:
        if (r4 > 0) goto L20;
        return r2;
    L20:
        return r4;
    L15:
        r4 = 0;
        goto L17
    }

    private long responseBytes(Response r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        if (r3.isSuccessful() == true) goto L6;
        return 0;
    L6:
        if (r3.body() != null) goto L9;
        return 0;
    L9:
        return r3.body().contentLength();
    }

    public Response intercept(Interceptor.Chain r15) throws IOException {
        String r0 = InvRouter.UNKNOWN;
        Request r1 = r15.request();
        long r6 = requestBytes(r1);
        Response r16 = r15.proceed(r1);     // Catch: RuntimeException -> L18
        long r4 = responseBytes(r16);
        if (r1.url() == null) goto L7;
        r0 = r1.url().host();
    L7:
        String r3 = r0;
        if (r4 > 0) goto L14;
        if (r16 == null) goto L14;
        if (r16.body() == null) goto L14;
        return r16.newBuilder().body(new c(r16, new a(r3, r6))).build();
    L14:
        com.ss.android.lark.monitor.traffic.j r2 = LarkMetrics.a.a.f;
        if (r2 == null) goto L17;
        r2.b(r3, r4, r6);
    L17:
        return r16;
    L18:
        e = move-exception;
        boolean r5 = false;
        boolean r7 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.monitor.disable_conscrypt_ssl_new_crash_fix");     // Catch: Throwable -> L22
    L25:
        if (r7 == true) goto L57;
        Throwable r8 = e.getCause();
        if ((r8 instanceof SSLException) == false) goto L57;
        String r9 = r8.getMessage();
        if (r9 == null) goto L57;
        if (r9.contains("Unable to create application data") == false) goto L57;
        StackTraceElement[] r10 = e.getStackTrace();
        int r11 = r10.length;
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
        boolean r17 = false;
    L36:
        if (r12 >= r11) goto L53;
        StackTraceElement r18 = r10[r12];
        if ("com.android.org.conscrypt.ConscryptEngine".equals(r18.getClassName()) == false) goto L43;
        if ("newSsl".equals(r18.getMethodName()) == false) goto L43;
        r13 = true;
    L52:
        r12 = r12 + 1;
    L43:
        if ("com.android.org.conscrypt.OpenSSLSocketFactoryImpl".equals(r18.getClassName()) == false) goto L48;
        if ("createSocket".equals(r18.getMethodName()) == false) goto L48;
        r14 = true;
    L48:
        if ("okhttp3.internal.connection.RealConnection".equals(r18.getClassName()) == false) goto L52;
        if ("connectTls".equals(r18.getMethodName()) == false) goto L52;
        r17 = true;
        goto L52
    L53:
        if (r13 == false) goto L57;
        if (r14 == false) goto L57;
        if (r17 == false) goto L57;
        r5 = true;
    L57:
        if (r5 == false) goto L68;
        if (r1 != null) goto L60;
    L62:
        String r19 = InvRouter.UNKNOWN;
    L63:
        Log.e("ConscryptSslNewCrashFix", "custom_error=lark_conscrypt_ssl_new_runtime_exception, convertedToIOException=true, host=" + r0 + ", path=" + r19 + ", fgDisable=lark.android.monitor.disable_conscrypt_ssl_new_crash_fix", e, true);
        Throwable r20 = e.getCause();
        if ((r20 instanceof IOException) == true) goto L79;
        IOException r21 = new IOException("Converted Conscrypt SSL_new RuntimeException: " + e.getMessage());
        r21.initCause(e);
        throw r21;
    L79:
        throw ((IOException) r20);
    L60:
        if (r1.url() == null) goto L62;
        r0 = r1.url().host();
        r19 = r1.url().encodedPath();
        goto L63
    L68:
        throw e;
    L22:
        th = move-exception;
        Log.e("ConscryptSslNewCrashFix", "check lark.android.monitor.disable_conscrypt_ssl_new_crash_fix failed", th);
        r7 = false;
        goto L25
    }
}
