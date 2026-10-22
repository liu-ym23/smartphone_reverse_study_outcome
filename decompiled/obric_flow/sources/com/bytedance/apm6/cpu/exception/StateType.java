package com.bytedance.apm6.cpu.exception;

/* JADX INFO: loaded from: classes2.dex */
public final enum StateType extends Enum<StateType> {
    public static final StateType COOL_DOWN = null;
    public static final StateType IDLE = null;
    public static final StateType PROCESS_DETECT = null;
    public static final StateType PROCESS_DOUBLE_DETECT = null;
    public static final StateType THREAD_DETECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StateType[] f3923a = null;

    static {
        StateType r5 = new StateType("PROCESS_DETECT", 0);
        PROCESS_DETECT = r5;
        StateType r10 = new StateType("PROCESS_DOUBLE_DETECT", 1);
        PROCESS_DOUBLE_DETECT = r10;
        StateType r11 = new StateType("THREAD_DETECT", 2);
        THREAD_DETECT = r11;
        StateType r12 = new StateType("COOL_DOWN", 3);
        COOL_DOWN = r12;
        StateType r13 = new StateType("IDLE", 4);
        IDLE = r13;
        f3923a = new StateType[]{r5, r10, r11, r12, r13};
    }

    public static StateType valueOf(String r5) {
        return (StateType) Enum.valueOf(StateType.class, r5);
    }

    public static StateType[] values() {
        return (StateType[]) f3923a.clone();
    }
}
