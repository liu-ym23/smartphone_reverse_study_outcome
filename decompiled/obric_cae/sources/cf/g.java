package cf;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Closeable {
    public static final ThreadPoolExecutor I = null;
    public long A;
    public long B;
    public final p.f C;
    public final p.f D;
    public final Socket E;
    public final p F;
    public final h G;
    public final LinkedHashSet H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f3500b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f3501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f3506r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ThreadPoolExecutor f3507s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final r.a f3508t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f3509u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f3510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f3511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f3512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f3513y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f3514z;

    public class a extends xe.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3515b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ cf.b f3516m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ g f3517n;

        public a(g r8, Object[] r10, int r11, cf.b r12) {
            this.f3517n = r8;
            this.f3515b = r11;
            this.f3516m = r12;
            super("OkHttp %s stream %d", r10);
        }

        @Override // xe.b
        public final void a() {
            g r8 = this.f3517n;
            int r10 = this.f3515b;     // Catch: IOException -> L5
            cf.b r11 = this.f3516m;     // Catch: IOException -> L5
            r8.F.w(r10, r11);     // Catch: IOException -> L5
            return;
        L5:
            r8.getClass();
            cf.b r12 = cf.b.f3451m;     // Catch: IOException -> L8
            r8.x(r12, r12);     // Catch: IOException -> L8
            return;
        }
    }

    public class b extends xe.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3518b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f3519m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ g f3520n;

        public b(g r8, Object[] r10, int r11, long r12) {
            this.f3520n = r8;
            this.f3518b = r11;
            this.f3519m = r12;
            super("OkHttp Window Update %s stream %d", r10);
        }

        @Override // xe.b
        public final void a() {
            g r8 = this.f3520n;
            r8.F.x(this.f3518b, this.f3519m);     // Catch: IOException -> L5
            return;
        L5:
            r8.getClass();
            cf.b r10 = cf.b.f3451m;     // Catch: IOException -> L8
            r8.x(r10, r10);     // Catch: IOException -> L8
            return;
        }
    }

    public class c extends xe.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f3521b;

        public c(g r8, Object... r10) {
            this.f3521b = r8;
            super("OkHttp %s ping", r10);
        }

        @Override // xe.b
        public final void a() {
            g r8 = this.f3521b;
            r8.getClass();
            r8.F.v(2, 0, false);     // Catch: IOException -> L5
            return;
        L5:
            cf.b r10 = cf.b.f3451m;     // Catch: IOException -> L7
            r8.x(r10, r10);     // Catch: IOException -> L7
            return;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Socket f3522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public jf.f f3524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public jf.e f3525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f f3526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3527f;

        public d() {
            this.f3526e = f.f3529a;
        }
    }

    public final class e extends xe.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f3528b;

        public e(g r8) {
            this.f3528b = r8;
            super("OkHttp %s ping", new Object[]{r8.f3502n});
        }

        @Override // xe.b
        public final void a() {
            if (p000if.a.b().f8333c.get() == true) goto L5;
            return;
        L5:
            g r8 = this.f3528b;
            monitor-enter(r8);
            g r10 = this.f3528b;     // Catch: Throwable -> L19
            long r11 = r10.f3510v;     // Catch: Throwable -> L19
            long r12 = r10.f3509u;     // Catch: Throwable -> L19
            if (r11 >= r12) goto L10;
            boolean r13 = true;
        L11:
            monitor-exit(r8);     // Catch: Throwable -> L19
            if (r13 == false) goto L26;
            cf.b r14 = cf.b.f3451m;     // Catch: IOException -> L22
            r10.x(r14, r14);     // Catch: IOException -> L22
        L23:
            return;
        L26:
            r10.F.v(1, 0, false);     // Catch: IOException -> L17
        L17:
            cf.b r15 = cf.b.f3451m;     // Catch: IOException -> L22
            r10.x(r15, r15);     // Catch: IOException -> L22
        L30:
            return;
        L10:
            r10.f3509u = r12 + 1;     // Catch: Throwable -> L19
            r13 = false;
        L19:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3529a = null;

        public static class a extends f {
            @Override // cf.g.f
            public final void b(o r8) {
                r8.f(cf.b.f3454p);
            }
        }

        static {
            f3529a = new a();
        }

        public void a(g r8) {
        }

        public abstract void b(o r8);
    }

    /* JADX INFO: renamed from: cf.g$g, reason: collision with other inner class name */
    public final class C0044g extends xe.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3530b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f3531m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f3532n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ g f3533o;

        public C0044g(g r8, int r10, int r11) {
            this.f3533o = r8;
            super("OkHttp %s ping %08x%08x", new Object[]{r8.f3502n, Integer.valueOf(r10), Integer.valueOf(r11)});
            this.f3530b = true;
            this.f3531m = r10;
            this.f3532n = r11;
        }

        @Override // xe.b
        public final void a() {
            int r8 = this.f3531m;
            int r10 = this.f3532n;
            boolean r11 = this.f3530b;
            g r12 = this.f3533o;
            r12.getClass();
            r12.F.v(r8, r10, r11);     // Catch: IOException -> L5
            return;
        L5:
            cf.b r13 = cf.b.f3451m;     // Catch: IOException -> L7
            r12.x(r13, r13);     // Catch: IOException -> L7
            return;
        }
    }

    public class h extends xe.b implements n.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f3534b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ g f3535m;

        public class a extends xe.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f3536b;

            public a(h r8, Object... r10) {
                this.f3536b = r8;
                super("OkHttp %s settings", r10);
            }

            @Override // xe.b
            public final void a() {
                g r8 = this.f3536b.f3535m;
                r8.f3500b.a(r8);
            }
        }

        public h(g r8, n r10) {
            this.f3535m = r8;
            super("OkHttp %s", new Object[]{r8.f3502n});
            this.f3534b = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // xe.b
        public final void a() {
            g r8 = this.f3535m;
            n r10 = this.f3534b;
            cf.b r11 = cf.b.f3452n;
            r10.k(this);     // Catch: Throwable -> L11 IOException -> L13
        L5:
            if (r10.i(false, this) == true) goto L5;
            cf.b r12 = cf.b.f3450b;     // Catch: Throwable -> L11 IOException -> L13
            r11 = cf.b.f3455q;     // Catch: IOException -> L23 Throwable -> L18
            r8.x(r12, r11);     // Catch: IOException -> L22
            cf.b this = r12;
        L27:
            goto L16
        L18:
            th = th;
        L25:
            r8.x(this, r11);     // Catch: IOException -> L24
        L20:
            xe.c.f(r10);
            throw th;
        L11:
            th = th;
            this = r11;
        L14:
            cf.b r13 = cf.b.f3451m;     // Catch: Throwable -> L18
            r8.x(r13, r13);     // Catch: IOException -> L22
            this = r13;
        L16:
            xe.c.f(r10);
        }

        public final void b(boolean r8, p.f r10) {
            p r11 = this.f3535m.F;
            monitor-enter(r11);
            g r12 = this.f3535m;     // Catch: Throwable -> L37
            monitor-enter(r12);     // Catch: Throwable -> L37
            int r13 = this.f3535m.D.b();     // Catch: Throwable -> L34
            if (r8 == false) goto L9;
            this.f3535m.D.a();     // Catch: Throwable -> L34
        L9:
            this.f3535m.D.c(r10);     // Catch: Throwable -> L34
            int r14 = this.f3535m.D.b();     // Catch: Throwable -> L34
            o[] r15 = null;
            if (r14 == (-1)) goto L15;
            if (r14 == r13) goto L15;
            long r16 = r14 - r13;     // Catch: Throwable -> L34
            if (this.f3535m.f3501m.isEmpty() == true) goto L16;
            r15 = (o[]) this.f3535m.f3501m.values().toArray(new o[this.f3535m.f3501m.size()]);     // Catch: Throwable -> L34
        L16:
            monitor-exit(r12);     // Catch: Throwable -> L34
            g r17 = this.f3535m;     // Catch: IOException -> L19 Throwable -> L37
            r17.F.a(r17.D);     // Catch: IOException -> L19 Throwable -> L37
        L20:
            monitor-exit(r11);     // Catch: Throwable -> L37
            if (r15 == null) goto L32;
            int r18 = r15.length;
            int r19 = 0;
        L23:
            if (r19 >= r18) goto L32;
            o r20 = r15[r19];
            monitor-enter(r20);
            r20.c(r16);     // Catch: Throwable -> L29
            monitor-exit(r20);     // Catch: Throwable -> L29
            r19 = r19 + 1;     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            throw th;
        L32:
            g.n().execute(new a(this, new Object[]{this.f3535m.f3502n}));
            return;
        L19:
            g.a(this.f3535m);     // Catch: Throwable -> L37
            goto L20
        L15:
            r16 = 0;
        L34:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            throw th;
        }

        public final void c(boolean r11, int r12, ArrayList r13) {
            this.f3535m.getClass();
            if (g.D(r12) == false) goto L6;
            this.f3535m.C(r12, r13, r11);
            return;
        L6:
            g r8 = this.f3535m;
            monitor-enter(r8);
            o r10 = this.f3535m.z(r12);     // Catch: Throwable -> L25
            if (r10 == null) goto L11;
            monitor-exit(r8);     // Catch: Throwable -> L25
            r10.l(r13);
            if (r11 == false) goto L35;
            r10.k();
            return;
        L35:
            return;
        L11:
            if (g.k(this.f3535m) == false) goto L14;
            monitor-exit(r8);     // Catch: Throwable -> L25
            return;
        L14:
            g r14 = this.f3535m;     // Catch: Throwable -> L25
            if (r12 > r14.f3503o) goto L19;
            monitor-exit(r8);     // Catch: Throwable -> L25
            return;
        L19:
            if ((r12 % 2) != (r14.f3504p % 2)) goto L22;
            monitor-exit(r8);     // Catch: Throwable -> L25
            return;
        L22:
            o r15 = new o(r12, this.f3535m, false, r11, xe.c.x(r13));     // Catch: Throwable -> L25
            g r16 = this.f3535m;     // Catch: Throwable -> L25
            r16.f3503o = r12;     // Catch: Throwable -> L25
            r16.f3501m.put(Integer.valueOf(r12), r15);     // Catch: Throwable -> L25
            g.n().execute(new l(this, new Object[]{this.f3535m.f3502n, Integer.valueOf(r12)}, r15));     // Catch: Throwable -> L25
            monitor-exit(r8);     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }

        public final void d(int r8, int r10, boolean r11) {
            if (r11 == false) goto L23;
            g r12 = this.f3535m;
            monitor-enter(r12);
            if (r8 != 1) goto L11;
            g.i(this.f3535m);     // Catch: Throwable -> L8
        L16:
            monitor-exit(r12);     // Catch: Throwable -> L8
            return;
        L11:
            if (r8 != 2) goto L14;
            g.v(this.f3535m);     // Catch: Throwable -> L8
            goto L16
        L14:
            if (r8 != 3) goto L16;
            g.w(this.f3535m);     // Catch: Throwable -> L8
            this.f3535m.notifyAll();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        L23:
            g.r(this.f3535m).execute(new C0044g(this.f3535m, r8, r10));     // Catch: RejectedExecutionException -> L22
            return;
        }

        public final void e(p.f r8) {
            g r10 = this.f3535m;
            g.r(r10).execute(new m(this, new Object[]{r10.f3502n}, r8));     // Catch: RejectedExecutionException -> L5
            return;
        }
    }

    static {
        TimeUnit r8 = TimeUnit.SECONDS;
        SynchronousQueue r10 = new SynchronousQueue();
        byte[] r11 = xe.c.f13880a;
        I = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r8, r10, new xe.d("OkHttp Http2Connection", true));
    }

    public g(d r23) {
        this.f3501m = new LinkedHashMap();
        this.f3509u = 0;
        this.f3510v = 0;
        this.f3511w = 0;
        this.f3512x = 0;
        this.f3513y = 0;
        this.f3514z = 0;
        this.A = 0;
        p.f r8 = new p.f();
        this.C = r8;
        p.f r10 = new p.f();
        this.D = r10;
        this.H = new LinkedHashSet();
        this.f3508t = r.f3601a;
        this.f3499a = true;
        this.f3500b = r23.f3526e;
        this.f3504p = 3;
        r8.e(7, 16777216);
        String r11 = r23.f3523b;
        this.f3502n = r11;
        ScheduledThreadPoolExecutor r12 = new ScheduledThreadPoolExecutor(1, new xe.d(xe.c.n("OkHttp %s Writer", new Object[]{r11}), false));
        this.f3506r = r12;
        if (r23.f3527f == 0) goto L5;
        e r13 = new e(this);
        long r14 = r23.f3527f;
        r12.scheduleAtFixedRate(r13, r14, r14, TimeUnit.MILLISECONDS);
    L5:
        this.f3507s = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new xe.d(xe.c.n("OkHttp %s Push Observer", new Object[]{r11}), true));
        r10.e(7, 65535);
        r10.e(5, 16384);
        this.B = r10.b();
        this.E = r23.f3522a;
        this.F = new p(r23.f3525d, true);
        this.G = new h(this, new n(r23.f3524c, true));
    }

    public static boolean D(int r8) {
        if (r8 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r8 & 1) != 0) goto L6;
        return true;
    }

    public static void a(g r8) {
        r8.getClass();
        cf.b r10 = cf.b.f3451m;     // Catch: IOException -> L5
        r8.x(r10, r10);     // Catch: IOException -> L5
        return;
    }

    public static /* synthetic */ void i(g r8) {
        r8.f3510v++;
    }

    public static /* synthetic */ boolean k(g r8) {
        return r8.f3505q;
    }

    public static /* synthetic */ ThreadPoolExecutor n() {
        return I;
    }

    public static /* synthetic */ ScheduledThreadPoolExecutor r(g r8) {
        return r8.f3506r;
    }

    public static /* synthetic */ void v(g r8) {
        r8.f3512x++;
    }

    public static /* synthetic */ void w(g r8) {
        r8.f3513y++;
    }

    public final void A(int r8, int r10, jf.f r11, boolean r12) {
        jf.d r13 = new jf.d();
        long r14 = r10;
        r11.L(r14);
        r11.u(r13, r14);
        if (r13.size() != r14) goto L7;
        B(new j(this, new Object[]{this.f3502n, Integer.valueOf(r8)}, r8, r13, r10, r12));
        return;
    L7:
        throw new IOException(r13.size() + " != " + r10);
    }

    public final synchronized void B(xe.b r8) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f3505q == true) goto L6;
        this.f3507s.execute(r8);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final void C(int r8, ArrayList r10, boolean r11) {
        B(new i(this, new Object[]{this.f3502n, Integer.valueOf(r8)}, r8, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    public final synchronized o E(int r8) {
        monitor-enter(this);
        o r10 = (o) this.f3501m.remove(Integer.valueOf(r8));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final void G() {
        monitor-enter(this);
        long r8 = this.f3512x;     // Catch: Throwable -> L11
        long r10 = this.f3511w;     // Catch: Throwable -> L11
        if (r8 >= r10) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.f3511w = r10 + 1;     // Catch: Throwable -> L11
        this.f3514z = System.nanoTime() + BwdlDropUtils.DROP_SHOW_GIGABYTES;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.f3506r.execute(new c(this, new Object[]{this.f3502n}));     // Catch: RejectedExecutionException -> L14
        return;
    L18:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void H(cf.b r8) {
        p r10 = this.F;
        monitor-enter(r10);
        monitor-enter(this);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.f3505q == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L11:
        this.f3505q = true;     // Catch: Throwable -> L16
        int r11 = this.f3503o;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.F.n(r11, r8, xe.c.f13880a);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void I(long r8) {
        monitor-enter(this);
        long r10 = this.A + r8;     // Catch: Throwable -> L8
        this.A = r10;     // Catch: Throwable -> L8
        if (r10 < (this.C.b() / 2)) goto L6;
        V(0, this.A);     // Catch: Throwable -> L8
        this.A = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void J(int r10, boolean r11, jf.d r12, long r13) {
        if (r13 != 0) goto L7;
        this.F.i(r11, r10, r12, 0);
        return;
    L7:
        if (r13 <= 0) goto L31;
        monitor-enter(this);
    L32:
        long r8 = this.B;     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r8 > 0) goto L16;
        if (this.f3501m.containsKey(Integer.valueOf(r10)) == false) goto L15;
        wait();     // Catch: Throwable -> L25 InterruptedException -> L27
        goto L32
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L25 InterruptedException -> L27
    L16:
        int r14 = Math.min((int) Math.min(r13, r8), this.F.f3591n);     // Catch: Throwable -> L25
        long r15 = r14;
        this.B -= r15;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        r13 = r13 - r15;
        p r16 = this.F;
        if (r11 == true) goto L21;
    L23:
        boolean r17 = false;
    L24:
        r16.i(r17, r10, r12, r14);
        goto L7
    L21:
        if (r13 != 0) goto L23;
        r17 = true;
    L27:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        throw new InterruptedIOException();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final void K(int r8, cf.b r10) {
        this.f3506r.execute(new a(this, new Object[]{this.f3502n, Integer.valueOf(r8)}, r8, r10));     // Catch: RejectedExecutionException -> L4
        return;
    }

    public final void V(int r10, long r11) {
        this.f3506r.execute(new b(this, new Object[]{this.f3502n, Integer.valueOf(r10)}, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        x(cf.b.f3450b, cf.b.f3455q);
    }

    public final void flush() {
        p r8 = this.F;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r8.f3592o == true) goto L10;
        r8.f3588a.flush();     // Catch: Throwable -> L11
        monitor-exit(r8);
        return;
    L10:
        throw new IOException("closed");     // Catch: Throwable -> L11
    }

    public final void x(cf.b r8, cf.b r10) {
        o[] r11 = null;
        H(r8);     // Catch: IOException -> L5
        e = null;
    L6:
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L8:
        if (this.f3501m.isEmpty() == true) goto L10;
        r11 = (o[]) this.f3501m.values().toArray(new o[this.f3501m.size()]);     // Catch: Throwable -> L33
        this.f3501m.clear();     // Catch: Throwable -> L33
    L10:
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r11 == null) goto L40;
        int r12 = r11.length;
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L40;
        r11[r13].f(r10);     // Catch: IOException -> L17
    L20:
        r13 = r13 + 1;
    L17:
        e = move-exception;
        if (e == null) goto L20;
        e = e;
    L40:
        this.F.close();     // Catch: IOException -> L23
    L42:
        this.E.close();     // Catch: IOException -> L28
    L29:
        this.f3506r.shutdown();
        this.f3507s.shutdown();
        if (e != null) goto L32;
        return;
    L32:
        throw e;
    L28:
        e = e;
    L23:
        e = move-exception;
        if (e != null) goto L42;
        e = e;
    L5:
        e = e;
        goto L6
    }

    public final synchronized o z(int r8) {
        monitor-enter(this);
        o r10 = (o) this.f3501m.get(Integer.valueOf(r8));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
