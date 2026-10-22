package com.ss.android.lark.officesdk;

import androidx.lifecycle.SavedStateHandle;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r implements ViewModelComponentBuilder {
    public final o a;
    public final g b;
    public SavedStateHandle c;

    public final ViewModelComponent build() {
        Preconditions.checkBuilderRequirement(this.c, SavedStateHandle.class);
        return new s(this.a, this.b, this.c);
    }

    public final ViewModelComponentBuilder savedStateHandle(SavedStateHandle r1) {
        this.c = (SavedStateHandle) Preconditions.checkNotNull(r1);
        return this;
    }

    public r(o r1, g r2) {
        this.a = r1;
        this.b = r2;
    }
}
