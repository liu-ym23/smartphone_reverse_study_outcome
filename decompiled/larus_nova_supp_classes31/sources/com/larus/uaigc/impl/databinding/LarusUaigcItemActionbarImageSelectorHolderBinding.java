package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusUaigcItemActionbarImageSelectorHolderBinding implements ViewBinding {
    public final FrameLayout a;

    public final View getRoot() {
        return this.a;
    }

    public LarusUaigcItemActionbarImageSelectorHolderBinding(FrameLayout r1) {
        this.a = r1;
    }

    public static LarusUaigcItemActionbarImageSelectorHolderBinding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131563191, r3, false);
        int r5 = 2131374767;
        if (ViewBindings.findChildViewById(r4, 2131374767) == null) goto L11;
        r5 = 2131375080;
        if (ViewBindings.findChildViewById(r4, 2131375080) == null) goto L11;
        r5 = 2131390830;
        if (((TextView) ViewBindings.findChildViewById(r4, 2131390830)) == null) goto L11;
        return new LarusUaigcItemActionbarImageSelectorHolderBinding((FrameLayout) r4);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }
}
