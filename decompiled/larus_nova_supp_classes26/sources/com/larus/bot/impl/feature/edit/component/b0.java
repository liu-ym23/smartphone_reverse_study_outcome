package com.larus.bot.impl.feature.edit.component;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 implements TextWatcher {
    public final /* synthetic */ BotCreateViewModel a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public b0(BotCreateViewModel r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        if (r2 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        this.a.updateDescription(String.valueOf(r2));
        BotCreateViewModel.onBotInfoChanged$default(this.a, ContentType.DESC, false, 2, null);
        return;
    L12:
        this.a.updateDescription(r2.toString());
        BotCreateViewModel.onBotInfoChanged$default(this.a, ContentType.DESC, false, 2, null);
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r6 = false;
        goto L10
    }
}
