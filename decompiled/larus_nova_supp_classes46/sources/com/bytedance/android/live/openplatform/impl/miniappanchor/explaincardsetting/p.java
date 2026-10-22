package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements TextWatcher {
    public final /* synthetic */ ExplainCardTitleEditorDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public p(ExplainCardTitleEditorDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        ExplainCardTitleEditorDialog r0 = this.a;
        if (r3 == null) goto L6;
        String r4 = r3.toString();
        if (r4 == null) goto L6;
    L7:
        int r1 = ExplainCardTitleEditorDialog.k;
        r0.V90(r4);
        return;
    L6:
        r4 = "";
        goto L7
    }
}
