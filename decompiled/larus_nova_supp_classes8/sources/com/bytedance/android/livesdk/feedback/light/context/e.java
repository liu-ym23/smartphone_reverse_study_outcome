package com.bytedance.android.livesdk.feedback.light.context;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements b {
    public final CompositeDisposable a;

    @Override // com.bytedance.android.livesdk.feedback.light.context.b
    public final void release() {
        this.a.clear();
    }

    public e() {
        this.a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.b
    public final void a(FeedbackCard r14, Room r15) {
        IFeedbackApi r0 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
        long r1 = 0;
        if (r14 == null) goto L7;
        Long r3 = r14.feedbackId;
        if (r3 == null) goto L7;
        long r4 = r3.longValue();
    L8:
        if (r15 == null) goto L10;
        r1 = r15.id;
    L10:
        long r6 = r1;
        if (r14 == null) goto L15;
        Integer r2 = r14.feedbackType;
        if (r2 == null) goto L15;
        int r8 = r2.intValue();
    L16:
        if (r15 == null) goto L18;
        LiveMode r16 = r15.getStreamType();
    L19:
        int r5 = h1.a;
        String r17 = i1.a(r16);
        if (r14 == null) goto L24;
        Integer r7 = r14.getIndex();
        if (r7 == null) goto L24;
        int r9 = r7.intValue();
    L26:
        if (r14 == null) goto L28;
        int r18 = r14.getScene();
    L29:
        RxUtilKt.c(IFeedbackApi.CC.feedbackCardShow$default(r0, r4, r6, 0, r8, r17, r9, false, r18, 64, null).compose(RxUtil.rxSchedulerHelper()).subscribe(c.a, d.a), this.a);
        return;
    L28:
        r18 = -1;
    L24:
        r9 = -1;
        goto L26
    L18:
        r16 = null;
    L15:
        r8 = -1;
    L7:
        r4 = 0;
        goto L8
    }
}
