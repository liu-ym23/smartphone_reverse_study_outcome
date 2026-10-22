package com.google.android.material.button;

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
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.ViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f3062p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f3063q = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f3064c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f3065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LinkedHashSet<c> f3066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Comparator<MaterialButton> f3067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer[] f3068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3071m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @IdRes
    private final int f3072n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Set<Integer> f3073o;

    class a implements Comparator<MaterialButton> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialButtonToggleGroup f3074c;

        a(MaterialButtonToggleGroup r10) {
            this.f3074c = r10;
        }

        public int a(MaterialButton r10, MaterialButton r11) {
            int r12 = Boolean.valueOf(r10.isChecked()).compareTo(Boolean.valueOf(r11.isChecked()));
            if (r12 == 0) goto L5;
            return r12;
        L5:
            int r13 = Boolean.valueOf(r10.isPressed()).compareTo(Boolean.valueOf(r11.isPressed()));
            if (r13 == 0) goto L9;
            return r13;
        L9:
            return Integer.valueOf(this.f3074c.indexOfChild(r10)).compareTo(Integer.valueOf(this.f3074c.indexOfChild(r11)));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(MaterialButton r10, MaterialButton r11) {
            return a(r10, r11);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.android.material.shape.c f3075e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.shape.c f3076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.android.material.shape.c f3077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.google.android.material.shape.c f3078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.google.android.material.shape.c f3079d;

        static {
            f3075e = new com.google.android.material.shape.a(0.0f);
        }

        b(com.google.android.material.shape.c r10, com.google.android.material.shape.c r11, com.google.android.material.shape.c r12, com.google.android.material.shape.c r13) {
            this.f3076a = r10;
            this.f3077b = r12;
            this.f3078c = r13;
            this.f3079d = r11;
        }

        public static b a(b r10) {
            com.google.android.material.shape.c r11 = f3075e;
            return new b(r11, r10.f3079d, r11, r10.f3078c);
        }

        public static b b(b r10, View r11) {
            if (ViewUtils.i(r11) == false) goto L6;
            return c(r10);
        L6:
            return d(r10);
        }

        public static b c(b r10) {
            com.google.android.material.shape.c r11 = r10.f3076a;
            com.google.android.material.shape.c r12 = r10.f3079d;
            com.google.android.material.shape.c r13 = f3075e;
            return new b(r11, r12, r13, r13);
        }

        public static b d(b r10) {
            com.google.android.material.shape.c r11 = f3075e;
            return new b(r11, r11, r10.f3077b, r10.f3078c);
        }

        public static b e(b r10, View r11) {
            if (ViewUtils.i(r11) == false) goto L6;
            return d(r10);
        L6:
            return c(r10);
        }

        public static b f(b r10) {
            com.google.android.material.shape.c r11 = r10.f3076a;
            com.google.android.material.shape.c r12 = f3075e;
            return new b(r11, r12, r10.f3077b, r12);
        }
    }

    public interface c {
        void a(MaterialButtonToggleGroup r10, @IdRes int r11, boolean r12);
    }

    private class d implements MaterialButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialButtonToggleGroup f3080a;

        private d(MaterialButtonToggleGroup r10) {
            this.f3080a = r10;
        }

        /* synthetic */ d(MaterialButtonToggleGroup r10, a r11) {
            this(r10);
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton r10, boolean r11) {
            this.f3080a.invalidate();
        }
    }

    static {
        f3062p = MaterialButtonToggleGroup.class.getSimpleName();
        f3063q = k.Widget_MaterialComponents_MaterialButtonToggleGroup;
    }

    public MaterialButtonToggleGroup(@NonNull Context r10) {
        this(r10, null);
    }

    public MaterialButtonToggleGroup(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = f3063q;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        this.f3064c = new ArrayList();
        this.f3065g = new d(this, null);
        this.f3066h = new LinkedHashSet();
        this.f3067i = new a(this);
        this.f3069k = false;
        this.f3073o = new HashSet();
        TypedArray r14 = com.google.android.material.internal.k.h(getContext(), r11, l.MaterialButtonToggleGroup, r12, r13, new int[0]);
        setSingleSelection(r14.getBoolean(l.MaterialButtonToggleGroup_singleSelection, false));
        this.f3072n = r14.getResourceId(l.MaterialButtonToggleGroup_checkedButton, -1);
        this.f3071m = r14.getBoolean(l.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        r14.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    static /* synthetic */ int a(MaterialButtonToggleGroup r10, View r11) {
        return r10.j(r11);
    }

    private void c() {
        int r10 = getFirstVisibleChildIndex();
        if (r10 != (-1)) goto L5;
        return;
    L5:
        int r11 = r10 + 1;
    L7:
        if (r11 >= getChildCount()) goto L13;
        MaterialButton r12 = i(r11);
        int r13 = Math.min(r12.getStrokeWidth(), i(r11 - 1).getStrokeWidth());
        LinearLayout.LayoutParams r14 = d(r12);
        if (getOrientation() != 0) goto L11;
        MarginLayoutParamsCompat.setMarginEnd(r14, 0);
        MarginLayoutParamsCompat.setMarginStart(r14, -r13);
        r14.topMargin = 0;
    L12:
        r12.setLayoutParams(r14);
        r11 = r11 + 1;
        goto L7
    L11:
        r14.bottomMargin = 0;
        r14.topMargin = -r13;
        MarginLayoutParamsCompat.setMarginStart(r14, 0);
        goto L12
    L13:
        o(r10);
    }

    @NonNull
    private LinearLayout.LayoutParams d(@NonNull View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return (LinearLayout.LayoutParams) r11;
    L7:
        return new LinearLayout.LayoutParams(r11.width, r11.height);
    }

    private void f(@IdRes int r10, boolean r11) {
        if (r10 != (-1)) goto L6;
        Log.e(f3062p, "Button ID is not valid: " + r10);
        return;
    L6:
        HashSet r12 = new HashSet(this.f3073o);
        if (r11 == true) goto L9;
    L16:
        if (r11 == false) goto L18;
        return;
    L18:
        if (r12.contains(Integer.valueOf(r10)) == true) goto L20;
        return;
    L20:
        if (this.f3071m == true) goto L22;
    L23:
        r12.remove(Integer.valueOf(r10));
    L24:
        r(r12);
        return;
    L22:
        if (r12.size() <= 1) goto L24;
    L9:
        if (r12.contains(Integer.valueOf(r10)) == true) goto L16;
        if (this.f3070l == true) goto L13;
    L15:
        r12.add(Integer.valueOf(r10));
        goto L24
    L13:
        if (r12.isEmpty() == true) goto L15;
        r12.clear();
        goto L15
    }

    private int getFirstVisibleChildIndex() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (l(r11) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r10 = getChildCount() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (l(r10) == true) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    private int getVisibleButtonCount() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= getChildCount()) goto L11;
        if ((getChildAt(r10) instanceof MaterialButton) == false) goto L10;
        if (l(r10) == false) goto L10;
        r11 = r11 + 1;
    L10:
        r10 = r10 + 1;
        goto L4
    L11:
        return r11;
    }

    private void h(@IdRes int r10, boolean r11) {
        Iterator<c> r12 = this.f3066h.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().a(this, r10, r11);
        goto L4
    }

    private MaterialButton i(int r10) {
        return (MaterialButton) getChildAt(r10);
    }

    private int j(@Nullable View r10) {
        if ((r10 instanceof MaterialButton) == true) goto L5;
        return -1;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= getChildCount()) goto L17;
        if (getChildAt(r11) == r10) goto L10;
        if ((getChildAt(r11) instanceof MaterialButton) == false) goto L16;
        if (l(r11) == false) goto L16;
        r12 = r12 + 1;
    L16:
        r11 = r11 + 1;
        goto L7
    L10:
        return r12;
    L17:
        return -1;
    }

    @Nullable
    private b k(int r10, int r11, int r12) {
        b r13 = this.f3064c.get(r10);
        if (r11 != r12) goto L6;
        return r13;
    L6:
        if (getOrientation() != 0) goto L8;
        boolean r14 = true;
    L9:
        if (r10 != r11) goto L14;
        if (r14 == false) goto L13;
        return b.e(r13, this);
    L13:
        return b.f(r13);
    L14:
        if (r10 != r12) goto L19;
        if (r14 == false) goto L18;
        return b.b(r13, this);
    L18:
        return b.a(r13);
    L19:
        return null;
    L8:
        r14 = false;
        goto L9
    }

    private boolean l(int r10) {
        if (getChildAt(r10).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    private void o(int r10) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L14;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) i(r10).getLayoutParams();
        if (getOrientation() != 1) goto L11;
        r11.topMargin = 0;
        r11.bottomMargin = 0;
        return;
    L11:
        MarginLayoutParamsCompat.setMarginEnd(r11, 0);
        MarginLayoutParamsCompat.setMarginStart(r11, 0);
        r11.leftMargin = 0;
        r11.rightMargin = 0;
        return;
    }

    private void p(@IdRes int r10, boolean r11) {
        View r12 = findViewById(r10);
        if ((r12 instanceof MaterialButton) == false) goto L6;
        this.f3069k = true;
        ((MaterialButton) r12).setChecked(r11);
        this.f3069k = false;
        return;
    }

    private static void q(com.google.android.material.shape.l.b r10, @Nullable b r11) {
        if (r11 != null) goto L5;
        r10.o(0.0f);
        return;
    L5:
        r10.F(r11.f3076a).w(r11.f3079d).J(r11.f3077b).A(r11.f3078c);
    }

    private void r(Set<Integer> r10) {
        Set<Integer> r11 = this.f3073o;
        this.f3073o = new HashSet(r10);
        int r12 = 0;
    L4:
        if (r12 >= getChildCount()) goto L9;
        int r13 = i(r12).getId();
        p(r13, r10.contains(Integer.valueOf(r13)));
        if (r11.contains(Integer.valueOf(r13)) == r10.contains(Integer.valueOf(r13))) goto L8;
        h(r13, r10.contains(Integer.valueOf(r13)));
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        invalidate();
    }

    private void s() {
        TreeMap r10 = new TreeMap(this.f3067i);
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.put(i(r12), Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        this.f3068j = (Integer[]) r10.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton r10) {
        if (r10.getId() != (-1)) goto L6;
        r10.setId(ViewCompat.generateViewId());
        return;
    }

    private void setupButtonChild(@NonNull MaterialButton r10) {
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setCheckable(true);
        r10.setOnPressedChangeListenerInternal(this.f3065g);
        r10.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if ((r10 instanceof MaterialButton) == true) goto L6;
        Log.e(f3062p, "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r10, r11, r12);
        MaterialButton r13 = (MaterialButton) r10;
        setGeneratedIdIfNeeded(r13);
        setupButtonChild(r13);
        f(r13.getId(), r13.isChecked());
        com.google.android.material.shape.l r14 = r13.getShapeAppearanceModel();
        this.f3064c.add(new b(r14.r(), r14.j(), r14.t(), r14.l()));
        ViewCompat.setAccessibilityDelegate(r13, new AnonymousClass2(this));
    }

    public void b(@NonNull c r10) {
        this.f3066h.add(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas r10) {
        s();
        super.dispatchDraw(r10);
    }

    public void e(@IdRes int r10) {
        f(r10, true);
    }

    public void g() {
        r(new HashSet());
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.f3070l == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.f3073o.isEmpty() == true) goto L7;
        return this.f3073o.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L9;
        int r12 = i(r11).getId();
        if (this.f3073o.contains(Integer.valueOf(r12)) == false) goto L8;
        r10.add(Integer.valueOf(r12));
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int r10, int r11) {
        Integer[] r12 = this.f3068j;
        if (r12 != null) goto L5;
    L9:
        Log.w(f3062p, "Child order wasn't updated");
        return r11;
    L5:
        if (r11 >= r12.length) goto L9;
        return r12[r11].intValue();
    }

    public boolean m() {
        return this.f3070l;
    }

    void n(@NonNull MaterialButton r10, boolean r11) {
        if (this.f3069k == false) goto L5;
        return;
    L5:
        f(r10.getId(), r11);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r10 = this.f3072n;
        if (r10 == (-1)) goto L6;
        r(Collections.singleton(Integer.valueOf(r10)));
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(r10);
        int r12 = getVisibleButtonCount();
        if (m() == false) goto L5;
        int r13 = 1;
    L6:
        r11.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, r12, false, r13));
        return;
    L5:
        r13 = 2;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        t();
        c();
        super.onMeasure(r10, r11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        if ((r10 instanceof MaterialButton) == false) goto L5;
        ((MaterialButton) r10).setOnPressedChangeListenerInternal(null);
    L5:
        int r11 = indexOfChild(r10);
        if (r11 < 0) goto L8;
        this.f3064c.remove(r11);
    L8:
        t();
        c();
    }

    public void setSelectionRequired(boolean r10) {
        this.f3071m = r10;
    }

    public void setSingleSelection(@BoolRes int r10) {
        setSingleSelection(getResources().getBoolean(r10));
    }

    public void setSingleSelection(boolean r10) {
        if (this.f3070l == r10) goto L6;
        this.f3070l = r10;
        g();
        return;
    }

    @VisibleForTesting
    void t() {
        int r10 = getChildCount();
        int r11 = getFirstVisibleChildIndex();
        int r12 = getLastVisibleChildIndex();
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L9;
        MaterialButton r14 = i(r13);
        if (r14.getVisibility() == 8) goto L8;
        com.google.android.material.shape.l.b r15 = r14.getShapeAppearanceModel().v();
        q(r15, k(r13, r11, r12));
        r14.setShapeAppearanceModel(r15.m());
    L8:
        r13 = r13 + 1;
        goto L3
    }
}
