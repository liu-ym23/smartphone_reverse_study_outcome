package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private ArrayList<View> mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst;
    private ArrayList<View> mTransitioningFragmentViews;

    public FragmentContainerView(@NonNull Context r10) {
        super(r10);
        this.mDrawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public FragmentContainerView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mDrawDisappearingViewsFirst = true;
        if (r11 == null) goto L15;
        String r13 = r11.getClassAttribute();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.FragmentContainerView);
        if (r13 != null) goto L7;
        r13 = r14.getString(R.styleable.FragmentContainerView_android_name);
        String r15 = "android:name";
    L8:
        r14.recycle();
        if (r13 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r15 + "=\"" + r13 + "\"");
    L7:
        r15 = "class";
        goto L8
    }

    FragmentContainerView(@NonNull Context r10, @NonNull AttributeSet r11, @NonNull FragmentManager r12) {
        super(r10, r11);
        this.mDrawDisappearingViewsFirst = true;
        String r13 = r11.getClassAttribute();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.FragmentContainerView);
        if (r13 != null) goto L5;
        r13 = r14.getString(R.styleable.FragmentContainerView_android_name);
    L5:
        String r15 = r14.getString(R.styleable.FragmentContainerView_android_tag);
        r14.recycle();
        int r16 = getId();
        Fragment r17 = r12.findFragmentById(r16);
        if (r13 == null) goto L15;
        if (r17 != null) goto L15;
        if (r16 > 0) goto L14;
        if (r15 == null) goto L11;
        String r18 = " with tag " + r15;
    L13:
        throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + r13 + r18);
    L11:
        r18 = "";
        goto L13
    L14:
        Fragment r19 = r12.getFragmentFactory().instantiate(r10.getClassLoader(), r13);
        r19.onInflate(r10, r11, null);
        r12.beginTransaction().setReorderingAllowed(true).add(this, r19, r15).commitNowAllowingStateLoss();
    L15:
        r12.onContainerAvailable(this);
    }

    private void addDisappearingFragmentView(@NonNull View r10) {
        ArrayList<View> r11 = this.mTransitioningFragmentViews;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.contains(r10) == true) goto L7;
        return;
    L7:
        if (this.mDisappearingFragmentChildren != null) goto L9;
        this.mDisappearingFragmentChildren = new ArrayList();
    L9:
        this.mDisappearingFragmentChildren.add(r10);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r10, int r11, @Nullable ViewGroup.LayoutParams r12) {
        if (FragmentManager.getViewFragment(r10) == null) goto L7;
        super.addView(r10, r11, r12);
        return;
    L7:
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + r10 + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(@NonNull View r10, int r11, @Nullable ViewGroup.LayoutParams r12, boolean r13) {
        if (FragmentManager.getViewFragment(r10) == null) goto L7;
        return super.addViewInLayout(r10, r11, r12, r13);
    L7:
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + r10 + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(@NonNull WindowInsets r10) {
        WindowInsetsCompat r11 = WindowInsetsCompat.toWindowInsetsCompat(r10);
        View.OnApplyWindowInsetsListener r12 = this.mApplyWindowInsetsListener;
        if (r12 == null) goto L5;
        WindowInsetsCompat r13 = WindowInsetsCompat.toWindowInsetsCompat(r12.onApplyWindowInsets(this, r10));
    L7:
        if (r13.isConsumed() == true) goto L11;
        int r14 = getChildCount();
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L11;
        ViewCompat.dispatchApplyWindowInsets(getChildAt(r15), r13);
        r15 = r15 + 1;
    L11:
        return r10;
    L5:
        r13 = ViewCompat.onApplyWindowInsets(this, r11);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas r10) {
        if (this.mDrawDisappearingViewsFirst == true) goto L5;
    L10:
        super.dispatchDraw(r10);
        return;
    L5:
        if (this.mDisappearingFragmentChildren == null) goto L10;
        int r11 = 0;
    L8:
        if (r11 >= this.mDisappearingFragmentChildren.size()) goto L10;
        super.drawChild(r10, this.mDisappearingFragmentChildren.get(r11), getDrawingTime());
        r11 = r11 + 1;
        goto L8
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NonNull Canvas r10, @NonNull View r11, long r12) {
        if (this.mDrawDisappearingViewsFirst == false) goto L13;
        ArrayList<View> r13 = this.mDisappearingFragmentChildren;
        if (r13 == null) goto L13;
        if (r13.size() <= 0) goto L13;
        if (this.mDisappearingFragmentChildren.contains(r11) == false) goto L13;
        return false;
    L13:
        return super.drawChild(r10, r11, r12);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@NonNull View r10) {
        ArrayList<View> r11 = this.mTransitioningFragmentViews;
        if (r11 == null) goto L9;
        r11.remove(r10);
        ArrayList<View> r12 = this.mDisappearingFragmentChildren;
        if (r12 == null) goto L9;
        if (r12.remove(r10) == false) goto L9;
        this.mDrawDisappearingViewsFirst = true;
    L9:
        super.endViewTransition(r10);
    }

    @Override // android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets r10) {
        return r10;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r10 = getChildCount() - 1;
    L3:
        if (r10 < 0) goto L5;
        addDisappearingFragmentView(getChildAt(r10));
        r10 = r10 - 1;
        goto L3
    L5:
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(@NonNull View r10, boolean r11) {
        if (r11 == false) goto L4;
        addDisappearingFragmentView(r10);
    L4:
        super.removeDetachedView(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View r10) {
        addDisappearingFragmentView(r10);
        super.removeView(r10);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r10) {
        addDisappearingFragmentView(getChildAt(r10));
        super.removeViewAt(r10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@NonNull View r10) {
        addDisappearingFragmentView(r10);
        super.removeViewInLayout(r10);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r10, int r11) {
        int r12 = r10;
    L4:
        if (r12 >= (r10 + r11)) goto L6;
        addDisappearingFragmentView(getChildAt(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        super.removeViews(r10, r11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r10, int r11) {
        int r12 = r10;
    L4:
        if (r12 >= (r10 + r11)) goto L6;
        addDisappearingFragmentView(getChildAt(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        super.removeViewsInLayout(r10, r11);
    }

    void setDrawDisappearingViewsLast(boolean r10) {
        this.mDrawDisappearingViewsFirst = r10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition r10) {
        if (Build.VERSION.SDK_INT >= 18) goto L7;
        super.setLayoutTransition(r10);
        return;
    L7:
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@NonNull View.OnApplyWindowInsetsListener r10) {
        this.mApplyWindowInsetsListener = r10;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@NonNull View r10) {
        if (r10.getParent() == this) goto L5;
    L8:
        super.startViewTransition(r10);
        return;
    L5:
        if (this.mTransitioningFragmentViews != null) goto L7;
        this.mTransitioningFragmentViews = new ArrayList();
    L7:
        this.mTransitioningFragmentViews.add(r10);
        goto L8
    }
}
