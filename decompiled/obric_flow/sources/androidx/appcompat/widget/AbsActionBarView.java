package androidx.appcompat.widget;

import ai.j0;
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

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled;
        int mFinalVisibility;
        final /* synthetic */ AbsActionBarView this$0;

        public VisibilityAnimListener(AbsActionBarView r5) {
            this.this$0 = r5;
            this.mCanceled = false;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r5) {
            this.mCanceled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r5) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            AbsActionBarView r10 = this.this$0;
            r10.mVisibilityAnim = null;
            AbsActionBarView.access$101(r10, this.mFinalVisibility);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r5) {
            AbsActionBarView.access$001(this.this$0, 0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat r5, int r10) {
            this.this$0.mVisibilityAnim = r5;
            this.mFinalVisibility = r10;
            return this;
        }
    }

    public AbsActionBarView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void access$001(AbsActionBarView r5, int r10) {
        super.setVisibility(r10);
    }

    public static /* synthetic */ void access$101(AbsActionBarView r5, int r10) {
        super.setVisibility(r10);
    }

    public static int next(int r5, int r10, boolean r11) {
        if (r11 == false) goto L5;
        return r5 - r10;
    L5:
        return r5 + r10;
    }

    public void animateToVisibility(int r5) {
        setupAnimatorToVisibility(r5, 200).start();
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
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 == null) goto L6;
        r5.dismissPopupMenus();
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
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isOverflowReserved() == false) goto L7;
        return true;
    }

    public int measureChildView(View r5, int r10, int r11, int r12) {
        r5.measure(View.MeasureSpec.makeMeasureSpec(r10, Integer.MIN_VALUE), r11);
        return Math.max(0, (r10 - r5.getMeasuredWidth()) - r12);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        TypedArray r5 = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(r5.getLayoutDimension(R.styleable.ActionBar_height, 0));
        r5.recycle();
        ActionMenuPresenter r11 = this.mActionMenuPresenter;
        if (r11 == null) goto L6;
        r11.onConfigurationChanged(r10);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r5 = r10.getActionMasked();
        if (r5 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r11 = super.onHoverEvent(r10);
        if (r5 != 9) goto L12;
        if (r11 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r5 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r5 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r10 = r5.getActionMasked();
        if (r10 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r11 = super.onTouchEvent(r5);
        if (r10 != 0) goto L11;
        if (r11 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r10 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r10 != 3) goto L15;
        goto L14
    }

    public int positionChild(View r5, int r10, int r11, int r12, boolean r13) {
        int r14 = r5.getMeasuredWidth();
        int r15 = r5.getMeasuredHeight();
        int r16 = j0.c(r12, r15, 2, r11);
        if (r13 == false) goto L5;
        r5.layout(r10 - r14, r16, r10, r15 + r16);
    L6:
        if (r13 == true) goto L8;
        return r14;
    L8:
        return -r14;
    L5:
        r5.layout(r10, r16, r10 + r14, r15 + r16);
        goto L6
    }

    public void postShowOverflowMenu() {
        post(new AnonymousClass1(this));
    }

    public void setContentHeight(int r5) {
        this.mContentHeight = r5;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        if (r5 == getVisibility()) goto L9;
        ViewPropertyAnimatorCompat r10 = this.mVisibilityAnim;
        if (r10 == null) goto L7;
        r10.cancel();
    L7:
        super.setVisibility(r5);
        return;
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r5, long r10) {
        ViewPropertyAnimatorCompat r11 = this.mVisibilityAnim;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (r5 == 0) goto L8;
        ViewPropertyAnimatorCompat r12 = ViewCompat.animate(this).alpha(0.0f);
        r12.setDuration(r10);
        r12.setListener(this.mVisAnimListener.withFinalVisibility(r12, r5));
        return r12;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        ViewPropertyAnimatorCompat r13 = ViewCompat.animate(this).alpha(1.0f);
        r13.setDuration(r10);
        r13.setListener(this.mVisAnimListener.withFinalVisibility(r13, r5));
        return r13;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.showOverflowMenu();
    }

    public AbsActionBarView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public AbsActionBarView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        TypedValue r12 = new TypedValue();
        if (r5.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, r12, true) == true) goto L5;
    L7:
        this.mPopupContext = r5;
        return;
    L5:
        if (r12.resourceId == 0) goto L7;
        this.mPopupContext = new ContextThemeWrapper(r5, r12.resourceId);
    }
}
