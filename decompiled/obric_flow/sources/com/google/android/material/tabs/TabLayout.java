package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = 0;

    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = null;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;

    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;

    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;

    @Nullable
    private Tab selectedTab;
    private int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;

    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    private TabIndicatorInterpolator tabIndicatorInterpolator;
    private final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;

    @NonNull
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    private final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;

    @Nullable
    ViewPager viewPager;
    private int viewPagerScrollState;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ TabLayout this$0;

        public AdapterChangeListener(TabLayout r5) {
            this.this$0 = r5;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager r5, @Nullable PagerAdapter r10, @Nullable PagerAdapter r11) {
            TabLayout r12 = this.this$0;
            if (r12.viewPager != r5) goto L6;
            r12.setPagerAdapter(r11, this.autoRefresh);
            return;
        }

        public void setAutoRefresh(boolean r5) {
            this.autoRefresh = r5;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T r5);

        void onTabSelected(T r5);

        void onTabUnselected(T r5);
    }

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ TabLayout this$0;

        public PagerAdapterObserver(TabLayout r5) {
            this.this$0 = r5;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.populateFromPagerAdapter();
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection;
        final /* synthetic */ TabLayout this$0;

        public SlidingTabIndicator(TabLayout r5, Context r10) {
            this.this$0 = r5;
            super(r10);
            this.layoutDirection = -1;
            setWillNotDraw(false);
        }

        public static /* synthetic */ void access$100(SlidingTabIndicator r5) {
            r5.jumpIndicatorToSelectedPosition();
        }

        public static /* synthetic */ void access$1800(SlidingTabIndicator r5, View r10, View r11, float r12) {
            r5.tweenIndicatorPosition(r10, r11, r12);
        }

        private void jumpIndicatorToIndicatorPosition() {
            TabLayout r5 = this.this$0;
            if (r5.indicatorPosition != (-1)) goto L5;
            r5.indicatorPosition = r5.getSelectedTabPosition();
        L5:
            jumpIndicatorToPosition(this.this$0.indicatorPosition);
        }

        private void jumpIndicatorToPosition(int r5) {
            if (TabLayout.access$1600(this.this$0) != 0) goto L5;
        L9:
            View r10 = getChildAt(r5);
            TabIndicatorInterpolator r11 = TabLayout.access$1700(this.this$0);
            TabLayout r12 = this.this$0;
            r11.setIndicatorBoundsForTab(r12, r10, r12.tabSelectedIndicator);
            this.this$0.indicatorPosition = r5;
            return;
        L5:
            if (this.this$0.getTabSelectedIndicator().getBounds().left == (-1)) goto L7;
            return;
        L7:
            if (this.this$0.getTabSelectedIndicator().getBounds().right == (-1)) goto L9;
        }

        private void jumpIndicatorToSelectedPosition() {
            jumpIndicatorToPosition(this.this$0.getSelectedTabPosition());
        }

        private void tweenIndicatorPosition(View r10, View r11, float r12) {
            if (r10 != null) goto L4;
        L6:
            Drawable r13 = this.this$0.tabSelectedIndicator;
            r13.setBounds(-1, r13.getBounds().top, -1, this.this$0.tabSelectedIndicator.getBounds().bottom);
        L7:
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L4:
            if (r10.getWidth() <= 0) goto L6;
            TabIndicatorInterpolator r5 = TabLayout.access$1700(this.this$0);
            TabLayout r14 = this.this$0;
            r5.updateIndicatorForOffset(r14, r10, r11, r12, r14.tabSelectedIndicator);
            goto L7
        }

        private void updateOrRecreateIndicatorAnimation(boolean r5, int r10, int r11) {
            TabLayout r12 = this.this$0;
            if (r12.indicatorPosition != r10) goto L5;
            return;
        L5:
            final View r13 = getChildAt(r12.getSelectedTabPosition());
            final View r14 = getChildAt(r10);
            if (r14 != null) goto L9;
            jumpIndicatorToSelectedPosition();
            return;
        L9:
            this.this$0.indicatorPosition = r10;
            ValueAnimator.AnimatorUpdateListener r15 = new AnonymousClass1(this, r13, r14);
            if (r5 == false) goto L12;
            ValueAnimator r16 = new ValueAnimator();
            this.indicatorAnimator = r16;
            r16.setInterpolator(TabLayout.access$1900(this.this$0));
            r16.setDuration(r11);
            r16.setFloatValues(new float[]{0.0f, 1.0f});
            r16.addUpdateListener(r15);
            r16.start();
            return;
        L12:
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(r15);
        }

        public void animateIndicatorToPosition(int r5, int r10) {
            ValueAnimator r11 = this.indicatorAnimator;
            if (r11 != null) goto L5;
        L9:
            updateOrRecreateIndicatorAnimation(true, r5, r10);
            return;
        L5:
            if (r11.isRunning() == false) goto L9;
            if (this.this$0.indicatorPosition == r5) goto L9;
            this.indicatorAnimator.cancel();
            goto L9
        }

        public boolean childrenNeedLayout() {
            int r5 = getChildCount();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L9;
            if (getChildAt(r10).getWidth() <= 0) goto L6;
            r10 = r10 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas r10) {
            int r5 = this.this$0.tabSelectedIndicator.getBounds().height();
            if (r5 >= 0) goto L5;
            r5 = this.this$0.tabSelectedIndicator.getIntrinsicHeight();
        L5:
            int r11 = this.this$0.tabIndicatorGravity;
            if (r11 != 0) goto L8;
            int r12 = getHeight() - r5;
            r5 = getHeight();
        L18:
            if (this.this$0.tabSelectedIndicator.getBounds().width() <= 0) goto L20;
            Rect r13 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r13.left, r12, r13.right, r5);
            this.this$0.tabSelectedIndicator.draw(r10);
        L20:
            super.draw(r10);
            return;
        L8:
            if (r11 == 1) goto L15;
            r12 = 0;
            if (r11 == 2) goto L18;
            if (r11 == 3) goto L14;
            r5 = 0;
            goto L18
        L14:
            r5 = getHeight();
            goto L18
        L15:
            r12 = (getHeight() - r5) / 2;
            r5 = (getHeight() + r5) / 2;
            goto L18
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
            super.onLayout(r5, r10, r11, r12, r13);
            ValueAnimator r14 = this.indicatorAnimator;
            if (r14 != null) goto L5;
        L7:
            jumpIndicatorToIndicatorPosition();
            return;
        L5:
            if (r14.isRunning() == false) goto L7;
            updateOrRecreateIndicatorAnimation(false, this.this$0.getSelectedTabPosition(), -1);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
            return;
        L5:
            TabLayout r5 = this.this$0;
            boolean r12 = true;
            if (r5.tabGravity != 1) goto L8;
        L9:
            int r13 = getChildCount();
            int r14 = 0;
            int r15 = 0;
            int r16 = 0;
        L10:
            if (r15 >= r13) goto L15;
            View r17 = getChildAt(r15);
            if (r17.getVisibility() != 0) goto L14;
            r16 = Math.max(r16, r17.getMeasuredWidth());
        L14:
            r15 = r15 + 1;
            goto L10
        L15:
            if (r16 > 0) goto L18;
            return;
        L18:
            if ((r16 * r13) > (getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2))) goto L28;
            boolean r18 = false;
        L20:
            if (r14 >= r13) goto L27;
            LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) getChildAt(r14).getLayoutParams();
            if (r19.width == r16) goto L24;
        L25:
            r19.width = r16;
            r19.weight = 0.0f;
            r18 = true;
        L26:
            r14 = r14 + 1;
            goto L20
        L24:
            if (r19.weight == 0.0f) goto L26;
        L27:
            r12 = r18;
        L29:
            if (r12 == false) goto L39;
            super.onMeasure(r10, r11);
            return;
        L39:
            return;
        L28:
            TabLayout r20 = this.this$0;
            r20.tabGravity = 0;
            r20.updateTabViews(false);
            goto L29
        L8:
            if (r5.mode == 2) goto L9;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r5) {
            super.onRtlPropertiesChanged(r5);
        }

        public void setIndicatorPositionFromTabPosition(int r5, float r10) {
            this.this$0.indicatorPosition = Math.round(r5 + r10);
            ValueAnimator r11 = this.indicatorAnimator;
            if (r11 != null) goto L5;
        L7:
            tweenIndicatorPosition(getChildAt(r5), getChildAt(r5 + 1), r10);
            return;
        L5:
            if (r11.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        public void setSelectedIndicatorHeight(int r5) {
            Rect r10 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r10.left, 0, r10.right, r5);
            requestLayout();
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;

        @Nullable
        private CharSequence contentDesc;

        @Nullable
        private View customView;

        @Nullable
        private Drawable icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private int f8598id;

        @LabelVisibility
        private int labelVisibilityMode;

        @Nullable
        public TabLayout parent;
        private int position;

        @Nullable
        private Object tag;

        @Nullable
        private CharSequence text;

        @NonNull
        public TabView view;

        public Tab() {
            this.position = -1;
            this.labelVisibilityMode = 1;
            this.f8598id = -1;
        }

        public static /* synthetic */ int access$000(Tab r5) {
            return r5.f8598id;
        }

        public static /* synthetic */ int access$1500(Tab r5) {
            return r5.labelVisibilityMode;
        }

        public static /* synthetic */ CharSequence access$300(Tab r5) {
            return r5.contentDesc;
        }

        public static /* synthetic */ CharSequence access$400(Tab r5) {
            return r5.text;
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return TabView.access$1000(this.view);
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView r5 = this.view;
            if (r5 != null) goto L6;
            return null;
        L6:
            return r5.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.f8598id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return TabView.access$800(this.view);
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout r5 = this.parent;
            if (r5 == null) goto L12;
            int r10 = r5.getSelectedTabPosition();
            if (r10 != (-1)) goto L7;
        L9:
            return false;
        L7:
            if (r10 != this.position) goto L9;
            return true;
        L12:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            TabView.access$900(this.view);
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.f8598id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout r5 = this.parent;
            if (r5 == null) goto L7;
            r5.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int r5) {
            TabLayout r10 = this.parent;
            if (r10 == null) goto L7;
            return setContentDescription(r10.getResources().getText(r5));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View r5) {
            this.customView = r5;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable r5) {
            this.icon = r5;
            TabLayout r10 = this.parent;
            if (r10.tabGravity != 1) goto L5;
        L6:
            r10.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$600(this.view) == false) goto L14;
            if (TabView.access$700(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (r10.mode != 2) goto L7;
            goto L6
        }

        @NonNull
        public Tab setId(int r5) {
            this.f8598id = r5;
            TabView r10 = this.view;
            if (r10 == null) goto L5;
            r10.setId(r5);
        L5:
            return this;
        }

        public void setPosition(int r5) {
            this.position = r5;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int r5) {
            this.labelVisibilityMode = r5;
            TabLayout r10 = this.parent;
            if (r10.tabGravity != 1) goto L5;
        L6:
            r10.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$600(this.view) == false) goto L14;
            if (TabView.access$700(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (r10.mode != 2) goto L7;
            goto L6
        }

        @NonNull
        public Tab setTag(@Nullable Object r5) {
            this.tag = r5;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence r5) {
            if (TextUtils.isEmpty(this.contentDesc) == true) goto L5;
        L7:
            this.text = r5;
            updateView();
            return this;
        L5:
            if (TextUtils.isEmpty(r5) == true) goto L7;
            this.view.setContentDescription(r5);
            goto L7
        }

        public void updateView() {
            TabView r5 = this.view;
            if (r5 == null) goto L6;
            r5.update();
            return;
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int r5) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(r5, this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence r5) {
            this.contentDesc = r5;
            updateView();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int r5) {
            TabLayout r10 = this.parent;
            if (r10 == null) goto L7;
            return setText(r10.getResources().getText(r5));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int r5) {
            TabLayout r10 = this.parent;
            if (r10 == null) goto L7;
            return setIcon(AppCompatResources.getDrawable(r10.getContext(), r5));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout r5) {
            this.tabLayoutRef = new WeakReference(r5);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r5) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r5;
            TabLayout r10 = this.tabLayoutRef.get();
            if (r10 == null) goto L6;
            r10.updateViewPagerScrollState(this.scrollState);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
            TabLayout r5 = this.tabLayoutRef.get();
            if (r5 == null) goto L19;
            int r13 = this.scrollState;
            if (r13 == 2) goto L7;
        L10:
            boolean r14 = true;
        L11:
            if (r13 == 2) goto L13;
        L16:
            boolean r15 = true;
        L17:
            r5.setScrollPosition(r10, r11, r14, r15, false);
            return;
        L13:
            if (this.previousScrollState != 0) goto L16;
            r15 = false;
            goto L17
        L7:
            if (this.previousScrollState == 1) goto L10;
            r14 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r5) {
            TabLayout r10 = this.tabLayoutRef.get();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getSelectedTabPosition() != r5) goto L7;
            return;
        L7:
            if (r5 >= r10.getTabCount()) goto L21;
            int r11 = this.scrollState;
            if (r11 != 0) goto L11;
        L16:
            boolean r12 = true;
        L17:
            r10.selectTab(r10.getTabAt(r5), r12);
            return;
        L11:
            if (r11 == 2) goto L13;
        L15:
            r12 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {

        @Nullable
        private View badgeAnchorView;

        @Nullable
        private BadgeDrawable badgeDrawable;

        @Nullable
        private Drawable baseBackgroundDrawable;

        @Nullable
        private ImageView customIconView;

        @Nullable
        private TextView customTextView;

        @Nullable
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;
        final /* synthetic */ TabLayout this$0;

        public TabView(@NonNull TabLayout r5, Context r10) {
            this.this$0 = r5;
            super(r10);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(r10);
            ViewCompat.setPaddingRelative(this, r5.tabPaddingStart, r5.tabPaddingTop, r5.tabPaddingEnd, r5.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r5.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        public static /* synthetic */ BadgeDrawable access$1000(TabView r5) {
            return r5.getBadge();
        }

        public static /* synthetic */ void access$1400(TabView r5, View r10) {
            r5.tryUpdateBadgeDrawableBounds(r10);
        }

        public static /* synthetic */ void access$200(TabView r5, Context r10) {
            r5.updateBackgroundDrawable(r10);
        }

        public static /* synthetic */ void access$500(TabView r5, Canvas r10) {
            r5.drawBackground(r10);
        }

        public static /* synthetic */ boolean access$600(TabView r5) {
            return r5.hasBadgeDrawable();
        }

        public static /* synthetic */ BadgeDrawable access$700(TabView r5) {
            return r5.badgeDrawable;
        }

        public static /* synthetic */ BadgeDrawable access$800(TabView r5) {
            return r5.getOrCreateBadge();
        }

        public static /* synthetic */ void access$900(TabView r5) {
            r5.removeBadge();
        }

        private void addOnLayoutChangeListener(@Nullable final View r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            r5.addOnLayoutChangeListener(new AnonymousClass1(this, r5));
        }

        private float approximateLineWidth(@NonNull Layout r5, int r10, float r11) {
            float r12 = r5.getLineWidth(r10);
            return (r11 / r5.getPaint().getTextSize()) * r12;
        }

        private void clipViewToPaddingForBadge(boolean r5) {
            setClipChildren(r5);
            setClipToPadding(r5);
            ViewGroup r10 = (ViewGroup) getParent();
            if (r10 == null) goto L6;
            r10.setClipChildren(r5);
            r10.setClipToPadding(r5);
            return;
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout r5 = new FrameLayout(getContext());
            r5.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r5;
        }

        private void drawBackground(@NonNull Canvas r10) {
            Drawable r5 = this.baseBackgroundDrawable;
            if (r5 == null) goto L6;
            r5.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(r10);
            return;
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View r5) {
            if (r5 == this.iconView) goto L8;
            if (r5 == this.textView) goto L8;
            return null;
        L8:
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
            return null;
        L10:
            return (FrameLayout) r5.getParent();
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable != null) goto L5;
            this.badgeDrawable = BadgeDrawable.create(getContext());
        L5:
            tryUpdateBadgeAnchor();
            BadgeDrawable r5 = this.badgeDrawable;
            if (r5 == null) goto L9;
            return r5;
        L9:
            throw new IllegalStateException("Unable to create badge");
        }

        private boolean hasBadgeDrawable() {
            if (this.badgeDrawable == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void inflateAndAddDefaultIconView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r5 = createPreApi18BadgeAnchorRoot();
            addView(r5, 0);
            ViewGroup r10 = r5;
        L6:
            ImageView r11 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, r10, false);
            this.iconView = r11;
            r10.addView(r11, 0);
            return;
        L5:
            r10 = this;
            goto L6
        }

        private void inflateAndAddDefaultTextView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r5 = createPreApi18BadgeAnchorRoot();
            addView(r5);
            ViewGroup r10 = r5;
        L6:
            TextView r11 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, r10, false);
            this.textView = r11;
            r10.addView(r11);
            return;
        L5:
            r10 = this;
            goto L6
        }

        private void removeBadge() {
            if (this.badgeAnchorView == null) goto L5;
            tryRemoveBadgeFromAnchor();
        L5:
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@Nullable View r5) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r5 == null) goto L8;
            clipViewToPaddingForBadge(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r5, getCustomParentForBadge(r5));
            this.badgeAnchorView = r5;
            return;
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            clipViewToPaddingForBadge(true);
            View r5 = this.badgeAnchorView;
            if (r5 == null) goto L9;
            BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r5);
            this.badgeAnchorView = null;
            return;
        }

        private void tryUpdateBadgeAnchor() {
            if (hasBadgeDrawable() == true) goto L6;
            return;
        L6:
            if (this.customView == null) goto L9;
            tryRemoveBadgeFromAnchor();
            return;
        L9:
            if (this.iconView == null) goto L19;
            Tab r5 = this.tab;
            if (r5 == null) goto L19;
            if (r5.getIcon() == null) goto L19;
            View r10 = this.badgeAnchorView;
            ImageView r11 = this.iconView;
            if (r10 == r11) goto L17;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.iconView);
            return;
        L17:
            tryUpdateBadgeDrawableBounds(r11);
            return;
        L19:
            if (this.textView == null) goto L28;
            Tab r12 = this.tab;
            if (r12 == null) goto L28;
            if (r12.getTabLabelVisibility() != 1) goto L28;
            View r13 = this.badgeAnchorView;
            TextView r14 = this.textView;
            if (r13 == r14) goto L27;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.textView);
            return;
        L27:
            tryUpdateBadgeDrawableBounds(r14);
            return;
        L28:
            tryRemoveBadgeFromAnchor();
        }

        private void tryUpdateBadgeDrawableBounds(@NonNull View r5) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r5 != this.badgeAnchorView) goto L9;
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r5, getCustomParentForBadge(r5));
            return;
        }

        private void updateBackgroundDrawable(Context r10) {
            int r5 = this.this$0.tabBackgroundResId;
            GradientDrawable r11 = null;
            if (r5 == 0) goto L9;
            Drawable r12 = AppCompatResources.getDrawable(r10, r5);
            this.baseBackgroundDrawable = r12;
            if (r12 != null) goto L7;
        L10:
            GradientDrawable r13 = new GradientDrawable();
            r13.setColor(0);
            Drawable r14 = r13;
            if (this.this$0.tabRippleColorStateList == null) goto L19;
            GradientDrawable r15 = new GradientDrawable();
            r15.setCornerRadius(1.0E-5f);
            r15.setColor(-1);
            ColorStateList r16 = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
            boolean r17 = this.this$0.unboundedRipple;
            GradientDrawable r18 = r13;
            if (r17 == false) goto L15;
            r18 = null;
        L15:
            if (r17 == true) goto L18;
            r11 = r15;
        L18:
            r14 = new RippleDrawable(r16, r18, r11);
        L19:
            ViewCompat.setBackground(this, r14);
            this.this$0.invalidate();
            return;
        L7:
            if (r12.isStateful() == false) goto L10;
            this.baseBackgroundDrawable.setState(getDrawableState());
            goto L10
        L9:
            this.baseBackgroundDrawable = null;
            goto L10
        }

        private void updateTextAndIcon(@Nullable TextView r10, @Nullable ImageView r11, boolean r12) {
            Tab r5 = this.tab;
            CharSequence r13 = null;
            if (r5 != null) goto L5;
        L7:
            Drawable r14 = null;
        L8:
            if (r14 == null) goto L12;
            DrawableCompat.setTintList(r14, this.this$0.tabIconTint);
            PorterDuff.Mode r15 = this.this$0.tabIconTintMode;
            if (r15 == null) goto L12;
            DrawableCompat.setTintMode(r14, r15);
        L12:
            Tab r16 = this.tab;
            if (r16 == null) goto L15;
            CharSequence r17 = r16.getText();
        L17:
            if (r11 == null) goto L21;
            if (r14 == null) goto L20;
            r11.setImageDrawable(r14);
            r11.setVisibility(0);
            setVisibility(0);
            goto L21
        L20:
            r11.setVisibility(8);
            r11.setImageDrawable(null);
        L21:
            boolean r18 = TextUtils.isEmpty(r17);
            if (r10 == null) goto L38;
            if (r18 == true) goto L27;
            boolean r19 = true;
            if (Tab.access$1500(this.tab) != 1) goto L27;
        L28:
            if (r18 == true) goto L30;
            CharSequence r20 = r17;
        L31:
            r10.setText(r20);
            if (r19 == false) goto L34;
            int r21 = 0;
        L35:
            r10.setVisibility(r21);
            if (r18 == true) goto L39;
            setVisibility(0);
        L39:
            if (r12 == false) goto L55;
            if (r11 == null) goto L55;
            ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
            if (r19 == true) goto L44;
        L46:
            int r110 = 0;
        L48:
            if (this.this$0.inlineLabel == false) goto L53;
            if (r110 == MarginLayoutParamsCompat.getMarginEnd(r22)) goto L55;
            MarginLayoutParamsCompat.setMarginEnd(r22, r110);
            r22.bottomMargin = 0;
            r11.setLayoutParams(r22);
            r11.requestLayout();
            goto L55
        L53:
            if (r110 == r22.bottomMargin) goto L55;
            r22.bottomMargin = r110;
            MarginLayoutParamsCompat.setMarginEnd(r22, 0);
            r11.setLayoutParams(r22);
            r11.requestLayout();
            goto L55
        L44:
            if (r11.getVisibility() != 0) goto L46;
            r110 = (int) ViewUtils.dpToPx(getContext(), 8);
        L55:
            Tab r23 = this.tab;
            if (r23 == null) goto L58;
            r13 = Tab.access$300(r23);
        L58:
            if (r18 == false) goto L61;
            r17 = r13;
        L61:
            TooltipCompat.setTooltipText(this, r17);
            return;
        L34:
            r21 = 8;
            goto L35
        L30:
            r20 = null;
        L27:
            r19 = false;
            goto L28
        L38:
            r19 = false;
            goto L39
        L15:
            r17 = null;
            goto L17
        L5:
            if (r5.getIcon() == null) goto L7;
            r14 = DrawableCompat.wrap(this.tab.getIcon()).mutate();
            goto L8
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r5 = getDrawableState();
            Drawable r10 = this.baseBackgroundDrawable;
            if (r10 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == false) goto L11;
            invalidate();
            this.this$0.invalidate();
            return;
        L11:
            return;
        L5:
            if (r10.isStateful() == false) goto L7;
            r11 = this.baseBackgroundDrawable.setState(r5);
            goto L8
        }

        public int getContentHeight() {
            int r5 = 0;
            View[] r10 = {this.textView, this.iconView, this.customView};
            int r11 = 0;
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r5 >= 3) goto L17;
            View r14 = r10[r5];
            if (r14 == null) goto L15;
            if (r14.getVisibility() != 0) goto L15;
            if (r13 == false) goto L10;
            r12 = Math.min(r12, r14.getTop());
        L11:
            if (r13 == false) goto L13;
            r11 = Math.max(r11, r14.getBottom());
        L14:
            r13 = true;
            goto L15
        L13:
            r11 = r14.getBottom();
            goto L14
        L10:
            r12 = r14.getTop();
        L15:
            r5 = r5 + 1;
            goto L3
        L17:
            return r11 - r12;
        }

        public int getContentWidth() {
            int r5 = 0;
            View[] r10 = {this.textView, this.iconView, this.customView};
            int r11 = 0;
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r5 >= 3) goto L17;
            View r14 = r10[r5];
            if (r14 == null) goto L15;
            if (r14.getVisibility() != 0) goto L15;
            if (r13 == false) goto L10;
            r12 = Math.min(r12, r14.getLeft());
        L11:
            if (r13 == false) goto L13;
            r11 = Math.max(r11, r14.getRight());
        L14:
            r13 = true;
            goto L15
        L13:
            r11 = r14.getRight();
            goto L14
        L10:
            r12 = r14.getLeft();
        L15:
            r5 = r5 + 1;
            goto L3
        L17:
            return r11 - r12;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(r10);
            BadgeDrawable r5 = this.badgeDrawable;
            if (r5 != null) goto L5;
        L7:
            r11.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r11.setClickable(false);
            r11.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        L10:
            r11.setRoleDescription(getResources().getString(R.string.item_view_role_description));
            return;
        L5:
            if (r5.isVisible() == false) goto L7;
            r11.setContentDescription(this.badgeDrawable.getContentDescription());
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            int r5 = View.MeasureSpec.getSize(r10);
            int r12 = View.MeasureSpec.getMode(r10);
            int r13 = this.this$0.getTabMaxWidth();
            if (r13 <= 0) goto L7;
            if (r12 == 0) goto L6;
            if (r5 <= r13) goto L7;
        L6:
            r10 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r10, r11);
            if (this.textView == null) goto L34;
            float r14 = this.this$0.tabTextSize;
            int r15 = this.defaultMaxLines;
            ImageView r16 = this.iconView;
            if (r16 != null) goto L12;
        L14:
            TextView r17 = this.textView;
            if (r17 != null) goto L17;
        L19:
            float r18 = this.textView.getTextSize();
            int r19 = this.textView.getLineCount();
            int r20 = TextViewCompat.getMaxLines(this.textView);
            if (r14 != r18) goto L24;
            if (r20 < 0) goto L35;
            if (r15 != r20) goto L24;
            return;
        L35:
            return;
        L24:
            if (this.this$0.mode != 1) goto L32;
            if (r14 <= r18) goto L32;
            if (r19 != 1) goto L32;
            Layout r21 = this.textView.getLayout();
            if (r21 != null) goto L30;
            return;
        L30:
            if (approximateLineWidth(r21, 0, r14) <= ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L32;
            return;
        L32:
            this.textView.setTextSize(0, r14);
            this.textView.setMaxLines(r15);
            super.onMeasure(r10, r11);
            return;
        L17:
            if (r17.getLineCount() <= 1) goto L19;
            r14 = this.this$0.tabTextMultiLineSize;
            goto L19
        L12:
            if (r16.getVisibility() != 0) goto L14;
            r15 = 1;
            goto L19
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r5 = super.performClick();
            if (this.tab == null) goto L8;
            if (r5 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.tab.select();
            return true;
        L8:
            return r5;
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean r5) {
            isSelected();
            super.setSelected(r5);
            TextView r10 = this.textView;
            if (r10 == null) goto L5;
            r10.setSelected(r5);
        L5:
            ImageView r11 = this.iconView;
            if (r11 == null) goto L8;
            r11.setSelected(r5);
        L8:
            View r12 = this.customView;
            if (r12 == null) goto L12;
            r12.setSelected(r5);
            return;
        }

        public void setTab(@Nullable Tab r5) {
            if (r5 == this.tab) goto L6;
            this.tab = r5;
            update();
            return;
        }

        public final void update() {
            updateTab();
            Tab r5 = this.tab;
            if (r5 != null) goto L5;
        L7:
            boolean r10 = false;
        L8:
            setSelected(r10);
            return;
        L5:
            if (r5.isSelected() == false) goto L7;
            r10 = true;
            goto L8
        }

        public final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r5 = this.customTextView;
            if (r5 == null) goto L5;
        L8:
            updateTextAndIcon(r5, this.customIconView, false);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView, true);
        }

        public final void updateTab() {
            Tab r5 = this.tab;
            if (r5 == null) goto L5;
            View r10 = r5.getCustomView();
        L6:
            if (r10 == null) goto L27;
            ViewParent r11 = r10.getParent();
            if (r11 == this) goto L17;
            if (r11 == null) goto L11;
            ((ViewGroup) r11).removeView(r10);
        L11:
            View r12 = this.customView;
            if (r12 == null) goto L16;
            ViewParent r13 = r12.getParent();
            if (r13 == null) goto L16;
            ((ViewGroup) r13).removeView(this.customView);
        L16:
            addView(r10);
        L17:
            this.customView = r10;
            TextView r14 = this.textView;
            if (r14 == null) goto L20;
            r14.setVisibility(8);
        L20:
            ImageView r15 = this.iconView;
            if (r15 == null) goto L23;
            r15.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L23:
            TextView r16 = (TextView) r10.findViewById(android.R.id.text1);
            this.customTextView = r16;
            if (r16 == null) goto L26;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r16);
        L26:
            this.customIconView = (ImageView) r10.findViewById(android.R.id.icon);
        L32:
            if (this.customView == null) goto L34;
            TextView r17 = this.customTextView;
            if (r17 == null) goto L52;
        L53:
            updateTextAndIcon(r17, this.customIconView, false);
        L54:
            if (r5 != null) goto L56;
            return;
        L56:
            if (TextUtils.isEmpty(Tab.access$300(r5)) == true) goto L60;
            setContentDescription(Tab.access$300(r5));
            return;
        L60:
            return;
        L52:
            if (this.customIconView == null) goto L54;
        L34:
            if (this.iconView != null) goto L37;
            inflateAndAddDefaultIconView();
        L37:
            if (this.textView != null) goto L39;
            inflateAndAddDefaultTextView();
            this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
        L39:
            TextViewCompat.setTextAppearance(this.textView, TabLayout.access$1100(this.this$0));
            if (isSelected() == true) goto L42;
        L44:
            TextViewCompat.setTextAppearance(this.textView, TabLayout.access$1300(this.this$0));
        L45:
            ColorStateList r18 = this.this$0.tabTextColors;
            if (r18 == null) goto L48;
            this.textView.setTextColor(r18);
        L48:
            updateTextAndIcon(this.textView, this.iconView, true);
            tryUpdateBadgeAnchor();
            addOnLayoutChangeListener(this.iconView);
            addOnLayoutChangeListener(this.textView);
            goto L54
        L42:
            if (TabLayout.access$1200(this.this$0) == (-1)) goto L44;
            TextViewCompat.setTextAppearance(this.textView, TabLayout.access$1200(this.this$0));
            goto L45
        L27:
            View r19 = this.customView;
            if (r19 == null) goto L30;
            removeView(r19);
            this.customView = null;
        L30:
            this.customTextView = null;
            this.customIconView = null;
            goto L32
        L5:
            r10 = null;
            goto L6
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager r5) {
            this.viewPager = r5;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab r5) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab r5) {
            this.viewPager.setCurrentItem(r5.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab r5) {
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
        tabPool = new Pools.SynchronizedPool(16);
    }

    public TabLayout(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int access$1100(TabLayout r5) {
        return r5.defaultTabTextAppearance;
    }

    public static /* synthetic */ int access$1200(TabLayout r5) {
        return r5.selectedTabTextAppearance;
    }

    public static /* synthetic */ int access$1300(TabLayout r5) {
        return r5.tabTextAppearance;
    }

    public static /* synthetic */ int access$1600(TabLayout r5) {
        return r5.viewPagerScrollState;
    }

    public static /* synthetic */ TabIndicatorInterpolator access$1700(TabLayout r5) {
        return r5.tabIndicatorInterpolator;
    }

    public static /* synthetic */ TimeInterpolator access$1900(TabLayout r5) {
        return r5.tabIndicatorTimeInterpolator;
    }

    private void addTabFromItemView(@NonNull TabItem r5) {
        Tab r10 = newTab();
        CharSequence r11 = r5.text;
        if (r11 == null) goto L5;
        r10.setText(r11);
    L5:
        Drawable r12 = r5.icon;
        if (r12 == null) goto L8;
        r10.setIcon(r12);
    L8:
        int r13 = r5.customLayout;
        if (r13 == 0) goto L12;
        r10.setCustomView(r13);
    L12:
        if (TextUtils.isEmpty(r5.getContentDescription()) == true) goto L14;
        r10.setContentDescription(r5.getContentDescription());
    L14:
        addTab(r10);
    }

    private void addTabView(@NonNull Tab r5) {
        TabView r10 = r5.view;
        r10.setSelected(false);
        r10.setActivated(false);
        this.slidingTabIndicator.addView(r10, r5.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View r5) {
        if ((r5 instanceof TabItem) == false) goto L7;
        addTabFromItemView((TabItem) r5);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int r5) {
        if (r5 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        setScrollPosition(r5, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.slidingTabIndicator.childrenNeedLayout() == true) goto L17;
        int r10 = getScrollX();
        int r11 = calculateScrollXForTab(r5, 0.0f);
        if (r10 == r11) goto L15;
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[]{r10, r11});
        this.scrollAnimator.start();
    L15:
        this.slidingTabIndicator.animateIndicatorToPosition(r5, this.tabIndicatorAnimationDuration);
    }

    private void applyGravityForModeScrollable(int r5) {
        if (r5 != 0) goto L4;
        Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.slidingTabIndicator.setGravity(GravityCompat.START);
        return;
    L4:
        if (r5 != 1) goto L6;
        this.slidingTabIndicator.setGravity(1);
        return;
    L6:
        if (r5 == 2) goto L10;
    }

    private void applyModeAndGravity() {
        int r5 = this.mode;
        if (r5 == 0) goto L7;
        if (r5 == 2) goto L7;
        int r10 = 0;
    L8:
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, r10, 0, 0, 0);
        int r11 = this.mode;
        if (r11 == 0) goto L17;
        if (r11 == 1) goto L14;
        if (r11 == 2) goto L14;
    L18:
        updateTabViews(true);
        return;
    L14:
        if (this.tabGravity != 2) goto L16;
        Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
    L16:
        this.slidingTabIndicator.setGravity(1);
        goto L18
    L17:
        applyGravityForModeScrollable(this.tabGravity);
    L7:
        r10 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        goto L8
    }

    private int calculateScrollXForTab(int r5, float r10) {
        int r11 = this.mode;
        int r12 = 0;
        if (r11 == 0) goto L7;
        if (r11 == 2) goto L7;
        return 0;
    L7:
        View r13 = this.slidingTabIndicator.getChildAt(r5);
        if (r13 != null) goto L10;
        return 0;
    L10:
        int r14 = r5 + 1;
        if (r14 >= this.slidingTabIndicator.getChildCount()) goto L13;
        View r15 = this.slidingTabIndicator.getChildAt(r14);
    L14:
        int r16 = r13.getWidth();
        if (r15 == null) goto L17;
        r12 = r15.getWidth();
    L17:
        int r17 = ((r16 / 2) + r13.getLeft()) - (getWidth() / 2);
        int r18 = (int) (((r16 + r12) * 0.5f) * r10);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L21;
        return r17 + r18;
    L21:
        return r17 - r18;
    L13:
        r15 = null;
        goto L14
    }

    private void configureTab(@NonNull Tab r5, int r10) {
        r5.setPosition(r10);
        this.tabs.add(r10, r5);
        int r11 = this.tabs.size();
        int r12 = r10 + 1;
        int r13 = -1;
    L3:
        if (r12 >= r11) goto L8;
        if (this.tabs.get(r12).getPosition() != this.indicatorPosition) goto L7;
        r13 = r12;
    L7:
        this.tabs.get(r12).setPosition(r12);
        r12 = r12 + 1;
        goto L3
    L8:
        this.indicatorPosition = r13;
    }

    @NonNull
    private static ColorStateList createColorStateList(int r5, int r10) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r10, r5});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r5);
        return r5;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab r5) {
        Pools.Pool<TabView> r10 = this.tabViewPool;
        if (r10 == null) goto L5;
        TabView r11 = r10.acquire();
    L6:
        if (r11 != null) goto L8;
        r11 = new TabView(this, getContext());
    L8:
        r11.setTab(r5);
        r11.setFocusable(true);
        r11.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(Tab.access$300(r5)) == false) goto L11;
        r11.setContentDescription(Tab.access$400(r5));
    L12:
        return r11;
    L11:
        r11.setContentDescription(Tab.access$300(r5));
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    private void dispatchTabReselected(@NonNull Tab r5) {
        int r10 = this.selectedListeners.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.selectedListeners.get(r10).onTabReselected(r5);
        r10 = r10 - 1;
        goto L3
    }

    private void dispatchTabSelected(@NonNull Tab r5) {
        int r10 = this.selectedListeners.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.selectedListeners.get(r10).onTabSelected(r5);
        r10 = r10 - 1;
        goto L3
    }

    private void dispatchTabUnselected(@NonNull Tab r5) {
        int r10 = this.selectedListeners.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.selectedListeners.get(r10).onTabUnselected(r5);
        r10 = r10 - 1;
        goto L3
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator != null) goto L6;
        ValueAnimator r5 = new ValueAnimator();
        this.scrollAnimator = r5;
        r5.setInterpolator(this.tabIndicatorTimeInterpolator);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int r5 = this.tabs.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L14;
        Tab r11 = this.tabs.get(r10);
        if (r11 == null) goto L13;
        if (r11.getIcon() == null) goto L13;
        if (TextUtils.isEmpty(r11.getText()) == true) goto L13;
        if (this.inlineLabel == true) goto L14;
        return 72;
    L13:
        r10 = r10 + 1;
    L14:
        return 48;
    }

    private int getTabMinWidth() {
        int r5 = this.requestedTabMinWidth;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = this.mode;
        if (r10 == 0) goto L12;
        if (r10 == 2) goto L12;
        return 0;
    L12:
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private boolean isScrollingEnabled() {
        if (getTabMode() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getTabMode() == 2) goto L8;
        return false;
    }

    private void removeTabViewAt(int r5) {
        TabView r10 = (TabView) this.slidingTabIndicator.getChildAt(r5);
        this.slidingTabIndicator.removeViewAt(r5);
        if (r10 == null) goto L5;
        r10.reset();
        this.tabViewPool.release(r10);
    L5:
        requestLayout();
    }

    private void setSelectedTabView(int r10) {
        int r5 = this.slidingTabIndicator.getChildCount();
        if (r10 >= r5) goto L32;
        int r11 = 0;
    L5:
        if (r11 >= r5) goto L37;
        View r12 = this.slidingTabIndicator.getChildAt(r11);
        boolean r13 = true;
        if (r11 == r10) goto L9;
    L10:
        if (r11 != r10) goto L12;
    L23:
        if (r11 != r10) goto L25;
        boolean r14 = true;
    L26:
        r12.setSelected(r14);
        if (r11 == r10) goto L30;
        r13 = false;
    L30:
        r12.setActivated(r13);
    L31:
        r11 = r11 + 1;
        goto L5
    L25:
        r14 = false;
        goto L26
    L12:
        if (r12.isSelected() == false) goto L23;
    L13:
        if (r11 != r10) goto L15;
        boolean r15 = true;
    L16:
        r12.setSelected(r15);
        if (r11 == r10) goto L20;
        r13 = false;
    L20:
        r12.setActivated(r13);
        if ((r12 instanceof TabView) == false) goto L31;
        ((TabView) r12).updateTab();
        goto L31
    L15:
        r15 = false;
        goto L16
    L9:
        if (r12.isSelected() == false) goto L13;
    L37:
        return;
    }

    private void updateAllTabs() {
        int r5 = this.tabs.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.tabs.get(r10).updateView();
        r10 = r10 + 1;
        goto L3
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams r5) {
        if (this.mode == 1) goto L5;
    L7:
        r5.width = -2;
        r5.weight = 0.0f;
        return;
    L5:
        if (this.tabGravity != 0) goto L7;
        r5.width = 0;
        r5.weight = 1.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener r5) {
        addOnTabSelectedListener(r5);
    }

    public void addTab(@NonNull Tab r5) {
        addTab(r5, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r5) {
        addViewInternal(r5);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab r5 = tabPool.acquire();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new Tab();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public int getSelectedTabPosition() {
        Tab r5 = this.selectedTab;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.getPosition();
    }

    @Nullable
    public Tab getTabAt(int r5) {
        if (r5 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r5 >= getTabCount()) goto L7;
        return this.tabs.get(r5);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab r5 = createTabFromPool();
        r5.parent = this;
        r5.view = createTabView(r5);
        if (Tab.access$000(r5) == (-1)) goto L5;
        r5.view.setId(Tab.access$000(r5));
    L5:
        return r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager != null) goto L8;
        ViewParent r5 = getParent();
        if ((r5 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r5, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.setupViewPagerImplicitly = false;
        return;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r11 = this.slidingTabIndicator.getChildAt(r10);
        if ((r11 instanceof TabView) == false) goto L8;
        TabView.access$500((TabView) r11, r5);
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        super.onDraw(r5);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        AccessibilityNodeInfoCompat.wrap(r5).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (isScrollingEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r5) == false) goto L7;
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r5 = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int r12 = View.MeasureSpec.getMode(r11);
        if (r12 == Integer.MIN_VALUE) goto L8;
        if (r12 != 0) goto L12;
        r11 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + (getPaddingTop() + r5), BasicMeasure.EXACTLY);
    L12:
        int r13 = View.MeasureSpec.getSize(r10);
        if (View.MeasureSpec.getMode(r10) == 0) goto L19;
        int r14 = this.requestedTabMaxWidth;
        if (r14 > 0) goto L18;
        r14 = (int) (r13 - ViewUtils.dpToPx(getContext(), 56));
    L18:
        this.tabMaxWidth = r14;
    L19:
        super.onMeasure(r10, r11);
        if (getChildCount() != 1) goto L34;
        View r15 = getChildAt(0);
        int r16 = this.mode;
        if (r16 == 0) goto L31;
        if (r16 == 1) goto L28;
        if (r16 == 2) goto L31;
        return;
    L28:
        if (r15.getMeasuredWidth() == getMeasuredWidth()) goto L35;
    L32:
        r15.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), ViewGroup.getChildMeasureSpec(r11, getPaddingBottom() + getPaddingTop(), r15.getLayoutParams().height));
        return;
    L35:
        return;
    L31:
        if (r15.getMeasuredWidth() < getMeasuredWidth()) goto L32;
        return;
    L34:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r11) < r5) goto L12;
        getChildAt(0).setMinimumHeight(r5);
        goto L12
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r5) {
        if (r5.getActionMasked() != 8) goto L9;
        if (isScrollingEnabled() == true) goto L9;
        return false;
    L9:
        return super.onTouchEvent(r5);
    }

    public void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r5 = this.pagerAdapter;
        if (r5 == null) goto L17;
        int r10 = r5.getCount();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(r11)), false);
        r11 = r11 + 1;
        goto L5
    L7:
        ViewPager r12 = this.viewPager;
        if (r12 == null) goto L18;
        if (r10 <= 0) goto L19;
        int r13 = r12.getCurrentItem();
        if (r13 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r13 >= getTabCount()) goto L21;
        selectTab(getTabAt(r13));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public boolean releaseFromTabPool(Tab r5) {
        return tabPool.release(r5);
    }

    public void removeAllTabs() {
        int r5 = this.slidingTabIndicator.getChildCount() - 1;
    L3:
        if (r5 < 0) goto L5;
        removeTabViewAt(r5);
        r5 = r5 - 1;
        goto L3
    L5:
        Iterator<Tab> r10 = this.tabs.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Tab r11 = r10.next();
        r10.remove();
        r11.reset();
        releaseFromTabPool(r11);
        goto L7
    L9:
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener r5) {
        removeOnTabSelectedListener(r5);
    }

    public void removeTab(@NonNull Tab r5) {
        if (r5.parent != this) goto L7;
        removeTabAt(r5.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r10) {
        Tab r5 = this.selectedTab;
        if (r5 == null) goto L5;
        int r11 = r5.getPosition();
    L6:
        removeTabViewAt(r10);
        Tab r12 = this.tabs.remove(r10);
        if (r12 == null) goto L9;
        r12.reset();
        releaseFromTabPool(r12);
    L9:
        int r13 = this.tabs.size();
        int r14 = -1;
        int r15 = r10;
    L10:
        if (r15 >= r13) goto L15;
        if (this.tabs.get(r15).getPosition() != this.indicatorPosition) goto L14;
        r14 = r15;
    L14:
        this.tabs.get(r15).setPosition(r15);
        r15 = r15 + 1;
        goto L10
    L15:
        this.indicatorPosition = r14;
        if (r11 == r10) goto L18;
        return;
    L18:
        if (this.tabs.isEmpty() == false) goto L20;
        Tab r16 = null;
    L21:
        selectTab(r16);
        return;
    L20:
        r16 = this.tabs.get(Math.max(0, r10 - 1));
        goto L21
    L5:
        r11 = 0;
        goto L6
    }

    public void selectTab(@Nullable Tab r5) {
        selectTab(r5, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        MaterialShapeUtils.setElevation(this, r5);
    }

    public void setInlineLabel(boolean r5) {
        if (this.inlineLabel == r5) goto L16;
        this.inlineLabel = r5;
        int r10 = 0;
    L6:
        if (r10 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r11 = this.slidingTabIndicator.getChildAt(r10);
        if ((r11 instanceof TabView) == false) goto L10;
        ((TabView) r11).updateOrientation();
    L10:
        r10 = r10 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(@BoolRes int r5) {
        setInlineLabel(getResources().getBoolean(r5));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener r5) {
        setOnTabSelectedListener(r5);
    }

    public void setPagerAdapter(@Nullable PagerAdapter r5, boolean r10) {
        PagerAdapter r11 = this.pagerAdapter;
        if (r11 == null) goto L7;
        DataSetObserver r12 = this.pagerAdapterObserver;
        if (r12 == null) goto L7;
        r11.unregisterDataSetObserver(r12);
    L7:
        this.pagerAdapter = r5;
        if (r10 == false) goto L14;
        if (r5 == null) goto L14;
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r5.registerDataSetObserver(this.pagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r5) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r5);
    }

    public void setScrollPosition(int r5, float r10, boolean r11) {
        setScrollPosition(r5, r10, r11, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable r5) {
        if (r5 != null) goto L4;
        r5 = new GradientDrawable();
    L4:
        Drawable r10 = DrawableCompat.wrap(r5).mutate();
        this.tabSelectedIndicator = r10;
        DrawableUtils.setTint(r10, this.tabSelectedIndicatorColor);
        int r11 = this.tabIndicatorHeight;
        if (r11 != (-1)) goto L7;
        r11 = this.tabSelectedIndicator.getIntrinsicHeight();
    L7:
        this.slidingTabIndicator.setSelectedIndicatorHeight(r11);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r5) {
        this.tabSelectedIndicatorColor = r5;
        DrawableUtils.setTint(this.tabSelectedIndicator, r5);
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int r5) {
        if (this.tabIndicatorGravity == r5) goto L6;
        this.tabIndicatorGravity = r5;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r5) {
        this.tabIndicatorHeight = r5;
        this.slidingTabIndicator.setSelectedIndicatorHeight(r5);
    }

    public void setTabGravity(int r5) {
        if (this.tabGravity == r5) goto L6;
        this.tabGravity = r5;
        applyModeAndGravity();
        return;
    }

    public void setTabIconTint(@Nullable ColorStateList r5) {
        if (this.tabIconTint == r5) goto L6;
        this.tabIconTint = r5;
        updateAllTabs();
        return;
    }

    public void setTabIconTintResource(@ColorRes int r5) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r5));
    }

    public void setTabIndicatorAnimationMode(int r5) {
        this.tabIndicatorAnimationMode = r5;
        if (r5 != 0) goto L5;
        this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        return;
    L5:
        if (r5 != 1) goto L7;
        this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        return;
    L7:
        if (r5 != 2) goto L10;
        this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
        return;
    L10:
        throw new IllegalArgumentException(r5 + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean r5) {
        this.tabIndicatorFullWidth = r5;
        SlidingTabIndicator.access$100(this.slidingTabIndicator);
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int r5) {
        if (r5 == this.mode) goto L6;
        this.mode = r5;
        applyModeAndGravity();
        return;
    }

    public void setTabRippleColor(@Nullable ColorStateList r5) {
        if (this.tabRippleColorStateList == r5) goto L11;
        this.tabRippleColorStateList = r5;
        int r10 = 0;
    L6:
        if (r10 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r11 = this.slidingTabIndicator.getChildAt(r10);
        if ((r11 instanceof TabView) == false) goto L10;
        TabView.access$200((TabView) r11, getContext());
    L10:
        r10 = r10 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(@ColorRes int r5) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r5));
    }

    public void setTabTextColors(@Nullable ColorStateList r5) {
        if (this.tabTextColors == r5) goto L6;
        this.tabTextColors = r5;
        updateAllTabs();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r5) {
        setPagerAdapter(r5, false);
    }

    public void setUnboundedRipple(boolean r5) {
        if (this.unboundedRipple == r5) goto L11;
        this.unboundedRipple = r5;
        int r10 = 0;
    L6:
        if (r10 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r11 = this.slidingTabIndicator.getChildAt(r10);
        if ((r11 instanceof TabView) == false) goto L10;
        TabView.access$200((TabView) r11, getContext());
    L10:
        r10 = r10 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(@BoolRes int r5) {
        setUnboundedRipple(getResources().getBoolean(r5));
    }

    public void setupWithViewPager(@Nullable ViewPager r5) {
        setupWithViewPager(r5, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateTabViews(boolean r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r11 = this.slidingTabIndicator.getChildAt(r10);
        r11.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r11.getLayoutParams());
        if (r5 == false) goto L8;
        r11.requestLayout();
    L8:
        r10 = r10 + 1;
        goto L4
    }

    public void updateViewPagerScrollState(int r5) {
        this.viewPagerScrollState = r5;
    }

    public TabLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r5) {
        if (this.selectedListeners.contains(r5) == true) goto L6;
        this.selectedListeners.add(r5);
        return;
    }

    public void addTab(@NonNull Tab r5, int r10) {
        addTab(r5, r10, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r5, int r10) {
        addViewInternal(r5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r5) {
        this.selectedListeners.remove(r5);
    }

    public void selectTab(@Nullable Tab r5, boolean r10) {
        Tab r11 = this.selectedTab;
        if (r11 != r5) goto L7;
        if (r11 == null) goto L27;
        dispatchTabReselected(r5);
        animateToTab(r5.getPosition());
        return;
    L27:
        return;
    L7:
        if (r5 == null) goto L9;
        int r12 = r5.getPosition();
    L10:
        if (r10 == false) goto L19;
        if (r11 != null) goto L13;
    L14:
        if (r12 == (-1)) goto L16;
        setScrollPosition(r12, 0.0f, true);
    L17:
        if (r12 == (-1)) goto L19;
        setSelectedTabView(r12);
    L16:
        animateToTab(r12);
        goto L17
    L13:
        if (r11.getPosition() != (-1)) goto L16;
    L19:
        this.selectedTab = r5;
        if (r11 != null) goto L22;
    L24:
        if (r5 == null) goto L29;
        dispatchTabSelected(r5);
        return;
    L29:
        return;
    L22:
        if (r11.parent == null) goto L24;
        dispatchTabUnselected(r11);
        goto L24
    L9:
        r12 = -1;
        goto L10
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r5) {
        BaseOnTabSelectedListener r10 = this.selectedListener;
        if (r10 == null) goto L5;
        removeOnTabSelectedListener(r10);
    L5:
        this.selectedListener = r5;
        if (r5 == null) goto L9;
        addOnTabSelectedListener(r5);
        return;
    }

    public void setScrollPosition(int r10, float r11, boolean r12, boolean r13) {
        setScrollPosition(r10, r11, r12, r13, true);
    }

    public void setupWithViewPager(@Nullable ViewPager r5, boolean r10) {
        setupWithViewPager(r5, r10, false);
    }

    public TabLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.indicatorPosition = -1;
        this.tabs = new ArrayList();
        this.selectedTabTextAppearance = -1;
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.tabIndicatorHeight = -1;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new Pools.SimplePool(12);
        Context r13 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r14 = new SlidingTabIndicator(this, r13);
        this.slidingTabIndicator = r14;
        super.addView(r14, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.TabLayout, r12, r5, new int[]{R.styleable.TabLayout_tabTextAppearance});
        ColorStateList r16 = DrawableUtils.getColorStateListOrNull(getBackground());
        if (r16 == null) goto L5;
        MaterialShapeDrawable r17 = new MaterialShapeDrawable();
        r17.setFillColor(r16);
        r17.initializeElevationOverlay(r13);
        r17.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r17);
    L5:
        setSelectedTabIndicator(MaterialResources.getDrawable(r13, r15, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(r15.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        r14.setSelectedIndicatorHeight(r15.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(r15.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(r15.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(r15.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int r18 = r15.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = r18;
        this.tabPaddingEnd = r18;
        this.tabPaddingTop = r18;
        this.tabPaddingStart = r18;
        this.tabPaddingStart = r15.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, r18);
        this.tabPaddingTop = r15.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = r15.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = r15.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        if (ThemeEnforcement.isMaterial3Theme(r13) == false) goto L8;
        this.defaultTabTextAppearance = R.attr.textAppearanceTitleSmall;
    L9:
        int r19 = r15.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = r19;
        TypedArray r20 = r13.obtainStyledAttributes(r19, androidx.appcompat.R.styleable.TextAppearance);
        this.tabTextSize = r20.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L34
        this.tabTextColors = MaterialResources.getColorStateList(r13, r20, androidx.appcompat.R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L34
        r20.recycle();
        if (r15.hasValue(R.styleable.TabLayout_tabSelectedTextAppearance) == false) goto L14;
        this.selectedTabTextAppearance = r15.getResourceId(R.styleable.TabLayout_tabSelectedTextAppearance, r19);
    L14:
        int r110 = this.selectedTabTextAppearance;
        if (r110 == (-1)) goto L27;
        TypedArray r111 = r13.obtainStyledAttributes(r110, androidx.appcompat.R.styleable.TextAppearance);
        this.selectedTabTextSize = r111.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, (int) this.tabTextSize);     // Catch: Throwable -> L21
        ColorStateList r21 = MaterialResources.getColorStateList(r13, r111, androidx.appcompat.R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L21
        if (r21 == null) goto L23;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r21.getColorForState(new int[]{android.R.attr.state_selected}, r21.getDefaultColor()));     // Catch: Throwable -> L21
    L23:
        r111.recycle();
    L21:
        th = move-exception;
        r111.recycle();
        throw th;
    L27:
        if (r15.hasValue(R.styleable.TabLayout_tabTextColor) == false) goto L30;
        this.tabTextColors = MaterialResources.getColorStateList(r13, r15, R.styleable.TabLayout_tabTextColor);
    L30:
        if (r15.hasValue(R.styleable.TabLayout_tabSelectedTextColor) == false) goto L32;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r15.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
    L32:
        this.tabIconTint = MaterialResources.getColorStateList(r13, r15, R.styleable.TabLayout_tabIconTint);
        this.tabIconTintMode = ViewUtils.parseTintMode(r15.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(r13, r15, R.styleable.TabLayout_tabRippleColor);
        this.tabIndicatorAnimationDuration = r15.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
        this.tabIndicatorTimeInterpolator = MotionUtils.resolveThemeInterpolator(r13, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.requestedTabMinWidth = r15.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
        this.requestedTabMaxWidth = r15.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.tabBackgroundResId = r15.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.contentInsetStart = r15.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
        this.mode = r15.getInt(R.styleable.TabLayout_tabMode, 1);
        this.tabGravity = r15.getInt(R.styleable.TabLayout_tabGravity, 0);
        this.inlineLabel = r15.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
        this.unboundedRipple = r15.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
        r15.recycle();
        Resources r112 = getResources();
        this.tabTextMultiLineSize = r112.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.scrollableTabMinWidth = r112.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
        return;
    L34:
        th = move-exception;
        r20.recycle();
        throw th;
    L8:
        this.defaultTabTextAppearance = R.attr.textAppearanceButton;
        goto L9
    }

    private void setupWithViewPager(@Nullable ViewPager r5, boolean r10, boolean r11) {
        ViewPager r12 = this.viewPager;
        if (r12 == null) goto L10;
        TabLayoutOnPageChangeListener r13 = this.pageChangeListener;
        if (r13 == null) goto L7;
        r12.removeOnPageChangeListener(r13);
    L7:
        AdapterChangeListener r14 = this.adapterChangeListener;
        if (r14 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r14);
    L10:
        BaseOnTabSelectedListener r15 = this.currentVpSelectedListener;
        if (r15 == null) goto L13;
        removeOnTabSelectedListener(r15);
        this.currentVpSelectedListener = null;
    L13:
        if (r5 == null) goto L24;
        this.viewPager = r5;
        if (this.pageChangeListener != null) goto L17;
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
    L17:
        this.pageChangeListener.reset();
        r5.addOnPageChangeListener(this.pageChangeListener);
        ViewPagerOnTabSelectedListener r16 = new ViewPagerOnTabSelectedListener(r5);
        this.currentVpSelectedListener = r16;
        addOnTabSelectedListener(r16);
        PagerAdapter r17 = r5.getAdapter();
        if (r17 == null) goto L21;
        setPagerAdapter(r17, r10);
    L21:
        if (this.adapterChangeListener != null) goto L23;
        this.adapterChangeListener = new AdapterChangeListener(this);
    L23:
        this.adapterChangeListener.setAutoRefresh(r10);
        r5.addOnAdapterChangeListener(this.adapterChangeListener);
        setScrollPosition(r5.getCurrentItem(), 0.0f, true);
    L25:
        this.setupViewPagerImplicitly = r11;
        return;
    L24:
        this.viewPager = null;
        setPagerAdapter(null, false);
        goto L25
    }

    public void addTab(@NonNull Tab r5, boolean r10) {
        addTab(r5, this.tabs.size(), r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r5, ViewGroup.LayoutParams r10) {
        addViewInternal(r5);
    }

    public void setScrollPosition(int r10, float r11, boolean r12, boolean r13, boolean r14) {
        int r5 = Math.round(r10 + r11);
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 >= this.slidingTabIndicator.getChildCount()) goto L48;
        if (r13 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r10, r11);
    L9:
        ValueAnimator r15 = this.scrollAnimator;
        if (r15 != null) goto L12;
    L14:
        int r16 = calculateScrollXForTab(r10, r11);
        int r17 = getScrollX();
        if (r10 >= getSelectedTabPosition()) goto L18;
        if (r16 < r17) goto L18;
    L22:
        boolean r18 = true;
    L25:
        if (ViewCompat.getLayoutDirection(this) == 1) goto L27;
    L36:
        if (r18 == false) goto L38;
    L40:
        if (r10 >= 0) goto L42;
        r16 = 0;
    L42:
        scrollTo(r16, 0);
    L43:
        if (r12 == false) goto L47;
        setSelectedTabView(r5);
        return;
    L47:
        return;
    L38:
        if (this.viewPagerScrollState == 1) goto L40;
        if (r14 == false) goto L43;
    L27:
        if (r10 >= getSelectedTabPosition()) goto L30;
        if (r16 > r17) goto L30;
    L34:
        r18 = true;
    L30:
        if (r10 <= getSelectedTabPosition()) goto L33;
        if (r16 >= r17) goto L34;
    L33:
        if (r10 == getSelectedTabPosition()) goto L34;
        r18 = false;
    L18:
        if (r10 <= getSelectedTabPosition()) goto L21;
        if (r16 <= r17) goto L22;
    L21:
        if (r10 == getSelectedTabPosition()) goto L22;
        r18 = false;
        goto L25
    L12:
        if (r15.isRunning() == false) goto L14;
        this.scrollAnimator.cancel();
        goto L14
    }

    public void addTab(@NonNull Tab r5, int r10, boolean r11) {
        if (r5.parent != this) goto L9;
        configureTab(r5, r10);
        addTabView(r5);
        if (r11 == false) goto L10;
        r5.select();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        addViewInternal(r5);
    }

    public void setTabTextColors(int r5, int r10) {
        setTabTextColors(createColorStateList(r5, r10));
    }

    public void setSelectedTabIndicator(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), r5));
        return;
    L4:
        setSelectedTabIndicator(null);
    }
}
