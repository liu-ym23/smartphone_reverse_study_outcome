package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveLightFeedbackRelaxWidget a;

    public c(LiveLightFeedbackRelaxWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        LiveLightFeedbackRelaxWidget.wq(this.a, FeedbackCard.FeedbackStatus.COMPLETE);
        com.bytedance.android.livesdk.feedback.light.context.a r4 = this.a.a;
        if (r4 == null) goto L10;
        com.bytedance.live.datacontext.i<ix1.a> r5 = r4.getFeedbackConfigService();
        if (r5 == null) goto L11;
        ix1.a r6 = (ix1.a) r5.getValue();
        if (r6 == null) goto L12;
        r6.b();
        return;
    L12:
        return;
    L11:
        return;
    }
}
