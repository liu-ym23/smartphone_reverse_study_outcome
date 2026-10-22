package com.larus.dora.obric.device_management.setting.g.feedback;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y implements TextWatcher {
    public final /* synthetic */ DoraObricGFeedbackFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public y(DoraObricGFeedbackFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        DoraObricGFeedbackFragment r0 = this.a;
        int r1 = DoraObricGFeedbackFragment.A;
        r0.Y90().getConversationLinkFlow().setValue(String.valueOf(r3));
    }
}
