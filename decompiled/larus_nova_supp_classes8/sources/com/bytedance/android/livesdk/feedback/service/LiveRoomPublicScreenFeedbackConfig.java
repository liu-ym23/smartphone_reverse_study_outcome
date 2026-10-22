package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.feedback.condition.observer.LiveRoomFeedbackConditionObserver;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveRoomPublicScreenFeedbackConfig implements d {
    public final Lazy a;
    public final com.bytedance.android.livesdk.feedback.light.context.a b;
    public final gx1.a c;
    public final DataCenter d;

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void onLeaveRoom() {
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final e a() {
        return (LiveRoomFeedbackConditionObserver) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void b() {
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r0 = LightFeedbackDataManager.a.a();
        if (r0 == null) goto L6;
        r0.insertLiveRoomFeedback(this.c.b, new LiveRoomPublicScreenFeedbackConfig$onShowFeedback$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void c() {
        RoomContext.a r0 = RoomContext.Companion;
        DataCenter r1 = this.d;
        long r2 = this.c.b;
        r0.getClass();
        RoomContext r3 = RoomContext.a.a(r1, r2);
        if (r3 == null) goto L13;
        m r4 = r3.getRoom();
        if (r4 == null) goto L13;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L13;
        FeedbackCard r6 = r5.mFeedbackCard;
        if (r6 == null) goto L13;
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r7 = LightFeedbackDataManager.a.a();
        if (r7 == null) goto L13;
        r7.saveLiveRoomFeedback(this.c.b, r6);
    L13:
        ((LiveRoomFeedbackConditionObserver) this.a.getValue()).startFeedbackObserve();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void d(final FeedbackHideCode r6) {
        Intrinsics.checkNotNullParameter(r6, "code");
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r0 = LightFeedbackDataManager.a.a();
        final FeedbackCard.FeedbackStatus r1 = null;
        if (r0 == null) goto L5;
        FeedbackCard r2 = r0.getLiveRoomFeedback(this.c.b);
    L6:
        if (r2 == null) goto L8;
        r1 = r2.getStatus();
    L8:
        int r3 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r4 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveRoomPublicScreenFeedbackConfig", "page");
        r4.a = "LiveRoomPublicScreenFeedbackConfig";
        r4.c("invoke onHideFeedback");
        r4.a("roomId", Long.valueOf(this.c.b));
        if (r1 == null) goto L12;
        String r5 = r1.name();
        if (r5 == null) goto L12;
    L13:
        r4.a("status", r5);
        r4.d();
        if (r1 != FeedbackCard.FeedbackStatus.DEFAULT) goto L16;
    L17:
        LightFeedbackDataManager r7 = LightFeedbackDataManager.a.a();
        if (r7 == null) goto L22;
        r7.removeLiveRoomFeedback(this.c.b, new LiveRoomPublicScreenFeedbackConfig$onHideFeedback$1(this, r1, r6));
        return;
    L22:
        return;
    L16:
        if (r1 == FeedbackCard.FeedbackStatus.COMPLETE) goto L17;
        return;
    L12:
        r5 = "unknown";
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final FeedbackCard e(long r3) {
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r0 = LightFeedbackDataManager.a.a();
        if (r0 == null) goto L5;
        FeedbackCard r4 = r0.getLiveRoomFeedback(r3);
    L6:
        if (r4 == null) goto L13;
        Integer r5 = r4.feedbackType;
        if (r5 == null) goto L13;
        if (r5.intValue() != 6) goto L13;
        return r4;
    L13:
        return null;
    L5:
        r4 = null;
        goto L6
    }

    public LiveRoomPublicScreenFeedbackConfig(com.bytedance.android.livesdk.feedback.light.context.a r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "lightContext");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(new LiveRoomPublicScreenFeedbackConfig$service$2(this));
    }
}
