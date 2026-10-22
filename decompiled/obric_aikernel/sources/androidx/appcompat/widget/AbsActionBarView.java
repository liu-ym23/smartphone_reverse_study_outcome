package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled;
        int mFinalVisibility;
        final /* synthetic */ AbsActionBarView this$0;

        protected VisibilityAnimListener(AbsActionBarView r10) {
            this.this$0 = r10;
            this.mCanceled = false;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r10) {
            this.mCanceled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            AbsActionBarView r11 = this.this$0;
            r11.mVisibilityAnim = null;
            AbsActionBarView.access$101(r11, this.mFinalVisibility);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r10) {
            AbsActionBarView.access$001(this.this$0, 0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat r10, int r11) {
            this.this$0.mVisibilityAnim = r10;
            this.mFinalVisibility = r11;
            return this;
        }
    }

    AbsActionBarView(@NonNull Context r10) {
        this(r10, null);
    }

    AbsActionBarView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    AbsActionBarView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        TypedValue r13 = new TypedValue();
        if (r10.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, r13, true) == true) goto L5;
    L7:
        this.mPopupContext = r10;
        return;
    L5:
        if (r13.resourceId == 0) goto L7;
        this.mPopupContext = new ContextThemeWrapper(r10, r13.resourceId);
    }

    static /* synthetic */ void access$001(AbsActionBarView r10, int r11) {
        super.setVisibility(r11);
    }

    static /* synthetic */ void access$101(AbsActionBarView r10, int r11) {
        super.setVisibility(r11);
    }

    protected static int next(int r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        return r10 - r11;
    L5:
        return r10 + r11;
    }

    public void animateToVisibility(int r10) {
        setupAnimatorToVisibility(r10, 200).start();
    }

    public boolean canShowOverflowMenu() {
        if (isOverflowReserved() == true) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 == null) goto L6;
        r10.dismissPopupMenus();
        return;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim == null) goto L7;
        return this.mVisAnimListener.mFinalVisibility;
    L7:
        return getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOverflowReserved() == false) goto L7;
        return true;
    }

    protected int measureChildView(View r10, int r11, int r12, int r13) {
        r10.measure(View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE), r12);
        return Math.max(0, (r11 - r10.getMeasuredWidth()) - r13);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        TypedArray r11 = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(r11.getLayoutDimension(R.styleable.ActionBar_height, 0));
        r11.recycle();
        ActionMenuPresenter r12 = this.mActionMenuPresenter;
        if (r12 == null) goto L6;
        r12.onConfigurationChanged(r10);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r12 = super.onHoverEvent(r10);
        if (r11 != 9) goto L12;
        if (r12 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r11 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r11 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r12 = super.onTouchEvent(r10);
        if (r11 != 0) goto L11;
        if (r12 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r11 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r11 != 3) goto L15;
        goto L14
    }

    protected int positionChild(View r10, int r11, int r12, int r13, boolean r14) {
        int r15 = r10.getMeasuredWidth();
        int r16 = r10.getMeasuredHeight();
        int r17 = r12 + ((r13 - r16) / 2);
        if (r14 == false) goto L5;
        r10.layout(r11 - r15, r17, r11, r16 + r17);
    L6:
        if (r14 == true) goto L8;
        return r15;
    L8:
        return -r15;
    L5:
        r10.layout(r11, r17, r11 + r15, r16 + r17);
        goto L6
    }

    public void postShowOverflowMenu() {
        post(new AnonymousClass1(this));
    }

    public void setContentHeight(int r10) {
        this.mContentHeight = r10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        if (r10 == getVisibility()) goto L9;
        ViewPropertyAnimatorCompat r11 = this.mVisibilityAnim;
        if (r11 == null) goto L7;
        r11.cancel();
    L7:
        super.setVisibility(r10);
        return;
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r10, long r11) {
        ViewPropertyAnimatorCompat r12 = this.mVisibilityAnim;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        if (r10 == 0) goto L8;
        ViewPropertyAnimatorCompat r13 = ViewCompat.animate(this).alpha(0.0f);
    L11:
        r13.setDuration(r11);
        r13.setListener(this.mVisAnimListener.withFinalVisibility(r13, r10));
        return r13;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        r13 = ViewCompat.animate(this).alpha(1.0f);
        goto L11
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.showOverflowMenu();
    }
}
