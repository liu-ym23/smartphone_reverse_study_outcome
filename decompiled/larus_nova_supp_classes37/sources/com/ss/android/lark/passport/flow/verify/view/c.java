package com.ss.android.lark.passport.flow.verify.view;

import android.text.TextUtils;
import android.widget.Button;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.password.PasswordEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements PasswordEditText.g {
    public final /* synthetic */ VerifyPwdFragment a;

    public c(VerifyPwdFragment r1) {
        this.a = r1;
    }

    public final void h(String r2) {
        CommonUiContainer r0 = this.a.j;
        if (r0 == null) goto L9;
        boolean r3 = !TextUtils.isEmpty(r2);
        Button r1 = (Button) r0.h.getValue();
        if (r1 == null) goto L10;
        r1.setEnabled(r3);
        return;
    L10:
        return;
    }
}
