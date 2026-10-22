package com.ss.android.lark.flow.feed.action.done;

import aeb.d;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowDoneActionHandler extends FlowBaseActionHandler implements d {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    public FlowDoneActionHandler(com.ss.android.lark.feed.export.feedcard.d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        super(r2);
    }

    public final void o(UIFeedCard r13, FeedActionEvent r14, aeb.a r15) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "actionStatusListener");
        FeedActionType r1 = FeedActionType.DONE;
        r15.a(r13, r1, FeedActionStatus.START, r14);
        int r2 = fhb.a.a;
        HashMap<String, String> r3 = fhb.a.b(this.a);
        Intrinsics.checkNotNullParameter(r13, "feedCard");
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r3, "flowHitpointParams");
        String r0 = fhb.a.a(r13);
        String r4 = r3.get("is_navigation_sidebar");
        if (r4 != null) goto L5;
        r4 = "-1";
    L5:
        int r5 = fhb.a.C0261a.a[r14.ordinal()];
        if (r5 != 1) goto L8;
    L11:
        String r6 = "slide_bot_list";
    L12:
        JSONObject r7 = new JSONObject().put("click_from", r6).put("is_navigation_sidebar", r4);
        String r8 = r3.get("current_page");
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        Statistics.sendEvent("hide_chat", r7.put("current_page", r8).put("chat_type", r0));
        if (r14 != FeedActionEvent.LONG_CLICK) goto L18;
        int r9 = qeb.a.a;
        qeb.a.a.a("finished", r13);
    L18:
        LarkFeedListViewModel r10 = p();
        if (r10 == null) goto L21;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r10), null, null, new FlowDoneActionHandler$handle$1$1(r10, r13, r15, r14, this, null), 3, null);
    L21:
        r15.a(r13, r1, FeedActionStatus.END, r14);
        return;
    L8:
        if (r5 != 2) goto L11;
        r6 = "long_press_cell";
        goto L12
    }
}
