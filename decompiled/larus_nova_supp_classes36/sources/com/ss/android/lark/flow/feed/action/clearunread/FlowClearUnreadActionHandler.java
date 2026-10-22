package com.ss.android.lark.flow.feed.action.clearunread;

import aeb.d;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowClearUnreadActionHandler extends FlowBaseActionHandler implements d {
    public FlowClearUnreadActionHandler(com.ss.android.lark.feed.export.feedcard.d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        super(r2);
    }

    public final void o(UIFeedCard r13, FeedActionEvent r14, aeb.a r15) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "actionStatusListener");
        FeedActionType r1 = FeedActionType.CLEAR_UNREAD;
        r15.a(r13, r1, FeedActionStatus.START, r14);
        HashMap<String, String> r2 = fhb.a.b(this.a);
        Intrinsics.checkNotNullParameter(r13, "feedCard");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "flowHitpointParams");
        fhb.a.c("mark_read_chat", r13, r14, r2);
        LarkFeedListViewModel r4 = p();
        if (r4 == null) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r4), null, null, new FlowClearUnreadActionHandler$handle$1$1(r4, r13, r15, r14, this, null), 3, null);
    L5:
        r15.a(r13, r1, FeedActionStatus.END, r14);
    }
}
