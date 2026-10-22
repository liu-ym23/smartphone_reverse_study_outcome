package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.livesdk.feedback.condition.trigger.ReceiveLiveRoomFeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver;
import com.bytedance.android.livesdk.feedback.service.LiveRoomPublicScreenFeedbackConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import fx1.e;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveRoomFeedbackConditionObserver extends FeedbackCommonObserver {
    public static final /* synthetic */ int f = 0;
    public Disposable d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver, com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver, com.bytedance.android.livesdk.feedback.service.e
    public final void reset() {
        super.reset();
        this.e = false;
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.FeedbackCommonObserver, com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver, com.bytedance.android.livesdk.feedback.service.e
    public final void startFeedbackObserve() {
        super.startFeedbackObserve();
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        List<e<Object>> r0 = getTriggerActions();
        e<Object> r1 = bindThisHandleAction(new ReceiveLiveRoomFeedbackMsgTrigger(getDataCenter()), new AnonymousClass1(this));
        r1.a();
        Unit r2 = Unit.INSTANCE;
        r0.add(r1);
    }

    public LiveRoomFeedbackConditionObserver(LiveRoomPublicScreenFeedbackConfig r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        super(r2, r3, r4);
    }
}
