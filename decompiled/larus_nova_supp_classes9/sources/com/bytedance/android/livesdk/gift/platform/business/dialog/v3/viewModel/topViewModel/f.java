package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.AnimMoveType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[AnimMoveType.values().length];
        a = r0;
        AnimMoveType r1 = AnimMoveType.Left;
        r0[r1.ordinal()] = 1;
        AnimMoveType r2 = AnimMoveType.Right;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[AnimMoveType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
