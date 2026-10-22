package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@CoordinatorLayout.DefaultBehavior(b.class)
public class ScrollCoordinatorAppBarLayout extends BaseScrollCoordinatorAppBarLayout {
    public a b;
    public boolean c;
    public b d;

    public interface a {
        void a();

        void b();

        void onFling();
    }

    public class b extends AppBarLayout.Behavior {
        public boolean a;
        public boolean b;
        public Field c;
        public final /* synthetic */ ScrollCoordinatorAppBarLayout d;

        public final Field getFlingRunnableField() throws NoSuchFieldException {
            Field r0 = this.c;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Class r1 = b.class.getSuperclass();
            if (r1 != null) goto L19;
            Class r2 = null;
        L11:
            if (r2 == null) goto L18;
            Field r3 = r2.getDeclaredField("mFlingRunnable");     // Catch: NoSuchFieldException -> L8
            this.c = r3;     // Catch: NoSuchFieldException -> L8
            return r3;
        L8:
            e = move-exception;
            e.printStackTrace();
            Class r4 = r1.getSuperclass().getSuperclass();
            if (r4 == null) goto L18;
            Field r5 = r4.getDeclaredField("flingRunnable");
            this.c = r5;
            return r5;
        L18:
            return null;
        L19:
            r2 = r1.getSuperclass();     // Catch: NoSuchFieldException -> L8
            goto L11
        }

        public b(ScrollCoordinatorAppBarLayout r1) {
            this.d = r1;
            setDragCallback(new d());
        }

        public final void a(AppBarLayout r3) {
            Field r0 = getFlingRunnableField();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r0 == null) goto L7;
            r0.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            Runnable r1 = (Runnable) r0.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r1 == null) goto L7;
            r3.removeCallbacks(r1);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            r0.set(this, null);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        L7:
            Class r4 = b.class.getSuperclass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r4 == null) goto L18;
            r4.getSuperclass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        L20:
            return;
        L18:
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
        }

        public final boolean onInterceptTouchEvent(CoordinatorLayout r2, View r3, MotionEvent r4) {
            AppBarLayout r5 = (AppBarLayout) r3;
            this.b = this.a;
            if (r4.getAction() != 0) goto L11;
            if ((r5 instanceof ScrollCoordinatorAppBarLayout) == false) goto L7;
            boolean r0 = ((ScrollCoordinatorAppBarLayout) r5).c;
        L8:
            if (r0 == false) goto L11;
            a(r5);
            goto L11
        L7:
            r0 = true;
        L11:
            return super/*com.google.android.material.appbar.AppBarLayout.BaseBehavior*/.onInterceptTouchEvent(r2, r5, r4);
        }

        public final void onStopNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4) {
            super.onStopNestedScroll(r1, r2, r3, r4);
            this.a = false;
            this.b = false;
            a r5 = this.d.b;
            if (r5 == null) goto L6;
            r5.b();
            return;
        }

        public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4) {
            onStopNestedScroll(r1, (AppBarLayout) r2, r3, r4);
        }

        public final boolean onNestedFling(CoordinatorLayout r8, View r9, View r10, float r11, float r12, boolean r13) {
            AppBarLayout r2 = (AppBarLayout) r9;
            a r14 = this.d.b;
            if (r14 == null) goto L6;
            r14.onFling();
        L6:
            return super/*androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior*/.onNestedFling(r8, r2, r10, r11, r12, r13);
        }

        public final boolean onStartNestedScroll(CoordinatorLayout r2, AppBarLayout r3, View r4, View r5, int r6, int r7) {
            if ((r3 instanceof ScrollCoordinatorAppBarLayout) == false) goto L5;
            boolean r0 = ((ScrollCoordinatorAppBarLayout) r3).c;
        L6:
            if (r0 == false) goto L8;
            a(r3);
        L8:
            a r1 = this.d.b;
            if (r1 == null) goto L12;
            r1.a();
        L12:
            return super.onStartNestedScroll(r2, r3, r4, r5, r6, r7);
        L5:
            r0 = true;
            goto L6
        }

        public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
            return onStartNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6);
        }

        public final void onNestedPreScroll(CoordinatorLayout r3, AppBarLayout r4, View r5, int r6, int r7, int[] r8, int r9) {
            boolean r0 = true;
            if (r9 != 1) goto L6;
            this.a = true;
        L6:
            if (this.b == false) goto L8;
            return;
        L8:
            if ((r4 instanceof BaseScrollCoordinatorAppBarLayout) == false) goto L10;
            r0 = ((BaseScrollCoordinatorAppBarLayout) r4).a;
        L10:
            if (r0 == false) goto L14;
            super.onNestedPreScroll(r3, r4, r5, r6, r7, r8, r9);
            return;
        }

        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
            onNestedPreScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7);
        }

        public final void onNestedScroll(CoordinatorLayout r2, AppBarLayout r3, View r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.b == true) goto L16;
        L11:
            th = move-exception;
            th.printStackTrace();
            return;
        L5:
            if ((r3 instanceof BaseScrollCoordinatorAppBarLayout) == false) goto L7;
            boolean r0 = ((BaseScrollCoordinatorAppBarLayout) r3).a;     // Catch: Throwable -> L11
        L8:
            if (r0 == false) goto L17;
            super.onNestedScroll(r2, r3, r4, r5, r6, r7, r8, r9);     // Catch: Throwable -> L11
            return;
        L17:
            return;
        L7:
            r0 = true;
            goto L8
        }

        public final /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7, int r8) {
            onNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7, r8);
        }
    }

    public CoordinatorLayout.Behavior getBehavior() {
        if (this.d != null) goto L6;
        this.d = new b(this);
    L6:
        return this.d;
    }

    public int getTopAndBottomOffset() {
        b r0 = this.d;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getTopAndBottomOffset();
    }

    public ScrollCoordinatorAppBarLayout(Context r1) {
        super(r1);
        this.c = true;
    }

    public void setScrollListener(a r1) {
        this.b = r1;
    }

    public void setTouchStopFlingEnabled(boolean r1) {
        this.c = r1;
    }

    public ScrollCoordinatorAppBarLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = true;
    }
}
