package com.ss.android.lark.flow.feed.action;

import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.feed.export.feedcard.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class FlowBaseActionHandler {
    public final d a;
    public final Lazy b;

    public final LarkFeedListViewModel p() {
        return (LarkFeedListViewModel) this.b.getValue();
    }

    public FlowBaseActionHandler(d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        this.a = r2;
        this.b = LazyKt.lazy(new FlowBaseActionHandler$feedItemsViewModel$2(this));
    }
}
