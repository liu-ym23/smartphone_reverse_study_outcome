package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum RunStatus extends Enum<RunStatus> {
    private static final /* synthetic */ RunStatus[] $VALUES = null;
    public static final RunStatus RUN_STATUS_CANCELED = null;
    public static final RunStatus RUN_STATUS_COMPLETED = null;
    public static final RunStatus RUN_STATUS_END_FOR_FILE_EXIST = null;
    public static final RunStatus RUN_STATUS_END_RIGHT_NOW = null;
    public static final RunStatus RUN_STATUS_ERROR = null;
    public static final RunStatus RUN_STATUS_INTERCEPT = null;
    public static final RunStatus RUN_STATUS_NONE = null;
    public static final RunStatus RUN_STATUS_PAUSE = null;
    public static final RunStatus RUN_STATUS_WAITING_ASYNC_HANDLER = null;

    static {
        RunStatus r10 = new RunStatus("RUN_STATUS_NONE", 0);
        RUN_STATUS_NONE = r10;
        RunStatus r11 = new RunStatus("RUN_STATUS_PAUSE", 1);
        RUN_STATUS_PAUSE = r11;
        RunStatus r12 = new RunStatus("RUN_STATUS_CANCELED", 2);
        RUN_STATUS_CANCELED = r12;
        RunStatus r13 = new RunStatus("RUN_STATUS_ERROR", 3);
        RUN_STATUS_ERROR = r13;
        RunStatus r14 = new RunStatus("RUN_STATUS_END_RIGHT_NOW", 4);
        RUN_STATUS_END_RIGHT_NOW = r14;
        RunStatus r15 = new RunStatus("RUN_STATUS_WAITING_ASYNC_HANDLER", 5);
        RUN_STATUS_WAITING_ASYNC_HANDLER = r15;
        RunStatus r16 = new RunStatus("RUN_STATUS_END_FOR_FILE_EXIST", 6);
        RUN_STATUS_END_FOR_FILE_EXIST = r16;
        RunStatus r17 = new RunStatus("RUN_STATUS_INTERCEPT", 7);
        RUN_STATUS_INTERCEPT = r17;
        RunStatus r18 = new RunStatus("RUN_STATUS_COMPLETED", 8);
        RUN_STATUS_COMPLETED = r18;
        $VALUES = new RunStatus[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    private RunStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static RunStatus valueOf(String r10) {
        return (RunStatus) Enum.valueOf(RunStatus.class, r10);
    }

    public static RunStatus[] values() {
        return (RunStatus[]) $VALUES.clone();
    }
}
