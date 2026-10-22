package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
public class c extends g0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f12179h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ReentrantLock f12180i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Condition f12181j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f12182k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f12183l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static c f12184m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f12186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12187g;

    @SourceDebugExtension({"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n1#2:332\n*E\n"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ boolean a(a r10, c r11) {
            return r10.d(r11);
        }

        public static final /* synthetic */ void b(a r10, c r11, long r12, boolean r13) {
            r10.g(r11, r12, r13);
        }

        private final boolean d(c r10) {
            ReentrantLock r11 = c.f12179h.f();
            r11.lock();
        L19:
            th = move-exception;
            r11.unlock();
            throw th;
        L5:
            if (c.m(r10) == true) goto L8;
            r11.unlock();
            return false;
        L8:
            c.s(r10, false);     // Catch: Throwable -> L19
            c r12 = c.j();     // Catch: Throwable -> L19
        L9:
            if (r12 == null) goto L17;
            if (c.o(r12) == r10) goto L12;
            r12 = c.o(r12);     // Catch: Throwable -> L19
            goto L9
        L12:
            c.t(r12, c.o(r10));     // Catch: Throwable -> L19
            c.t(r10, null);     // Catch: Throwable -> L19
            r11.unlock();
            return false;
        L17:
            r11.unlock();
            return true;
        }

        private final void g(c r10, long r11, boolean r12) {
            ReentrantLock r13 = c.f12179h.f();
            r13.lock();
        L34:
            th = move-exception;
            r13.unlock();
            throw th;
        L4:
            if ((!c.m(r10)) == false) goto L33;
            c.s(r10, true);     // Catch: Throwable -> L34
            if (c.j() != null) goto L8;
            c.r(new c());     // Catch: Throwable -> L34
            new b().start();     // Catch: Throwable -> L34
        L8:
            long r14 = System.nanoTime();     // Catch: Throwable -> L34
            if (r11 == 0) goto L13;
            if (r12 == false) goto L13;
            r11 = Math.min(r11, r10.c() - r14);     // Catch: Throwable -> L34
        L12:
            c.u(r10, r11 + r14);     // Catch: Throwable -> L34
        L17:
            long r15 = c.q(r10, r14);     // Catch: Throwable -> L34
            c r16 = c.j();     // Catch: Throwable -> L34
        L18:
            Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L34
            if (c.o(r16) == null) goto L24;
            c r17 = c.o(r16);     // Catch: Throwable -> L34
            Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L34
            if (r15 < c.q(r17, r14)) goto L24;
            r16 = c.o(r16);     // Catch: Throwable -> L34
        L24:
            c.t(r10, c.o(r16));     // Catch: Throwable -> L34
            c.t(r16, r10);     // Catch: Throwable -> L34
            if (r16 != c.j()) goto L27;
            c.f12179h.e().signal();     // Catch: Throwable -> L34
        L27:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L34
            r13.unlock();
            return;
        L13:
            if (r11 != 0) goto L12;
            if (r12 == false) goto L31;
            c.u(r10, r10.c());     // Catch: Throwable -> L34
            goto L17
        L31:
            throw new AssertionError();     // Catch: Throwable -> L34
        L33:
            throw new IllegalStateException("Unbalanced enter/exit".toString());     // Catch: Throwable -> L34
        }

        public final c c() {
            c r10 = c.j();
            Intrinsics.checkNotNull(r10);
            c r11 = c.o(r10);
            long r12 = System.nanoTime();
            if (r11 != null) goto L10;
            e().await(c.k(), TimeUnit.MILLISECONDS);
            c r13 = c.j();
            Intrinsics.checkNotNull(r13);
            if (c.o(r13) == null) goto L7;
            return null;
        L7:
            if ((System.nanoTime() - r12) >= c.l()) goto L9;
            return null;
        L9:
            return c.j();
        L10:
            long r14 = c.q(r11, r12);
            if (r14 <= 0) goto L14;
            e().await(r14, TimeUnit.NANOSECONDS);
            return null;
        L14:
            c r15 = c.j();
            Intrinsics.checkNotNull(r15);
            c.t(r15, c.o(r11));
            c.t(r11, null);
            return r11;
        }

        public final Condition e() {
            return c.i();
        }

        public final ReentrantLock f() {
            return c.n();
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L18:
            a r10 = c.f12179h;     // Catch: InterruptedException -> L15
            ReentrantLock r11 = r10.f();     // Catch: InterruptedException -> L15
            r11.lock();     // Catch: InterruptedException -> L15
            c r12 = r10.c();     // Catch: Throwable -> L12
            if (r12 != c.j()) goto L8;
            c.r(null);     // Catch: Throwable -> L12
            goto L18
        L6:
            r11.unlock();     // Catch: InterruptedException -> L15
            return;
        L8:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
            r11.unlock();     // Catch: InterruptedException -> L15
            if (r12 == null) goto L18;
            r12.B();     // Catch: InterruptedException -> L15
        L12:
            th = move-exception;
            r11.unlock();     // Catch: InterruptedException -> L15
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    /* JADX INFO: renamed from: okio.c$c, reason: collision with other inner class name */
    @SourceDebugExtension({"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$sink$1\n+ 2 AsyncTimeout.kt\nokio/AsyncTimeout\n*L\n1#1,331:1\n146#2,11:332\n146#2,11:343\n146#2,11:354\n*S KotlinDebug\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$sink$1\n*L\n102#1:332,11\n108#1:343,11\n112#1:354,11\n*E\n"})
    public static final class C0273c implements d0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f12188c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d0 f12189g;

        C0273c(c r10, d0 r11) {
            this.f12188c = r10;
            this.f12189g = r11;
        }

        public c a() {
            return this.f12188c;
        }

        @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c r10 = this.f12188c;
            d0 r11 = this.f12189g;
            r10.v();
            r11.close();     // Catch: Throwable -> L9 IOException -> L11
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r10.w() == true) goto L8;
            return;
        L8:
            throw r10.p(null);
        L9:
            th = move-exception;
            r10.w();
            throw th;
        L11:
            e = move-exception;
            if (r10.w() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r10.p(e);     // Catch: Throwable -> L9
        }

        @Override // okio.d0, java.io.Flushable
        public void flush() {
            c r10 = this.f12188c;
            d0 r11 = this.f12189g;
            r10.v();
            r11.flush();     // Catch: Throwable -> L9 IOException -> L11
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r10.w() == true) goto L8;
            return;
        L8:
            throw r10.p(null);
        L9:
            th = move-exception;
            r10.w();
            throw th;
        L11:
            e = move-exception;
            if (r10.w() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r10.p(e);     // Catch: Throwable -> L9
        }

        @Override // okio.d0
        public /* bridge */ /* synthetic */ g0 timeout() {
            return a();
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f12189g + ')';
        }

        @Override // okio.d0
        public void x(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            okio.b.b(r10.M(), 0, r11);
        L3:
            long r12 = 0;
            if (r11 <= 0) goto L29;
            b0 r13 = r10.f12197c;
        L6:
            Intrinsics.checkNotNull(r13);
            if (r12 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L12;
            r12 = r12 + ((long) (r13.f12174c - r13.f12173b));
            if (r12 >= r11) goto L10;
            r13 = r13.f12177f;
            goto L6
        L10:
            r12 = r11;
        L12:
            c r14 = this.f12188c;
            d0 r15 = this.f12189g;
            r14.v();
            r15.x(r10, r12);     // Catch: Throwable -> L19 IOException -> L21
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19 IOException -> L21
        L15:
            if (r14.w() == true) goto L18;
            r11 = r11 - r12;
            goto L3
        L18:
            throw r14.p(null);
        L19:
            th = move-exception;
            r14.w();
            throw th;
        L21:
            e = move-exception;
            if (r14.w() == true) goto L26;
            throw e;     // Catch: Throwable -> L19
        L26:
            throw r14.p(e);     // Catch: Throwable -> L19
        }
    }

    @SourceDebugExtension({"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$source$1\n+ 2 AsyncTimeout.kt\nokio/AsyncTimeout\n*L\n1#1,331:1\n146#2,11:332\n146#2,11:343\n*S KotlinDebug\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$source$1\n*L\n128#1:332,11\n132#1:343,11\n*E\n"})
    public static final class d implements f0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f12190c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f0 f12191g;

        d(c r10, f0 r11) {
            this.f12190c = r10;
            this.f12191g = r11;
        }

        @Override // okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            c r12 = this.f12190c;
            f0 r13 = this.f12191g;
            r12.v();
            long r14 = r13.S(r10, r11);     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r12.w() == true) goto L8;
            return r14;
        L8:
            throw r12.p(null);
        L11:
            e = move-exception;
            if (r12.w() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r12.p(e);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r12.w();
            throw th;
        }

        public c a() {
            return this.f12190c;
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c r10 = this.f12190c;
            f0 r11 = this.f12191g;
            r10.v();
            r11.close();     // Catch: Throwable -> L9 IOException -> L11
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r10.w() == true) goto L8;
            return;
        L8:
            throw r10.p(null);
        L9:
            th = move-exception;
            r10.w();
            throw th;
        L11:
            e = move-exception;
            if (r10.w() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r10.p(e);     // Catch: Throwable -> L9
        }

        @Override // okio.f0
        public /* bridge */ /* synthetic */ g0 timeout() {
            return a();
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f12191g + ')';
        }
    }

    static {
        f12179h = new a(null);
        ReentrantLock r10 = new ReentrantLock();
        f12180i = r10;
        Condition r11 = r10.newCondition();
        Intrinsics.checkNotNullExpressionValue(r11, "newCondition(...)");
        f12181j = r11;
        long r12 = TimeUnit.SECONDS.toMillis(60);
        f12182k = r12;
        f12183l = TimeUnit.MILLISECONDS.toNanos(r12);
    }

    public c() {
    }

    public static final /* synthetic */ Condition i() {
        return f12181j;
    }

    public static final /* synthetic */ c j() {
        return f12184m;
    }

    public static final /* synthetic */ long k() {
        return f12182k;
    }

    public static final /* synthetic */ long l() {
        return f12183l;
    }

    public static final /* synthetic */ boolean m(c r10) {
        return r10.f12185e;
    }

    public static final /* synthetic */ ReentrantLock n() {
        return f12180i;
    }

    public static final /* synthetic */ c o(c r10) {
        return r10.f12186f;
    }

    public static final /* synthetic */ long q(c r10, long r11) {
        return r10.y(r11);
    }

    public static final /* synthetic */ void r(c r10) {
        f12184m = r10;
    }

    public static final /* synthetic */ void s(c r10, boolean r11) {
        r10.f12185e = r11;
    }

    public static final /* synthetic */ void t(c r10, c r11) {
        r10.f12186f = r11;
    }

    public static final /* synthetic */ void u(c r10, long r11) {
        r10.f12187g = r11;
    }

    private final long y(long r10) {
        return this.f12187g - r10;
    }

    public final f0 A(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        return new d(this, r10);
    }

    protected void B() {
    }

    @PublishedApi
    public final IOException p(IOException r10) {
        return x(r10);
    }

    public final void v() {
        long r10 = h();
        boolean r11 = e();
        if (r10 != 0) goto L6;
        if (r11 == true) goto L6;
        return;
    L6:
        a.b(f12179h, this, r10, r11);
    }

    public final boolean w() {
        return a.a(f12179h, this);
    }

    protected IOException x(IOException r10) {
        InterruptedIOException r11 = new InterruptedIOException("timeout");
        if (r10 == null) goto L5;
        r11.initCause(r10);
    L5:
        return r11;
    }

    public final d0 z(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        return new C0273c(this, r10);
    }
}
