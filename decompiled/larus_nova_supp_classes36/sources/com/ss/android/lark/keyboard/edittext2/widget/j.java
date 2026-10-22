package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements TextWatcher {
    public final /* synthetic */ RichTextFunctionEditText a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public j(RichTextFunctionEditText r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        Editable r6 = this.a.getText();
        if ((r6 instanceof Spanned) == false) goto L7;
        int r2 = 0;
        Object[] r0 = r6.getSpans(0, r6.length(), com.ss.android.lark.keyboard.edittext2.span.l.class);
        int r1 = r0.length;
    L5:
        if (r2 >= r1) goto L9;
        ((com.ss.android.lark.keyboard.edittext2.span.l) r0[r2]).b(r6);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }
}
