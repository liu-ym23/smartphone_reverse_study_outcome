package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.y0;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends f implements androidx.appcompat.view.menu.k.a {
    public static final int[] Q = null;
    public int F;
    public boolean G;
    public boolean H;
    public final boolean I;
    public final CheckedTextView J;
    public FrameLayout K;
    public androidx.appcompat.view.menu.h L;
    public ColorStateList M;
    public boolean N;
    public Drawable O;
    public final a P;

    public class a extends j0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NavigationMenuItemView f4821d;

        public a(NavigationMenuItemView r8) {
            this.f4821d = r8;
        }

        @Override // j0.a
        public final void d(View r8, k0.f r10) {
            View.AccessibilityDelegate r11 = this.f8370a;
            AccessibilityNodeInfo r12 = r10.f8890a;
            r11.onInitializeAccessibilityNodeInfo(r8, r12);
            r12.setCheckable(this.f4821d.H);
        }
    }

    static {
        Q = new int[]{R.attr.state_checked};
    }

    public NavigationMenuItemView(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    private void setActionView(View r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.K != null) goto L6;
        this.K = (FrameLayout) ((ViewStub) findViewById(com.obric.cae.R.id.design_menu_item_action_area_stub)).inflate();
    L6:
        this.K.removeAllViews();
        this.K.addView(r8);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void c(androidx.appcompat.view.menu.h r8) {
        this.L = r8;
        int r10 = r8.f843a;
        if (r10 <= 0) goto L6;
        setId(r10);
    L6:
        if (r8.isVisible() == false) goto L8;
        int r11 = 0;
    L9:
        setVisibility(r11);
        boolean r12 = true;
        if (getBackground() != null) goto L16;
        TypedValue r13 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(com.obric.cae.R.attr.colorControlHighlight, r13, true) == false) goto L14;
        StateListDrawable r14 = new StateListDrawable();
        r14.addState(Q, new ColorDrawable(r13.data));
        r14.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
    L15:
        WeakHashMap<View, h0> r15 = w.f8437a;
        w.d.q(this, r14);
        goto L16
    L14:
        r14 = null;
    L16:
        setCheckable(r8.isCheckable());
        setChecked(r8.isChecked());
        setEnabled(r8.isEnabled());
        setTitle(r8.f847e);
        setIcon(r8.getIcon());
        setActionView(r8.getActionView());
        setContentDescription(r8.f859q);
        y0.a(this, r8.f860r);
        androidx.appcompat.view.menu.h r16 = this.L;
        if (r16.f847e == null) goto L19;
    L23:
        r12 = false;
    L24:
        CheckedTextView r17 = this.J;
        if (r12 == false) goto L29;
        r17.setVisibility(8);
        FrameLayout r18 = this.K;
        if (r18 == null) goto L34;
        LinearLayoutCompat.a r19 = (LinearLayoutCompat.a) r18.getLayoutParams();
        int r20 = -1;
    L32:
        ((LinearLayout.LayoutParams) r19).width = r20;
        this.K.setLayoutParams(r19);
        return;
    L34:
        return;
    L29:
        r17.setVisibility(0);
        FrameLayout r21 = this.K;
        if (r21 == null) goto L35;
        r19 = (LinearLayoutCompat.a) r21.getLayoutParams();
        r20 = -2;
        goto L32
    L35:
        return;
    L19:
        if (r16.getIcon() != null) goto L23;
        if (this.L.getActionView() == null) goto L23;
    L8:
        r11 = 8;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.h getItemData() {
        return this.L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 1);
        androidx.appcompat.view.menu.h r11 = this.L;
        if (r11 != null) goto L5;
    L9:
        return r10;
    L5:
        if (r11.isCheckable() == false) goto L9;
        if (this.L.isChecked() == false) goto L9;
        ViewGroup.mergeDrawableStates(r10, Q);
        goto L9
    }

    public void setCheckable(boolean r8) {
        refreshDrawableState();
        if (this.H == r8) goto L6;
        this.H = r8;
        CheckedTextView r10 = this.J;
        this.P.h(r10, 2048);
        return;
    }

    public void setChecked(boolean r8) {
        refreshDrawableState();
        CheckedTextView r10 = this.J;
        r10.setChecked(r8);
        Typeface r11 = r10.getTypeface();
        if (r8 == true) goto L5;
    L7:
        int r12 = 0;
    L8:
        r10.setTypeface(r11, r12);
        return;
    L5:
        if (this.I == false) goto L7;
        r12 = 1;
        goto L8
    }

    public void setHorizontalPadding(int r8) {
        setPadding(r8, getPaddingTop(), r8, getPaddingBottom());
    }

    public void setIcon(Drawable r8) {
        if (r8 == null) goto L13;
        if (this.N == false) goto L11;
        Drawable.ConstantState r10 = r8.getConstantState();
        if (r10 == null) goto L10;
        r8 = r10.newDrawable();
    L10:
        r8 = r8.mutate();
        b0.a.b.h(r8, this.M);
    L11:
        int r11 = this.F;
        r8.setBounds(0, 0, r11, r11);
    L20:
        androidx.core.widget.l.e(this.J, r8, null, null, null);
        return;
    L13:
        if (this.G == false) goto L20;
        if (this.O != null) goto L19;
        Resources r12 = getResources();
        Resources.Theme r13 = getContext().getTheme();
        ThreadLocal<TypedValue> r14 = z.f.f14146a;
        Drawable r15 = z.f.a.a(r12, com.obric.cae.R.drawable.navigation_empty_icon, r13);
        this.O = r15;
        if (r15 == null) goto L19;
        int r16 = this.F;
        r15.setBounds(0, 0, r16, r16);
    L19:
        r8 = this.O;
        goto L20
    }

    public void setIconPadding(int r8) {
        this.J.setCompoundDrawablePadding(r8);
    }

    public void setIconSize(int r8) {
        this.F = r8;
    }

    public void setIconTintList(ColorStateList r8) {
        this.M = r8;
        if (r8 == null) goto L5;
        boolean r10 = true;
    L6:
        this.N = r10;
        androidx.appcompat.view.menu.h r11 = this.L;
        if (r11 == null) goto L10;
        setIcon(r11.getIcon());
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void setMaxLines(int r8) {
        this.J.setMaxLines(r8);
    }

    public void setNeedsEmptyIcon(boolean r8) {
        this.G = r8;
    }

    public void setTextAppearance(int r8) {
        this.J.setTextAppearance(r8);
    }

    public void setTextColor(ColorStateList r8) {
        this.J.setTextColor(r8);
    }

    public void setTitle(CharSequence r8) {
        this.J.setText(r8);
    }

    public NavigationMenuItemView(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, 0);
        this.I = true;
        a r12 = new a(this);
        this.P = r12;
        setOrientation(0);
        LayoutInflater.from(r8).inflate(com.obric.cae.R.layout.design_navigation_menu_item, this, true);
        setIconSize(r8.getResources().getDimensionPixelSize(com.obric.cae.R.dimen.design_navigation_icon_size));
        CheckedTextView r13 = (CheckedTextView) findViewById(com.obric.cae.R.id.design_menu_item_text);
        this.J = r13;
        r13.setDuplicateParentStateEnabled(true);
        w.m(r13, r12);
    }
}
