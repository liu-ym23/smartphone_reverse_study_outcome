package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.livesdk.feedback.condition.trigger.ReceiveLiveRoomFeedbackMsgTrigger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedbackWithMessageService extends FeedbackCommonObserver {
    public static final /* synthetic */ int f = 0;
    public Disposable d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver, com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver, com.bytedance.android.livesdk.feedback.service.e
    public final void startFeedbackObserve() {
        super.startFeedbackObserve();
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        List<fx1.e<Object>> r0 = getTriggerActions();
        fx1.e<Object> r1 = bindThisHandleAction(new ReceiveLiveRoomFeedbackMsgTrigger(getDataCenter()), new AnonymousClass1(this));
        r1.a();
        Unit r2 = Unit.INSTANCE;
        r0.add(r1);
    }

    public FeedbackWithMessageService(InnerFeedbackWithMessageConfig r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        super(r2, r3, r4);
    }
}
