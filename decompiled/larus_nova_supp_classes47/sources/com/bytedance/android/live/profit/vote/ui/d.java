package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteCompare;
import com.bytedance.android.live.profit.vote.model.VoteConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;
    public static final /* synthetic */ int[] e = null;
    public static final /* synthetic */ int[] f = null;
    public static final /* synthetic */ int[] g = null;

    static {
        int[] r0 = new int[VoteCompare.values().length];
        a = r0;
        VoteCompare r1 = VoteCompare.LeftWin;
        r0[r1.ordinal()] = 1;
        VoteCompare r2 = VoteCompare.RightWin;
        r0[r2.ordinal()] = 2;
        VoteCompare r4 = VoteCompare.Draw;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[VoteCompare.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[VoteCompare.values().length];
        c = r5;
        r5[r1.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
        r5[r4.ordinal()] = 3;
        int[] r6 = new int[VoteCompare.values().length];
        d = r6;
        r6[r1.ordinal()] = 1;
        r6[r2.ordinal()] = 2;
        r6[r4.ordinal()] = 3;
        int[] r7 = new int[VoteCompare.values().length];
        e = r7;
        r7[r1.ordinal()] = 1;
        r7[r2.ordinal()] = 2;
        r7[r4.ordinal()] = 3;
        int[] r8 = new int[VoteConfig.Plan.values().length];
        f = r8;
        r8[VoteConfig.Plan.A.ordinal()] = 1;
        r8[VoteConfig.Plan.B.ordinal()] = 2;
        r8[VoteConfig.Plan.C.ordinal()] = 3;
        int[] r9 = new int[VoteCompare.values().length];
        g = r9;
        r9[r1.ordinal()] = 1;
        r9[r2.ordinal()] = 2;
        r9[r4.ordinal()] = 3;
    }
}
