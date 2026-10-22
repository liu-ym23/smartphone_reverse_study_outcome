package com.larus.community.impl.share;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/share/CreationViewPagerBottomSheetBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", "startX", "", "startY", "isHorizontalSwipe", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "onLayoutChild", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "layoutDirection", "", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onTouchEvent", "isTouchInsideViewPager", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationViewPagerBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public float a;
    public float b;
    public boolean c;
    public ViewPager2 d;

    public CreationViewPagerBottomSheetBehavior() {
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        int r0 = r12.getAction();
        if (r0 != 0) goto L5;
        this.a = r12.getX();
        this.b = r12.getY();
        this.c = false;
    L35:
        return super.onInterceptTouchEvent(r10, r11, r12);
    L5:
        if (r0 != 1) goto L7;
    L32:
        this.c = false;
        goto L35
    L7:
        if (r0 != 2) goto L9;
        float r1 = Math.abs(r12.getX() - this.a);
        float r4 = Math.abs(r12.getY() - this.b);
        ViewPager2 r5 = this.d;
        if (r5 == null) goto L22;
        int[] r3 = new int[2];
        r5.getLocationOnScreen(r3);
        int r6 = r3[0];
        int r7 = r3[1];
        if (r12.getRawX() < r6) goto L22;
        if (r12.getRawX() > (r6 + r5.getWidth())) goto L22;
        if (r12.getRawY() < r7) goto L22;
        if (r12.getRawY() > (r7 + r5.getHeight())) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L35;
        if (r4 > r1) goto L27;
    L30:
        this.c = true;
        return super.onInterceptTouchEvent(r10, r11, r12);
    L27:
        if (r4 <= 1.0f) goto L30;
        this.c = false;
        return true;
    L22:
        r8 = false;
        goto L23
    L9:
        if (r0 == 3) goto L32;
        goto L32
    }

    public final boolean onLayoutChild(CoordinatorLayout r2, V r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        boolean r5 = super.onLayoutChild(r2, r3, r4);
        this.d = r3.findViewById(2131392567);
        return r5;
    }

    public final boolean onTouchEvent(CoordinatorLayout r2, V r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.c == false) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2, r3, r4);
    }
}
