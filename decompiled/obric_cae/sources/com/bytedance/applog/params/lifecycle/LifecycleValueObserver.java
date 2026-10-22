package com.bytedance.applog.params.lifecycle;

import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.m;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleValueObserver implements k {
    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        if (r10 == h.a.ON_DESTROY) goto L5;
        return;
    L5:
        c4.m.u().p(null, "params with lifecycle owner destroyed and onDestroy callback invoke start...", new Object[0]);
        throw null;
    }
}
