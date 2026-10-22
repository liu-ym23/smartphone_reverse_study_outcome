package com.larus.profile.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusProfileInfoViewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ViewStub b;
    public final RecyclerView c;
    public final LarusPageProfileInfoSkeletonBinding d;

    public final View getRoot() {
        return this.a;
    }

    public LarusProfileInfoViewBinding(ConstraintLayout r1, ViewStub r2, RecyclerView r3, LarusPageProfileInfoSkeletonBinding r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
