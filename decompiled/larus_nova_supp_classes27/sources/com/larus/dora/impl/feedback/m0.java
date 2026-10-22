package com.larus.dora.impl.feedback;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 implements TextWatcher {
    public final /* synthetic */ DoraGFeedbackFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public m0(DoraGFeedbackFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        DoraGFeedbackFragment r0 = this.a;
        int r1 = DoraGFeedbackFragment.r;
        r0.X90().getConversationLinkFlow().setValue(String.valueOf(r3));
    }
}
