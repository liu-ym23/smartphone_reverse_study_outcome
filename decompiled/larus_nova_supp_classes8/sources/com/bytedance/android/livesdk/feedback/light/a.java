package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.live.base.model.feed.FeedItem;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LiveLightFeedbackWidget a;

    public a(LiveLightFeedbackWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        FeedItem r4 = (FeedItem) sh6.c.b((sh6.b) r3);
        if (r4 == null) goto L6;
        LiveLightFeedbackWidget r0 = this.a;
        int r1 = LiveLightFeedbackWidget.f;
        r0.Aq(r4);
        return;
    }
}
