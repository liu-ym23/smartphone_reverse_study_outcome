package bx1;

import com.bytedance.android.livesdkapi.feed.constant.FeedType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[FeedType.values().length];
        a = r0;
        r0[FeedType.COMMON_FEED.ordinal()] = 1;
        r0[FeedType.HOT_FEED.ordinal()] = 2;
        r0[FeedType.FOLLOW_FEED.ordinal()] = 3;
    }
}
