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

    private class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView this$0;

        TabAdapter(ScrollingTabContainerView r10) {
            this.this$0 = r10;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            return ((TabView) this.this$0.mTabLayout.getChildAt(r10)).getTab();
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 == null) goto L6;
            ((TabView) r11).bindTab((ActionBar.Tab) getItem(r10));
            return r11;
        L6:
            return this.this$0.createTabView((ActionBar.Tab) getItem(r10), true);
        }
    }

    private class TabClickListener implements View.OnClickListener {
        final /* synthetic */ ScrollingTabContainerView this$0;

        TabClickListener(ScrollingTabContainerView r10) {
            this.this$0 = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ((TabView) r10).getTab().select();
            int r11 = this.this$0.mTabLayout.getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            View r13 = this.this$0.mTabLayout.getChildAt(r12);
            if (r13 != r10) goto L7;
            boolean r14 = true;
        L8:
            r13.setSelected(r14);
            r12 = r12 + 1;
            goto L3
        L7:
            r14 = false;
            goto L8
        }
    }

    private class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.Tab mTab;
        private TextView mTextView;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabView(ScrollingTabContainerView r10, Context r11, ActionBar.Tab r12, boolean r13) {
            this.this$0 = r10;
            int r14 = R.attr.actionBarTabStyle;
            super(r11, null, r14);
            int[] r15 = {android.R.attr.background};
            this.BG_ATTRS = r15;
            this.mTab = r12;
            TintTypedArray r16 = TintTypedArray.obtainStyledAttributes(r11, null, r15, r14, 0);
            if (r16.hasValue(0) == false) goto L5;
            setBackgroundDrawable(r16.getDrawable(0));
        L5:
            r16.recycle();
            if (r13 == false) goto L8;
            setGravity(8388627);
        L8:
            update();
        }

        public void bindTab(ActionBar.Tab r10) {
            this.mTab = r10;
            update();
        }

        public ActionBar.Tab getTab() {
            return this.mTab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r10);
            r10.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            r10.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (this.this$0.mMaxTabWidth <= 0) goto L8;
            int r12 = getMeasuredWidth();
            int r13 = this.this$0.mMaxTabWidth;
            if (r12 <= r13) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), r11);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setSelected(boolean r10) {
            if (isSelected() == r10) goto L5;
            boolean r11 = true;
        L6:
            super.setSelected(r10);
            if (r11 == false) goto L11;
            if (r10 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r11 = false;
            goto L6
        }

        public void update() {
            ActionBar.Tab r10 = this.mTab;
            View r11 = r10.getCustomView();
            CharSequence r12 = null;
            if (r11 == null) goto L15;
            ViewParent r13 = r11.getParent();
            if (r13 == this) goto L9;
            if (r13 == null) goto L8;
            ((ViewGroup) r13).removeView(r11);
        L8:
            addView(r11);
        L9:
            this.mCustomView = r11;
            TextView r14 = this.mTextView;
            if (r14 == null) goto L12;
            r14.setVisibility(8);
        L12:
            ImageView r15 = this.mIconView;
            if (r15 == null) goto L44;
            r15.setVisibility(8);
            this.mIconView.setImageDrawable(null);
            return;
        L44:
            return;
        L15:
            View r16 = this.mCustomView;
            if (r16 == null) goto L18;
            removeView(r16);
            this.mCustomView = null;
        L18:
            Drawable r17 = r10.getIcon();
            CharSequence r18 = r10.getText();
            if (r17 != null) goto L21;
            ImageView r19 = this.mIconView;
            if (r19 == null) goto L27;
            r19.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L27:
            boolean r20 = !TextUtils.isEmpty(r18);
            if (r20 == true) goto L30;
            TextView r21 = this.mTextView;
            if (r21 == null) goto L36;
            r21.setVisibility(8);
            this.mTextView.setText(null);
        L36:
            ImageView r22 = this.mIconView;
            if (r22 == null) goto L39;
            r22.setContentDescription(r10.getContentDescription());
        L39:
            if (r20 == true) goto L42;
            r12 = r10.getContentDescription();
        L42:
            TooltipCompat.setTooltipText(this, r12);
            return;
        L30:
            if (this.mTextView != null) goto L32;
            AppCompatTextView r23 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            r23.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-2, -2);
            r24.gravity = 16;
            r23.setLayoutParams(r24);
            addView(r23);
            this.mTextView = r23;
        L32:
            this.mTextView.setText(r18);
            this.mTextView.setVisibility(0);
            goto L36
        L21:
            if (this.mIconView != null) goto L23;
            AppCompatImageView r25 = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-2, -2);
            r26.gravity = 16;
            r25.setLayoutParams(r26);
            addView(r25, 0);
            this.mIconView = r25;
        L23:
            this.mIconView.setImageDrawable(r17);
            this.mIconView.setVisibility(0);
            goto L27
        }
    }

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        private int mFinalVisibility;
        final /* synthetic */ ScrollingTabContainerView this$0;

        protected VisibilityAnimListener(ScrollingTabContainerView r10) {
            this.this$0 = r10;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            ScrollingTabContainerView r11 = this.this$0;
            r11.mVisibilityAnim = null;
            r11.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.this$0.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator r10, int r11) {
            this.mFinalVisibility = r11;
            this.this$0.mVisibilityAnim = r10;
            return this;
        }
    }

    static {
        sAlphaInterpolator = new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(@NonNull Context r10) {
        super(r10);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy r11 = ActionBarPolicy.get(r10);
        setContentHeight(r11.getTabContainerHeight());
        this.mStackedTabMaxWidth = r11.getStackedTabMaxWidth();
        LinearLayoutCompat r12 = createTabLayout();
        this.mTabLayout = r12;
        addView(r12, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        AppCompatSpinner r10 = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        r10.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        r10.setOnItemSelectedListener(this);
        return r10;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat r10 = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        r10.setMeasureWithLargestChildEnabled(true);
        r10.setGravity(17);
        r10.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return r10;
    }

    private boolean isCollapsed() {
        Spinner r10 = this.mTabSpinner;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getParent() != this) goto L7;
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
        Runnable r10 = this.mTabSelector;
        if (r10 == null) goto L14;
        removeCallbacks(r10);
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

    public void addTab(ActionBar.Tab r10, boolean r11) {
        TabView r12 = createTabView(r10, false);
        this.mTabLayout.addView(r12, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r13 = this.mTabSpinner;
        if (r13 == null) goto L5;
        ((TabAdapter) r13.getAdapter()).notifyDataSetChanged();
    L5:
        if (r11 == false) goto L8;
        r12.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    public void animateToTab(int r10) {
        final View r11 = this.mTabLayout.getChildAt(r10);
        Runnable r12 = this.mTabSelector;
        if (r12 == null) goto L5;
        removeCallbacks(r12);
    L5:
        Runnable r13 = new AnonymousClass1(this, r11);
        this.mTabSelector = r13;
        post(r13);
    }

    public void animateToVisibility(int r10) {
        ViewPropertyAnimator r11 = this.mVisibilityAnim;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (r10 == 0) goto L8;
        ViewPropertyAnimator r12 = animate().alpha(0.0f);
    L12:
        r12.setDuration(200);
        r12.setInterpolator(sAlphaInterpolator);
        r12.setListener(this.mVisAnimListener.withFinalVisibility(r12, r10));
        r12.start();
        return;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        r12 = animate().alpha(1.0f);
        goto L12
    }

    TabView createTabView(ActionBar.Tab r10, boolean r11) {
        TabView r12 = new TabView(this, getContext(), r10, r11);
        if (r11 == false) goto L5;
        r12.setBackgroundDrawable(null);
        r12.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    L9:
        return r12;
    L5:
        r12.setFocusable(true);
        if (this.mTabClickListener != null) goto L8;
        this.mTabClickListener = new TabClickListener(this);
    L8:
        r12.setOnClickListener(this.mTabClickListener);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r10 = this.mTabSelector;
        if (r10 == null) goto L6;
        post(r10);
        return;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        ActionBarPolicy r11 = ActionBarPolicy.get(getContext());
        setContentHeight(r11.getTabContainerHeight());
        this.mStackedTabMaxWidth = r11.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r10 = this.mTabSelector;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r10, View r11, int r12, long r13) {
        ((TabView) r11).getTab().select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        boolean r13 = true;
        if (r12 != 1073741824) goto L5;
        boolean r14 = true;
    L6:
        setFillViewport(r14);
        int r15 = this.mTabLayout.getChildCount();
        if (r15 <= 1) goto L16;
        if (r12 == 1073741824) goto L12;
        if (r12 != Integer.MIN_VALUE) goto L16;
    L12:
        if (r15 <= 2) goto L14;
        this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(r10) * 0.4f);
    L15:
        int r16 = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    L17:
        this.mMaxTabWidth = r16;
        int r17 = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (r14 == false) goto L20;
    L22:
        r13 = false;
    L23:
        if (r13 == false) goto L27;
        this.mTabLayout.measure(0, r17);
        if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(r10)) goto L27;
        performCollapse();
    L28:
        int r18 = getMeasuredWidth();
        super.onMeasure(r10, r17);
        int r19 = getMeasuredWidth();
        if (r14 == false) goto L33;
        if (r18 == r19) goto L34;
        setTabSelected(this.mSelectedTabIndex);
        return;
    L34:
        return;
    L33:
        return;
    L27:
        performExpand();
        goto L28
    L20:
        if (this.mAllowCollapse == false) goto L22;
    L14:
        this.mMaxTabWidth = View.MeasureSpec.getSize(r10) / 2;
    L16:
        r16 = -1;
        goto L17
    L5:
        r14 = false;
        goto L6
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r10) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner r10 = this.mTabSpinner;
        if (r10 == null) goto L6;
        ((TabAdapter) r10.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void removeTabAt(int r10) {
        this.mTabLayout.removeViewAt(r10);
        Spinner r11 = this.mTabSpinner;
        if (r11 == null) goto L6;
        ((TabAdapter) r11.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void setAllowCollapse(boolean r10) {
        this.mAllowCollapse = r10;
    }

    public void setContentHeight(int r10) {
        this.mContentHeight = r10;
        requestLayout();
    }

    public void setTabSelected(int r10) {
        this.mSelectedTabIndex = r10;
        int r11 = this.mTabLayout.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        View r13 = this.mTabLayout.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r14 = true;
    L8:
        r13.setSelected(r14);
        if (r14 == false) goto L11;
        animateToTab(r10);
    L11:
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = false;
        goto L8
    L12:
        Spinner r15 = this.mTabSpinner;
        if (r15 == null) goto L20;
        if (r10 < 0) goto L21;
        r15.setSelection(r10);
        return;
    L21:
        return;
    }

    public void updateTab(int r10) {
        ((TabView) this.mTabLayout.getChildAt(r10)).update();
        Spinner r11 = this.mTabSpinner;
        if (r11 == null) goto L6;
        ((TabAdapter) r11.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }
}
