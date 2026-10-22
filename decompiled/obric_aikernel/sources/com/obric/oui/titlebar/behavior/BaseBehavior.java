package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.ref.WeakReference;
import java.util.List;
import q5.l;

/* JADX INFO: loaded from: classes2.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private boolean coordinatorLayoutA11yScrollable;

    @Nullable
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    public int offsetDelta;
    private b onDragCallback;
    private SavedState savedState;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
            return super.canDragView((OUnitedTitleBar) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r10) {
            return super.getMaxDragOffset((OUnitedTitleBar) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r10) {
            return super.getScrollRangeForDragFling((OUnitedTitleBar) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull View r11) {
            super.onFlingFinished(r10, (OUnitedTitleBar) r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return super.onLayoutChild(r10, (OUnitedTitleBar) r11, r12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
            return super.onMeasureChild(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int[] r15, int r16) {
            super.onNestedPreScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int r15, int r16, int r17) {
            super.onNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16, r17);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11, Parcelable r12) {
            super.onRestoreInstanceState(r10, (OUnitedTitleBar) r11, r12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11) {
            return super.onSaveInstanceState(r10, (OUnitedTitleBar) r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12, View r13, int r14, int r15) {
            return super.onStartNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13) {
            super.onStopNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14) {
            return super.setHeaderTopBottomOffset(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f7726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f7727c;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f7725a = 1;
            TypedArray r12 = r10.obtainStyledAttributes(r11, l.AppBarLayout_Layout);
            this.f7725a = r12.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
            e(0);
            int r13 = l.AppBarLayout_Layout_layout_scrollInterpolator;
            if (r12.hasValue(r13) == false) goto L5;
            this.f7727c = AnimationUtils.loadInterpolator(r10, r12.getResourceId(r13, 0));
        L5:
            r12.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f7725a = 1;
        }

        @Nullable
        private c a(int r10) {
            if (r10 == 1) goto L7;
            return null;
        L7:
            return new d();
        }

        @Nullable
        public c b() {
            return this.f7726b;
        }

        public int c() {
            return this.f7725a;
        }

        public Interpolator d() {
            return this.f7727c;
        }

        public void e(int r10) {
            this.f7726b = a(r10);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean firstVisibleChildAtMinimumHeight;
        int firstVisibleChildIndex;
        float firstVisibleChildPercentageShown;
        boolean fullyExpanded;
        boolean fullyScrolled;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Nullable
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            @NonNull
            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            boolean r12 = true;
            if (r10.readByte() == 0) goto L5;
            boolean r13 = true;
        L6:
            this.fullyScrolled = r13;
            if (r10.readByte() == 0) goto L9;
            boolean r14 = true;
        L10:
            this.fullyExpanded = r14;
            this.firstVisibleChildIndex = r10.readInt();
            this.firstVisibleChildPercentageShown = r10.readFloat();
            if (r10.readByte() != 0) goto L14;
            r12 = false;
        L14:
            this.firstVisibleChildAtMinimumHeight = r12;
            return;
        L9:
            r14 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeByte(this.fullyScrolled ? 1 : 0);
            r10.writeByte(this.fullyExpanded ? 1 : 0);
            r10.writeInt(this.firstVisibleChildIndex);
            r10.writeFloat(this.firstVisibleChildPercentageShown);
            r10.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CoordinatorLayout f7728c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f7729g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BaseBehavior f7730h;

        a(BaseBehavior r10, CoordinatorLayout r11, OUnitedTitleBar r12) {
            this.f7730h = r10;
            this.f7728c = r11;
            this.f7729g = r12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            this.f7730h.setHeaderTopBottomOffset(this.f7728c, this.f7729g, ((Integer) r10.getAnimatedValue()).intValue());
        }
    }

    public static abstract class b<T extends OUnitedTitleBar> {
    }

    public static abstract class c {
        public c() {
        }

        public abstract void a(@NonNull OUnitedTitleBar r10, @NonNull View r11, float r12);
    }

    public static class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f7731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f7732b;

        public d() {
            this.f7731a = new Rect();
            this.f7732b = new Rect();
        }

        private static void b(Rect r10, OUnitedTitleBar r11, View r12) {
            r12.getDrawingRect(r10);
            r11.offsetDescendantRectToMyCoords(r12, r10);
            r10.offset(0, -r11.getTopInset());
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior.c
        public void a(@NonNull OUnitedTitleBar r10, @NonNull View r11, float r12) {
            b(this.f7731a, r10, r11);
            float r13 = this.f7731a.top - Math.abs(r12);
            if (r13 > 0.0f) goto L9;
            float r14 = 1.0f - MathUtils.clamp(Math.abs(r13 / this.f7731a.height()), 0.0f, 1.0f);
            float r15 = (-r13) - ((this.f7731a.height() * 0.3f) * (1.0f - (r14 * r14)));
            r11.setTranslationY(r15);
            r11.getDrawingRect(this.f7732b);
            this.f7732b.offset(0, (int) (-r15));
            if (r15 < this.f7732b.height()) goto L7;
            r11.setVisibility(4);
        L8:
            ViewCompat.setClipBounds(r11, this.f7732b);
            return;
        L7:
            r11.setVisibility(0);
            goto L8
        L9:
            ViewCompat.setClipBounds(r11, null);
            r11.setTranslationY(0.0f);
            r11.setVisibility(0);
        }
    }

    public BaseBehavior() {
    }

    public BaseBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    static /* synthetic */ boolean access$000(BaseBehavior r10) {
        return r10.coordinatorLayoutA11yScrollable;
    }

    private boolean addAccessibilityScrollActions(final CoordinatorLayout r11, @NonNull final T r12, @NonNull final View r13) {
        boolean r10 = false;
        if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
        addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        r10 = true;
    L6:
        if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
        if (r13.canScrollVertically(-1) == false) goto L12;
        final int r14 = -r12.getDownNestedPreScrollRange();
        if (r14 == 0) goto L14;
        ViewCompat.replaceAccessibilityAction(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass3(this, r11, r12, r13, r14));
        return true;
    L12:
        addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        return true;
    L14:
        return r10;
    }

    private void addActionToExpand(CoordinatorLayout r10, @NonNull final T r11, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r12, final boolean r13) {
        ViewCompat.replaceAccessibilityAction(r10, r12, null, new AnonymousClass4(this, r11, r13));
    }

    private void animateOffsetTo(CoordinatorLayout r10, @NonNull T r11, int r12, float r13) {
        int r14 = Math.abs(getTopBottomOffsetForScrollingSibling() - r12);
        float r15 = Math.abs(r13);
        if (r15 <= 0.0f) goto L5;
        int r16 = Math.round((r14 / r15) * 1000.0f) * 3;
    L6:
        animateOffsetWithDuration(r10, r11, r12, r16);
        return;
    L5:
        r16 = (int) (((r14 / r11.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    @SuppressLint({"RestrictedApi"})
    private void animateOffsetWithDuration(CoordinatorLayout r10, T r11, int r12, int r13) {
        int r14 = getTopBottomOffsetForScrollingSibling();
        if (r14 != r12) goto L10;
        ValueAnimator r15 = this.offsetAnimator;
        if (r15 != null) goto L7;
        return;
    L7:
        if (r15.isRunning() == false) goto L17;
        this.offsetAnimator.cancel();
        return;
    L17:
        return;
    L10:
        ValueAnimator r16 = this.offsetAnimator;
        if (r16 != null) goto L13;
        ValueAnimator r17 = new ValueAnimator();
        this.offsetAnimator = r17;
        r17.setInterpolator(r5.a.f12677e);
        this.offsetAnimator.addUpdateListener(new a(this, r10, r11));
    L14:
        this.offsetAnimator.setDuration(Math.min(r13, 600));
        this.offsetAnimator.setIntValues(new int[]{r14, r12});
        this.offsetAnimator.start();
        return;
    L13:
        r16.cancel();
        goto L14
    }

    private int calculateSnapOffset(int r10, int r11, int r12) {
        if (r10 >= ((r11 + r12) / 2)) goto L6;
        return r11;
    L6:
        return r12;
    }

    private boolean canScrollChildren(@NonNull CoordinatorLayout r10, @NonNull T r11, @NonNull View r12) {
        if (r11.hasScrollableChildren() == true) goto L5;
    L7:
        return false;
    L5:
        if ((r10.getHeight() - r12.getHeight()) > r11.getHeight()) goto L7;
        return true;
    }

    private static boolean checkFlag(int r10, int r11) {
        if ((r10 & r11) != r11) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean childrenHaveScrollFlags(OUnitedTitleBar r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (((LayoutParams) r10.getChildAt(r12).getLayoutParams()).f7725a != 0) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Nullable
    private View findFirstScrollingChild(@NonNull CoordinatorLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof NestedScrollingChild) == true) goto L12;
        if ((r13 instanceof AbsListView) == true) goto L12;
        if ((r13 instanceof ScrollView) == true) goto L12;
        r12 = r12 + 1;
    L12:
        return r13;
    L13:
        return null;
    }

    @Nullable
    private static View getAppBarChildOnOffset(@NonNull OUnitedTitleBar r10, int r11) {
        int r12 = Math.abs(r11);
        int r13 = r10.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L10;
        View r15 = r10.getChildAt(r14);
        if (r12 < r15.getTop()) goto L9;
        if (r12 > r15.getBottom()) goto L9;
        return r15;
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        return null;
    }

    private int getChildIndexOnOffset(@NonNull T r10, int r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        View r14 = r10.getChildAt(r13);
        int r15 = r14.getTop();
        int r16 = r14.getBottom();
        LayoutParams r17 = (LayoutParams) r14.getLayoutParams();
        if (checkFlag(r17.c(), 32) == false) goto L7;
        r15 = r15 - ((FrameLayout.LayoutParams) r17).topMargin;
        r16 = r16 + ((FrameLayout.LayoutParams) r17).bottomMargin;
    L7:
        int r18 = -r11;
        if (r15 > r18) goto L11;
        if (r16 < r18) goto L11;
        return r13;
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return -1;
    }

    @Nullable
    private View getChildWithScrollingBehavior(CoordinatorLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = r10.getChildAt(r12);
        if ((((CoordinatorLayout.LayoutParams) r13.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    private int interpolateOffset(@NonNull T r10, int r11) {
        int r12 = Math.abs(r11);
        int r13 = r10.getChildCount();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L21;
        View r16 = r10.getChildAt(r15);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        Interpolator r18 = r17.d();
        if (r12 < r16.getTop()) goto L20;
        if (r12 > r16.getBottom()) goto L20;
        if (r18 == null) goto L21;
        int r19 = r17.c();
        if ((r19 & 1) == 0) goto L15;
        r14 = 0 + ((r16.getHeight() + ((FrameLayout.LayoutParams) r17).topMargin) + ((FrameLayout.LayoutParams) r17).bottomMargin);
        if ((r19 & 2) == 0) goto L15;
        r14 = r14 - ViewCompat.getMinimumHeight(r16);
    L15:
        if (ViewCompat.getFitsSystemWindows(r16) == false) goto L17;
        r14 = r14 - r10.getTopInset();
    L17:
        if (r14 <= 0) goto L21;
        float r20 = r14;
        return Integer.signum(r11) * (r16.getTop() + Math.round(r20 * r18.getInterpolation((r12 - r16.getTop()) / r20)));
    L20:
        r15 = r15 + 1;
    L21:
        return r11;
    }

    private boolean shouldJumpElevationState(@NonNull CoordinatorLayout r10, @NonNull T r11) {
        List<View> r12 = r10.getDependents(r11);
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        CoordinatorLayout.Behavior r15 = ((CoordinatorLayout.LayoutParams) r12.get(r14).getLayoutParams()).getBehavior();
        if ((r15 instanceof ScrollingViewBehavior) == true) goto L7;
        r14 = r14 + 1;
        goto L3
    L7:
        if (((ScrollingViewBehavior) r15).getOverlayTop() == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    private void snapToChildIfNeeded(CoordinatorLayout r10, @NonNull T r11) {
        int r12 = r11.getTopInset() + r11.getPaddingTop();
        int r13 = getTopBottomOffsetForScrollingSibling() - r12;
        int r14 = getChildIndexOnOffset(r11, r13);
        if (r14 < 0) goto L27;
        View r15 = r11.getChildAt(r14);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        int r17 = r16.c();
        if ((r17 & 17) != 17) goto L28;
        int r18 = -r15.getTop();
        int r19 = -r15.getBottom();
        if (r14 != 0) goto L14;
        if (ViewCompat.getFitsSystemWindows(r11) == false) goto L14;
        if (ViewCompat.getFitsSystemWindows(r15) == false) goto L14;
        r18 = r18 - r11.getTopInset();
    L14:
        if (checkFlag(r17, 2) == false) goto L17;
        r19 = r19 + ViewCompat.getMinimumHeight(r15);
    L23:
        if (checkFlag(r17, 32) == false) goto L25;
        r18 = r18 + ((FrameLayout.LayoutParams) r16).topMargin;
        r19 = r19 - ((FrameLayout.LayoutParams) r16).bottomMargin;
    L25:
        animateOffsetTo(r10, r11, MathUtils.clamp(calculateSnapOffset(r13, r19, r18) + r12, -r11.getTotalScrollRange(), 0), 0.0f);
        return;
    L17:
        if (checkFlag(r17, 5) == false) goto L23;
        int r20 = ViewCompat.getMinimumHeight(r15) + r19;
        if (r13 >= r20) goto L21;
        r18 = r20;
        goto L23
    L21:
        r19 = r20;
        goto L23
    L28:
        return;
    }

    private void updateAccessibilityActions(CoordinatorLayout r10, @NonNull T r11) {
        ViewCompat.removeAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r11.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        View r12 = getChildWithScrollingBehavior(r10);
        if (r12 != null) goto L9;
        return;
    L9:
        if (childrenHaveScrollFlags(r11) == true) goto L12;
        return;
    L12:
        if (ViewCompat.hasAccessibilityDelegate(r10) == true) goto L14;
        ViewCompat.setAccessibilityDelegate(r10, new AnonymousClass2(this));
    L14:
        this.coordinatorLayoutA11yScrollable = addAccessibilityScrollActions(r10, r11, r12);
    }

    private void updateOUnitedTitleBarDrawableState(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, boolean r14) {
        View r15 = getAppBarChildOnOffset(r11, r12);
        boolean r16 = false;
        if (r15 == null) goto L19;
        int r17 = ((LayoutParams) r15.getLayoutParams()).c();
        if ((r17 & 1) == 0) goto L19;
        int r18 = ViewCompat.getMinimumHeight(r15);
        if (r13 <= 0) goto L14;
        if ((r17 & 12) == 0) goto L14;
        if ((-r12) < ((r15.getBottom() - r18) - r11.getTopInset())) goto L19;
    L12:
        r16 = true;
    L14:
        if ((r17 & 2) == 0) goto L19;
        if ((-r12) >= ((r15.getBottom() - r18) - r11.getTopInset())) goto L12;
    L19:
        if (r11.isLiftOnScroll() == false) goto L21;
        r16 = r11.shouldLift(findFirstScrollingChild(r10));
    L21:
        boolean r19 = r11.setLiftedState(r16);
        if (r14 == true) goto L27;
        if (r19 == true) goto L25;
        return;
    L25:
        if (shouldJumpElevationState(r10, r11) == true) goto L27;
        return;
    L27:
        if (r11.getBackground() == null) goto L29;
        r11.getBackground().jumpToCurrentState();
    L29:
        int r20 = Build.VERSION.SDK_INT;
        if (r20 < 23) goto L35;
        if (r11.getForeground() == null) goto L35;
        r11.getForeground().jumpToCurrentState();
    L35:
        if (r20 >= 21) goto L37;
        return;
    L37:
        if (r11.getStateListAnimator() == null) goto L43;
        r11.getStateListAnimator().jumpToCurrentState();
        return;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
        return canDragView((OUnitedTitleBar) r10);
    }

    public boolean canDragView(T r10) {
        WeakReference<View> r11 = this.lastNestedScrollingChildRef;
        if (r11 == null) goto L13;
        View r12 = r11.get();
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

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r10) {
        return getMaxDragOffset((OUnitedTitleBar) r10);
    }

    public int getMaxDragOffset(@NonNull T r10) {
        return (-r10.getDownNestedScrollRange()) + r10.getTopInset();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r10) {
        return getScrollRangeForDragFling((OUnitedTitleBar) r10);
    }

    public int getScrollRangeForDragFling(@NonNull T r10) {
        return r10.getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.offsetDelta;
    }

    @VisibleForTesting
    boolean isOffsetAnimatorRunning() {
        ValueAnimator r10 = this.offsetAnimator;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isRunning() == false) goto L7;
        return true;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull View r11) {
        onFlingFinished(r10, (OUnitedTitleBar) r11);
    }

    public void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull T r11) {
        snapToChildIfNeeded(r10, r11);
        if (r11.isLiftOnScroll() == false) goto L6;
        r11.setLiftedState(r11.shouldLift(findFirstScrollingChild(r10)));
        return;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
        return onLayoutChild(r10, (OUnitedTitleBar) r11, r12);
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12) {
        boolean r13 = super.onLayoutChild(r10, r11, r12);
        int r14 = r11.getPendingAction();
        SavedState r15 = this.savedState;
        if (r15 != null) goto L5;
    L18:
        if (r14 != 0) goto L20;
    L32:
        r11.resetPendingAction();
        this.savedState = null;
        setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r11.getTotalScrollRange(), 0));
        updateOUnitedTitleBarDrawableState(r10, r11, getTopAndBottomOffset(), 0, true);
        r11.dispatchOffsetChange(getTopAndBottomOffset());
        updateAccessibilityActions(r10, r11);
        return r13;
    L20:
        if ((r14 & 4) == 0) goto L22;
        boolean r16 = true;
    L24:
        if ((r14 & 1) == 0) goto L29;
        int r17 = -r11.getUpNestedPreScrollRange();
        if (r16 == true) goto L27;
    L9:
        setHeaderTopBottomOffset(r10, r11, r17);
        goto L32
    L27:
        animateOffsetTo(r10, r11, r17, 0.0f);
        goto L32
    L29:
        if ((r14 & 16) == 0) goto L32;
        if (r16 == true) goto L31;
    L12:
        setHeaderTopBottomOffset(r10, r11, 0);
        goto L32
    L31:
        animateOffsetTo(r10, r11, 0, 0.0f);
        goto L32
    L22:
        r16 = false;
        goto L24
    L5:
        if ((r14 & 8) != 0) goto L18;
        if (r15.fullyScrolled == false) goto L11;
        r17 = -r11.getTotalScrollRange();
        goto L9
    L11:
        if (r15.fullyExpanded == true) goto L12;
        View r18 = r11.getChildAt(r15.firstVisibleChildIndex);
        int r19 = -r18.getBottom();
        if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L16;
        int r20 = ViewCompat.getMinimumHeight(r18) + r11.getTopInset();
    L17:
        setHeaderTopBottomOffset(r10, r11, r19 + r20);
        goto L32
    L16:
        r20 = Math.round(r18.getHeight() * this.savedState.firstVisibleChildPercentageShown);
        goto L17
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
        return onMeasureChild(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
    }

    public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14, int r15) {
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r11.getLayoutParams())).height != (-2)) goto L7;
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(0, 0), r15);
        return true;
    L7:
        return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int[] r15, int r16) {
        onNestedPreScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16);
    }

    public void onNestedPreScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int[] r15, int r16) {
        if (r14 == 0) goto L10;
        if (r14 >= 0) goto L5;
        int r17 = -r11.getTotalScrollRange();
        int r18 = r11.getDownNestedPreScrollRange() + r17;
    L6:
        int r19 = r17;
        int r20 = r18;
        if (r19 == r20) goto L10;
        r15[1] = scroll(r10, r11, r14, r19, r20);
        goto L10
    L5:
        r17 = -r11.getUpNestedPreScrollRange();
        r18 = 0;
    L10:
        if (r11.isLiftOnScroll() == false) goto L13;
        r11.setLiftedState(r11.shouldLift(r12));
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int r15, int r16, int r17) {
        onNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16, r17);
    }

    public void onNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int r15, int r16, int r17) {
        if (r16 >= 0) goto L4;
        scroll(r10, r11, r16, -r11.getDownNestedScrollRange(), 0);
    L4:
        if (r16 != 0) goto L7;
        updateAccessibilityActions(r10, r11);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11, Parcelable r12) {
        onRestoreInstanceState(r10, (OUnitedTitleBar) r11, r12);
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull T r11, Parcelable r12) {
        if ((r12 instanceof SavedState) == false) goto L5;
        restoreScrollState((SavedState) r12, true);
        super.onRestoreInstanceState(r10, r11, this.savedState.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r10, r11, r12);
        this.savedState = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11) {
        return onSaveInstanceState(r10, (OUnitedTitleBar) r11);
    }

    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull T r11) {
        Parcelable r12 = super.onSaveInstanceState(r10, r11);
        SavedState r13 = saveScrollState(r12, r11);
        if (r13 != null) goto L6;
        return r12;
    L6:
        return r13;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12, View r13, int r14, int r15) {
        return onStartNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull T r11, @NonNull View r12, View r13, int r14, int r15) {
        if ((r14 & 2) != 0) goto L5;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == false) goto L14;
        ValueAnimator r17 = this.offsetAnimator;
        if (r17 == null) goto L14;
        r17.cancel();
    L14:
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = r15;
        return r16;
    L5:
        if (r11.isLiftOnScroll() == false) goto L7;
    L8:
        r16 = true;
        goto L10
    L7:
        if (canScrollChildren(r10, r11, r12) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13) {
        onStopNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13);
    }

    public void onStopNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13) {
        if (this.lastStartedType != 0) goto L5;
    L6:
        snapToChildIfNeeded(r10, r11);
        if (r11.isLiftOnScroll() == false) goto L9;
        r11.setLiftedState(r11.shouldLift(r12));
    L9:
        this.lastNestedScrollingChildRef = new WeakReference(r12);
        return;
    L5:
        if (r13 != 1) goto L9;
        goto L6
    }

    void restoreScrollState(@Nullable SavedState r10, boolean r11) {
        if (this.savedState == null) goto L5;
        if (r11 == true) goto L5;
        return;
    L5:
        this.savedState = r10;
    }

    @Nullable
    SavedState saveScrollState(@Nullable Parcelable r10, @NonNull T r11) {
        int r12 = getTopAndBottomOffset();
        int r13 = r11.getChildCount();
        boolean r14 = false;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L26;
        View r16 = r11.getChildAt(r15);
        int r17 = r16.getBottom() + r12;
        if ((r16.getTop() + r12) > 0) goto L25;
        if (r17 < 0) goto L25;
        if (r10 != null) goto L10;
        r10 = AbsSavedState.EMPTY_STATE;
    L10:
        SavedState r18 = new SavedState(r10);
        if (r12 != 0) goto L13;
        boolean r19 = true;
    L14:
        r18.fullyExpanded = r19;
        if (r19 == false) goto L17;
    L19:
        boolean r20 = false;
    L20:
        r18.fullyScrolled = r20;
        r18.firstVisibleChildIndex = r15;
        if (r17 != (ViewCompat.getMinimumHeight(r16) + r11.getTopInset())) goto L23;
        r14 = true;
    L23:
        r18.firstVisibleChildAtMinimumHeight = r14;
        r18.firstVisibleChildPercentageShown = r17 / r16.getHeight();
        return r18;
    L17:
        if ((-r12) < r11.getTotalScrollRange()) goto L19;
        r20 = true;
        goto L20
    L13:
        r19 = false;
    L25:
        r15 = r15 + 1;
        goto L3
    L26:
        return null;
    }

    public void setDragCallback(@Nullable b r10) {
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14) {
        return setHeaderTopBottomOffset(r10, (OUnitedTitleBar) r11, r12, r13, r14);
    }

    public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14) {
        int r15 = getTopBottomOffsetForScrollingSibling();
        int r16 = 0;
        if (r13 == 0) goto L30;
        if (r15 < r13) goto L30;
        if (r15 > r14) goto L30;
        int r17 = MathUtils.clamp(r12, r13, r14);
        if (r15 != r17) goto L9;
    L31:
        updateAccessibilityActions(r10, r11);
        return r16;
    L9:
        if (r11.hasChildWithInterpolator() == false) goto L11;
        int r18 = interpolateOffset(r11, r17);
    L12:
        boolean r19 = setTopAndBottomOffset(r18);
        int r110 = r15 - r17;
        this.offsetDelta = r17 - r18;
        int r111 = 1;
        if (r19 == true) goto L15;
    L22:
        if (r19 == false) goto L24;
    L26:
        r11.dispatchOffsetChange(getTopAndBottomOffset());
        if (r17 >= r15) goto L29;
        r111 = -1;
    L29:
        updateOUnitedTitleBarDrawableState(r10, r11, r17, r111, false);
        r16 = r110;
        goto L31
    L24:
        if (r11.hasChildWithInterpolator() == false) goto L26;
        r10.dispatchDependentViewsChanged(r11);
    L15:
        if (r16 >= r11.getChildCount()) goto L22;
        LayoutParams r20 = (LayoutParams) r11.getChildAt(r16).getLayoutParams();
        c r21 = r20.b();
        if (r21 == null) goto L21;
        if ((r20.c() & 1) == 0) goto L21;
        r21.a(r11, r11.getChildAt(r16), getTopAndBottomOffset());
    L21:
        r16 = r16 + 1;
        goto L15
    L11:
        r18 = r17;
    L30:
        this.offsetDelta = 0;
        goto L31
    }
}
