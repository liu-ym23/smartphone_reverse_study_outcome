package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements TextWatcher {
    public l() {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        if ((r2 instanceof Spanned) == false) goto L7;
        Spanned r6 = (Spanned) r2;
        int r0 = 0;
        Object[] r7 = r6.getSpans(0, r6.length(), com.ss.android.lark.keyboard.edittext2.span.l.class);
        int r8 = r7.length;
    L5:
        if (r0 >= r8) goto L9;
        ((com.ss.android.lark.keyboard.edittext2.span.l) r7[r0]).c(r2);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }
}
