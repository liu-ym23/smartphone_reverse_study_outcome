package com.ss.android.lark.flow.passport.ui.widget.password;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements TextView.OnEditorActionListener {
    public final /* synthetic */ PasswordEditText a;

    public d(PasswordEditText r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 6) goto L9;
        PasswordEditText.c r4 = this.a.h;
        if (r4 == null) goto L10;
        r4.a(r1.getText().toString());
        return false;
    L10:
        return false;
    L9:
        return false;
    }
}
