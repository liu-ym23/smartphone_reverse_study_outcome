package com.bytedance.android.live.effect.common;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements b {
    public final /* synthetic */ LiveCommonStickerAdjustBarView a;

    @Override // com.bytedance.android.live.effect.common.b
    public final void a(Sticker r2, Sticker.ComposerConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "sticker");
        Intrinsics.checkNotNullParameter(r3, "composerConfig");
    }

    public g(LiveCommonStickerAdjustBarView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.common.b
    public final void b(Sticker r2, Sticker.ComposerConfig r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "sticker");
        Intrinsics.checkNotNullParameter(r3, "composerConfig");
        LiveCommonStickerRenderViewModel r0 = LiveCommonStickerAdjustBarView.R5(this.a);
        if (r0 == null) goto L6;
        r0.updateTagValue(r2, r3, r4);
        return;
    }
}
