package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget a;

    public r0(LiveGiftMenuStickerServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        LiveGiftMenuStickerServiceWidget r0 = this.a;
        r0.h = r5.booleanValue();
        PthreadHandlerThreadV2 r1 = LiveEffectMonitor.a;
        boolean r6 = r5.booleanValue();
        NewBroadcastMonitor.a r2 = NewBroadcastMonitor.c("ttlive_anchor_prefix_gift_event_channel_status_change", null, null, 14);
        r2.l(0);
        if (r6 == false) goto L5;
        String r7 = "open";
    L6:
        r2.c(r7);
        r2.a().report();
        return;
    L5:
        r7 = "close";
        goto L6
    }
}
