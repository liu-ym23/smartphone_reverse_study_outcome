package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SeatUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[SeatUpdateType.values().length];
        a = r0;
        r0[SeatUpdateType.UPDATE_BY_UID.ordinal()] = 1;
        r0[SeatUpdateType.UPDATE_BY_POS.ordinal()] = 2;
        r0[SeatUpdateType.UPDATE_ALL.ordinal()] = 3;
        r0[SeatUpdateType.RESET.ordinal()] = 4;
    }
}
