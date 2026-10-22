package com.ss.android.lark.forwardv2.impl.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements TextWatcher {
    public final /* synthetic */ ForwardClickableEnhancedView a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public o(ForwardClickableEnhancedView r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        this.a.k1(r2);
    }
}
