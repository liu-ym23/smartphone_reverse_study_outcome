package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.w4;
import com.bytedance.android.livesdk.feedback.FeedbackManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class InnerFeedbackWithMessageConfig implements d {
    public final Lazy a;
    public final RoomSession b;
    public final DataCenter c;

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void c() {
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void onLeaveRoom() {
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final e a() {
        return (FeedbackWithMessageService) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void b() {
        if ((System.currentTimeMillis() - ((Number) com.bytedance.android.livesdk.sharedpref.b.U2.getValue()).longValue()) >= (w4.a.getValue().longValue() * ((long) BubbleId.PadCast))) goto L5;
        return;
    L5:
        final long r0 = this.b.getRoomId();
        FeedbackManager.Companion.getClass();
        FeedbackManager r2 = FeedbackManager.b.a();
        if (r2 == null) goto L9;
        r2.insertRoomFeedback(r0, new InnerFeedbackWithMessageConfig$onShowFeedback$$inlined$let$lambda$1(r0, this));
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void d(FeedbackHideCode r4) {
        Intrinsics.checkNotNullParameter(r4, "code");
        long r0 = this.b.getRoomId();
        FeedbackManager.Companion.getClass();
        FeedbackManager r5 = FeedbackManager.b.a();
        if (r5 == null) goto L6;
        r5.removeRoomFeedback(r0, new InnerFeedbackWithMessageConfig$onHideFeedback$$inlined$let$lambda$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final FeedbackCard e(long r3) {
        FeedbackManager.Companion.getClass();
        FeedbackManager r4 = FeedbackManager.b.a();
        if (r4 == null) goto L7;
        FeedItem r5 = r4.getRoomFeedback(this.b.getRoomId());
        if (r5 == null) goto L7;
        return r5.feedbackCard;
    L7:
        return null;
    }

    public InnerFeedbackWithMessageConfig(RoomSession r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomSession");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new InnerFeedbackWithMessageConfig$feedbackService$2(this));
    }
}
