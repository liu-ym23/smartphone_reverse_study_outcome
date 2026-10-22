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
import com.google.android.material.R;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = 0;
    private final CheckableGroup<Chip> checkableGroup;

    @Dimension
    private int chipSpacingHorizontal;

    @Dimension
    private int chipSpacingVertical;
    private final int defaultCheckedId;

    @Nullable
    private OnCheckedStateChangeListener onCheckedStateChangeListener;

    @NonNull
    private final PassThroughHierarchyChangeListener passThroughListener;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
        }
    }

    @Deprecated
    public interface OnCheckedChangeListener {
        void onCheckedChanged(@NonNull ChipGroup r5, @IdRes int r10);
    }

    public interface OnCheckedStateChangeListener {
        void onCheckedChanged(@NonNull ChipGroup r5, @NonNull List<Integer> r10);
    }

    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        final /* synthetic */ ChipGroup this$0;

        private PassThroughHierarchyChangeListener(ChipGroup r5) {
            this.this$0 = r5;
        }

        public static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$302(PassThroughHierarchyChangeListener r5, ViewGroup.OnHierarchyChangeListener r10) {
            r5.onHierarchyChangeListener = r10;
            return r10;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r5, View r10) {
            if (r5 == this.this$0) goto L5;
        L10:
            ViewGroup.OnHierarchyChangeListener r11 = this.onHierarchyChangeListener;
            if (r11 == null) goto L14;
            r11.onChildViewAdded(r5, r10);
            return;
        L14:
            return;
        L5:
            if ((r10 instanceof Chip) == false) goto L10;
            if (r10.getId() != (-1)) goto L9;
            r10.setId(ViewCompat.generateViewId());
        L9:
            ChipGroup.access$200(this.this$0).addCheckable((Chip) r10);
            goto L10
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r5, View r10) {
            ChipGroup r11 = this.this$0;
            if (r5 == r11) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r12 = this.onHierarchyChangeListener;
            if (r12 == null) goto L11;
            r12.onChildViewRemoved(r5, r10);
            return;
        L11:
            return;
        L5:
            if ((r10 instanceof Chip) == false) goto L7;
            ChipGroup.access$200(r11).removeCheckable((Chip) r10);
            goto L7
        }

        public /* synthetic */ PassThroughHierarchyChangeListener(ChipGroup r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ChipGroup;
    }

    public ChipGroup(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ OnCheckedStateChangeListener access$100(ChipGroup r5) {
        return r5.onCheckedStateChangeListener;
    }

    public static /* synthetic */ CheckableGroup access$200(ChipGroup r5) {
        return r5.checkableGroup;
    }

    private int getVisibleChipCount() {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= getChildCount()) goto L11;
        if ((getChildAt(r5) instanceof Chip) == false) goto L10;
        if (isChildVisible(r5) == false) goto L10;
        r10 = r10 + 1;
    L10:
        r5 = r5 + 1;
        goto L4
    L11:
        return r10;
    }

    private boolean isChildVisible(int r5) {
        if (getChildAt(r5).getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void check(@IdRes int r5) {
        this.checkableGroup.check(r5);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if (super.checkLayoutParams(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r5 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    public void clearCheck() {
        this.checkableGroup.clearCheck();
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @IdRes
    public int getCheckedChipId() {
        return this.checkableGroup.getSingleCheckedId();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.checkableGroup.getCheckedIdsSortedByChildOrder(this);
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public int getIndexOfChip(@Nullable View r10) {
        if ((r10 instanceof Chip) == true) goto L5;
        return -1;
    L5:
        int r5 = 0;
        int r11 = 0;
    L7:
        if (r5 >= getChildCount()) goto L17;
        View r12 = getChildAt(r5);
        if ((r12 instanceof Chip) == false) goto L16;
        if (isChildVisible(r5) == false) goto L16;
        if (((Chip) r12) == r10) goto L14;
        r11 = r11 + 1;
        goto L16
    L14:
        return r11;
    L16:
        r5 = r5 + 1;
        goto L7
    L17:
        return -1;
    }

    public boolean isSelectionRequired() {
        return this.checkableGroup.isSelectionRequired();
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.checkableGroup.isSingleSelection();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r5 = this.defaultCheckedId;
        if (r5 == (-1)) goto L6;
        this.checkableGroup.check(r5);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.wrap(r5);
        if (isSingleLine() == false) goto L5;
        int r11 = getVisibleChipCount();
    L6:
        int r12 = getRowCount();
        if (isSingleSelection() == false) goto L9;
        int r13 = 1;
    L10:
        r10.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r12, r11, false, r13));
        return;
    L9:
        r13 = 2;
        goto L10
    L5:
        r11 = -1;
        goto L6
    }

    public void setChipSpacing(@Dimension int r5) {
        setChipSpacingHorizontal(r5);
        setChipSpacingVertical(r5);
    }

    public void setChipSpacingHorizontal(@Dimension int r5) {
        if (this.chipSpacingHorizontal == r5) goto L6;
        this.chipSpacingHorizontal = r5;
        setItemSpacing(r5);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(@DimenRes int r5) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r5));
    }

    public void setChipSpacingResource(@DimenRes int r5) {
        setChipSpacing(getResources().getDimensionPixelOffset(r5));
    }

    public void setChipSpacingVertical(@Dimension int r5) {
        if (this.chipSpacingVertical == r5) goto L6;
        this.chipSpacingVertical = r5;
        setLineSpacing(r5);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(@DimenRes int r5) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r5));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r5) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable r5) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r5) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable final OnCheckedChangeListener r5) {
        if (r5 != null) goto L5;
        setOnCheckedStateChangeListener(null);
        return;
    L5:
        setOnCheckedStateChangeListener(new AnonymousClass2(this, r5));
    }

    public void setOnCheckedStateChangeListener(@Nullable OnCheckedStateChangeListener r5) {
        this.onCheckedStateChangeListener = r5;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r5) {
        PassThroughHierarchyChangeListener.access$302(this.passThroughListener, r5);
    }

    public void setSelectionRequired(boolean r5) {
        this.checkableGroup.setSelectionRequired(r5);
    }

    @Deprecated
    public void setShowDividerHorizontal(int r5) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r5) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean r5) {
        super.setSingleLine(r5);
    }

    public void setSingleSelection(boolean r5) {
        this.checkableGroup.setSingleSelection(r5);
    }

    public ChipGroup(Context r5, AttributeSet r10) {
        this(r5, r10, R.attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LayoutParams(r5);
    }

    public void setSingleLine(@BoolRes int r5) {
        setSingleLine(getResources().getBoolean(r5));
    }

    public void setSingleSelection(@BoolRes int r5) {
        setSingleSelection(getResources().getBoolean(r5));
    }

    public ChipGroup(Context r10, AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        CheckableGroup<Chip> r13 = new CheckableGroup();
        this.checkableGroup = r13;
        PassThroughHierarchyChangeListener r14 = new PassThroughHierarchyChangeListener(this, null);
        this.passThroughListener = r14;
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(getContext(), r11, R.styleable.ChipGroup, r12, r5, new int[0]);
        int r16 = r15.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(r15.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, r16));
        setChipSpacingVertical(r15.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, r16));
        setSingleLine(r15.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(r15.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(r15.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        this.defaultCheckedId = r15.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        r15.recycle();
        r13.setOnCheckedStateChangeListener(new AnonymousClass1(this));
        super.setOnHierarchyChangeListener(r14);
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
