package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.onboarding.DoraOnboardingNestedScrollView;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingTopicView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingV2WakeupBinding implements ViewBinding {
    public final DoraOnboardingNestedScrollView a;
    public final CircleSimpleDraweeView b;
    public final View c;
    public final View d;
    public final CustomBarCountAudioVisualizer e;
    public final ImageView f;
    public final View g;
    public final RelativeLayout h;
    public final LottieAdapterView i;
    public final LottieAdapterView j;
    public final LarusDoraOnboardingMusicPanelBinding k;
    public final DoraTextView l;
    public final DoraLiteOnboardingTopicView m;
    public final DoraUrlSpanTextView n;
    public final DoraTextView o;

    public final View getRoot() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LarusDoraOnboardingV2WakeupBinding a(LayoutInflater r110, ViewGroup r20) {
        View r0 = r110.inflate(2131562248, r20, false);
        int r1 = 2131369852;
        CircleSimpleDraweeView r5 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r0, 2131369852);
        if (r5 == null) goto L35;
        r1 = 2131369853;
        View r6 = ViewBindings.findChildViewById(r0, 2131369853);
        if (r6 == null) goto L35;
        r1 = 2131369863;
        View r7 = ViewBindings.findChildViewById(r0, 2131369863);
        if (r7 == null) goto L35;
        r1 = 2131369864;
        CustomBarCountAudioVisualizer r8 = (CustomBarCountAudioVisualizer) ViewBindings.findChildViewById(r0, 2131369864);
        if (r8 == null) goto L35;
        r1 = 2131369865;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r0, 2131369865);
        if (r9 == null) goto L35;
        r1 = 2131369866;
        View r10 = ViewBindings.findChildViewById(r0, 2131369866);
        if (r10 == null) goto L35;
        r1 = 2131369867;
        RelativeLayout r11 = (RelativeLayout) ViewBindings.findChildViewById(r0, 2131369867);
        if (r11 == null) goto L35;
        r1 = 2131369868;
        LottieAdapterView r12 = ViewBindings.findChildViewById(r0, 2131369868);
        if (r12 == null) goto L35;
        r1 = 2131369869;
        LottieAdapterView r13 = ViewBindings.findChildViewById(r0, 2131369869);
        if (r13 == null) goto L35;
        DoraOnboardingNestedScrollView r4 = (DoraOnboardingNestedScrollView) r0;
        r1 = 2131369910;
        View r2 = ViewBindings.findChildViewById(r0, 2131369910);
        if (r2 == null) goto L35;
        LarusDoraOnboardingMusicPanelBinding r14 = LarusDoraOnboardingMusicPanelBinding.a(r2);
        r1 = 2131369915;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131369915)) == null) goto L35;
        r1 = 2131369920;
        DoraTextView r15 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369920);
        if (r15 == null) goto L35;
        r1 = 2131369922;
        DoraLiteOnboardingTopicView r16 = (DoraLiteOnboardingTopicView) ViewBindings.findChildViewById(r0, 2131369922);
        if (r16 == null) goto L35;
        r1 = 2131369946;
        DoraUrlSpanTextView r17 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r0, 2131369946);
        if (r17 == null) goto L35;
        r1 = 2131369947;
        DoraTextView r18 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369947);
        if (r18 == null) goto L35;
        return new LarusDoraOnboardingV2WakeupBinding(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public LarusDoraOnboardingV2WakeupBinding(DoraOnboardingNestedScrollView r1, CircleSimpleDraweeView r2, View r3, View r4, CustomBarCountAudioVisualizer r5, ImageView r6, View r7, RelativeLayout r8, LottieAdapterView r9, LottieAdapterView r10, LarusDoraOnboardingMusicPanelBinding r11, DoraTextView r12, DoraLiteOnboardingTopicView r13, DoraUrlSpanTextView r14, DoraTextView r15) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
    }
}
