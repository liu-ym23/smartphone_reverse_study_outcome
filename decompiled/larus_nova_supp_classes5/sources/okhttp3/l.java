package okhttp3;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import hvc.g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.RealInterceptorChain;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l implements Call {
    public final OkHttpClient a;
    public final evc.i b;
    public final a c;

    @Nullable
    public i d;
    public final Request e;
    public final boolean f;
    public boolean g;

    public class a extends okio.c {
        public final /* synthetic */ l m;

        @Override // okio.c
        public final void m() {
            this.m.a(-192);
        }

        public a(l r1) {
            this.m = r1;
        }
    }

    @Override // okhttp3.Call
    public final void cancel() {
        a(-1);
    }

    @Override // okhttp3.Call
    public final synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r0 = this.g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final Response b() throws IOException {
        ArrayList r1 = new ArrayList();
        r1.addAll(this.a.interceptors());
        r1.add(this.b);
        r1.add(new evc.a(this.a.cookieJar()));
        r1.add(new dvc.b(this.a.internalCache()));
        r1.add(new okhttp3.internal.connection.a(this.a));
        if (this.f == true) goto L5;
        r1.addAll(this.a.networkInterceptors());
    L5:
        r1.add(new evc.b(this.f));
        Response r0 = new RealInterceptorChain(r1, null, null, null, 0, this.e, this, this.d, this.a.connectTimeoutMillis(), this.a.readTimeoutMillis(), this.a.writeTimeoutMillis()).proceed(this.e);
        if (this.b.d == true) goto L8;
        return r0;
    L8:
        cvc.c.e(r0);
        throw new IOException("Canceled#Reason=" + this.b.d);
    }

    public final Object clone() throws CloneNotSupportedException {
        return c(this.a, this.e, this.f);
    }

    public final String e() {
        StringBuilder r0 = new StringBuilder();
        if (this.b.d == false) goto L5;
        String r1 = "canceled ";
    L6:
        r0.append(r1);
        if (this.f == false) goto L9;
        String r2 = "web socket";
    L10:
        r0.append(r2);
        r0.append(" to ");
        r0.append(this.e.url().redact());
        return r0.toString();
    L9:
        r2 = "call";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    @Override // okhttp3.Call
    public final Response execute() throws IOException {
        Request r2 = this.e;     // Catch: Throwable -> L8 IOException -> L10
        String r3 = r2.url().host();     // Catch: Throwable -> L8 IOException -> L10
        String r4 = r2.url().encodedPath();     // Catch: Throwable -> L8 IOException -> L10
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L13;
        FLogger.a.i("OkHttp3CallLancet", "execute drop " + r3 + r4);     // Catch: Throwable -> L8 IOException -> L10
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L10
        throw new IOException("[NetGuard] dropped " + r2.url());     // Catch: Throwable -> L8 IOException -> L10
    L13:
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L15:
        if (this.g == true) goto L33;
        this.g = true;     // Catch: Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L34
        this.b.c = g.a.k();
        this.c.j();
        this.d.callStart(this);
        this.a.dispatcher().executed(this);     // Catch: Throwable -> L25 IOException -> L27
        Response r0 = b();     // Catch: Throwable -> L25 IOException -> L27
        if (r0 == null) goto L24;
        this.a.dispatcher().finished(this);
        return r0;
    L24:
        throw new IOException("Canceled");     // Catch: Throwable -> L25 IOException -> L27
    L25:
        th = move-exception;
        this.a.dispatcher().finished(this);
        throw th;
    L27:
        e = move-exception;
        IOException r1 = d(e);     // Catch: Throwable -> L25
        this.d.callFailed(this, r1);     // Catch: Throwable -> L25
        throw r1;     // Catch: Throwable -> L25
    L33:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L34
    L10:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("OkHttp3CallLancet", "execute intercept failed, fallback to origin: " + th.getMessage());
        goto L13
    }

    @Override // okhttp3.Call
    public final boolean isCanceled() {
        return this.b.d;
    }

    @Override // okhttp3.Call
    public final Request request() {
        return this.e;
    }

    @Override // okhttp3.Call
    public final j0 timeout() {
        return this.c;
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Call mo536clone() {
        return c(this.a, this.e, this.f);
    }

    public final void a(int r3) {
        evc.i r0 = this.b;
        r0.e = r3;
        r0.d = true;
        StreamAllocation r1 = r0.b;
        if (r1 == null) goto L6;
        r1.cancel(r3);
        return;
    }

    @Nullable
    public final IOException d(@Nullable IOException r3) {
        if (this.c.k() == true) goto L5;
        return r3;
    L5:
        InterruptedIOException r0 = new InterruptedIOException("timeout");
        if (r3 == null) goto L8;
        r0.initCause(r3);
    L8:
        return r0;
    }

    @Override // okhttp3.Call
    public final void enqueue(Callback r8) {
        Request r0 = this.e;
        String r1 = r0.url().host();
        String r2 = r0.url().encodedPath();
        if (com.obric.assistant.network.okhttp.a.c(r1, r2) == false) goto L7;
        FLogger.a.i("OkHttp3CallLancet", "enqueue drop " + r1 + r2);
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r1, r2), r1, r2);
        if (r8 == null) goto L20;
        r8.onFailure(this, new IOException("[NetGuard] dropped " + r0.url()));
        return;
    L20:
        return;
    L7:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.g == true) goto L15;
        this.g = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.b.c = g.a.k();
        this.d.callStart(this);
        this.a.dispatcher().enqueue(new b(this, r8));
        return;
    L15:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L16
    }

    public l(OkHttpClient r3, Request r4, boolean r5) {
        this.a = r3;
        this.e = r4;
        this.f = r5;
        this.b = new evc.i(r3);
        a r6 = new a(this);
        this.c = r6;
        r6.h(r3.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public static l c(OkHttpClient r1, Request r2, boolean r3) {
        l r0 = new l(r1, r2, r3);
        r0.d = r1.eventListenerFactory().create(r0);
        return r0;
    }
}
