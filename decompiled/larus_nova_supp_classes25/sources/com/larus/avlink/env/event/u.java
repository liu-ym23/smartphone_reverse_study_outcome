package com.larus.avlink.env.event;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u implements TextWatcher {
    public final /* synthetic */ DoraEnvObservePersonalMemoryEditDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public u(DoraEnvObservePersonalMemoryEditDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        DoraEnvObservePersonalMemoryEditDialog r0 = this.a;
        if (r4 == null) goto L5;
        int r1 = r4.length();
    L6:
        int r2 = DoraEnvObservePersonalMemoryEditDialog.k;
        r0.U90(r1);
        this.a.V90(r4);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
