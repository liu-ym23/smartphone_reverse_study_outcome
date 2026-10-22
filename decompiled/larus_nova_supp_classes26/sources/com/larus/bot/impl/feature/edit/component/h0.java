package com.larus.bot.impl.feature.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 implements TextWatcher {
    public final /* synthetic */ LarusPageBotEditBinding a;
    public final /* synthetic */ BotCreateViewModel b;
    public final /* synthetic */ BotCreateNameComponent c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public h0(LarusPageBotEditBinding r1, BotCreateViewModel r2, BotCreateNameComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        if (r3 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
    L24:
        this.a.B.setVisibility(8);
        this.b.updateName("");
        BotCreateViewModel.onBotInfoChanged$default(this.b, ContentType.NAME, false, 2, null);
        return;
    L12:
        if (StringsKt.isBlank(r3) == true) goto L24;
        Context r8 = this.c.getContext();
        if (r8 == null) goto L19;
        Resources r9 = r8.getResources();
        if (r9 == null) goto L19;
        int r10 = r9.getInteger(2131427368);
    L21:
        if (r3.length() <= r10) goto L23;
        r3 = r3.subSequence(0, r10);
        this.a.z.setText(r3);
    L23:
        this.b.updateName(StringsKt.trim(r3.toString()).toString());
        BotCreateViewModel.onBotInfoChanged$default(this.b, ContentType.NAME, false, 2, null);
        this.a.B.setVisibility(0);
        return;
    L19:
        r10 = 40;
        goto L21
    L5:
        if (r3.length() == 0) goto L8;
        r7 = false;
        goto L10
    }
}
