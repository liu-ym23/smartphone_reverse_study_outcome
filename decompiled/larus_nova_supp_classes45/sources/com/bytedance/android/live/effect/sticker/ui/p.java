package com.bytedance.android.live.effect.sticker.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements TextWatcher {
    public final /* synthetic */ StickerSearchBox a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public p(StickerSearchBox r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        int r0 = 0;
        if (r4 == null) goto L10;
        boolean r2 = true;
        if (r4.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L10;
    L11:
        ImageView r3 = StickerSearchBox.R5(this.a);
        if (r2 == false) goto L14;
        r0 = 8;
    L14:
        r3.setVisibility(r0);
        j r5 = this.a.d;
        if (r5 == null) goto L22;
        if (r4 == null) goto L19;
        String r6 = r4.toString();
        if (r6 == null) goto L19;
    L20:
        r5.c(r2, r6);
        return;
    L19:
        r6 = "";
        goto L20
    L22:
        return;
    L7:
        r1 = false;
    L10:
        r2 = false;
        goto L11
    }
}
