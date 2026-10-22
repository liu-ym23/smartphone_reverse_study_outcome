package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
final enum SequentialExecutor$WorkerRunningState extends Enum<SequentialExecutor$WorkerRunningState> {
    public static final SequentialExecutor$WorkerRunningState IDLE = null;
    public static final SequentialExecutor$WorkerRunningState QUEUED = null;
    public static final SequentialExecutor$WorkerRunningState QUEUING = null;
    public static final SequentialExecutor$WorkerRunningState RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SequentialExecutor$WorkerRunningState[] f9396a = null;

    static {
        SequentialExecutor$WorkerRunningState r5 = new SequentialExecutor$WorkerRunningState("IDLE", 0);
        IDLE = r5;
        SequentialExecutor$WorkerRunningState r10 = new SequentialExecutor$WorkerRunningState("QUEUING", 1);
        QUEUING = r10;
        SequentialExecutor$WorkerRunningState r11 = new SequentialExecutor$WorkerRunningState("QUEUED", 2);
        QUEUED = r11;
        SequentialExecutor$WorkerRunningState r12 = new SequentialExecutor$WorkerRunningState("RUNNING", 3);
        RUNNING = r12;
        f9396a = new SequentialExecutor$WorkerRunningState[]{r5, r10, r11, r12};
    }

    public static SequentialExecutor$WorkerRunningState valueOf(String r5) {
        return (SequentialExecutor$WorkerRunningState) Enum.valueOf(SequentialExecutor$WorkerRunningState.class, r5);
    }

    public static SequentialExecutor$WorkerRunningState[] values() {
        return (SequentialExecutor$WorkerRunningState[]) f9396a.clone();
    }
}
