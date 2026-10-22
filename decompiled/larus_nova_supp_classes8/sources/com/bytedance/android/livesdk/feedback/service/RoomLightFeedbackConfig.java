package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.lv;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.feedback.condition.trigger.ReceiveLiveRoomFeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RoomLightFeedbackConfig implements d {
    public final Lazy a;
    public final CompositeDisposable b;
    public final com.bytedance.android.livesdk.feedback.light.context.a c;
    public final gx1.a d;
    public final DataCenter e;

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public FeedbackCard e(long r1) {
        throw null;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public e a() {
        return (FeedbackCommonObserver) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void b() {
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r1.a = "RoomLightFeedbackConfig";
        r1.c("invoke onShowFeedback");
        r1.a("roomId", Long.valueOf(this.d.b));
        r1.d();
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r2 = LightFeedbackDataManager.a.a();
        if (r2 == null) goto L6;
        r2.insertRoomFeedback(this.d.b, new RoomLightFeedbackConfig$onShowFeedback$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void c() {
        DataCenter r0 = this.e;
        if (r0 == null) goto L12;
        Room r1 = z.o(r0);
        if (r1 == null) goto L12;
        FeedbackCard r2 = r1.mFeedbackCard;
        if (r2 == null) goto L12;
        int r4 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r5 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r5.a = "RoomLightFeedbackConfig";
        r5.c("onStartRoom，保存进房问卷数据");
        r5.a("roomId", Long.valueOf(this.d.b));
        r5.d();
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r6 = LightFeedbackDataManager.a.a();
        if (r6 == null) goto L12;
        r6.saveLiveRoomFeedback(this.d.b, r2);
    L12:
        if (e(this.d.b) == null) goto L17;
        FeedbackCommonObserver r3 = (FeedbackCommonObserver) this.a.getValue();
        if (r3 == null) goto L24;
        r3.startFeedbackObserve();
        return;
    L24:
        return;
    L17:
        if (lv.a.getValue().booleanValue() == false) goto L20;
        int r7 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r8 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r8.a = "RoomLightFeedbackConfig";
        r8.c("onStartRoom，没有问卷数据，监听服务端消息下发问卷, 主看播都生效");
        r8.a("roomId", Long.valueOf(this.d.b));
        r8.d();
        ReceiveLiveRoomFeedbackMsgTrigger r9 = new ReceiveLiveRoomFeedbackMsgTrigger(this.e);
        r9.c = new RoomLightFeedbackConfig$loadFeedbackFromMsg$$inlined$also$lambda$1(this);
        r9.a();
    L22:
        Unit r10 = Unit.INSTANCE;
        return;
    L20:
        if (this.d.a == false) goto L22;
        int r11 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r12 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r12.a = "RoomLightFeedbackConfig";
        r12.c("onStartRoom，没有问卷数据，监听服务端消息下发问卷， 仅主播侧生效");
        r12.a("roomId", Long.valueOf(this.d.b));
        r12.d();
        ReceiveLiveRoomFeedbackMsgTrigger r13 = new ReceiveLiveRoomFeedbackMsgTrigger(this.e);
        r13.c = new RoomLightFeedbackConfig$loadFeedbackFromMsg$$inlined$also$lambda$1(this);
        r13.a();
        goto L22
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void onLeaveRoom() {
        this.b.clear();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void d(final FeedbackHideCode r6) {
        Intrinsics.checkNotNullParameter(r6, "code");
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r0 = LightFeedbackDataManager.a.a();
        final FeedbackCard.FeedbackStatus r1 = null;
        if (r0 == null) goto L5;
        FeedItem r2 = r0.getRoomFeedback(this.d.b);
    L6:
        if (r2 == null) goto L12;
        Room r3 = r2.getRoom();
        if (r3 == null) goto L12;
        FeedbackCard r4 = r3.mFeedbackCard;
        if (r4 == null) goto L12;
        r1 = r4.getStatus();
    L12:
        int r5 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r7 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r7.a = "RoomLightFeedbackConfig";
        r7.c("invoke onHideFeedback");
        r7.a("roomId", Long.valueOf(this.d.b));
        if (r1 == null) goto L16;
        String r8 = r1.name();
        if (r8 == null) goto L16;
    L17:
        r7.a("status", r8);
        r7.d();
        if (r1 != FeedbackCard.FeedbackStatus.DEFAULT) goto L20;
    L21:
        LightFeedbackDataManager r9 = LightFeedbackDataManager.a.a();
        if (r9 == null) goto L26;
        r9.removeRoomFeedback(this.d.b, new RoomLightFeedbackConfig$onHideFeedback$1(this, r1, r6));
        return;
    L26:
        return;
    L20:
        if (r1 == FeedbackCard.FeedbackStatus.COMPLETE) goto L21;
        return;
    L16:
        r8 = "unknown";
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public RoomLightFeedbackConfig(com.bytedance.android.livesdk.feedback.light.context.a r2, gx1.a r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "lightContext");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = LazyKt.lazy(new RoomLightFeedbackConfig$service$2(this));
        this.b = new CompositeDisposable();
    }
}
