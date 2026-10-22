package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteCompare;
import com.bytedance.android.live.profit.vote.VoteState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[VoteState.values().length];
        a = r0;
        r0[VoteState.RESUMED.ordinal()] = 1;
        r0[VoteState.PAUSED.ordinal()] = 2;
        r0[VoteState.FINISHED.ordinal()] = 3;
        int[] r1 = new int[VoteCompare.values().length];
        b = r1;
        r1[VoteCompare.Draw.ordinal()] = 1;
        r1[VoteCompare.LeftWin.ordinal()] = 2;
        r1[VoteCompare.RightWin.ordinal()] = 3;
    }
}
