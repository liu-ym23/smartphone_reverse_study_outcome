package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LiveLightFeedbackRelaxWidget a;

    public b(LiveLightFeedbackRelaxWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        FeedItem r4 = (FeedItem) sh6.c.b((sh6.b) r3);
        if (r4 == null) goto L6;
        LiveLightFeedbackRelaxWidget r0 = this.a;
        int r1 = LiveLightFeedbackRelaxWidget.f;
        r0.zq(r4);
        return;
    }
}
