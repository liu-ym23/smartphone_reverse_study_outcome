package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.live.base.model.feedback.Condition;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        FeedbackCard r6 = ((com.bytedance.android.live.base.model.feedback.a.a) ((ExtraResponse) ((e) r5)).data).feedbackCard;
        if (r6 == null) goto L29;
        Integer r0 = r6.inflowFeedbackType;
        if (r0 != null) goto L8;
    L9:
        if (r0 != null) goto L12;
    L13:
        Condition r1 = r6.condition;
        if (r1 == null) goto L19;
        List r2 = r1.actionIds;
        if (r2 == null) goto L19;
        if (r2.contains(99L) != true) goto L19;
        return;
    L19:
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r3 = LightFeedbackDataManager.a.a();
        if (r3 == null) goto L22;
        r3.saveLiveRoomFeedback(z.o(this.a.a.getDataCenter()).getRoomId(), r6);
    L22:
        LiveRoomFeedbackConditionObserver r7 = this.a.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter("on action：receive live room feedback msg", "msg");
        int r4 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r8 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveRoomFeedbackConditionObserver", "page");
        r8.a = "LiveRoomFeedbackConditionObserver";
        r8.c("on action：receive live room feedback msg");
        r8.a("roomId", Long.valueOf(r7.getFeedbackSession().b));
        FeedbackCard r9 = r7.getFeedbackCard();
        if (r9 == null) goto L26;
        Object r10 = r9.feedbackType;
        if (r10 == null) goto L26;
    L27:
        r8.a("feedback_type", r10);
        r8.d();
        this.a.a.startFeedbackObserve();
        return;
    L26:
        r10 = "-1";
        goto L27
    L12:
        if (r0.intValue() != 2) goto L13;
        return;
    L8:
        if (r0.intValue() != 1) goto L9;
        return;
    }
}
