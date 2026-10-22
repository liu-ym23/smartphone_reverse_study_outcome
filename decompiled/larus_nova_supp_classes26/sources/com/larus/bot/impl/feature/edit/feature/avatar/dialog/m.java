package com.larus.bot.impl.feature.edit.feature.avatar.dialog;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.larus.bot.impl.databinding.LarusDialogAvatarPromptInputBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m implements TextWatcher {
    public final /* synthetic */ AvatarPromptInputDialog a;
    public final /* synthetic */ LarusDialogAvatarPromptInputBinding b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public m(AvatarPromptInputDialog r1, LarusDialogAvatarPromptInputBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        if (r2 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L13;
        AvatarPromptInputDialog r7 = this.a;
        int r8 = AvatarPromptInputDialog.o;
        LarusDialogAvatarPromptInputBinding r9 = r7.f;
        if (r9 == null) goto L21;
        r9.b.setEnabled(false);
        r9.b.setAlpha(0.3f);
        return;
    L21:
        return;
    L13:
        LarusDialogAvatarPromptInputBinding r10 = this.a.f;
        if (r10 == null) goto L17;
        r10.b.setEnabled(true);
        r10.b.setAlpha(1.0f);
    L17:
        if (r2.length() <= 100) goto L19;
        r2 = r2.subSequence(0, 100);
        this.b.c.setText(r2);
        Selection.setSelection(this.b.c.getText(), r2.length());
    L19:
        AvatarPromptInputDialog r11 = this.a;
        r11.h = r2.toString();
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
