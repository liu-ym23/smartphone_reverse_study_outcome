package com.google.android.material.button;

import aa.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.google.android.material.internal.l;
import com.google.android.material.internal.q;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import k0.f;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f4462u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4464b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashSet<d> f4465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f4466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer[] f4467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f4471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public HashSet f4472t;

    public class a implements Comparator<MaterialButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialButtonToggleGroup f4473a;

        public a(MaterialButtonToggleGroup r8) {
            this.f4473a = r8;
        }

        @Override // java.util.Comparator
        public final int compare(MaterialButton r8, MaterialButton r10) {
            MaterialButton r11 = r8;
            MaterialButton r12 = r10;
            int r13 = Boolean.valueOf(r11.isChecked()).compareTo(Boolean.valueOf(r12.isChecked()));
            if (r13 != 0) goto L10;
            int r14 = Boolean.valueOf(r11.isPressed()).compareTo(Boolean.valueOf(r12.isPressed()));
            if (r14 != 0) goto L11;
            MaterialButtonToggleGroup r15 = this.f4473a;
            return Integer.valueOf(r15.indexOfChild(r11)).compareTo(Integer.valueOf(r15.indexOfChild(r12)));
        L11:
            return r14;
        L10:
            return r13;
        }
    }

    public class b extends j0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MaterialButtonToggleGroup f4474d;

        public b(MaterialButtonToggleGroup r8) {
            this.f4474d = r8;
        }

        @Override // j0.a
        public final void d(View r8, f r10) {
            this.f8370a.onInitializeAccessibilityNodeInfo(r8, r10.f8890a);
            int r11 = MaterialButtonToggleGroup.f4462u;
            MaterialButtonToggleGroup r12 = this.f4474d;
            r12.getClass();
            if ((r8 instanceof MaterialButton) == false) goto L17;
            int r13 = 0;
            int r14 = 0;
        L7:
            if (r13 >= r12.getChildCount()) goto L17;
            if (r12.getChildAt(r13) == r8) goto L18;
            if ((r12.getChildAt(r13) instanceof MaterialButton) == false) goto L16;
            if (r12.d(r13) == false) goto L16;
            r14 = r14 + 1;
        L16:
            r13 = r13 + 1;
        L18:
            r10.h(f.c.a(0, 1, r14, 1, ((MaterialButton) r8).isChecked()));
            return;
        L17:
            r14 = -1;
            goto L18
        }
    }

    public static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final aa.a f4475e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final aa.c f4476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final aa.c f4477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final aa.c f4478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final aa.c f4479d;

        static {
            f4475e = new aa.a(0.0f);
        }

        public c(aa.c r8, aa.c r10, aa.c r11, aa.c r12) {
            this.f4476a = r8;
            this.f4477b = r11;
            this.f4478c = r12;
            this.f4479d = r10;
        }
    }

    public interface d {
        void a();
    }

    public class e implements MaterialButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialButtonToggleGroup f4480a;

        public e(MaterialButtonToggleGroup r8) {
            this.f4480a = r8;
        }
    }

    public MaterialButtonToggleGroup(Context r8, AttributeSet r10) {
        super(ea.a.a(r8, r10, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), r10, R.attr.materialButtonToggleGroupStyle);
        this.f4463a = new ArrayList();
        this.f4464b = new e(this);
        this.f4465m = new LinkedHashSet();
        this.f4466n = new a(this);
        this.f4468p = false;
        this.f4472t = new HashSet();
        TypedArray r11 = l.d(getContext(), r10, g9.a.f7771l, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(r11.getBoolean(3, false));
        this.f4471s = r11.getResourceId(1, -1);
        this.f4470r = r11.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(r11.getBoolean(0, true));
        r11.recycle();
        WeakHashMap<View, h0> r12 = w.f8437a;
        w.d.s(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int r8 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L8;
        if (d(r10) == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r8 = getChildCount() - 1;
    L3:
        if (r8 < 0) goto L8;
        if (d(r8) == true) goto L6;
        r8 = r8 - 1;
        goto L3
    L6:
        return r8;
    L8:
        return -1;
    }

    private int getVisibleButtonCount() {
        int r8 = 0;
        int r10 = 0;
    L4:
        if (r8 >= getChildCount()) goto L11;
        if ((getChildAt(r8) instanceof MaterialButton) == false) goto L10;
        if (d(r8) == false) goto L10;
        r10 = r10 + 1;
    L10:
        r8 = r8 + 1;
        goto L4
    L11:
        return r10;
    }

    private void setGeneratedIdIfNeeded(MaterialButton r8) {
        if (r8.getId() != (-1)) goto L6;
        WeakHashMap<View, h0> r10 = w.f8437a;
        r8.setId(w.e.a());
        return;
    }

    private void setupButtonChild(MaterialButton r8) {
        r8.setMaxLines(1);
        r8.setEllipsize(TextUtils.TruncateAt.END);
        r8.setCheckable(true);
        r8.setOnPressedChangeListenerInternal(this.f4464b);
        r8.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int r8 = getFirstVisibleChildIndex();
        if (r8 != (-1)) goto L5;
        return;
    L5:
        int r10 = r8 + 1;
    L7:
        if (r10 >= getChildCount()) goto L18;
        MaterialButton r11 = c(r10);
        int r12 = Math.min(r11.getStrokeWidth(), c(r10 - 1).getStrokeWidth());
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == false) goto L11;
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) r13;
    L13:
        if (getOrientation() != 0) goto L15;
        j0.f.g(r14, 0);
        j0.f.h(r14, -r12);
        r14.topMargin = 0;
    L16:
        r11.setLayoutParams(r14);
        r10 = r10 + 1;
        goto L7
    L15:
        r14.bottomMargin = 0;
        r14.topMargin = -r12;
        j0.f.h(r14, 0);
        goto L16
    L11:
        r14 = new LinearLayout.LayoutParams(r13.width, r13.height);
        goto L13
    L18:
        if (getChildCount() == 0) goto L29;
        if (r8 == (-1)) goto L31;
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) c(r8).getLayoutParams();
        if (getOrientation() != 1) goto L24;
        r15.topMargin = 0;
        r15.bottomMargin = 0;
        return;
    L24:
        j0.f.g(r15, 0);
        j0.f.h(r15, 0);
        r15.leftMargin = 0;
        r15.rightMargin = 0;
        return;
    L31:
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        if ((r8 instanceof MaterialButton) == true) goto L6;
        Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r8, r10, r11);
        MaterialButton r12 = (MaterialButton) r8;
        setGeneratedIdIfNeeded(r12);
        setupButtonChild(r12);
        b(r12.getId(), r12.isChecked());
        j r13 = r12.getShapeAppearanceModel();
        ArrayList r14 = this.f4463a;
        aa.c r15 = r13.f184e;
        aa.c r16 = r13.f185f;
        aa.c r17 = r13.f186g;
        r14.add(new c(r15, r13.f187h, r16, r17));
        r12.setEnabled(isEnabled());
        w.m(r12, new b(this));
    }

    public final void b(int r8, boolean r10) {
        if (r8 != (-1)) goto L6;
        Log.e("MButtonToggleGroup", "Button ID is not valid: " + r8);
        return;
    L6:
        HashSet r11 = new HashSet(this.f4472t);
        if (r10 == true) goto L9;
    L16:
        if (r10 == false) goto L18;
        return;
    L18:
        if (r11.contains(Integer.valueOf(r8)) == true) goto L20;
        return;
    L20:
        if (this.f4470r == true) goto L22;
    L23:
        r11.remove(Integer.valueOf(r8));
    L24:
        e(r11);
        return;
    L22:
        if (r11.size() <= 1) goto L24;
    L9:
        if (r11.contains(Integer.valueOf(r8)) == true) goto L16;
        if (this.f4469q == true) goto L13;
    L15:
        r11.add(Integer.valueOf(r8));
        goto L24
    L13:
        if (r11.isEmpty() == true) goto L15;
        r11.clear();
        goto L15
    }

    public final MaterialButton c(int r8) {
        return (MaterialButton) getChildAt(r8);
    }

    public final boolean d(int r8) {
        if (getChildAt(r8).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        TreeMap r10 = new TreeMap(this.f4466n);
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.put(c(r12), Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        this.f4467o = (Integer[]) r10.values().toArray(new Integer[0]);
        super.dispatchDraw(r8);
    }

    public final void e(Set<Integer> r8) {
        HashSet r10 = this.f4472t;
        this.f4472t = new HashSet(r8);
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L15;
        int r12 = c(r11).getId();
        boolean r13 = r8.contains(Integer.valueOf(r12));
        View r14 = findViewById(r12);
        if ((r14 instanceof MaterialButton) == false) goto L9;
        this.f4468p = true;
        ((MaterialButton) r14).setChecked(r13);
        this.f4468p = false;
    L9:
        if (r10.contains(Integer.valueOf(r12)) == r8.contains(Integer.valueOf(r12))) goto L14;
        r8.contains(Integer.valueOf(r12));
        Iterator<d> r15 = this.f4465m.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r15.next().a();
    L14:
        r11 = r11 + 1;
        goto L4
    L15:
        invalidate();
    }

    public final void f() {
        int r8 = getChildCount();
        int r10 = getFirstVisibleChildIndex();
        int r11 = getLastVisibleChildIndex();
        int r12 = 0;
    L3:
        if (r12 >= r8) goto L36;
        MaterialButton r13 = c(r12);
        if (r13.getVisibility() == 8) goto L35;
        j r14 = r13.getShapeAppearanceModel();
        r14.getClass();
        j.a r15 = new j.a(r14);
        c r16 = (c) this.f4463a.get(r12);
        if (r10 != r11) goto L11;
    L31:
        if (r16 != null) goto L33;
        r15.e(0.0f);
        r15.f(0.0f);
        r15.d(0.0f);
        r15.c(0.0f);
    L34:
        r13.setShapeAppearanceModel(new j(r15));
        goto L35
    L33:
        r15.f196e = r16.f4476a;
        r15.f199h = r16.f4479d;
        r15.f197f = r16.f4477b;
        r15.f198g = r16.f4478c;
        goto L34
    L11:
        if (getOrientation() != 0) goto L13;
        boolean r17 = true;
    L14:
        aa.a r18 = c.f4475e;
        if (r12 != r10) goto L23;
        if (r17 == true) goto L18;
        c r19 = new c(r16.f4476a, r18, r16.f4477b, r18);
    L21:
        r16 = r19;
        goto L31
    L18:
        if (q.a(this) == false) goto L20;
        r19 = new c(r18, r18, r16.f4477b, r16.f4478c);
        goto L21
    L20:
        r19 = new c(r16.f4476a, r16.f4479d, r18, r18);
        goto L21
    L23:
        if (r12 != r11) goto L30;
        if (r17 == true) goto L26;
        r19 = new c(r18, r16.f4479d, r18, r16.f4478c);
        goto L21
    L26:
        if (q.a(this) == false) goto L28;
        r19 = new c(r16.f4476a, r16.f4479d, r18, r18);
        goto L21
    L28:
        r19 = new c(r18, r18, r16.f4477b, r16.f4478c);
        goto L21
    L30:
        r16 = null;
        goto L31
    L13:
        r17 = false;
    L35:
        r12 = r12 + 1;
        goto L3
    }

    public int getCheckedButtonId() {
        if (this.f4469q == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.f4472t.isEmpty() == true) goto L7;
        return ((Integer) this.f4472t.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList r8 = new ArrayList();
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        int r11 = c(r10).getId();
        if (this.f4472t.contains(Integer.valueOf(r11)) == false) goto L8;
        r8.add(Integer.valueOf(r11));
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r8;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r8, int r10) {
        Integer[] r11 = this.f4467o;
        if (r11 != null) goto L5;
    L9:
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return r10;
    L5:
        if (r10 >= r11.length) goto L9;
        return r11[r10].intValue();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r8 = this.f4471s;
        if (r8 == (-1)) goto L6;
        e(Collections.singleton(Integer.valueOf(r8)));
        return;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        f r10 = new f(r8);
        int r11 = getVisibleButtonCount();
        if (this.f4469q == false) goto L5;
        int r12 = 1;
    L6:
        r10.g(new f.b(AccessibilityNodeInfo.CollectionInfo.obtain(1, r11, false, r12)));
        return;
    L5:
        r12 = 2;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        f();
        a();
        super.onMeasure(r8, r10);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r8) {
        super.onViewRemoved(r8);
        if ((r8 instanceof MaterialButton) == false) goto L5;
        ((MaterialButton) r8).setOnPressedChangeListenerInternal(null);
    L5:
        int r10 = indexOfChild(r8);
        if (r10 < 0) goto L8;
        this.f4463a.remove(r10);
    L8:
        f();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        c(r10).setEnabled(r8);
        r10 = r10 + 1;
        goto L4
    }

    public void setSelectionRequired(boolean r8) {
        this.f4470r = r8;
    }

    public void setSingleSelection(int r8) {
        setSingleSelection(getResources().getBoolean(r8));
    }

    public void setSingleSelection(boolean r8) {
        if (this.f4469q == r8) goto L5;
        this.f4469q = r8;
        e(new HashSet());
    L5:
        int r10 = 0;
    L7:
        if (r10 >= getChildCount()) goto L13;
        if (this.f4469q == false) goto L11;
        Class r11 = RadioButton.class;
    L12:
        String r12 = r11.getName();
        c(r10).setA11yClassName(r12);
        r10 = r10 + 1;
        goto L7
    L11:
        r11 = ToggleButton.class;
        goto L12
    }
}
