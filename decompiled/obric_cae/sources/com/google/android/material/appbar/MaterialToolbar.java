package com.google.android.material.appbar;

import aa.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f4310j0 = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Integer f4311e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f4312f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f4313g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public ImageView.ScaleType f4314h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Boolean f4315i0;

    static {
        f4310j0 = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public MaterialToolbar(Context r8, AttributeSet r10) {
        super(ea.a.a(r8, r10, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), r10, 0);
        Context r11 = getContext();
        TypedArray r12 = l.d(r11, r10, g9.a.f7779t, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (r12.hasValue(2) == false) goto L5;
        setNavigationIconTint(r12.getColor(2, -1));
    L5:
        this.f4312f0 = r12.getBoolean(4, false);
        this.f4313g0 = r12.getBoolean(3, false);
        int r13 = r12.getInt(1, -1);
        if (r13 < 0) goto L11;
        ImageView.ScaleType[] r14 = f4310j0;
        if (r13 >= r14.length) goto L11;
        this.f4314h0 = r14[r13];
    L11:
        if (r12.hasValue(0) == false) goto L13;
        this.f4315i0 = Boolean.valueOf(r12.getBoolean(0, false));
    L13:
        r12.recycle();
        Drawable r15 = getBackground();
        if (r15 != null) goto L16;
        ColorStateList r16 = ColorStateList.valueOf(0);
    L17:
        if (r16 == null) goto L20;
        f r17 = new f();
        r17.k(r16);
        r17.i(r11);
        WeakHashMap<View, h0> r18 = w.f8437a;
        r17.j(w.i.i(this));
        w.d.q(this, r17);
        return;
    L20:
        return;
    L16:
        r16 = r9.a.a(r15);
        goto L17
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f4314h0;
    }

    public Integer getNavigationIconTint() {
        return this.f4311e0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void k(int r8) {
        Menu r10 = getMenu();
        boolean r11 = r10 instanceof androidx.appcompat.view.menu.f;
        if (r11 == false) goto L5;
        ((androidx.appcompat.view.menu.f) r10).y();
    L5:
        super.k(r8);
        if (r11 == false) goto L9;
        ((androidx.appcompat.view.menu.f) r10).x();
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r8 = getBackground();
        if ((r8 instanceof f) == false) goto L6;
        defpackage.c.i0(this, (f) r8);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        int r14 = 0;
        ImageView r15 = null;
        if (this.f4312f0 == false) goto L5;
    L7:
        ArrayList r16 = m.b(this, getTitle());
        boolean r17 = r16.isEmpty();
        m.a r18 = m.f4888a;
        if (r17 == false) goto L10;
        TextView r19 = null;
    L11:
        ArrayList r110 = m.b(this, getSubtitle());
        if (r110.isEmpty() == false) goto L14;
        TextView r111 = null;
    L15:
        if (r19 != null) goto L18;
        if (r111 != null) goto L18;
    L44:
        Drawable r20 = getLogo();
        if (r20 != null) goto L48;
    L59:
        if (r15 == null) goto L80;
        Boolean r21 = this.f4315i0;
        if (r21 == null) goto L63;
        r15.setAdjustViewBounds(r21.booleanValue());
    L63:
        ImageView.ScaleType r22 = this.f4314h0;
        if (r22 == null) goto L81;
        r15.setScaleType(r22);
        return;
    L81:
        return;
    L80:
        return;
    L48:
        if (r14 >= getChildCount()) goto L59;
        View r112 = getChildAt(r14);
        if ((r112 instanceof ImageView) == false) goto L58;
        ImageView r113 = (ImageView) r112;
        Drawable r114 = r113.getDrawable();
        if (r114 == null) goto L58;
        if (r114.getConstantState() == null) goto L58;
        if (r114.getConstantState().equals(r20.getConstantState()) == false) goto L58;
        r15 = r113;
    L58:
        r14 = r14 + 1;
    L18:
        int r115 = getMeasuredWidth();
        int r23 = r115 / 2;
        int r24 = getPaddingLeft();
        int r116 = r115 - getPaddingRight();
        int r25 = 0;
    L20:
        if (r25 >= getChildCount()) goto L36;
        View r26 = getChildAt(r25);
        if (r26.getVisibility() == 8) goto L35;
        if (r26 == r19) goto L35;
        if (r26 == r111) goto L35;
        if (r26.getRight() >= r23) goto L31;
        if (r26.getRight() <= r24) goto L31;
        r24 = r26.getRight();
    L31:
        if (r26.getLeft() <= r23) goto L35;
        if (r26.getLeft() >= r116) goto L35;
        r116 = r26.getLeft();
    L35:
        r25 = r25 + 1;
        goto L20
    L36:
        Pair r27 = new Pair(Integer.valueOf(r24), Integer.valueOf(r116));
        if (this.f4312f0 == false) goto L41;
        if (r19 == null) goto L41;
        t(r19, r27);
    L41:
        if (this.f4313g0 == false) goto L44;
        if (r111 == null) goto L44;
        t(r111, r27);
        goto L44
    L14:
        r111 = (TextView) Collections.max(r110, r18);
        goto L15
    L10:
        r19 = (TextView) Collections.min(r16, r18);
        goto L11
    L5:
        if (this.f4313g0 == true) goto L7;
        goto L7
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        Drawable r10 = getBackground();
        if ((r10 instanceof f) == false) goto L6;
        ((f) r10).j(r8);
        return;
    }

    public void setLogoAdjustViewBounds(boolean r8) {
        Boolean r10 = this.f4315i0;
        if (r10 != null) goto L5;
    L6:
        this.f4315i0 = Boolean.valueOf(r8);
        requestLayout();
        return;
    L5:
        if (r10.booleanValue() != r8) goto L6;
    }

    public void setLogoScaleType(ImageView.ScaleType r8) {
        if (this.f4314h0 == r8) goto L6;
        this.f4314h0 = r8;
        requestLayout();
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r8) {
        if (r8 != null) goto L4;
    L6:
        super.setNavigationIcon(r8);
        return;
    L4:
        if (this.f4311e0 == null) goto L6;
        r8 = r8.mutate();
        b0.a.b.g(r8, this.f4311e0.intValue());
        goto L6
    }

    public void setNavigationIconTint(int r8) {
        this.f4311e0 = Integer.valueOf(r8);
        Drawable r10 = getNavigationIcon();
        if (r10 == null) goto L6;
        setNavigationIcon(r10);
        return;
    }

    public void setSubtitleCentered(boolean r8) {
        if (this.f4313g0 == r8) goto L6;
        this.f4313g0 = r8;
        requestLayout();
        return;
    }

    public void setTitleCentered(boolean r8) {
        if (this.f4312f0 == r8) goto L6;
        this.f4312f0 = r8;
        requestLayout();
        return;
    }

    public final void t(TextView r8, Pair r10) {
        int r11 = getMeasuredWidth();
        int r12 = r8.getMeasuredWidth();
        int r13 = (r11 / 2) - (r12 / 2);
        int r14 = r12 + r13;
        int r15 = Math.max(Math.max(((Integer) r10.first).intValue() - r13, 0), Math.max(r14 - ((Integer) r10.second).intValue(), 0));
        if (r15 <= 0) goto L5;
        r13 = r13 + r15;
        r14 = r14 - r15;
        r8.measure(View.MeasureSpec.makeMeasureSpec(r14 - r13, 1073741824), r8.getMeasuredHeightAndState());
    L5:
        r8.layout(r13, r8.getTop(), r14, r8.getBottom());
    }
}
