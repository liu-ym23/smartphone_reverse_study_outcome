package com.ss.android.lark.flow.feed.cell.thread;

import aeb.f;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import com.ss.android.lark.flow.feed.action.FlowFeedActionMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadAction extends FlowBaseActionHandler implements f {
    public final com.ss.android.lark.feed.export.feedcard.d c;
    public final FlowFeedActionMode d;

    public static final class a {
        public static boolean a(ThreadFeedPreview r5) {
            Intrinsics.checkNotNullParameter(r5, "data");
            if (r5.getUnreadCount() > 0) goto L5;
        L7:
            return false;
        L5:
            if (com.ss.android.lark.feed.shared.data.appconfig.a.a(r5.getType()) == false) goto L7;
            return true;
        }
    }

    static {
    }

    public final void b(FeedActionType r2, FeedActionStatus r3, UIFeedCard r4) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionStatus");
        Intrinsics.checkNotNullParameter(r4, "data");
    }

    public final List<aeb.c> c() {
        return CollectionsKt.emptyList();
    }

    public /* synthetic */ FlowThreadAction(com.ss.android.lark.feed.export.feedcard.d r2) {
        this(r2, FlowFeedActionMode.MAIN_FEED);
    }

    public final void a(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        fhb.a.e(r2, fhb.a.b(this.c));
    }

    public final List<FeedActionType> e(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        if (this.d.getSupportLeftSwipe() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return q(r2);
    }

    public final List<FeedActionType> f(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.emptyList();
    }

    public final void g(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        fhb.a.g(r2, fhb.a.b(this.c));
    }

    public final List<FeedActionType> h(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        if (this.d.getSupportLeftSwipe() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return q(r2);
    }

    public final List<FeedActionType> k(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.emptyList();
    }

    public final void l(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
    }

    public final List<FeedActionType> n(UIFeedCard r7) {
        Intrinsics.checkNotNullParameter(r7, "uiFeedCard");
        ArrayList r0 = new ArrayList();
        if ((r7 instanceof ThreadFeedPreview) == false) goto L5;
        ThreadFeedPreview r1 = (ThreadFeedPreview) r7;
    L6:
        if (r1 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "getSupportLongClickActionTypes: unsupported id=" + r7.getId() + ", card=" + r7.getClass().getSimpleName());
        return r0;
    L9:
        r0.add(FeedActionType.TOPPING_IN_LIST);
        if (a.a(r1) == false) goto L12;
        r0.add(FeedActionType.CLEAR_UNREAD);
    L12:
        Intrinsics.checkNotNullParameter(r1, "data");
        if (r1.getUnreadCount() != 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L19;
        r0.add(FeedActionType.MARK_UNREAD);
    L19:
        if (r1.getType() != FeedCard.Type.MSG_THREAD) goto L21;
        r0.add(FeedActionType.NO_DISTURB);
    L21:
        r0.add(FeedActionType.DONE);
        return r0;
    L15:
        r8 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final List<FeedActionType> q(UIFeedCard r6) {
        ArrayList r0 = new ArrayList();
        if ((r6 instanceof ThreadFeedPreview) == false) goto L5;
        ThreadFeedPreview r1 = (ThreadFeedPreview) r6;
    L6:
        if (r1 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "getSwipeLeftActions: unsupported id=" + r6.getId() + ", card=" + r6.getClass().getSimpleName());
        return r0;
    L9:
        r0.add(FeedActionType.TOPPING_IN_LIST);
        if (a.a(r1) == false) goto L12;
        r0.add(FeedActionType.CLEAR_UNREAD);
    L12:
        Intrinsics.checkNotNullParameter(r1, "data");
        if (r1.getUnreadCount() != 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        r0.add(FeedActionType.MARK_UNREAD);
    L18:
        return r0;
    L15:
        r7 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public FlowThreadAction(com.ss.android.lark.feed.export.feedcard.d r2, FlowFeedActionMode r3) {
        Intrinsics.checkNotNullParameter(r2, "feedContext");
        Intrinsics.checkNotNullParameter(r3, "actionMode");
        super(r2);
        this.c = r2;
        this.d = r3;
    }

    public final void j(UIFeedCard r7, View r8, int r9, ActionScene r10) {
        Intrinsics.checkNotNullParameter(r7, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r8, "clickView");
        Intrinsics.checkNotNullParameter(r10, "actionScene");
        fhb.a.d(r7, fhb.a.b(this.c));
        FeedSidebarItemsMoltenViewModel r11 = p();
        if ((r11 instanceof FeedSidebarItemsMoltenViewModel) == false) goto L5;
        FeedSidebarItemsMoltenViewModel r12 = r11;
    L6:
        if (r12 == null) goto L8;
        r12.setFlowClickHint(r7.getId());
    L8:
        Fragment r13 = this.c.getHost();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), null, null, new FlowThreadAction$onItemClick$1$1(r7, this, r13, null), 3, null);
        return;
    L5:
        r12 = null;
        goto L6
    }
}
