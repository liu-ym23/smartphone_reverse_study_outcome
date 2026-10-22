package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a0 implements TextWatcher {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ Context b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        b0 r0 = this.a;
        Context r1 = this.b;
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L6:
        r0.b(r1, r4);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public a0(b0 r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
