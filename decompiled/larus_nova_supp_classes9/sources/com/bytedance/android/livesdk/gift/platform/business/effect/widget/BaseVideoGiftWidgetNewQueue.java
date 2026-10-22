package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftEffectManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.m;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidgetNewQueue;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidgetOrigin;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseVideoGiftWidgetNewQueue extends BaseVideoGiftWidgetOrigin {
    public BaseVideoGiftWidgetNewQueue() {
        Intrinsics.checkNotNullParameter("BaseVideoGiftWidgetNewQueue", "<set-?>");
        this.b = "BaseVideoGiftWidgetNewQueue";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.y
    public final boolean Lc(NormalGiftMessage r14) {
        Intrinsics.checkNotNullParameter(r14, "message");
        IBaseUser r0 = null;
        if (GiftEffectManager.b(r14, null) == false) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "onConsumeMessage: not consume,because of interceptGiftMsg " + r14);
        return false;
    L7:
        if ((r14 instanceof NormalGiftMessage) == false) goto L37;
        gm2.d r1 = r14.t;
        if ((r1 instanceof o7) == false) goto L18;
        o7 r2 = r14.r();
        if (r2.getGift() == null) goto L13;
        VideoGiftLinkMonitor.Event r3 = VideoGiftLinkMonitor.Event.consume_message;
        long r4 = r2.getMessageId();
        long r6 = r2.getGiftId();
        h1 r5 = r2.getGift();
        Intrinsics.checkNotNull(r5);
        VideoGiftLinkMonitor.a(r3, r4, r6, r5.getPrimaryEffectId());
    L13:
        int r7 = m.a;
        IRoom r8 = this.d;
        if (r8 == null) goto L17;
        Intrinsics.checkNotNull(r8);
        r0 = r8.getOwner();
    L17:
        return jr(m.b(r14, r0));
    L18:
        long r9 = 0;
        if ((r1 instanceof k6) == false) goto L28;
        k6 r15 = r14.o();
        VideoGiftLinkMonitor.Event r10 = VideoGiftLinkMonitor.Event.consume_message;
        Intrinsics.checkNotNullParameter(r15, "$this$messageId");
        m0 r11 = r15.getCommonData();
        if (r11 == null) goto L23;
        r0 = Long.valueOf(r11.getMessageId());
    L23:
        if (r0 == null) goto L25;
        r9 = r0.longValue();
    L25:
        VideoGiftLinkMonitor.a(r10, r9, -1, r15.getAssetId());
        return jr(m.d(r15));
    L28:
        if (r14.n() == null) goto L36;
        i6 r16 = r14.n();
        VideoGiftLinkMonitor.Event r13 = VideoGiftLinkMonitor.Event.consume_message;
        Intrinsics.checkNotNullParameter(r16, "$this$messageId");
        m0 r17 = r16.getCommonData();
        if (r17 == null) goto L32;
        r0 = Long.valueOf(r17.getMessageId());
    L32:
        if (r0 == null) goto L34;
        r9 = r0.longValue();
    L34:
        VideoGiftLinkMonitor.a(r13, r9, -1, r16.getAssetId());
        return jr(m.c(r16));
    L36:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "[onConsumeMessage] ERROR!: message ignored.." + r14.getAssetId());
    L38:
        return false;
    L37:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "[onConsumeMessage] ERROR!:not an instanceof NormalGiftMessage , ignored.." + r14);
        goto L38
    }
}
