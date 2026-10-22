package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.oui.layout.OUIFrameLayout;
import he.i;
import wb.a;
import xd.j;
import zc.b;

/* JADX INFO: loaded from: classes2.dex */
public final class OButtonGroup extends a {
    public LinearLayout A;
    public final int B;
    public final int C;
    public final int D;
    public View E;
    public boolean F;

    public OButtonGroup(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0, 8);
        float r11 = 0;
        this.B = android.aimedia.a.a("Resources.getSystem()", 1, r11);
        this.C = android.aimedia.a.a("Resources.getSystem()", 1, r11);
        this.D = 5;
        TypedArray r12 = r8.obtainStyledAttributes(r10, nb.a.f9490d);
        i.e(r12, "context.obtainStyledAttr…R.styleable.OButtonGroup)");
        this.C = r12.getDimensionPixelSize(3, 0);
        this.B = r12.getDimensionPixelSize(2, 0);
        this.D = r12.getDimensionPixelSize(1, 5);
        r12.recycle();
    }

    @Override // wb.a, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        boolean r10 = false;
        if (getItemCount() != 1) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = super.dispatchTouchEvent(r8);
        if (r11 == false) goto L27;
        int r13 = r8.getActionMasked();
        if (r13 == 0) goto L26;
        if (r13 != 1) goto L12;
    L25:
        getContentView().setPressed(r10);
        goto L27
    L12:
        if (r13 != 2) goto L14;
        float r14 = 0;
        if (r8.getX() < r14) goto L25;
        if (r8.getX() >= getWidth()) goto L25;
        if (r8.getY() < r14) goto L25;
        if (r8.getY() >= getHeight()) goto L25;
        r10 = true;
        goto L25
    L14:
        if (r13 == 3) goto L25;
    L26:
        getContentView().setPressed(true);
    L27:
        return r12;
    L5:
        r11 = false;
        goto L6
    }

    public final int getItemCount() {
        LinearLayout r8 = this.A;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.getChildCount();
    }

    @Override // wb.a
    public final void i(Context r8, OUIFrameLayout r10, TypedArray r11) {
        i.f(r8, "context");
        i.f(r10, "contentView");
        r10.removeAllViews();
        int r12 = 0;
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r13 = new LinearLayout(r8);
        r13.setOrientation(0);
        r13.setGravity(17);
        j r14 = j.f13877a;
        this.A = r13;
        r10.addView(r13);
        int r15 = this.C;
        setWidthMin(r15);
        getContentView().setWidthMin(r15);
        l();
        if (getItemCount() != 0) goto L5;
        r12 = 8;
    L5:
        setVisibility(r12);
    }

    public final void k(OUIFrameLayout r8, ViewGroup.MarginLayoutParams r10) {
        LinearLayout r11 = this.A;
        if (r11 != null) goto L6;
        b.b("OButtonGroup", "itemContainer is null");
        return;
    L6:
        int r12 = r11.getChildCount();
        int r13 = this.D;
        if (r12 < r13) goto L10;
        b.h("OButtonGroup", "itemContainer is full, capacity: " + r13);
        return;
    L10:
        LinearLayout r14 = this.A;
        i.c(r14);
        int r15 = r14.getChildCount();
        LinearLayout r16 = this.A;
        i.c(r16);
        int r17 = 0;
        if (r16.getChildCount() <= 0) goto L21;
        int r18 = this.B;
        if (r15 <= 0) goto L15;
        r10.setMarginStart(r18);
    L22:
        LinearLayout r19 = this.A;
        i.c(r19);
        r19.addView(r8, r15, r10);
        l();
        if (getItemCount() != 0) goto L25;
        r17 = 8;
    L25:
        setVisibility(r17);
        return;
    L15:
        r10.setMarginStart(0);
        LinearLayout r20 = this.A;
        i.c(r20);
        View r21 = r20.getChildAt(0);
        i.e(r21, "oldFirst");
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r22 = null;
    L18:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 == null) goto L22;
        r23.setMarginStart(r18);
        r21.setLayoutParams(r23);
        goto L22
    L21:
        r10.setMarginStart(0);
        goto L22
    }

    public final void l() {
        LinearLayout r8 = this.A;
        if (r8 == null) goto L37;
        Object r10 = null;
        if (r8.getChildCount() != 1) goto L25;
        View r11 = r8.getChildAt(0);
        KeyEvent.Callback r12 = this.E;
        if (r12 == r11) goto L18;
        if (r12 != null) goto L10;
    L17:
        this.F = false;
        this.E = r11;
        goto L18
    L10:
        if (this.F == false) goto L17;
        if ((r12 instanceof ac.a) == true) goto L14;
        r12 = null;
    L14:
        ac.a r13 = (ac.a) r12;
        if (r13 == null) goto L17;
        r13.setChangeAlphaWhenPress(true);
    L18:
        i.e(r11, "only");
        if ((r11 instanceof ac.a) == false) goto L22;
        r10 = r11;
    L22:
        ac.a r14 = (ac.a) r10;
        if (r14 == null) goto L38;
        r14.setChangeAlphaWhenPress(false);
        this.F = true;
        return;
    L38:
        return;
    L25:
        KeyEvent.Callback r15 = this.E;
        if (r15 != null) goto L28;
    L35:
        this.E = null;
        this.F = false;
        return;
    L28:
        if (this.F == false) goto L35;
        if ((r15 instanceof ac.a) == true) goto L32;
        r15 = null;
    L32:
        ac.a r16 = (ac.a) r15;
        if (r16 == null) goto L35;
        r16.setChangeAlphaWhenPress(true);
        goto L35
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, ac.b
    public void setWidthMin(int r8) {
        getLayoutHelper().setWidthMin(r8);
    }
}
