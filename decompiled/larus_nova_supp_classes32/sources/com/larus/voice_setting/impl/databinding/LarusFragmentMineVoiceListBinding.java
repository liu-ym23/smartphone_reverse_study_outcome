package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusFragmentMineVoiceListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusMyVoiceListEmptyBinding b;
    public final LarusVoiceListErrorBinding c;
    public final NestedScrollView d;
    public final RecyclerView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFragmentMineVoiceListBinding a(LayoutInflater r11, ViewGroup r12) {
        ConstraintLayout r13 = r11.inflate(2131562409, r12, false);
        int r14 = 2131392713;
        ConstraintLayout r0 = ViewBindings.findChildViewById(r13, 2131392713);
        if (r0 == null) goto L25;
        ConstraintLayout r15 = r0;
        int r2 = 2131392714;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r0, 2131392714);
        if (r3 == null) goto L23;
        r2 = 2131392715;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r0, 2131392715);
        if (r4 == null) goto L23;
        LarusMyVoiceListEmptyBinding r7 = new LarusMyVoiceListEmptyBinding(r15, r15, r3, r4);
        r14 = 2131392720;
        ConstraintLayout r1 = ViewBindings.findChildViewById(r13, 2131392720);
        if (r1 == null) goto L25;
        int r16 = 2131383232;
        if (ViewBindings.findChildViewById(r1, 2131383232) == null) goto L21;
        r16 = 2131383234;
        if (ViewBindings.findChildViewById(r1, 2131383234) == null) goto L21;
        ConstraintLayout r5 = r1;
        LarusVoiceListErrorBinding r8 = new LarusVoiceListErrorBinding(r5, r5);
        r14 = 2131392722;
        NestedScrollView r9 = ViewBindings.findChildViewById(r13, 2131392722);
        if (r9 == null) goto L25;
        r14 = 2131392751;
        RecyclerView r10 = ViewBindings.findChildViewById(r13, 2131392751);
        if (r10 == null) goto L25;
        return new LarusFragmentMineVoiceListBinding(r13, r7, r8, r9, r10);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r16)));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }

    public LarusFragmentMineVoiceListBinding(ConstraintLayout r1, LarusMyVoiceListEmptyBinding r2, LarusVoiceListErrorBinding r3, NestedScrollView r4, RecyclerView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
