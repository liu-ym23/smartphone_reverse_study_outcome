package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.cae.R;
import h9.g;
import j0.h0;
import j0.w;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f5180i;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final FabTransformationBehavior.b F(Context r8, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    L5:
        FabTransformationBehavior.b r12 = new FabTransformationBehavior.b();
        r12.f5174a = g.a(r8, r11);
        r12.f5175b = new t2.b();
        return r12;
    L4:
        r11 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        goto L5
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void y(View r8, View r10, boolean r11, boolean r12) {
        ViewParent r13 = r10.getParent();
        if ((r13 instanceof CoordinatorLayout) == false) goto L30;
        CoordinatorLayout r14 = (CoordinatorLayout) r13;
        int r15 = r14.getChildCount();
        if (r11 == false) goto L8;
        this.f5180i = new HashMap(r15);
    L8:
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L28;
        View r17 = r14.getChildAt(r16);
        if ((r17.getLayoutParams() instanceof CoordinatorLayout.f) == true) goto L13;
    L15:
        boolean r18 = false;
    L16:
        if (r17 == r10) goto L27;
        if (r18 == true) goto L27;
        HashMap r19 = this.f5180i;
        if (r11 == true) goto L25;
        if (r19 == null) goto L27;
        if (r19.containsKey(r17) == false) goto L27;
        int r20 = ((Integer) this.f5180i.get(r17)).intValue();
        WeakHashMap<View, h0> r21 = w.f8437a;
    L26:
        w.d.s(r17, r20);
        goto L27
    L25:
        r19.put(r17, Integer.valueOf(r17.getImportantForAccessibility()));
        WeakHashMap<View, h0> r22 = w.f8437a;
        r20 = 4;
    L27:
        r16 = r16 + 1;
        goto L9
    L13:
        if ((((CoordinatorLayout.f) r17.getLayoutParams()).f1563a instanceof FabTransformationScrimBehavior) == false) goto L15;
        r18 = true;
        goto L16
    L28:
        if (r11 == true) goto L30;
        this.f5180i = null;
    L30:
        super.y(r8, r10, r11, r12);
    }
}
