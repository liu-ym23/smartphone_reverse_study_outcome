package com.larus.av_call.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.av_call.view.SceneModeButton;
import com.larus.common_ui.view.NoSpaceTextView;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusLayoutRealtimeCallTopBinding implements ViewBinding {
    public final View a;
    public final NoSpaceTextView b;
    public final FrameLayout c;
    public final SceneModeButton d;
    public final CustomRoundImageView e;
    public final LottieAdapterView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final ImageView i;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutRealtimeCallTopBinding a(View r12) {
        int r0 = 2131372908;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131372908)) == null) goto L23;
        r0 = 2131383812;
        NoSpaceTextView r4 = ViewBindings.findChildViewById(r12, 2131383812);
        if (r4 == null) goto L23;
        r0 = 2131383813;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131383813);
        if (r5 == null) goto L23;
        r0 = 2131383822;
        SceneModeButton r6 = (SceneModeButton) ViewBindings.findChildViewById(r12, 2131383822);
        if (r6 == null) goto L23;
        r0 = 2131383830;
        CustomRoundImageView r7 = ViewBindings.findChildViewById(r12, 2131383830);
        if (r7 == null) goto L23;
        r0 = 2131383833;
        LottieAdapterView r8 = ViewBindings.findChildViewById(r12, 2131383833);
        if (r8 == null) goto L23;
        r0 = 2131383834;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r12, 2131383834);
        if (r9 == null) goto L23;
        r0 = 2131383835;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r12, 2131383835);
        if (r10 == null) goto L23;
        r0 = 2131387833;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r12, 2131387833);
        if (r11 == null) goto L23;
        return new LarusLayoutRealtimeCallTopBinding(r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public LarusLayoutRealtimeCallTopBinding(View r1, NoSpaceTextView r2, FrameLayout r3, SceneModeButton r4, CustomRoundImageView r5, LottieAdapterView r6, AppCompatImageView r7, AppCompatImageView r8, ImageView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
