package com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/feed/viewstate/FeedMultiPlayMode;", "", "PERSONAL_PK", "TEAM_PK", "VOTE", "BREAK_THROUGH", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FeedMultiPlayMode extends Enum<FeedMultiPlayMode> {
    public static final FeedMultiPlayMode BREAK_THROUGH = null;
    public static final FeedMultiPlayMode PERSONAL_PK = null;
    public static final FeedMultiPlayMode TEAM_PK = null;
    public static final FeedMultiPlayMode VOTE = null;
    public static final /* synthetic */ FeedMultiPlayMode[] a = null;

    static {
        FeedMultiPlayMode r1 = new FeedMultiPlayMode("PERSONAL_PK", 0);
        PERSONAL_PK = r1;
        FeedMultiPlayMode r2 = new FeedMultiPlayMode("TEAM_PK", 1);
        TEAM_PK = r2;
        FeedMultiPlayMode r3 = new FeedMultiPlayMode("VOTE", 2);
        VOTE = r3;
        FeedMultiPlayMode r4 = new FeedMultiPlayMode("BREAK_THROUGH", 3);
        BREAK_THROUGH = r4;
        a = new FeedMultiPlayMode[]{r1, r2, r3, r4};
    }

    public static FeedMultiPlayMode valueOf(String r1) {
        return (FeedMultiPlayMode) r27.a.a(FeedMultiPlayMode.class, r1);
    }

    public static FeedMultiPlayMode[] values() {
        return (FeedMultiPlayMode[]) a.clone();
    }

    public FeedMultiPlayMode(String r1, int r2) {
        super(r1, r2);
    }
}
