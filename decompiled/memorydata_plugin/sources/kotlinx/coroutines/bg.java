package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0010J\u0010\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\nH\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "limitedParallelism", "parallelism", "", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class bg extends ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f17232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17233b;
    private ArrayDeque<ax<?>> c;

    public bg() {
    }

    public static /* synthetic */ void a(bg r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.a(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void b(bg r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.b(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long c(boolean r1) {
        if (r1 == false) goto L4;
        return 4294967296L;
    L4:
        return 1;
    }

    public final void a(ax<?> r2) {
        ArrayDeque<ax<?>> r0 = this.c;
        if (r0 != null) goto L5;
        r0 = new ArrayDeque();
        this.c = r0;
    L5:
        r0.addLast(r2);
    }

    public final void a(boolean r5) {
        this.f17232a += c(r5);
        if (r5 == true) goto L6;
        this.f17233b = true;
        return;
    }

    public void b() {
    }

    public final void b(boolean r5) {
        long r0 = this.f17232a - c(r5);
        this.f17232a = r0;
        if (r0 <= 0) goto L6;
        return;
    L6:
        if (an.a() == false) goto L16;
        if (this.f17232a != 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L16;
        throw new AssertionError();
    L10:
        r6 = false;
    L16:
        if (this.f17233b == false) goto L19;
        b();
        return;
    }

    public long c() {
        if (f() == true) goto L6;
        return Long.MAX_VALUE;
    L6:
        return 0;
    }

    public boolean d() {
        return i();
    }

    public long e() {
        ArrayDeque<ax<?>> r2 = this.c;
        if (r2 != null) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r2.isEmpty() == true) goto L10;
        return 0;
    L10:
        return Long.MAX_VALUE;
    }

    public final boolean f() {
        ArrayDeque<ax<?>> r3 = this.c;
        if (r3 != null) goto L5;
        return false;
    L5:
        ax r4 = (ax) ZeusTransformUtils.preCheckCast(r3.removeFirstOrNull(), ax.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        return false;
    L8:
        r4.run();
        return true;
    }

    public boolean g() {
        return false;
    }

    public final boolean h() {
        if (this.f17232a >= c(true)) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean i() {
        ArrayDeque<ax<?>> r0 = this.c;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isEmpty();
    }

    @Override // kotlinx.coroutines.ah
    public final ah limitedParallelism(int r2) {
        kotlinx.coroutines.internal.s.a(r2);
        return (ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin");
    }
}
