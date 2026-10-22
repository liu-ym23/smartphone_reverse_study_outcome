package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[FeedMultiPlayMode.values().length];
        a = r0;
        FeedMultiPlayMode r1 = FeedMultiPlayMode.VOTE;
        r0[r1.ordinal()] = 1;
        FeedMultiPlayMode r2 = FeedMultiPlayMode.PERSONAL_PK;
        r0[r2.ordinal()] = 2;
        FeedMultiPlayMode r4 = FeedMultiPlayMode.TEAM_PK;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[FeedMultiPlayMode.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[FeedMultiPlayMode.values().length];
        c = r5;
        r5[r1.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
        r5[r4.ordinal()] = 3;
    }
}
