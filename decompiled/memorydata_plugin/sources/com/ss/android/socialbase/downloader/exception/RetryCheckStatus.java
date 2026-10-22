package com.ss.android.socialbase.downloader.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
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

    private RetryCheckStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static RetryCheckStatus valueOf(String r2) {
        return (RetryCheckStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(RetryCheckStatus.class, r2), RetryCheckStatus.class, "com.obric.memorydata.plugin");
    }

    public static RetryCheckStatus[] values() {
        return (RetryCheckStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RetryCheckStatus[].class, "com.obric.memorydata.plugin");
    }
}
