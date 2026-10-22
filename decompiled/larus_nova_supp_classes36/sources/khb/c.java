package khb;

import android.view.View;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.export.feedcard.e;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.flow.feed.action.FlowFeedActionMode;
import com.ss.android.lark.flow.feed.cell.thread.FlowThreadAction;
import com.ss.android.lark.flow.feed.cell.thread.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements e {
    public c() {
    }

    public final f a() {
        return new d();
    }

    public final AppFeedCardType bizType() {
        return AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
    }

    public final FeedCard.Type type() {
        return FeedCard.Type.THREAD;
    }

    public final h b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        return new b();
    }

    public final aeb.f c(com.ss.android.lark.feed.export.feedcard.d r3) {
        Intrinsics.checkNotNullParameter(r3, "feedCardContext");
        return new FlowThreadAction(r3, FlowFeedActionMode.SIDEBAR);
    }
}
