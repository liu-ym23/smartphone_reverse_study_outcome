package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[SelectedStatus.values().length];
        a = r0;
        r0[SelectedStatus.GROUP.ordinal()] = 1;
        r0[SelectedStatus.CLICK.ordinal()] = 2;
        r0[SelectedStatus.LOCATE.ordinal()] = 3;
        int[] r1 = new int[ItemStatus.values().length];
        b = r1;
        r1[ItemStatus.SELECTED.ordinal()] = 1;
        r1[ItemStatus.IDLE.ordinal()] = 2;
        r1[ItemStatus.GONE.ordinal()] = 3;
    }
}
