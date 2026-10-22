package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.memorydata.plugin.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private boolean coordinatorLayoutA11yScrollable;
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    public int offsetDelta;
    private a onDragCallback;
    private SavedState savedState;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ boolean canDragView(View r3) {
            return super.canDragView((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int getMaxDragOffset(View r3) {
            return super.getMaxDragOffset((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int getScrollRangeForDragFling(View r3) {
            return super.getScrollRangeForDragFling((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ void onFlingFinished(CoordinatorLayout r3, View r4) {
            super.onFlingFinished(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
            return super.onLayoutChild(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onMeasureChild(CoordinatorLayout r8, View r9, int r10, int r11, int r12, int r13) {
            return super.onMeasureChild(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onNestedPreScroll(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int[] r14, int r15) {
            super.onNestedPreScroll(r9, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r10, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, r15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onNestedScroll(CoordinatorLayout r11, View r12, View r13, int r14, int r15, int r16, int r17, int r18) {
            super.onNestedScroll(r11, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r12, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r13, r14, r15, r16, r17, r18);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r3, View r4, Parcelable r5) {
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin");
            super.onRestoreInstanceState(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r3, View r4) {
            return super.onSaveInstanceState(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r8, View r9, View r10, View r11, int r12, int r13) {
            return super.onStartNestedScroll(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onStopNestedScroll(CoordinatorLayout r3, View r4, View r5, int r6) {
            super.onStopNestedScroll(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r5, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
            return super.setHeaderTopBottomOffset(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r9, r10, r11);
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f14777b;
        private b c;

        public LayoutParams(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r7, r8);
            this.f14776a = 1;
            TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.AppBarLayout_Layout);
            this.f14776a = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollFlags, "styleable", "AppBarLayout_Layout_layout_scrollFlags"), 0);
            a(0);
            if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, "styleable", "AppBarLayout_Layout_layout_scrollInterpolator")) == false) goto L5;
            this.f14777b = AnimationUtils.loadInterpolator(r7, r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, "styleable", "AppBarLayout_Layout_layout_scrollInterpolator"), 0));
        L5:
            r9.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.f14776a = 1;
        }

        private b b(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new c();
        }

        public int a() {
            return this.f14776a;
        }

        public void a(int r1) {
            this.c = b(r1);
        }

        public b b() {
            return this.c;
        }

        public Interpolator c() {
            return this.f14777b;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean firstVisibleChildAtMinimumHeight;
        int firstVisibleChildIndex;
        float firstVisibleChildPercentageShown;
        boolean fullyExpanded;
        boolean fullyScrolled;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            boolean r0 = true;
            if (r3.readByte() == 0) goto L5;
            boolean r5 = true;
        L6:
            this.fullyScrolled = r5;
            if (r3.readByte() == 0) goto L9;
            boolean r6 = true;
        L10:
            this.fullyExpanded = r6;
            this.firstVisibleChildIndex = r3.readInt();
            this.firstVisibleChildPercentageShown = r3.readFloat();
            if (r3.readByte() != 0) goto L14;
            r0 = false;
        L14:
            this.firstVisibleChildAtMinimumHeight = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.fullyScrolled ? 1 : 0);
            r1.writeByte(this.fullyExpanded ? 1 : 0);
            r1.writeInt(this.firstVisibleChildIndex);
            r1.writeFloat(this.firstVisibleChildPercentageShown);
            r1.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
        }
    }

    public static abstract class a<T extends OUnitedTitleBar> {
        public abstract boolean a(T r1);
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(OUnitedTitleBar r1, View r2, float r3);
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f14778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f14779b;

        public c() {
            this.f14778a = new Rect();
            this.f14779b = new Rect();
        }

        private static void a(Rect r0, OUnitedTitleBar r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior.b
        public void a(OUnitedTitleBar r4, View r5, float r6) {
            a(this.f14778a, r4, r5);
            float r7 = this.f14778a.top - Math.abs(r6);
            if (r7 > 0.0f) goto L9;
            float r8 = 1.0f - MathUtils.clamp(Math.abs(r7 / this.f14778a.height()), 0.0f, 1.0f);
            float r9 = (-r7) - ((this.f14778a.height() * 0.3f) * (1.0f - (r8 * r8)));
            r5.setTranslationY(r9);
            r5.getDrawingRect(this.f14779b);
            this.f14779b.offset(0, (int) (-r9));
            if (r9 < this.f14779b.height()) goto L7;
            r5.setVisibility(4);
        L8:
            ViewCompat.setClipBounds(r5, this.f14779b);
            return;
        L7:
            r5.setVisibility(0);
            goto L8
        L9:
            ViewCompat.setClipBounds(r5, null);
            r5.setTranslationY(0.0f);
            r5.setVisibility(0);
        }
    }

    public BaseBehavior() {
    }

    public BaseBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean access$000(BaseBehavior r0) {
        return r0.coordinatorLayoutA11yScrollable;
    }

    private boolean addAccessibilityScrollActions(final CoordinatorLayout r11, final T r12, final View r13) {
        boolean r2 = false;
        if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
        addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        r2 = true;
    L6:
        if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
        if (r13.canScrollVertically(-1) == false) goto L12;
        final int r9 = -r12.getDownNestedPreScrollRange();
        if (r9 == 0) goto L14;
        ViewCompat.replaceAccessibilityAction(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass3(this, r11, r12, r13, r9));
        return true;
    L12:
        addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        return true;
    L14:
        return r2;
    }

    private void addActionToExpand(CoordinatorLayout r2, final T r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat r4, final boolean r5) {
        ViewCompat.replaceAccessibilityAction(r2, r4, null, new AnonymousClass4(this, r3, r5));
    }

    private void animateOffsetTo(CoordinatorLayout r3, T r4, int r5, float r6) {
        int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
        float r7 = Math.abs(r6);
        if (r7 <= 0.0f) goto L5;
        int r8 = Math.round((r0 / r7) * 1000.0f) * 3;
    L6:
        animateOffsetWithDuration(r3, r4, r5, r8);
        return;
    L5:
        r8 = (int) (((r0 / r4.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    private void animateOffsetWithDuration(final CoordinatorLayout r4, final T r5, int r6, int r7) {
        int r0 = getTopBottomOffsetForScrollingSibling();
        if (r0 != r6) goto L10;
        ValueAnimator r8 = this.offsetAnimator;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isRunning() == false) goto L17;
        this.offsetAnimator.cancel();
        return;
    L17:
        return;
    L10:
        ValueAnimator r1 = this.offsetAnimator;
        if (r1 != null) goto L13;
        ValueAnimator r2 = new ValueAnimator();
        this.offsetAnimator = r2;
        r2.setInterpolator(com.google.android.material.a.a.e);
        this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r4, r5));
    L14:
        this.offsetAnimator.setDuration(Math.min(r7, 600));
        this.offsetAnimator.setIntValues(new int[]{r0, r6});
        this.offsetAnimator.start();
        return;
    L13:
        r1.cancel();
        goto L14
    }

    private int calculateSnapOffset(int r1, int r2, int r3) {
        if (r1 >= ((r2 + r3) / 2)) goto L6;
        return r2;
    L6:
        return r3;
    }

    private boolean canScrollChildren(CoordinatorLayout r1, T r2, View r3) {
        if (r2.hasScrollableChildren() == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
        return true;
    }

    private static boolean checkFlag(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean childrenHaveScrollFlags(OUnitedTitleBar r6) {
        int r5 = r6.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L9;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).f14776a != 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private View findFirstScrollingChild(CoordinatorLayout r4) {
        int r3 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L13;
        View r1 = r4.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(r1, NestedScrollingChild.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, AbsListView.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, ScrollView.class) == true) goto L12;
        r0 = r0 + 1;
    L12:
        return r1;
    L13:
        return null;
    }

    private static View getAppBarChildOnOffset(OUnitedTitleBar r4, int r5) {
        int r6 = Math.abs(r5);
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = r4.getChildAt(r1);
        if (r6 < r2.getTop()) goto L9;
        if (r6 > r2.getBottom()) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private int getChildIndexOnOffset(T r7, int r8) {
        int r6 = r7.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L12;
        View r1 = r7.getChildAt(r0);
        int r2 = r1.getTop();
        int r3 = r1.getBottom();
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (checkFlag(r4.a(), 32) == false) goto L7;
        r2 = r2 - r4.topMargin;
        r3 = r3 + r4.bottomMargin;
    L7:
        int r5 = -r8;
        if (r2 > r5) goto L11;
        if (r3 < r5) goto L11;
        return r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L12:
        return -1;
    }

    private View getChildWithScrollingBehavior(CoordinatorLayout r6) {
        int r5 = r6.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L8;
        View r1 = r6.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior(), ScrollingViewBehavior.class) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    private int interpolateOffset(T r8, int r9) {
        int r7 = Math.abs(r9);
        int r0 = r8.getChildCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        View r3 = r8.getChildAt(r2);
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        Interpolator r5 = r4.c();
        if (r7 < r3.getTop()) goto L20;
        if (r7 > r3.getBottom()) goto L20;
        if (r5 == null) goto L21;
        int r6 = r4.a();
        if ((r6 & 1) == 0) goto L15;
        r1 = 0 + ((r3.getHeight() + r4.topMargin) + r4.bottomMargin);
        if ((r6 & 2) == 0) goto L15;
        r1 = r1 - ViewCompat.getMinimumHeight(r3);
    L15:
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L17;
        r1 = r1 - r8.getTopInset();
    L17:
        if (r1 <= 0) goto L21;
        float r10 = r1;
        return Integer.signum(r9) * (r3.getTop() + Math.round(r10 * r5.getInterpolation((r7 - r3.getTop()) / r10)));
    L20:
        r2 = r2 + 1;
    L21:
        return r9;
    }

    private boolean shouldJumpElevationState(CoordinatorLayout r5, T r6) {
        List<View> r4 = r5.getDependents(r6);
        int r7 = r4.size();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L11;
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(((View) ZeusTransformUtils.preCheckCast(r4.get(r0), View.class, "com.obric.memorydata.plugin")).getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r1, ScrollingViewBehavior.class) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (((ScrollingViewBehavior) ZeusTransformUtils.preCheckCast(r1, ScrollingViewBehavior.class, "com.obric.memorydata.plugin")).getOverlayTop() == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    private void snapToChildIfNeeded(CoordinatorLayout r9, T r10) {
        int r0 = r10.getTopInset() + r10.getPaddingTop();
        int r1 = getTopBottomOffsetForScrollingSibling() - r0;
        int r2 = getChildIndexOnOffset(r10, r1);
        if (r2 < 0) goto L27;
        View r3 = r10.getChildAt(r2);
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r5 = r4.a();
        if ((r5 & 17) != 17) goto L28;
        int r6 = -r3.getTop();
        int r7 = -r3.getBottom();
        if (r2 != 0) goto L14;
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L14;
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L14;
        r6 = r6 - r10.getTopInset();
    L14:
        if (checkFlag(r5, 2) == false) goto L17;
        r7 = r7 + ViewCompat.getMinimumHeight(r3);
    L23:
        if (checkFlag(r5, 32) == false) goto L25;
        r6 = r6 + r4.topMargin;
        r7 = r7 - r4.bottomMargin;
    L25:
        animateOffsetTo(r9, r10, MathUtils.clamp(calculateSnapOffset(r1, r7, r6) + r0, -r10.getTotalScrollRange(), 0), 0.0f);
        return;
    L17:
        if (checkFlag(r5, 5) == false) goto L23;
        int r8 = ViewCompat.getMinimumHeight(r3) + r7;
        if (r1 >= r8) goto L21;
        r6 = r8;
        goto L23
    L21:
        r7 = r8;
        goto L23
    L28:
        return;
    }

    private void updateAccessibilityActions(CoordinatorLayout r3, T r4) {
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r4.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        View r0 = getChildWithScrollingBehavior(r3);
        if (r0 != null) goto L9;
        return;
    L9:
        if (childrenHaveScrollFlags(r4) == true) goto L12;
        return;
    L12:
        if (ViewCompat.hasAccessibilityDelegate(r3) == true) goto L14;
        ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass2(this));
    L14:
        this.coordinatorLayoutA11yScrollable = addAccessibilityScrollActions(r3, r4, r0);
    }

    private void updateOUnitedTitleBarDrawableState(CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
        View r0 = getAppBarChildOnOffset(r7, r8);
        boolean r1 = false;
        if (r0 == null) goto L19;
        int r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).a();
        if ((r2 & 1) == 0) goto L19;
        int r3 = ViewCompat.getMinimumHeight(r0);
        if (r9 <= 0) goto L14;
        if ((r2 & 12) == 0) goto L14;
        if ((-r8) < ((r0.getBottom() - r3) - r7.getTopInset())) goto L19;
    L12:
        r1 = true;
    L14:
        if ((r2 & 2) == 0) goto L19;
        if ((-r8) >= ((r0.getBottom() - r3) - r7.getTopInset())) goto L12;
    L19:
        if (r7.isLiftOnScroll() == false) goto L21;
        r1 = r7.shouldLift(findFirstScrollingChild(r6));
    L21:
        boolean r11 = r7.setLiftedState(r1);
        if (r10 == true) goto L27;
        if (r11 == true) goto L25;
        return;
    L25:
        if (shouldJumpElevationState(r6, r7) == true) goto L27;
        return;
    L27:
        if (r7.getBackground() == null) goto L30;
        r7.getBackground().jumpToCurrentState();
    L30:
        if (Build.VERSION.SDK_INT < 23) goto L35;
        if (r7.getForeground() == null) goto L35;
        r7.getForeground().jumpToCurrentState();
    L35:
        if (Build.VERSION.SDK_INT >= 21) goto L37;
        return;
    L37:
        if (r7.getStateListAnimator() == null) goto L43;
        r7.getStateListAnimator().jumpToCurrentState();
        return;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ boolean canDragView(View r3) {
        return canDragView((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
    }

    public boolean canDragView(T r3) {
        a r0 = this.onDragCallback;
        if (r0 != null) goto L5;
        WeakReference<View> r2 = this.lastNestedScrollingChildRef;
        if (r2 == null) goto L17;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
    L15:
        return false;
    L11:
        if (r4.isShown() == false) goto L15;
        if (r4.canScrollVertically(-1) == true) goto L15;
        return true;
    L17:
        return true;
    L5:
        return r0.a(r3);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ int getMaxDragOffset(View r3) {
        return getMaxDragOffset((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
    }

    public int getMaxDragOffset(T r1) {
        return (-r1.getDownNestedScrollRange()) + r1.getTopInset();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ int getScrollRangeForDragFling(View r3) {
        return getScrollRangeForDragFling((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
    }

    public int getScrollRangeForDragFling(T r1) {
        return r1.getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.offsetDelta;
    }

    boolean isOffsetAnimatorRunning() {
        ValueAnimator r0 = this.offsetAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ void onFlingFinished(CoordinatorLayout r3, View r4) {
        onFlingFinished(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
    }

    public void onFlingFinished(CoordinatorLayout r2, T r3) {
        snapToChildIfNeeded(r2, r3);
        if (r3.isLiftOnScroll() == false) goto L6;
        r3.setLiftedState(r3.shouldLift(findFirstScrollingChild(r2)));
        return;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
        return onLayoutChild(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r5);
    }

    public boolean onLayoutChild(CoordinatorLayout r8, T r9, int r10) {
        boolean r11 = super.onLayoutChild(r8, r9, r10);
        int r0 = r9.getPendingAction();
        SavedState r1 = this.savedState;
        if (r1 != null) goto L5;
    L18:
        if (r0 != 0) goto L20;
    L32:
        r9.resetPendingAction();
        this.savedState = null;
        setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r9.getTotalScrollRange(), 0));
        updateOUnitedTitleBarDrawableState(r8, r9, getTopAndBottomOffset(), 0, true);
        r9.dispatchOffsetChange(getTopAndBottomOffset());
        updateAccessibilityActions(r8, r9);
        return r11;
    L20:
        if ((r0 & 4) == 0) goto L22;
        boolean r2 = true;
    L24:
        if ((r0 & 1) == 0) goto L29;
        int r3 = -r9.getUpNestedPreScrollRange();
        if (r2 == true) goto L27;
    L9:
        setHeaderTopBottomOffset(r8, r9, r3);
        goto L32
    L27:
        animateOffsetTo(r8, r9, r3, 0.0f);
        goto L32
    L29:
        if ((r0 & 16) == 0) goto L32;
        if (r2 == true) goto L31;
    L12:
        setHeaderTopBottomOffset(r8, r9, 0);
        goto L32
    L31:
        animateOffsetTo(r8, r9, 0, 0.0f);
        goto L32
    L22:
        r2 = false;
        goto L24
    L5:
        if ((r0 & 8) != 0) goto L18;
        if (r1.fullyScrolled == false) goto L11;
        r3 = -r9.getTotalScrollRange();
        goto L9
    L11:
        if (this.savedState.fullyExpanded == true) goto L12;
        View r4 = r9.getChildAt(this.savedState.firstVisibleChildIndex);
        int r5 = -r4.getBottom();
        if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L16;
        int r6 = ViewCompat.getMinimumHeight(r4) + r9.getTopInset();
    L17:
        setHeaderTopBottomOffset(r8, r9, r5 + r6);
        goto L32
    L16:
        r6 = Math.round(r4.getHeight() * this.savedState.firstVisibleChildPercentageShown);
        goto L17
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ boolean onMeasureChild(CoordinatorLayout r8, View r9, int r10, int r11, int r12, int r13) {
        return onMeasureChild(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
    }

    public boolean onMeasureChild(CoordinatorLayout r7, T r8, int r9, int r10, int r11, int r12) {
        if (((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).height != (-2)) goto L7;
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
        return true;
    L7:
        return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ void onNestedPreScroll(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int[] r14, int r15) {
        onNestedPreScroll(r9, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r10, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, r15);
    }

    public void onNestedPreScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int[] r12, int r13) {
        if (r11 == 0) goto L10;
        if (r11 >= 0) goto L5;
        int r14 = -r8.getTotalScrollRange();
        int r15 = r8.getDownNestedPreScrollRange() + r14;
    L6:
        int r4 = r14;
        int r5 = r15;
        if (r4 == r5) goto L10;
        r12[1] = scroll(r7, r8, r11, r4, r5);
        goto L10
    L5:
        r14 = -r8.getUpNestedPreScrollRange();
        r15 = 0;
    L10:
        if (r8.isLiftOnScroll() == false) goto L13;
        r8.setLiftedState(r8.shouldLift(r9));
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ void onNestedScroll(CoordinatorLayout r11, View r12, View r13, int r14, int r15, int r16, int r17, int r18) {
        onNestedScroll(r11, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r12, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r13, r14, r15, r16, r17, r18);
    }

    public void onNestedScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        if (r13 >= 0) goto L4;
        scroll(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
    L4:
        if (r13 != 0) goto L7;
        updateAccessibilityActions(r7, r8);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r3, View r4, Parcelable r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin");
        onRestoreInstanceState(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r6);
    }

    public void onRestoreInstanceState(CoordinatorLayout r3, T r4, Parcelable r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, SavedState.class) == false) goto L5;
        restoreScrollState((SavedState) ZeusTransformUtils.preCheckCast(r6, SavedState.class, "com.obric.memorydata.plugin"), true);
        super.onRestoreInstanceState(r3, r4, this.savedState.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r3, r4, r6);
        this.savedState = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r3, View r4) {
        return onSaveInstanceState(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout r1, T r2) {
        Parcelable r3 = super.onSaveInstanceState(r1, r2);
        SavedState r0 = saveScrollState(r3, r2);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r8, View r9, View r10, View r11, int r12, int r13) {
        return onStartNestedScroll(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
    }

    public boolean onStartNestedScroll(CoordinatorLayout r1, T r2, View r3, View r4, int r5, int r6) {
        if ((r5 & 2) != 0) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L14;
        ValueAnimator r8 = this.offsetAnimator;
        if (r8 == null) goto L14;
        r8.cancel();
    L14:
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = r6;
        return r7;
    L5:
        if (r2.isLiftOnScroll() == false) goto L7;
    L8:
        r7 = true;
        goto L10
    L7:
        if (canScrollChildren(r1, r2, r3) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* synthetic */ void onStopNestedScroll(CoordinatorLayout r3, View r4, View r5, int r6) {
        onStopNestedScroll(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    public void onStopNestedScroll(CoordinatorLayout r2, T r3, View r4, int r5) {
        if (this.lastStartedType != 0) goto L5;
    L6:
        snapToChildIfNeeded(r2, r3);
        if (r3.isLiftOnScroll() == false) goto L9;
        r3.setLiftedState(r3.shouldLift(r4));
    L9:
        this.lastNestedScrollingChildRef = new WeakReference(r4);
        return;
    L5:
        if (r5 != 1) goto L9;
        goto L6
    }

    void restoreScrollState(SavedState r2, boolean r3) {
        if (this.savedState == null) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        this.savedState = r2;
    }

    SavedState saveScrollState(Parcelable r7, T r8) {
        Parcelable r9 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.memorydata.plugin");
        int r6 = getTopAndBottomOffset();
        int r0 = r8.getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        View r3 = r8.getChildAt(r2);
        int r4 = r3.getBottom() + r6;
        if ((r3.getTop() + r6) > 0) goto L25;
        if (r4 < 0) goto L25;
        if (r9 != null) goto L10;
        r9 = AbsSavedState.EMPTY_STATE;
    L10:
        SavedState r5 = new SavedState(r9);
        if (r6 != 0) goto L13;
        boolean r10 = true;
    L14:
        r5.fullyExpanded = r10;
        if (r5.fullyExpanded == false) goto L17;
    L19:
        boolean r11 = false;
    L20:
        r5.fullyScrolled = r11;
        r5.firstVisibleChildIndex = r2;
        if (r4 != (ViewCompat.getMinimumHeight(r3) + r8.getTopInset())) goto L23;
        r1 = true;
    L23:
        r5.firstVisibleChildAtMinimumHeight = r1;
        r5.firstVisibleChildPercentageShown = r4 / r3.getHeight();
        return r5;
    L17:
        if ((-r6) < r8.getTotalScrollRange()) goto L19;
        r11 = true;
        goto L20
    L13:
        r10 = false;
    L25:
        r2 = r2 + 1;
        goto L3
    L26:
        return null;
    }

    public void setDragCallback(a r1) {
        this.onDragCallback = r1;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
        return setHeaderTopBottomOffset(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r9, r10, r11);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r9, T r10, int r11, int r12, int r13) {
        int r0 = getTopBottomOffsetForScrollingSibling();
        int r1 = 0;
        if (r12 == 0) goto L30;
        if (r0 < r12) goto L30;
        if (r0 > r13) goto L30;
        int r5 = MathUtils.clamp(r11, r12, r13);
        if (r0 != r5) goto L9;
    L31:
        updateAccessibilityActions(r9, r10);
        return r1;
    L9:
        if (r10.hasChildWithInterpolator() == false) goto L11;
        int r14 = interpolateOffset(r10, r5);
    L12:
        boolean r15 = setTopAndBottomOffset(r14);
        int r16 = r0 - r5;
        this.offsetDelta = r5 - r14;
        int r17 = 1;
        if (r15 == true) goto L15;
    L22:
        if (r15 == false) goto L24;
    L26:
        r10.dispatchOffsetChange(getTopAndBottomOffset());
        if (r5 >= r0) goto L29;
        r17 = -1;
    L29:
        updateOUnitedTitleBarDrawableState(r9, r10, r5, r17, false);
        r1 = r16;
        goto L31
    L24:
        if (r10.hasChildWithInterpolator() == false) goto L26;
        r9.dispatchDependentViewsChanged(r10);
    L15:
        if (r1 >= r10.getChildCount()) goto L22;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        b r3 = r2.b();
        if (r3 == null) goto L21;
        if ((r2.a() & 1) == 0) goto L21;
        r3.a(r10, r10.getChildAt(r1), getTopAndBottomOffset());
    L21:
        r1 = r1 + 1;
        goto L15
    L11:
        r14 = r5;
    L30:
        this.offsetDelta = 0;
        goto L31
    }
}
