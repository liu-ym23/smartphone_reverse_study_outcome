package kotlinx.coroutines.scheduling;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.an;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0016\u0010#\u001a\u0004\u0018\u00010\u00072\n\u0010$\u001a\u00060\tj\u0002`%H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\"\u0010(\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+J$\u0010,\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+H\u0002J\u000e\u0010-\u001a\u00020\u0018*\u0004\u0018\u00010\u0007H\u0002R\t\u0010\u0003\u001a\u00020\u0004X\u0082\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\t\u0010\f\u001a\u00020\u0004X\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eX\u0082\u0004R\t\u0010\u000f\u001a\u00020\u0004X\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006."}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "blockingTasksInBuffer", "Lkotlinx/atomicfu/AtomicInt;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize", "()I", "consumerIndex", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "size", "getSize$kotlinx_coroutines_core", "add", "task", "fair", "", "addLast", "offloadAllWorkTo", "", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "poll", "pollBlocking", "pollBuffer", "pollCpu", "pollTo", "queue", "pollWithExclusiveMode", "onlyBlocking", "stealWithExclusiveMode", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryExtractFromTheMiddle", "index", "trySteal", "", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "tryStealLastScheduled", "decrementIfBlocking", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17626b = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater c = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<g> f17627a;
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        f17626b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask$volatile");
        c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex$volatile");
        d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex$volatile");
        e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer$volatile");
    }

    public m() {
        this.f17627a = new AtomicReferenceArray(128);
    }

    private final g a(int r5) {
        int r0 = h().get(this);
        int r1 = g().get(this);
        boolean r2 = true;
        if (r5 == 1) goto L7;
        r2 = false;
    L7:
        if (r0 == r1) goto L16;
        if (r2 == true) goto L10;
    L12:
        int r6 = r0 + 1;
        g r3 = a(r0, r2);
        if (r3 != null) goto L15;
        r0 = r6;
        goto L7
    L15:
        return r3;
    L10:
        if (i().get(this) != 0) goto L12;
        return null;
    L16:
        return null;
    }

    private final g a(int r5, boolean r6) {
        int r7 = r5 & 127;
        g r0 = (g) ZeusTransformUtils.preCheckCast(this.f17627a.get(r7), g.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
        boolean r3 = true;
        if (r0.g.a() == 1) goto L8;
        r3 = false;
    L8:
        if (r3 != r6) goto L14;
        if (this.f17627a.compareAndSet(r7, r0, null) == false) goto L14;
        if (r6 == false) goto L13;
        i().decrementAndGet(this);
    L13:
        return r0;
    L14:
        return null;
    }

    private final g a(g r4) {
        if (d() != 127) goto L5;
        return r4;
    L5:
        boolean r2 = true;
        if (r4.g.a() == 1) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L11;
        i().incrementAndGet(this);
    L11:
        int r0 = g().get(this) & 127;
    L13:
        if (this.f17627a.get(r0) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.f17627a.lazySet(r0, r4);
        g().incrementAndGet(this);
        return null;
    }

    private final g a(boolean r5) {
    L2:
        g r0 = (g) ZeusTransformUtils.preCheckCast(f().get(this), g.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        boolean r3 = true;
        if (r0.g.a() == 1) goto L9;
        r3 = false;
    L9:
        if (r3 != r5) goto L13;
        if (f().compareAndSet(this, r0, null) == false) goto L2;
        return r0;
    L13:
        int r1 = h().get(this);
        int r2 = g().get(this);
    L14:
        if (r1 == r2) goto L22;
        if (r5 == true) goto L17;
    L19:
        r2 = r2 - 1;
        g r4 = a(r2, r5);
        if (r4 == null) goto L14;
        return r4;
    L17:
        if (i().get(this) != 0) goto L19;
        return null;
    L22:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.g] */
    private final long b(int r6, Ref.ObjectRef<g> r7) {
    L2:
        ?? r0 = (g) ZeusTransformUtils.preCheckCast(f().get(this), g.class, "com.obric.memorydata.plugin");
        if (r0 == 0) goto L4;
        int r4 = 1;
        if (r0.g.a() != 1) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r4 = 2;
    L13:
        if ((r4 & r6) == 0) goto L14;
        long r1 = k.f.a() - r0.f;
        if (r1 < k.f17624b) goto L18;
        if (f().compareAndSet(this, r0, null) == false) goto L2;
        r7.element = r0;
        return -1;
    L18:
        return k.f17624b - r1;
    L14:
        return -2;
    L8:
        r3 = false;
        goto L9
    L4:
        return -2;
    }

    private final void b(g r3) {
        if (r3 == null) goto L16;
        boolean r0 = false;
        if (r3.g.a() != 1) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L17;
        int r2 = i().decrementAndGet(this);
        if (an.a() == false) goto L18;
        if (r2 < 0) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        throw new AssertionError();
    L18:
        return;
    L17:
        return;
    L6:
        r4 = false;
        goto L7
    }

    private final boolean b(c r1) {
        g r0 = e();
        if (r0 != null) goto L6;
        return false;
    L6:
        r1.a(r0);
        return true;
    }

    private final int d() {
        return g().get(this) - h().get(this);
    }

    private final g e() {
    L2:
        int r0 = h().get(this);
        if ((r0 - g().get(this)) == 0) goto L4;
        int r1 = r0 & 127;
        if (h().compareAndSet(this, r0, r0 + 1) == false) goto L2;
        g r2 = (g) ZeusTransformUtils.preCheckCast(this.f17627a.getAndSet(r1, null), g.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L2;
        b(r2);
        return r2;
    L4:
        return null;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater f() {
        return f17626b;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater g() {
        return c;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater h() {
        return d;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater i() {
        return e;
    }

    public final int a() {
        Object r0 = f().get(this);
        int r1 = d();
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(int r2, Ref.ObjectRef<g> r3) {
        if (r2 != 3) goto L5;
        T r0 = e();
    L6:
        if (r0 == 0) goto L10;
        r3.element = r0;
        return -1;
    L10:
        return b(r2, r3);
    L5:
        r0 = a(r2);
        goto L6
    }

    public final g a(g r2, boolean r3) {
        if (r3 == true) goto L4;
        g r4 = (g) ZeusTransformUtils.preCheckCast(f().getAndSet(this, r2), g.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return null;
    L10:
        return a(r4);
    L4:
        return a(r2);
    }

    public final void a(c r4) {
        g r0 = (g) ZeusTransformUtils.preCheckCast(f().getAndSet(this, null), g.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r4.a(r0);
    L6:
        if (b(r4) == true) goto L6;
    }

    public final g b() {
        g r0 = (g) ZeusTransformUtils.preCheckCast(f().getAndSet(this, null), g.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e();
    }

    public final g c() {
        return a(true);
    }
}
