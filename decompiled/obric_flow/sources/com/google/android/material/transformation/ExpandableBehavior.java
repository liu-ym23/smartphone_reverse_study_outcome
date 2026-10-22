package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
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

    public static /* synthetic */ int access$000(ExpandableBehavior r5) {
        return r5.currentState;
    }

    private boolean didStateChange(boolean r5) {
        if (r5 == false) goto L11;
        int r10 = this.currentState;
        if (r10 == 0) goto L9;
        if (r10 == 2) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (this.currentState == 1) goto L13;
        return false;
    L13:
        return true;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View r5, @NonNull Class<T> r10) {
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.LayoutParams) r11).getBehavior();
        if ((r12 instanceof ExpandableBehavior) == false) goto L9;
        return r10.cast(r12);
    L9:
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout r10, @NonNull View r11) {
        List<View> r5 = r10.getDependencies(r11);
        int r12 = r5.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        View r14 = r5.get(r13);
        if (layoutDependsOn(r10, r11, r14) == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return (ExpandableWidget) r14;
    L9:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout r5, View r10, View r11);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout r5, View r10, View r11) {
        ExpandableWidget r12 = (ExpandableWidget) r11;
        if (didStateChange(r12.isExpanded()) == true) goto L5;
        return false;
    L5:
        if (r12.isExpanded() == false) goto L7;
        int r13 = 1;
    L8:
        this.currentState = r13;
        return onExpandedStateChange((View) r12, r10, r12.isExpanded(), true);
    L7:
        r13 = 2;
        goto L8
    }

    public abstract boolean onExpandedStateChange(View r5, View r10, boolean r11, boolean r12);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull final View r10, int r11) {
        if (ViewCompat.isLaidOut(r10) == true) goto L15;
        final ExpandableWidget r12 = findExpandableWidget(r5, r10);
        if (r12 != null) goto L7;
        return false;
    L7:
        if (didStateChange(r12.isExpanded()) == true) goto L9;
        return false;
    L9:
        if (r12.isExpanded() == false) goto L11;
        final int r13 = 1;
    L12:
        this.currentState = r13;
        r10.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this, r10, r13, r12));
        return false;
    L11:
        r13 = 2;
        goto L12
    L15:
        return false;
    }

    public ExpandableBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.currentState = 0;
    }
}
