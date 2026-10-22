package com.larus.chat.job.impl.page.edit;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y implements TextWatcher {
    public final /* synthetic */ ChatJobEditFragment a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public y(ChatJobEditFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        ChatJobEditFragment r5 = this.a;
        int r6 = ChatJobEditFragment.n;
        ChatJobEditViewModel r7 = r5.aa0();
        if (r1 == null) goto L5;
        String r8 = r1.toString();
    L6:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r7.updateCustomFrequencyInput(r8);
        return;
    L5:
        r8 = null;
        goto L6
    }
}
