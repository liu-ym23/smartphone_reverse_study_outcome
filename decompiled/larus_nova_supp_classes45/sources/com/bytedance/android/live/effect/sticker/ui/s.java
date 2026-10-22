package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements View.OnFocusChangeListener {
    public final /* synthetic */ StickerSearchBox a;

    public s(StickerSearchBox r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        j r3 = this.a.d;
        if (r3 == null) goto L6;
        r3.e();
        return;
    }
}
