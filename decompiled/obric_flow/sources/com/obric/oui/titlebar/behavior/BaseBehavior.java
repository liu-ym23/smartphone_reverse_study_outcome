package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.obric.oui.panel.f;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f14843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SavedState f14844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference f14845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14846n;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final boolean canDragView(View r5) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
            WeakReference r11 = this.f14845m;
            if (r11 == null) goto L13;
            View r12 = (View) r11.get();
            if (r12 != null) goto L7;
        L11:
            return false;
        L7:
            if (r12.isShown() == false) goto L11;
            if (r12.canScrollVertically(-1) == true) goto L11;
            return true;
        L13:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getMaxDragOffset(View r5) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
            int r11 = -r10.getDownNestedScrollRange();
            return r10.getTopInset() + r11;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getScrollRangeForDragFling(View r5) {
            return ((OUnitedTitleBar) r5).getTotalScrollRange();
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout r5, View r10) {
            i(r5, (OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r5, View r10, int r11) {
            b(r5, (OUnitedTitleBar) r10, r11);
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r5, View r10, int r11, int r12, int r13, int r14) {
            return c(r5, (OUnitedTitleBar) r10, r11, r12, r13, r14);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r5, View r10, View r11, int r12, int r13, int[] r14, int r15) {
            d(r5, (OUnitedTitleBar) r10, r13, r14);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int r15, int r16, int r17) {
            OUnitedTitleBar r18 = (OUnitedTitleBar) r11;
            if (r16 >= 0) goto L5;
            int r5 = -r18.getDownNestedScrollRange();
            setHeaderTopBottomOffset(r10, r18, getTopBottomOffsetForScrollingSibling() - r16, r5, 0);
        L5:
            if (r16 != 0) goto L8;
            j(r10, r18);
            return;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r5, View r10, Parcelable r11) {
            e(r5, (OUnitedTitleBar) r10, r11);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r5, View r10) {
            return f(r5, (OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14, int r15) {
            return g(r10, (OUnitedTitleBar) r11, r12, r14, r15);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout r5, View r10, View r11, int r12) {
            OUnitedTitleBar r13 = (OUnitedTitleBar) r10;
            if (this.f14842j != 0) goto L5;
        L6:
            i(r5, r13);
        L7:
            this.f14845m = new WeakReference(r11);
            return;
        L5:
            if (r12 != 1) goto L7;
            goto L6
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r5, View r10, int r11, int r12, int r13) {
            return h(r5, (OUnitedTitleBar) r10, r11, r12, r13);
        }

        public Behavior(Context r5, AttributeSet r10) {
            super(r5, r10);
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14847a;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.f14847a = 1;
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.AppBarLayout_Layout);
            this.f14847a = r11.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (r11.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator) == false) goto L5;
            AnimationUtils.loadInterpolator(r5, r11.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        L5:
            r11.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14850c;
        public float d;
        public boolean e;

        static {
            CREATOR = new d();
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            boolean r11 = false;
            if (r5.readByte() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.f14848a = r12;
            if (r5.readByte() == 0) goto L9;
            boolean r13 = true;
        L10:
            this.f14849b = r13;
            this.f14850c = r5.readInt();
            this.d = r5.readFloat();
            if (r5.readByte() == 0) goto L13;
            r11 = true;
        L13:
            this.e = r11;
            return;
        L9:
            r13 = false;
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeByte(this.f14848a ? 1 : 0);
            r5.writeByte(this.f14849b ? 1 : 0);
            r5.writeInt(this.f14850c);
            r5.writeFloat(this.d);
            r5.writeByte(this.e ? 1 : 0);
        }
    }

    public BaseBehavior() {
    }

    public static void k(OUnitedTitleBar r5, int r10, int r11, boolean r12) {
        int r13 = Math.abs(r10);
        int r14 = r5.getChildCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L10;
        View r16 = r5.getChildAt(r15);
        if (r13 < r16.getTop()) goto L9;
        if (r13 > r16.getBottom()) goto L9;
    L11:
        if (r16 == null) goto L22;
        int r17 = ((LayoutParams) r16.getLayoutParams()).f14847a;
        if ((r17 & 1) == 0) goto L22;
        ViewCompat.getMinimumHeight(r16);
        if (r11 <= 0) goto L20;
        if ((r17 & 12) == 0) goto L20;
        r16.getBottom();
        r5.getTopInset();
    L20:
        if ((r17 & 2) == 0) goto L22;
        r16.getBottom();
        r5.getTopInset();
    L22:
        if (r12 == true) goto L25;
        return;
    L25:
        if (r5.getBackground() == null) goto L28;
        r5.getBackground().jumpToCurrentState();
    L28:
        if (r5.getForeground() == null) goto L31;
        r5.getForeground().jumpToCurrentState();
    L31:
        if (r5.getStateListAnimator() == null) goto L38;
        r5.getStateListAnimator().jumpToCurrentState();
        return;
    L38:
        return;
    L9:
        r15 = r15 + 1;
        goto L3
    L10:
        r16 = null;
        goto L11
    }

    public final void a(CoordinatorLayout r5, OUnitedTitleBar r10, int r11) {
        int r12 = Math.abs(getTopAndBottomOffset() - r11);
        float r13 = Math.abs(0.0f);
        if (r13 <= 0.0f) goto L5;
        int r14 = Math.round((r12 / r13) * 1000.0f) * 3;
    L6:
        int r15 = getTopAndBottomOffset();
        if (r15 != r11) goto L13;
        ValueAnimator r16 = this.f14843k;
        if (r16 != null) goto L11;
        return;
    L11:
        if (r16.isRunning() == false) goto L20;
        this.f14843k.cancel();
        return;
    L20:
        return;
    L13:
        ValueAnimator r17 = this.f14843k;
        if (r17 != null) goto L16;
        ValueAnimator r18 = new ValueAnimator();
        this.f14843k = r18;
        r18.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.f14843k.addUpdateListener(new a(this, r5, r10));
    L17:
        this.f14843k.setDuration(Math.min(r14, 600));
        this.f14843k.setIntValues(new int[]{r15, r11});
        this.f14843k.start();
        return;
    L16:
        r17.cancel();
        goto L17
    L5:
        r14 = (int) (((r12 / r10.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    public final boolean b(CoordinatorLayout r5, OUnitedTitleBar r10, int r11) {
        super.onLayoutChild(r5, r10, r11);
        int r12 = r10.getPendingAction();
        SavedState r13 = this.f14844l;
        if (r13 != null) goto L5;
    L17:
        if (r12 != 0) goto L19;
    L33:
        r10.f14827k = 0;
        this.f14844l = null;
        int r14 = MathUtils.clamp(getTopAndBottomOffset(), -r10.getTotalScrollRange(), 0);
        com.airbnb.lottie.parser.moshi.c r15 = this.f14855a;
        if (r15 != null) goto L36;
        this.f14856b = r14;
    L39:
        k(r10, getTopAndBottomOffset(), 0, true);
        r10.c(getTopAndBottomOffset());
        j(r5, r10);
        return true;
    L36:
        if (r15.f1315c == r14) goto L39;
        r15.f1315c = r14;
        r15.f();
        goto L39
    L19:
        if ((r12 & 4) == 0) goto L21;
        boolean r16 = true;
    L23:
        if ((r12 & 1) == 0) goto L29;
        int r17 = -r10.getUpNestedPreScrollRange();
        if (r16 == false) goto L27;
        a(r5, r10, r17);
        goto L33
    L27:
        setHeaderTopBottomOffset(r5, r10, r17);
        goto L33
    L29:
        if ((r12 & 16) == 0) goto L33;
        if (r16 == false) goto L32;
        a(r5, r10, 0);
        goto L33
    L32:
        setHeaderTopBottomOffset(r5, r10, 0);
        goto L33
    L21:
        r16 = false;
        goto L23
    L5:
        if ((r12 & 8) != 0) goto L17;
        if (r13.f14848a == false) goto L10;
        setHeaderTopBottomOffset(r5, r10, -r10.getTotalScrollRange());
        goto L33
    L10:
        if (r13.f14849b == false) goto L12;
        setHeaderTopBottomOffset(r5, r10, 0);
        goto L33
    L12:
        View r18 = r10.getChildAt(r13.f14850c);
        int r19 = -r18.getBottom();
        if (this.f14844l.e == false) goto L15;
        int r20 = (r10.getTopInset() + ViewCompat.getMinimumHeight(r18)) + r19;
    L16:
        setHeaderTopBottomOffset(r5, r10, r20);
        goto L33
    L15:
        r20 = Math.round(r18.getHeight() * this.f14844l.d) + r19;
        goto L16
    }

    public final boolean c(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, int r14, int r15) {
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r11.getLayoutParams())).height != (-2)) goto L7;
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(0, 0), r15);
        return true;
    L7:
        return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public boolean canDragView(View r5) {
        OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
        WeakReference r11 = this.f14845m;
        if (r11 == null) goto L13;
        View r12 = (View) r11.get();
        if (r12 != null) goto L7;
    L11:
        return false;
    L7:
        if (r12.isShown() == false) goto L11;
        if (r12.canScrollVertically(-1) == true) goto L11;
        return true;
    L13:
        return true;
    }

    public final void d(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int[] r13) {
        if (r12 == 0) goto L9;
        if (r12 >= 0) goto L6;
        int r5 = -r11.getTotalScrollRange();
        int r14 = r11.getDownNestedPreScrollRange() + r5;
    L5:
        int r15 = r5;
        int r16 = r14;
        if (r15 == r16) goto L9;
        r13[1] = setHeaderTopBottomOffset(r10, r11, getTopBottomOffsetForScrollingSibling() - r12, r15, r16);
        goto L9
    L6:
        r5 = -r11.getUpNestedPreScrollRange();
        r14 = 0;
    L9:
        r11.getClass();
    }

    public final void e(CoordinatorLayout r5, OUnitedTitleBar r10, Parcelable r11) {
        if ((r11 instanceof SavedState) == false) goto L5;
        SavedState r12 = (SavedState) r11;
        this.f14844l = r12;
        super.onRestoreInstanceState(r5, r10, r12.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r5, r10, r11);
        this.f14844l = null;
    }

    public final Parcelable f(CoordinatorLayout r10, OUnitedTitleBar r11) {
        Parcelable r12 = super.onSaveInstanceState(r10, r11);
        int r13 = getTopAndBottomOffset();
        int r5 = r11.getChildCount();
        boolean r14 = false;
        int r15 = 0;
    L3:
        if (r15 >= r5) goto L26;
        View r16 = r11.getChildAt(r15);
        int r17 = r16.getBottom() + r13;
        if ((r16.getTop() + r13) > 0) goto L25;
        if (r17 < 0) goto L25;
        if (r12 != null) goto L10;
        Parcelable r18 = AbsSavedState.EMPTY_STATE;
    L11:
        SavedState r19 = new SavedState(r18);
        if (r13 != 0) goto L14;
        boolean r20 = true;
    L15:
        r19.f14849b = r20;
        if (r20 == false) goto L18;
    L20:
        boolean r21 = false;
    L21:
        r19.f14848a = r21;
        r19.f14850c = r15;
        if (r17 != (r11.getTopInset() + ViewCompat.getMinimumHeight(r16))) goto L24;
        r14 = true;
    L24:
        r19.e = r14;
        r19.d = r17 / r16.getHeight();
    L27:
        if (r19 != null) goto L30;
        return r12;
    L30:
        return r19;
    L18:
        if ((-r13) < r11.getTotalScrollRange()) goto L20;
        r21 = true;
        goto L21
    L14:
        r20 = false;
        goto L15
    L10:
        r18 = r12;
    L25:
        r15 = r15 + 1;
        goto L3
    L26:
        r19 = null;
        goto L27
    }

    public final boolean g(CoordinatorLayout r5, OUnitedTitleBar r10, View r11, int r12, int r13) {
        if ((r12 & 2) == 0) goto L9;
        r10.getClass();
        if (r10.getTotalScrollRange() == 0) goto L9;
        if ((r5.getHeight() - r11.getHeight()) > r10.getHeight()) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == false) goto L14;
        ValueAnimator r15 = this.f14843k;
        if (r15 == null) goto L14;
        r15.cancel();
    L14:
        this.f14845m = null;
        this.f14842j = r13;
        return r14;
    L9:
        r14 = false;
        goto L10
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getMaxDragOffset(View r5) {
        OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
        int r11 = -r10.getDownNestedScrollRange();
        return r10.getTopInset() + r11;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getScrollRangeForDragFling(View r5) {
        return ((OUnitedTitleBar) r5).getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public final int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public final int h(CoordinatorLayout r5, OUnitedTitleBar r10, int r11, int r12, int r13) {
        int r14 = getTopAndBottomOffset();
        int r15 = 0;
        if (r12 == 0) goto L25;
        if (r14 < r12) goto L25;
        if (r14 > r13) goto L25;
        int r16 = MathUtils.clamp(r11, r12, r13);
        if (r14 == r16) goto L25;
        r10.getClass();
        com.airbnb.lottie.parser.moshi.c r17 = this.f14855a;
        int r18 = 1;
        if (r17 != null) goto L11;
        this.f14856b = r16;
    L14:
        boolean r19 = false;
    L15:
        int r20 = r14 - r16;
        if (r19 == false) goto L21;
        int r21 = 0;
    L19:
        if (r21 >= r10.getChildCount()) goto L21;
        ((LayoutParams) r10.getChildAt(r21).getLayoutParams()).getClass();
        r21 = r21 + 1;
    L21:
        r10.c(getTopAndBottomOffset());
        if (r16 >= r14) goto L24;
        r18 = -1;
    L24:
        k(r10, r16, r18, false);
        r15 = r20;
        goto L25
    L11:
        if (r17.f1315c == r16) goto L14;
        r17.f1315c = r16;
        r17.f();
        r19 = true;
    L25:
        j(r5, r10);
        return r15;
    }

    public final void i(CoordinatorLayout r13, OUnitedTitleBar r14) {
        int r5 = r14.getPaddingTop() + r14.getTopInset();
        int r10 = getTopAndBottomOffset() - r5;
        int r11 = r14.getChildCount();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L13;
        View r15 = r14.getChildAt(r12);
        int r16 = r15.getTop();
        int r17 = r15.getBottom();
        LayoutParams r18 = (LayoutParams) r15.getLayoutParams();
        if ((r18.f14847a & 32) != 32) goto L8;
        r16 = r16 - ((FrameLayout.LayoutParams) r18).topMargin;
        r17 = r17 + ((FrameLayout.LayoutParams) r18).bottomMargin;
    L8:
        int r19 = -r10;
        if (r16 > r19) goto L12;
        if (r17 < r19) goto L12;
    L14:
        if (r12 < 0) goto L45;
        View r20 = r14.getChildAt(r12);
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        int r22 = r21.f14847a;
        if ((r22 & 17) != 17) goto L46;
        int r23 = -r20.getTop();
        int r24 = -r20.getBottom();
        if (r12 != 0) goto L25;
        if (ViewCompat.getFitsSystemWindows(r14) == false) goto L25;
        if (ViewCompat.getFitsSystemWindows(r20) == false) goto L25;
        r23 = r23 - r14.getTopInset();
    L25:
        if ((r22 & 2) != 2) goto L28;
        r24 = r24 + ViewCompat.getMinimumHeight(r20);
    L34:
        if ((r22 & 32) != 32) goto L37;
        r23 = r23 + ((FrameLayout.LayoutParams) r21).topMargin;
        r24 = r24 - ((FrameLayout.LayoutParams) r21).bottomMargin;
    L37:
        if (r10 >= ((r24 + r23) / 2)) goto L39;
        r23 = r24;
    L39:
        a(r13, r14, MathUtils.clamp(r23 + r5, -r14.getTotalScrollRange(), 0));
        return;
    L28:
        if ((r22 & 5) != 5) goto L34;
        int r25 = ViewCompat.getMinimumHeight(r20) + r24;
        if (r10 >= r25) goto L32;
        r23 = r25;
        goto L34
    L32:
        r24 = r25;
        goto L34
    L46:
        return;
    L45:
        return;
    L12:
        r12 = r12 + 1;
        goto L4
    L13:
        r12 = -1;
        goto L14
    }

    public final void j(CoordinatorLayout r12, OUnitedTitleBar r13) {
        ViewCompat.removeAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r13.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        int r5 = r12.getChildCount();
        boolean r10 = false;
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L12;
        View r14 = r12.getChildAt(r11);
        if ((((CoordinatorLayout.LayoutParams) r14.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        View r15 = r14;
    L13:
        if (r15 != null) goto L15;
        return;
    L15:
        int r16 = r13.getChildCount();
        int r17 = 0;
    L16:
        if (r17 >= r16) goto L37;
        if (((LayoutParams) r13.getChildAt(r17).getLayoutParams()).f14847a != 0) goto L20;
        r17 = r17 + 1;
        goto L16
    L20:
        if (ViewCompat.hasAccessibilityDelegate(r12) == true) goto L22;
        ViewCompat.setAccessibilityDelegate(r12, new f(this, 2));
    L22:
        boolean r18 = true;
        if (getTopAndBottomOffset() == (-r13.getTotalScrollRange())) goto L26;
        ViewCompat.replaceAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, null, new c(r13, false));
        r10 = true;
    L26:
        if (getTopAndBottomOffset() != 0) goto L28;
    L33:
        r18 = r10;
    L34:
        this.f14846n = r18;
        return;
    L28:
        if (r15.canScrollVertically(-1) == false) goto L32;
        int r19 = -r13.getDownNestedPreScrollRange();
        if (r19 == 0) goto L33;
        ViewCompat.replaceAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(this, r12, r13, r15, r19));
        goto L34
    L32:
        ViewCompat.replaceAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new c(r13, true));
        goto L34
    L37:
        return;
    L12:
        r15 = null;
        goto L13
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public void onFlingFinished(CoordinatorLayout r5, View r10) {
        i(r5, (OUnitedTitleBar) r10);
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r5, View r10, int r11) {
        b(r5, (OUnitedTitleBar) r10, r11);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r5, View r10, int r11, int r12, int r13, int r14) {
        return c(r5, (OUnitedTitleBar) r10, r11, r12, r13, r14);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r5, View r10, View r11, int r12, int r13, int[] r14, int r15) {
        d(r5, (OUnitedTitleBar) r10, r13, r14);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int r15, int r16, int r17) {
        OUnitedTitleBar r18 = (OUnitedTitleBar) r11;
        if (r16 >= 0) goto L5;
        int r5 = -r18.getDownNestedScrollRange();
        setHeaderTopBottomOffset(r10, r18, getTopBottomOffsetForScrollingSibling() - r16, r5, 0);
    L5:
        if (r16 != 0) goto L8;
        j(r10, r18);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r5, View r10, Parcelable r11) {
        e(r5, (OUnitedTitleBar) r10, r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r5, View r10) {
        return f(r5, (OUnitedTitleBar) r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14, int r15) {
        return g(r10, (OUnitedTitleBar) r11, r12, r14, r15);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r5, View r10, View r11, int r12) {
        OUnitedTitleBar r13 = (OUnitedTitleBar) r10;
        if (this.f14842j != 0) goto L5;
    L6:
        i(r5, r13);
    L7:
        this.f14845m = new WeakReference(r11);
        return;
    L5:
        if (r12 != 1) goto L7;
        goto L6
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r5, View r10, int r11, int r12, int r13) {
        return h(r5, (OUnitedTitleBar) r10, r11, r12, r13);
    }

    public BaseBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
    }
}
