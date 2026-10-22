package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.feedback.condition.trigger.BottomRightCardShowTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver;
import com.bytedance.android.livesdk.feedback.service.RoomPublicScreenEmojiFeedbackConfig;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import fx1.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PublicScreenEmojiObserver extends FeedbackCommonObserver {
    public static final /* synthetic */ int d = 0;

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver
    public final void c() {
        e<Object> r0 = findTriggerById(TriggerId.BOTTOM_RIGHT_CARD_SHOW);
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver
    public final List<e<Object>> d() {
        ArrayList r0 = new ArrayList();
        r0.addAll(super.d());
        r0.add(bindThisHandleAction(new BottomRightCardShowTrigger(getDataCenter()), new PublicScreenEmojiObserver$getTriggers$$inlined$apply$lambda$1(this)));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver
    public final void f() {
        e<Object> r0 = findTriggerById(TriggerId.BOTTOM_RIGHT_CARD_SHOW);
        if ((r0 instanceof BottomRightCardShowTrigger) == true) goto L5;
        r0 = null;
    L5:
        BottomRightCardShowTrigger r1 = (BottomRightCardShowTrigger) r0;
        if (r1 == null) goto L8;
        boolean r2 = r1.g();
    L9:
        if (r2 == true) goto L11;
        getConfig().b();
        return;
    L11:
        g("the right bottom card is showing");
        return;
    L8:
        r2 = true;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver, com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver, com.bytedance.android.livesdk.feedback.service.e
    public final void startFeedbackObserve() {
        FeedbackCard r0 = getConfig().e(getFeedbackSession().b);
        if (r0 == null) goto L5;
        FeedbackCard.FeedbackStatus r1 = r0.getStatus();
    L7:
        if (r1 != FeedbackCard.FeedbackStatus.COMPLETE) goto L10;
        g("startFeedbackObserve fail.the emoji feedback is complete");
        return;
    L10:
        super.startFeedbackObserve();
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver
    public final boolean a(FeedbackCard r2) {
        Intrinsics.checkNotNullParameter(r2, "feedbackCard");
        Intrinsics.checkNotNullParameter(r2, "feedbackCard");
        if (r2.canShowDirectly() == false) goto L13;
        e<Object> r3 = findTriggerById(TriggerId.BOTTOM_RIGHT_CARD_SHOW);
        if ((r3 instanceof BottomRightCardShowTrigger) == true) goto L7;
        r3 = null;
    L7:
        BottomRightCardShowTrigger r4 = (BottomRightCardShowTrigger) r3;
        if (r4 == null) goto L10;
        boolean r5 = r4.g();
    L11:
        if (r5 == true) goto L13;
        return true;
    L10:
        r5 = true;
    L13:
        return false;
    }

    public final void g(String r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomBottomRightCardConditionObserver", "page");
        r1.a = "RoomBottomRightCardConditionObserver";
        r1.c(r4);
        r1.a("roomId", Long.valueOf(getFeedbackSession().b));
        FeedbackCard r5 = getFeedbackCard();
        if (r5 == null) goto L6;
        Object r6 = r5.feedbackType;
        if (r6 == null) goto L6;
    L7:
        r1.a("feedback_type", r6);
        r1.d();
        return;
    L6:
        r6 = "-1";
        goto L7
    }

    public PublicScreenEmojiObserver(RoomPublicScreenEmojiFeedbackConfig r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        super(r2, r3, r4);
    }
}
