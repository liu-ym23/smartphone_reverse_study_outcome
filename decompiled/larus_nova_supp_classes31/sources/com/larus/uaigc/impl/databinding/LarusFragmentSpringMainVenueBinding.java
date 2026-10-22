package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.view.TouchInterceptingView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentSpringMainVenueBinding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final BottomMenuGridLayout c;
    public final ChatConstraintLayout d;
    public final FrameLayout e;
    public final TouchInterceptingView f;
    public final FrameLayout g;
    public final View h;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFragmentSpringMainVenueBinding a(LayoutInflater r10, ViewGroup r11) {
        View r12 = r10.inflate(2131562434, r11, false);
        int r13 = 2131364480;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131364480);
        if (r3 == null) goto L43;
        r13 = 2131364488;
        BottomMenuGridLayout r4 = ViewBindings.findChildViewById(r12, 2131364488);
        if (r4 == null) goto L43;
        r13 = 2131365254;
        if (((ViewStub) ViewBindings.findChildViewById(r12, 2131365254)) == null) goto L43;
        r13 = 2131365588;
        ChatConstraintLayout r5 = ViewBindings.findChildViewById(r12, 2131365588);
        if (r5 == null) goto L43;
        r13 = 2131372778;
        if (ViewBindings.findChildViewById(r12, 2131372778) == null) goto L43;
        r13 = 2131372779;
        if (ViewBindings.findChildViewById(r12, 2131372779) == null) goto L43;
        r13 = 2131375324;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131375324);
        if (r6 == null) goto L43;
        r13 = 2131375364;
        if (((ViewStub) ViewBindings.findChildViewById(r12, 2131375364)) == null) goto L43;
        r13 = 2131375385;
        TouchInterceptingView r7 = ViewBindings.findChildViewById(r12, 2131375385);
        if (r7 == null) goto L43;
        r13 = 2131375556;
        if (ViewBindings.findChildViewById(r12, 2131375556) == null) goto L43;
        r13 = 2131377386;
        if (ViewBindings.findChildViewById(r12, 2131377386) == null) goto L43;
        r13 = 2131382457;
        if (((ViewStub) ViewBindings.findChildViewById(r12, 2131382457)) == null) goto L43;
        FrameLayout r8 = (FrameLayout) r12;
        r13 = 2131387040;
        if (((Space) ViewBindings.findChildViewById(r12, 2131387040)) == null) goto L43;
        r13 = 2131387041;
        if (((Space) ViewBindings.findChildViewById(r12, 2131387041)) == null) goto L43;
        r13 = 2131387057;
        if (((ViewStub) ViewBindings.findChildViewById(r12, 2131387057)) == null) goto L43;
        r13 = 2131387119;
        View r9 = ViewBindings.findChildViewById(r12, 2131387119);
        if (r9 == null) goto L43;
        r13 = 2131387487;
        if (((ViewStub) ViewBindings.findChildViewById(r12, 2131387487)) == null) goto L43;
        r13 = 2131389133;
        if (ViewBindings.findChildViewById(r12, 2131389133) == null) goto L43;
        r13 = 2131389273;
        if (ViewBindings.findChildViewById(r12, 2131389273) == null) goto L43;
        return new LarusFragmentSpringMainVenueBinding(r8, r3, r4, r5, r6, r7, r8, r9);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }

    public LarusFragmentSpringMainVenueBinding(FrameLayout r1, FrameLayout r2, BottomMenuGridLayout r3, ChatConstraintLayout r4, FrameLayout r5, TouchInterceptingView r6, FrameLayout r7, View r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
