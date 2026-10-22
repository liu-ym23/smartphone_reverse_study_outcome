package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t {
    public final FeedItem a;
    public final Function0<FeedExtra> b;
    public final Function3<? super String, ? super Boolean, ? super String, Unit> c;

    public t(FeedItem r2, Function0<FeedExtra> r3, Function3<? super String, ? super Boolean, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "historyExtraData");
        Intrinsics.checkNotNullParameter(r4, "deleteHistory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
