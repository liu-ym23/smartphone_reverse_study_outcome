package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements TextView.OnEditorActionListener {
    public final /* synthetic */ VerifyCodeEditText a;

    public b(VerifyCodeEditText r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 6) goto L7;
        VerifyCodeEditText r4 = this.a;
        int r5 = VerifyCodeEditText.h;
        r4.getClass();
        return false;
    L7:
        return false;
    }
}
