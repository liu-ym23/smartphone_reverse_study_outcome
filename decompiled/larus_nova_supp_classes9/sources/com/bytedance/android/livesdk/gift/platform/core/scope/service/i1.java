package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1<T> implements Consumer {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        StringBuilder r5 = new StringBuilder("reportEvent response error fps: ");
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.x> r1 = r0.getHotRoomInfo();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.core.x r2 = (com.bytedance.android.livesdk.gift.platform.core.x) r1.getValue();
        if (r2 == null) goto L9;
        Integer r6 = Integer.valueOf((int) r2.b);
    L10:
        r5.append(r6);
        r5.append("giftQueueSizeBig: ");
        r5.append(VideoGiftWidgetV2.S.g());
        ALogger.e("GiftLogService", r5.toString());
        return;
    L9:
        r6 = null;
        goto L10
    }
}
