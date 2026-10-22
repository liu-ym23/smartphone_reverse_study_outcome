package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGuideBindDeviceDialogBinding implements ViewBinding {
    public final FrameLayout a;
    public final SimpleDraweeView b;
    public final ImageView c;
    public final DoraTextView d;
    public final DoraTextView e;
    public final DoraTextView f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraGuideBindDeviceDialogBinding a(LayoutInflater r8, ViewGroup r9) {
        View r10 = r8.inflate(2131562204, r9, false);
        int r11 = 2131369629;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r10, 2131369629);
        if (r3 == null) goto L15;
        r11 = 2131369630;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, 2131369630);
        if (r4 == null) goto L15;
        r11 = 2131369631;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369631);
        if (r5 == null) goto L15;
        r11 = 2131369632;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369632);
        if (r6 == null) goto L15;
        r11 = 2131369633;
        DoraTextView r7 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369633);
        if (r7 == null) goto L15;
        return new LarusDoraGuideBindDeviceDialogBinding((FrameLayout) r10, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LarusDoraGuideBindDeviceDialogBinding(FrameLayout r1, SimpleDraweeView r2, ImageView r3, DoraTextView r4, DoraTextView r5, DoraTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
