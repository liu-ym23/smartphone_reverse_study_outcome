package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    private void updateImportantForAccessibility(View r10, boolean r11) {
        ViewParent r0 = r10.getParent();
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.class) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r1 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.class, "com.obric.memorydata.plugin");
        int r2 = r1.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L9;
        if (r11 == false) goto L9;
        this.importantForAccessibilityMap = new HashMap(r2);
    L9:
        int r5 = 0;
    L10:
        if (r5 >= r2) goto L32;
        View r6 = r1.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r6.getLayoutParams(), CoordinatorLayout.LayoutParams.class) == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r6 == r10) goto L31;
        if (r7 == true) goto L31;
        if (r11 == true) goto L27;
        Map<View, Integer> r8 = this.importantForAccessibilityMap;
        if (r8 == null) goto L31;
        if (r8.containsKey(r6) == false) goto L31;
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(this.importantForAccessibilityMap.get(r6), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L30:
        ViewCompat.setImportantForAccessibility(r6, r9);
        goto L31
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L29;
        this.importantForAccessibilityMap.put(r6, Integer.valueOf(r6.getImportantForAccessibility()));
    L29:
        r9 = 4;
    L31:
        r5 = r5 + 1;
        goto L10
    L14:
        if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior(), FabTransformationScrimBehavior.class) == false) goto L16;
        r7 = true;
        goto L17
    L32:
        if (r11 == true) goto L41;
        this.importantForAccessibilityMap = null;
        return;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.a onCreateMotionSpec(Context r2, boolean r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        int r4 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        String r0 = "mtrl_fab_transformation_sheet_expand_spec";
    L6:
        int r5 = ZeusTransformUtils.mapRes(r4, "animator", r0);
        FabTransformationBehavior.a r6 = new FabTransformationBehavior.a();
        r6.f4225a = h.a(r1, r5);
        r6.f4226b = new j(17, 0.0f, 0.0f);
        return r6;
    L5:
        r4 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        r0 = "mtrl_fab_transformation_sheet_collapse_spec";
        goto L6
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean onExpandedStateChange(View r1, View r2, boolean r3, boolean r4) {
        updateImportantForAccessibility(r2, r3);
        return super.onExpandedStateChange(r1, r2, r3, r4);
    }
}
