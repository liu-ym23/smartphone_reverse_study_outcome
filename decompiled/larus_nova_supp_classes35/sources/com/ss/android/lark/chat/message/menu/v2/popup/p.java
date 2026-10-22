package com.ss.android.lark.chat.message.menu.v2.popup;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ PopupMenuRootView b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r9) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.e.setAlpha(0.0f);
        this.b.e.animate().alpha(1.0f).setDuration(200).start();
        PopupMenuRootView r10 = this.b;
        int r4 = r10.getChildCount();
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L8;
        View r6 = r10.getChildAt(r5);
        if (Intrinsics.areEqual(r6, this.b.e) == true) goto L7;
        r6.setAlpha(0.0f);
        r6.setScaleX(0.98f);
        r6.setScaleY(0.98f);
        r6.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
    L7:
        r5 = r5 + 1;
        goto L3
    }

    public p(PopupMenuRootView r1, PopupMenuRootView r2) {
        this.a = r1;
        this.b = r2;
    }
}
