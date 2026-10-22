package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ VerifyCodeEditText a;

    public c(VerifyCodeEditText r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        VerifyCodeEditText r3 = this.a;
        int r0 = VerifyCodeEditText.h;
        r3.getClass();
        this.a.a.setCursorVisible(false);
    }
}
