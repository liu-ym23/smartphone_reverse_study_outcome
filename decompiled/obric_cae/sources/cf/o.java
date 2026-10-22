package cf;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.annotation.Nullable;
import jf.v;
import jf.w;
import jf.x;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f3568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque f3569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f3571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f3572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f3573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f3574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public cf.b f3575k;

    public final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jf.d f3576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3577b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f3578m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ o f3579n;

        public a(o r8) {
            this.f3579n = r8;
            this.f3576a = new jf.d();
        }

        public final void a(boolean r12) {
            o r8 = this.f3579n;
            monitor-enter(r8);
            this.f3579n.f3574j.j();     // Catch: Throwable -> L33
        L36:
            o r10 = this.f3579n;     // Catch: Throwable -> L30
            if (r10.f3566b > 0) goto L15;
            if (this.f3578m == true) goto L15;
            if (this.f3577b == true) goto L15;
            if (r10.f3575k != null) goto L15;
            r10.n();     // Catch: Throwable -> L30
        L15:
            r10.f3574j.p();     // Catch: Throwable -> L33
            this.f3579n.e();     // Catch: Throwable -> L33
            long r11 = Math.min(this.f3579n.f3566b, this.f3576a.f8830b);     // Catch: Throwable -> L33
            o r13 = this.f3579n;     // Catch: Throwable -> L33
            r13.f3566b -= r11;     // Catch: Throwable -> L33
            monitor-exit(r8);     // Catch: Throwable -> L33
            r13.f3574j.j();
            o r14 = this.f3579n;     // Catch: Throwable -> L27
            g r15 = r14.f3568d;     // Catch: Throwable -> L27
            int r16 = r14.f3567c;     // Catch: Throwable -> L27
            if (r12 == true) goto L21;
        L23:
            boolean r17 = false;
        L24:
            r15.J(r16, r17, this.f3576a, r11);     // Catch: Throwable -> L27
            this.f3579n.f3574j.p();
            return;
        L21:
            if (r11 != this.f3576a.f8830b) goto L23;
            r17 = true;
        L27:
            th = move-exception;
            this.f3579n.f3574j.p();
            throw th;
        L30:
            th = move-exception;
            this.f3579n.f3574j.p();     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        }

        @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            o r8 = this.f3579n;
            monitor-enter(r8);
        L26:
            th = move-exception;
            throw th;
        L5:
            if (this.f3577b == false) goto L8;
            monitor-exit(r8);     // Catch: Throwable -> L26
            return;
        L8:
            monitor-exit(r8);     // Catch: Throwable -> L26
            o r10 = this.f3579n;
            if (r10.f3572h.f3578m == false) goto L12;
        L17:
            o r11 = this.f3579n;
            monitor-enter(r11);
            this.f3577b = true;     // Catch: Throwable -> L23
            monitor-exit(r11);     // Catch: Throwable -> L23
            this.f3579n.f3568d.flush();
            this.f3579n.d();
            return;
        L23:
            th = move-exception;
            throw th;
        L12:
            if (this.f3576a.f8830b > 0) goto L14;
            r10.f3568d.J(r10.f3567c, true, null, 0);
        L14:
            if (this.f3576a.f8830b <= 0) goto L17;
            a(true);
            goto L14
        }

        @Override // jf.v, java.io.Flushable
        public final void flush() {
            o r8 = this.f3579n;
            monitor-enter(r8);
            this.f3579n.e();     // Catch: Throwable -> L10
            monitor-exit(r8);     // Catch: Throwable -> L10
        L7:
            if (this.f3576a.f8830b <= 0) goto L9;
            a(false);
            this.f3579n.f3568d.flush();
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // jf.v
        public final x timeout() {
            return this.f3579n.f3574j;
        }

        @Override // jf.v
        public final void write(jf.d r8, long r10) {
            jf.d r11 = this.f3576a;
            r11.write(r8, r10);
        L4:
            if (r11.f8830b < 16384) goto L6;
            a(false);
            goto L4
        }
    }

    public final class b implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jf.d f3580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jf.d f3581b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f3582m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f3583n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f3584o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ o f3585p;

        public b(o r8, long r10) {
            this.f3585p = r8;
            this.f3580a = new jf.d();
            this.f3581b = new jf.d();
            this.f3582m = r10;
        }

        public final void a(jf.f r10, long r11) {
        L3:
            if (r11 <= 0) goto L44;
            o r8 = this.f3585p;
            monitor-enter(r8);
            boolean r12 = this.f3584o;     // Catch: Throwable -> L41
            boolean r13 = true;
            if ((this.f3581b.size() + r11) <= this.f3582m) goto L9;
            boolean r14 = true;
        L10:
            monitor-exit(r8);     // Catch: Throwable -> L41
            if (r14 == true) goto L12;
            if (r12 == true) goto L15;
            long r15 = r10.u(this.f3580a, r11);
            if (r15 == (-1)) goto L40;
            r11 = r11 - r15;
            o r16 = this.f3585p;
            monitor-enter(r16);
            if (this.f3583n == false) goto L25;
            long r17 = this.f3580a.size();     // Catch: Throwable -> L36
            this.f3580a.a();     // Catch: Throwable -> L36
        L32:
            monitor-exit(r16);     // Catch: Throwable -> L36
            if (r17 <= 0) goto L3;
            this.f3585p.f3568d.I(r17);
            goto L3
        L25:
            if (this.f3581b.size() == 0) goto L28;
            r13 = false;
        L28:
            this.f3581b.X(this.f3580a);     // Catch: Throwable -> L36
            if (r13 == false) goto L31;
            this.f3585p.notifyAll();     // Catch: Throwable -> L36
        L31:
            r17 = 0;
        L36:
            th = move-exception;
            throw th;
        L40:
            throw new EOFException();
        L15:
            r10.skip(r11);
            return;
        L12:
            r10.skip(r11);
            this.f3585p.h(cf.b.f3453o);
            return;
        L9:
            r14 = false;
        L41:
            th = move-exception;
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            o r8 = this.f3585p;
            monitor-enter(r8);
            this.f3583n = true;     // Catch: Throwable -> L15
            long r10 = this.f3581b.size();     // Catch: Throwable -> L15
            this.f3581b.a();     // Catch: Throwable -> L15
            if (o.a(this.f3585p).isEmpty() == true) goto L8;
            o.b(this.f3585p);     // Catch: Throwable -> L15
        L8:
            this.f3585p.notifyAll();     // Catch: Throwable -> L15
            monitor-exit(r8);     // Catch: Throwable -> L15
            if (r10 <= 0) goto L13;
            this.f3585p.f3568d.I(r10);
        L13:
            this.f3585p.d();
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // jf.w
        public final x timeout() {
            return this.f3585p.f3573i;
        }

        @Override // jf.w
        public final long u(jf.d r12, long r13) {
            if (r13 < 0) goto L50;
        L4:
            o r8 = this.f3585p;
            monitor-enter(r8);
            this.f3585p.f3573i.j();     // Catch: Throwable -> L46
            o r10 = this.f3585p;     // Catch: Throwable -> L43
            cf.b r11 = r10.f3575k;     // Catch: Throwable -> L43
            if (r11 != null) goto L12;
            r11 = null;
        L12:
            if (this.f3583n == true) goto L42;
            if (o.a(r10).isEmpty() == true) goto L17;
            o.b(this.f3585p);     // Catch: Throwable -> L43
        L17:
            if (this.f3581b.size() > 0) goto L18;
            if (this.f3584o == true) goto L30;
            if (r11 != null) goto L30;
            this.f3585p.n();     // Catch: Throwable -> L43
            this.f3585p.f3573i.p();     // Catch: Throwable -> L46
            monitor-exit(r8);     // Catch: Throwable -> L46
        L30:
            long r14 = -1;
        L31:
            this.f3585p.f3573i.p();     // Catch: Throwable -> L46
            monitor-exit(r8);     // Catch: Throwable -> L46
            if (r14 == (-1)) goto L37;
            this.f3585p.f3568d.I(r14);
            return r14;
        L37:
            if (r11 != null) goto L40;
            return -1;
        L40:
            throw new s(r11);
        L18:
            jf.d r15 = this.f3581b;     // Catch: Throwable -> L43
            r14 = r15.u(r12, Math.min(r13, r15.size()));     // Catch: Throwable -> L43
            o r16 = this.f3585p;     // Catch: Throwable -> L43
            long r17 = r16.f3565a + r14;     // Catch: Throwable -> L43
            r16.f3565a = r17;     // Catch: Throwable -> L43
            if (r11 != null) goto L31;
            if (r17 < (r16.f3568d.C.b() / 2)) goto L31;
            o r18 = this.f3585p;     // Catch: Throwable -> L43
            r18.f3568d.V(r18.f3567c, r18.f3565a);     // Catch: Throwable -> L43
            this.f3585p.f3565a = 0;     // Catch: Throwable -> L43
            goto L31
        L42:
            throw new IOException("stream closed");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            this.f3585p.f3573i.p();     // Catch: Throwable -> L46
            throw th;     // Catch: Throwable -> L46
        L46:
            th = move-exception;
            throw th;
        L50:
            throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r13));
        }
    }

    public class c extends jf.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ o f3586k;

        public c(o r8) {
            this.f3586k = r8;
        }

        @Override // jf.c
        public final IOException n(IOException r8) {
            SocketTimeoutException r10 = new SocketTimeoutException("timeout");
            if (r8 == null) goto L5;
            r10.initCause(r8);
        L5:
            return r10;
        }

        @Override // jf.c
        public final void o() {
            cf.b r8 = cf.b.f3455q;
            o r10 = this.f3586k;
            r10.h(r8);
            r10.f3568d.G();
        }

        public final void p() {
            if (m() == true) goto L6;
            return;
        L6:
            throw n(null);
        }
    }

    public o(int r8, g r10, boolean r11, boolean r12, @Nullable we.q r13) {
        this.f3565a = 0;
        ArrayDeque r14 = new ArrayDeque();
        this.f3569e = r14;
        this.f3573i = new c(this);
        this.f3574j = new c(this);
        this.f3575k = null;
        if (r10 == null) goto L21;
        this.f3567c = r8;
        this.f3568d = r10;
        this.f3566b = r10.D.b();
        b r15 = new b(this, r10.C.b());
        this.f3571g = r15;
        a r16 = new a(this);
        this.f3572h = r16;
        r15.f3584o = r12;
        r16.f3578m = r11;
        if (r13 == null) goto L8;
        r14.add(r13);
    L8:
        if (i() == false) goto L14;
        if (r13 == null) goto L14;
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    L14:
        if (i() == true) goto L19;
        if (r13 == null) goto L18;
        return;
    L18:
        throw new IllegalStateException("remotely-initiated streams should have headers");
    L19:
        return;
    L21:
        throw new NullPointerException("connection == null");
    }

    public static /* synthetic */ ArrayDeque a(o r8) {
        return r8.f3569e;
    }

    public static /* synthetic */ void b(o r8) {
        r8.getClass();
    }

    public final void c(long r8) {
        this.f3566b += r8;
        if (r8 <= 0) goto L6;
        notifyAll();
        return;
    }

    public final void d() {
        monitor-enter(this);
        b r8 = this.f3571g;     // Catch: Throwable -> L20
        if (r8.f3584o == false) goto L6;
    L12:
        boolean r10 = false;
    L13:
        boolean r11 = j();     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r10 == false) goto L17;
        f(cf.b.f3455q);
        return;
    L17:
        if (r11 == true) goto L26;
        this.f3568d.E(this.f3567c);
        return;
    L26:
        return;
    L6:
        if (r8.f3583n == false) goto L12;
        a r12 = this.f3572h;     // Catch: Throwable -> L20
        if (r12.f3578m == false) goto L10;
    L11:
        r10 = true;
        goto L13
    L10:
        if (r12.f3577b == false) goto L12;
    L20:
        th = move-exception;
        throw th;
    }

    public final void e() {
        a r8 = this.f3572h;
        if (r8.f3577b == true) goto L14;
        if (r8.f3578m == true) goto L12;
        if (this.f3575k != null) goto L10;
        return;
    L10:
        throw new s(this.f3575k);
    L12:
        throw new IOException("stream finished");
    L14:
        throw new IOException("stream closed");
    }

    public final void f(cf.b r8) {
        if (g(r8) == true) goto L5;
        return;
    L5:
        this.f3568d.F.w(this.f3567c, r8);
    }

    public final boolean g(cf.b r8) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f3575k == null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L17
        return false;
    L8:
        if (this.f3571g.f3584o == true) goto L10;
    L13:
        this.f3575k = r8;     // Catch: Throwable -> L17
        notifyAll();     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        this.f3568d.E(this.f3567c);
        return true;
    L10:
        if (this.f3572h.f3578m == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L17
        return false;
    }

    public final void h(cf.b r8) {
        if (g(r8) == true) goto L5;
        return;
    L5:
        this.f3568d.K(this.f3567c, r8);
    }

    public final boolean i() {
        if ((this.f3567c & 1) != 1) goto L5;
        boolean r8 = true;
    L7:
        if (this.f3568d.f3499a != r8) goto L10;
        return true;
    L10:
        return false;
    L5:
        r8 = false;
        goto L7
    }

    public final synchronized boolean j() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.f3575k == null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        b r8 = this.f3571g;     // Catch: Throwable -> L23
        if (r8.f3584o == false) goto L11;
    L12:
        a r10 = this.f3572h;     // Catch: Throwable -> L23
        if (r10.f3578m == false) goto L15;
    L16:
        if (this.f3570f == false) goto L20;
        monitor-exit(this);
        return false;
    L20:
        monitor-exit(this);
        return true;
    L15:
        if (r10.f3577b == false) goto L20;
    L11:
        if (r8.f3583n == false) goto L20;
        goto L12
    }

    public final void k() {
        monitor-enter(this);
        this.f3571g.f3584o = true;     // Catch: Throwable -> L8
        boolean r8 = j();     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r8 == true) goto L13;
        this.f3568d.E(this.f3567c);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void l(ArrayList r8) {
        monitor-enter(this);
        this.f3570f = true;     // Catch: Throwable -> L9
        this.f3569e.add(xe.c.x(r8));     // Catch: Throwable -> L9
        boolean r10 = j();     // Catch: Throwable -> L9
        notifyAll();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r10 == true) goto L14;
        this.f3568d.E(this.f3567c);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized we.q m() {
        monitor-enter(this);
        this.f3573i.j();     // Catch: Throwable -> L20
    L23:
    L17:
        th = move-exception;
        this.f3573i.p();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L5:
        if (this.f3569e.isEmpty() == false) goto L10;
        if (this.f3575k != null) goto L10;
        n();     // Catch: Throwable -> L17
    L10:
        this.f3573i.p();     // Catch: Throwable -> L20
        if (this.f3569e.isEmpty() == true) goto L16;
        we.q r8 = (we.q) this.f3569e.removeFirst();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r8;
    L16:
        throw new s(this.f3575k);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final void n() {
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }
}
