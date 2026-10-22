package com.larus.avlink.env.diary.style;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 implements TextWatcher {
    public final /* synthetic */ DiaryStyleInputDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public d0(DiaryStyleInputDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        DiaryStyleInputDialog r0 = this.a;
        int r1 = DiaryStyleInputDialog.j;
        r0.T90(r3);
    }
}
