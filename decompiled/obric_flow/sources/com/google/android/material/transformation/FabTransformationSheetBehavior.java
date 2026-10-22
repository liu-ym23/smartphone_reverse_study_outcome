package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    private void updateImportantForAccessibility(@NonNull View r10, boolean r11) {
        ViewParent r5 = r10.getParent();
        if ((r5 instanceof CoordinatorLayout) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r12 = (CoordinatorLayout) r5;
        int r13 = r12.getChildCount();
        if (r11 == false) goto L8;
        this.importantForAccessibilityMap = new HashMap(r13);
    L8:
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L27;
        View r15 = r12.getChildAt(r14);
        if ((r15.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L13;
    L15:
        boolean r16 = false;
    L16:
        if (r15 == r10) goto L26;
        if (r16 == true) goto L26;
        if (r11 == true) goto L25;
        Map<View, Integer> r17 = this.importantForAccessibilityMap;
        if (r17 == null) goto L26;
        if (r17.containsKey(r15) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r15, this.importantForAccessibilityMap.get(r15).intValue());
        goto L26
    L25:
        this.importantForAccessibilityMap.put(r15, Integer.valueOf(r15.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r15, 4);
    L26:
        r14 = r14 + 1;
        goto L9
    L13:
        if ((((CoordinatorLayout.LayoutParams) r15.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior) == false) goto L15;
        r16 = true;
        goto L16
    L27:
        if (r11 == true) goto L37;
        this.importantForAccessibilityMap = null;
        return;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    public FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context r5, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    L5:
        FabTransformationBehavior.FabTransformationSpec r12 = new FabTransformationBehavior.FabTransformationSpec();
        r12.timings = MotionSpec.createFromResource(r5, r11);
        r12.positioning = new Positioning(17, 0.0f, 0.0f);
        return r12;
    L4:
        r11 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        goto L5
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean onExpandedStateChange(@NonNull View r5, @NonNull View r10, boolean r11, boolean r12) {
        updateImportantForAccessibility(r10, r11);
        return super.onExpandedStateChange(r5, r10, r11, r12);
    }

    public FabTransformationSheetBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
    }
}
