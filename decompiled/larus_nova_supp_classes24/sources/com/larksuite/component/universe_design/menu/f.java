package com.larksuite.component.universe_design.menu;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements View.OnAttachStateChangeListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ View b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.c(this.b);
        this.b.removeOnAttachStateChangeListener(this);
    }

    public f(c r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
