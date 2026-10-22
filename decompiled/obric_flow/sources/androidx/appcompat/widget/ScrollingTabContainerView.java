package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = null;
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;

    public class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabAdapter(ScrollingTabContainerView r5) {
            this.this$0 = r5;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r5) {
            return ((TabView) this.this$0.mTabLayout.getChildAt(r5)).getTab();
        }

        @Override // android.widget.Adapter
        public long getItemId(int r5) {
            return r5;
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r10, ViewGroup r11) {
            if (r10 == null) goto L6;
            ((TabView) r10).bindTab((ActionBar.Tab) getItem(r5));
            return r10;
        L6:
            return this.this$0.createTabView((ActionBar.Tab) getItem(r5), true);
        }
    }

    public class TabClickListener implements View.OnClickListener {
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabClickListener(ScrollingTabContainerView r5) {
            this.this$0 = r5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ((TabView) r10).getTab().select();
            int r5 = this.this$0.mTabLayout.getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L9;
            View r12 = this.this$0.mTabLayout.getChildAt(r11);
            if (r12 != r10) goto L7;
            boolean r13 = true;
        L8:
            r12.setSelected(r13);
            r11 = r11 + 1;
            goto L3
        L7:
            r13 = false;
            goto L8
        }
    }

    public class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.Tab mTab;
        private TextView mTextView;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabView(ScrollingTabContainerView r5, Context r10, ActionBar.Tab r11, boolean r12) {
            this.this$0 = r5;
            super(r10, null, R.attr.actionBarTabStyle);
            int[] r13 = {android.R.attr.background};
            this.BG_ATTRS = r13;
            this.mTab = r11;
            TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r10, null, r13, R.attr.actionBarTabStyle, 0);
            if (r14.hasValue(0) == false) goto L5;
            setBackgroundDrawable(r14.getDrawable(0));
        L5:
            r14.recycle();
            if (r12 == false) goto L8;
            setGravity(8388627);
        L8:
            update();
        }

        public void bindTab(ActionBar.Tab r5) {
            this.mTab = r5;
            update();
        }

        public ActionBar.Tab getTab() {
            return this.mTab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
            super.onInitializeAccessibilityEvent(r5);
            r5.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
            super.onInitializeAccessibilityNodeInfo(r5);
            r5.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r5, int r10) {
            super.onMeasure(r5, r10);
            if (this.this$0.mMaxTabWidth <= 0) goto L8;
            int r11 = getMeasuredWidth();
            int r12 = this.this$0.mMaxTabWidth;
            if (r11 <= r12) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY), r10);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setSelected(boolean r5) {
            if (isSelected() == r5) goto L5;
            boolean r10 = true;
        L6:
            super.setSelected(r5);
            if (r10 == false) goto L11;
            if (r5 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r10 = false;
            goto L6
        }

        public void update() {
            ActionBar.Tab r5 = this.mTab;
            View r10 = r5.getCustomView();
            CharSequence r11 = null;
            if (r10 == null) goto L15;
            ViewParent r12 = r10.getParent();
            if (r12 == this) goto L9;
            if (r12 == null) goto L8;
            ((ViewGroup) r12).removeView(r10);
        L8:
            addView(r10);
        L9:
            this.mCustomView = r10;
            TextView r13 = this.mTextView;
            if (r13 == null) goto L12;
            r13.setVisibility(8);
        L12:
            ImageView r14 = this.mIconView;
            if (r14 == null) goto L44;
            r14.setVisibility(8);
            this.mIconView.setImageDrawable(null);
            return;
        L44:
            return;
        L15:
            View r15 = this.mCustomView;
            if (r15 == null) goto L18;
            removeView(r15);
            this.mCustomView = null;
        L18:
            Drawable r16 = r5.getIcon();
            CharSequence r17 = r5.getText();
            if (r16 != null) goto L21;
            ImageView r18 = this.mIconView;
            if (r18 == null) goto L27;
            r18.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L27:
            boolean r19 = TextUtils.isEmpty(r17);
            if (r19 == false) goto L30;
            TextView r20 = this.mTextView;
            if (r20 == null) goto L36;
            r20.setVisibility(8);
            this.mTextView.setText(null);
        L36:
            ImageView r21 = this.mIconView;
            if (r21 == null) goto L39;
            r21.setContentDescription(r5.getContentDescription());
        L39:
            if (r19 == false) goto L42;
            r11 = r5.getContentDescription();
        L42:
            TooltipCompat.setTooltipText(this, r11);
            return;
        L30:
            if (this.mTextView != null) goto L32;
            AppCompatTextView r22 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            r22.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-2, -2);
            r23.gravity = 16;
            r22.setLayoutParams(r23);
            addView(r22);
            this.mTextView = r22;
        L32:
            this.mTextView.setText(r17);
            this.mTextView.setVisibility(0);
            goto L36
        L21:
            if (this.mIconView != null) goto L23;
            AppCompatImageView r24 = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(-2, -2);
            r25.gravity = 16;
            r24.setLayoutParams(r25);
            addView(r24, 0);
            this.mIconView = r24;
        L23:
            this.mIconView.setImageDrawable(r16);
            this.mIconView.setVisibility(0);
            goto L27
        }
    }

    public class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        private int mFinalVisibility;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public VisibilityAnimListener(ScrollingTabContainerView r5) {
            this.this$0 = r5;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            ScrollingTabContainerView r10 = this.this$0;
            r10.mVisibilityAnim = null;
            r10.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            this.this$0.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator r5, int r10) {
            this.mFinalVisibility = r10;
            this.this$0.mVisibilityAnim = r5;
            return this;
        }
    }

    static {
        sAlphaInterpolator = new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(@NonNull Context r5) {
        super(r5);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy r10 = ActionBarPolicy.get(r5);
        setContentHeight(r10.getTabContainerHeight());
        this.mStackedTabMaxWidth = r10.getStackedTabMaxWidth();
        LinearLayoutCompat r11 = createTabLayout();
        this.mTabLayout = r11;
        addView(r11, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        AppCompatSpinner r5 = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        r5.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        r5.setOnItemSelectedListener(this);
        return r5;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat r5 = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        r5.setMeasureWithLargestChildEnabled(true);
        r5.setGravity(17);
        r5.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return r5;
    }

    private boolean isCollapsed() {
        Spinner r5 = this.mTabSpinner;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.getParent() != this) goto L7;
        return true;
    }

    private void performCollapse() {
        if (isCollapsed() == false) goto L6;
        return;
    L6:
        if (this.mTabSpinner != null) goto L8;
        this.mTabSpinner = createSpinner();
    L8:
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() != null) goto L11;
        this.mTabSpinner.setAdapter(new TabAdapter(this));
    L11:
        Runnable r5 = this.mTabSelector;
        if (r5 == null) goto L14;
        removeCallbacks(r5);
        this.mTabSelector = null;
    L14:
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (isCollapsed() == true) goto L5;
        return false;
    L5:
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.Tab r10, boolean r11) {
        TabView r12 = createTabView(r10, false);
        this.mTabLayout.addView(r12, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r5 = this.mTabSpinner;
        if (r5 == null) goto L5;
        ((TabAdapter) r5.getAdapter()).notifyDataSetChanged();
    L5:
        if (r11 == false) goto L8;
        r12.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    public void animateToTab(int r5) {
        final View r10 = this.mTabLayout.getChildAt(r5);
        Runnable r11 = this.mTabSelector;
        if (r11 == null) goto L5;
        removeCallbacks(r11);
    L5:
        Runnable r12 = new AnonymousClass1(this, r10);
        this.mTabSelector = r12;
        post(r12);
    }

    public void animateToVisibility(int r5) {
        ViewPropertyAnimator r10 = this.mVisibilityAnim;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        if (r5 == 0) goto L8;
        ViewPropertyAnimator r11 = animate().alpha(0.0f);
        r11.setDuration(200);
        r11.setInterpolator(sAlphaInterpolator);
        r11.setListener(this.mVisAnimListener.withFinalVisibility(r11, r5));
        r11.start();
        return;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        ViewPropertyAnimator r12 = animate().alpha(1.0f);
        r12.setDuration(200);
        r12.setInterpolator(sAlphaInterpolator);
        r12.setListener(this.mVisAnimListener.withFinalVisibility(r12, r5));
        r12.start();
    }

    public TabView createTabView(ActionBar.Tab r5, boolean r10) {
        TabView r11 = new TabView(this, getContext(), r5, r10);
        if (r10 == false) goto L5;
        r11.setBackgroundDrawable(null);
        r11.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    L9:
        return r11;
    L5:
        r11.setFocusable(true);
        if (this.mTabClickListener != null) goto L8;
        this.mTabClickListener = new TabClickListener(this);
    L8:
        r11.setOnClickListener(this.mTabClickListener);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r5 = this.mTabSelector;
        if (r5 == null) goto L6;
        post(r5);
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        ActionBarPolicy r10 = ActionBarPolicy.get(getContext());
        setContentHeight(r10.getTabContainerHeight());
        this.mStackedTabMaxWidth = r10.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r5 = this.mTabSelector;
        if (r5 == null) goto L6;
        removeCallbacks(r5);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r5, View r10, int r11, long r12) {
        ((TabView) r10).getTab().select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        if (r12 != 1073741824) goto L5;
        boolean r5 = true;
    L6:
        setFillViewport(r5);
        int r13 = this.mTabLayout.getChildCount();
        if (r13 <= 1) goto L16;
        if (r12 == 1073741824) goto L12;
        if (r12 != Integer.MIN_VALUE) goto L16;
    L12:
        if (r13 <= 2) goto L14;
        this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(r10) * 0.4f);
    L15:
        this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    L17:
        int r14 = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, BasicMeasure.EXACTLY);
        if (r5 == false) goto L20;
    L25:
        performExpand();
    L26:
        int r15 = getMeasuredWidth();
        super.onMeasure(r10, r14);
        int r16 = getMeasuredWidth();
        if (r5 == false) goto L31;
        if (r15 == r16) goto L32;
        setTabSelected(this.mSelectedTabIndex);
        return;
    L32:
        return;
    L31:
        return;
    L20:
        if (this.mAllowCollapse == false) goto L25;
        this.mTabLayout.measure(0, r14);
        if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(r10)) goto L24;
        performCollapse();
        goto L26
    L24:
        performExpand();
        goto L26
    L14:
        this.mMaxTabWidth = View.MeasureSpec.getSize(r10) / 2;
    L16:
        this.mMaxTabWidth = -1;
        goto L17
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r5) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner r5 = this.mTabSpinner;
        if (r5 == null) goto L6;
        ((TabAdapter) r5.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void removeTabAt(int r5) {
        this.mTabLayout.removeViewAt(r5);
        Spinner r10 = this.mTabSpinner;
        if (r10 == null) goto L6;
        ((TabAdapter) r10.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void setAllowCollapse(boolean r5) {
        this.mAllowCollapse = r5;
    }

    public void setContentHeight(int r5) {
        this.mContentHeight = r5;
        requestLayout();
    }

    public void setTabSelected(int r10) {
        this.mSelectedTabIndex = r10;
        int r5 = this.mTabLayout.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L12;
        View r12 = this.mTabLayout.getChildAt(r11);
        if (r11 != r10) goto L7;
        boolean r13 = true;
    L8:
        r12.setSelected(r13);
        if (r13 == false) goto L11;
        animateToTab(r10);
    L11:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = false;
        goto L8
    L12:
        Spinner r14 = this.mTabSpinner;
        if (r14 == null) goto L20;
        if (r10 < 0) goto L21;
        r14.setSelection(r10);
        return;
    L21:
        return;
    }

    public void updateTab(int r5) {
        ((TabView) this.mTabLayout.getChildAt(r5)).update();
        Spinner r10 = this.mTabSpinner;
        if (r10 == null) goto L6;
        ((TabAdapter) r10.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void addTab(ActionBar.Tab r10, int r11, boolean r12) {
        TabView r13 = createTabView(r10, false);
        this.mTabLayout.addView(r13, r11, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r14 = this.mTabSpinner;
        if (r14 == null) goto L5;
        ((TabAdapter) r14.getAdapter()).notifyDataSetChanged();
    L5:
        if (r12 == false) goto L8;
        r13.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }
}
