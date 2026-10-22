package com.ss.android.lark.flow.feed.action.mute;

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
public final class FlowNoDisturbActionHandler extends FlowBaseActionHandler implements d {
    public final com.ss.android.lark.feed.export.feedcard.d c;

    public static final class a {
    }

    static {
    }

    public FlowNoDisturbActionHandler(com.ss.android.lark.feed.export.feedcard.d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedContext");
        super(r2);
        this.c = r2;
    }

    public final void o(UIFeedCard r13, FeedActionEvent r14, aeb.a r15) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "actionStatusListener");
        FeedActionType r1 = FeedActionType.NO_DISTURB;
        r15.a(r13, r1, FeedActionStatus.START, r14);
        HashMap<String, String> r2 = fhb.a.b(this.c);
        Intrinsics.checkNotNullParameter(r13, "feedCard");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "flowHitpointParams");
        fhb.a.c("mute_chat", r13, r14, r2);
        LarkFeedListViewModel r5 = p();
        if (r5 == null) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r5), null, null, new FlowNoDisturbActionHandler$handle$1$1(r13, r5, r15, r14, this, null), 3, null);
    L5:
        r15.a(r13, r1, FeedActionStatus.END, r14);
    }
}
