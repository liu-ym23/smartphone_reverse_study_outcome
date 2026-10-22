package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import hr.f;
import hr.l;
import java.util.Arrays;
import java.util.HashMap;
import lr.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f12984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f12986c;
    public l d;
    public boolean e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f12987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f12988i;

    public ConstraintHelper(Context r5) {
        super(r5);
        this.f12984a = new int[32];
        this.e = false;
        this.f12987h = null;
        this.f12988i = new HashMap();
        this.f12986c = r5;
        k(null);
    }

    public final void b(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() != 0) goto L7;
        return;
    L7:
        if (this.f12986c != null) goto L9;
        return;
    L9:
        String r10 = r5.trim();
        int r11 = i(r10);
        if (r11 == 0) goto L12;
        this.f12988i.put(Integer.valueOf(r11), r10);
        c(r11);
        return;
    L12:
        Log.w("ConstraintHelper", "Could not find id of \"" + r10 + "\"");
    }

    public final void c(int r5) {
        if (r5 != getId()) goto L5;
        return;
    L5:
        int r10 = this.f12985b + 1;
        int[] r11 = this.f12984a;
        if (r10 <= r11.length) goto L8;
        this.f12984a = Arrays.copyOf(r11, r11.length * 2);
    L8:
        int[] r12 = this.f12984a;
        int r13 = this.f12985b;
        r12[r13] = r5;
        this.f12985b = r13 + 1;
    }

    public final void d(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f12986c != null) goto L9;
        return;
    L9:
        String r11 = r10.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r5 = (ConstraintLayout) getParent();
    L14:
        if (r5 != null) goto L17;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L17:
        int r12 = r5.getChildCount();
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L35;
        View r14 = r5.getChildAt(r13);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        if (r11.equals(((ConstraintLayout.LayoutParams) r15).Y) == false) goto L27;
        if (r14.getId() != (-1)) goto L26;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r14.getClass().getSimpleName() + " must have an ID");
        goto L27
    L26:
        c(r14.getId());
    L27:
        r13 = r13 + 1;
        goto L18
    L35:
        return;
    L12:
        r5 = null;
        goto L14
    }

    public final void e() {
        ViewParent r5 = getParent();
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof ConstraintLayout) == false) goto L9;
        f((ConstraintLayout) r5);
        return;
    }

    public final void f(ConstraintLayout r10) {
        int r5 = getVisibility();
        float r11 = getElevation();
        int r12 = 0;
    L4:
        if (r12 >= this.f12985b) goto L11;
        View r13 = r10.e(this.f12984a[r12]);
        if (r13 == null) goto L10;
        r13.setVisibility(r5);
        if (r11 <= 0.0f) goto L10;
        r13.setTranslationZ(r13.getTranslationZ() + r11);
    L10:
        r12 = r12 + 1;
        goto L4
    }

    public void g(ConstraintLayout r5) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f12984a, this.f12985b);
    }

    public final int h(ConstraintLayout r10, String r11) {
        if (r11 == null) goto L21;
        if (r10 == null) goto L21;
        Resources r12 = this.f12986c.getResources();
        if (r12 != null) goto L9;
        return 0;
    L9:
        int r5 = r10.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r5) goto L21;
        View r14 = r10.getChildAt(r13);
        if (r14.getId() == (-1)) goto L20;
        String r15 = r12.getResourceEntryName(r14.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r11.equals(r15) == false) goto L20;
        return r14.getId();
    L15:
        r15 = null;
    L20:
        r13 = r13 + 1;
    L21:
        return 0;
    }

    public final int i(String r5) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r10 = (ConstraintLayout) getParent();
    L7:
        if (isInEditMode() == false) goto L19;
        if (r10 == null) goto L19;
        if (r5 == null) goto L15;
        HashMap r11 = r10.f12998m;
        if (r11 == null) goto L15;
        if (r11.containsKey(r5) == false) goto L15;
        Object r12 = r10.f12998m.get(r5);
    L17:
        if ((r12 instanceof Integer) == false) goto L19;
        int r13 = ((Integer) r12).intValue();
    L20:
        if (r13 != 0) goto L23;
        if (r10 == null) goto L23;
        r13 = h(r10, r5);
    L23:
        if (r13 == 0) goto L29;
    L25:
        if (r13 != 0) goto L31;
        Context r14 = this.f12986c;
        return r14.getResources().getIdentifier(r5, "id", r14.getPackageName());
    L31:
        return r13;
    L29:
        r13 = R$id.class.getField(r5).getInt(null);     // Catch: Exception -> L28
    L15:
        r12 = null;
    L19:
        r13 = 0;
        goto L20
    L5:
        r10 = null;
        goto L7
    }

    public final View[] j(ConstraintLayout r5) {
        View[] r10 = this.f12987h;
        if (r10 != null) goto L5;
    L6:
        this.f12987h = new View[this.f12985b];
    L7:
        int r11 = 0;
    L9:
        if (r11 >= this.f12985b) goto L12;
        int r12 = this.f12984a[r11];
        this.f12987h[r11] = r5.e(r12);
        r11 = r11 + 1;
        goto L9
    L12:
        return this.f12987h;
    L5:
        if (r10.length == this.f12985b) goto L7;
        goto L6
    }

    public void k(AttributeSet r5) {
        if (r5 == null) goto L18;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R$styleable.ConstraintLayout_Layout);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L12;
        int r13 = r10.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) goto L9;
        String r14 = r10.getString(r13);
        this.f = r14;
        setIds(r14);
    L11:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r13 != R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r15 = r10.getString(r13);
        this.g = r15;
        setReferenceTags(r15);
        goto L11
    L12:
        r10.recycle();
        return;
    }

    public void l(c r10, l r11, Constraints.LayoutParams r12, SparseArray r13) {
        g r14 = r10.e;
        int[] r15 = r14.f19728j0;
        int r5 = 0;
        if (r15 == null) goto L5;
        setReferencedIds(r15);
    L21:
        r11.f17463v0 = 0;
        Arrays.fill(r11.f17462u0, null);
        if (r14.f19728j0 == null) goto L29;
    L23:
        int[] r16 = r14.f19728j0;
        if (r5 >= r16.length) goto L36;
        f r17 = (f) r13.get(r16[r5]);
        if (r17 == null) goto L28;
        r11.S(r17);
    L28:
        r5 = r5 + 1;
        goto L23
    L36:
        return;
    L29:
        return;
    L5:
        String r18 = r14.f19730k0;
        if (r18 == null) goto L21;
        if (r18.length() <= 0) goto L20;
        String[] r19 = r14.f19730k0.split(",");
        int[] r20 = new int[r19.length];
        int r21 = 0;
        int r22 = 0;
    L11:
        if (r21 >= r19.length) goto L17;
        int r23 = i(r19[r21].trim());
        if (r23 == 0) goto L15;
        r20[r22] = r23;
        r22 = r22 + 1;
    L15:
        r21 = r21 + 1;
        goto L11
    L17:
        if (r22 == r19.length) goto L19;
        r20 = Arrays.copyOf(r20, r22);
    L19:
        r14.f19728j0 = r20;
        goto L21
    L20:
        r14.f19728j0 = null;
        goto L21
    }

    public void m(f r5, boolean r10) {
    }

    public void n() {
    }

    public void o(ConstraintLayout r5) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r5 = this.f;
        if (r5 == null) goto L5;
        setIds(r5);
    L5:
        String r10 = this.g;
        if (r10 == null) goto L9;
        setReferenceTags(r10);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.e == false) goto L5;
        super.onMeasure(r5, r10);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void p(l r5, SparseArray r10) {
        int r11 = 0;
        r5.f17463v0 = 0;
        Arrays.fill(r5.f17462u0, null);
    L4:
        if (r11 >= this.f12985b) goto L6;
        r5.S((f) r10.get(this.f12984a[r11]));
        r11 = r11 + 1;
        goto L4
    }

    public final void q() {
        if (this.d != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        l r10 = this.d;
        ((ConstraintLayout.LayoutParams) r5).f13027q0 = r10;
        return;
    }

    public void setIds(String r5) {
        this.f = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        this.f12985b = 0;
    L6:
        int r11 = r5.indexOf(44, r10);
        if (r11 == (-1)) goto L8;
        b(r5.substring(r10, r11));
        r10 = r11 + 1;
        goto L6
    L8:
        b(r5.substring(r10));
    }

    public void setReferenceTags(String r5) {
        this.g = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        this.f12985b = 0;
    L6:
        int r11 = r5.indexOf(44, r10);
        if (r11 == (-1)) goto L8;
        d(r5.substring(r10, r11));
        r10 = r11 + 1;
        goto L6
    L8:
        d(r5.substring(r10));
    }

    public void setReferencedIds(int[] r5) {
        this.f = null;
        int r10 = 0;
        this.f12985b = 0;
    L4:
        if (r10 >= r5.length) goto L6;
        c(r5[r10]);
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.view.View
    public final void setTag(int r5, Object r10) {
        super.setTag(r5, r10);
        if (r10 == null) goto L5;
        return;
    L5:
        if (this.f != null) goto L9;
        c(r5);
        return;
    }

    public ConstraintHelper(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12984a = new int[32];
        this.e = false;
        this.f12987h = null;
        this.f12988i = new HashMap();
        this.f12986c = r5;
        k(r10);
    }

    public ConstraintHelper(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12984a = new int[32];
        this.e = false;
        this.f12987h = null;
        this.f12988i = new HashMap();
        this.f12986c = r5;
        k(r10);
    }
}
