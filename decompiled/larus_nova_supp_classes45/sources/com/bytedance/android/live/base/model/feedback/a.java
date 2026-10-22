package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.distribution.GetFeedbackCardResponse")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/a;", "", "Lcom/bytedance/android/live/base/model/feedback/a$a;", "data", "Lcom/bytedance/android/live/base/model/feedback/a$a;", "<init>", "()V", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("data")
    public C0010a data;

    /* JADX INFO: renamed from: com.bytedance.android.live.base.model.feedback.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.api.distribution.GetFeedbackCardResponse.Data")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/a$a;", "", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "feedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0010a implements h {

        @SerializedName("feedback_card")
        public FeedbackCard feedbackCard;

        public C0010a() {
        }

        public C0010a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.feedbackCard = new FeedbackCard(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }
    }

    public a() {
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.data = new C0010a(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
