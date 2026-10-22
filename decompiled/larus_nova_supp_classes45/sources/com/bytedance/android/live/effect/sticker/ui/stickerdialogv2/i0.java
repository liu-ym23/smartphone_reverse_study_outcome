package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 implements View.OnClickListener {
    public final /* synthetic */ StickerSearchPageView a;

    public i0(StickerSearchPageView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        LoadingStatusView r2 = StickerSearchPageView.R5(this.a);
        if (r2 == null) goto L5;
        r2.showLoading();
    L5:
        StickerSearchPageView.c6(this.a);
    }
}
