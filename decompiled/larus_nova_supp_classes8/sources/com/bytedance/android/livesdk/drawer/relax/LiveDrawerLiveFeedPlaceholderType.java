package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerLiveFeedPlaceholderType;", "", "", "value", "J", "getValue", "()J", "LiveFeedPlaceholderTypeUnknown", "LiveFeedPlaceholderTypeRecommend", "LiveFeedPlaceholderTypeTitle", "LiveFeedPlaceholderTypeEmpty", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerLiveFeedPlaceholderType extends Enum<LiveDrawerLiveFeedPlaceholderType> {
    public static final LiveDrawerLiveFeedPlaceholderType LiveFeedPlaceholderTypeEmpty = null;
    public static final LiveDrawerLiveFeedPlaceholderType LiveFeedPlaceholderTypeRecommend = null;
    public static final LiveDrawerLiveFeedPlaceholderType LiveFeedPlaceholderTypeTitle = null;
    public static final LiveDrawerLiveFeedPlaceholderType LiveFeedPlaceholderTypeUnknown = null;
    public static final /* synthetic */ LiveDrawerLiveFeedPlaceholderType[] a = null;
    private final long value;

    static {
        LiveDrawerLiveFeedPlaceholderType r1 = new LiveDrawerLiveFeedPlaceholderType("LiveFeedPlaceholderTypeUnknown", 0, 0);
        LiveFeedPlaceholderTypeUnknown = r1;
        LiveDrawerLiveFeedPlaceholderType r2 = new LiveDrawerLiveFeedPlaceholderType("LiveFeedPlaceholderTypeRecommend", 1, 1);
        LiveFeedPlaceholderTypeRecommend = r2;
        LiveDrawerLiveFeedPlaceholderType r3 = new LiveDrawerLiveFeedPlaceholderType("LiveFeedPlaceholderTypeTitle", 2, 2);
        LiveFeedPlaceholderTypeTitle = r3;
        LiveDrawerLiveFeedPlaceholderType r4 = new LiveDrawerLiveFeedPlaceholderType("LiveFeedPlaceholderTypeEmpty", 3, 3);
        LiveFeedPlaceholderTypeEmpty = r4;
        a = new LiveDrawerLiveFeedPlaceholderType[]{r1, r2, r3, r4};
    }

    public static LiveDrawerLiveFeedPlaceholderType valueOf(String r1) {
        return (LiveDrawerLiveFeedPlaceholderType) r27.a.a(LiveDrawerLiveFeedPlaceholderType.class, r1);
    }

    public static LiveDrawerLiveFeedPlaceholderType[] values() {
        return (LiveDrawerLiveFeedPlaceholderType[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerLiveFeedPlaceholderType(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
