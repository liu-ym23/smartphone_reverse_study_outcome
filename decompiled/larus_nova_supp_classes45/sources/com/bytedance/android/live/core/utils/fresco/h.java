package com.bytedance.android.live.core.utils.fresco;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    public final View a;
    public final View.OnAttachStateChangeListener b;
    public boolean c;
    public boolean d;

    private void update() {
        if (this.c == false) goto L11;
        View r0 = this.a;
    L5:
        Object r1 = r0.getParent();
        if ((r1 instanceof View) == false) goto L8;
        r0 = (View) r1;
        goto L5
    L8:
        if (r0 != this.a.getRootView()) goto L11;
        boolean r2 = true;
    L13:
        if (this.d == r2) goto L20;
        this.d = r2;
        if (r2 == false) goto L17;
        this.b.onViewAttachedToWindow(this.a);
        return;
    L17:
        this.b.onViewDetachedFromWindow(this.a);
        return;
    L20:
        return;
    L11:
        r2 = false;
        goto L13
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        update();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        this.a.getViewTreeObserver().addOnPreDrawListener(this);
        update();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        if (this.c == true) goto L5;
        return;
    L5:
        this.c = false;
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        update();
    }

    public h(View r2, FrescoLoader.b r3) {
        this.a = r2;
        this.b = r3;
        boolean r4 = r2.isAttachedToWindow();
        this.c = r4;
        this.d = false;
        if (r4 == false) goto L5;
        r2.getViewTreeObserver().addOnPreDrawListener(this);
    L5:
        r2.addOnAttachStateChangeListener(this);
        update();
    }
}
