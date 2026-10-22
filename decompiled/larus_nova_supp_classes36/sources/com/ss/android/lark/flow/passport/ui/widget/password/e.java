package com.ss.android.lark.flow.passport.ui.widget.password;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ PasswordEditText a;

    public e(PasswordEditText r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a.setText("");
        this.a.a.requestFocus();
        this.a.c.setVisibility(8);
    }
}
