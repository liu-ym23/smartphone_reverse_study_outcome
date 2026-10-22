package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {
    public final Function0<? extends FeedItem> a;
    public final l0 b;

    public n(Function0<? extends FeedItem> r2, l0 r3) {
        Intrinsics.checkNotNullParameter(r2, "feedItem");
        Intrinsics.checkNotNullParameter(r3, "tabItem");
        this.a = r2;
        this.b = r3;
    }
}
