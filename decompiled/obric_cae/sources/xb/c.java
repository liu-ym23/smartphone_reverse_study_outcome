package xb;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ViewPager {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f13775l0;

    public c(Context r8) {
        super(r8);
        this.f13775l0 = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r8) {
        if (this.f13775l0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r8) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r8) {
        if (this.f13775l0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r8) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        if (this.f13775l0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r8) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (this.f13775l0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r8) == false) goto L7;
        return true;
    }
}
