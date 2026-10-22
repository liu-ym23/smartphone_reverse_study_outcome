package com.obric.miniapp.lynx;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x3 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ LynxOUISearchBarUI a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public x3(LynxOUISearchBarUI r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        LynxOUISearchBarUI r3 = this.a;
        if (r3.f == false) goto L6;
        r3.M();
        return;
    }
}
