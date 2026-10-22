package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.timon.calendar.ResultCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class j7 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ResultCode.values().length];
        a = r0;
        ResultCode r1 = ResultCode.ArgumentError;
        r0[r1.ordinal()] = 1;
        ResultCode r2 = ResultCode.NoPermission;
        r0[r2.ordinal()] = 2;
        ResultCode r4 = ResultCode.NoAccount;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[ResultCode.values().length];
        b = r3;
        r3[ResultCode.NotFound.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r2.ordinal()] = 3;
        r3[r4.ordinal()] = 4;
    }
}
