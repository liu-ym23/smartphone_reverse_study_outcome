package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ LinkedHashMap<FeedActionType, aeb.c> a;
    public final /* synthetic */ FeedActionType b;
    public final /* synthetic */ UIFeedCard c;
    public final /* synthetic */ aeb.a d;

    public q(LinkedHashMap<FeedActionType, aeb.c> r1, FeedActionType r2, UIFeedCard r3, aeb.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        aeb.c r5 = this.a.get(this.b);
        if (r5 == null) goto L8;
        aeb.d r6 = r5.m();
        if (r6 == null) goto L9;
        r6.o(this.c, FeedActionEvent.LEFT_SWIPE, this.d);
        return;
    L9:
        return;
    }
}
