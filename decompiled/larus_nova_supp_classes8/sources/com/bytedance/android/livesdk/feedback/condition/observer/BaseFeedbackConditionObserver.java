package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.live.base.model.feedback.Condition;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.feedback.condition.trigger.LiveEndTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.ReceiveFeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.android.livesdk.feedback.service.d;
import com.bytedance.android.livesdk.feedback.service.e;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.message.model.n4;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 <2\u00020\u0001:\u0001=B!\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00101\u001a\u000200\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b:\u0010;J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0004JC\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00022#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0004J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0004J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00020\u0013H\u0014JJ\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0015*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0016H\u0004JD\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0015*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0016H\u0004J\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH&J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H&R$\u0010!\u001a\u0004\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00020\u00158\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00106\u001a\u0004\u0018\u0001058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/observer/BaseFeedbackConditionObserver;", "Lcom/bytedance/android/livesdk/feedback/service/e;", "Lfx1/e;", "Lcom/bytedance/android/livesdk/message/model/n4;", "", "bindThisHandleMsg", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "data", "", "action", "bindThisHandleAction", "Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/TriggerId;", "triggerId", "findTriggerById", "", "removeTriggerById", "", "getCommonTriggers", "", "Lkotlin/Function0;", "predicate", "block", "shouldAddTrigger", "", "actionId", "onLiveEnd", "onReport", "message", "handleFeedbackActionMsg", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "feedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "getFeedbackCard", "()Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "setFeedbackCard", "(Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;)V", "triggerActions", "Ljava/util/List;", "getTriggerActions", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/feedback/service/d;", "config", "Lcom/bytedance/android/livesdk/feedback/service/d;", "getConfig", "()Lcom/bytedance/android/livesdk/feedback/service/d;", "Lgx1/a;", "feedbackSession", "Lgx1/a;", "getFeedbackSession", "()Lgx1/a;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/android/livesdk/feedback/service/d;Lgx1/a;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseFeedbackConditionObserver implements e {
    public static final a Companion = null;
    public static final String TAG = "FeedbackConditionObserver";
    private final d config;
    private final DataCenter dataCenter;
    private FeedbackCard feedbackCard;
    private final gx1.a feedbackSession;
    private final List<fx1.e<Object>> triggerActions;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public List<fx1.e<Object>> getCommonTriggers() {
        List<fx1.e<Object>> r0 = CollectionsKt.mutableListOf(new fx1.e[]{bindThisHandleAction(new LiveEndTrigger(this.dataCenter), new AnonymousClass1(this)), bindThisHandleAction(new com.bytedance.android.livesdk.feedback.condition.trigger.e(), new AnonymousClass2(this)), bindThisHandleMsg(new ReceiveFeedbackMsgTrigger(this.dataCenter))});
        shouldAddTrigger(r0, 5, new BaseFeedbackConditionObserver$getCommonTriggers$$inlined$apply$lambda$1(this));
        shouldAddTrigger(r0, 1, new BaseFeedbackConditionObserver$getCommonTriggers$$inlined$apply$lambda$2(this));
        shouldAddTrigger(r0, 2, new BaseFeedbackConditionObserver$getCommonTriggers$$inlined$apply$lambda$3(this));
        shouldAddTrigger(r0, 4, new BaseFeedbackConditionObserver$getCommonTriggers$$inlined$apply$lambda$4(this));
        shouldAddTrigger(r0, 6, new BaseFeedbackConditionObserver$getCommonTriggers$$inlined$apply$lambda$5(this));
        shouldAddTrigger(r0, 5, new BaseFeedbackConditionObserver$getCommonTriggers$$inlined$apply$lambda$6(this));
        return r0;
    }

    public abstract void handleFeedbackActionMsg(n4 r1);

    public abstract void onReport();

    @Override // com.bytedance.android.livesdk.feedback.service.e
    public abstract /* synthetic */ void reset();

    @Override // com.bytedance.android.livesdk.feedback.service.e
    public abstract /* synthetic */ void startFeedbackObserve();

    public void onLiveEnd() {
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("BaseFeedbackConditionObserver", "page");
        r1.a = "BaseFeedbackConditionObserver";
        r1.c("onLiveEnd");
        r1.a("roomId", Long.valueOf(this.feedbackSession.b));
        FeedbackCard r2 = this.feedbackCard;
        if (r2 == null) goto L6;
        Object r3 = r2.feedbackType;
        if (r3 == null) goto L6;
    L7:
        r1.a("feedback_type", r3);
        r1.d();
        FeedbackCard r4 = this.feedbackCard;
        if (r4 == null) goto L10;
        r4.updateFeedbackStatus(FeedbackCard.FeedbackStatus.COMPLETE);
    L10:
        fx1.e<Object> r5 = findTriggerById(TriggerId.TOTAL_WATCH_TIME_SECTION);
        if (r5 == null) goto L13;
        r5.reset();
    L13:
        this.config.d(FeedbackHideCode.LIVE_END);
        reset();
        return;
    L6:
        r3 = "-1";
        goto L7
    }

    public final d getConfig() {
        return this.config;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final FeedbackCard getFeedbackCard() {
        return this.feedbackCard;
    }

    public final gx1.a getFeedbackSession() {
        return this.feedbackSession;
    }

    public final List<fx1.e<Object>> getTriggerActions() {
        return this.triggerActions;
    }

    public final fx1.e<Object> bindThisHandleMsg(fx1.e<n4> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$bindThisHandleMsg");
        r2.b(new BaseFeedbackConditionObserver$bindThisHandleMsg$$inlined$apply$lambda$1(this));
        return r2;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.e
    public fx1.e<Object> findTriggerById(TriggerId r4) {
        Intrinsics.checkNotNullParameter(r4, "triggerId");
        Iterator<T> r0 = this.triggerActions.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((fx1.e) r1).getId() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (fx1.e) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final synchronized boolean removeTriggerById(TriggerId r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "triggerId");     // Catch: Throwable -> L15
        Iterator<fx1.e<Object>> r0 = this.triggerActions.iterator();     // Catch: Throwable -> L15
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L13;
        fx1.e<Object> r2 = r0.next();     // Catch: Throwable -> L15
        if (r2 == null) goto L9;
        TriggerId r3 = r2.getId();     // Catch: Throwable -> L15
    L10:
        if (r3 != r4) goto L4;
        r0.remove();     // Catch: Throwable -> L15
        r1 = true;
        goto L4
    L9:
        r3 = null;
        goto L10
    L13:
        monitor-exit(this);
        return r1;
    L15:
        th = move-exception;
        throw th;
    }

    public final void setFeedbackCard(FeedbackCard r1) {
        this.feedbackCard = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> fx1.e<T> bindThisHandleAction(fx1.e<? extends T> r2, final Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$bindThisHandleAction");
        Intrinsics.checkNotNullParameter(r3, "action");
        r2.b(new BaseFeedbackConditionObserver$bindThisHandleAction$$inlined$apply$lambda$1(r3));
        return r2;
    }

    public BaseFeedbackConditionObserver(d r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        this.config = r2;
        this.feedbackSession = r3;
        this.dataCenter = r4;
        this.triggerActions = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.List, java.util.List<fx1.e<java.lang.Object>>] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List<fx1.e<java.lang.Object>>] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final List<fx1.e<Object>> shouldAddTrigger(List<fx1.e<Object>> r4, long r5, Function0<? extends fx1.e<? extends Object>> r7) {
        Intrinsics.checkNotNullParameter(r4, "$this$shouldAddTrigger");
        Intrinsics.checkNotNullParameter(r7, "block");
        FeedbackCard r0 = this.config.e(this.feedbackSession.b);
        if (r0 == null) goto L11;
        Condition r1 = r0.condition;
        if (r1 == null) goto L11;
        List r2 = r1.actionIds;
        if (r2 == null) goto L11;
        boolean r6 = true;
        if (r2.contains(Long.valueOf(r5)) != true) goto L11;
    L13:
        if (r6 == false) goto L15;
        ?? r8 = r4;
    L16:
        if (r8 == 0) goto L19;
        r4.add(r7.invoke());
        return r8;
    L19:
        return null;
    L15:
        r8 = 0;
    L11:
        r6 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<fx1.e<java.lang.Object>>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List, java.util.List<fx1.e<java.lang.Object>>] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final List<fx1.e<Object>> shouldAddTrigger(List<fx1.e<Object>> r2, Function0<Boolean> r3, Function0<? extends fx1.e<? extends Object>> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$shouldAddTrigger");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Intrinsics.checkNotNullParameter(r4, "block");
        if (((Boolean) r3.invoke()).booleanValue() == false) goto L5;
        ?? r5 = r2;
    L6:
        if (r5 == 0) goto L9;
        r2.add(r4.invoke());
        return r5;
    L9:
        return null;
    L5:
        r5 = 0;
        goto L6
    }
}
