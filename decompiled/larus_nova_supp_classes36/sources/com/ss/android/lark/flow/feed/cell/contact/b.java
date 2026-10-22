package com.ss.android.lark.flow.feed.cell.contact;

import android.view.View;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.e;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.export.feedcard.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements e {
    public b() {
    }

    public final f a() {
        return new c();
    }

    public final AppFeedCardType bizType() {
        return AppFeedCardType.CONTACT;
    }

    public final FeedCard.Type type() {
        return FeedCard.Type.APP_FEED;
    }

    public final h b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        return new a();
    }

    public final aeb.f c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        return new FlowContactAction(r2);
    }
}
