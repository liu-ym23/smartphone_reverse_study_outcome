package com.ss.android.lark.officesdk;

import androidx.fragment.app.Fragment;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements FragmentComponentBuilder {
    public final o a;
    public final g b;
    public final e c;
    public Fragment d;

    public final FragmentComponent build() {
        Preconditions.checkBuilderRequirement(this.d, Fragment.class);
        return new j(this.a, this.b, this.c);
    }

    public final FragmentComponentBuilder fragment(Fragment r1) {
        this.d = (Fragment) Preconditions.checkNotNull(r1);
        return this;
    }

    public i(o r1, g r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
