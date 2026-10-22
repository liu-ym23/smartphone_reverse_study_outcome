package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ StickerSearchBox a;

    public r(StickerSearchBox r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        j r2 = this.a.d;
        if (r2 == null) goto L6;
        r2.b();
        return;
    }
}
