package com.larus.avlink.simulInterpret.page.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x implements View.OnLayoutChangeListener {
    public final /* synthetic */ TitleView a;
    public final /* synthetic */ boolean b;

    public x(TitleView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        ConstraintLayout.LayoutParams r10 = this.a.a.e.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r11 = r10;
        if (this.b == false) goto L5;
        r11.setMarginStart(this.a.a.d.getLeft());
        ((ViewGroup.MarginLayoutParams) r11).width = this.a.a.d.getWidth();
    L6:
        this.a.a.e.setLayoutParams(r11);
        return;
    L5:
        r11.setMarginStart(this.a.a.c.getLeft());
        ((ViewGroup.MarginLayoutParams) r11).width = this.a.a.c.getWidth();
        goto L6
    }
}
