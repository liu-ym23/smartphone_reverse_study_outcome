package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.common.LiveCommonStickerRenderViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements m {
    public i() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r5) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = r5.e;
        String r2 = r5.f;
        r0.getClass();
        LiveCommonStickerRenderViewModel r3 = (LiveCommonStickerRenderViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerRenderViewModel.class);
        if (r3 == null) goto L5;
        r3.renderSticker(r5.g);
    L5:
        r5.a();
    }
}
