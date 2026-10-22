package com.larus.bmhome.chat.mode;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ModeSwitchComponent$e implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ModeSwitchComponent b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        this.a.removeOnAttachStateChangeListener(this);
        if (this.b.Q != r2) goto L6;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        r3.addOnGlobalLayoutListener(this.b.V);
        this.b.R = r3;
        return;
    }

    public ModeSwitchComponent$e(ConstraintLayout r1, ModeSwitchComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
