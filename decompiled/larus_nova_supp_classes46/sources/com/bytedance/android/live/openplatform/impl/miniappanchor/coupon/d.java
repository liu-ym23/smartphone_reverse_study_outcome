package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.OpenPlatformCouponInvalidMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends ro0.b<OpenPlatformCouponInvalidMessage> {
    @Override // ro0.b
    public final MessageType a() {
        return MessageType.OPEN_PLATFORM_COUPON_INVALID_MESSAGE;
    }

    public d(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // ro0.b
    public final void b(tlc.d r3) {
        OpenPlatformCouponInvalidMessage r4 = (OpenPlatformCouponInvalidMessage) r3;
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        if (r4.invalidType == OpenPlatformCouponInvalidMessage.InvalidType.UnknownInvalidType.getValue()) goto L6;
        f2.c(r4.content, 0);
        return;
    }
}
