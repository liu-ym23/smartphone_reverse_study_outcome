package com.ss.android.lark.flow.feed.action.topping_in_list;

import aeb.d;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowToppingInListHandler extends FlowBaseActionHandler implements d {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    public FlowToppingInListHandler(com.ss.android.lark.feed.export.feedcard.d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        super(r2);
    }

    public final void o(UIFeedCard r13, FeedActionEvent r14, aeb.a r15) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "actionStatusListener");
        com.ss.android.lark.flow.feed.utils.b.d("ToppingHandler", "feed item shortcut click: " + r13.getId());
        FeedActionType r1 = FeedActionType.TOPPING_IN_LIST;
        r15.a(r13, r1, FeedActionStatus.START, r14);
        HashMap<String, String> r2 = fhb.a.b(this.a);
        if (UIFeedCardExtraKt.isOnTop(r13) == false) goto L5;
        Intrinsics.checkNotNullParameter(r13, "feedCard");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "flowHitpointParams");
        fhb.a.c("unpin_chat", r13, r14, r2);
    L6:
        LarkFeedListViewModel r5 = p();
        if (r5 == null) goto L9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r5), null, null, new FlowToppingInListHandler$handle$1$1(r13, r5, r15, r14, this, null), 3, null);
    L9:
        r15.a(r13, r1, FeedActionStatus.END, r14);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r13, "feedCard");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "flowHitpointParams");
        fhb.a.c("pin_chat", r13, r14, r2);
        goto L6
    }
}
