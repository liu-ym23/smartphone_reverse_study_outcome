package com.ss.android.lark.feed.shared.page.binder2;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements aeb.a {
    public final /* synthetic */ FeedCommonViewHolder a;
    public final /* synthetic */ seb.b b;

    public e(FeedCommonViewHolder r1, seb.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // aeb.a
    public final void a(UIFeedCard r6, FeedActionType r7, FeedActionStatus r8, FeedActionEvent r9) {
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r7, "actionType");
        Intrinsics.checkNotNullParameter(r8, "actionStatus");
        Intrinsics.checkNotNullParameter(r9, "event");
        aeb.f r4 = this.a.z;
        if (r4 == null) goto L5;
        r4.b(r7, r8, r6);
    L5:
        seb.b r5 = this.b;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r7, "actionType");
        Intrinsics.checkNotNullParameter(r8, "actionStatus");
        Intrinsics.checkNotNullParameter(r9, "event");
        r5.a.a(r6, r7, r8, r9);
        return;
    }
}
