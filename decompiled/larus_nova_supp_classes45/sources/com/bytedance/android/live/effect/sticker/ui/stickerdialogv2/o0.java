package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o0<T> implements Observer {
    public final /* synthetic */ StickerSearchPageView a;

    public o0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        StickerSearchPageView r0 = this.a;
        StickerSearchPageView.b6(r0, (com.bytedance.android.live.effect.sticker.viewmodel.a) r2);
    }
}
