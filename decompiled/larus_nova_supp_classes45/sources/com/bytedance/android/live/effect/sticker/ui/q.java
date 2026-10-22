package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ StickerSearchBox a;

    public q(StickerSearchBox r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        StickerSearchBox.S5(this.a).setCursorVisible(true);
    }
}
