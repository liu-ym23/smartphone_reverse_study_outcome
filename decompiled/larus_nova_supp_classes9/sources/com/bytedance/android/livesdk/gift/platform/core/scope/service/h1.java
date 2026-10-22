package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h1<T> implements Consumer {
    public static final h1 a = null;

    static {
        a = new h1();
    }

    public h1() {
    }

    public final void accept(Object r3) {
        if (((BaseResponse) ((Response) r3)).data != null) goto L14;
        StringBuilder r4 = new StringBuilder("reportEvent response null UIFps: ");
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.x> r1 = r0.getHotRoomInfo();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.core.x r2 = (com.bytedance.android.livesdk.gift.platform.core.x) r1.getValue();
        if (r2 == null) goto L11;
        Integer r5 = Integer.valueOf((int) r2.b);
    L12:
        r4.append(r5);
        r4.append("giftQueueSizeBig: ");
        r4.append(VideoGiftWidgetV2.S.g());
        ALogger.e("GiftLogService", r4.toString());
        return;
    L11:
        r5 = null;
        goto L12
    }
}
