package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.feedback.condition.observer.PublicScreenEmojiObserver;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RoomPublicScreenEmojiFeedbackConfig extends RoomLightFeedbackConfig {
    public final Lazy f;

    @Override // com.bytedance.android.livesdk.feedback.service.RoomLightFeedbackConfig, com.bytedance.android.livesdk.feedback.service.d
    public final e a() {
        return (PublicScreenEmojiObserver) this.f.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.service.RoomLightFeedbackConfig, com.bytedance.android.livesdk.feedback.service.d
    public final FeedbackCard e(long r3) {
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r0 = LightFeedbackDataManager.a.a();
        if (r0 == null) goto L9;
        FeedItem r4 = r0.getRoomFeedback(r3);
        if (r4 == null) goto L9;
        Room r5 = r4.getRoom();
        if (r5 == null) goto L9;
        FeedbackCard r6 = r5.mFeedbackCard;
    L10:
        if (r6 == null) goto L12;
        Integer r7 = r6.inflowFeedbackType;
    L13:
        if (r7 != null) goto L16;
    L18:
        return null;
    L16:
        if (r7.intValue() != 10) goto L18;
        return r6;
    L12:
        r7 = null;
    L9:
        r6 = null;
        goto L10
    }

    public RoomPublicScreenEmojiFeedbackConfig(com.bytedance.android.livesdk.feedback.light.context.a r2, final gx1.a r3, final DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "lightContext");
        Intrinsics.checkNotNullParameter(r3, "feedbackSession");
        super(r2, r3, r4);
        this.f = LazyKt.lazy(new RoomPublicScreenEmojiFeedbackConfig$service$2(this, r3, r4));
    }
}
