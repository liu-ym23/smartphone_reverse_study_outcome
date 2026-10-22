package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIBadgeView extends View {
    public final a a;

    public final void a() {
        a r0 = this.a;
        boolean r2 = true;
        if (r0.h == false) goto L9;
        r0.a();
        if (r0.getCallback() == null) goto L7;
        r0.getCallback().invalidateDrawable(r0);
    L7:
        r0.h = false;
        r0.i = false;
    L12:
        if (r2 == false) goto L14;
        requestLayout();
        return;
    L14:
        invalidate();
        return;
    L9:
        if (r0.i == false) goto L11;
        r0.i = false;
        r0.invalidateSelf();
        goto L12
    L11:
        r2 = false;
        goto L12
    }

    public LKUIBadgeView(Context r2) {
        this(r2, null);
    }

    public final void b(int r3) {
        if (r3 != 0) goto L4;
        Drawable r4 = null;
    L5:
        a r0 = this.a;
        if (r0.c == r4) goto L9;
        r0.c = r4;
        r0.h = true;
        return;
    L9:
        return;
    L4:
        r4 = AppCompatResources.getDrawable(getContext(), r3);
        goto L5
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        super.onDraw(r4);
        r4.translate((getWidth() - this.a.j) / 2, (getHeight() - this.a.k) / 2);
        this.a.draw(r4);
    }

    public LKUIBadgeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        setMeasuredDimension(Math.max(this.a.j, getMinimumWidth()), Math.max(this.a.k, getMeasuredHeight()));
    }

    public LKUIBadgeView(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        TypedArray r9 = r6.obtainStyledAttributes(r7, new int[]{2130968911, 2130968913, 2130968915, 2130968916, 2130974495, 2130974525, 2130974542}, r8, 0);
        Drawable r10 = r9.getDrawable(0);
        r9.getDimensionPixelSize(3, 0);
        Drawable r0 = r9.getDrawable(1);
        int r1 = r9.getDimensionPixelSize(2, 0);
        int r2 = r9.getColor(5, -1);
        int r3 = r9.getDimensionPixelSize(6, (int) j08.b.a(r6, 12.0f));
        CharSequence r4 = r9.getText(4);
        r9.recycle();
        a.C0035a r11 = new a.C0035a(r6);
        r11.c = r10;
        r11.e = r0;
        r11.f = r1;
        r11.a = r4;
        r11.d = r2;
        r11.b = r3;
        this.a = new a(r11);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        a r6 = this.a;
        r6.setBounds(0, 0, r6.j, r6.k);
    }
}
