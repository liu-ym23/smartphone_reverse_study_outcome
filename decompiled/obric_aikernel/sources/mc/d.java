package mc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.r;
import okio.d0;
import okio.f0;
import okio.g0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,688:1\n1#2:689\n615#3,4:690\n615#3,4:694\n563#3:698\n615#3,4:699\n615#3,4:703\n563#3:707\n563#3:708\n615#3,4:709\n563#3:713\n557#3:714\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream\n*L\n176#1:690,4\n255#1:694,4\n263#1:698\n274#1:699,4\n281#1:703,4\n295#1:707\n305#1:708\n491#1:709,4\n637#1:713\n657#1:714\n*E\n"})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.http2.b f11118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque<r> f11123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f11125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f11126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final C0243d f11127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final C0243d f11128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ErrorCode f11129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private IOException f11130n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSink\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,688:1\n615#2,4:689\n615#2,4:693\n615#2,4:697\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSink\n*L\n528#1:689,4\n573#1:693,4\n589#1:697,4\n*E\n"})
    public final class b implements d0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11131c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final okio.d f11132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private r f11133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f11134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f11135j;

        public b(d r10, boolean r11) {
            this.f11135j = r10;
            this.f11131c = r11;
            this.f11132g = new okio.d();
        }

        private final void a(boolean r12) {
            d r10 = this.f11135j;
            monitor-enter(r10);
            r10.s().v();     // Catch: Throwable -> L33
        L39:
        L30:
            th = move-exception;
            r10.s().C();     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L6:
            if (r10.r() < r10.q()) goto L15;
            if (this.f11131c == true) goto L15;
            if (this.f11134i == true) goto L15;
            if (r10.h() != null) goto L15;
            r10.D();     // Catch: Throwable -> L30
        L15:
            r10.s().C();     // Catch: Throwable -> L33
            r10.c();     // Catch: Throwable -> L33
            long r11 = Math.min(r10.q() - r10.r(), this.f11132g.M());     // Catch: Throwable -> L33
            r10.B(r10.r() + r11);     // Catch: Throwable -> L33
            if (r12 == true) goto L18;
        L20:
            boolean r13 = false;
        L21:
            boolean r14 = r13;
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L33
            monitor-exit(r10);
            this.f11135j.s().v();
            this.f11135j.g().v0(this.f11135j.j(), r14, this.f11132g, r11);     // Catch: Throwable -> L27
            this.f11135j.s().C();
            return;
        L27:
            th = move-exception;
            this.f11135j.s().C();
            throw th;
        L18:
            if (r11 != this.f11132g.M()) goto L20;
            r13 = true;
        L33:
            th = move-exception;
            throw th;
        }

        public final boolean c() {
            return this.f11134i;
        }

        @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d r10 = this.f11135j;
            if (hc.e.f9283g == true) goto L5;
        L9:
            d r11 = this.f11135j;
            monitor-enter(r11);
        L51:
            th = move-exception;
            throw th;
        L12:
            if (this.f11134i == false) goto L16;
            monitor-exit(r11);
            return;
        L16:
            if (r11.h() != null) goto L18;
            boolean r12 = true;
        L19:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L51
            monitor-exit(r11);
            if (this.f11135j.o().f11131c == false) goto L24;
        L42:
            d r14 = this.f11135j;
            monitor-enter(r14);
            this.f11134i = true;     // Catch: Throwable -> L48
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r14);
            this.f11135j.g().flush();
            this.f11135j.b();
            return;
        L48:
            th = move-exception;
            throw th;
        L24:
            if (this.f11132g.M() <= 0) goto L26;
            boolean r16 = true;
        L28:
            if (this.f11133h == null) goto L30;
            boolean r17 = true;
        L31:
            if (r17 == true) goto L33;
            if (r16 == true) goto L38;
            if (r12 == false) goto L42;
            this.f11135j.g().v0(this.f11135j.j(), true, null, 0);
        L38:
            if (this.f11132g.M() <= 0) goto L42;
            a(true);
        L33:
            if (this.f11132g.M() <= 0) goto L35;
            a(false);
            goto L33
        L35:
            okhttp3.internal.http2.b r18 = this.f11135j.g();
            int r19 = this.f11135j.j();
            r r20 = this.f11133h;
            Intrinsics.checkNotNull(r20);
            r18.w0(r19, r12, hc.e.P(r20));
            goto L42
        L30:
            r17 = false;
            goto L31
        L26:
            r16 = false;
            goto L28
        L18:
            r12 = false;
            goto L19
        L5:
            if (Thread.holdsLock(r10) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r10);
        }

        public final boolean f() {
            return this.f11131c;
        }

        @Override // okio.d0, java.io.Flushable
        public void flush() {
            d r10 = this.f11135j;
            if (hc.e.f9283g == true) goto L5;
        L9:
            d r11 = this.f11135j;
            monitor-enter(r11);
            r11.c();     // Catch: Throwable -> L17
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(r11);
        L14:
            if (this.f11132g.M() <= 0) goto L16;
            a(false);
            this.f11135j.g().flush();
            goto L14
        L16:
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Thread.holdsLock(r10) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r10);
        }

        @Override // okio.d0
        public g0 timeout() {
            return this.f11135j.s();
        }

        @Override // okio.d0
        public void x(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            d r12 = this.f11135j;
            if (hc.e.f9283g == true) goto L5;
        L9:
            this.f11132g.x(r10, r11);
        L11:
            if (this.f11132g.M() < PlaybackStateCompat.ACTION_PREPARE) goto L13;
            a(false);
            goto L11
        L13:
            return;
        L5:
            if (Thread.holdsLock(r12) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r12);
        }
    }

    @SourceDebugExtension({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,688:1\n1#2:689\n615#3,4:690\n615#3,4:694\n563#3:698\n563#3:699\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSource\n*L\n407#1:690,4\n418#1:694,4\n458#1:698\n480#1:699\n*E\n"})
    public final class c implements f0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f11136c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11137g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final okio.d f11138h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final okio.d f11139i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f11140j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ d f11141k;

        public c(d r10, long r11, boolean r12) {
            this.f11141k = r10;
            this.f11136c = r11;
            this.f11137g = r12;
            this.f11138h = new okio.d();
            this.f11139i = new okio.d();
        }

        private final void l(long r10) {
            d r11 = this.f11141k;
            if (hc.e.f9283g == true) goto L5;
        L9:
            this.f11141k.g().u0(r10);
            return;
        L5:
            if (Thread.holdsLock(r11) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r11);
        }

        @Override // okio.f0
        public long S(okio.d r18, long r19) {
            Intrinsics.checkNotNullParameter(r18, "sink");
            long r10 = 0;
            if (r19 < 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L52;
        L7:
            IOException r12 = null;
            d r13 = this.f11141k;
            monitor-enter(r13);
            r13.m().v();     // Catch: Throwable -> L48
        L45:
            th = move-exception;
            r13.m().C();     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L11:
            if (r13.h() == null) goto L18;
            if (this.f11137g == true) goto L18;
            r12 = r13.i();     // Catch: Throwable -> L45
            if (r12 != null) goto L18;
            ErrorCode r14 = r13.h();     // Catch: Throwable -> L45
            Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L45
            r12 = new StreamResetException(r14);     // Catch: Throwable -> L45
        L18:
            if (this.f11140j == true) goto L44;
            if (this.f11139i.M() <= r10) goto L27;
            okio.d r15 = this.f11139i;     // Catch: Throwable -> L45
            long r16 = r15.S(r18, Math.min(r19, r15.M()));     // Catch: Throwable -> L45
            r13.A(r13.l() + r16);     // Catch: Throwable -> L45
            long r17 = r13.l() - r13.k();     // Catch: Throwable -> L45
            if (r12 == null) goto L24;
        L32:
            boolean r20 = false;
        L33:
            r13.m().C();     // Catch: Throwable -> L48
            Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r13);
            if (r20 == false) goto L38;
            r10 = 0;
            goto L7
        L38:
            if (r16 == (-1)) goto L40;
            return r16;
        L40:
            if (r12 != null) goto L42;
            return -1;
        L42:
            throw r12;
        L24:
            if (r17 < (r13.g().V().c() / 2)) goto L32;
            r13.g().A0(r13.j(), r17);     // Catch: Throwable -> L45
            r13.z(r13.l());     // Catch: Throwable -> L45
            goto L32
        L27:
            if (this.f11137g == true) goto L31;
            if (r12 != null) goto L31;
            r13.D();     // Catch: Throwable -> L45
            r16 = -1;
            r20 = true;
        L31:
            r16 = -1;
            goto L32
        L44:
            throw new IOException("stream closed");     // Catch: Throwable -> L45
        L48:
            th = move-exception;
            throw th;
        L52:
            throw new IllegalArgumentException(("byteCount < 0: " + r19).toString());
        L5:
            r11 = false;
            goto L6
        }

        public final boolean a() {
            return this.f11140j;
        }

        public final boolean c() {
            return this.f11137g;
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d r10 = this.f11141k;
            monitor-enter(r10);
            this.f11140j = true;     // Catch: Throwable -> L12
            long r11 = this.f11139i.M();     // Catch: Throwable -> L12
            this.f11139i.f();     // Catch: Throwable -> L12
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
            r10.notifyAll();     // Catch: Throwable -> L12
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r10);
            if (r11 <= 0) goto L10;
            l(r11);
        L10:
            this.f11141k.b();
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public final void f(okio.f r12, long r13) {
            Intrinsics.checkNotNullParameter(r12, "source");
            d r10 = this.f11141k;
            if (hc.e.f9283g == true) goto L5;
        L9:
            long r11 = r13;
        L11:
            if (r11 <= 0) goto L50;
            d r14 = this.f11141k;
            monitor-enter(r14);
            boolean r15 = this.f11137g;     // Catch: Throwable -> L47
            boolean r16 = true;
            if ((this.f11139i.M() + r11) <= this.f11136c) goto L17;
            boolean r17 = true;
        L18:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L47
            monitor-exit(r14);
            if (r17 == true) goto L21;
            if (r15 == true) goto L24;
            long r19 = r12.S(this.f11138h, r11);
            if (r19 == (-1)) goto L46;
            r11 = r11 - r19;
            d r20 = this.f11141k;
            monitor-enter(r20);
            if (this.f11140j == false) goto L34;
            this.f11138h.f();     // Catch: Throwable -> L42
        L40:
            monitor-exit(r20);
            goto L11
        L34:
            if (this.f11139i.M() == 0) goto L37;
            r16 = false;
        L37:
            this.f11139i.y(this.f11138h);     // Catch: Throwable -> L42
            if (r16 == false) goto L40;
            Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L42
            r20.notifyAll();     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            throw th;
        L46:
            throw new EOFException();
        L24:
            r12.skip(r11);
            return;
        L21:
            r12.skip(r11);
            this.f11141k.f(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        L17:
            r17 = false;
        L47:
            th = move-exception;
            throw th;
        L50:
            l(r13);
            return;
        L5:
            if (Thread.holdsLock(r10) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r10);
        }

        public final void i(boolean r10) {
            this.f11137g = r10;
        }

        public final void k(r r10) {
        }

        @Override // okio.f0
        public g0 timeout() {
            return this.f11141k.m();
        }
    }

    /* JADX INFO: renamed from: mc.d$d, reason: collision with other inner class name */
    public final class C0243d extends okio.c {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ d f11142n;

        public C0243d(d r10) {
            this.f11142n = r10;
        }

        @Override // okio.c
        protected void B() {
            this.f11142n.f(ErrorCode.CANCEL);
            this.f11142n.g().o0();
        }

        public final void C() {
            if (w() == true) goto L6;
            return;
        L6:
            throw x(null);
        }

        @Override // okio.c
        protected IOException x(IOException r10) {
            SocketTimeoutException r11 = new SocketTimeoutException("timeout");
            if (r10 == null) goto L5;
            r11.initCause(r10);
        L5:
            return r11;
        }
    }

    static {
        new a(null);
    }

    public d(int r10, okhttp3.internal.http2.b r11, boolean r12, boolean r13, r r14) {
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION);
        this.f11117a = r10;
        this.f11118b = r11;
        this.f11122f = r11.X().c();
        ArrayDeque<r> r15 = new ArrayDeque();
        this.f11123g = r15;
        this.f11125i = new c(this, r11.V().c(), r13);
        this.f11126j = new b(this, r12);
        this.f11127k = new C0243d(this);
        this.f11128l = new C0243d(this);
        boolean r16 = t();
        if (r14 != null) goto L5;
        if (r16 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException("remotely-initiated streams should have headers".toString());
    L5:
        if ((!r16) == false) goto L8;
        r15.add(r14);
        return;
    L8:
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
    }

    private final boolean e(ErrorCode r10, IOException r11) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L12:
        if (this.f11129m == null) goto L15;
        monitor-exit(this);
        return false;
    L15:
        this.f11129m = r10;     // Catch: Throwable -> L25
        this.f11130n = r11;     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L25
        notifyAll();     // Catch: Throwable -> L25
        if (this.f11125i.c() == true) goto L18;
    L21:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
        this.f11118b.n0(this.f11117a);
        return true;
    L18:
        if (this.f11126j.f() == false) goto L21;
        monitor-exit(this);
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void A(long r10) {
        this.f11119c = r10;
    }

    public final void B(long r10) {
        this.f11121e = r10;
    }

    public final synchronized r C() {
        monitor-enter(this);
        this.f11127k.v();     // Catch: Throwable -> L23
    L26:
    L20:
        th = move-exception;
        this.f11127k.C();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L5:
        if (this.f11123g.isEmpty() == false) goto L10;
        if (this.f11129m != null) goto L10;
        D();     // Catch: Throwable -> L20
    L10:
        this.f11127k.C();     // Catch: Throwable -> L23
        if ((!this.f11123g.isEmpty()) == false) goto L15;
        r r10 = this.f11123g.removeFirst();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r10, "headersQueue.removeFirst()");     // Catch: Throwable -> L23
        r r11 = r10;     // Catch: Throwable -> L23
        monitor-exit(this);
        return r11;
    L15:
        IOException r12 = this.f11130n;     // Catch: Throwable -> L23
        if (r12 != null) goto L32;
        ErrorCode r13 = this.f11129m;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L23
        throw new StreamResetException(r13);     // Catch: Throwable -> L23
    L32:
        throw r12;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final void D() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: InterruptedException -> L4
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }

    public final g0 E() {
        return this.f11128l;
    }

    public final void a(long r10) {
        this.f11122f += r10;
        if (r10 <= 0) goto L6;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return;
    }

    public final void b() {
        if (hc.e.f9283g == true) goto L5;
    L9:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L11:
        if (this.f11125i.c() == false) goto L13;
    L19:
        boolean r10 = false;
    L20:
        boolean r11 = u();     // Catch: Throwable -> L27
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        if (r10 == false) goto L24;
        d(ErrorCode.CANCEL, null);
        return;
    L24:
        if (r11 == true) goto L33;
        this.f11118b.n0(this.f11117a);
        return;
    L33:
        return;
    L13:
        if (this.f11125i.a() == false) goto L19;
        if (this.f11126j.f() == false) goto L17;
    L18:
        r10 = true;
        goto L20
    L17:
        if (this.f11126j.c() == false) goto L19;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void c() {
        if (this.f11126j.c() == true) goto L17;
        if (this.f11126j.f() == true) goto L15;
        if (this.f11129m == null) goto L13;
        IOException r10 = this.f11130n;
        if (r10 != null) goto L18;
        ErrorCode r11 = this.f11129m;
        Intrinsics.checkNotNull(r11);
        throw new StreamResetException(r11);
    L18:
        throw r10;
    L13:
        return;
    L15:
        throw new IOException("stream finished");
    L17:
        throw new IOException("stream closed");
    }

    public final void d(ErrorCode r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r10, "rstStatusCode");
        if (e(r10, r11) == true) goto L5;
        return;
    L5:
        this.f11118b.y0(this.f11117a, r10);
    }

    public final void f(ErrorCode r10) {
        Intrinsics.checkNotNullParameter(r10, "errorCode");
        if (e(r10, null) == true) goto L5;
        return;
    L5:
        this.f11118b.z0(this.f11117a, r10);
    }

    public final okhttp3.internal.http2.b g() {
        return this.f11118b;
    }

    public final synchronized ErrorCode h() {
        monitor-enter(this);
        ErrorCode r10 = this.f11129m;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final IOException i() {
        return this.f11130n;
    }

    public final int j() {
        return this.f11117a;
    }

    public final long k() {
        return this.f11120d;
    }

    public final long l() {
        return this.f11119c;
    }

    public final C0243d m() {
        return this.f11127k;
    }

    public final d0 n() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f11124h == false) goto L6;
    L9:
        boolean r10 = true;
    L10:
        if (r10 == false) goto L16;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return this.f11126j;
    L16:
        throw new IllegalStateException("reply before requesting the sink".toString());     // Catch: Throwable -> L17
    L6:
        if (t() == true) goto L9;
        r10 = false;
        goto L10
    }

    public final b o() {
        return this.f11126j;
    }

    public final c p() {
        return this.f11125i;
    }

    public final long q() {
        return this.f11122f;
    }

    public final long r() {
        return this.f11121e;
    }

    public final C0243d s() {
        return this.f11128l;
    }

    public final boolean t() {
        if ((this.f11117a & 1) != 1) goto L5;
        boolean r10 = true;
    L7:
        if (this.f11118b.K() != r10) goto L10;
        return true;
    L10:
        return false;
    L5:
        r10 = false;
        goto L7
    }

    public final synchronized boolean u() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.f11129m == null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.f11125i.c() == true) goto L13;
        if (this.f11125i.a() == true) goto L13;
    L21:
        monitor-exit(this);
        return true;
    L13:
        if (this.f11126j.f() == false) goto L15;
    L16:
        if (this.f11124h == false) goto L21;
        monitor-exit(this);
        return false;
    L15:
        if (this.f11126j.c() == false) goto L21;
        goto L16
    }

    public final g0 v() {
        return this.f11127k;
    }

    public final void w(okio.f r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if (hc.e.f9283g == true) goto L5;
    L9:
        this.f11125i.f(r10, r11);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void x(r r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "headers");
        if (hc.e.f9283g == true) goto L5;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.f11124h == false) goto L15;
        if (r11 == false) goto L15;
        this.f11125i.k(r10);     // Catch: Throwable -> L23
    L16:
        if (r11 == false) goto L18;
        this.f11125i.i(true);     // Catch: Throwable -> L23
    L18:
        boolean r12 = u();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L23
        notifyAll();     // Catch: Throwable -> L23
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r12 == true) goto L28;
        this.f11118b.n0(this.f11117a);
        return;
    L28:
        return;
    L15:
        this.f11124h = true;     // Catch: Throwable -> L23
        this.f11123g.add(r10);     // Catch: Throwable -> L23
        goto L16
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final synchronized void y(ErrorCode r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "errorCode");     // Catch: Throwable -> L8
        if (this.f11129m != null) goto L6;
        this.f11129m = r10;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void z(long r10) {
        this.f11120d = r10;
    }
}
