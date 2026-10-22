package com.obric.assistant.interaction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LayoutHelperBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainer;
    private final FragmentContainerView rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m0getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public FragmentContainerView m0getRoot() {
        return this.rootView;
    }

    public static LayoutHelperBinding bind(View r1) {
        if (r1 == null) goto L6;
        FragmentContainerView r2 = (FragmentContainerView) r1;
        return new LayoutHelperBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }

    public static LayoutHelperBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private LayoutHelperBinding(FragmentContainerView r1, FragmentContainerView r2) {
        this.rootView = r1;
        this.fragmentContainer = r2;
    }

    public static LayoutHelperBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131563332, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
