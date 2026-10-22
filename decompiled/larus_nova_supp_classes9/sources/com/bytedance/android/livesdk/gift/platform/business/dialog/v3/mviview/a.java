package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ComboState.values().length];
        a = r0;
        r0[ComboState.IDLE.ordinal()] = 1;
        r0[ComboState.ON_SINGLE_CLICK.ordinal()] = 2;
        r0[ComboState.ON_LONG_CLICK.ordinal()] = 3;
        r0[ComboState.ON_COUNT_DOWN.ordinal()] = 4;
    }
}
