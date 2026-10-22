package com.bytedance.android.live.revlink.impl.pk.ui;

import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.IGroupRivals;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[IGroupRivals.GroupType.values().length];
        a = r0;
        IGroupRivals.GroupType r1 = IGroupRivals.GroupType.GroupRivalsSearchPopularityRank;
        r0[r1.ordinal()] = 1;
        IGroupRivals.GroupType r2 = IGroupRivals.GroupType.GroupRivalsSearchHourlyRank;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[IGroupRivals.GroupType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        int[] r4 = new int[IGroupRivals.GroupType.values().length];
        c = r4;
        r4[r1.ordinal()] = 1;
        r4[r2.ordinal()] = 2;
        int[] r5 = new int[SearchSourceFlag.values().length];
        d = r5;
        r5[SearchSourceFlag.INVITE_LINKING.ordinal()] = 1;
        r5[SearchSourceFlag.MAIN_LINK.ordinal()] = 2;
    }
}
