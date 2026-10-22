package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.os.Build;
import com.bytedance.android.live.effect.sticker.ui.StickerFavoriteView;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements StickerFavoriteView.a {
    public final /* synthetic */ StickerFavoriteView a;
    public final /* synthetic */ LiveStickerDialogV2 b;

    public l(StickerFavoriteView r1, LiveStickerDialogV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.StickerFavoriteView.a
    public final void a(Sticker r3, boolean r4) {
        StickerDataViewModel r0 = this.b.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L5:
        r0.updateStickerFavoriteStatus(r3, r4);
        if (r4 == false) goto L8;
        String r5 = "收藏成功";
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L12;
        this.a.setAccessibilityPaneTitle(r5);
        return;
    L12:
        this.a.announceForAccessibility(r5);
        return;
    L8:
        r5 = "已取消收藏";
        goto L10
    }
}
