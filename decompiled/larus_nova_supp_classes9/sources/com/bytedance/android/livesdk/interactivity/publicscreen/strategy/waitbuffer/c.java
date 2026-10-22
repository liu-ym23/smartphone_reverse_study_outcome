package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PublicScreenIndividualPriorityState.values().length];
        a = r0;
        r0[PublicScreenIndividualPriorityState.HIT_ALL.ordinal()] = 1;
        r0[PublicScreenIndividualPriorityState.HIGH_PROTECT.ordinal()] = 2;
        r0[PublicScreenIndividualPriorityState.LOW_DEGRADE.ordinal()] = 3;
    }
}
