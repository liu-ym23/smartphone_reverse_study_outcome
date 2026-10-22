package com.larus.profile.impl;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.profile.impl.databinding.LarusAccountRegisterUserInfoPageBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a2 implements TextWatcher {
    public final /* synthetic */ LarusAccountRegisterUserInfoPageBinding a;
    public final /* synthetic */ ProfileRegisterFragment b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        AppCompatImageView r0 = this.a.d;
        boolean r1 = true;
        int r2 = 0;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
    L13:
        r1 = false;
    L15:
        if (r1 == true) goto L18;
        r2 = 8;
    L18:
        r0.setVisibility(r2);
        this.a.i.setVisibility(8);
        ProfileRegisterFragment r6 = this.b;
        int r3 = ProfileRegisterFragment.o;
        r6.Y90();
        return;
    L11:
        if (this.a.h.hasFocus() == false) goto L13;
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public a2(LarusAccountRegisterUserInfoPageBinding r1, ProfileRegisterFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
