package com.bytedance.android.live.core.feed;

import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final String a(String r6, String r7) {
        LiveFeedType r0 = LiveFeedType.OUT_FLOW;
        String r1 = c.a(r6, r7, r0).getLiveFeedUrl();
        c.b(r6, r7, r0, r1, !StringsKt.contains$default(r1, "channel_id=999999", false, 2, null));
        return r1;
    }
}
