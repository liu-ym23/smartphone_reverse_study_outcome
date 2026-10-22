package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding implements ViewBinding {
    public final View a;
    public final View b;
    public final ConstraintLayout c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding a(LayoutInflater r7, ViewGroup r8) {
        if (r8 == null) goto L22;
        r7.inflate(2131562714, r8);
        int r9 = 2131364451;
        View r2 = ViewBindings.findChildViewById(r8, 2131364451);
        if (r2 == null) goto L20;
        r9 = 2131370355;
        if (ViewBindings.findChildViewById(r8, 2131370355) == null) goto L20;
        r9 = 2131370356;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r8, 2131370356);
        if (r3 == null) goto L20;
        r9 = 2131370357;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r8, 2131370357);
        if (r4 == null) goto L20;
        r9 = 2131374727;
        if (ViewBindings.findChildViewById(r8, 2131374727) == null) goto L20;
        r9 = 2131390536;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r8, 2131390536);
        if (r5 == null) goto L20;
        r9 = 2131391380;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r8, 2131391380);
        if (r6 == null) goto L20;
        return new LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding(r8, r2, r3, r4, r5, r6);
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    L22:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding(View r1, View r2, ConstraintLayout r3, AppCompatTextView r4, AppCompatTextView r5, AppCompatTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
