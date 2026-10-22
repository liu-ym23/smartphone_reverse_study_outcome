package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.k;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3830a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3831b;
    private int c;
    private b d;
    private final com.google.android.material.internal.a<Chip> e;
    private final int f;
    private final c g;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }
    }

    @Deprecated
    public interface a {
        void a(ChipGroup r1, int r2);
    }

    public interface b {
        void a(ChipGroup r1, List<Integer> r2);
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChipGroup f3835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f3836b;

        private c(ChipGroup r1) {
            this.f3835a = r1;
        }

        /* synthetic */ c(ChipGroup r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(c r2, ViewGroup.OnHierarchyChangeListener r3) {
            ViewGroup.OnHierarchyChangeListener r4 = (ViewGroup.OnHierarchyChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewGroup.OnHierarchyChangeListener.class, "com.obric.memorydata.plugin");
            r2.f3836b = r4;
            return r4;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r4, View r5) {
            if (r4 == this.f3835a) goto L5;
        L10:
            ViewGroup.OnHierarchyChangeListener r3 = this.f3836b;
            if (r3 == null) goto L14;
            r3.onChildViewAdded(r4, r5);
            return;
        L14:
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, Chip.class) == false) goto L10;
            if (r5.getId() != (-1)) goto L9;
            r5.setId(ViewCompat.generateViewId());
        L9:
            ChipGroup.b(this.f3835a).a((Chip) ZeusTransformUtils.preCheckCast(r5, Chip.class, "com.obric.memorydata.plugin"));
            goto L10
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r4, View r5) {
            if (r4 == this.f3835a) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r3 = this.f3836b;
            if (r3 == null) goto L11;
            r3.onChildViewRemoved(r4, r5);
            return;
        L11:
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, Chip.class) == false) goto L7;
            ChipGroup.b(this.f3835a).b((Chip) ZeusTransformUtils.preCheckCast(r5, Chip.class, "com.obric.memorydata.plugin"));
            goto L7
        }
    }

    static {
        f3830a = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_ChipGroup, "style", "Widget_MaterialComponents_ChipGroup");
    }

    public ChipGroup(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ChipGroup(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.chipGroupStyle, "attr", "chipGroupStyle"));
    }

    public ChipGroup(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = f3830a;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r3, r11, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        com.google.android.material.internal.a<Chip> r13 = new com.google.android.material.internal.a();
        this.e = r13;
        c r14 = new c(this, null);
        this.g = r14;
        TypedArray r15 = k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, R.styleable.ChipGroup, r11, r6, new int[0]);
        int r1 = r15.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_chipSpacing, "styleable", "ChipGroup_chipSpacing"), 0);
        setChipSpacingHorizontal(r15.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_chipSpacingHorizontal, "styleable", "ChipGroup_chipSpacingHorizontal"), r1));
        setChipSpacingVertical(r15.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_chipSpacingVertical, "styleable", "ChipGroup_chipSpacingVertical"), r1));
        setSingleLine(r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_singleLine, "styleable", "ChipGroup_singleLine"), false));
        setSingleSelection(r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_singleSelection, "styleable", "ChipGroup_singleSelection"), false));
        setSelectionRequired(r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_selectionRequired, "styleable", "ChipGroup_selectionRequired"), false));
        this.f = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ChipGroup_checkedChip, "styleable", "ChipGroup_checkedChip"), -1);
        r15.recycle();
        r13.a(new AnonymousClass1(this));
        super.setOnHierarchyChangeListener(r14);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    static /* synthetic */ b a(ChipGroup r0) {
        return r0.d;
    }

    static /* synthetic */ com.google.android.material.internal.a b(ChipGroup r0) {
        return r0.e;
    }

    private int getChipCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L9;
        if (ZeusTransformUtils.instanceOf(getChildAt(r0), Chip.class) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    int a(View r7) {
        if (ZeusTransformUtils.instanceOf(r7, Chip.class) == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= getChildCount()) goto L15;
        if (ZeusTransformUtils.instanceOf(getChildAt(r0), Chip.class) == false) goto L14;
        if (((Chip) ZeusTransformUtils.preCheckCast(getChildAt(r0), Chip.class, "com.obric.memorydata.plugin")) == r7) goto L12;
        r2 = r2 + 1;
        goto L14
    L12:
        return r2;
    L14:
        r0 = r0 + 1;
        goto L7
    L15:
        return -1;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean a() {
        return super.a();
    }

    public boolean b() {
        return this.e.a();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        if (super.checkLayoutParams(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, LayoutParams.class) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    public int getCheckedChipId() {
        return this.e.c();
    }

    public List<Integer> getCheckedChipIds() {
        return this.e.a(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f3831b;
    }

    public int getChipSpacingVertical() {
        return this.c;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.f;
        if (r0 == (-1)) goto L6;
        this.e.a(r0);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.wrap(r4);
        if (a() == false) goto L5;
        int r0 = getChipCount();
    L6:
        int r1 = getRowCount();
        if (b() == false) goto L9;
        int r3 = 1;
    L10:
        r5.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r1, r0, false, r3));
        return;
    L9:
        r3 = 2;
        goto L10
    L5:
        r0 = -1;
        goto L6
    }

    public void setChipSpacing(int r1) {
        setChipSpacingHorizontal(r1);
        setChipSpacingVertical(r1);
    }

    public void setChipSpacingHorizontal(int r2) {
        if (this.f3831b == r2) goto L6;
        this.f3831b = r2;
        setItemSpacing(r2);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(int r2) {
        setChipSpacingHorizontal(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelOffset(r2));
    }

    public void setChipSpacingResource(int r2) {
        setChipSpacing(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelOffset(r2));
    }

    public void setChipSpacingVertical(int r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
        setLineSpacing(r2);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(int r2) {
        setChipSpacingVertical(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelOffset(r2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable r1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r1) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(a r3) {
        final a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        setOnCheckedStateChangeListener(null);
        return;
    L6:
        setOnCheckedStateChangeListener(new AnonymousClass2(this, r4));
    }

    public void setOnCheckedStateChangeListener(b r3) {
        this.d = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r3) {
        ViewGroup.OnHierarchyChangeListener r4 = (ViewGroup.OnHierarchyChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewGroup.OnHierarchyChangeListener.class, "com.obric.memorydata.plugin");
        c.a(this.g, r4);
    }

    public void setSelectionRequired(boolean r1) {
        this.e.b(r1);
    }

    @Deprecated
    public void setShowDividerHorizontal(int r1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int r2) {
        setSingleLine(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getBoolean(r2));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean r1) {
        super.setSingleLine(r1);
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getBoolean(r2));
    }

    public void setSingleSelection(boolean r1) {
        this.e.a(r1);
    }
}
