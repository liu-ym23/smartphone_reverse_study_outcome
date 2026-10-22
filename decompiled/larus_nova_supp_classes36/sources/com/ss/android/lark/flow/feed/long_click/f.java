package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ FlowFeedMenuUtil.FeedMenuListAdapter a;
    public final /* synthetic */ aeb.d b;

    public f(FlowFeedMenuUtil.FeedMenuListAdapter r1, aeb.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.b.invoke();
        aeb.d r5 = this.b;
        UIFeedCard r0 = this.a.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedCardData");
        r0 = null;
    L5:
        r5.o(r0, FeedActionEvent.LONG_CLICK, this.a.c);
    }
}
