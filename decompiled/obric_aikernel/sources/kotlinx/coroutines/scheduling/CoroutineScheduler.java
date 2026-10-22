package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.work.WorkRequest;
import gc.g;
import gc.h;
import gc.j;
import gc.k;
import gc.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
public final class CoroutineScheduler implements Executor, Closeable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10633m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10634n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10635o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JvmField
    public static final i0 f10636p = null;

    @Volatile
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final int f10637c;

    @Volatile
    private volatile long controlState;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final int f10638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final long f10639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public final String f10640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final gc.c f10641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public final gc.c f10642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public final d0<c> f10643l;

    @Volatile
    private volatile long parkedWorkersStack;

    public static final enum WorkerState extends Enum<WorkerState> {
        private static final /* synthetic */ WorkerState[] $VALUES = null;
        public static final WorkerState BLOCKING = null;
        public static final WorkerState CPU_ACQUIRED = null;
        public static final WorkerState DORMANT = null;
        public static final WorkerState PARKING = null;
        public static final WorkerState TERMINATED = null;

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        static {
            CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
            BLOCKING = new WorkerState("BLOCKING", 1);
            PARKING = new WorkerState("PARKING", 2);
            DORMANT = new WorkerState("DORMANT", 3);
            TERMINATED = new WorkerState("TERMINATED", 4);
            $VALUES = $values();
        }

        private WorkerState(String r10, int r11) {
            super(r10, r11);
        }

        public static WorkerState valueOf(String r10) {
            return (WorkerState) Enum.valueOf(WorkerState.class, r10);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10644a = null;

        static {
            int[] r10 = new int[WorkerState.values().length];
            r10[WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r10[WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r10[WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r10[WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r10[WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f10644a = r10;
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    public final class c extends Thread {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f10645n = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final m f10646c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Ref.ObjectRef<g> f10647g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @JvmField
        public WorkerState f10648h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f10649i;
        private volatile int indexInArray;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f10650j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f10651k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @JvmField
        public boolean f10652l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ CoroutineScheduler f10653m;
        private volatile Object nextParkedWorker;

        @Volatile
        private volatile int workerCtl;

        static {
            f10645n = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        }

        private c(CoroutineScheduler r10) {
            this.f10653m = r10;
            setDaemon(true);
            this.f10646c = new m();
            this.f10647g = new Ref.ObjectRef();
            this.f10648h = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f10636p;
            this.f10651k = Random.Default.nextInt();
        }

        public c(CoroutineScheduler r10, int r11) {
            this(r10);
            q(r11);
        }

        public static final /* synthetic */ CoroutineScheduler a(c r10) {
            return r10.f10653m;
        }

        private final void b(int r10) {
            if (r10 != 0) goto L4;
            return;
        L4:
            CoroutineScheduler r11 = this.f10653m;
            CoroutineScheduler.a().addAndGet(r11, -2097152);
            WorkerState r12 = this.f10648h;
            if (r12 != WorkerState.TERMINATED) goto L7;
            return;
        L7:
            if (n0.a() == true) goto L9;
        L16:
            this.f10648h = WorkerState.DORMANT;
            return;
        L9:
            if (r12 != WorkerState.BLOCKING) goto L11;
            boolean r13 = true;
        L12:
            if (r13 == true) goto L16;
            throw new AssertionError();
        L11:
            r13 = false;
            goto L12
        }

        private final void c(int r10) {
            if (r10 != 0) goto L5;
            return;
        L5:
            if (w(WorkerState.BLOCKING) == false) goto L8;
            this.f10653m.C();
            return;
        }

        private final void d(g r10) {
            int r11 = r10.f9107g.b();
            k(r11);
            c(r11);
            this.f10653m.v(r10);
            b(r11);
        }

        private final g e(boolean r10) {
            if (r10 == true) goto L4;
            g r11 = o();
            if (r11 == null) goto L22;
            return r11;
        L22:
            return x(3);
        L4:
            if (m(this.f10653m.f10637c * 2) != 0) goto L6;
            boolean r12 = true;
        L7:
            if (r12 == false) goto L11;
            g r13 = o();
            if (r13 == null) goto L11;
            return r13;
        L11:
            g r14 = this.f10646c.g();
            if (r14 == null) goto L14;
            return r14;
        L14:
            if (r12 == true) goto L22;
            g r15 = o();
            if (r15 == null) goto L22;
            return r15;
        L6:
            r12 = false;
            goto L7
        }

        private final g f() {
            g r10 = this.f10646c.h();
            if (r10 != null) goto L8;
            g r11 = this.f10653m.f10642k.d();
            if (r11 == null) goto L7;
            return r11;
        L7:
            return x(1);
        L8:
            return r10;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f10645n;
        }

        private final void k(int r10) {
            this.f10649i = 0;
            if (this.f10648h == WorkerState.PARKING) goto L5;
            return;
        L5:
            if (n0.a() == false) goto L14;
            boolean r11 = true;
            if (r10 == 1) goto L10;
            r11 = false;
        L10:
            if (r11 == true) goto L14;
            throw new AssertionError();
        L14:
            this.f10648h = WorkerState.BLOCKING;
        }

        private final boolean l() {
            if (this.nextParkedWorker == CoroutineScheduler.f10636p) goto L5;
            return true;
        L5:
            return false;
        }

        private final void n() {
            if (this.f10649i != 0) goto L5;
            this.f10649i = System.nanoTime() + this.f10653m.f10639h;
        L5:
            LockSupport.parkNanos(this.f10653m.f10639h);
            if ((System.nanoTime() - this.f10649i) < 0) goto L9;
            this.f10649i = 0;
            y();
            return;
        }

        private final g o() {
            if (m(2) != 0) goto L10;
            g r10 = this.f10653m.f10641j.d();
            if (r10 == null) goto L7;
            return r10;
        L7:
            gc.c r11 = this.f10653m.f10642k;
        L9:
            return r11.d();
        L10:
            g r12 = this.f10653m.f10642k.d();
            if (r12 == null) goto L13;
            return r12;
        L13:
            r11 = this.f10653m.f10641j;
            goto L9
        }

        private final void p() {
        L3:
            boolean r10 = false;
        L5:
            if (this.f10653m.isTerminated() == true) goto L17;
            if (this.f10648h == WorkerState.TERMINATED) goto L17;
            g r11 = g(this.f10652l);
            if (r11 != null) goto L10;
            this.f10652l = false;
            if (this.f10650j != 0) goto L13;
            t();
            goto L5
        L13:
            if (r10 == true) goto L15;
            r10 = true;
            goto L5
        L15:
            w(WorkerState.PARKING);
            Thread.interrupted();
            LockSupport.parkNanos(this.f10650j);
            this.f10650j = 0;
            goto L3
        L10:
            this.f10650j = 0;
            d(r11);
        L17:
            w(WorkerState.TERMINATED);
        }

        private final boolean s() {
            if (this.f10648h == WorkerState.CPU_ACQUIRED) goto L14;
            CoroutineScheduler r10 = this.f10653m;
            AtomicLongFieldUpdater r11 = CoroutineScheduler.a();
        L6:
            long r12 = r11.get(r10);
            if (((int) ((9223367638808264704L & r12) >> 42)) == 0) goto L8;
            if (CoroutineScheduler.a().compareAndSet(r10, r12, r12 - 4398046511104L) == false) goto L6;
            boolean r13 = true;
        L12:
            if (r13 == false) goto L18;
            this.f10648h = WorkerState.CPU_ACQUIRED;
            goto L14
        L18:
            return false;
        L8:
            r13 = false;
        L14:
            return true;
        }

        private final void t() {
            if (l() == true) goto L6;
            this.f10653m.s(this);
            return;
        L6:
            f10645n.set(this, -1);
        L8:
            if (l() == false) goto L17;
            if (f10645n.get(this) != (-1)) goto L22;
            if (this.f10653m.isTerminated() == true) goto L23;
            if (this.f10648h == WorkerState.TERMINATED) goto L24;
            w(WorkerState.PARKING);
            Thread.interrupted();
            n();
            goto L8
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }

        private final g x(int r18) {
            int r10 = (int) (CoroutineScheduler.a().get(this.f10653m) & 2097151);
            if (r10 >= 2) goto L5;
            return null;
        L5:
            int r11 = m(r10);
            CoroutineScheduler r12 = this.f10653m;
            int r13 = 0;
            long r14 = Long.MAX_VALUE;
        L7:
            if (r13 >= r10) goto L24;
            r11 = r11 + 1;
            if (r11 <= r10) goto L11;
            r11 = 1;
        L11:
            c r15 = r12.f10643l.b(r11);
            if (r15 == null) goto L22;
            if (r15 == this) goto L22;
            long r16 = r15.f10646c.n(r18, this.f10647g);
            if (r16 == (-1)) goto L16;
            if (r16 <= 0) goto L22;
            r14 = Math.min(r14, r16);
            goto L22
        L16:
            Ref.ObjectRef<g> r17 = this.f10647g;
            g r19 = r17.element;
            r17.element = null;
            return r19;
        L22:
            r13 = r13 + 1;
            goto L7
        L24:
            if (r14 != Long.MAX_VALUE) goto L27;
            r14 = 0;
        L27:
            this.f10650j = r14;
            return null;
        }

        private final void y() {
            CoroutineScheduler r10 = this.f10653m;
            d0<c> r11 = r10.f10643l;
            monitor-enter(r11);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (r10.isTerminated() == false) goto L9;
            monitor-exit(r11);
            return;
        L9:
            if (((int) (CoroutineScheduler.a().get(r10) & 2097151)) > r10.f10637c) goto L13;
            monitor-exit(r11);
            return;
        L13:
            if (f10645n.compareAndSet(this, -1, 1) == true) goto L16;
            monitor-exit(r11);
            return;
        L16:
            int r12 = this.indexInArray;     // Catch: Throwable -> L23
            q(0);     // Catch: Throwable -> L23
            r10.u(this, r12, 0);     // Catch: Throwable -> L23
            int r13 = (int) (CoroutineScheduler.a().getAndDecrement(r10) & 2097151);     // Catch: Throwable -> L23
            if (r13 == r12) goto L19;
            c r14 = r10.f10643l.b(r13);     // Catch: Throwable -> L23
            Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L23
            c r15 = r14;     // Catch: Throwable -> L23
            r10.f10643l.c(r12, r15);     // Catch: Throwable -> L23
            r15.q(r12);     // Catch: Throwable -> L23
            r10.u(r15, r13, r12);     // Catch: Throwable -> L23
        L19:
            r10.f10643l.c(r13, null);     // Catch: Throwable -> L23
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r11);
            this.f10648h = WorkerState.TERMINATED;
        }

        public final g g(boolean r10) {
            if (s() == false) goto L7;
            return e(r10);
        L7:
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int r10) {
            int r11 = this.f10651k;
            int r12 = r11 ^ (r11 << 13);
            int r13 = r12 ^ (r12 >> 17);
            int r14 = r13 ^ (r13 << 5);
            this.f10651k = r14;
            int r15 = r10 - 1;
            if ((r15 & r10) != 0) goto L7;
            return r15 & r14;
        L7:
            return (Integer.MAX_VALUE & r14) % r10;
        }

        public final void q(int r10) {
            StringBuilder r11 = new StringBuilder();
            r11.append(this.f10653m.f10640i);
            r11.append("-worker-");
            if (r10 != 0) goto L5;
            String r12 = "TERMINATED";
        L6:
            r11.append(r12);
            setName(r11.toString());
            this.indexInArray = r10;
            return;
        L5:
            r12 = String.valueOf(r10);
            goto L6
        }

        public final void r(Object r10) {
            this.nextParkedWorker = r10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean w(WorkerState r10) {
            WorkerState r11 = this.f10648h;
            if (r11 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L8;
            CoroutineScheduler r13 = this.f10653m;
            CoroutineScheduler.a().addAndGet(r13, 4398046511104L);
        L8:
            if (r11 == r10) goto L10;
            this.f10648h = r10;
        L10:
            return r12;
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        new a(null);
        f10633m = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        f10634n = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        f10635o = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
        f10636p = new i0("NOT_IN_STACK");
    }

    public CoroutineScheduler(int r10, int r11, long r12, String r13) {
        this.f10637c = r10;
        this.f10638g = r11;
        this.f10639h = r12;
        this.f10640i = r13;
        boolean r14 = true;
        if (r10 < 1) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L31;
        if (r11 < r10) goto L9;
        boolean r16 = true;
    L11:
        if (r16 == false) goto L29;
        if (r11 > 2097150) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == false) goto L27;
        if (r12 > 0) goto L21;
        r14 = false;
    L21:
        if (r14 == false) goto L25;
        this.f10641j = new gc.c();
        this.f10642k = new gc.c();
        this.f10643l = new d0((r10 + 1) * 2);
        this.controlState = ((long) r10) << 42;
        this._isTerminated = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r12 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(("Max pool size " + r11 + " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r17 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r11 + " should be greater than or equals to core pool size " + r10).toString());
    L9:
        r16 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(("Core pool size " + r10 + " should be at least 1").toString());
    L5:
        r15 = false;
        goto L6
    }

    private final void B(long r10, boolean r11) {
        if (r11 == false) goto L5;
        return;
    L5:
        if (I() == false) goto L8;
        return;
    L8:
        if (F(r10) == false) goto L10;
        return;
    L10:
        I();
    }

    private final g D(c r10, g r11, boolean r12) {
        if (r10 != null) goto L5;
        return r11;
    L5:
        if (r10.f10648h != WorkerState.TERMINATED) goto L8;
        return r11;
    L8:
        if (r11.f9107g.b() == 0) goto L10;
    L12:
        r10.f10652l = true;
        return r10.f10646c.a(r11, r12);
    L10:
        if (r10.f10648h != WorkerState.BLOCKING) goto L12;
        return r11;
    }

    private final boolean F(long r10) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & r10)) - ((int) ((r10 & 4398044413952L) >> 21)), 0) >= this.f10637c) goto L11;
        int r11 = f();
        if (r11 == 1) goto L7;
    L9:
        if (r11 <= 0) goto L11;
        return true;
    L7:
        if (this.f10637c <= 1) goto L9;
        f();
    L11:
        return false;
    }

    static /* synthetic */ boolean G(CoroutineScheduler r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = f10634n.get(r10);
    L6:
        return r10.F(r11);
    }

    private final boolean I() {
    L2:
        c r10 = r();
        if (r10 == null) goto L4;
        if (c.j().compareAndSet(r10, -1, 0) == false) goto L2;
        LockSupport.unpark(r10);
        return true;
    L4:
        return false;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater a() {
        return f10634n;
    }

    private final boolean c(g r10) {
        boolean r11 = true;
        if (r10.f9107g.b() == 1) goto L6;
        r11 = false;
    L6:
        if (r11 == false) goto L8;
        gc.c r12 = this.f10642k;
    L10:
        return r12.a(r10);
    L8:
        r12 = this.f10641j;
        goto L10
    }

    private final int f() {
        d0<c> r10 = this.f10643l;
        monitor-enter(r10);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (isTerminated() == true) goto L7;
        AtomicLongFieldUpdater r11 = f10634n;     // Catch: Throwable -> L37
        long r12 = r11.get(this);     // Catch: Throwable -> L37
        int r13 = (int) (r12 & 2097151);     // Catch: Throwable -> L37
        boolean r14 = false;
        int r15 = RangesKt.coerceAtLeast(r13 - ((int) ((r12 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L37
        if (r15 < this.f10637c) goto L14;
        monitor-exit(r10);
        return 0;
    L14:
        if (r13 < this.f10638g) goto L17;
        monitor-exit(r10);
        return 0;
    L17:
        int r16 = ((int) (a().get(this) & 2097151)) + 1;     // Catch: Throwable -> L37
        if (r16 > 0) goto L20;
    L22:
        boolean r17 = false;
    L23:
        if (r17 == false) goto L36;
        c r18 = new c(this, r16);     // Catch: Throwable -> L37
        this.f10643l.c(r16, r18);     // Catch: Throwable -> L37
        if (r16 != ((int) (2097151 & r11.incrementAndGet(this)))) goto L28;
        r14 = true;
    L28:
        if (r14 == false) goto L34;
        int r19 = r15 + 1;
        monitor-exit(r10);
        r18.start();
        return r19;
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L20:
        if (this.f10643l.b(r16) != null) goto L22;
        r17 = true;
        goto L23
    L7:
        monitor-exit(r10);
        return -1;
    }

    private final c k() {
        Thread r10 = Thread.currentThread();
        if ((r10 instanceof c) == false) goto L5;
        c r11 = (c) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(c.a(r11), this) == true) goto L10;
        return null;
    L10:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public static /* synthetic */ void o(CoroutineScheduler r10, Runnable r11, h r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = k.f9116g;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = false;
    L8:
        r10.l(r11, r12, r13);
    }

    private final int p(c r10) {
        Object r11 = r10.i();
    L4:
        if (r11 == f10636p) goto L5;
        if (r11 == null) goto L8;
        c r12 = (c) r11;
        int r13 = r12.h();
        if (r13 != 0) goto L12;
        r11 = r12.i();
        goto L4
    L12:
        return r13;
    L8:
        return 0;
    L5:
        return -1;
    }

    private final c r() {
        AtomicLongFieldUpdater r10 = f10633m;
    L3:
        long r11 = r10.get(this);
        d0<c> r12 = this.f10643l;
        c r13 = r12.b((int) (2097151 & r11));
        if (r13 == null) goto L5;
        long r14 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r11) & (-2097152);
        int r15 = p(r13);
        if (r15 < 0) goto L3;
        if (f10633m.compareAndSet(this, r11, ((long) r15) | r14) == false) goto L3;
        r13.r(f10636p);
        return r13;
    L5:
        return null;
    }

    public final void A(long r10) {
        boolean r11 = false;
        if (f10635o.compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        c r12 = k();
        d0<c> r13 = this.f10643l;
        monitor-enter(r13);
        int r14 = (int) (a().get(this) & 2097151);
        monitor-exit(r13);
        if (1 > r14) goto L30;
        int r15 = 1;
    L12:
        c r16 = this.f10643l.b(r15);
        Intrinsics.checkNotNull(r16);
        c r17 = r16;
        if (r17 != r12) goto L15;
    L28:
        if (r15 == r14) goto L30;
        r15 = r15 + 1;
    L15:
        if (r17.isAlive() == false) goto L17;
        LockSupport.unpark(r17);
        r17.join(r10);
        goto L15
    L17:
        WorkerState r18 = r17.f10648h;
        if (n0.a() == true) goto L20;
    L27:
        r17.f10646c.f(this.f10642k);
        goto L28
    L20:
        if (r18 != WorkerState.TERMINATED) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == true) goto L27;
        throw new AssertionError();
    L22:
        r19 = false;
    L30:
        this.f10642k.b();
        this.f10641j.b();
    L31:
        if (r12 == null) goto L34;
        g r20 = r12.g(true);
        if (r20 == null) goto L34;
    L51:
        v(r20);
    L34:
        r20 = this.f10641j.d();
        if (r20 != null) goto L51;
        r20 = this.f10642k.d();
        if (r20 != null) goto L51;
        if (r12 == null) goto L41;
        r12.w(WorkerState.TERMINATED);
    L41:
        if (n0.a() == true) goto L43;
    L49:
        f10633m.set(this, 0);
        f10634n.set(this, 0);
        return;
    L43:
        if (((int) ((f10634n.get(this) & 9223367638808264704L) >> 42)) != this.f10637c) goto L45;
        r11 = true;
    L45:
        if (r11 == true) goto L49;
        throw new AssertionError();
    L52:
        th = move-exception;
        throw th;
    }

    public final void C() {
        if (I() == false) goto L6;
        return;
    L6:
        if (G(this, 0, 1, null) == false) goto L8;
        return;
    L8:
        I();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        A(WorkRequest.MIN_BACKOFF_MILLIS);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        o(this, r10, null, false, 6, null);
    }

    public final g i(Runnable r10, h r11) {
        long r12 = k.f9115f.a();
        if ((r10 instanceof g) == false) goto L7;
        g r13 = (g) r10;
        r13.f9106c = r12;
        r13.f9107g = r11;
        return r13;
    L7:
        return new j(r10, r12, r11);
    }

    public final boolean isTerminated() {
        if (f10635o.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void l(Runnable r10, h r11, boolean r12) {
        kotlinx.coroutines.c.a();
        g r13 = i(r10, r11);
        boolean r14 = false;
        if (r13.f9107g.b() != 1) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L8;
        long r16 = f10634n.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
    L9:
        c r17 = k();
        g r18 = D(r17, r13, r12);
        if (r18 != null) goto L12;
    L16:
        if (r12 == false) goto L19;
        if (r17 == null) goto L19;
        r14 = true;
    L19:
        if (r15 == false) goto L21;
        B(r16, r14);
        return;
    L21:
        if (r14 == false) goto L23;
        return;
    L23:
        C();
        return;
    L12:
        if (c(r18) == true) goto L16;
        throw new RejectedExecutionException(this.f10640i + " was terminated");
    L8:
        r16 = 0;
        goto L9
    L5:
        r15 = false;
        goto L6
    }

    public final boolean s(c r11) {
        if (r11.i() == f10636p) goto L5;
        return false;
    L5:
        AtomicLongFieldUpdater r10 = f10633m;
    L6:
        long r12 = r10.get(this);
        int r13 = (int) (2097151 & r12);
        long r14 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r12) & (-2097152);
        int r15 = r11.h();
        if (n0.a() == false) goto L15;
        if (r15 == 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == true) goto L15;
        throw new AssertionError();
    L10:
        r16 = false;
    L15:
        r11.r(this.f10643l.b(r13));
        if (f10633m.compareAndSet(this, r12, ((long) r15) | r14) == false) goto L6;
        return true;
    }

    public String toString() {
        ArrayList r10 = new ArrayList();
        int r11 = this.f10643l.a();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 1;
    L3:
        if (r17 >= r11) goto L27;
        c r18 = this.f10643l.b(r17);
        if (r18 == null) goto L26;
        int r19 = r18.f10646c.e();
        int r20 = b.f10644a[r18.f10648h.ordinal()];
        if (r20 != 1) goto L10;
        r14 = r14 + 1;
        goto L26
    L10:
        if (r20 != 2) goto L12;
        r13 = r13 + 1;
        StringBuilder r21 = new StringBuilder();
        r21.append(r19);
        char r110 = 'b';
    L24:
        r21.append(r110);
        r10.add(r21.toString());
        goto L26
    L12:
        if (r20 != 3) goto L14;
        r12 = r12 + 1;
        r21 = new StringBuilder();
        r21.append(r19);
        r110 = 'c';
        goto L24
    L14:
        if (r20 != 4) goto L16;
        r15 = r15 + 1;
        if (r19 <= 0) goto L26;
        r21 = new StringBuilder();
        r21.append(r19);
        r110 = 'd';
        goto L24
    L16:
        if (r20 != 5) goto L26;
        r16 = r16 + 1;
    L26:
        r17 = r17 + 1;
        goto L3
    L27:
        long r22 = f10634n.get(this);
        return this.f10640i + '@' + o0.b(this) + "[Pool Size {core = " + this.f10637c + ", max = " + this.f10638g + "}, Worker States {CPU = " + r12 + ", blocking = " + r13 + ", parked = " + r14 + ", dormant = " + r15 + ", terminated = " + r16 + "}, running workers queues = " + r10 + ", global CPU queue size = " + this.f10641j.c() + ", global blocking queue size = " + this.f10642k.c() + ", Control State {created workers= " + ((int) (2097151 & r22)) + ", blocking tasks = " + ((int) ((4398044413952L & r22) >> 21)) + ", CPUs acquired = " + (this.f10637c - ((int) ((9223367638808264704L & r22) >> 42))) + "}]";
    }

    public final void u(c r10, int r11, int r12) {
        AtomicLongFieldUpdater r13 = f10633m;
    L3:
        long r14 = r13.get(this);
        int r15 = (int) (2097151 & r14);
        long r16 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r14) & (-2097152);
        if (r15 != r11) goto L8;
        if (r12 != 0) goto L7;
        r15 = p(r10);
        goto L8
    L7:
        r15 = r12;
    L8:
        if (r15 < 0) goto L3;
        if (f10633m.compareAndSet(this, r14, r16 | ((long) r15)) == false) goto L3;
    }

    public final void v(g r10) {
        r10.run();     // Catch: Throwable -> L4
    L3:
        kotlinx.coroutines.c.a();
        return;
    L4:
        th = move-exception;
        Thread r11 = Thread.currentThread();     // Catch: Throwable -> L8
        r11.getUncaughtExceptionHandler().uncaughtException(r11, th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        kotlinx.coroutines.c.a();
        throw th;
    }
}
