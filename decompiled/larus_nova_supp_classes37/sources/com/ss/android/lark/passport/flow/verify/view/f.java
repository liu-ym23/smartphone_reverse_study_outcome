package com.ss.android.lark.passport.flow.verify.view;

import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.password.PasswordEditText;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ VerifyPwdFragment a;

    public f(VerifyPwdFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        VerifyPwdFragment r4 = this.a;
        int r0 = VerifyPwdFragment.k;
        VerifyPwdViewModel r5 = (VerifyPwdViewModel) r4.V90().getValue();
        PasswordEditText r1 = this.a.i;
        if (r1 == null) goto L6;
        String r2 = r1.getString();
        if (r2 == null) goto L6;
    L7:
        r5.reduce(new VerifyPwdViewModel.a.b(r2));
        return;
    L6:
        r2 = "";
        goto L7
    }
}
