package kotlinx.coroutines;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002:\u00043456B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aJ\u0014\u0010\u001f\u001a\u00020\u00172\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0014\u0010!\u001a\u00020\f2\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0004J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0002J\u001c\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00132\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aH\u0004J\u001e\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00132\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001700H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010 \u001a\u00020(H\u0002J\b\u00102\u001a\u00020\u0017H\u0016R\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00138TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00067"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_isCompleted", "Lkotlinx/atomicfu/AtomicBoolean;", "_queue", "", EventBody.KEY_VALUE, "", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueue", "task", "enqueueImpl", "processNextEvent", "rescheduleAllDelayed", "resetAll", "schedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "scheduleImpl", "", "scheduleInvokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "shutdown", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class bh extends bi implements at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17235b = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater c = null;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bh f17236a;
        private final n<Unit> c;

        public a(bh r3, long r4, n<? super Unit> r6) {
            n<Unit> r7 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.memorydata.plugin");
            this.f17236a = r3;
            super(r4);
            this.c = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.a((ah) ZeusTransformUtils.preCheckCast(this.f17236a, ah.class, "com.obric.memorydata.plugin"), Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.bh.c
        public String toString() {
            return super.toString() + this.c;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f17237a;

        public b(long r3, Runnable r5) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
            super(r3);
            this.f17237a = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17237a.run();
        }

        @Override // kotlinx.coroutines.bh.c
        public String toString() {
            return super.toString() + this.f17237a;
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "nanoTime", "", "(J)V", "_heap", EventBody.KEY_VALUE, "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class c implements Comparable<c>, Runnable, bc, kotlinx.coroutines.internal.as {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17239b;

        public c(long r1) {
            this.f17239b = r1;
            this.f17238a = -1;
        }

        public final int a(long r9, d r11, bh r12) {
            monitor-enter(this);
        L35:
            th = move-exception;
            throw th;
        L4:
            if (this._heap != bk.b()) goto L8;
            int r10 = 2;
        L6:
            monitor-exit(this);
            return r10;
        L8:
            kotlinx.coroutines.internal.ar r0 = (kotlinx.coroutines.internal.ar) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.internal.ar.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
            monitor-enter(r0);     // Catch: Throwable -> L35
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.e(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
            if (bh.a(r12) == false) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L35
            monitor-exit(this);
            return 1;
        L17:
            if (r1 != null) goto L19;
        L18:
            r11.f17240a = r9;     // Catch: Throwable -> L32
        L27:
            if ((this.f17239b - r11.f17240a) >= 0) goto L29;
            this.f17239b = r11.f17240a;     // Catch: Throwable -> L32
        L29:
            r0.b((kotlinx.coroutines.internal.as) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.internal.as.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
            monitor-exit(r0);     // Catch: Throwable -> L35
            r10 = 0;
            goto L6
        L19:
            long r4 = r1.f17239b;     // Catch: Throwable -> L32
            if ((r4 - r9) >= 0) goto L24;
            r9 = r4;
        L24:
            if ((r9 - r11.f17240a) <= 0) goto L27;
        L32:
            th = move-exception;
            throw th;     // Catch: Throwable -> L35
        }

        public int a(c r3) {
            long r0 = this.f17239b - r3.f17239b;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        @Override // kotlinx.coroutines.internal.as
        public kotlinx.coroutines.internal.ar<?> a() {
            Object r2 = this._heap;
            if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.ar.class) == true) goto L7;
            return null;
        L7:
            return (kotlinx.coroutines.internal.ar) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.ar.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.internal.as
        public void a(int r1) {
            this.f17238a = r1;
        }

        @Override // kotlinx.coroutines.internal.as
        public void a(kotlinx.coroutines.internal.ar<?> r3) {
            if (this._heap == bk.b()) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this._heap = r3;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final boolean a(long r3) {
            if ((r3 - this.f17239b) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.internal.as
        public int b() {
            return this.f17238a;
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(c r3) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.bc
        public final void dispose() {
            monitor-enter(this);
            Object r0 = this._heap;     // Catch: Throwable -> L16
            if (r0 != bk.b()) goto L8;
            monitor-exit(this);
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L10;
            d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        L11:
            if (r1 == null) goto L13;
            r1.a((kotlinx.coroutines.internal.as) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.internal.as.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        L13:
            this._heap = bk.b();     // Catch: Throwable -> L16
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(this);
            return;
        L10:
            r1 = null;
        L16:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f17239b + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class d extends kotlinx.coroutines.internal.ar<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17240a;

        public d(long r1) {
            this.f17240a = r1;
        }
    }

    static {
        f17234a = AtomicReferenceFieldUpdater.newUpdater(bh.class, Object.class, "_queue$volatile");
        f17235b = AtomicReferenceFieldUpdater.newUpdater(bh.class, Object.class, "_delayed$volatile");
        c = AtomicIntegerFieldUpdater.newUpdater(bh.class, "_isCompleted$volatile");
    }

    public bh() {
        this._isCompleted$volatile = 0;
    }

    private final boolean a(c r3) {
        d r2 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2.c(), c.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != r3) goto L8;
        return true;
    L8:
        return false;
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ boolean a(bh r0) {
        return r0.l();
    }

    private final boolean b(Runnable r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r0 = p();
    L3:
        Object r2 = r0.get(this);
        if (l() == true) goto L5;
        if (r2 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.x.class) == true) goto L13;
        if (r2 == bk.a()) goto L24;
        kotlinx.coroutines.internal.x r4 = new kotlinx.coroutines.internal.x(8, true);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r4.a((Runnable) ZeusTransformUtils.preCheckCast(r2, Runnable.class, "com.obric.memorydata.plugin"));
        r4.a(r8);
        if (p().compareAndSet(this, r2, r4) == false) goto L3;
        return true;
    L24:
        return false;
    L13:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        int r5 = ((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).a(r8);
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L17;
        p().compareAndSet(this, r2, ((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).e());
        goto L3
    L17:
        if (r5 != 2) goto L3;
        return false;
    L21:
        return true;
    L9:
        if (p().compareAndSet(this, null, r8) == false) goto L3;
        return true;
    L5:
        return false;
    }

    private final int c(long r6, c r8) {
        if (l() == false) goto L6;
        return 1;
    L6:
        d r0 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        bh r1 = (bh) ZeusTransformUtils.preCheckCast(this, bh.class, "com.obric.memorydata.plugin");
        q().compareAndSet(r1, null, new d(r6));
        Object r2 = q().get(r1);
        Intrinsics.checkNotNull(r2);
        r0 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin");
    L10:
        return r8.a(r6, r0, this);
    }

    private final void c(boolean r2) {
        r().set(this, r2 ? 1 : 0);
    }

    private final boolean l() {
        if (r().get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final Runnable m() {
        AtomicReferenceFieldUpdater r0 = p();
    L3:
        Object r1 = r0.get(this);
        if (r1 == null) goto L5;
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.x.class) == true) goto L8;
        if (r1 == bk.a()) goto L16;
        if (p().compareAndSet(this, r1, null) == false) goto L3;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        Object r5 = ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin");
    L12:
        return (Runnable) r5;
    L16:
        return null;
    L8:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        Object r2 = ((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).d();
        if (r2 != kotlinx.coroutines.internal.x.f17601b) goto L10;
        p().compareAndSet(this, r1, ((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).e());
        goto L3
    L10:
        r5 = ZeusTransformUtils.preCheckCast(r2, Runnable.class, "com.obric.memorydata.plugin");
        goto L12
    L5:
        return null;
    }

    private final void n() {
        if (an.a() == true) goto L5;
    L9:
        AtomicReferenceFieldUpdater r0 = p();
    L10:
        Object r1 = r0.get(this);
        if (r1 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.x.class) == true) goto L17;
        if (r1 == bk.a()) goto L21;
        kotlinx.coroutines.internal.x r2 = new kotlinx.coroutines.internal.x(8, true);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r2.a((Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin"));
        if (p().compareAndSet(this, r1, r2) == false) goto L10;
        return;
    L21:
        return;
    L17:
        ((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).c();
        return;
    L13:
        if (p().compareAndSet(this, null, bk.a()) == false) goto L10;
        return;
    L5:
        if (l() == true) goto L9;
        throw new AssertionError();
    }

    private final void o() {
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L5;
        long r1 = r0.a();
    L6:
        d r2 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.d(), c.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        a(r1, r3);
        goto L6
    L16:
        return;
    L12:
        return;
    L5:
        r1 = System.nanoTime();
        goto L6
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater p() {
        return f17234a;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater q() {
        return f17235b;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater r() {
        return c;
    }

    public final bc a(long r5, Runnable r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        long r6 = bk.a(r5);
        if (r6 >= DurationKt.MAX_MILLIS) goto L9;
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L7;
        long r2 = r0.a();
    L8:
        b r1 = new b(r6 + r2, r8);
        b(r2, (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin"));
        Object r4 = ZeusTransformUtils.preCheckCast(r1, bc.class, "com.obric.memorydata.plugin");
    L11:
        return (bc) r4;
    L7:
        r2 = System.nanoTime();
        goto L8
    L9:
        r4 = ZeusTransformUtils.preCheckCast(cl.f17297a, bc.class, "com.obric.memorydata.plugin");
        goto L11
    }

    public bc a(long r3, Runnable r5, CoroutineContext r6) {
        return at.a.a(this, r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.at
    public void a(long r5, n<? super Unit> r7) {
        n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
        long r6 = bk.a(r5);
        if (r6 >= DurationKt.MAX_MILLIS) goto L10;
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L7;
        long r2 = r0.a();
    L8:
        a r1 = new a(this, r6 + r2, r8);
        b(r2, (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin"));
        q.a(r8, (bc) ZeusTransformUtils.preCheckCast(r1, bc.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        r2 = System.nanoTime();
        goto L8
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (b(r4) == false) goto L5;
        k();
        return;
    L5:
        ap.f17219a.a(r4);
    }

    @Override // kotlinx.coroutines.bg
    public void b() {
        cx.f17302a.c();
        c(true);
        n();
    L4:
        if (c() <= 0) goto L4;
        o();
    }

    public final void b(long r3, c r5) {
        int r0 = c(r3, r5);
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L7;
        a(r3, r5);
        return;
    L7:
        if (r0 != 2) goto L10;
        return;
    L10:
        throw new IllegalStateException("unexpected result".toString());
    L13:
        if (a(r5) == false) goto L17;
        k();
        return;
    }

    @Override // kotlinx.coroutines.bg
    public long c() {
        if (f() == false) goto L5;
        return 0;
    L5:
        d r0 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
    L33:
        Runnable r1 = m();
        if (r1 == null) goto L38;
        r1.run();
        return 0;
    L38:
        return e();
    L8:
        if (r0.b() == true) goto L33;
        kotlinx.coroutines.b r3 = kotlinx.coroutines.c.a();
        if (r3 == null) goto L12;
        long r4 = r3.a();
    L13:
        kotlinx.coroutines.internal.ar r5 = (kotlinx.coroutines.internal.ar) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.ar.class, "com.obric.memorydata.plugin");
        monitor-enter(r5);
        kotlinx.coroutines.internal.as r6 = r5.e();     // Catch: Throwable -> L30
        kotlinx.coroutines.internal.as r7 = null;
        if (r6 != null) goto L20;
    L18:
        monitor-exit(r5);
        if (((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")) != null) goto L13;
    L20:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r8.a(r4) == false) goto L23;
        boolean r9 = b((Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
    L24:
        if (r9 == false) goto L18;
        r7 = r5.a(0);     // Catch: Throwable -> L30
        goto L18
    L23:
        r9 = false;
    L30:
        th = move-exception;
        throw th;
    L12:
        r4 = System.nanoTime();
        goto L13
    }

    @Override // kotlinx.coroutines.bg
    public boolean d() {
        if (i() == true) goto L5;
        return false;
    L5:
        d r0 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
    L10:
        Object r4 = p().get(this);
        if (r4 != null) goto L14;
    L19:
        return true;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, kotlinx.coroutines.internal.x.class) == false) goto L17;
        return ((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).a();
    L17:
        if (r4 == bk.a()) goto L19;
        return false;
    L8:
        if (r0.b() == true) goto L10;
        return false;
    }

    @Override // kotlinx.coroutines.ah
    public final void dispatch(CoroutineContext r3, Runnable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.bg
    public long e() {
        if (super.e() != 0) goto L5;
        return 0;
    L5:
        Object r0 = p().get(this);
        if (r0 != null) goto L8;
    L16:
        d r7 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L27;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7.c(), c.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L27;
        long r1 = r8.f17239b;
        kotlinx.coroutines.b r9 = kotlinx.coroutines.c.a();
        if (r9 == null) goto L24;
        long r4 = r9.a();
    L26:
        return RangesKt.coerceAtLeast(r1 - r4, 0);
    L24:
        r4 = System.nanoTime();
    L27:
        return Long.MAX_VALUE;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.x.class) == false) goto L13;
        if (((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.x.class, "com.obric.memorydata.plugin")).a() == true) goto L16;
        return 0;
    L13:
        if (r0 != bk.a()) goto L15;
        return Long.MAX_VALUE;
    L15:
        return 0;
    }

    public final void j() {
        p().set(this, null);
        q().set(this, null);
    }
}
