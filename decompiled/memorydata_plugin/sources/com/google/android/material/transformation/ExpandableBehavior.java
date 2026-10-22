package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.e.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.currentState = 0;
    }

    static /* synthetic */ int access$000(ExpandableBehavior r0) {
        return r0.currentState;
    }

    private boolean didStateChange(boolean r3) {
        int r2 = this.currentState;
        if (r3 == false) goto L9;
        if (r2 == 0) goto L8;
        if (r2 == 2) goto L8;
        return false;
    L8:
        return true;
    L9:
        if (r2 == 1) goto L11;
        return false;
    L11:
        return true;
    }

    public static <T extends ExpandableBehavior> T from(View r3, Class<T> r4) {
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, CoordinatorLayout.LayoutParams.class) == false) goto L11;
        CoordinatorLayout.Behavior r6 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r6, ExpandableBehavior.class) == false) goto L9;
        return (T) ZeusTransformUtils.preCheckCast(r4.cast(r6), ExpandableBehavior.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public b findExpandableWidget(CoordinatorLayout r7, View r8) {
        List<View> r0 = r7.getDependencies(r8);
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r0.get(r2), View.class, "com.obric.memorydata.plugin");
        if (layoutDependsOn(r7, r8, r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r3, View r4, View r5) {
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (didStateChange(r6.isExpanded()) == true) goto L5;
        return false;
    L5:
        if (r6.isExpanded() == false) goto L7;
        int r7 = 1;
    L8:
        this.currentState = r7;
        return onExpandedStateChange((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), r4, r6.isExpanded(), true);
    L7:
        r7 = 2;
        goto L8
    }

    public abstract boolean onExpandedStateChange(View r1, View r2, boolean r3, boolean r4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r3, final View r4, int r5) {
        if (ViewCompat.isLaidOut(r4) == true) goto L15;
        final b r6 = findExpandableWidget(r3, r4);
        if (r6 != null) goto L7;
        return false;
    L7:
        if (didStateChange(r6.isExpanded()) == true) goto L9;
        return false;
    L9:
        if (r6.isExpanded() == false) goto L11;
        final int r7 = 1;
    L12:
        this.currentState = r7;
        r4.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this, r4, r7, r6));
        return false;
    L11:
        r7 = 2;
        goto L12
    L15:
        return false;
    }
}
