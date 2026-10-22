package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z {
    public final Function0<? extends FeedItem> a;
    public final Function0<String> b;
    public final Function0<String> c;
    public final Function0<Long> d;

    public z(Function0<? extends FeedItem> r2, Function0<String> r3, Function0<String> r4, Function0<Long> r5) {
        Intrinsics.checkNotNullParameter(r2, "feedItem");
        Intrinsics.checkNotNullParameter(r3, "aggregateEnterFrom");
        Intrinsics.checkNotNullParameter(r4, "aggregateEnterMethod");
        Intrinsics.checkNotNullParameter(r5, "aggregateReplaceTabId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
