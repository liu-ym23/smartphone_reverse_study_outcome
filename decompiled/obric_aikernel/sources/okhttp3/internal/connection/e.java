package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kc.j;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.CertificatePinner;
import okhttp3.o;
import okhttp3.q;
import okhttp3.s;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRealCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,560:1\n1#2:561\n608#3,4:562\n615#3,4:566\n615#3,4:570\n608#3,4:574\n350#4,7:578\n*S KotlinDebug\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall\n*L\n269#1:562,4\n344#1:566,4\n348#1:570,4\n375#1:574,4\n378#1:578,7\n*E\n"})
public final class e implements okhttp3.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w f11799c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x f11800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f11801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f f11802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final q f11803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c f11804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f11805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Object f11806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d f11807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RealConnection f11808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f11809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private okhttp3.internal.connection.c f11810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f11811r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f11812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f11813t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f11814u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile okhttp3.internal.connection.c f11815v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile RealConnection f11816w;

    @SourceDebugExtension({"SMAP\nRealCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall$AsyncCall\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,560:1\n615#2,4:561\n409#2,9:565\n*S KotlinDebug\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall$AsyncCall\n*L\n503#1:561,4\n522#1:565,9\n*E\n"})
    public final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.f f11817c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile AtomicInteger f11818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f11819h;

        public final void a(ExecutorService r10) {
            Intrinsics.checkNotNullParameter(r10, "executorService");
            o r11 = this.f11819h.l().o();
            if (hc.e.f9283g == true) goto L5;
        L19:
            r10.execute(this);     // Catch: Throwable -> L11 RejectedExecutionException -> L13
        L22:
            return;
        L11:
            th = move-exception;
            this.f11819h.l().o().d(this);
            throw th;
        L13:
            e = move-exception;
            InterruptedIOException r12 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L11
            r12.initCause(e);     // Catch: Throwable -> L11
            this.f11819h.s(r12);     // Catch: Throwable -> L11
            this.f11817c.b(this.f11819h, r12);     // Catch: Throwable -> L11
            this.f11819h.l().o().d(this);
            return;
        L5:
            if (Thread.holdsLock(r11) == false) goto L19;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r11);
        }

        public final AtomicInteger b() {
            return this.f11818g;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = "OkHttp " + this.f11819h.t();
            e r11 = this.f11819h;
            Thread r12 = Thread.currentThread();
            String r13 = r12.getName();
            r12.setName(r10);
            e.b(r11).v();     // Catch: Throwable -> L33
            boolean r14 = true;
            this.f11817c.a(r11, r11.p());     // Catch: Throwable -> L10 IOException -> L12
            o r15 = r11.l().o();     // Catch: Throwable -> L33
        L8:
            r15.d(this);     // Catch: Throwable -> L33
            r12.setName(r13);
            return;
        L12:
            IOException e10 = e;
        L24:
            if (r14 == false) goto L26;
            okhttp3.internal.platform.h.f11979a.g().j("Callback failure for " + e.d(r11), 4, e10);     // Catch: Throwable -> L20
        L27:
            r15 = r11.l().o();     // Catch: Throwable -> L33
            goto L8
        L26:
            this.f11817c.b(r11, e10);     // Catch: Throwable -> L20
        L10:
            Throwable th = th;
        L16:
            r11.cancel();     // Catch: Throwable -> L20
            if (r14 == true) goto L19;
            IOException r16 = new IOException("canceled due to " + th);     // Catch: Throwable -> L20
            ExceptionsKt.addSuppressed(r16, th);     // Catch: Throwable -> L20
            this.f11817c.b(r11, r16);     // Catch: Throwable -> L20
        L19:
            throw th;     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            r14 = false;
            e10 = e;
        L14:
            th = move-exception;
            r14 = false;
            th = th;
        L33:
            th = move-exception;
            r12.setName(r13);
            throw th;
        L20:
            th = move-exception;
            r11.l().o().d(this);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        }
    }

    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f11820a;

        public b(e r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "referent");
            super(r10);
            this.f11820a = r11;
        }

        public final Object a() {
            return this.f11820a;
        }
    }

    public static final class c extends okio.c {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ e f11821n;

        c(e r10) {
            this.f11821n = r10;
        }

        @Override // okio.c
        protected void B() {
            this.f11821n.cancel();
        }
    }

    public e(w r10, x r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "originalRequest");
        this.f11799c = r10;
        this.f11800g = r11;
        this.f11801h = r12;
        this.f11802i = r10.l().a();
        this.f11803j = r10.r().a(this);
        c r13 = new c(this);
        r13.g(r10.h(), TimeUnit.MILLISECONDS);
        this.f11804k = r13;
        this.f11805l = new AtomicBoolean();
        this.f11813t = true;
    }

    private final String A() {
        StringBuilder r10 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r11 = "canceled ";
    L6:
        r10.append(r11);
        if (this.f11801h == false) goto L9;
        String r12 = "web socket";
    L10:
        r10.append(r12);
        r10.append(" to ");
        r10.append(t());
        return r10.toString();
    L9:
        r12 = NotificationCompat.CATEGORY_CALL;
        goto L10
    L5:
        r11 = "";
        goto L6
    }

    public static final /* synthetic */ c b(e r10) {
        return r10.f11804k;
    }

    public static final /* synthetic */ String d(e r10) {
        return r10.A();
    }

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
    private final <E extends IOException> E f(E r10) {
        boolean r11 = hc.e.f9283g;
        if (r11 == true) goto L5;
    L9:
        RealConnection r12 = this.f11808o;
        if (r12 == null) goto L35;
        if (r11 == true) goto L13;
    L17:
        monitor-enter(r12);
        Socket r13 = u();     // Catch: Throwable -> L32
        monitor-exit(r12);
        if (this.f11808o != null) goto L25;
        if (r13 == null) goto L24;
        hc.e.n(r13);
    L24:
        this.f11803j.n(this, r12);
        goto L35
    L25:
        if (r13 != null) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L35;
        throw new IllegalStateException("Check failed.".toString());
    L27:
        r14 = false;
    L32:
        th = move-exception;
        throw th;
    L13:
        if (Thread.holdsLock(r12) == false) goto L17;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r12);
    L35:
        E r15 = (E) z(r10);
        if (r10 == null) goto L38;
        q r16 = this.f11803j;
        Intrinsics.checkNotNull(r15);
        r16.d(this, r15);
    L39:
        return r15;
    L38:
        this.f11803j.c(this);
        goto L39
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void g() {
        this.f11806m = okhttp3.internal.platform.h.f11979a.g().h("response.body().close()");
        this.f11803j.g(this);
    }

    private final okhttp3.a i(s r19) {
        if (r19.i() == false) goto L5;
        SSLSocketFactory r10 = this.f11799c.J();
        HostnameVerifier r11 = this.f11799c.v();
        SSLSocketFactory r12 = r10;
        CertificatePinner r13 = this.f11799c.j();
    L7:
        return new okhttp3.a(r19.h(), r19.n(), this.f11799c.p(), this.f11799c.K(), this.f11799c.I(), r12, r11, r13, this.f11799c.E(), this.f11799c.D(), this.f11799c.C(), this.f11799c.m(), this.f11799c.F());
    L5:
        r12 = null;
        r11 = null;
        r13 = null;
        goto L7
    }

    private final <E extends IOException> E z(E r10) {
        if (this.f11809p == false) goto L6;
        return r10;
    L6:
        if (this.f11804k.w() == true) goto L8;
        return r10;
    L8:
        InterruptedIOException r11 = new InterruptedIOException("timeout");
        if (r10 == null) goto L11;
        r11.initCause(r10);
    L11:
        return r11;
    }

    @Override // okhttp3.e
    public void cancel() {
        if (this.f11814u == false) goto L5;
        return;
    L5:
        this.f11814u = true;
        okhttp3.internal.connection.c r10 = this.f11815v;
        if (r10 == null) goto L8;
        r10.b();
    L8:
        RealConnection r11 = this.f11816w;
        if (r11 == null) goto L11;
        r11.f();
    L11:
        this.f11803j.h(this);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return h();
    }

    public final void e(RealConnection r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        if (hc.e.f9283g == false) goto L10;
        if (Thread.holdsLock(r10) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    L10:
        if (this.f11808o != null) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L17;
        this.f11808o = r10;
        r10.p().add(new b(this, this.f11806m));
        return;
    L17:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r11 = false;
        goto L13
    }

    @Override // okhttp3.e
    public z execute() {
        if (this.f11805l.compareAndSet(false, true) == false) goto L12;
        this.f11804k.v();
        g();
        this.f11799c.o().a(this);     // Catch: Throwable -> L8
        z r10 = p();     // Catch: Throwable -> L8
        this.f11799c.o().e(this);
        return r10;
    L8:
        th = move-exception;
        this.f11799c.o().e(this);
        throw th;
    L12:
        throw new IllegalStateException("Already Executed".toString());
    }

    public e h() {
        return new e(this.f11799c, this.f11800g, this.f11801h);
    }

    @Override // okhttp3.e
    public boolean isCanceled() {
        return this.f11814u;
    }

    public final void j(x r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        if (this.f11810q != null) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L25;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L9:
        if ((!this.f11812s) == false) goto L20;
        if ((!this.f11811r) == false) goto L18;
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (r11 == false) goto L27;
        this.f11807n = new d(this.f11802i, i(r10.l()), this, this.f11803j);
        return;
    L27:
        return;
    L18:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());     // Catch: Throwable -> L21
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r12 = false;
        goto L6
    }

    public final void k(boolean r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f11813t == false) goto L14;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (r10 == false) goto L11;
        okhttp3.internal.connection.c r12 = this.f11815v;
        if (r12 == null) goto L11;
        r12.d();
    L11:
        this.f11810q = null;
        return;
    L14:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L15
    }

    public final w l() {
        return this.f11799c;
    }

    public final RealConnection m() {
        return this.f11808o;
    }

    public final q n() {
        return this.f11803j;
    }

    public final okhttp3.internal.connection.c o() {
        return this.f11810q;
    }

    public final z p() {
        ArrayList r10 = new ArrayList();
        CollectionsKt.addAll(r10, this.f11799c.w());
        r10.add(new j(this.f11799c));
        r10.add(new kc.a(this.f11799c.n()));
        r10.add(new okhttp3.internal.cache.a(this.f11799c.g()));
        r10.add(okhttp3.internal.connection.a.f11766a);
        if (this.f11801h == true) goto L5;
        CollectionsKt.addAll(r10, this.f11799c.y());
    L5:
        r10.add(new kc.b(this.f11801h));
        boolean r11 = false;
        z r12 = new kc.g(this, r10, 0, null, this.f11800g, this.f11799c.k(), this.f11799c.G(), this.f11799c.M()).b(this.f11800g);     // Catch: Throwable -> L12 IOException -> L14
        if (isCanceled() == true) goto L10;
        s(null);
        return r12;
    L10:
        hc.e.m(r12);     // Catch: Throwable -> L12 IOException -> L14
        throw new IOException("Canceled");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        IOException r13 = s(e);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L18
        throw r13;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th = th;
        r11 = true;
    L20:
        if (r11 == true) goto L22;
        s(null);
    L22:
        throw th;
    L12:
        th = th;
        goto L20
    }

    public final okhttp3.internal.connection.c q(kc.g r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.f11813t == false) goto L29;
        if ((!this.f11812s) == false) goto L27;
        if ((!this.f11811r) == false) goto L25;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
        d r12 = this.f11807n;
        Intrinsics.checkNotNull(r12);
        okhttp3.internal.connection.c r13 = new okhttp3.internal.connection.c(this, this.f11803j, r12, r12.a(this.f11799c, r10));
        this.f11810q = r13;
        this.f11815v = r13;
        monitor-enter(this);
        this.f11811r = true;     // Catch: Throwable -> L21
        this.f11812s = true;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (this.f11814u == true) goto L20;
        return r13;
    L20:
        throw new IOException("Canceled");
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L30
    L27:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L30
    }

    public final <E extends IOException> E r(okhttp3.internal.connection.c r10, boolean r11, boolean r12, E r13) {
        Intrinsics.checkNotNullParameter(r10, "exchange");
        if (Intrinsics.areEqual(r10, this.f11815v) == true) goto L5;
        return r13;
    L5:
        monitor-enter(this);
        boolean r14 = false;
        if (r11 == true) goto L46;
    L13:
        if (r12 == true) goto L15;
    L33:
        boolean r15 = false;
    L34:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        if (r14 == false) goto L40;
        this.f11815v = null;
        RealConnection r17 = this.f11808o;
        if (r17 == null) goto L40;
        r17.u();
    L40:
        if (r15 == true) goto L42;
        return r13;
    L42:
        return (E) f(r13);
    L11:
        th = move-exception;
        throw th;
    L15:
        if (this.f11812s == false) goto L33;
    L16:
        if (r11 == false) goto L18;
        this.f11811r = false;     // Catch: Throwable -> L11
    L18:
        if (r12 == false) goto L20;
        this.f11812s = false;     // Catch: Throwable -> L11
    L20:
        boolean r18 = this.f11811r;     // Catch: Throwable -> L11
        if (r18 == false) goto L23;
    L25:
        boolean r19 = false;
    L26:
        if (r18 == false) goto L28;
    L32:
        r15 = r14;
        r14 = r19;
        goto L34
    L28:
        if (this.f11812s == true) goto L32;
        if (this.f11813t == true) goto L32;
        r14 = true;
        goto L32
    L23:
        if (this.f11812s == true) goto L25;
        r19 = true;
        goto L26
    L46:
        if (this.f11811r == true) goto L16;
        goto L16
    }

    public final IOException s(IOException r10) {
        monitor-enter(this);
        boolean r11 = false;
        if (this.f11813t == false) goto L10;
        this.f11813t = false;     // Catch: Throwable -> L16
        if (this.f11811r == true) goto L10;
        if (this.f11812s == true) goto L10;
        r11 = true;
    L10:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r11 == true) goto L14;
        return r10;
    L14:
        return f(r10);
    L16:
        th = move-exception;
        throw th;
    }

    public final String t() {
        return this.f11800g.l().p();
    }

    public final Socket u() {
        RealConnection r10 = this.f11808o;
        Intrinsics.checkNotNull(r10);
        if (hc.e.f9283g == true) goto L5;
    L9:
        List<Reference<e>> r11 = r10.p();
        Iterator<Reference<e>> r12 = r11.iterator();
        boolean r13 = false;
        int r14 = 0;
    L11:
        if (r12.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(r12.next().get(), this) == true) goto L17;
        r14 = r14 + 1;
    L17:
        if (r14 == (-1)) goto L19;
        r13 = true;
    L19:
        if (r13 == false) goto L28;
        r11.remove(r14);
        this.f11808o = null;
        if (r11.isEmpty() == false) goto L26;
        r10.C(System.nanoTime());
        if (this.f11802i.c(r10) == false) goto L26;
        return r10.b();
    L26:
        return null;
    L28:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        r14 = -1;
        goto L17
    L5:
        if (Thread.holdsLock(r10) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    }

    public final void v(int r10) {
        d r11 = this.f11807n;
        if (r11 == null) goto L6;
        r11.e(r10);
        return;
    }

    public final boolean w() {
        d r10 = this.f11807n;
        Intrinsics.checkNotNull(r10);
        return r10.f();
    }

    public final void x(RealConnection r10) {
        this.f11816w = r10;
    }

    public final void y() {
        if ((!this.f11809p) == false) goto L7;
        this.f11809p = true;
        this.f11804k.w();
        return;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
