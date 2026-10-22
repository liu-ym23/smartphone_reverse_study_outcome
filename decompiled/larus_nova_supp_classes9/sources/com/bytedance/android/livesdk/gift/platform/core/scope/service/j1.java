package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j1 implements Action {
    public static final j1 a = null;

    static {
        a = new j1();
    }

    public j1() {
    }

    public final void run() {
        StringBuilder r0 = new StringBuilder("reportEvent response complete fps: ");
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.x> r2 = r1.getHotRoomInfo();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.core.x r3 = (com.bytedance.android.livesdk.gift.platform.core.x) r2.getValue();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf((int) r3.b);
    L10:
        r0.append(r4);
        r0.append("giftQueueSizeBig: ");
        r0.append(VideoGiftWidgetV2.S.g());
        ALogger.e("GiftLogService", r0.toString());
        return;
    L9:
        r4 = null;
        goto L10
    }
}
