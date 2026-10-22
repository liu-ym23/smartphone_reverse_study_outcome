package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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
        RunStatus r0 = new RunStatus("RUN_STATUS_NONE", 0);
        RUN_STATUS_NONE = r0;
        RunStatus r1 = new RunStatus("RUN_STATUS_PAUSE", 1);
        RUN_STATUS_PAUSE = r1;
        RunStatus r3 = new RunStatus("RUN_STATUS_CANCELED", 2);
        RUN_STATUS_CANCELED = r3;
        RunStatus r5 = new RunStatus("RUN_STATUS_ERROR", 3);
        RUN_STATUS_ERROR = r5;
        RunStatus r7 = new RunStatus("RUN_STATUS_END_RIGHT_NOW", 4);
        RUN_STATUS_END_RIGHT_NOW = r7;
        RunStatus r9 = new RunStatus("RUN_STATUS_WAITING_ASYNC_HANDLER", 5);
        RUN_STATUS_WAITING_ASYNC_HANDLER = r9;
        RunStatus r11 = new RunStatus("RUN_STATUS_END_FOR_FILE_EXIST", 6);
        RUN_STATUS_END_FOR_FILE_EXIST = r11;
        RunStatus r13 = new RunStatus("RUN_STATUS_INTERCEPT", 7);
        RUN_STATUS_INTERCEPT = r13;
        RunStatus r15 = new RunStatus("RUN_STATUS_COMPLETED", 8);
        RUN_STATUS_COMPLETED = r15;
        $VALUES = new RunStatus[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    public static RunStatus[] values() {
        return (RunStatus[]) $VALUES.clone();
    }

    public static RunStatus valueOf(String r1) {
        return (RunStatus) a.a(RunStatus.class, r1);
    }

    private RunStatus(String r1, int r2) {
        super(r1, r2);
    }
}
