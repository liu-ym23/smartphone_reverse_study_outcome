package com.ss.android.socialbase.downloader.exception;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum RetryCheckStatus extends Enum<RetryCheckStatus> {
    private static final /* synthetic */ RetryCheckStatus[] $VALUES = null;
    public static final RetryCheckStatus CONTINUE = null;
    public static final RetryCheckStatus RETURN = null;

    static {
        RetryCheckStatus r0 = new RetryCheckStatus("RETURN", 0);
        RETURN = r0;
        RetryCheckStatus r1 = new RetryCheckStatus("CONTINUE", 1);
        CONTINUE = r1;
        $VALUES = new RetryCheckStatus[]{r0, r1};
    }

    public static RetryCheckStatus[] values() {
        return (RetryCheckStatus[]) $VALUES.clone();
    }

    public static RetryCheckStatus valueOf(String r1) {
        return (RetryCheckStatus) a.a(RetryCheckStatus.class, r1);
    }

    private RetryCheckStatus(String r1, int r2) {
        super(r1, r2);
    }
}
