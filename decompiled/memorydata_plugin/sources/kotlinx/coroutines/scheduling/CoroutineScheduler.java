package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.internal.ae;
import kotlinx.coroutines.internal.aj;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0086\bJ\u0011\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020 2\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010*\u001a\u00020+J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\u000e\u0010,\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\t\u0010-\u001a\u00020$H\u0082\bJ\t\u0010.\u001a\u00020\u0004H\u0082\bJ&\u0010/\u001a\u00020$2\n\u0010'\u001a\u00060(j\u0002`)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u0018J\u0014\u00101\u001a\u00020$2\n\u00102\u001a\u00060(j\u0002`)H\u0016J\t\u00103\u001a\u00020\u0007H\u0082\bJ\t\u00104\u001a\u00020\u0004H\u0082\bJ\u0014\u00105\u001a\u00020\u00042\n\u00106\u001a\u00060\u001dR\u00020\u0000H\u0002J\u000e\u00107\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\u0012\u00108\u001a\u00020\u00182\n\u00106\u001a\u00060\u001dR\u00020\u0000J\"\u00109\u001a\u00020$2\n\u00106\u001a\u00060\u001dR\u00020\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004J\t\u0010<\u001a\u00020\u0007H\u0082\bJ\u000e\u0010=\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0006\u0010C\u001a\u00020$J\b\u0010D\u001a\u00020\tH\u0016J\t\u0010E\u001a\u00020\u0018H\u0082\bJ\u0012\u0010F\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J$\u0010H\u001a\u0004\u0018\u00010 *\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u00020\u0018H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u001a\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001dR\u00020\u00000\u001c8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "availableCpuPermits", "getAvailableCpuPermits", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "createdWorkers", "getCreatedWorkers", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "isTerminated", "", "()Z", "parkedWorkersStack", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "addToGlobalQueue", "task", "Lkotlinx/coroutines/scheduling/Task;", "state", "blockingTasks", IslandSession.REOPEN_VALUE_CLOSE, "", "createNewWorker", "createTask", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "currentWorker", "decrementBlockingTasks", "decrementCreatedWorkers", "dispatch", "tailDispatch", "execute", "command", "incrementBlockingTasks", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "releaseCpuPermit", "runSafely", "shutdown", LocationMonitorConst.TIMEOUT, "signalBlockingWork", "stateSnapshot", "skipUnpark", "signalCpuWork", "toString", "tryAcquireCpuPermit", "tryCreateWorker", "tryUnpark", "submitToLocalQueue", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CoroutineScheduler implements Closeable, Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17612a = null;
    public static final aj i = null;
    private static final /* synthetic */ AtomicLongFieldUpdater j = null;
    private static final /* synthetic */ AtomicLongFieldUpdater k = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater l = null;
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17613b;
    public final int c;
    private volatile /* synthetic */ long controlState$volatile;
    public final long d;
    public final String e;
    public final kotlinx.coroutines.scheduling.c f;
    public final kotlinx.coroutines.scheduling.c g;
    public final ae<c> h;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum WorkerState extends Enum<WorkerState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
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
            WorkerState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private WorkerState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        public static WorkerState valueOf(String r2) {
            return (WorkerState) ZeusTransformUtils.preCheckCast(Enum.valueOf(WorkerState.class, r2), WorkerState.class, "com.obric.memorydata.plugin");
        }

        public static WorkerState[] values() {
            return (WorkerState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WorkerState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17614a = null;

        static {
            int[] r0 = new int[WorkerState.values().length];
            r0[WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f17614a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020\u000eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\b\u00105\u001a\u00020%H\u0002J\n\u00106\u001a\u0004\u0018\u00010 H\u0002J\b\u00107\u001a\u00020%H\u0016J\u0006\u00108\u001a\u00020\u0010J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020%H\u0002J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\u0004\u0018\u00010 2\n\u0010?\u001a\u00060\u0003j\u0002`@H\u0002J\b\u0010A\u001a\u00020%H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0006\u0010\"\u001a\u00020#¨\u0006B"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "", "minDelayUntilStealableTaskNs", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "terminationDeadline", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "beforeTask", "executeTask", "task", "findAnyTask", "scanLocalQueue", "findBlockingTask", "findCpuTask", "findTask", "idleReset", "mode", "inStack", "isIo", "nextInt", "upperBound", "park", "pollGlobalQueues", "run", "runSingleTask", "runWorker", "tryAcquireCpuPermit", "tryPark", "tryReleaseCpu", "newState", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryTerminateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class c extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f17615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WorkerState f17616b;
        public boolean c;
        final /* synthetic */ CoroutineScheduler d;
        private final Ref.ObjectRef<g> e;
        private long f;
        private long g;
        private int h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        static {
            i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");
        }

        private c(CoroutineScheduler r3) {
            this.d = r3;
            setDaemon(true);
            setContextClassLoader(r3.getClass().getClassLoader());
            this.f17615a = new m();
            this.e = new Ref.ObjectRef();
            this.f17616b = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.i;
            c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
            int r5 = (int) System.nanoTime();
            if (r5 != 0) goto L6;
            r5 = 42;
        L6:
            this.h = r5;
        }

        public c(CoroutineScheduler r1, int r2) {
            this(r1);
            a(r2);
        }

        public static final /* synthetic */ CoroutineScheduler a(c r0) {
            return r0.d;
        }

        private final void a(g r3) {
            int r0 = r3.g.a();
            e(r0);
            c(r0);
            this.d.a(r3);
            d(r0);
        }

        private final g b(boolean r2) {
            if (r2 == true) goto L4;
            g r3 = k();
            if (r3 == null) goto L22;
            return r3;
        L22:
            return f(3);
        L4:
            if (b(this.d.f17613b * 2) != 0) goto L6;
            boolean r4 = true;
        L7:
            if (r4 == false) goto L11;
            g r0 = k();
            if (r0 == null) goto L11;
            return r0;
        L11:
            g r1 = this.f17615a.b();
            if (r1 == null) goto L14;
            return r1;
        L14:
            if (r4 == true) goto L22;
            g r5 = k();
            if (r5 == null) goto L22;
            return r5;
        L6:
            r4 = false;
            goto L7
        }

        public static final /* synthetic */ AtomicIntegerFieldUpdater c() {
            return i;
        }

        private final void c(int r1) {
            if (r1 != 0) goto L5;
            return;
        L5:
            if (a(WorkerState.BLOCKING) == false) goto L8;
            this.d.b();
            return;
        }

        private final void d(int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            CoroutineScheduler r5 = this.d;
            CoroutineScheduler.c().addAndGet(r5, -2097152);
            WorkerState r6 = this.f17616b;
            if (r6 != WorkerState.TERMINATED) goto L7;
            return;
        L7:
            if (an.a() == true) goto L9;
        L16:
            this.f17616b = WorkerState.DORMANT;
            return;
        L9:
            if (r6 != WorkerState.BLOCKING) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == true) goto L16;
            throw new AssertionError();
        L11:
            r7 = false;
            goto L12
        }

        private final boolean d() {
            if (this.f17616b == WorkerState.CPU_ACQUIRED) goto L14;
            CoroutineScheduler r0 = this.d;
            AtomicLongFieldUpdater r1 = CoroutineScheduler.c();
        L6:
            long r6 = r1.get(r0);
            if (((int) ((9223367638808264704L & r6) >> 42)) == 0) goto L8;
            if (CoroutineScheduler.c().compareAndSet(r0, r6, r6 - 4398046511104L) == false) goto L6;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L18;
            this.f17616b = WorkerState.CPU_ACQUIRED;
            goto L14
        L18:
            return false;
        L8:
            r2 = false;
        L14:
            return true;
        }

        private final void e() {
        L3:
            boolean r1 = false;
        L5:
            if (this.d.a() == true) goto L17;
            if (this.f17616b == WorkerState.TERMINATED) goto L17;
            g r2 = a(this.c);
            if (r2 != null) goto L10;
            this.c = false;
            if (this.g != 0) goto L13;
            f();
            goto L5
        L13:
            if (r1 == true) goto L15;
            r1 = true;
            goto L5
        L15:
            a(WorkerState.PARKING);
            Thread.interrupted();
            LockSupport.parkNanos(this.g);
            this.g = 0;
            goto L3
        L10:
            this.g = 0;
            a(r2);
        L17:
            a(WorkerState.TERMINATED);
        }

        private final void e(int r3) {
            this.f = 0;
            if (this.f17616b == WorkerState.PARKING) goto L5;
            return;
        L5:
            if (an.a() == false) goto L14;
            boolean r0 = true;
            if (r3 == 1) goto L10;
            r0 = false;
        L10:
            if (r0 == true) goto L14;
            throw new AssertionError();
        L14:
            this.f17616b = WorkerState.BLOCKING;
        }

        private final g f(int r19) {
            int r1 = (int) (CoroutineScheduler.c().get(this.d) & 2097151);
            if (r1 >= 2) goto L5;
            return null;
        L5:
            int r3 = b(r1);
            CoroutineScheduler r4 = this.d;
            int r5 = 0;
            long r8 = Long.MAX_VALUE;
        L7:
            if (r5 >= r1) goto L24;
            r3 = r3 + 1;
            if (r3 <= r1) goto L11;
            r3 = 1;
        L11:
            c r12 = (c) ZeusTransformUtils.preCheckCast(r4.h.a(r3), c.class, "com.obric.memorydata.plugin");
            if (r12 == null) goto L22;
            if (r12 == this) goto L22;
            long r13 = r12.f17615a.a(r19, this.e);
            if (r13 == (-1)) goto L16;
            if (r13 <= 0) goto L22;
            r8 = Math.min(r8, r13);
            goto L22
        L16:
            g r2 = (g) ZeusTransformUtils.preCheckCast(this.e.element, g.class, "com.obric.memorydata.plugin");
            this.e.element = null;
            return r2;
        L22:
            r5 = r5 + 1;
            goto L7
        L24:
            if (r8 != Long.MAX_VALUE) goto L27;
            r8 = 0;
        L27:
            this.g = r8;
            return null;
        }

        private final void f() {
            if (g() == true) goto L6;
            this.d.a(this);
            return;
        L6:
            c().set(this, -1);
        L8:
            if (g() == false) goto L17;
            if (c().get(this) != (-1)) goto L22;
            if (this.d.a() == true) goto L23;
            if (this.f17616b == WorkerState.TERMINATED) goto L24;
            a(WorkerState.PARKING);
            Thread.interrupted();
            h();
            goto L8
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }

        private final boolean g() {
            if (this.nextParkedWorker == CoroutineScheduler.i) goto L5;
            return true;
        L5:
            return false;
        }

        private final void h() {
            if (this.f != 0) goto L5;
            this.f = System.nanoTime() + this.d.d;
        L5:
            LockSupport.parkNanos(this.d.d);
            if ((System.nanoTime() - this.f) < 0) goto L9;
            this.f = 0;
            i();
            return;
        }

        private final void i() {
            ae<c> r0 = this.d.h;
            CoroutineScheduler r1 = this.d;
            monitor-enter(r0);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (r1.a() == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            if (((int) (CoroutineScheduler.c().get(r1) & 2097151)) > r1.f17613b) goto L13;
            monitor-exit(r0);
            return;
        L13:
            if (c().compareAndSet(this, -1, 1) == true) goto L16;
            monitor-exit(r0);
            return;
        L16:
            int r2 = this.indexInArray;     // Catch: Throwable -> L23
            a(0);     // Catch: Throwable -> L23
            r1.a(this, r2, 0);     // Catch: Throwable -> L23
            int r3 = (int) (CoroutineScheduler.c().getAndDecrement(r1) & 2097151);     // Catch: Throwable -> L23
            if (r3 == r2) goto L19;
            c r4 = r1.h.a(r3);     // Catch: Throwable -> L23
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L23
            c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
            r1.h.a(r2, r5);     // Catch: Throwable -> L23
            r5.a(r2);     // Catch: Throwable -> L23
            r1.a(r5, r3, r2);     // Catch: Throwable -> L23
        L19:
            r1.h.a(r3, null);     // Catch: Throwable -> L23
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r0);
            this.f17616b = WorkerState.TERMINATED;
        }

        private final g j() {
            g r0 = this.f17615a.c();
            if (r0 != null) goto L8;
            g r1 = (g) ZeusTransformUtils.preCheckCast(this.d.g.c(), g.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L7;
            return r1;
        L7:
            return f(1);
        L8:
            return r0;
        }

        private final g k() {
            if (b(2) != 0) goto L10;
            g r0 = (g) ZeusTransformUtils.preCheckCast(this.d.f.c(), g.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            return r0;
        L7:
            kotlinx.coroutines.scheduling.c r3 = this.d.g;
        L9:
            return (g) ZeusTransformUtils.preCheckCast(r3.c(), g.class, "com.obric.memorydata.plugin");
        L10:
            g r1 = (g) ZeusTransformUtils.preCheckCast(this.d.g.c(), g.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L13;
            return r1;
        L13:
            r3 = this.d.f;
            goto L9
        }

        public final int a() {
            return this.indexInArray;
        }

        public final g a(boolean r2) {
            if (d() == false) goto L7;
            return b(r2);
        L7:
            return j();
        }

        public final void a(int r3) {
            StringBuilder r0 = new StringBuilder().append(this.d.e).append("-worker-");
            if (r3 != 0) goto L5;
            String r1 = "TERMINATED";
        L6:
            setName(r0.append(r1).toString());
            this.indexInArray = r3;
            return;
        L5:
            r1 = String.valueOf(r3);
            goto L6
        }

        public final void a(Object r1) {
            this.nextParkedWorker = r1;
        }

        public final boolean a(WorkerState r7) {
            WorkerState r0 = this.f17616b;
            if (r0 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            CoroutineScheduler r2 = this.d;
            CoroutineScheduler.c().addAndGet(r2, 4398046511104L);
        L8:
            if (r0 == r7) goto L10;
            this.f17616b = r7;
        L10:
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        public final int b(int r3) {
            int r0 = this.h;
            int r1 = r0 ^ (r0 << 13);
            int r2 = r1 ^ (r1 >> 17);
            int r4 = r2 ^ (r2 << 5);
            this.h = r4;
            int r5 = r3 - 1;
            if ((r5 & r3) != 0) goto L7;
            return r5 & r4;
        L7:
            return (Integer.MAX_VALUE & r4) % r3;
        }

        public final Object b() {
            return this.nextParkedWorker;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            e();
        }
    }

    static {
        f17612a = new a(null);
        j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
        k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
        l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
        i = new aj("NOT_IN_STACK");
    }

    public CoroutineScheduler(int r4, int r5, long r6, String r8) {
        this.f17613b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        boolean r0 = true;
        if (r4 < 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L31;
        if (r5 < r4) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L29;
        if (r5 > 2097150) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L27;
        if (r6 > 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L25;
        this.f = new kotlinx.coroutines.scheduling.c();
        this.g = new kotlinx.coroutines.scheduling.c();
        this.h = new ae((r4 + 1) * 2);
        this.controlState$volatile = ((long) r4) << 42;
        this._isTerminated$volatile = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r6 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r3 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should be greater than or equals to core pool size " + r4).toString());
    L9:
        r2 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(("Core pool size " + r4 + " should be at least 1").toString());
    L5:
        r1 = false;
        goto L6
    }

    private final g a(c r2, g r3, boolean r4) {
        if (r2 != null) goto L5;
        return r3;
    L5:
        if (r2.f17616b != WorkerState.TERMINATED) goto L8;
        return r3;
    L8:
        if (r3.g.a() == 0) goto L10;
    L12:
        r2.c = true;
        return r2.f17615a.a(r3, r4);
    L10:
        if (r2.f17616b != WorkerState.BLOCKING) goto L12;
        return r3;
    }

    private final void a(long r1, boolean r3) {
        if (r3 == false) goto L5;
        return;
    L5:
        if (e() == false) goto L8;
        return;
    L8:
        if (b(r1) == false) goto L10;
        return;
    L10:
        e();
    }

    public static /* synthetic */ void a(CoroutineScheduler r1, Runnable r2, h r3, boolean r4, int r5, Object r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = k.g;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        r1.a(r7, r8, r4);
    }

    static /* synthetic */ boolean a(CoroutineScheduler r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = i().get(r0);
    L6:
        return r0.b(r1);
    }

    private final int b(c r2) {
        Object r1 = r2.b();
    L4:
        if (r1 == i) goto L5;
        if (r1 == null) goto L8;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin");
        int r4 = r3.a();
        if (r4 != 0) goto L12;
        r1 = r3.b();
        goto L4
    L12:
        return r4;
    L8:
        return 0;
    L5:
        return -1;
    }

    private final boolean b(long r4) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & r4)) - ((int) ((r4 & 4398044413952L) >> 21)), 0) >= this.f17613b) goto L11;
        int r5 = f();
        if (r5 == 1) goto L7;
    L9:
        if (r5 <= 0) goto L11;
        return true;
    L7:
        if (this.f17613b <= 1) goto L9;
        f();
    L11:
        return false;
    }

    private final boolean b(g r3) {
        boolean r1 = true;
        if (r3.g.a() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        kotlinx.coroutines.scheduling.c r2 = this.g;
    L10:
        return r2.a(r3);
    L8:
        r2 = this.f;
        goto L10
    }

    public static final /* synthetic */ AtomicLongFieldUpdater c() {
        return i();
    }

    private final c d() {
        AtomicLongFieldUpdater r0 = h();
    L3:
        long r3 = r0.get(this);
        ae<c> r2 = this.h;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r2.a((int) (2097151 & r3)), c.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        long r1 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r3) & (-2097152);
        int r5 = b(r7);
        if (r5 < 0) goto L3;
        if (h().compareAndSet(this, r3, ((long) r5) | r1) == false) goto L3;
        r7.a(i);
        return r7;
    L5:
        return null;
    }

    private final boolean e() {
    L2:
        c r0 = d();
        if (r0 == null) goto L4;
        if (c.c().compareAndSet(r0, -1, 0) == false) goto L2;
        LockSupport.unpark((Thread) ZeusTransformUtils.preCheckCast(r0, Thread.class, "com.obric.memorydata.plugin"));
        return true;
    L4:
        return false;
    }

    private final int f() {
        ae<c> r0 = this.h;
        monitor-enter(r0);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (a() == true) goto L7;
        long r1 = i().get(this);     // Catch: Throwable -> L37
        int r5 = (int) (r1 & 2097151);     // Catch: Throwable -> L37
        boolean r2 = false;
        int r3 = RangesKt.coerceAtLeast(r5 - ((int) ((r1 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L37
        if (r3 < this.f17613b) goto L14;
        monitor-exit(r0);
        return 0;
    L14:
        if (r5 < this.c) goto L17;
        monitor-exit(r0);
        return 0;
    L17:
        int r6 = ((int) (c().get(this) & 2097151)) + 1;     // Catch: Throwable -> L37
        if (r6 > 0) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L36;
        c r8 = new c(this, r6);     // Catch: Throwable -> L37
        this.h.a(r6, r8);     // Catch: Throwable -> L37
        if (r6 != ((int) (2097151 & i().incrementAndGet(this)))) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L34;
        int r4 = r3 + 1;
        monitor-exit(r0);
        r8.start();
        return r4;
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L20:
        if (this.h.a(r6) != null) goto L22;
        r7 = true;
        goto L23
    L7:
        monitor-exit(r0);
        return -1;
    }

    private final c g() {
        Thread r0 = Thread.currentThread();
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L5;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(c.a(r1), this) == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    private static final /* synthetic */ AtomicLongFieldUpdater h() {
        return j;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater i() {
        return k;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater j() {
        return l;
    }

    public final g a(Runnable r4, h r5) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        long r1 = k.f.a();
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L7;
        ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).f = r1;
        ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).g = r6;
        Object r7 = ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin");
    L6:
        return (g) r7;
    L7:
        r7 = ZeusTransformUtils.preCheckCast(new j(r3, r1, r6), g.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void a(long r9) {
        boolean r1 = false;
        if (j().compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        c r0 = g();
        ae<c> r3 = this.h;
        monitor-enter(r3);
        int r4 = (int) (c().get(this) & 2097151);
        monitor-exit(r3);
        if (1 > r4) goto L30;
        int r5 = 1;
    L12:
        c r6 = this.h.a(r5);
        Intrinsics.checkNotNull(r6);
        c r7 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");
        if (r7 != r0) goto L15;
    L28:
        if (r5 == r4) goto L30;
        r5 = r5 + 1;
    L15:
        if (r7.getState() == Thread.State.TERMINATED) goto L18;
        LockSupport.unpark((Thread) ZeusTransformUtils.preCheckCast(r7, Thread.class, "com.obric.memorydata.plugin"));
        r7.join(r9);
        goto L15
    L18:
        if (an.a() == true) goto L20;
    L27:
        r7.f17615a.a(this.g);
        goto L28
    L20:
        if (r7.f17616b != WorkerState.TERMINATED) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L27;
        throw new AssertionError();
    L22:
        r8 = false;
    L30:
        this.g.b();
        this.f.b();
    L31:
        if (r0 == null) goto L34;
        g r10 = r0.a(true);
        if (r10 == null) goto L34;
    L51:
        a(r10);
    L34:
        r10 = (g) ZeusTransformUtils.preCheckCast(this.f.c(), g.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L51;
        r10 = (g) ZeusTransformUtils.preCheckCast(this.g.c(), g.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L51;
        if (r0 == null) goto L41;
        r0.a(WorkerState.TERMINATED);
    L41:
        if (an.a() == true) goto L43;
    L49:
        h().set(this, 0);
        i().set(this, 0);
        return;
    L43:
        if (((int) ((i().get(this) & 9223367638808264704L) >> 42)) != this.f17613b) goto L45;
        r1 = true;
    L45:
        if (r1 == true) goto L49;
        throw new AssertionError();
    L52:
        th = move-exception;
        throw th;
    }

    public final void a(Runnable r6, h r7, boolean r8) {
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        g r11 = a(r9, r10);
        boolean r1 = false;
        if (r11.g.a() != 1) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        long r2 = i().addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
    L12:
        c r4 = g();
        g r13 = a(r4, r11, r8);
        if (r13 != null) goto L15;
    L19:
        if (r8 == false) goto L22;
        if (r4 == null) goto L22;
        r1 = true;
    L22:
        if (r12 == false) goto L24;
        a(r2, r1);
        return;
    L24:
        if (r1 == false) goto L26;
        return;
    L26:
        b();
        return;
    L15:
        if (b(r13) == true) goto L19;
        throw new RejectedExecutionException(this.e + " was terminated");
    L11:
        r2 = 0;
        goto L12
    L8:
        r12 = false;
        goto L9
    }

    public final void a(c r10, int r11, int r12) {
        AtomicLongFieldUpdater r0 = h();
    L3:
        long r3 = r0.get(this);
        int r1 = (int) (2097151 & r3);
        long r5 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r3) & (-2097152);
        if (r1 != r11) goto L8;
        if (r12 != 0) goto L7;
        r1 = b(r10);
        goto L8
    L7:
        r1 = r12;
    L8:
        if (r1 < 0) goto L3;
        if (h().compareAndSet(this, r3, r5 | ((long) r1)) == false) goto L3;
    }

    public final void a(g r2) {
        r2.run();     // Catch: Throwable -> L6
        kotlinx.coroutines.b r1 = kotlinx.coroutines.c.a();
        if (r1 == null) goto L11;
    L5:
        r1.c();
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Thread r3 = Thread.currentThread();     // Catch: Throwable -> L12
        r3.getUncaughtExceptionHandler().uncaughtException(r3, th);     // Catch: Throwable -> L12
        r1 = kotlinx.coroutines.c.a();
        if (r1 != null) goto L5;
        return;
    L12:
        th = move-exception;
        kotlinx.coroutines.b r4 = kotlinx.coroutines.c.a();
        if (r4 == null) goto L16;
        r4.c();
    L16:
        throw th;
    }

    public final boolean a() {
        if (j().get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(c r11) {
        if (r11.b() == i) goto L5;
        return false;
    L5:
        AtomicLongFieldUpdater r0 = h();
    L6:
        long r5 = r0.get(this);
        int r1 = (int) (2097151 & r5);
        long r3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r5) & (-2097152);
        int r7 = r11.a();
        if (an.a() == false) goto L15;
        if (r7 == 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L15;
        throw new AssertionError();
    L10:
        r8 = false;
    L15:
        r11.a(this.h.a(r1));
        if (h().compareAndSet(this, r5, ((long) r7) | r3) == false) goto L6;
        return true;
    }

    public final void b() {
        if (e() == false) goto L6;
        return;
    L6:
        if (a(this, 0, 1, null) == false) goto L8;
        return;
    L8:
        e();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(10000);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r7) {
        a(this, (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin"), null, false, 6, null);
    }

    public String toString() {
        ArrayList r0 = new ArrayList();
        int r1 = this.h.a();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
    L3:
        if (r8 >= r1) goto L27;
        c r9 = (c) ZeusTransformUtils.preCheckCast(this.h.a(r8), c.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L26;
        int r10 = r9.f17615a.a();
        int r11 = b.f17614a[r9.f17616b.ordinal()];
        if (r11 != 1) goto L10;
        r5 = r5 + 1;
        goto L26
    L10:
        if (r11 != 2) goto L12;
        r4 = r4 + 1;
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append(r10);
        char r14 = 'b';
    L24:
        r12.add(r13.append(r14).toString());
        goto L26
    L12:
        if (r11 != 3) goto L14;
        r2 = r2 + 1;
        r12 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        r13 = new StringBuilder().append(r10);
        r14 = 'c';
        goto L24
    L14:
        if (r11 != 4) goto L16;
        r6 = r6 + 1;
        if (r10 <= 0) goto L26;
        r12 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        r13 = new StringBuilder().append(r10);
        r14 = 'd';
        goto L24
    L16:
        if (r11 != 5) goto L26;
        r7 = r7 + 1;
    L26:
        r8 = r8 + 1;
        goto L3
    L27:
        long r15 = i().get(this);
        StringBuilder r3 = new StringBuilder();
        r3.append(this.e).append('@').append(ao.a(this)).append("[Pool Size {core = ").append(this.f17613b).append(", max = ").append(this.c).append("}, Worker States {CPU = ").append(r2).append(", blocking = ").append(r4).append(", parked = ").append(r5).append(", dormant = ").append(r6).append(", terminated = ").append(r7).append("}, running workers queues = ").append(r0).append(", global CPU queue size = ").append(this.f.a()).append(", global blocking queue size = ").append(this.g.a());
        r3.append(", Control State {created workers= ").append((int) (2097151 & r15)).append(", blocking tasks = ").append((int) ((4398044413952L & r15) >> 21)).append(", CPUs acquired = ").append(this.f17613b - ((int) ((9223367638808264704L & r15) >> 42))).append("}]");
        return r3.toString();
    }
}
