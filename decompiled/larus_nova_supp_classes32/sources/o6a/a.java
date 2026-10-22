package o6a;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a implements m6a.d, q6a.a, ValueAnimator.AnimatorUpdateListener {
    public View a;
    public final View b;
    public View c;
    public View d;
    public View e;
    public int f;
    public boolean g;
    public boolean h;
    public d i;

    @Override // m6a.d
    public boolean b() {
        if (this.g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.i.b(this.a) == false) goto L7;
        return true;
    }

    @Override // m6a.d
    public boolean canLoadMore() {
        if (this.h == true) goto L5;
    L7:
        return false;
    L5:
        if (this.i.a(this.a) == false) goto L7;
        return true;
    }

    public final void f() {
        this.i.b = null;
    }

    public a(View r2) {
        this.f = 0;
        this.g = true;
        this.h = true;
        this.i = new d();
        this.c = r2;
        this.b = r2;
        this.a = r2;
    }

    @Override // m6a.d
    public void a(MotionEvent r3) {
        PointF r0 = new PointF(r3.getX(), r3.getY());
        r0.offset(-this.a.getLeft(), -this.a.getTop());
        View r4 = this.c;
        View r1 = this.a;
        if (r4 == r1) goto L6;
        this.c = c(r1, r0, r4);
    L6:
        if (this.c != this.a) goto L8;
        this.i.a = null;
        return;
    L8:
        this.i.a = r0;
    }

    public final a e(int r3) {
        View r0 = this.c;
        if (r0 == null) goto L13;
        if (r3 == 0) goto L15;
        if (r3 >= 0) goto L8;
        float r1 = r6a.b.b;
        if (r0.canScrollVertically(1) == false) goto L8;
    L11:
        this.f = r3;
        return this;
    L8:
        if (r3 <= 0) goto L16;
        View r2 = this.c;
        float r4 = r6a.b.b;
        if (r2.canScrollVertically(-1) == true) goto L11;
        return null;
    L16:
        return null;
    L15:
        return null;
    L13:
        return null;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        int r5 = ((Integer) r4.getAnimatedValue()).intValue();
        float r0 = (r5 - this.f) * this.c.getScaleY();     // Catch: Throwable -> L8
        View r1 = this.c;     // Catch: Throwable -> L8
        if ((r1 instanceof AbsListView) == false) goto L6;
        float r2 = r6a.b.b;     // Catch: Throwable -> L8
        ((AbsListView) r1).scrollListBy((int) r0);     // Catch: Throwable -> L8
    L12:
    L10:
        this.f = r5;
        return;
    L6:
        r1.scrollBy(0, (int) r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static View c(View r5, PointF r6, View r7) {
        if ((r5 instanceof ViewGroup) == false) goto L14;
        ViewGroup r8 = (ViewGroup) r5;
        int r0 = r8.getChildCount();
        PointF r1 = new PointF();
    L5:
        if (r0 <= 0) goto L14;
        r0 = r0 - 1;
        View r2 = r8.getChildAt(r0);
        if (r6a.b.e(r8, r2, r6.x, r6.y, r1) == false) goto L5;
        if ((r2 instanceof ViewPager) == false) goto L11;
    L12:
        r6.offset(r1.x, r1.y);
        View r3 = c(r2, r6, r7);
        r6.offset(-r1.x, -r1.y);
        return r3;
    L11:
        if (r6a.b.d(r2) == false) goto L12;
        return r2;
    L14:
        return r7;
    }

    public final void d(int r6, int r7, int r8) {
        boolean r0 = true;
        if (r7 == (-1)) goto L11;
        View r9 = this.b.findViewById(r7);
        if (r9 == null) goto L11;
        if (r6 <= 0) goto L9;
        r9.setTranslationY(r6);
        boolean r10 = true;
    L12:
        if (r8 == (-1)) goto L20;
        View r11 = this.b.findViewById(r8);
        if (r11 == null) goto L20;
        if (r6 >= 0) goto L18;
        r11.setTranslationY(r6);
    L21:
        if (r0 == true) goto L23;
        this.b.setTranslationY(r6);
    L24:
        View r12 = this.d;
        if (r12 == null) goto L27;
        r12.setTranslationY(Math.max(0, r6));
    L27:
        View r13 = this.e;
        if (r13 == null) goto L31;
        r13.setTranslationY(Math.min(0, r6));
        return;
    L31:
        return;
    L23:
        this.b.setTranslationY(0.0f);
        goto L24
    L18:
        if (r11.getTranslationY() >= 0.0f) goto L20;
        r11.setTranslationY(0.0f);
    L20:
        r0 = r10;
        goto L21
    L9:
        if (r9.getTranslationY() <= 0.0f) goto L11;
        r9.setTranslationY(0.0f);
    L11:
        r10 = false;
        goto L12
    }

    public final void g(SmartRefreshLayout.i r17, View r18, View r19) {
        View r0 = this.a;
        boolean r5 = r0.isInEditMode();
        View r7 = null;
    L4:
        if (r7 != null) goto L6;
    L9:
        if (r7 != null) goto L11;
        boolean r11 = true;
    L12:
        LinkedList r12 = new LinkedList();
        r12.add(r0);
        View r13 = null;
    L14:
        if (r12.size() <= 0) goto L29;
        if (r13 != null) goto L29;
        View r14 = (View) r12.poll();
        if (r14 == null) goto L14;
        if (r11 == true) goto L21;
        if (r14 != r0) goto L21;
    L24:
        if ((r14 instanceof ViewGroup) == false) goto L14;
        ViewGroup r15 = (ViewGroup) r14;
        int r16 = 0;
    L27:
        if (r16 >= r15.getChildCount()) goto L14;
        r12.add(r15.getChildAt(r16));
        r16 = r16 + 1;
    L21:
        if (r6a.b.d(r14) == false) goto L24;
        r13 = r14;
    L29:
        if (r13 != null) goto L31;
        r13 = r0;
    L31:
        if (r13 == r7) goto L32;
        if (r5 == true) goto L54;
    L52:
        th = move-exception;
        th.printStackTrace();
        goto L54
    L44:
        if ((r13 instanceof CoordinatorLayout) == false) goto L54;
        r17.a.setNestedScrollingEnabled(false);     // Catch: Throwable -> L52
        ViewGroup r1 = (ViewGroup) r13;     // Catch: Throwable -> L52
        int r6 = r1.getChildCount();     // Catch: Throwable -> L52
    L46:
        r6 = r6 - 1;     // Catch: Throwable -> L52
        if (r6 < 0) goto L54;
        AppBarLayout r8 = r1.getChildAt(r6);     // Catch: Throwable -> L52
        if ((r8 instanceof AppBarLayout) == false) goto L46;
        r8.addOnOffsetChangedListener(new r6a.a(this));     // Catch: Throwable -> L52
    L54:
        r0 = r13;
        r7 = r0;
    L32:
        if (r7 == null) goto L34;
        this.c = r7;
    L34:
        if (r18 != null) goto L36;
        if (r19 != null) goto L36;
        return;
    L36:
        this.d = r18;
        this.e = r19;
        FrameLayout r2 = new FrameLayout(this.a.getContext());
        int r9 = r17.a.getLayout().indexOfChild(this.a);
        r17.a.getLayout().removeView(this.a);
        r2.addView(this.a, 0, new ViewGroup.LayoutParams(-1, -1));
        r17.a.getLayout().addView(r2, r9, this.a.getLayoutParams());
        this.a = r2;
        if (r18 == null) goto L39;
        r18.setTag("fixed-top");
        ViewGroup.LayoutParams r3 = r18.getLayoutParams();
        ViewGroup r10 = (ViewGroup) r18.getParent();
        int r20 = r10.indexOfChild(r18);
        r10.removeView(r18);
        r3.height = r6a.b.f(r18);
        r10.addView(new Space(this.a.getContext()), r20, r3);
        r2.addView(r18, 1, r3);
    L39:
        if (r19 == null) goto L81;
        r19.setTag("fixed-bottom");
        ViewGroup.LayoutParams r4 = r19.getLayoutParams();
        ViewGroup r21 = (ViewGroup) r19.getParent();
        int r22 = r21.indexOfChild(r19);
        r21.removeView(r19);
        FrameLayout.LayoutParams r23 = new FrameLayout.LayoutParams(r4);
        r4.height = r6a.b.f(r19);
        r21.addView(new Space(this.a.getContext()), r22, r4);
        r23.gravity = 80;
        r2.addView(r19, 1, r23);
        return;
    L81:
        return;
    L11:
        r11 = false;
        goto L12
    L6:
        if ((r7 instanceof NestedScrollingParent) == false) goto L32;
        if ((r7 instanceof NestedScrollingChild) == true) goto L32;
        goto L9
    }
}
