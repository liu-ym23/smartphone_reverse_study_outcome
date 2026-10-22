package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[VipRecordResultModel.Code.values().length];
        a = r0;
        r0[VipRecordResultModel.Code.NO_USER_PERMISSION.ordinal()] = 1;
        r0[VipRecordResultModel.Code.ILLEGAL_STATE.ordinal()] = 2;
        r0[VipRecordResultModel.Code.DURATION_TOO_SHORT.ordinal()] = 3;
        r0[VipRecordResultModel.Code.DURATION_TOO_LONG.ordinal()] = 4;
        r0[VipRecordResultModel.Code.Failed.ordinal()] = 5;
    }
}
