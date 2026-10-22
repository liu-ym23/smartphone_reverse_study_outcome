package okio;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFileHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileHandle.kt\nokio/FileHandle\n+ 2 -JvmPlatform.kt\nokio/_JvmPlatformKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 5 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 6 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,444:1\n33#2:445\n33#2:447\n33#2:448\n33#2:449\n33#2:450\n33#2:451\n33#2:452\n33#2:453\n33#2:457\n33#2:459\n1#3:446\n62#4:454\n62#4:455\n62#4:456\n51#5:458\n86#6:460\n86#6:461\n*S KotlinDebug\n*F\n+ 1 FileHandle.kt\nokio/FileHandle\n*L\n69#1:445\n81#1:447\n92#1:448\n105#1:449\n119#1:450\n129#1:451\n139#1:452\n151#1:453\n221#1:457\n287#1:459\n169#1:454\n195#1:455\n202#1:456\n248#1:458\n345#1:460\n374#1:461\n*E\n"})
public abstract class g implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12208c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ReentrantLock f12210h;

    @SourceDebugExtension({"SMAP\nFileHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileHandle.kt\nokio/FileHandle$FileHandleSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 -JvmPlatform.kt\nokio/_JvmPlatformKt\n*L\n1#1,444:1\n1#2:445\n33#3:446\n*S KotlinDebug\n*F\n+ 1 FileHandle.kt\nokio/FileHandle$FileHandleSource\n*L\n436#1:446\n*E\n"})
    private static final class a implements f0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f12211c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f12212g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12213h;

        public a(g r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "fileHandle");
            this.f12211c = r10;
            this.f12212g = r11;
        }

        @Override // okio.f0
        public long S(d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if ((!this.f12213h) == false) goto L9;
            long r12 = g.f(this.f12211c, this.f12212g, r10, r11);
            if (r12 == (-1)) goto L7;
            this.f12212g += r12;
        L7:
            return r12;
        L9:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f12213h == false) goto L5;
            return;
        L5:
            this.f12213h = true;
            ReentrantLock r10 = this.f12211c.k();
            r10.lock();
            g r11 = this.f12211c;     // Catch: Throwable -> L16
            g.i(r11, g.c(r11) - 1);     // Catch: Throwable -> L16
            if (g.c(this.f12211c) == 0) goto L9;
        L14:
            r10.unlock();
            return;
        L9:
            if (g.a(this.f12211c) == false) goto L14;
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
            r10.unlock();
            this.f12211c.l();
            return;
        L16:
            th = move-exception;
            r10.unlock();
            throw th;
        }

        @Override // okio.f0
        public g0 timeout() {
            return g0.f12214d;
        }
    }

    public g(boolean r10) {
        this.f12210h = j0.b();
    }

    public static final /* synthetic */ boolean a(g r10) {
        return r10.f12208c;
    }

    public static final /* synthetic */ int c(g r10) {
        return r10.f12209g;
    }

    public static final /* synthetic */ long f(g r10, long r11, d r12, long r13) {
        return r10.r(r11, r12, r13);
    }

    public static final /* synthetic */ void i(g r10, int r11) {
        r10.f12209g = r11;
    }

    private final long r(long r16, d r18, long r19) {
        if (r19 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L23;
        long r11 = r16 + r19;
        long r12 = r16;
    L9:
        if (r12 >= r11) goto L21;
        b0 r13 = r18.Q(1);
        byte[] r14 = r13.f12172a;
        int r15 = r13.f12174c;
        int r17 = o(r12, r14, r15, (int) Math.min(r11 - r12, 8192 - r15));
        if (r17 == (-1)) goto L13;
        r13.f12174c += r17;
        long r20 = r17;
        r12 = r12 + r20;
        r18.K(r18.M() + r20);
        goto L9
    L13:
        if (r13.f12173b != r13.f12174c) goto L16;
        r18.f12197c = r13.b();
        c0.b(r13);
    L16:
        if (r16 != r12) goto L21;
        return -1;
    L21:
        return r12 - r16;
    L23:
        throw new IllegalArgumentException(("byteCount < 0: " + r19).toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock r10 = this.f12210h;
        r10.lock();
    L15:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if (this.f12208c == false) goto L8;
        r10.unlock();
        return;
    L8:
        this.f12208c = true;     // Catch: Throwable -> L15
        if (this.f12209g == 0) goto L12;
        r10.unlock();
        return;
    L12:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r10.unlock();
        l();
    }

    public final ReentrantLock k() {
        return this.f12210h;
    }

    protected abstract void l();

    protected abstract int o(long r10, byte[] r11, int r12, int r13);

    protected abstract long p();

    public final long s() {
        ReentrantLock r10 = this.f12210h;
        r10.lock();
    L10:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if ((!this.f12208c) == false) goto L9;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r10.unlock();
        return p();
    L9:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L10
    }

    public final f0 u(long r10) {
        ReentrantLock r11 = this.f12210h;
        r11.lock();
    L10:
        th = move-exception;
        r11.unlock();
        throw th;
    L4:
        if ((!this.f12208c) == false) goto L9;
        this.f12209g++;     // Catch: Throwable -> L10
        r11.unlock();
        return new a(this, r10);
    L9:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L10
    }
}
