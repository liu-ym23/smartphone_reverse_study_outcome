package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.view.ViewGroup;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ TitleTetris a;

    public a(TitleTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        TitleTetris r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        if (d90.c.i((d90.a) r0.K()) == true) goto L5;
        return;
    L5:
        if (r0.F == false) goto L22;
        Disposable r1 = r0.D;
        if (r1 == null) goto L14;
        if (r1.isDisposed() == true) goto L14;
        Disposable r2 = r0.D;
        if (r2 == null) goto L14;
        r2.dispose();
    L14:
        if (r4 == false) goto L19;
        ViewGroup r5 = r0.Z();
        if (r5 == null) goto L18;
        r5.setVisibility(0);
    L18:
        r0.l0(true);
        return;
    L19:
        r0.l0(false);
        return;
    }
}
