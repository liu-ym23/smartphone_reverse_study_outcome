package ow1;

import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[FeedType.values().length];
        a = r0;
        r0[FeedType.FOLLOW_FEED.ordinal()] = 1;
        r0[FeedType.COMMON_FEED.ordinal()] = 2;
        int[] r1 = new int[CardStyle.values().length];
        b = r1;
        CardStyle r2 = CardStyle.PREVIEW_CARD_H;
        r1[r2.ordinal()] = 1;
        r1[CardStyle.SMALL_CARD_D.ordinal()] = 2;
        int[] r3 = new int[CardStyle.values().length];
        c = r3;
        r3[r2.ordinal()] = 1;
    }
}
