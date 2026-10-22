package com.larus.bot.impl.feature.edit;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w1 implements TextWatcher {
    public final /* synthetic */ BotUpdateFragment a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public w1(BotUpdateFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        BotUpdateFragment r5 = this.a;
        int r6 = BotUpdateFragment.K;
        r5.X90().updateDescription(String.valueOf(r1));
    }
}
