package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class y {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PlayMode.values().length];
        PlayMode r1 = PlayMode.PERSONAL_PK;
        r0[r1.ordinal()] = 1;
        PlayMode r2 = PlayMode.TEAM_PK;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[PlayMode.values().length];
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        int[] r4 = new int[PlayMode.values().length];
        a = r4;
        r4[r1.ordinal()] = 1;
        r4[r2.ordinal()] = 2;
    }
}
