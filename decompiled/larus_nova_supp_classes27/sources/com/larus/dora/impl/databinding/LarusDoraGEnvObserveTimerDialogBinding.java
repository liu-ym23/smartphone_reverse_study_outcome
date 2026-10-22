package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGEnvObserveTimerDialogBinding implements ViewBinding {
    public final FrameLayout a;
    public final DoraTextView b;
    public final DoraTextView c;
    public final AppCompatTextView d;
    public final DoraTextView e;
    public final LinearLayout f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraGEnvObserveTimerDialogBinding a(LayoutInflater r8, ViewGroup r9) {
        View r10 = r8.inflate(2131562190, r9, false);
        int r11 = 2131369575;
        DoraTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369575);
        if (r3 == null) goto L15;
        r11 = 2131369576;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369576);
        if (r4 == null) goto L15;
        r11 = 2131369577;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r10, 2131369577);
        if (r5 == null) goto L15;
        r11 = 2131369578;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369578);
        if (r6 == null) goto L15;
        r11 = 2131388666;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131388666);
        if (r7 == null) goto L15;
        return new LarusDoraGEnvObserveTimerDialogBinding((FrameLayout) r10, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LarusDoraGEnvObserveTimerDialogBinding(FrameLayout r1, DoraTextView r2, DoraTextView r3, AppCompatTextView r4, DoraTextView r5, LinearLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
