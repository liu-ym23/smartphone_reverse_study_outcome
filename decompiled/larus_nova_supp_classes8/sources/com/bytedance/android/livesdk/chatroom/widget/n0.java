package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n0 implements IFetchEffectListener {
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget a;
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget.a b;

    public final void onStart(Effect r1) {
    }

    public final void onSuccess(Object r4) {
        Effect r5 = (Effect) r4;
        if (r5 != null) goto L7;
        PthreadHandlerThreadV2 r6 = LiveEffectMonitor.a;
        LiveEffectMonitor.i(true, this.b.a.b, false, "response null");
        zg1.q r7 = this.b.a.d;
        if (r7 == null) goto L10;
        zg1.q.a.a(r7, false);
    L10:
        LiveGiftMenuStickerServiceWidget r8 = this.a;
        LiveGiftMenuStickerServiceWidget.a r0 = this.b;
        int r1 = LiveGiftMenuStickerServiceWidget.i;
        r8.yq(r0);
        return;
    L7:
        Sticker r9 = com.bytedance.android.live.effect.sticker.d.b(r5);
        this.a.c.put(this.b.a.b, r9);
        this.a.xq(r9);
        PthreadHandlerThreadV2 r10 = LiveEffectMonitor.a;
        LiveEffectMonitor.i(true, this.b.a.b, true, "");
        zg1.q r11 = this.b.a.d;
        if (r11 == null) goto L10;
        zg1.q.a.a(r11, true);
        goto L10
    }

    public n0(LiveGiftMenuStickerServiceWidget r1, LiveGiftMenuStickerServiceWidget.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Effect r3, ExceptionResult r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        PthreadHandlerThreadV2 r5 = LiveEffectMonitor.a;
        LiveEffectMonitor.i(true, this.b.a.b, false, "download failed");
        zg1.q r6 = this.b.a.d;
        if (r6 == null) goto L5;
        zg1.q.a.a(r6, false);
    L5:
        LiveGiftMenuStickerServiceWidget r7 = this.a;
        LiveGiftMenuStickerServiceWidget.a r8 = this.b;
        int r0 = LiveGiftMenuStickerServiceWidget.i;
        r7.yq(r8);
    }
}
