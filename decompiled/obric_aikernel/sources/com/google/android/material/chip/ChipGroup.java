package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.FlowLayout;
import java.util.List;
import java.util.Set;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f3126p = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Dimension
    private int f3127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Dimension
    private int f3128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private d f3129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.google.android.material.internal.a<Chip> f3130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f3131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    private final e f3132o;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }
    }

    class a implements com.google.android.material.internal.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChipGroup f3133a;

        a(ChipGroup r10) {
            this.f3133a = r10;
        }

        @Override // com.google.android.material.internal.a.b
        public void a(Set<Integer> r10) {
            if (ChipGroup.e(this.f3133a) == null) goto L6;
            d r11 = ChipGroup.e(this.f3133a);
            ChipGroup r12 = this.f3133a;
            r11.a(r12, ChipGroup.f(r12).j(this.f3133a));
            return;
        }
    }

    class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChipGroup f3135b;

        b(ChipGroup r10, c r11) {
            this.f3135b = r10;
            this.f3134a = r11;
        }

        @Override // com.google.android.material.chip.ChipGroup.d
        public void a(@NonNull ChipGroup r10, @NonNull List<Integer> r11) {
            if (ChipGroup.f(this.f3135b).l() == true) goto L5;
            return;
        L5:
            this.f3134a.a(r10, this.f3135b.getCheckedChipId());
        }
    }

    @Deprecated
    public interface c {
        void a(@NonNull ChipGroup r10, @IdRes int r11);
    }

    public interface d {
        void a(@NonNull ChipGroup r10, @NonNull List<Integer> r11);
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f3136c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ChipGroup f3137g;

        private e(ChipGroup r10) {
            this.f3137g = r10;
        }

        /* synthetic */ e(ChipGroup r10, a r11) {
            this(r10);
        }

        static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(e r10, ViewGroup.OnHierarchyChangeListener r11) {
            r10.f3136c = r11;
            return r11;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r10, View r11) {
            if (r10 == this.f3137g) goto L5;
        L10:
            ViewGroup.OnHierarchyChangeListener r12 = this.f3136c;
            if (r12 == null) goto L14;
            r12.onChildViewAdded(r10, r11);
            return;
        L14:
            return;
        L5:
            if ((r11 instanceof Chip) == false) goto L10;
            if (r11.getId() != (-1)) goto L9;
            r11.setId(ViewCompat.generateViewId());
        L9:
            ChipGroup.f(this.f3137g).e((Chip) r11);
            goto L10
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r10, View r11) {
            ChipGroup r12 = this.f3137g;
            if (r10 == r12) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r13 = this.f3136c;
            if (r13 == null) goto L11;
            r13.onChildViewRemoved(r10, r11);
            return;
        L11:
            return;
        L5:
            if ((r11 instanceof Chip) == false) goto L7;
            ChipGroup.f(r12).n((Chip) r11);
            goto L7
        }
    }

    static {
        f3126p = k.Widget_MaterialComponents_ChipGroup;
    }

    public ChipGroup(Context r10) {
        this(r10, null);
    }

    public ChipGroup(Context r10, AttributeSet r11) {
        this(r10, r11, q5.b.chipGroupStyle);
    }

    public ChipGroup(Context r10, AttributeSet r11, int r12) {
        int r13 = f3126p;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        com.google.android.material.internal.a<Chip> r14 = new com.google.android.material.internal.a();
        this.f3130m = r14;
        e r15 = new e(this, null);
        this.f3132o = r15;
        TypedArray r16 = com.google.android.material.internal.k.h(getContext(), r11, l.ChipGroup, r12, r13, new int[0]);
        int r17 = r16.getDimensionPixelOffset(l.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(r16.getDimensionPixelOffset(l.ChipGroup_chipSpacingHorizontal, r17));
        setChipSpacingVertical(r16.getDimensionPixelOffset(l.ChipGroup_chipSpacingVertical, r17));
        setSingleLine(r16.getBoolean(l.ChipGroup_singleLine, false));
        setSingleSelection(r16.getBoolean(l.ChipGroup_singleSelection, false));
        setSelectionRequired(r16.getBoolean(l.ChipGroup_selectionRequired, false));
        this.f3131n = r16.getResourceId(l.ChipGroup_checkedChip, -1);
        r16.recycle();
        r14.o(new a(this));
        super.setOnHierarchyChangeListener(r15);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    static /* synthetic */ d e(ChipGroup r10) {
        return r10.f3129l;
    }

    static /* synthetic */ com.google.android.material.internal.a f(ChipGroup r10) {
        return r10.f3130m;
    }

    private int getChipCount() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        if ((getChildAt(r10) instanceof Chip) == false) goto L8;
        r11 = r11 + 1;
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r11;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if (super.checkLayoutParams(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    int g(@Nullable View r10) {
        if ((r10 instanceof Chip) == true) goto L5;
        return -1;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= getChildCount()) goto L15;
        if ((getChildAt(r11) instanceof Chip) == false) goto L14;
        if (((Chip) getChildAt(r11)) == r10) goto L12;
        r12 = r12 + 1;
        goto L14
    L12:
        return r12;
    L14:
        r11 = r11 + 1;
        goto L7
    L15:
        return -1;
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    @IdRes
    public int getCheckedChipId() {
        return this.f3130m.k();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.f3130m.j(this);
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.f3127j;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.f3128k;
    }

    public boolean h() {
        return this.f3130m.l();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r10 = this.f3131n;
        if (r10 == (-1)) goto L6;
        this.f3130m.f(r10);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(r10);
        if (c() == false) goto L5;
        int r12 = getChipCount();
    L6:
        int r13 = getRowCount();
        if (h() == false) goto L9;
        int r14 = 1;
    L10:
        r11.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r13, r12, false, r14));
        return;
    L9:
        r14 = 2;
        goto L10
    L5:
        r12 = -1;
        goto L6
    }

    public void setChipSpacing(@Dimension int r10) {
        setChipSpacingHorizontal(r10);
        setChipSpacingVertical(r10);
    }

    public void setChipSpacingHorizontal(@Dimension int r10) {
        if (this.f3127j == r10) goto L6;
        this.f3127j = r10;
        setItemSpacing(r10);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(@DimenRes int r10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r10));
    }

    public void setChipSpacingResource(@DimenRes int r10) {
        setChipSpacing(getResources().getDimensionPixelOffset(r10));
    }

    public void setChipSpacingVertical(@Dimension int r10) {
        if (this.f3128k == r10) goto L6;
        this.f3128k = r10;
        setLineSpacing(r10);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(@DimenRes int r10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r10) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable r10) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable c r10) {
        if (r10 != null) goto L5;
        setOnCheckedStateChangeListener(null);
        return;
    L5:
        setOnCheckedStateChangeListener(new b(this, r10));
    }

    public void setOnCheckedStateChangeListener(@Nullable d r10) {
        this.f3129l = r10;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r10) {
        e.a(this.f3132o, r10);
    }

    public void setSelectionRequired(boolean r10) {
        this.f3130m.p(r10);
    }

    @Deprecated
    public void setShowDividerHorizontal(int r10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(@BoolRes int r10) {
        setSingleLine(getResources().getBoolean(r10));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean r10) {
        super.setSingleLine(r10);
    }

    public void setSingleSelection(@BoolRes int r10) {
        setSingleSelection(getResources().getBoolean(r10));
    }

    public void setSingleSelection(boolean r10) {
        this.f3130m.q(r10);
    }
}
