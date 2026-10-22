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
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
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
    private static final int DEF_STYLE_RES = 0;
    private static final String LOG_TAG = "MButtonToggleGroup";
    private Set<Integer> checkedIds;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;

    @IdRes
    private final int defaultCheckId;
    private final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    private final List<CornerData> originalCornerData;
    private final PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    public static class CornerData {
        private static final CornerSize noCorner = null;
        CornerSize bottomLeft;
        CornerSize bottomRight;
        CornerSize topLeft;
        CornerSize topRight;

        static {
            noCorner = new AbsoluteCornerSize(0.0f);
        }

        public CornerData(CornerSize r5, CornerSize r10, CornerSize r11, CornerSize r12) {
            this.topLeft = r5;
            this.topRight = r11;
            this.bottomRight = r12;
            this.bottomLeft = r10;
        }

        public static CornerData bottom(CornerData r5) {
            CornerSize r10 = noCorner;
            return new CornerData(r10, r5.bottomLeft, r10, r5.bottomRight);
        }

        public static CornerData end(CornerData r5, View r10) {
            if (ViewUtils.isLayoutRtl(r10) == false) goto L6;
            return left(r5);
        L6:
            return right(r5);
        }

        public static CornerData left(CornerData r5) {
            CornerSize r10 = r5.topLeft;
            CornerSize r11 = r5.bottomLeft;
            CornerSize r12 = noCorner;
            return new CornerData(r10, r11, r12, r12);
        }

        public static CornerData right(CornerData r5) {
            CornerSize r10 = noCorner;
            return new CornerData(r10, r10, r5.topRight, r5.bottomRight);
        }

        public static CornerData start(CornerData r5, View r10) {
            if (ViewUtils.isLayoutRtl(r10) == false) goto L6;
            return right(r5);
        L6:
            return left(r5);
        }

        public static CornerData top(CornerData r5) {
            CornerSize r10 = r5.topLeft;
            CornerSize r11 = noCorner;
            return new CornerData(r10, r11, r5.topRight, r11);
        }
    }

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup r5, @IdRes int r10, boolean r11);
    }

    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        final /* synthetic */ MaterialButtonToggleGroup this$0;

        private PressedStateTracker(MaterialButtonToggleGroup r5) {
            this.this$0 = r5;
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(@NonNull MaterialButton r5, boolean r10) {
            this.this$0.invalidate();
        }

        public /* synthetic */ PressedStateTracker(MaterialButtonToggleGroup r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    }

    public MaterialButtonToggleGroup(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int access$100(MaterialButtonToggleGroup r5, View r10) {
        return r5.getIndexWithinVisibleButtons(r10);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int r5 = getFirstVisibleChildIndex();
        if (r5 != (-1)) goto L5;
        return;
    L5:
        int r10 = r5 + 1;
    L7:
        if (r10 >= getChildCount()) goto L13;
        MaterialButton r11 = getChildButton(r10);
        int r12 = Math.min(r11.getStrokeWidth(), getChildButton(r10 - 1).getStrokeWidth());
        LinearLayout.LayoutParams r13 = buildLayoutParams(r11);
        if (getOrientation() != 0) goto L11;
        MarginLayoutParamsCompat.setMarginEnd(r13, 0);
        MarginLayoutParamsCompat.setMarginStart(r13, -r12);
        r13.topMargin = 0;
    L12:
        r11.setLayoutParams(r13);
        r10 = r10 + 1;
        goto L7
    L11:
        r13.bottomMargin = 0;
        r13.topMargin = -r12;
        MarginLayoutParamsCompat.setMarginStart(r13, 0);
        goto L12
    L13:
        resetChildMargins(r5);
    }

    @NonNull
    private LinearLayout.LayoutParams buildLayoutParams(@NonNull View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return (LinearLayout.LayoutParams) r10;
    L7:
        return new LinearLayout.LayoutParams(r10.width, r10.height);
    }

    private void checkInternal(@IdRes int r5, boolean r10) {
        if (r5 != (-1)) goto L6;
        Log.e(LOG_TAG, "Button ID is not valid: " + r5);
        return;
    L6:
        HashSet r11 = new HashSet(this.checkedIds);
        if (r10 == true) goto L9;
    L16:
        if (r10 == false) goto L18;
        return;
    L18:
        if (r11.contains(Integer.valueOf(r5)) == true) goto L20;
        return;
    L20:
        if (this.selectionRequired == true) goto L22;
    L23:
        r11.remove(Integer.valueOf(r5));
    L24:
        updateCheckedIds(r11);
        return;
    L22:
        if (r11.size() <= 1) goto L24;
    L9:
        if (r11.contains(Integer.valueOf(r5)) == true) goto L16;
        if (this.singleSelection == true) goto L13;
    L15:
        r11.add(Integer.valueOf(r5));
        goto L24
    L13:
        if (r11.isEmpty() == true) goto L15;
        r11.clear();
        goto L15
    }

    private void dispatchOnButtonChecked(@IdRes int r5, boolean r10) {
        Iterator<OnButtonCheckedListener> r11 = this.onButtonCheckedListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onButtonChecked(this, r5, r10);
        goto L4
    }

    private MaterialButton getChildButton(int r5) {
        return (MaterialButton) getChildAt(r5);
    }

    private int getFirstVisibleChildIndex() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        if (isChildVisible(r10) == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    private int getIndexWithinVisibleButtons(@Nullable View r5) {
        if ((r5 instanceof MaterialButton) == true) goto L5;
        return -1;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= getChildCount()) goto L17;
        if (getChildAt(r10) == r5) goto L10;
        if ((getChildAt(r10) instanceof MaterialButton) == false) goto L16;
        if (isChildVisible(r10) == false) goto L16;
        r11 = r11 + 1;
    L16:
        r10 = r10 + 1;
        goto L7
    L10:
        return r11;
    L17:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r5 = getChildCount() - 1;
    L3:
        if (r5 < 0) goto L8;
        if (isChildVisible(r5) == true) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return r5;
    L8:
        return -1;
    }

    @Nullable
    private CornerData getNewCornerData(int r5, int r10, int r11) {
        CornerData r12 = this.originalCornerData.get(r5);
        if (r10 != r11) goto L6;
        return r12;
    L6:
        if (getOrientation() != 0) goto L8;
        boolean r13 = true;
    L9:
        if (r5 != r10) goto L14;
        if (r13 == false) goto L13;
        return CornerData.start(r12, this);
    L13:
        return CornerData.top(r12);
    L14:
        if (r5 != r11) goto L19;
        if (r13 == false) goto L18;
        return CornerData.end(r12, this);
    L18:
        return CornerData.bottom(r12);
    L19:
        return null;
    L8:
        r13 = false;
        goto L9
    }

    private int getVisibleButtonCount() {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= getChildCount()) goto L11;
        if ((getChildAt(r5) instanceof MaterialButton) == false) goto L10;
        if (isChildVisible(r5) == false) goto L10;
        r10 = r10 + 1;
    L10:
        r5 = r5 + 1;
        goto L4
    L11:
        return r10;
    }

    private boolean isChildVisible(int r5) {
        if (getChildAt(r5).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    private void resetChildMargins(int r5) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L14;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) getChildButton(r5).getLayoutParams();
        if (getOrientation() != 1) goto L11;
        r10.topMargin = 0;
        r10.bottomMargin = 0;
        return;
    L11:
        MarginLayoutParamsCompat.setMarginEnd(r10, 0);
        MarginLayoutParamsCompat.setMarginStart(r10, 0);
        r10.leftMargin = 0;
        r10.rightMargin = 0;
        return;
    }

    private void setCheckedStateForView(@IdRes int r5, boolean r10) {
        View r11 = findViewById(r5);
        if ((r11 instanceof MaterialButton) == false) goto L6;
        this.skipCheckedStateTracker = true;
        ((MaterialButton) r11).setChecked(r10);
        this.skipCheckedStateTracker = false;
        return;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton r5) {
        if (r5.getId() != (-1)) goto L6;
        r5.setId(ViewCompat.generateViewId());
        return;
    }

    private void setupButtonChild(@NonNull MaterialButton r5) {
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setCheckable(true);
        r5.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        r5.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(ShapeAppearanceModel.Builder r5, @Nullable CornerData r10) {
        if (r10 != null) goto L5;
        r5.setAllCornerSizes(0.0f);
        return;
    L5:
        r5.setTopLeftCornerSize(r10.topLeft).setBottomLeftCornerSize(r10.bottomLeft).setTopRightCornerSize(r10.topRight).setBottomRightCornerSize(r10.bottomRight);
    }

    private void updateCheckedIds(Set<Integer> r10) {
        Set<Integer> r5 = this.checkedIds;
        this.checkedIds = new HashSet(r10);
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L9;
        int r12 = getChildButton(r11).getId();
        setCheckedStateForView(r12, r10.contains(Integer.valueOf(r12)));
        if (r5.contains(Integer.valueOf(r12)) == r10.contains(Integer.valueOf(r12))) goto L8;
        dispatchOnButtonChecked(r12, r10.contains(Integer.valueOf(r12)));
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        invalidate();
    }

    private void updateChildOrder() {
        TreeMap r5 = new TreeMap(this.childOrderComparator);
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5.put(getChildButton(r11), Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        this.childOrder = (Integer[]) r5.values().toArray(new Integer[0]);
    }

    private void updateChildrenA11yClassName() {
        int r5 = 0;
    L4:
        if (r5 >= getChildCount()) goto L11;
        if (this.singleSelection == false) goto L9;
        Class r10 = RadioButton.class;
    L8:
        String r11 = r10.getName();
        getChildButton(r5).setA11yClassName(r11);
        r5 = r5 + 1;
        goto L4
    L9:
        r10 = ToggleButton.class;
        goto L8
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener r5) {
        this.onButtonCheckedListeners.add(r5);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if ((r5 instanceof MaterialButton) == true) goto L6;
        Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r5, r10, r11);
        MaterialButton r12 = (MaterialButton) r5;
        setGeneratedIdIfNeeded(r12);
        setupButtonChild(r12);
        checkInternal(r12.getId(), r12.isChecked());
        ShapeAppearanceModel r13 = r12.getShapeAppearanceModel();
        this.originalCornerData.add(new CornerData(r13.getTopLeftCornerSize(), r13.getBottomLeftCornerSize(), r13.getTopRightCornerSize(), r13.getBottomRightCornerSize()));
        r12.setEnabled(isEnabled());
        ViewCompat.setAccessibilityDelegate(r12, new AnonymousClass2(this));
    }

    public void check(@IdRes int r5) {
        checkInternal(r5, true);
    }

    public void clearChecked() {
        updateCheckedIds(new HashSet());
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas r5) {
        updateChildOrder();
        super.dispatchDraw(r5);
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.singleSelection == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.checkedIds.isEmpty() == true) goto L7;
        return this.checkedIds.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList r5 = new ArrayList();
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        int r11 = getChildButton(r10).getId();
        if (this.checkedIds.contains(Integer.valueOf(r11)) == false) goto L8;
        r5.add(Integer.valueOf(r11));
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r5;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r5, int r10) {
        Integer[] r11 = this.childOrder;
        if (r11 != null) goto L5;
    L9:
        Log.w(LOG_TAG, "Child order wasn't updated");
        return r10;
    L5:
        if (r10 >= r11.length) goto L9;
        return r11[r10].intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void onButtonCheckedStateChanged(@NonNull MaterialButton r5, boolean r10) {
        if (this.skipCheckedStateTracker == false) goto L5;
        return;
    L5:
        checkInternal(r5.getId(), r10);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r5 = this.defaultCheckId;
        if (r5 == (-1)) goto L6;
        updateCheckedIds(Collections.singleton(Integer.valueOf(r5)));
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.wrap(r5);
        int r11 = getVisibleButtonCount();
        if (isSingleSelection() == false) goto L5;
        int r12 = 1;
    L6:
        r10.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, r11, false, r12));
        return;
    L5:
        r12 = 2;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(r5, r10);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        if ((r5 instanceof MaterialButton) == false) goto L5;
        ((MaterialButton) r5).setOnPressedChangeListenerInternal(null);
    L5:
        int r10 = indexOfChild(r5);
        if (r10 < 0) goto L8;
        this.originalCornerData.remove(r10);
    L8:
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener r5) {
        this.onButtonCheckedListeners.remove(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        getChildButton(r10).setEnabled(r5);
        r10 = r10 + 1;
        goto L4
    }

    public void setSelectionRequired(boolean r5) {
        this.selectionRequired = r5;
    }

    public void setSingleSelection(boolean r5) {
        if (this.singleSelection == r5) goto L5;
        this.singleSelection = r5;
        clearChecked();
    L5:
        updateChildrenA11yClassName();
    }

    public void uncheck(@IdRes int r5) {
        checkInternal(r5, false);
    }

    @VisibleForTesting
    public void updateChildShapes() {
        int r5 = getChildCount();
        int r10 = getFirstVisibleChildIndex();
        int r11 = getLastVisibleChildIndex();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L9;
        MaterialButton r13 = getChildButton(r12);
        if (r13.getVisibility() == 8) goto L8;
        ShapeAppearanceModel.Builder r14 = r13.getShapeAppearanceModel().toBuilder();
        updateBuilderWithCornerData(r14, getNewCornerData(r12, r10, r11));
        r13.setShapeAppearanceModel(r14.build());
    L8:
        r12 = r12 + 1;
        goto L3
    }

    public MaterialButtonToggleGroup(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.originalCornerData = new ArrayList();
        this.pressedStateTracker = new PressedStateTracker(this, null);
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new AnonymousClass1(this);
        this.skipCheckedStateTracker = false;
        this.checkedIds = new HashSet();
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(getContext(), r11, R.styleable.MaterialButtonToggleGroup, r12, r5, new int[0]);
        setSingleSelection(r13.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.defaultCheckId = r13.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = r13.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(r13.getBoolean(R.styleable.MaterialButtonToggleGroup_android_enabled, true));
        r13.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int r5) {
        setSingleSelection(getResources().getBoolean(r5));
    }
}
