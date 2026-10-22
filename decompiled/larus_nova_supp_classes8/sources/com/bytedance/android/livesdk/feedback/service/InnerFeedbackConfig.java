package com.bytedance.android.livesdk.feedback.service;

import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.w4;
import com.bytedance.android.livesdk.feedback.FeedbackManager;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.PreviewLandScapeUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class InnerFeedbackConfig implements d {
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
        return (FeedbackCommonObserver) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void b() {
        if ((System.currentTimeMillis() - ((Number) com.bytedance.android.livesdk.sharedpref.b.U2.getValue()).longValue()) >= (w4.a.getValue().longValue() * ((long) BubbleId.PadCast))) goto L5;
        return;
    L5:
        int r0 = com.bytedance.android.livesdk.landscapeslide.f.a;
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L14;
        return;
    L14:
        if (PreviewLandScapeUtils.INSTANCE.getInitHashCode() != 0) goto L16;
    L18:
        long r2 = this.b.getRoomId();
        FeedbackManager.Companion.getClass();
        FeedbackManager r3 = FeedbackManager.b.a();
        if (r3 == null) goto L22;
        r3.insertRoomFeedback(r2, new InnerFeedbackConfig$onShowFeedback$$inlined$let$lambda$1(this));
        return;
    L22:
        return;
    L16:
        if (u.h.equals("1") == false) goto L18;
        return;
    L8:
        if (e5.n() == false) goto L10;
        ALogger.i("LiveLandScapeSlideExtUtil", "onInterceptShow is called. skip");
        r1 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void d(FeedbackHideCode r4) {
        Intrinsics.checkNotNullParameter(r4, "code");
        long r0 = this.b.getRoomId();
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.R2;
        LongSparseArray r2 = new LongSparseArray();
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r2);
        FeedbackManager.Companion.getClass();
        FeedbackManager r6 = FeedbackManager.b.a();
        if (r6 == null) goto L6;
        r6.removeRoomFeedback(r0, new InnerFeedbackConfig$onHideFeedback$$inlined$let$lambda$1(this));
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

    public InnerFeedbackConfig(RoomSession r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomSession");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new InnerFeedbackConfig$feedbackService$2(this));
    }
}
