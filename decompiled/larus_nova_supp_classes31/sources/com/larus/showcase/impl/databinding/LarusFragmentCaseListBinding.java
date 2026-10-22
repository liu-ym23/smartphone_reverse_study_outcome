package com.larus.showcase.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentCaseListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final LarusPageCaseErrorBinding c;
    public final RecyclerView d;
    public final LarusPageCaseLoadingSkeletonBinding e;
    public final AppCompatTextView f;
    public final ConstraintLayout g;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentCaseListBinding(ConstraintLayout r1, ImageView r2, LarusPageCaseErrorBinding r3, RecyclerView r4, LarusPageCaseLoadingSkeletonBinding r5, AppCompatTextView r6, ConstraintLayout r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
