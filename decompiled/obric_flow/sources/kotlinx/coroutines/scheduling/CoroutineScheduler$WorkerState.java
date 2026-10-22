package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"kotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState", "", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CoroutineScheduler$WorkerState extends Enum<CoroutineScheduler$WorkerState> {
    public static final CoroutineScheduler$WorkerState BLOCKING = null;
    public static final CoroutineScheduler$WorkerState CPU_ACQUIRED = null;
    public static final CoroutineScheduler$WorkerState DORMANT = null;
    public static final CoroutineScheduler$WorkerState PARKING = null;
    public static final CoroutineScheduler$WorkerState TERMINATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoroutineScheduler$WorkerState[] f18991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18992b = null;

    static {
        CoroutineScheduler$WorkerState r5 = new CoroutineScheduler$WorkerState("CPU_ACQUIRED", 0);
        CPU_ACQUIRED = r5;
        CoroutineScheduler$WorkerState r10 = new CoroutineScheduler$WorkerState("BLOCKING", 1);
        BLOCKING = r10;
        CoroutineScheduler$WorkerState r11 = new CoroutineScheduler$WorkerState("PARKING", 2);
        PARKING = r11;
        CoroutineScheduler$WorkerState r12 = new CoroutineScheduler$WorkerState("DORMANT", 3);
        DORMANT = r12;
        CoroutineScheduler$WorkerState r13 = new CoroutineScheduler$WorkerState("TERMINATED", 4);
        TERMINATED = r13;
        CoroutineScheduler$WorkerState[] r14 = {r5, r10, r11, r12, r13};
        f18991a = r14;
        f18992b = EnumEntriesKt.enumEntries(r14);
    }

    public static EnumEntries<CoroutineScheduler$WorkerState> getEntries() {
        return f18992b;
    }

    public static CoroutineScheduler$WorkerState valueOf(String r5) {
        return (CoroutineScheduler$WorkerState) Enum.valueOf(CoroutineScheduler$WorkerState.class, r5);
    }

    public static CoroutineScheduler$WorkerState[] values() {
        return (CoroutineScheduler$WorkerState[]) f18991a.clone();
    }
}
