package com.ss.android.lark.officesdk;

import android.app.Activity;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements ActivityComponentBuilder {
    public final o a;
    public final g b;
    public Activity c;

    public final ActivityComponent build() {
        Preconditions.checkBuilderRequirement(this.c, Activity.class);
        return new e(this.a, this.b);
    }

    public final ActivityComponentBuilder activity(Activity r1) {
        this.c = (Activity) Preconditions.checkNotNull(r1);
        return this;
    }

    public d(o r1, g r2) {
        this.a = r1;
        this.b = r2;
    }
}
