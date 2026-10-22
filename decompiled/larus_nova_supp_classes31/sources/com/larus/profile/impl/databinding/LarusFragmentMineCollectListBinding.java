package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentMineCollectListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusPageCollectListEmptyBinding b;
    public final LarusPageCollectErrorBinding c;
    public final RecyclerView d;
    public final LarusPageCollectLoadingSkeletonBinding e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentMineCollectListBinding(ConstraintLayout r1, LarusPageCollectListEmptyBinding r2, LarusPageCollectErrorBinding r3, RecyclerView r4, LarusPageCollectLoadingSkeletonBinding r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
