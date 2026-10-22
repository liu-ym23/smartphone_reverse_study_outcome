package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
final enum ExecutionSequencer$RunningState extends Enum<ExecutionSequencer$RunningState> {
    public static final ExecutionSequencer$RunningState CANCELLED = null;
    public static final ExecutionSequencer$RunningState NOT_RUN = null;
    public static final ExecutionSequencer$RunningState STARTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecutionSequencer$RunningState[] f9389a = null;

    static {
        ExecutionSequencer$RunningState r5 = new ExecutionSequencer$RunningState("NOT_RUN", 0);
        NOT_RUN = r5;
        ExecutionSequencer$RunningState r10 = new ExecutionSequencer$RunningState("CANCELLED", 1);
        CANCELLED = r10;
        ExecutionSequencer$RunningState r11 = new ExecutionSequencer$RunningState("STARTED", 2);
        STARTED = r11;
        f9389a = new ExecutionSequencer$RunningState[]{r5, r10, r11};
    }

    public static ExecutionSequencer$RunningState valueOf(String r5) {
        return (ExecutionSequencer$RunningState) Enum.valueOf(ExecutionSequencer$RunningState.class, r5);
    }

    public static ExecutionSequencer$RunningState[] values() {
        return (ExecutionSequencer$RunningState[]) f9389a.clone();
    }
}
