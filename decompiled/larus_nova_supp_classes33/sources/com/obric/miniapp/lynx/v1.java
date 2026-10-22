package com.obric.miniapp.lynx;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ OBottomNavActionBar a;
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (this.a.getViewTreeObserver().isAlive() == false) goto L6;
        this.a.getViewTreeObserver().addOnPreDrawListener(this.b);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (this.a.getViewTreeObserver().isAlive() == false) goto L6;
        this.a.getViewTreeObserver().removeOnPreDrawListener(this.b);
        return;
    }

    public v1(OBottomNavActionBar r1, r1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
