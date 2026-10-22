package com.larus.dora.o.impl.diary;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0 implements TextWatcher {
    public final /* synthetic */ i0 a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public j0(i0 r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        i0 r0 = this.a;
        if (r2 == null) goto L5;
        int r3 = r2.length();
    L6:
        r0.d(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
