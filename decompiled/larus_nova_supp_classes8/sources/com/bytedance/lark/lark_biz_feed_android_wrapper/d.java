package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.molten_livequery_wrapper.f;
import com.bytedance.lark.pb.feed.v1.LarkFeedListItem;
import com.bytedance.lark.pb.feed.v1.LarkFeedListKeyChange;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements f.a<LarkFeedListItem> {
    public d() {
    }

    public final Object b(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return (LarkFeedListKeyChange) LarkFeedListKeyChange.ADAPTER.decode(r2);
    }

    public final Object a(int r1, byte[] r2, Object r3) {
        LarkFeedListItem r4 = (LarkFeedListItem) r3;
        Intrinsics.checkNotNullParameter(r2, "source");
        LarkFeedListItem r5 = (LarkFeedListItem) LarkFeedListItem.ADAPTER.decode(r2);
        Intrinsics.checkNotNull(r5);
        return r5;
    }
}
