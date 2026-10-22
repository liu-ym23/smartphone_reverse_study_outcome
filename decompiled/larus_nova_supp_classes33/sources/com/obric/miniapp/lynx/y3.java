package com.obric.miniapp.lynx;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y3 implements TextWatcher {
    public final /* synthetic */ LynxOUISearchBarUI a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public y3(LynxOUISearchBarUI r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        LynxOUISearchBarUI r0 = this.a;
        if (r0.c == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r0.O("input", r4);
        return;
    L7:
        r4 = null;
        goto L8
    }
}
