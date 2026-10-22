package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements TextWatcher {
    public final /* synthetic */ DoraObricEarbudsAddSpecialContactSheet a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public s(DoraObricEarbudsAddSpecialContactSheet r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        DoraObricEarbudsAddSpecialContactSheet r3 = this.a;
        int r0 = DoraObricEarbudsAddSpecialContactSheet.h;
        r3.U90();
    }
}
