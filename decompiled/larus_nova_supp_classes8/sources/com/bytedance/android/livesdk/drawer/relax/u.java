package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u {
    public final Function0<? extends ArrayList<FeedItem>> a;
    public final Function0<FeedExtra> b;
    public final Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> c;
    public final Function1<? super Boolean, Unit> d;

    public u(Function0<? extends ArrayList<FeedItem>> r2, Function0<FeedExtra> r3, Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "historyList");
        Intrinsics.checkNotNullParameter(r3, "historyExtraData");
        Intrinsics.checkNotNullParameter(r4, "setHistoryList");
        Intrinsics.checkNotNullParameter(r5, "fetchHistory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
