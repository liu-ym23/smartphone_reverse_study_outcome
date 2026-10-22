package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    public final Function0<Boolean> a;
    public final Function0<? extends ArrayList<FeedItem>> b;

    public q(Function0<Boolean> r2, Function0<? extends ArrayList<FeedItem>> r3) {
        Intrinsics.checkNotNullParameter(r2, "enableLiveHistory");
        Intrinsics.checkNotNullParameter(r3, "historyList");
        this.a = r2;
        this.b = r3;
    }
}
