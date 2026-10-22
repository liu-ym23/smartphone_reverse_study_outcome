package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class s {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PublicScreenHeatState.values().length];
        a = r0;
        r0[PublicScreenHeatState.COLD.ordinal()] = 1;
        r0[PublicScreenHeatState.HOT.ordinal()] = 2;
        r0[PublicScreenHeatState.DEFAULT.ordinal()] = 3;
    }
}
