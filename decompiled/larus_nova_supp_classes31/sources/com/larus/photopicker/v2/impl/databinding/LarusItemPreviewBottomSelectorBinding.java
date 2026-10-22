package com.larus.photopicker.v2.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemPreviewBottomSelectorBinding implements ViewBinding {
    public final FrameLayout a;
    public final View b;
    public final View c;
    public final AppCompatTextView d;
    public final SimpleDraweeView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemPreviewBottomSelectorBinding a(LayoutInflater r6, ViewGroup r7) {
        View r8 = r6.inflate(2131562610, r7, false);
        int r9 = 2131375820;
        View r2 = ViewBindings.findChildViewById(r8, 2131375820);
        if (r2 == null) goto L15;
        r9 = 2131375821;
        if (ViewBindings.findChildViewById(r8, 2131375821) == null) goto L15;
        r9 = 2131375822;
        View r3 = ViewBindings.findChildViewById(r8, 2131375822);
        if (r3 == null) goto L15;
        r9 = 2131375823;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r8, 2131375823);
        if (r4 == null) goto L15;
        r9 = 2131375824;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r8, 2131375824);
        if (r5 == null) goto L15;
        return new LarusItemPreviewBottomSelectorBinding((FrameLayout) r8, r2, r3, r4, r5);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public LarusItemPreviewBottomSelectorBinding(FrameLayout r1, View r2, View r3, AppCompatTextView r4, SimpleDraweeView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
