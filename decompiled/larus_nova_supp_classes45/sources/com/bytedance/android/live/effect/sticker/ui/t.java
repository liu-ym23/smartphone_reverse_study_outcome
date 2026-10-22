package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ StickerSearchBox a;

    public t(StickerSearchBox r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        StickerSearchBox.S5(this.a).setText("");
        j r3 = this.a.d;
        if (r3 == null) goto L6;
        r3.d();
        return;
    }
}
