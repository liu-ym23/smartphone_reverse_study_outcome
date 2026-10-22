package we;

import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f13327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final af.i f13328b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f13329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public o f13330n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final y f13331o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f13332p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13333q;

    public class a extends jf.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ x f13334k;

        public a(x r8) {
            this.f13334k = r8;
        }

        @Override // jf.c
        public final void o() {
            this.f13334k.b(NetError.ERR_TTNET_REQUEST_TIMED_OUT);
        }
    }

    public final class b extends xe.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f13335b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ x f13336m;

        public b(x r8, b6.b r10) {
            this.f13336m = r8;
            super("OkHttp %s", new Object[]{r8.f13331o.f13337a.m()});
            this.f13335b = r10;
        }

        @Override // xe.b
        public final void a() {
            e r8 = this.f13335b;
            x r10 = this.f13336m;
            a r11 = r10.f13329m;
            v r12 = r10.f13327a;
            r11.j();
            boolean r13 = false;
        L31:
            ((b6.b) r8).b(r10, r10.e());     // Catch: Throwable -> L7 IOException -> L9
        L24:
            r12.f13277a.b(this);
            return;
        L9:
            e = e;
            r13 = true;
        L20:
            IOException r14 = r10.g(e);     // Catch: Throwable -> L26
            if (r13 == false) goto L23;
            df.f.f7097a.l(4, r14, "Callback failure for " + r10.h());     // Catch: Throwable -> L26
            goto L24
        L23:
            r10.f13330n.callFailed(r10, r14);     // Catch: Throwable -> L26
            ((b6.b) r8).a(r14);     // Catch: Throwable -> L26
        L7:
            th = th;
            r13 = true;
        L15:
            r10.b(-1);     // Catch: Throwable -> L26
            if (r13 == true) goto L18;
            ((b6.b) r8).a(new IOException("canceled due to " + th));     // Catch: Throwable -> L26
        L18:
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            r12.f13277a.b(this);
            throw th;
        L19:
            e = e;
        L13:
            th = th;
            goto L15
        }

        public final void b(ThreadPoolExecutor r8) {
            x r10 = this.f13336m;
            r8.execute(this);     // Catch: Throwable -> L5 RejectedExecutionException -> L7
        L13:
            return;
        L5:
            th = move-exception;
            r10.f13327a.a().b(this);
            throw th;
        L7:
            e = move-exception;
            InterruptedIOException r11 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L5
            r11.initCause(e);     // Catch: Throwable -> L5
            x.a(r10).callFailed(r10, r11);     // Catch: Throwable -> L5
            ((b6.b) this.f13335b).a(r11);     // Catch: Throwable -> L5
            r10.f13327a.a().b(this);
            goto L13
        }
    }

    public x(v r8, y r10, boolean r11) {
        this.f13327a = r8;
        this.f13331o = r10;
        this.f13332p = r11;
        this.f13328b = new af.i(r8);
        a r12 = new a(this);
        this.f13329m = r12;
        r12.g(r8.F, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ o a(x r8) {
        return r8.f13330n;
    }

    public static x f(v r8, y r10, boolean r11) {
        x r12 = new x(r8, r10, r11);
        r12.f13330n = ((o.b) r8.f13283q).f13233a;
        return r12;
    }

    public final void b(int r8) {
        af.i r10 = this.f13328b;
        r10.f379e = r8;
        r10.f378d = true;
        ze.g r11 = r10.f376b;
        if (r11 == null) goto L15;
        i r12 = r11.f14403d;
        monitor-enter(r12);
        r11.f14412m = true;     // Catch: Throwable -> L12
        r11.f14413n = r8;     // Catch: Throwable -> L12
        af.c r13 = r11.f14414o;     // Catch: Throwable -> L12
        ze.d r14 = r11.f14409j;     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        if (r13 == null) goto L10;
        r13.cancel();
        return;
    L10:
        if (r14 == null) goto L19;
        xe.c.g(r14.f14375d);
        return;
    L19:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void c(b6.b r8) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f13333q == true) goto L17;
        this.f13333q = true;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        this.f13328b.f377c = df.f.f7097a.j();
        this.f13330n.callStart(this);
        m r10 = this.f13327a.f13277a;
        b r11 = new b(this, r8);
        monitor-enter(r10);
        r10.f13229d.add(r11);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        r10.c();
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L18
    }

    @Override // we.d
    public final void cancel() {
        b(-1);
    }

    public final Object clone() {
        boolean r8 = this.f13332p;
        return f(this.f13327a, this.f13331o, r8);
    }

    public final a0 d() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.f13333q == true) goto L29;
        this.f13333q = true;     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        this.f13328b.f377c = df.f.f7097a.j();
        this.f13329m.j();
        this.f13330n.callStart(this);
        m r8 = this.f13327a.f13277a;     // Catch: Throwable -> L21 IOException -> L23
        monitor-enter(r8);     // Catch: Throwable -> L21 IOException -> L23
        r8.f13231f.add(this);     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L21 IOException -> L23
        a0 r10 = e();     // Catch: Throwable -> L21 IOException -> L23
        if (r10 == null) goto L17;
        m r11 = this.f13327a.f13277a;
        r11.a(r11.f13231f, this);
        return r10;
    L17:
        throw new IOException("Canceled");     // Catch: Throwable -> L21 IOException -> L23
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21 IOException -> L23
    L21:
        th = move-exception;
        m r12 = this.f13327a.f13277a;
        r12.a(r12.f13231f, this);
        throw th;
    L23:
        e = move-exception;
        IOException r13 = g(e);     // Catch: Throwable -> L21
        this.f13330n.callFailed(this, r13);     // Catch: Throwable -> L21
        throw r13;     // Catch: Throwable -> L21
    L29:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L30
    }

    public final a0 e() {
        ArrayList r8 = new ArrayList();
        r8.addAll(this.f13327a.f13281o);
        r8.add(this.f13328b);
        r8.add(new af.a(this.f13327a.f13285s));
        this.f13327a.getClass();
        r8.add(new ye.a());
        r8.add(new ze.a(this.f13327a));
        if (this.f13332p == true) goto L5;
        r8.addAll(this.f13327a.f13282p);
    L5:
        r8.add(new af.b(this.f13332p));
        y r13 = this.f13331o;
        o r10 = this.f13330n;
        v r11 = this.f13327a;
        a0 r12 = new af.f(r8, null, null, null, 0, r13, this, r10, r11.G, r11.H, r11.I).e(r13);
        if (this.f13328b.f378d == true) goto L8;
        return r12;
    L8:
        xe.c.f(r12);
        throw new IOException("Canceled#Reason=" + this.f13328b.f378d);
    }

    @Nullable
    public final IOException g(@Nullable IOException r8) {
        if (this.f13329m.m() == true) goto L5;
        return r8;
    L5:
        InterruptedIOException r10 = new InterruptedIOException("timeout");
        if (r8 == null) goto L8;
        r10.initCause(r8);
    L8:
        return r10;
    }

    public final String h() {
        StringBuilder r8 = new StringBuilder();
        if (this.f13328b.f378d == false) goto L5;
        String r10 = "canceled ";
    L6:
        r8.append(r10);
        if (this.f13332p == false) goto L9;
        String r11 = "web socket";
    L10:
        r8.append(r11);
        r8.append(" to ");
        r8.append(this.f13331o.f13337a.m());
        return r8.toString();
    L9:
        r11 = "call";
        goto L10
    L5:
        r10 = "";
        goto L6
    }

    @Override // we.d
    public final y request() {
        return this.f13331o;
    }
}
