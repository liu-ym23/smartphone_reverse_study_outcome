package cf;

import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import we.a0;
import we.v;
import we.w;
import we.y;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements af.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f3489f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f3490g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final we.s.a f3491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.g f3492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f3493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f3494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f3495e;

    public class a extends jf.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3496b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f3497m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ f f3498n;

        public a(f r8, o.b r10) {
            this.f3498n = r8;
            super(r10);
            this.f3496b = false;
            this.f3497m = 0;
        }

        @Override // jf.i, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            super.close();
            if (this.f3496b == true) goto L7;
            this.f3496b = true;
            f r8 = this.f3498n;
            r8.f3492b.i(false, r8, this.f3497m, null);
            return;
        }

        @Override // jf.w
        public final long u(jf.d r8, long r10) {
            long r11 = this.f8845a.u(r8, r10);     // Catch: IOException -> L6
            if (r11 <= 0) goto L5;
            this.f3497m += r11;     // Catch: IOException -> L6
        L5:
            return r11;
        L6:
            e = move-exception;
            if (this.f3496b == true) goto L11;
            this.f3496b = true;
            f r12 = this.f3498n;
            r12.f3492b.i(false, r12, this.f3497m, e);
        L11:
            throw e;
        }
    }

    static {
        f3489f = xe.c.q(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
        f3490g = xe.c.q(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    }

    public f(v r8, af.f r10, ze.g r11, g r12) {
        this.f3491a = r10;
        this.f3492b = r11;
        this.f3493c = r12;
        w r13 = w.f13323p;
        if (r8.f13279m.contains(r13) == true) goto L6;
        r13 = w.f13322o;
    L6:
        this.f3495e = r13;
    }

    @Override // af.c
    public final void a() {
        o r8 = this.f3494d;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r8.f3570f == false) goto L7;
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L14
        r8.f3572h.close();
        return;
    L7:
        if (r8.i() == true) goto L11;
        throw new IllegalStateException("reply before requesting the sink");     // Catch: Throwable -> L14
    }

    @Override // af.c
    public final void b(y r15) {
        if (this.f3494d == null) goto L5;
        return;
    L5:
        boolean r8 = true;
        if (r15.f13341e == null) goto L8;
        boolean r10 = true;
    L9:
        we.q r11 = r15.f13340d;
        ArrayList r12 = new ArrayList((r11.f13238a.length / 2) + 4);
        r12.add(new c(r15.f13339c, c.f3460f));
        jf.g r13 = c.f3461g;
        we.r r14 = r15.f13337a;
        r12.add(new c(af.h.a(r14), r13));
        String r16 = r15.b("Host");
        if (r16 == null) goto L12;
        r12.add(new c(r16, c.f3463i));
    L12:
        r12.add(new c(r14.f13241a, c.f3462h));
        int r17 = r11.f13238a.length / 2;
        int r18 = 0;
    L13:
        if (r18 >= r17) goto L18;
        jf.g r19 = jf.g.d(r11.e(r18).toLowerCase(Locale.US));
        if (f3489f.contains(r19.p()) == true) goto L17;
        r12.add(new c(r11.j(r18), r19));
    L17:
        r18 = r18 + 1;
        goto L13
    L18:
        g r110 = this.f3493c;
        boolean r20 = !r10;
        p r21 = r110.F;
        monitor-enter(r21);
        monitor-enter(r110);     // Catch: Throwable -> L71
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L22:
        if (r110.f3504p <= 1073741823) goto L25;
        r110.H(b.f3454p);     // Catch: Throwable -> L68
    L25:
        if (r110.f3505q == true) goto L67;
        int r111 = r110.f3504p;     // Catch: Throwable -> L68
        r110.f3504p = r111 + 2;     // Catch: Throwable -> L68
        o r112 = new o(r111, r110, r20, false, null);     // Catch: Throwable -> L68
        if (r10 == false) goto L35;
        if (r110.B == 0) goto L35;
        if (r112.f3566b == 0) goto L35;
        r8 = false;
    L35:
        if (r112.j() == false) goto L37;
        r110.f3501m.put(Integer.valueOf(r111), r112);     // Catch: Throwable -> L68
    L37:
        monitor-exit(r110);     // Catch: Throwable -> L68
        p r22 = r110.F;     // Catch: Throwable -> L71
        monitor-enter(r22);     // Catch: Throwable -> L71
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L41:
        if (r22.f3592o == true) goto L63;
        r22.r(r111, r12, r20);     // Catch: Throwable -> L60
        monitor-exit(r22);     // Catch: Throwable -> L71
        monitor-exit(r21);     // Catch: Throwable -> L71
        if (r8 == false) goto L58;
        p r113 = r110.F;
        monitor-enter(r113);
    L55:
        th = move-exception;
        throw th;
    L49:
        if (r113.f3592o == true) goto L54;
        r113.f3588a.flush();     // Catch: Throwable -> L55
        monitor-exit(r113);
        goto L58
    L54:
        throw new IOException("closed");     // Catch: Throwable -> L55
    L58:
        this.f3494d = r112;
        o.c r114 = r112.f3573i;
        long r23 = ((af.f) this.f3491a).f368j;
        TimeUnit r24 = TimeUnit.MILLISECONDS;
        r114.g(r23, r24);
        this.f3494d.f3574j.g(((af.f) this.f3491a).f369k, r24);
        return;
    L63:
        throw new IOException("closed");     // Catch: Throwable -> L60
    L67:
        throw new cf.a();     // Catch: Throwable -> L68
    L71:
        th = move-exception;
        throw th;
    L8:
        r10 = false;
        goto L9
    }

    @Override // af.c
    public final af.g c(a0 r8) {
        ze.g r10 = this.f3492b;
        r10.f14405f.responseBodyStart(r10.f14404e);
        String r11 = r8.n("Content-Type");
        long r12 = af.e.a(r8);
        a r13 = new a(this, this.f3494d.f3571g);
        Logger r14 = jf.p.f8861a;
        return new af.g(r11, r12, new jf.r(r13));
    }

    @Override // af.c
    public final void cancel() {
        o r8 = this.f3494d;
        if (r8 == null) goto L6;
        r8.h(b.f3455q);
        return;
    }

    @Override // af.c
    public final jf.v d(y r8, long r10) {
        o r11 = this.f3494d;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r11.f3570f == false) goto L7;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return r11.f3572h;
    L7:
        if (r11.i() == true) goto L11;
        throw new IllegalStateException("reply before requesting the sink");     // Catch: Throwable -> L14
    }

    @Override // af.c
    public final a0.a e(boolean r10) {
        we.q r8 = this.f3494d.m();
        we.q.a r11 = new we.q.a();
        int r12 = r8.f13238a.length / 2;
        int r13 = 0;
        r3.e r14 = null;
    L3:
        if (r13 >= r12) goto L11;
        String r15 = r8.e(r13);
        String r16 = r8.j(r13);
        if (r15.equals(":status") == false) goto L8;
        r14 = r3.e.a("HTTP/1.1 " + r16);
    L10:
        r13 = r13 + 1;
        goto L3
    L8:
        if (f3490g.contains(r15) == true) goto L10;
        xe.a.f13878a.getClass();
        r11.b(r15, r16);
        goto L10
    L11:
        if (r14 == null) goto L19;
        a0.a r17 = new a0.a();
        r17.f13127b = this.f3495e;
        r17.f13128c = r14.f11422b;
        r17.f13129d = (String) r14.f11424d;
        r17.f13131f = new we.q(r11).g();
        if (r10 == false) goto L17;
        xe.a.f13878a.getClass();
        if (r17.f13128c != 100) goto L17;
        return null;
    L17:
        return r17;
    L19:
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // af.c
    public final void f() {
        this.f3493c.flush();
    }
}
