package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final LarusWidgetInputBinding a;
    public final int b;
    public final GradientMaskView c;
    public final ConstraintLayout.LayoutParams d;
    public final Rect e;
    public final int f;

    public final void a() {
        ViewTreeObserver r0 = this.a.a.getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r0.removeOnPreDrawListener(this);
    L8:
        ConstraintLayout.LayoutParams r1 = this.c.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r2 = r1;
        ConstraintLayout.LayoutParams r3 = this.d;
        r2.topToTop = r3.topToTop;
        r2.topToBottom = r3.topToBottom;
        r2.bottomToTop = r3.bottomToTop;
        r2.bottomToBottom = r3.bottomToBottom;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = ((ViewGroup.MarginLayoutParams) r3).topMargin;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = ((ViewGroup.MarginLayoutParams) r3).bottomMargin;
        this.c.setLayoutParams(r2);
        this.c.setClipBounds(this.e);
        this.c.setImportantForAccessibility(this.f);
    }

    public final boolean b() {
        ConstraintLayout.LayoutParams r0 = this.c.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = r0;
        int r2 = RangesKt.coerceAtLeast((this.a.I.getHeight() - this.a.H.getTop()) + this.b, 0) + ((ViewGroup.MarginLayoutParams) this.d).bottomMargin;
        if (r1.topToTop == (-1)) goto L5;
    L15:
        r1.topToTop = -1;
        r1.topToBottom = -1;
        r1.bottomToTop = -1;
        r1.bottomToBottom = this.a.I.getId();
        ((ViewGroup.MarginLayoutParams) r1).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = r2;
        this.c.setLayoutParams(r1);
        return true;
    L5:
        if (r1.topToBottom != (-1)) goto L15;
        if (r1.bottomToTop != (-1)) goto L15;
        if (r1.bottomToBottom != this.a.I.getId()) goto L15;
        if (((ViewGroup.MarginLayoutParams) r1).bottomMargin != r2) goto L15;
        if (((ViewGroup.MarginLayoutParams) r1).topMargin != 0) goto L15;
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (b() == false) goto L5;
        return false;
    L5:
        int r0 = RangesKt.coerceIn(this.a.I.getTop() - this.c.getTop(), 0, this.c.getHeight());
        this.c.setClipBounds(new Rect(0, 0, this.c.getWidth(), r0));
        GradientMaskView r1 = this.c;
        if (r0 != 0) goto L8;
        int r2 = 4;
    L9:
        r1.setImportantForAccessibility(r2);
        return true;
    L8:
        r2 = this.f;
        goto L9
    }

    public a(LarusWidgetInputBinding r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        this.a = r4;
        this.b = r5;
        GradientMaskView r6 = r4.e;
        this.c = r6;
        ConstraintLayout.LayoutParams r1 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.d = new ConstraintLayout.LayoutParams(r1);
        Rect r0 = r6.getClipBounds();
        if (r0 == null) goto L5;
        Rect r2 = new Rect(r0);
    L6:
        this.e = r2;
        this.f = r6.getImportantForAccessibility();
        b();
        r4.a.getViewTreeObserver().addOnPreDrawListener(this);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
