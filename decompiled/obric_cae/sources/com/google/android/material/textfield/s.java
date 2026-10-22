package com.google.android.material.textfield;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.i0;
import j0.h0;
import j0.w;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class s extends androidx.appcompat.widget.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i0 f5109o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AccessibilityManager f5110p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f5111q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f5112r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f5113s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f5114t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5115u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f5116v;

    public class a<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ColorStateList f5117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorStateList f5118b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ s f5119m;

        public a(s r8, Context r10, int r11, String[] r12) {
            this.f5119m = r8;
            super(r10, r11, r12);
            b();
        }

        public final void b() {
            s r8 = this.f5119m;
            ColorStateList r10 = r8.f5116v;
            boolean r11 = true;
            if (r10 == null) goto L5;
            boolean r12 = true;
        L6:
            ColorStateList r13 = null;
            if (r12 == true) goto L9;
            ColorStateList r14 = null;
        L10:
            this.f5118b = r14;
            if (r8.f5115u == 0) goto L13;
            boolean r15 = true;
        L14:
            if (r15 == true) goto L16;
        L21:
            this.f5117a = r13;
            return;
        L16:
            if (r8.f5116v != null) goto L19;
            r11 = false;
        L19:
            if (r11 == false) goto L21;
            int[] r16 = {R.attr.state_hovered, -16842919};
            int[] r17 = {R.attr.state_selected, -16842919};
            int r18 = r8.f5116v.getColorForState(r17, 0);
            int r19 = r8.f5116v.getColorForState(r16, 0);
            r13 = new ColorStateList(new int[][]{r17, r16, new int[0]}, new int[]{a0.a.c(r18, r8.f5115u), a0.a.c(r19, r8.f5115u), r8.f5115u});
            goto L21
        L13:
            r15 = false;
            goto L14
        L9:
            int[] r20 = {R.attr.state_pressed};
            r14 = new ColorStateList(new int[][]{r20, new int[0]}, new int[]{r10.getColorForState(r20, 0), 0});
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int r8, View r10, ViewGroup r11) {
            View r12 = super.getView(r8, r10, r11);
            if ((r12 instanceof TextView) == false) goto L16;
            TextView r13 = (TextView) r12;
            s r14 = this.f5119m;
            Drawable r15 = null;
            if (r14.getText().toString().contentEquals(r13.getText()) == true) goto L7;
        L15:
            WeakHashMap<View, h0> r16 = w.f8437a;
            w.d.q(r13, r15);
            goto L16
        L7:
            if (r14.f5115u == 0) goto L9;
            boolean r17 = true;
        L10:
            if (r17 == false) goto L15;
            ColorDrawable r18 = new ColorDrawable(r14.f5115u);
            if (this.f5118b == null) goto L14;
            b0.a.b.h(r18, this.f5117a);
            r15 = new RippleDrawable(this.f5118b, r18, null);
            goto L15
        L14:
            r15 = r18;
            goto L15
        L9:
            r17 = false;
        L16:
            return r12;
        }
    }

    public s(Context r10, AttributeSet r11) {
        super(ea.a.a(r10, r11, com.obric.cae.R.attr.autoCompleteTextViewStyle, 0), r11, 0);
        this.f5111q = new Rect();
        Context r12 = getContext();
        TypedArray r13 = com.google.android.material.internal.l.d(r12, r11, g9.a.f7769j, com.obric.cae.R.attr.autoCompleteTextViewStyle, com.obric.cae.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (r13.hasValue(0) == true) goto L5;
    L7:
        this.f5112r = r13.getResourceId(3, com.obric.cae.R.layout.mtrl_auto_complete_simple_item);
        this.f5113s = r13.getDimensionPixelOffset(1, com.obric.cae.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (r13.hasValue(2) == false) goto L10;
        this.f5114t = ColorStateList.valueOf(r13.getColor(2, 0));
    L10:
        this.f5115u = r13.getColor(4, 0);
        this.f5116v = x9.c.a(r12, r13, 5);
        this.f5110p = (AccessibilityManager) r12.getSystemService("accessibility");
        i0 r8 = new i0(r12, null, com.obric.cae.R.attr.listPopupWindowStyle, 0);
        this.f5109o = r8;
        r8.I = true;
        androidx.appcompat.widget.p r14 = r8.J;
        r14.setFocusable(true);
        r8.f1184y = this;
        r14.setInputMethodMode(2);
        r8.setAdapter(getAdapter());
        r8.f1185z = new r(this);
        if (r13.hasValue(6) == false) goto L13;
        setSimpleItems(r13.getResourceId(6, 0));
    L13:
        r13.recycle();
        return;
    L5:
        if (r13.getInt(0, 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }

    public static /* synthetic */ i0 a(s r8) {
        return r8.f5109o;
    }

    public static void b(s r8, Object r10) {
        r8.setText(r8.convertSelectionToString(r10), false);
    }

    public final TextInputLayout c() {
        ViewParent r8 = getParent();
    L3:
        if (r8 == null) goto L9;
        if ((r8 instanceof TextInputLayout) == true) goto L7;
        r8 = r8.getParent();
        goto L3
    L7:
        return (TextInputLayout) r8;
    L9:
        return null;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        AccessibilityManager r8 = this.f5110p;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L10;
        this.f5109o.dismiss();
        return;
    L10:
        super.dismissDropDown();
        return;
    L5:
        if (r8.isTouchExplorationEnabled() == false) goto L7;
        r10 = true;
        goto L8
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f5114t;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout r8 = c();
        if (r8 == null) goto L9;
        if (r8.O == false) goto L9;
        return r8.getHint();
    L9:
        return super.getHint();
    }

    public float getPopupElevation() {
        return this.f5113s;
    }

    public int getSimpleItemSelectedColor() {
        return this.f5115u;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f5116v;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r8 = c();
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.O == true) goto L7;
        return;
    L7:
        if (super.getHint() != null) goto L18;
        String r10 = Build.MANUFACTURER;
        if (r10 == null) goto L11;
        String r11 = r10.toLowerCase(Locale.ENGLISH);
    L13:
        if (r11.equals("meizu") == false) goto L19;
        setHint("");
        return;
    L19:
        return;
    L11:
        r11 = "";
        goto L13
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5109o.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r14, int r15) {
        super.onMeasure(r14, r15);
        if (View.MeasureSpec.getMode(r14) != Integer.MIN_VALUE) goto L26;
        int r16 = getMeasuredWidth();
        ListAdapter r8 = getAdapter();
        TextInputLayout r10 = c();
        int r11 = 0;
        if (r8 == null) goto L21;
        if (r10 == null) goto L21;
        int r12 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        i0 r17 = this.f5109o;
        int r18 = Math.min(r8.getCount(), Math.max(0, r17.g()) + 15);
        int r19 = Math.max(0, r18 - 15);
        View r110 = null;
        int r20 = 0;
    L9:
        if (r19 >= r18) goto L17;
        int r111 = r8.getItemViewType(r19);
        if (r111 == r11) goto L13;
        r110 = null;
        r11 = r111;
    L13:
        r110 = r8.getView(r19, r110, r10);
        if (r110.getLayoutParams() != null) goto L16;
        r110.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L16:
        r110.measure(r12, r13);
        r20 = Math.max(r20, r110.getMeasuredWidth());
        r19 = r19 + 1;
        goto L9
    L17:
        Drawable r21 = r17.getBackground();
        if (r21 == null) goto L20;
        Rect r22 = this.f5111q;
        r21.getPadding(r22);
        r20 = r20 + (r22.left + r22.right);
    L20:
        r11 = r10.getEndIconView().getMeasuredWidth() + r20;
    L21:
        setMeasuredDimension(Math.min(Math.max(r16, r11), View.MeasureSpec.getSize(r14)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean r8) {
        AccessibilityManager r10 = this.f5110p;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        return;
    L10:
        super.onWindowFocusChanged(r8);
        return;
    L5:
        if (r10.isTouchExplorationEnabled() == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T r8) {
        super.setAdapter(r8);
        this.f5109o.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable r8) {
        super.setDropDownBackgroundDrawable(r8);
        i0 r10 = this.f5109o;
        if (r10 == null) goto L6;
        r10.setBackgroundDrawable(r8);
        return;
    }

    public void setDropDownBackgroundTint(int r8) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(r8));
    }

    public void setDropDownBackgroundTintList(ColorStateList r8) {
        this.f5114t = r8;
        Drawable r10 = getDropDownBackground();
        if ((r10 instanceof aa.f) == false) goto L6;
        ((aa.f) r10).k(this.f5114t);
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener r8) {
        super.setOnItemSelectedListener(r8);
        i0 r10 = this.f5109o;
        r10.A = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int r8) {
        super.setRawInputType(r8);
        TextInputLayout r10 = c();
        if (r10 == null) goto L6;
        r10.t();
        return;
    }

    public void setSimpleItemSelectedColor(int r8) {
        this.f5115u = r8;
        if ((getAdapter() instanceof a) == false) goto L6;
        ((a) getAdapter()).b();
        return;
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList r8) {
        this.f5116v = r8;
        if ((getAdapter() instanceof a) == false) goto L6;
        ((a) getAdapter()).b();
        return;
    }

    public void setSimpleItems(int r8) {
        setSimpleItems(getResources().getStringArray(r8));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager r8 = this.f5110p;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L10;
        this.f5109o.show();
        return;
    L10:
        super.showDropDown();
        return;
    L5:
        if (r8.isTouchExplorationEnabled() == false) goto L7;
        r10 = true;
        goto L8
    }

    public void setSimpleItems(String[] r8) {
        setAdapter(new a(this, getContext(), this.f5112r, r8));
    }
}
