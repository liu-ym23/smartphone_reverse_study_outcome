package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import uzb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnFocusChangeListener {
    public final /* synthetic */ VerifyCodeEditText a;

    public d(VerifyCodeEditText r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r4, boolean r5) {
        VerifyCodeEditText r6 = this.a;
        int r0 = VerifyCodeEditText.h;
        r6.getClass();
        VerifyCodeEditText r7 = this.a;
        if (r5 == false) goto L5;
        r7.a(r7.a.getText());
    L11:
        if (r5 == true) goto L15;
        f.b(this.a.getContext());
        return;
    L15:
        return;
    L5:
        CodeView[] r8 = r7.d;
        if (r8 == null) goto L11;
        int r1 = r8.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r8[r2].b();
        r2 = r2 + 1;
        goto L9
    }
}
