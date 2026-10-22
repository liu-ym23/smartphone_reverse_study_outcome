package n9;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.e;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9473o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9474p;

    public class a implements d {
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public b() {
            super(-2, -2);
        }
    }

    /* JADX INFO: renamed from: n9.c$c, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0120c {
    }

    public interface d {
    }

    private int getVisibleChipCount() {
        int r8 = 0;
        int r10 = 0;
    L4:
        if (r8 >= getChildCount()) goto L14;
        if ((getChildAt(r8) instanceof Chip) == false) goto L13;
        if (getChildAt(r8).getVisibility() != 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
        r10 = r10 + 1;
        goto L13
    L10:
        r11 = false;
    L13:
        r8 = r8 + 1;
        goto L4
    L14:
        return r10;
    }

    @Override // com.google.android.material.internal.e
    public final boolean a() {
        return this.f4860m;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        if (super.checkLayoutParams(r8) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r8 instanceof b) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new b(getContext(), r8);
    }

    public int getCheckedChipId() {
        throw null;
    }

    public List<Integer> getCheckedChipIds() {
        throw null;
    }

    public int getChipSpacingHorizontal() {
        return this.f9473o;
    }

    public int getChipSpacingVertical() {
        return this.f9474p;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        if (this.f4860m == false) goto L5;
        getVisibleChipCount();
    L5:
        getRowCount();
        throw null;
    }

    public void setChipSpacing(int r8) {
        setChipSpacingHorizontal(r8);
        setChipSpacingVertical(r8);
    }

    public void setChipSpacingHorizontal(int r8) {
        if (this.f9473o == r8) goto L6;
        this.f9473o = r8;
        setItemSpacing(r8);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(int r8) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r8));
    }

    public void setChipSpacingResource(int r8) {
        setChipSpacing(getResources().getDimensionPixelOffset(r8));
    }

    public void setChipSpacingVertical(int r8) {
        if (this.f9474p == r8) goto L6;
        this.f9474p = r8;
        setLineSpacing(r8);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(int r8) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r8));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r8) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable r8) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r8) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(InterfaceC0120c r8) {
        if (r8 != null) goto L6;
        a r10 = null;
    L4:
        setOnCheckedStateChangeListener(r10);
        return;
    L6:
        r10 = new a();
        goto L4
    }

    public void setOnCheckedStateChangeListener(d r8) {
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r8) {
        throw null;
    }

    public void setSelectionRequired(boolean r8) {
        throw null;
    }

    @Deprecated
    public void setShowDividerHorizontal(int r8) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r8) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int r8) {
        setSingleLine(getResources().getBoolean(r8));
    }

    public void setSingleSelection(int r8) {
        setSingleSelection(getResources().getBoolean(r8));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new b(r8);
    }

    @Override // com.google.android.material.internal.e
    public void setSingleLine(boolean r8) {
        super.setSingleLine(r8);
    }

    public void setSingleSelection(boolean r8) {
        throw null;
    }
}
