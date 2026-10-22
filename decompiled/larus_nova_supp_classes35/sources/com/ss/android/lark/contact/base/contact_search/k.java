package com.ss.android.lark.contact.base.contact_search;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements TextWatcher {
    public final /* synthetic */ s a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public k(s r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        this.a.B = true;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.a.y.setEnabled(false);
        return;
    L5:
        this.a.y.setEnabled(true);
    }
}
