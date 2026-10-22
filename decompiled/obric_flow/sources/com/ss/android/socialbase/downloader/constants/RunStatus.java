package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public final enum RunStatus extends Enum<RunStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RunStatus f15283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RunStatus f15284b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RunStatus f15285c = null;
    public static final RunStatus d = null;
    public static final RunStatus e = null;
    public static final RunStatus f = null;
    public static final RunStatus g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RunStatus f15286h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ RunStatus[] f15287i = null;

    static {
        RunStatus r5 = new RunStatus("RUN_STATUS_NONE", 0);
        f15283a = r5;
        RunStatus r10 = new RunStatus("RUN_STATUS_PAUSE", 1);
        f15284b = r10;
        RunStatus r11 = new RunStatus("RUN_STATUS_CANCELED", 2);
        f15285c = r11;
        RunStatus r12 = new RunStatus("RUN_STATUS_ERROR", 3);
        RunStatus r13 = new RunStatus("RUN_STATUS_END_RIGHT_NOW", 4);
        d = r13;
        RunStatus r14 = new RunStatus("RUN_STATUS_WAITING_ASYNC_HANDLER", 5);
        e = r14;
        RunStatus r15 = new RunStatus("RUN_STATUS_END_FOR_FILE_EXIST", 6);
        f = r15;
        RunStatus r16 = new RunStatus("RUN_STATUS_INTERCEPT", 7);
        g = r16;
        RunStatus r17 = new RunStatus("RUN_STATUS_COMPLETED", 8);
        f15286h = r17;
        f15287i = new RunStatus[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public RunStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static RunStatus valueOf(String r5) {
        return (RunStatus) Enum.valueOf(RunStatus.class, r5);
    }

    public static RunStatus[] values() {
        return (RunStatus[]) f15287i.clone();
    }
}
