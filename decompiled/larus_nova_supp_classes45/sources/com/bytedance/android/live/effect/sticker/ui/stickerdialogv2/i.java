package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerRenderViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public i(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        StickerPreviewViewModel r11 = this.a.h;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L5:
        com.bytedance.android.live.effect.sticker.viewmodel.f r12 = (com.bytedance.android.live.effect.sticker.viewmodel.f) r11.getPreviewStatusData().getValue();
        if (r12 == null) goto L8;
        StickerPreviewStatus r13 = r12.a;
    L9:
        StickerPreviewStatus r2 = StickerPreviewStatus.None;
        if (r13 == r2) goto L15;
        StickerPreviewViewModel r1 = this.a.h;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L14:
        StickerPreviewViewModel.updatePreviewStatus$default(r1, r2, null, null, null, 12, null);
        return;
    L15:
        StickerRenderViewModel r14 = this.a.i;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("stickerRenderViewModel");
    L18:
        r14.clearRenderSticker();
        return;
    L8:
        r13 = null;
        goto L9
    }
}
