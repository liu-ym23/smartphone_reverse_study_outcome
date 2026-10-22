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
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3816a = "MaterialButtonToggleGroup";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3817b = 0;
    private final List<a> c;
    private final c d;
    private final LinkedHashSet<b> e;
    private final Comparator<MaterialButton> f;
    private Integer[] g;
    private boolean h;
    private boolean i;
    private boolean j;
    private final int k;
    private Set<Integer> l;

    private static class a {
        private static final com.google.android.material.shape.c e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.shape.c f3819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.android.material.shape.c f3820b;
        com.google.android.material.shape.c c;
        com.google.android.material.shape.c d;

        static {
            e = new com.google.android.material.shape.a(0.0f);
        }

        a(com.google.android.material.shape.c r3, com.google.android.material.shape.c r4, com.google.android.material.shape.c r5, com.google.android.material.shape.c r6) {
            com.google.android.material.shape.c r7 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.shape.c.class, "com.obric.memorydata.plugin");
            com.google.android.material.shape.c r8 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r4, com.google.android.material.shape.c.class, "com.obric.memorydata.plugin");
            com.google.android.material.shape.c r9 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r5, com.google.android.material.shape.c.class, "com.obric.memorydata.plugin");
            com.google.android.material.shape.c r10 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r6, com.google.android.material.shape.c.class, "com.obric.memorydata.plugin");
            this.f3819a = r7;
            this.f3820b = r9;
            this.c = r10;
            this.d = r8;
        }

        public static a a(a r3) {
            com.google.android.material.shape.c r1 = r3.f3819a;
            com.google.android.material.shape.c r4 = r3.d;
            com.google.android.material.shape.c r2 = e;
            return new a(r1, r4, r2, r2);
        }

        public static a a(a r0, View r1) {
            if (r.a(r1) == false) goto L6;
            return b(r0);
        L6:
            return a(r0);
        }

        public static a b(a r3) {
            com.google.android.material.shape.c r1 = e;
            return new a(r1, r1, r3.f3820b, r3.c);
        }

        public static a b(a r0, View r1) {
            if (r.a(r1) == false) goto L6;
            return a(r0);
        L6:
            return b(r0);
        }

        public static a c(a r3) {
            com.google.android.material.shape.c r1 = r3.f3819a;
            com.google.android.material.shape.c r2 = e;
            return new a(r1, r2, r3.f3820b, r2);
        }

        public static a d(a r3) {
            com.google.android.material.shape.c r1 = e;
            return new a(r1, r3.d, r1, r3.c);
        }
    }

    public interface b {
        void a(MaterialButtonToggleGroup r1, int r2, boolean r3);
    }

    private class c implements MaterialButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialButtonToggleGroup f3821a;

        private c(MaterialButtonToggleGroup r1) {
            this.f3821a = r1;
        }

        /* synthetic */ c(MaterialButtonToggleGroup r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton r1, boolean r2) {
            this.f3821a.invalidate();
        }
    }

    static {
        f3817b = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, "style", "Widget_MaterialComponents_MaterialButtonToggleGroup");
    }

    public MaterialButtonToggleGroup(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialButtonToggleGroup(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.materialButtonToggleGroupStyle, "attr", "materialButtonToggleGroupStyle"));
    }

    public MaterialButtonToggleGroup(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = f3817b;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r3, r11, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        this.c = new ArrayList();
        this.d = new c(this, null);
        this.e = new LinkedHashSet();
        this.f = new AnonymousClass1(this);
        this.h = false;
        this.l = new HashSet();
        TypedArray r13 = k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, R.styleable.MaterialButtonToggleGroup, r11, r6, new int[0]);
        setSingleSelection(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialButtonToggleGroup_singleSelection, "styleable", "MaterialButtonToggleGroup_singleSelection"), false));
        this.k = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialButtonToggleGroup_checkedButton, "styleable", "MaterialButtonToggleGroup_checkedButton"), -1);
        this.j = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialButtonToggleGroup_selectionRequired, "styleable", "MaterialButtonToggleGroup_selectionRequired"), false);
        setChildrenDrawingOrderEnabled(true);
        r13.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private int a(View r6) {
        if (ZeusTransformUtils.instanceOf(r6, MaterialButton.class) == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= getChildCount()) goto L17;
        if (getChildAt(r0) == r6) goto L10;
        if (ZeusTransformUtils.instanceOf(getChildAt(r0), MaterialButton.class) == false) goto L16;
        if (d(r0) == false) goto L16;
        r2 = r2 + 1;
    L16:
        r0 = r0 + 1;
        goto L7
    L10:
        return r2;
    L17:
        return -1;
    }

    static /* synthetic */ int a(MaterialButtonToggleGroup r0, View r1) {
        return r0.a(r1);
    }

    private a a(int r4, int r5, int r6) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.c.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r5 != r6) goto L6;
        return r0;
    L6:
        if (getOrientation() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r4 != r5) goto L14;
        if (r1 == false) goto L13;
        return a.a(r0, this);
    L13:
        return a.c(r0);
    L14:
        if (r4 != r6) goto L19;
        if (r1 == false) goto L18;
        return a.b(r0, this);
    L18:
        return a.d(r0);
    L19:
        return null;
    L8:
        r1 = false;
        goto L9
    }

    private void a(int r3, boolean r4) {
        View r5 = findViewById(r3);
        if (ZeusTransformUtils.instanceOf(r5, MaterialButton.class) == false) goto L6;
        this.h = true;
        ((MaterialButton) ZeusTransformUtils.preCheckCast(r5, MaterialButton.class, "com.obric.memorydata.plugin")).setChecked(r4);
        this.h = false;
        return;
    }

    private static void a(l.a r1, a r2) {
        if (r2 != null) goto L5;
        r1.a(0.0f);
        return;
    L5:
        r1.b(r2.f3819a).e(r2.d).c(r2.f3820b).d(r2.c);
    }

    private void a(Set<Integer> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Set<Integer> r0 = this.l;
        this.l = new HashSet(r7);
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L9;
        int r2 = b(r1).getId();
        a(r2, r7.contains(Integer.valueOf(r2)));
        if (r0.contains(Integer.valueOf(r2)) == r7.contains(Integer.valueOf(r2))) goto L8;
        c(r2, r7.contains(Integer.valueOf(r2)));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        invalidate();
    }

    private LinearLayout.LayoutParams b(View r2) {
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayout.LayoutParams.class) == false) goto L7;
        return (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L7:
        return new LinearLayout.LayoutParams(r1.width, r1.height);
    }

    private MaterialButton b(int r2) {
        return (MaterialButton) ZeusTransformUtils.preCheckCast(getChildAt(r2), MaterialButton.class, "com.obric.memorydata.plugin");
    }

    private void b(int r3, boolean r4) {
        if (r3 != (-1)) goto L6;
        Log.e(f3816a, "Button ID is not valid: " + r3);
        return;
    L6:
        HashSet r0 = new HashSet(this.l);
        if (r4 == true) goto L9;
    L16:
        if (r4 == false) goto L18;
        return;
    L18:
        if (r0.contains(Integer.valueOf(r3)) == true) goto L20;
        return;
    L20:
        if (this.j == true) goto L22;
    L23:
        r0.remove(Integer.valueOf(r3));
    L24:
        a(r0);
        return;
    L22:
        if (r0.size() <= 1) goto L24;
    L9:
        if (r0.contains(Integer.valueOf(r3)) == true) goto L16;
        if (this.i == true) goto L13;
    L15:
        r0.add(Integer.valueOf(r3));
        goto L24
    L13:
        if (r0.isEmpty() == true) goto L15;
        r0.clear();
        goto L15
    }

    private void c(int r3) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L14;
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(b(r3).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (getOrientation() != 1) goto L11;
        r4.topMargin = 0;
        r4.bottomMargin = 0;
        return;
    L11:
        MarginLayoutParamsCompat.setMarginEnd(r4, 0);
        MarginLayoutParamsCompat.setMarginStart(r4, 0);
        r4.leftMargin = 0;
        r4.rightMargin = 0;
        return;
    }

    private void c(int r5, boolean r6) {
        Iterator<b> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).a(this, r5, r6);
        goto L4
    }

    private void d() {
        int r0 = getFirstVisibleChildIndex();
        if (r0 != (-1)) goto L5;
        return;
    L5:
        int r1 = r0 + 1;
    L7:
        if (r1 >= getChildCount()) goto L13;
        MaterialButton r2 = b(r1);
        int r3 = Math.min(r2.getStrokeWidth(), b(r1 - 1).getStrokeWidth());
        LinearLayout.LayoutParams r4 = b(r2);
        if (getOrientation() != 0) goto L11;
        MarginLayoutParamsCompat.setMarginEnd(r4, 0);
        MarginLayoutParamsCompat.setMarginStart(r4, -r3);
        r4.topMargin = 0;
    L12:
        r2.setLayoutParams(r4);
        r1 = r1 + 1;
        goto L7
    L11:
        r4.bottomMargin = 0;
        r4.topMargin = -r3;
        MarginLayoutParamsCompat.setMarginStart(r4, 0);
        goto L12
    L13:
        c(r0);
    }

    private boolean d(int r1) {
        if (getChildAt(r1).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    private void e() {
        TreeMap r0 = new TreeMap(this.f);
        int r1 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.put(b(r3), Integer.valueOf(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        this.g = (Integer[]) ZeusTransformUtils.preCheckCast(r0.values().toArray(new Integer[0]), Integer[].class, "com.obric.memorydata.plugin");
    }

    private int getFirstVisibleChildIndex() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (d(r1) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (d(r0) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    private int getVisibleButtonCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L11;
        if (ZeusTransformUtils.instanceOf(getChildAt(r0), MaterialButton.class) == false) goto L10;
        if (d(r0) == false) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton r2) {
        if (r2.getId() != (-1)) goto L6;
        r2.setId(ViewCompat.generateViewId());
        return;
    }

    private void setupButtonChild(MaterialButton r3) {
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setCheckable(true);
        r3.setOnPressedChangeListenerInternal(this.d);
        r3.setShouldDrawSurfaceColorStroke(true);
    }

    public void a() {
        a(new HashSet());
    }

    public void a(int r2) {
        b(r2, true);
    }

    void a(MaterialButton r2, boolean r3) {
        if (this.h == false) goto L5;
        return;
    L5:
        b(r2.getId(), r3);
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.e.add(r4);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (ZeusTransformUtils.instanceOf(r5, MaterialButton.class) == true) goto L6;
        Log.e(f3816a, "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r5, r6, r7);
        MaterialButton r8 = (MaterialButton) ZeusTransformUtils.preCheckCast(r5, MaterialButton.class, "com.obric.memorydata.plugin");
        setGeneratedIdIfNeeded(r8);
        setupButtonChild(r8);
        b(r8.getId(), r8.isChecked());
        l r9 = r8.getShapeAppearanceModel();
        this.c.add(new a(r9.f(), r9.i(), r9.g(), r9.h()));
        ViewCompat.setAccessibilityDelegate(r8, new AnonymousClass2(this));
    }

    public boolean b() {
        return this.i;
    }

    void c() {
        int r0 = getChildCount();
        int r1 = getFirstVisibleChildIndex();
        int r2 = getLastVisibleChildIndex();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        MaterialButton r4 = b(r3);
        if (r4.getVisibility() == 8) goto L8;
        l.a r5 = r4.getShapeAppearanceModel().n();
        a(r5, a(r3, r1, r2));
        r4.setShapeAppearanceModel(r5.a());
    L8:
        r3 = r3 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r1) {
        e();
        super.dispatchDraw(r1);
    }

    public int getCheckedButtonId() {
        if (this.i == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.l.isEmpty() == true) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(this.l.iterator().next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L9;
        int r2 = b(r1).getId();
        if (this.l.contains(Integer.valueOf(r2)) == false) goto L8;
        r0.add(Integer.valueOf(r2));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r1, int r2) {
        Integer[] r0 = this.g;
        if (r0 != null) goto L5;
    L9:
        Log.w(f3816a, "Child order wasn't updated");
        return r2;
    L5:
        if (r2 >= r0.length) goto L9;
        return r0[r2].intValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.k;
        if (r0 == (-1)) goto L6;
        a(Collections.singleton(Integer.valueOf(r0)));
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.wrap(r4);
        int r0 = getVisibleButtonCount();
        if (b() == false) goto L5;
        int r3 = 1;
    L6:
        r5.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, r0, false, r3));
        return;
    L5:
        r3 = 2;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        c();
        d();
        super.onMeasure(r1, r2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        if (ZeusTransformUtils.instanceOf(r3, MaterialButton.class) == false) goto L5;
        ((MaterialButton) ZeusTransformUtils.preCheckCast(r3, MaterialButton.class, "com.obric.memorydata.plugin")).setOnPressedChangeListenerInternal(null);
    L5:
        int r4 = indexOfChild(r3);
        if (r4 < 0) goto L8;
        this.c.remove(r4);
    L8:
        c();
        d();
    }

    public void setSelectionRequired(boolean r1) {
        this.j = r1;
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getBoolean(r2));
    }

    public void setSingleSelection(boolean r2) {
        if (this.i == r2) goto L6;
        this.i = r2;
        a();
        return;
    }
}
