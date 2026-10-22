package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusDialogAuthorizeUgcVoiceBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatButton b;
    public final AppCompatImageView c;
    public final LarusItemAuthorizeUgcVoiceBinding d;
    public final LarusItemAuthorizeUgcVoiceBinding e;
    public final LarusItemAuthorizeUgcVoiceBinding f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDialogAuthorizeUgcVoiceBinding a(LayoutInflater r8, ViewGroup r9) {
        ConstraintLayout r10 = r8.inflate(2131562031, r9, false);
        int r11 = 2131364991;
        AppCompatButton r3 = ViewBindings.findChildViewById(r10, 2131364991);
        if (r3 == null) goto L17;
        r11 = 2131365114;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r10, 2131365114);
        if (r4 == null) goto L17;
        r11 = 2131377528;
        View r0 = ViewBindings.findChildViewById(r10, 2131377528);
        if (r0 == null) goto L17;
        LarusItemAuthorizeUgcVoiceBinding r5 = LarusItemAuthorizeUgcVoiceBinding.a(r0);
        r11 = 2131377529;
        View r1 = ViewBindings.findChildViewById(r10, 2131377529);
        if (r1 == null) goto L17;
        LarusItemAuthorizeUgcVoiceBinding r6 = LarusItemAuthorizeUgcVoiceBinding.a(r1);
        r11 = 2131377530;
        View r2 = ViewBindings.findChildViewById(r10, 2131377530);
        if (r2 == null) goto L17;
        LarusItemAuthorizeUgcVoiceBinding r7 = LarusItemAuthorizeUgcVoiceBinding.a(r2);
        r11 = 2131388514;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131388514)) == null) goto L17;
        return new LarusDialogAuthorizeUgcVoiceBinding(r10, r3, r4, r5, r6, r7);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LarusDialogAuthorizeUgcVoiceBinding(ConstraintLayout r1, AppCompatButton r2, AppCompatImageView r3, LarusItemAuthorizeUgcVoiceBinding r4, LarusItemAuthorizeUgcVoiceBinding r5, LarusItemAuthorizeUgcVoiceBinding r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
