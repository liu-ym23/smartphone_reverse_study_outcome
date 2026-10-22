package com.ss.android.lark.imageocr.select;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements View.OnAttachStateChangeListener {
    public final /* synthetic */ e a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public j(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        e r4 = this.a;
        r4.f.getViewTreeObserver().removeOnScrollChangedListener(r4.s);
        r4.f.getViewTreeObserver().removeOnPreDrawListener(r4.r);
        r4.b();
        r4.a = null;
        r4.b = null;
        r4.c = null;
    }
}
