package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements TextWatcher {
    public final /* synthetic */ VerifyCodeEditText a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public a(VerifyCodeEditText r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        this.a.a(r5);
        String r0 = r5.toString().trim();
        int r1 = r0.length();
        VerifyCodeEditText r2 = this.a;
        int r3 = r2.e;
        if (r1 <= r3) goto L6;
        String r6 = r0.substring(0, r3);
        this.a.a.setText(r6);
        return;
    L6:
        VerifyCodeEditText.e r4 = r2.g;
        if (r4 == null) goto L9;
        r4.a(r0);
    L9:
        int r7 = r5.length();
        VerifyCodeEditText r8 = this.a;
        if (r7 != r8.e) goto L14;
        VerifyCodeEditText.f r9 = r8.f;
        if (r9 == null) goto L14;
        r9.onFinish();
    L14:
        this.a.getClass();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Editable r5 = this.a.a.getText();
        Selection.setSelection(r5, r5.length());
    }
}
