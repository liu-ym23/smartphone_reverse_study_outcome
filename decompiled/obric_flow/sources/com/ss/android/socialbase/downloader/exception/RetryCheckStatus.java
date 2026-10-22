package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes3.dex */
public final enum RetryCheckStatus extends Enum<RetryCheckStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RetryCheckStatus f15604a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RetryCheckStatus f15605b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ RetryCheckStatus[] f15606c = null;

    static {
        RetryCheckStatus r5 = new RetryCheckStatus("RETURN", 0);
        f15604a = r5;
        RetryCheckStatus r10 = new RetryCheckStatus("CONTINUE", 1);
        f15605b = r10;
        f15606c = new RetryCheckStatus[]{r5, r10};
    }

    public RetryCheckStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static RetryCheckStatus valueOf(String r5) {
        return (RetryCheckStatus) Enum.valueOf(RetryCheckStatus.class, r5);
    }

    public static RetryCheckStatus[] values() {
        return (RetryCheckStatus[]) f15606c.clone();
    }
}
