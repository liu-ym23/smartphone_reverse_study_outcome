package com.ss.android.lark.feed.shared.fg;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedFgSyncUtil {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FeedFgSyncUtil$enableFeedGroup$2.INSTANCE);
    }
}
