package gc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f9119b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f9120c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f9121d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f9122e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<g> f9123a;

    @Volatile
    private volatile int blockingTasksInBuffer;

    @Volatile
    private volatile int consumerIndex;

    @Volatile
    private volatile Object lastScheduledTask;

    @Volatile
    private volatile int producerIndex;

    static {
        f9119b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");
        f9120c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
        f9121d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
        f9122e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");
    }

    public m() {
        this.f9123a = new AtomicReferenceArray(128);
    }

    private final g b(g r10) {
        if (d() != 127) goto L5;
        return r10;
    L5:
        boolean r11 = true;
        if (r10.f9107g.b() == 1) goto L9;
        r11 = false;
    L9:
        if (r11 == false) goto L11;
        f9122e.incrementAndGet(this);
    L11:
        int r12 = f9120c.get(this) & 127;
    L13:
        if (this.f9123a.get(r12) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.f9123a.lazySet(r12, r10);
        f9120c.incrementAndGet(this);
        return null;
    }

    private final void c(g r10) {
        if (r10 == null) goto L16;
        boolean r11 = false;
        if (r10.f9107g.b() != 1) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L17;
        int r13 = f9122e.decrementAndGet(this);
        if (n0.a() == false) goto L18;
        if (r13 < 0) goto L12;
        r11 = true;
    L12:
        if (r11 == false) goto L15;
        return;
    L15:
        throw new AssertionError();
    L18:
        return;
    L17:
        return;
    L6:
        r12 = false;
        goto L7
    }

    private final int d() {
        return f9120c.get(this) - f9121d.get(this);
    }

    private final g i() {
    L2:
        AtomicIntegerFieldUpdater r10 = f9121d;
        int r11 = r10.get(this);
        if ((r11 - f9120c.get(this)) == 0) goto L4;
        int r12 = r11 & 127;
        if (r10.compareAndSet(this, r11, r11 + 1) == false) goto L2;
        g r13 = this.f9123a.getAndSet(r12, null);
        if (r13 == null) goto L2;
        c(r13);
        return r13;
    L4:
        return null;
    }

    private final boolean j(c r10) {
        g r11 = i();
        if (r11 != null) goto L6;
        return false;
    L6:
        r10.a(r11);
        return true;
    }

    private final g k(boolean r10) {
    L2:
        AtomicReferenceFieldUpdater r11 = f9119b;
        g r12 = (g) r11.get(this);
        if (r12 == null) goto L13;
        boolean r13 = true;
        if (r12.f9107g.b() == 1) goto L9;
        r13 = false;
    L9:
        if (r13 != r10) goto L13;
        if (r11.compareAndSet(this, r12, null) == false) goto L2;
        return r12;
    L13:
        int r14 = f9121d.get(this);
        int r15 = f9120c.get(this);
    L14:
        if (r14 == r15) goto L22;
        if (r10 == true) goto L17;
    L19:
        r15 = r15 - 1;
        g r16 = m(r15, r10);
        if (r16 == null) goto L14;
        return r16;
    L17:
        if (f9122e.get(this) != 0) goto L19;
        return null;
    L22:
        return null;
    }

    private final g l(int r10) {
        int r11 = f9121d.get(this);
        int r12 = f9120c.get(this);
        boolean r13 = true;
        if (r10 == 1) goto L7;
        r13 = false;
    L7:
        if (r11 == r12) goto L16;
        if (r13 == true) goto L10;
    L12:
        int r14 = r11 + 1;
        g r15 = m(r11, r13);
        if (r15 != null) goto L15;
        r11 = r14;
        goto L7
    L15:
        return r15;
    L10:
        if (f9122e.get(this) != 0) goto L12;
        return null;
    L16:
        return null;
    }

    private final g m(int r10, boolean r11) {
        int r12 = r10 & 127;
        g r13 = this.f9123a.get(r12);
        if (r13 == null) goto L14;
        boolean r14 = true;
        if (r13.f9107g.b() == 1) goto L8;
        r14 = false;
    L8:
        if (r14 != r11) goto L14;
        if (this.f9123a.compareAndSet(r12, r13, null) == false) goto L14;
        if (r11 == false) goto L13;
        f9122e.decrementAndGet(this);
    L13:
        return r13;
    L14:
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, gc.g, java.lang.Object] */
    private final long o(int r10, Ref.ObjectRef<g> r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = f9119b;
        ?? r13 = (g) r12.get(this);
        if (r13 == 0) goto L4;
        int r14 = 1;
        if (r13.f9107g.b() != 1) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == true) goto L13;
        r14 = 2;
    L13:
        if ((r14 & r10) == 0) goto L14;
        long r16 = k.f9115f.a() - r13.f9106c;
        long r17 = k.f9111b;
        if (r16 < r17) goto L18;
        if (r12.compareAndSet(this, r13, null) == false) goto L2;
        r11.element = r13;
        return -1;
    L18:
        return r17 - r16;
    L14:
        return -2;
    L8:
        r15 = false;
        goto L9
    L4:
        return -2;
    }

    public final g a(g r10, boolean r11) {
        if (r11 == true) goto L4;
        g r12 = (g) f9119b.getAndSet(this, r10);
        if (r12 != null) goto L10;
        return null;
    L10:
        return b(r12);
    L4:
        return b(r10);
    }

    public final int e() {
        Object r10 = f9119b.get(this);
        int r11 = d();
        if (r10 != null) goto L5;
        return r11;
    L5:
        return r11 + 1;
    }

    public final void f(c r10) {
        g r11 = (g) f9119b.getAndSet(this, null);
        if (r11 == null) goto L6;
        r10.a(r11);
    L6:
        if (j(r10) == true) goto L6;
    }

    public final g g() {
        g r10 = (g) f9119b.getAndSet(this, null);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return i();
    }

    public final g h() {
        return k(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int r10, Ref.ObjectRef<g> r11) {
        if (r10 != 3) goto L5;
        T r12 = i();
    L6:
        if (r12 == 0) goto L10;
        r11.element = r12;
        return -1;
    L10:
        return o(r10, r11);
    L5:
        r12 = l(r10);
        goto L6
    }
}
