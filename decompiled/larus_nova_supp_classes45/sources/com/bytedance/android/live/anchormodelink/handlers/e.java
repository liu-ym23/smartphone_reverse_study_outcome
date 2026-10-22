package com.bytedance.android.live.anchormodelink.handlers;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DynamicCenterUpdateType.values().length];
        a = r0;
        r0[DynamicCenterUpdateType.registerSEI.ordinal()] = 1;
        r0[DynamicCenterUpdateType.videoLinkmicAction.ordinal()] = 2;
        int[] r1 = new int[DynamicCenterGetType.values().length];
        b = r1;
        r1[DynamicCenterGetType.latestSEI.ordinal()] = 1;
    }
}
