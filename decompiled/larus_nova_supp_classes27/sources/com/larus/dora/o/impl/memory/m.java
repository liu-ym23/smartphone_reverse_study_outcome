package com.larus.dora.o.impl.memory;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements TextWatcher {
    public final /* synthetic */ l a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public m(l r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        l r0 = this.a;
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L6:
        TextView r1 = r0.e;
        if (r1 == null) goto L10;
        r1.setText(r4 + "/300");
        return;
    L10:
        return;
    L5:
        r4 = 0;
        goto L6
    }
}
