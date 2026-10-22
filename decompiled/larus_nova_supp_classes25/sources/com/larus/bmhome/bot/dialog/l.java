package com.larus.bmhome.bot.dialog;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements TextWatcher {
    public final /* synthetic */ BotNickNameEditDialog a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public l(BotNickNameEditDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        BotNickNameEditDialog r5 = this.a;
        int r6 = BotNickNameEditDialog.n;
        r5.T90(r1);
    }
}
