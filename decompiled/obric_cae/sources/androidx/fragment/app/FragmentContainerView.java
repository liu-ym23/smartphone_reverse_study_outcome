package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.cae.location.database.StarLocationDbManager;
import j0.m0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<View> f1858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<View> f1859b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1861n;

    public FragmentContainerView(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        this.f1861n = true;
        if (r10 == null) goto L15;
        String r11 = r10.getClassAttribute();
        TypedArray r12 = r8.obtainStyledAttributes(r10, r0.a.f11308b);
        if (r11 != null) goto L7;
        r11 = r12.getString(0);
        String r13 = "android:name";
    L8:
        r12.recycle();
        if (r11 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r13 + "=\"" + r11 + "\"");
    L7:
        r13 = StarLocationDbManager.GeofenceCallbackEntry.CLASS_NAME;
        goto L8
    }

    public final void a(View r8) {
        ArrayList<View> r10 = this.f1859b;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.contains(r8) == true) goto L7;
        return;
    L7:
        if (this.f1858a != null) goto L9;
        this.f1858a = new ArrayList();
    L9:
        this.f1858a.add(r8);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        Object r12 = r8.getTag(R.id.fragment_container_view_tag);
        if ((r12 instanceof Fragment) == false) goto L5;
        Fragment r13 = (Fragment) r12;
    L6:
        if (r13 == null) goto L10;
        super.addView(r8, r10, r11);
        return;
    L10:
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + r8 + " is not associated with a Fragment.");
    L5:
        r13 = null;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View r8, int r10, ViewGroup.LayoutParams r11, boolean r12) {
        Object r13 = r8.getTag(R.id.fragment_container_view_tag);
        if ((r13 instanceof Fragment) == false) goto L5;
        Fragment r14 = (Fragment) r13;
    L6:
        if (r14 == null) goto L10;
        return super.addViewInLayout(r8, r10, r11, r12);
    L10:
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + r8 + " is not associated with a Fragment.");
    L5:
        r14 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets r8) {
        m0 r10 = m0.h(null, r8);
        View.OnApplyWindowInsetsListener r11 = this.f1860m;
        if (r11 == null) goto L5;
        m0 r12 = m0.h(null, r11.onApplyWindowInsets(this, r8));
    L7:
        if (r12.f8409a.m() == true) goto L11;
        int r13 = getChildCount();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L11;
        j0.w.b(getChildAt(r14), r12);
        r14 = r14 + 1;
    L11:
        return r8;
    L5:
        r12 = j0.w.j(this, r10);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        if (this.f1861n == true) goto L5;
    L10:
        super.dispatchDraw(r8);
        return;
    L5:
        if (this.f1858a == null) goto L10;
        int r10 = 0;
    L8:
        if (r10 >= this.f1858a.size()) goto L10;
        super.drawChild(r8, this.f1858a.get(r10), getDrawingTime());
        r10 = r10 + 1;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r8, View r10, long r11) {
        if (this.f1861n == false) goto L13;
        ArrayList<View> r12 = this.f1858a;
        if (r12 == null) goto L13;
        if (r12.size() <= 0) goto L13;
        if (this.f1858a.contains(r10) == false) goto L13;
        return false;
    L13:
        return super.drawChild(r8, r10, r11);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View r8) {
        ArrayList<View> r10 = this.f1859b;
        if (r10 == null) goto L9;
        r10.remove(r8);
        ArrayList<View> r11 = this.f1858a;
        if (r11 == null) goto L9;
        if (r11.remove(r8) == false) goto L9;
        this.f1861n = true;
    L9:
        super.endViewTransition(r8);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets r8) {
        return r8;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int r8 = getChildCount() - 1;
    L3:
        if (r8 < 0) goto L5;
        a(getChildAt(r8));
        r8 = r8 - 1;
        goto L3
    L5:
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View r8, boolean r10) {
        if (r10 == false) goto L4;
        a(r8);
    L4:
        super.removeDetachedView(r8, r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r8) {
        a(r8);
        super.removeView(r8);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r8) {
        a(getChildAt(r8));
        super.removeViewAt(r8);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View r8) {
        a(r8);
        super.removeViewInLayout(r8);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int r8, int r10) {
        int r11 = r8;
    L4:
        if (r11 >= (r8 + r10)) goto L6;
        a(getChildAt(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        super.removeViews(r8, r10);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int r8, int r10) {
        int r11 = r8;
    L4:
        if (r11 >= (r8 + r10)) goto L6;
        a(getChildAt(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        super.removeViewsInLayout(r8, r10);
    }

    public void setDrawDisappearingViewsLast(boolean r8) {
        this.f1861n = r8;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r8) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener r8) {
        this.f1860m = r8;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View r8) {
        if (r8.getParent() == this) goto L5;
    L8:
        super.startViewTransition(r8);
        return;
    L5:
        if (this.f1859b != null) goto L7;
        this.f1859b = new ArrayList();
    L7:
        this.f1859b.add(r8);
        goto L8
    }

    public FragmentContainerView(Context r8, AttributeSet r10, FragmentManager r11) {
        super(r8, r10);
        this.f1861n = true;
        String r12 = r10.getClassAttribute();
        TypedArray r13 = r8.obtainStyledAttributes(r10, r0.a.f11308b);
        if (r12 != null) goto L5;
        r12 = r13.getString(0);
    L5:
        String r14 = r13.getString(1);
        r13.recycle();
        int r15 = getId();
        Fragment r16 = r11.B(r15);
        if (r12 == null) goto L19;
        if (r16 != null) goto L19;
        if (r15 > 0) goto L14;
        if (r14 == null) goto L11;
        String r17 = " with tag ".concat(r14);
    L13:
        throw new IllegalStateException(defpackage.b.d("FragmentContainerView must have an android:id to add Fragment ", r12, r17));
    L11:
        r17 = "";
        goto L13
    L14:
        q r18 = r11.D();
        r8.getClassLoader();
        Fragment r19 = Fragment.instantiate(((FragmentManager.e) r18).f1893b.f1877p.f2043b, r12, null);
        r19.onInflate(r8, r10, null);
        a r20 = new a(r11);
        r20.f2082p = true;
        r19.mContainer = this;
        r20.e(getId(), r19, r14, 1);
        if (r20.f2073g == true) goto L18;
        r20.f2074h = false;
        r20.f1923q.y(r20, true);
        goto L19
    L18:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    L19:
        Iterator r21 = r11.f1864c.d().iterator();
    L21:
        if (r21.hasNext() == false) goto L29;
        x r22 = (x) r21.next();
        Fragment r23 = r22.f2060c;
        if (r23.mContainerId != getId()) goto L21;
        View r24 = r23.mView;
        if (r24 == null) goto L21;
        if (r24.getParent() != null) goto L21;
        r23.mContainer = this;
        r22.b();
        goto L21
    }
}
