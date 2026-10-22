package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PSMessageHeatState.values().length];
        a = r0;
        r0[PSMessageHeatState.HOT.ordinal()] = 1;
        r0[PSMessageHeatState.NORMAL.ordinal()] = 2;
        r0[PSMessageHeatState.COLD.ordinal()] = 3;
    }
}
