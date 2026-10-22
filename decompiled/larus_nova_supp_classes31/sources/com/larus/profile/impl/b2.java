package com.larus.profile.impl;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.common.apphost.AppHost;
import com.larus.profile.impl.databinding.LarusAccountRegisterUserInfoPageBinding;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b2 implements TextWatcher {
    public final /* synthetic */ ProfileRegisterFragment a;
    public final /* synthetic */ LarusAccountRegisterUserInfoPageBinding b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r8) {
        if (Intrinsics.areEqual(this.a.i, String.valueOf(r8)) == false) goto L9;
        this.b.k.setVisibility(8);
        this.b.p.setVisibility(8);
        LarusAccountRegisterUserInfoPageBinding r9 = this.b;
        AppCompatImageView r0 = r9.e;
        if (r9.l.hasFocus() == false) goto L7;
        int r10 = 0;
    L8:
        r0.setVisibility(r10);
        this.b.m.setVisibility(8);
        this.b.o.setVisibility(0);
        this.a.Y90();
        return;
    L7:
        r10 = 8;
        goto L8
    L9:
        this.b.k.setVisibility(8);
        this.b.p.setVisibility(8);
        AppCompatImageView r1 = this.b.e;
        boolean r3 = true;
        if (r8 != null) goto L12;
    L15:
        boolean r11 = true;
    L16:
        if (r11 == false) goto L18;
    L20:
        r3 = false;
    L21:
        if (r3 == false) goto L23;
        int r12 = 0;
    L24:
        r1.setVisibility(r12);
        this.a.Y90();
        ProfileRegisterFragment r13 = this.a;
        LarusAccountRegisterUserInfoPageBinding r2 = r13.e;
        if (r2 == null) goto L54;
        String r4 = String.valueOf(r2.l.getText());
        String r6 = null;
        if (com.larus.utils.o0.c(r4) >= 4) goto L39;
        r2.o.setVisibility(8);
        r2.m.setVisibility(0);
        if (AppHost.a.isOversea() == false) goto L34;
        AppCompatTextView r5 = r2.n;
        Context r14 = r13.getContext();
        if (r14 == null) goto L33;
        r6 = r14.getString(2131900862);
    L33:
        r5.setText(r6);
    L51:
        Unit r15 = Unit.INSTANCE;
        return;
    L34:
        AppCompatTextView r7 = r2.n;
        Context r16 = r13.getContext();
        if (r16 == null) goto L37;
        r6 = r16.getString(2131909230);
    L37:
        r7.setText(r6);
        goto L51
    L39:
        if (ProfileEditFragment.r.matcher(r4).matches() == true) goto L50;
        r2.o.setVisibility(8);
        r2.m.setVisibility(0);
        if (AppHost.a.isOversea() == false) goto L46;
        AppCompatTextView r17 = r2.n;
        Context r18 = r13.getContext();
        if (r18 == null) goto L45;
        r6 = r18.getString(2131900863);
    L45:
        r17.setText(r6);
        goto L51
    L46:
        AppCompatTextView r19 = r2.n;
        Context r20 = r13.getContext();
        if (r20 == null) goto L49;
        r6 = r20.getString(2131909232);
    L49:
        r19.setText(r6);
        goto L51
    L50:
        r13.aa0().checkUserName(r4);
        goto L51
    L54:
        return;
    L23:
        r12 = 8;
        goto L24
    L18:
        if (this.b.l.hasFocus() == false) goto L20;
    L12:
        if (r8.length() == 0) goto L15;
        r11 = false;
        goto L16
    }

    public b2(ProfileRegisterFragment r1, LarusAccountRegisterUserInfoPageBinding r2) {
        this.a = r1;
        this.b = r2;
    }
}
