package com.bytedance.android.live.room.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[AudienceViewInfo.values().length];
        a = r0;
        AudienceViewInfo r1 = AudienceViewInfo.TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE;
        r0[r1.ordinal()] = 1;
        AudienceViewInfo r2 = AudienceViewInfo.TTLIVE_VIEW_AUDIENCE_LIST_ITEM;
        r0[r2.ordinal()] = 2;
        AudienceViewInfo r4 = AudienceViewInfo.TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[AudienceViewInfo.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
    }
}
