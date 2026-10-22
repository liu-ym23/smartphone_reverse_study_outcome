package com.bytedance.android.livesdk.feedback.service;

import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.feedback.FeedbackManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PreviewFeedbackConfig implements d {
    public final Lazy a;
    public final RoomSession b;
    public final DataCenter c;

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void onLeaveRoom() {
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final e a() {
        return (FeedbackCommonObserver) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void b() {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.R2;
        LongSparseArray r1 = new LongSparseArray();
        r1.put(this.b.getRoomId(), Boolean.TRUE);
        Unit r2 = Unit.INSTANCE;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void c() {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.R2;
        LongSparseArray r1 = new LongSparseArray();
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final void d(FeedbackHideCode r3) {
        Intrinsics.checkNotNullParameter(r3, "code");
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.R2;
        LongSparseArray r0 = new LongSparseArray();
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
        FeedbackManager.Companion.getClass();
        FeedbackManager r5 = FeedbackManager.b.a();
        if (r5 == null) goto L6;
        r5.removePreviewFeedback(this.b.getRoomId());
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.service.d
    public final FeedbackCard e(long r3) {
        FeedbackManager.Companion.getClass();
        FeedbackManager r4 = FeedbackManager.b.a();
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getPreviewFeedback(this.b.getRoomId());
    }

    public PreviewFeedbackConfig(RoomSession r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomSession");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new PreviewFeedbackConfig$feedbackService$2(this));
    }
}
