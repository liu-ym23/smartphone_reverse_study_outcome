package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p0 implements TextWatcher {
    public final /* synthetic */ j0.c a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public p0(j0.c r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        EditText r3 = this.a.b.a;
        if (r3 == null) goto L12;
        Editable r4 = r3.getText();
        if (r4 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r4) == false) goto L10;
        this.a.k(false);
        return;
    L10:
        this.a.k(true);
        return;
    }
}
