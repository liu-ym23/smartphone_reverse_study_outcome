package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGOnboardingBottomBtnLayoutBinding implements ViewBinding {
    public final LinearLayout a;
    public final DoraTextView b;
    public final LinearLayout c;
    public final DoraTextView d;
    public final View e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraGOnboardingBottomBtnLayoutBinding a(View r9) {
        int r0 = 2131369592;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r9, 2131369592);
        if (r4 == null) goto L13;
        LinearLayout r5 = (LinearLayout) r9;
        r0 = 2131369594;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r9, 2131369594);
        if (r6 == null) goto L13;
        r0 = 2131369597;
        View r7 = ViewBindings.findChildViewById(r9, 2131369597);
        if (r7 == null) goto L13;
        r0 = 2131369598;
        View r8 = ViewBindings.findChildViewById(r9, 2131369598);
        if (r8 == null) goto L13;
        return new LarusDoraGOnboardingBottomBtnLayoutBinding(r5, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    public LarusDoraGOnboardingBottomBtnLayoutBinding(LinearLayout r1, DoraTextView r2, LinearLayout r3, DoraTextView r4, View r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
