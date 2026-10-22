package com.larus.bot.impl.feature.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotUpdateViewModel;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t1 implements TextWatcher {
    public final /* synthetic */ BotUpdateNameComponent a;
    public final /* synthetic */ LarusPageBotEditBinding b;
    public final /* synthetic */ BotUpdateViewModel c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public t1(BotUpdateNameComponent r1, LarusPageBotEditBinding r2, BotUpdateViewModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (r1 == null) goto L15;
        Context r5 = this.a.getContext();
        if (r5 == null) goto L9;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L9;
        int r7 = r6.getInteger(2131427368);
    L11:
        if (r1.length() <= r7) goto L13;
        r1 = r1.subSequence(0, r7);
        this.b.z.setText(r1);
    L13:
        this.c.updateName(StringsKt.trim(r1.toString()).toString());
        return;
    L9:
        r7 = 40;
        goto L11
    }
}
