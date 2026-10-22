package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4081c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f4082g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ x5.a f4083h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ExpandableBehavior f4084i;

        a(ExpandableBehavior r10, View r11, int r12, x5.a r13) {
            this.f4084i = r10;
            this.f4081c = r11;
            this.f4082g = r12;
            this.f4083h = r13;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f4081c.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.access$000(this.f4084i) != this.f4082g) goto L5;
            ExpandableBehavior r10 = this.f4084i;
            x5.a r11 = this.f4083h;
            r10.onExpandedStateChange((View) r11, this.f4081c, r11.isExpanded(), false);
        L5:
            return false;
        }
    }

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.currentState = 0;
    }

    static /* synthetic */ int access$000(ExpandableBehavior r10) {
        return r10.currentState;
    }

    private boolean didStateChange(boolean r10) {
        int r11 = this.currentState;
        if (r10 == false) goto L9;
        if (r11 == 0) goto L8;
        if (r11 == 2) goto L8;
        return false;
    L8:
        return true;
    L9:
        if (r11 == 1) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View r10, @NonNull Class<T> r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r13 = ((CoordinatorLayout.LayoutParams) r12).getBehavior();
        if ((r13 instanceof ExpandableBehavior) == false) goto L9;
        return r11.cast(r13);
    L9:
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected x5.a findExpandableWidget(@NonNull CoordinatorLayout r10, @NonNull View r11) {
        List<View> r12 = r10.getDependencies(r11);
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        View r15 = r12.get(r14);
        if (layoutDependsOn(r10, r11, r15) == true) goto L7;
        r14 = r14 + 1;
        goto L3
    L7:
        return (x5.a) r15;
    L9:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout r10, View r11, View r12) {
        x5.a r13 = (x5.a) r12;
        if (didStateChange(r13.isExpanded()) == true) goto L5;
        return false;
    L5:
        if (r13.isExpanded() == false) goto L7;
        int r14 = 1;
    L8:
        this.currentState = r14;
        return onExpandedStateChange((View) r13, r11, r13.isExpanded(), true);
    L7:
        r14 = 2;
        goto L8
    }

    protected abstract boolean onExpandedStateChange(View r10, View r11, boolean r12, boolean r13);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
        if (ViewCompat.isLaidOut(r11) == true) goto L15;
        x5.a r13 = findExpandableWidget(r10, r11);
        if (r13 != null) goto L7;
        return false;
    L7:
        if (didStateChange(r13.isExpanded()) == true) goto L9;
        return false;
    L9:
        if (r13.isExpanded() == false) goto L11;
        int r14 = 1;
    L12:
        this.currentState = r14;
        r11.getViewTreeObserver().addOnPreDrawListener(new a(this, r11, r14, r13));
        return false;
    L11:
        r14 = 2;
        goto L12
    L15:
        return false;
    }
}
