package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes2.dex */
public final enum RetryCheckStatus extends Enum<RetryCheckStatus> {
    private static final /* synthetic */ RetryCheckStatus[] $VALUES = null;
    public static final RetryCheckStatus CONTINUE = null;
    public static final RetryCheckStatus RETURN = null;

    static {
        RetryCheckStatus r10 = new RetryCheckStatus("RETURN", 0);
        RETURN = r10;
        RetryCheckStatus r11 = new RetryCheckStatus("CONTINUE", 1);
        CONTINUE = r11;
        $VALUES = new RetryCheckStatus[]{r10, r11};
    }

    private RetryCheckStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static RetryCheckStatus valueOf(String r10) {
        return (RetryCheckStatus) Enum.valueOf(RetryCheckStatus.class, r10);
    }

    public static RetryCheckStatus[] values() {
        return (RetryCheckStatus[]) $VALUES.clone();
    }
}
