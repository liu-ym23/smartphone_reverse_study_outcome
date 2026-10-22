package com.obric.assistant.util;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l1 implements TextWatcher {
    public final /* synthetic */ String a;
    public final /* synthetic */ KeepScreenOnDelegate b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        FLogger.a.i("KeepScreenOnDelegate", this.a + " afterTextChanged");
        KeepScreenOnDelegate r4 = this.b;
        KeepScreenOnDelegate.KeepScreenOnReason r0 = KeepScreenOnDelegate.KeepScreenOnReason.InputTextTail;
        r4.getClass();
        r4.h(new i1(r4, r0));
    }

    public l1(String r1, KeepScreenOnDelegate r2) {
        this.a = r1;
        this.b = r2;
    }
}
