package com.google.android.material.internal;

import android.view.View;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class p implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r8) {
        r8.removeOnAttachStateChangeListener(this);
        WeakHashMap<View, h0> r10 = w.f8437a;
        w.h.c(r8);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r8) {
    }
}
