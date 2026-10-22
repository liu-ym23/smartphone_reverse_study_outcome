package kotlinx.coroutines.scheduling;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public /* synthetic */ class CoroutineScheduler$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CoroutineScheduler.WorkerState.values().length];
        r0[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r0[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r0[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r0[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r0[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        a = r0;
    }
}
