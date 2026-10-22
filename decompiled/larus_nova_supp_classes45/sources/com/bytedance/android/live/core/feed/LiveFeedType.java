package com.bytedance.android.live.core.feed;

import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/feed/LiveFeedType;", "", "", "lowerName", "OUT_FLOW", "INNER_FLOW", "DRAWER", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveFeedType extends Enum<LiveFeedType> {
    public static final LiveFeedType DRAWER = null;
    public static final LiveFeedType INNER_FLOW = null;
    public static final LiveFeedType OUT_FLOW = null;
    public static final /* synthetic */ LiveFeedType[] a = null;

    static {
        LiveFeedType r1 = new LiveFeedType("OUT_FLOW", 0);
        OUT_FLOW = r1;
        LiveFeedType r2 = new LiveFeedType("INNER_FLOW", 1);
        INNER_FLOW = r2;
        LiveFeedType r3 = new LiveFeedType("DRAWER", 2);
        DRAWER = r3;
        a = new LiveFeedType[]{r1, r2, r3};
    }

    public static LiveFeedType valueOf(String r1) {
        return (LiveFeedType) r27.a.a(LiveFeedType.class, r1);
    }

    public static LiveFeedType[] values() {
        return (LiveFeedType[]) a.clone();
    }

    public final String lowerName() {
        String r0 = name();
        Locale r1 = Locale.ENGLISH;
        if (r0 == null) goto L7;
        return r0.toLowerCase(r1);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public LiveFeedType(String r1, int r2) {
        super(r1, r2);
    }
}
