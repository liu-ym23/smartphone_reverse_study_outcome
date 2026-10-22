package com.ss.android.lark.flow.feed.action.markunread;

import aeb.d;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMarkUnreadActionHandler extends FlowBaseActionHandler implements d {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    public FlowMarkUnreadActionHandler(com.ss.android.lark.feed.export.feedcard.d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        super(r2);
    }

    public final void o(UIFeedCard r13, FeedActionEvent r14, aeb.a r15) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "actionStatusListener");
        FeedActionType r2 = FeedActionType.MARK_UNREAD;
        r15.a(r13, r2, FeedActionStatus.START, r14);
        if (r14 != FeedActionEvent.LONG_CLICK) goto L5;
        FeedFolder r3 = this.a.f();
        UpdateUnreadStatusScene r5 = UpdateUnreadStatusScene.FEED_ITEM;
        int r6 = qeb.b.a;
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r5, "actionScene");
        qeb.b.a("feed_press_click", r2, r13, r3, r5);
    L6:
        HashMap<String, String> r0 = fhb.a.b(this.a);
        Intrinsics.checkNotNullParameter(r13, "feedCard");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r0, "flowHitpointParams");
        fhb.a.c("mark_unread_chat", r13, r14, r0);
        LarkFeedListViewModel r4 = p();
        if (r4 == null) goto L9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r4), null, null, new FlowMarkUnreadActionHandler$handle$1$1(r4, r13, r15, r14, this, null), 3, null);
    L9:
        r15.a(r13, r2, FeedActionStatus.END, r14);
        return;
    L5:
        FeedFolder r7 = this.a.f();
        int r8 = qeb.b.a;
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r2, "actionType");
        qeb.b.a("feed_leftslide_detail_click", r2, r13, r7, UpdateUnreadStatusScene.FEED_ITEM);
        goto L6
    }
}
