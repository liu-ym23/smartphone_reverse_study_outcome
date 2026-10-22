package com.ss.android.lark.flow.feed.cell.contact;

import aeb.f;
import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowContactAction extends FlowBaseActionHandler implements f {
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public final List<aeb.c> c() {
        return CollectionsKt.emptyList();
    }

    public FlowContactAction(d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        super(r2);
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FlowContactAction$contactOfficeApi$2.INSTANCE);
    }

    public final void a(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        fhb.a.e(r2, fhb.a.b(this.a));
    }

    public final List<FeedActionType> e(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.listOf(FeedActionType.TOPPING_IN_LIST);
    }

    public final List<FeedActionType> f(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.emptyList();
    }

    public final void g(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        fhb.a.g(r2, fhb.a.b(this.a));
    }

    public final List<FeedActionType> h(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.listOf(FeedActionType.TOPPING_IN_LIST);
    }

    public final List<FeedActionType> k(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.emptyList();
    }

    public final void l(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
    }

    public final List<FeedActionType> n(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.listOf(FeedActionType.TOPPING_IN_LIST);
    }

    public final void b(FeedActionType r2, FeedActionStatus r3, UIFeedCard r4) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionStatus");
        Intrinsics.checkNotNullParameter(r4, "data");
    }

    public final void j(UIFeedCard r1, View r2, int r3, ActionScene r4) {
        Intrinsics.checkNotNullParameter(r1, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r2, "clickView");
        Intrinsics.checkNotNullParameter(r4, "actionScene");
        com.ss.android.lark.flow.feed.utils.b.d("FlowContactAction", "FlowContactAction onItemClick");
        FeedSidebarItemsMoltenViewModel r5 = p();
        if ((r5 instanceof FeedSidebarItemsMoltenViewModel) == false) goto L5;
        FeedSidebarItemsMoltenViewModel r6 = r5;
    L6:
        if (r6 == null) goto L8;
        r6.setFlowClickHint(r1.getId());
    L8:
        fhb.a.d(r1, fhb.a.b(this.a));
        ktb.c r7 = (ktb.c) this.c.getValue();
        if (r7 == null) goto L12;
        r7.startNewContactActivity(r2.getContext(), "feed");
        return;
    L12:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
