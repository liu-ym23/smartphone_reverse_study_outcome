package com.bytedance.android.live.broadcast.effect;

import com.bytedance.android.live.broadcast.stream.capture.effect.StickerEffectHandler;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.effect.api.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements t {
    public final StickerEffectHandler a;

    @Override // com.bytedance.android.live.effect.api.t
    public final int a() {
        this.a.getClass();
        return IQRCodeService.ERR_CAMERA;
    }

    public a(StickerEffectHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "liveStickerEffect");
        this.a = r2;
    }
}
