package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feedback.Condition;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.a31;
import com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver;
import com.bytedance.android.livesdk.feedback.condition.trigger.TotalWatchTimeToInsertTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.message.model.n4;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedbackCommonObserver extends BaseFeedbackConditionObserver {
    public boolean a;
    public boolean b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public void c() {
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver, com.bytedance.android.livesdk.feedback.service.e
    public void reset() {
        this.a = false;
        this.b = false;
        this.c = false;
        Iterator<T> r0 = getTriggerActions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((fx1.e) r0.next()).reset();
        goto L4
    L6:
        getTriggerActions().clear();
    }

    public final void b() {
        e("check2Show, inDisplayTimeCondition:" + this.a + " satisfyActionCondition:" + this.b + "  satisfyPcuCondition:" + this.c);
        if (this.a == true) goto L5;
        return;
    L5:
        if (this.b == true) goto L7;
        return;
    L7:
        if (this.c == false) goto L12;
        f();
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver
    public final void onReport() {
        e("onReport");
        FeedbackCard r0 = getFeedbackCard();
        if (r0 == null) goto L5;
        r0.updateFeedbackStatus(FeedbackCard.FeedbackStatus.COMPLETE);
    L5:
        getConfig().d(FeedbackHideCode.REPORT);
        reset();
    }

    public List<fx1.e<Object>> d() {
        final FeedbackCard r0 = getConfig().e(getFeedbackSession().b);
        if (r0 == null) goto L7;
        Condition r1 = r0.condition;
        if (r1 == null) goto L7;
        final long r2 = r1.pcuLowerThreshold;
    L8:
        ArrayList r3 = new ArrayList();
        r3.addAll(getCommonTriggers());
        shouldAddTrigger(r3, new FeedbackCommonObserver$getTriggers$$inlined$apply$lambda$1(this, r2, r0), new FeedbackCommonObserver$getTriggers$$inlined$apply$lambda$2(this, r2, r0));
        long r7 = getFeedbackSession().b;
        boolean r9 = getFeedbackSession().a;
        Long r5 = null;
        if (r0 == null) goto L13;
        Condition r6 = r0.condition;
        if (r6 == null) goto L13;
        Long r10 = r6.fromTime;
    L14:
        if (r0 == null) goto L18;
        Condition r8 = r0.condition;
        if (r8 == null) goto L18;
        r5 = r8.toTime;
    L18:
        r3.addAll(CollectionsKt.listOf(bindThisHandleAction(new TotalWatchTimeToInsertTrigger(r7, r9, r10, r5), new FeedbackCommonObserver$getTriggers$$inlined$apply$lambda$3(this, r2, r0))));
        return r3;
    L13:
        r10 = null;
    L7:
        r2 = 0;
        goto L8
    }

    public void f() {
        getConfig().b();
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver, com.bytedance.android.livesdk.feedback.service.e
    public void startFeedbackObserve() {
        FeedbackCard r0 = getConfig().e(getFeedbackSession().b);
        if (a31.a.getValue().booleanValue() == false) goto L9;
        if (r0 == null) goto L9;
        if (r0.isComplete() != true) goto L9;
        e("startFeedbackObserve fail, the feedback has completed");
        return;
    L9:
        if (r0 == null) goto L38;
        setFeedbackCard(r0);
        this.c = true;
        Iterator<T> r1 = getTriggerActions().iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        ((fx1.e) r1.next()).reset();
        goto L12
    L14:
        getTriggerActions().clear();
        getTriggerActions().addAll(d());
        if (a(r0) == false) goto L20;
        e("show directly");
        f();
        fx1.e<Object> r2 = findTriggerById(TriggerId.REPORT);
        if (r2 == null) goto L19;
        r2.a();
    L19:
        c();
        return;
    L20:
        ALogger.d("FeedbackCommonObserver", "feedback_room " + r0.toString());
        Condition r3 = r0.condition;
        if (r3 != null) goto L23;
        f();
        Unit r4 = Unit.INSTANCE;
    L23:
        if (r3 == null) goto L42;
        this.a = false;
        Long r5 = r3.actionType;
        if (r5 != null) goto L28;
    L29:
        List r6 = r3.actionIds;
        if (r6 != null) goto L32;
    L34:
        Iterator<T> r7 = getTriggerActions().iterator();
    L36:
        if (r7.hasNext() == false) goto L43;
        ((fx1.e) r7.next()).a();
        goto L36
    L43:
        return;
    L32:
        if (r6.isEmpty() != true) goto L34;
    L33:
        this.b = true;
        goto L34
    L28:
        if (r5.equals(2L) == true) goto L33;
    L42:
        return;
    }

    public boolean a(FeedbackCard r2) {
        Intrinsics.checkNotNullParameter(r2, "feedbackCard");
        return r2.canShowDirectly();
    }

    public final void e(String r4) {
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackCommonObserver", "page");
        r1.a = "FeedbackCommonObserver";
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

    @Override // com.bytedance.android.livesdk.feedback.condition.observer.BaseFeedbackConditionObserver
    public final void handleFeedbackActionMsg(n4 r6) {
        FeedbackCard r0 = getFeedbackCard();
        if (r0 == null) goto L5;
        Condition r1 = r0.condition;
    L6:
        if (r1 == null) goto L32;
        List r2 = r1.actionIds;
        if (r2 == null) goto L37;
        Long r3 = r1.actionType;
        StringBuilder r4 = new StringBuilder("onMessage action:");
        if (r6 == null) goto L13;
        Long r5 = r6.actionId;
    L14:
        r4.append(r5);
        ALogger.d("FeedbackCommonObserver", r4.toString());
        if (r6 != null) goto L17;
        return;
    L17:
        if (CollectionsKt.contains(r2, r6.actionId) == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L34;
        if (r3 != null) goto L24;
    L26:
        if (r3 != null) goto L29;
        return;
    L29:
        if (r3.longValue() != 1) goto L36;
        this.b = true;
        e("checkShow by action");
        b();
        return;
    L36:
        return;
    L24:
        if (r3.longValue() != 2) goto L26;
        this.b = false;
        e("hide by negative action");
        getConfig().d(FeedbackHideCode.NEGATIVE_ACTION);
        reset();
        return;
    L34:
        return;
    L13:
        r5 = null;
        goto L14
    L37:
        return;
    L32:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public FeedbackCommonObserver(d r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        super(r2, r3, r4);
        this.c = true;
    }
}
