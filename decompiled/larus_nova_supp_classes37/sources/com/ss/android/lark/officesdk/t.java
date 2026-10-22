package com.ss.android.lark.officesdk;

import android.view.View;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t implements ViewWithFragmentComponentBuilder {
    public View a;

    public final ViewWithFragmentComponent build() {
        Preconditions.checkBuilderRequirement(this.a, View.class);
        return new u();
    }

    public final ViewWithFragmentComponentBuilder view(View r1) {
        this.a = (View) Preconditions.checkNotNull(r1);
        return this;
    }

    public t(o r1, g r2, e r3, j r4) {
    }
}
