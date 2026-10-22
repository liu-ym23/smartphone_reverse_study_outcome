package com.ss.android.lark.officesdk;

import android.view.View;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p implements ViewComponentBuilder {
    public final o a;
    public final g b;
    public final e c;
    public View d;

    public final ViewComponent build() {
        Preconditions.checkBuilderRequirement(this.d, View.class);
        return new q(this.a, this.b, this.c);
    }

    public final ViewComponentBuilder view(View r1) {
        this.d = (View) Preconditions.checkNotNull(r1);
        return this;
    }

    public p(o r1, g r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
