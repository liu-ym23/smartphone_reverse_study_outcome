package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;
import q5.a;
import r5.h;
import r5.j;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    private void updateImportantForAccessibility(@NonNull View r10, boolean r11) {
        ViewParent r12 = r10.getParent();
        if ((r12 instanceof CoordinatorLayout) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r13 = (CoordinatorLayout) r12;
        int r14 = r13.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L9;
        if (r11 == false) goto L9;
        this.importantForAccessibilityMap = new HashMap(r14);
    L9:
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L32;
        View r16 = r13.getChildAt(r15);
        if ((r16.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r16 == r10) goto L31;
        if (r17 == true) goto L31;
        if (r11 == true) goto L27;
        Map<View, Integer> r18 = this.importantForAccessibilityMap;
        if (r18 == null) goto L31;
        if (r18.containsKey(r16) == false) goto L31;
        int r19 = this.importantForAccessibilityMap.get(r16).intValue();
    L30:
        ViewCompat.setImportantForAccessibility(r16, r19);
        goto L31
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L29;
        this.importantForAccessibilityMap.put(r16, Integer.valueOf(r16.getImportantForAccessibility()));
    L29:
        r19 = 4;
    L31:
        r15 = r15 + 1;
        goto L10
    L14:
        if ((((CoordinatorLayout.LayoutParams) r16.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior) == false) goto L16;
        r17 = true;
        goto L17
    L32:
        if (r11 == true) goto L41;
        this.importantForAccessibilityMap = null;
        return;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    protected FabTransformationBehavior.e onCreateMotionSpec(Context r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = a.mtrl_fab_transformation_sheet_expand_spec;
    L5:
        FabTransformationBehavior.e r13 = new FabTransformationBehavior.e();
        r13.f4093a = h.d(r10, r12);
        r13.f4094b = new j(17, 0.0f, 0.0f);
        return r13;
    L4:
        r12 = a.mtrl_fab_transformation_sheet_collapse_spec;
        goto L5
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    protected boolean onExpandedStateChange(@NonNull View r10, @NonNull View r11, boolean r12, boolean r13) {
        updateImportantForAccessibility(r11, r12);
        return super.onExpandedStateChange(r10, r11, r12, r13);
    }
}
