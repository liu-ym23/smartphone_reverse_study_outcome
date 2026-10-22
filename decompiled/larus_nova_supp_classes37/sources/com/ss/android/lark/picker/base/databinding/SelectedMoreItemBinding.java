package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.picker.base.view.AvatarItemViewWithMask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SelectedMoreItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final AvatarItemViewWithMask selectedItem;
    public final FrameLayout selectedRemove;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3341getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3341getRoot() {
        return this.rootView;
    }

    public static SelectedMoreItemBinding bind(View r3) {
        int r0 = 2131385841;
        AvatarItemViewWithMask r1 = (AvatarItemViewWithMask) ViewBindings.findChildViewById(r3, 2131385841);
        if (r1 == null) goto L9;
        r0 = 2131385848;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r3, 2131385848);
        if (r2 == null) goto L9;
        return new SelectedMoreItemBinding((ConstraintLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static SelectedMoreItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private SelectedMoreItemBinding(ConstraintLayout r1, AvatarItemViewWithMask r2, FrameLayout r3) {
        this.rootView = r1;
        this.selectedItem = r2;
        this.selectedRemove = r3;
    }

    public static SelectedMoreItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131564505, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
