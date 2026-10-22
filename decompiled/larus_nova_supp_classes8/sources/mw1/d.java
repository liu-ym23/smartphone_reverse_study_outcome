package mw1;

import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[FeedType.values().length];
        r0[FeedType.FOLLOW_FEED.ordinal()] = 1;
        r0[FeedType.COMMON_FEED.ordinal()] = 2;
        int[] r1 = new int[FeedStyle.values().length];
        a = r1;
        r1[FeedStyle.SINGLE_LIST_H.ordinal()] = 1;
        r1[FeedStyle.DOUBLE_LIST_D.ordinal()] = 2;
        r1[FeedStyle.SIMPLE_LIST.ordinal()] = 3;
        int[] r2 = new int[CardStyle.values().length];
        b = r2;
        r2[CardStyle.PREVIEW_CARD_H.ordinal()] = 1;
    }
}
