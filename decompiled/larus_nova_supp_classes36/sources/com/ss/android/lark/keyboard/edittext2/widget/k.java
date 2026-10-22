package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements TextWatcher {
    public k() {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r5, int r6, int r7, int r8) {
        if ((r5 instanceof Spanned) == false) goto L7;
        Spanned r0 = (Spanned) r5;
        int r3 = 0;
        Object[] r1 = r0.getSpans(0, r0.length(), com.ss.android.lark.keyboard.edittext2.span.l.class);
        int r2 = r1.length;
    L5:
        if (r3 >= r2) goto L9;
        ((com.ss.android.lark.keyboard.edittext2.span.l) r1[r3]).a(r5, r6, r7, r8);
        r3 = r3 + 1;
        goto L5
    L9:
        return;
    }
}
