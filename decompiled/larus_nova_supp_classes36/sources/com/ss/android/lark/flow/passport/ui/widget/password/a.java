package com.ss.android.lark.flow.passport.ui.widget.password;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.ss.android.lark.flow.passport.ui.widget.common.h;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.emm.design.edittext.SCEditText;
import uzb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements TextWatcher {
    public final /* synthetic */ PasswordEditText a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public a(PasswordEditText r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        PasswordEditText r0 = this.a;
        PasswordEditText.f r1 = r0.d;
        if (r1 == null) goto L9;
        SCEditText r2 = r0.a;
        if (r2 == null) goto L8;
        r2.setTextColor(r1.e);
    L8:
        h r3 = r0.j;
        int r4 = r0.d.b;
        r3.getClass();
        r3.b(l.a(LarkContext.getApplication(), 1.0f), r4);
    L9:
        ImageView r6 = this.a.c;
        if (TextUtils.isEmpty(r5) == false) goto L12;
        int r7 = 8;
    L13:
        r6.setVisibility(r7);
        PasswordEditText.g r8 = this.a.g;
        if (r8 == null) goto L20;
        if (r5 == null) goto L17;
        String r9 = r5.toString();
    L18:
        r8.h(r9);
        return;
    L17:
        r9 = "";
        goto L18
    L20:
        return;
    L12:
        r7 = 0;
        goto L13
    }
}
