package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public abstract class f1 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10387c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayDeque<w0<?>> f10389h;

    public f1() {
    }

    public static /* synthetic */ void d0(f1 r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.c0(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long e0(boolean r10) {
        if (r10 == false) goto L4;
        return 4294967296L;
    L4:
        return 1;
    }

    public static /* synthetic */ void i0(f1 r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.h0(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void c0(boolean r10) {
        long r11 = this.f10387c - e0(r10);
        this.f10387c = r11;
        if (r11 <= 0) goto L6;
        return;
    L6:
        if (n0.a() == false) goto L16;
        if (this.f10387c != 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L16;
        throw new AssertionError();
    L10:
        r12 = false;
    L16:
        if (this.f10388g == false) goto L19;
        shutdown();
        return;
    }

    public final void f0(w0<?> r10) {
        ArrayDeque<w0<?>> r11 = this.f10389h;
        if (r11 != null) goto L5;
        r11 = new ArrayDeque();
        this.f10389h = r11;
    L5:
        r11.addLast(r10);
    }

    protected long g0() {
        ArrayDeque<w0<?>> r10 = this.f10389h;
        if (r10 != null) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r10.isEmpty() == true) goto L10;
        return 0;
    L10:
        return Long.MAX_VALUE;
    }

    public final void h0(boolean r10) {
        this.f10387c += e0(r10);
        if (r10 == true) goto L6;
        this.f10388g = true;
        return;
    }

    public final boolean j0() {
        if (this.f10387c >= e0(true)) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean k0() {
        ArrayDeque<w0<?>> r10 = this.f10389h;
        if (r10 != null) goto L7;
        return true;
    L7:
        return r10.isEmpty();
    }

    public long l0() {
        if (m0() == true) goto L6;
        return Long.MAX_VALUE;
    L6:
        return 0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r10) {
        kotlinx.coroutines.internal.r.a(r10);
        return this;
    }

    public final boolean m0() {
        ArrayDeque<w0<?>> r10 = this.f10389h;
        if (r10 != null) goto L5;
        return false;
    L5:
        w0<?> r11 = r10.removeFirstOrNull();
        if (r11 != null) goto L8;
        return false;
    L8:
        r11.run();
        return true;
    }

    public boolean n0() {
        return false;
    }

    public void shutdown() {
    }
}
