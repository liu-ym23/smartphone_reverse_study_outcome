package com.ss.android.lark.flow.passport.ui.widget.password;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PasswordEditText a;

    public f(PasswordEditText r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (r2 == false) goto L4;
        this.a.a.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    L5:
        this.a.a.requestFocus();
        SCEditText r3 = this.a.a;
        r3.setSelection(r3.getText().length());
        return;
    L4:
        this.a.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L5
    }
}
