package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public n(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        StickerPreviewViewModel r3 = this.a.h;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L5:
        r3.tryApplySticker();
    }
}
