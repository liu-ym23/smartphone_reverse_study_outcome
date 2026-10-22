package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements TextWatcher {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public t(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (this.a.f().isProgrammaticUpdate() == false) goto L5;
        return;
    L5:
        if (r3 != 0) goto L8;
        if (r4 != 0) goto L8;
        return;
    L8:
        this.a.f().markUserEditedAfterAsr();
    }
}
