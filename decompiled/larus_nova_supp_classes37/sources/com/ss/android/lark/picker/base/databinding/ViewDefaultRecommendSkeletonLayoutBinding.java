package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewDefaultRecommendSkeletonLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3343getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m3343getRoot() {
        return this.rootView;
    }

    private ViewDefaultRecommendSkeletonLayoutBinding(LinearLayout r1) {
        this.rootView = r1;
    }

    public static ViewDefaultRecommendSkeletonLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new ViewDefaultRecommendSkeletonLayoutBinding((LinearLayout) r1);
    L6:
        throw new NullPointerException("rootView");
    }

    public static ViewDefaultRecommendSkeletonLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewDefaultRecommendSkeletonLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568155, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
