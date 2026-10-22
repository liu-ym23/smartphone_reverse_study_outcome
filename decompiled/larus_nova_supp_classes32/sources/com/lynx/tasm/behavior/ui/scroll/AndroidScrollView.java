package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x6a.e;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AndroidScrollView extends NestedScrollView implements IDrawChildHook.IDrawChildHookBinding, e {
    public static final /* synthetic */ int R = 0;
    public i A;
    public final c B;
    public int C;
    public int D;
    public final Rect E;
    public com.lynx.tasm.behavior.ui.scroll.b F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public Rect Q;
    public boolean l;
    public Boolean m;
    public Boolean n;
    public final UIScrollView o;
    public g7a.a p;
    public boolean q;
    public CustomHorizontalScrollView r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public ArrayList<b> y;
    public IDrawChildHook z;

    public class CustomHorizontalScrollView extends NestedHorizontalScrollView {
        public final /* synthetic */ AndroidScrollView s;

        @Override // android.widget.HorizontalScrollView
        public final int computeScrollDeltaToGetChildRectOnScreen(Rect r2) {
            if (this.s.H == false) goto L5;
            return 0;
        L5:
            return super.computeScrollDeltaToGetChildRectOnScreen(r2);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r4) {
            if (this.s.o.isEnableNewGesture() == false) goto L15;
            if (Boolean.FALSE.equals(this.s.m) == false) goto L8;
            return true;
        L8:
            if (r4.getActionMasked() != 2) goto L15;
            AndroidScrollView r0 = this.s;
            if (r0.m == null) goto L15;
            if (r0.l == true) goto L15;
            r4.setAction(0);
            this.s.l = true;
        L15:
            return super.dispatchTouchEvent(r4);
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView
        public final void fling(int r15) {
            AndroidScrollView r0 = this.s;
            if (r0.O != 1) goto L5;
            r0.g(2);
        L5:
            ArrayList<b> r1 = this.s.y;
            if (r1 == null) goto L13;
            Iterator<b> r2 = r1.iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            b r3 = r2.next();
            if (r3 == null) goto L9;
            r3.onFling();
        L13:
            if (r15 == 0) goto L18;
            if (this.s.k(r15) == false) goto L18;
            return;
        L18:
            if (this.s.L == true) goto L20;
        L36:
            super.fling(r15);
            return;
        L20:
            if (this.a == true) goto L36;
            Field r4 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L33
            if (r4 == null) goto L32;
            r4.setAccessible(true);     // Catch: Throwable -> L33
            OverScroller r5 = (OverScroller) r4.get(this);     // Catch: Throwable -> L33
            if (r5 == null) goto L30;
            if (getChildCount() <= 0) goto L44;
            int r6 = (getWidth() - getPaddingRight()) - getPaddingLeft();
            int r7 = getChildAt(0).getWidth();
            r5.fling(getScrollX(), getScrollY(), r15, 0, 0, Math.max(0, r7 - r6), 0, 0, r6 / 2, 0);
            postInvalidateOnAnimation();
            return;
        L44:
            return;
        L30:
            throw new Exception("failed to get mScroller in HorizontalScrollView");     // Catch: Throwable -> L33
        L32:
            throw new Exception("can not find mScroller field in HorizontalScrollView");     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            LLog.w("AndroidScrollView", th.getMessage());
            super.fling(r15);
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r5) {
            AndroidScrollView r0 = this.s;
            boolean r2 = false;
            if (r0.u == true) goto L5;
            return false;
        L5:
            if (r0.k == false) goto L8;
            return true;
        L8:
            if (r0.e(r5) == false) goto L11;
            return false;
        L11:
            if (this.s.f() == false) goto L13;
            return false;
        L13:
            AndroidScrollView r1 = this.s;
            if (r1.o.isEnableNewGesture() == true) goto L16;
        L18:
            boolean r3 = false;
        L19:
            if (r3 == true) goto L21;
        L23:
            if (r2 == false) goto L27;
            return this.s.n.booleanValue();
        L27:
            return super.onInterceptTouchEvent(r5);
        L21:
            if (r1.n.booleanValue() == false) goto L23;
            r2 = true;
            goto L23
        L16:
            if (r1.n == null) goto L18;
            r3 = true;
            goto L19
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
        public final boolean onTouchEvent(MotionEvent r8) {
            AndroidScrollView r1 = this.s;
            if (r1.u == true) goto L5;
        L68:
            return false;
        L5:
            if (r1.j == false) goto L8;
            return false;
        L8:
            if (r1.f() == false) goto L10;
            return false;
        L10:
            AndroidScrollView r2 = this.s;
            if (r2.e(r8) == true) goto L13;
            boolean r3 = false;
        L17:
            if (r3 == false) goto L19;
            return false;
        L19:
            AndroidScrollView r4 = this.s;
            if (r4.o.isEnableNewGesture() == true) goto L22;
        L24:
            boolean r5 = false;
        L26:
            if (r5 == true) goto L28;
        L41:
            AndroidScrollView r6 = this.s;
            if (r8.getAction() != 2) goto L44;
            boolean r7 = true;
        L45:
            r6.M = r7;
            if (r8.getAction() != 1) goto L49;
            AndroidScrollView r9 = this.s;
            r9.v = false;
            r9.M = false;
            r9.o.z0();
        L69:
            boolean r0 = super.onTouchEvent(r8);     // Catch: IllegalStateException -> L59 Throwable -> L65
            goto L66
        L56:
            if (r8.getAction() != 1) goto L58;
            this.s.j();
        L58:
            return r0;
        L59:
            e = move-exception;
            LLog.e("LynxUIScrollView", "CustomHorizontalScrollView onTouchEvent: " + r8.getAction() + ", " + e.getMessage());     // Catch: Throwable -> L65
            if (r8.getAction() != 1) goto L64;
            this.s.j();
        L64:
            return false;
        L66:
            if (r8.getAction() != 1) goto L68;
            this.s.j();
            goto L68
        L49:
            if (r8.getAction() != 0) goto L52;
            this.s.d();
            goto L69
        L52:
            if (r8.getAction() != 3) goto L69;
            this.s.M = false;
            goto L69
        L44:
            r7 = false;
            goto L45
        L28:
            if (r8.getActionMasked() != 0) goto L31;
            getParent().requestDisallowInterceptTouchEvent(true);
            goto L41
        L31:
            if (r8.getActionMasked() != 2) goto L37;
            getParent().requestDisallowInterceptTouchEvent(this.s.n.booleanValue());
            boolean r10 = this.s.n.booleanValue();
            if (this.s.n.booleanValue() == false) goto L35;
            return r10;
        L35:
            return super.onTouchEvent(r8);
        L37:
            if (r8.getActionMasked() != 1) goto L39;
        L40:
            this.s.n = null;
            goto L41
        L39:
            if (r8.getActionMasked() != 3) goto L41;
        L22:
            if (r4.n == null) goto L24;
            r5 = true;
            goto L26
        L13:
            if (r8.getActionMasked() != 1) goto L15;
            r2.v = false;
        L15:
            r3 = true;
            goto L17
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.view.View
        public final boolean dispatchNestedPreFling(float r2, float r3) {
            boolean r4 = super.dispatchNestedPreFling(r2, r3);
            if (r4 == false) goto L5;
            AndroidScrollView r5 = this.s;
            int r0 = AndroidScrollView.R;
            r5.m(4);
        L5:
            return r4;
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r1, int r2) {
            super.onMeasure(r1, r2);
        }

        public CustomHorizontalScrollView(AndroidScrollView r1, Context r2, UIScrollView r3) {
            this.s = r1;
            super(r2, r3);
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.view.View
        public final boolean dispatchNestedFling(float r1, float r2, boolean r3) {
            boolean r4 = super.dispatchNestedFling(r1, r2, r3);
            if (r4 == false) goto L5;
            AndroidScrollView r5 = this.s;
            int r6 = AndroidScrollView.R;
            r5.m(4);
        L5:
            return r4;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.view.View
        public final boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
            boolean r5 = super.dispatchNestedPreScroll(r1, r2, r3, r4);
            if (r5 == false) goto L5;
            AndroidScrollView r6 = this.s;
            int r7 = AndroidScrollView.R;
            r6.m(4);
        L5:
            return r5;
        }

        @Override // android.view.View
        public final void onScrollChanged(int r3, int r4, int r5, int r6) {
            super.onScrollChanged(r3, r4, r5, r6);
            AndroidScrollView r0 = this.s;
            if (r3 != r0.t) goto L5;
            return;
        L5:
            r0.t = getScrollX();
            AndroidScrollView r1 = this.s;
            if (r1.O != 0) goto L8;
            r1.l();
        L8:
            ArrayList<b> r2 = this.s.y;
            if (r2 == null) goto L16;
            Iterator<b> r7 = r2.iterator();
        L12:
            if (r7.hasNext() == false) goto L16;
            b r8 = r7.next();
            if (r8 == null) goto L12;
            r8.onScrollChanged(r3, r4, r5, r6);
        L16:
            AndroidScrollView r9 = this.s;
            if (r9.v == false) goto L19;
            return;
        L19:
            if (r9.G == true) goto L28;
            r9.o.z0();
            return;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView
        public final boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4, int r5) {
            boolean r6 = super.dispatchNestedPreScroll(r1, r2, r3, r4, r5);
            if (r6 == false) goto L5;
            AndroidScrollView r7 = this.s;
            int r8 = AndroidScrollView.R;
            r7.m(4);
        L5:
            return r6;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.view.View
        public final boolean dispatchNestedScroll(int r1, int r2, int r3, int r4, int[] r5) {
            boolean r6 = super.dispatchNestedScroll(r1, r2, r3, r4, r5);
            if (r6 == false) goto L5;
            AndroidScrollView r7 = this.s;
            int r8 = AndroidScrollView.R;
            r7.m(4);
        L5:
            return r6;
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
            int r0 = getScrollX();
            super.onLayout(r2, r3, r4, r5, r6);
            if (this.s.u == true) goto L6;
            return;
        L6:
            if (getChildCount() <= 0) goto L8;
            int r7 = getChildAt(0).getMeasuredWidth();
        L9:
            int r8 = Math.max(0, r7 - (((r5 - r3) - getPaddingLeft()) - getPaddingRight()));
            if (this.s.K == false) goto L17;
            if (ViewCompat.getLayoutDirection(this) != 1) goto L14;
            int r9 = r8;
        L15:
            setScrollX(r9);
            AndroidScrollView r10 = this.s;
            r10.K = false;
            r10.t = getScrollX();
        L28:
            this.s.J = r8;
            int r11 = this.r.f;
            if (this.c == false) goto L35;
            if (r11 > 0) goto L32;
            return;
        L32:
            if (r11 == getScrollX()) goto L37;
            this.s.i(r11, getScrollY(), false);
            return;
        L37:
            return;
        L35:
            return;
        L14:
            r9 = 0;
            goto L15
        L17:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L28;
            if (ViewCompat.isLaidOut(this) == true) goto L23;
            AndroidScrollView r12 = this.s;
            if (r12.J != r8) goto L23;
            setScrollX(r12.t);
        L27:
            AndroidScrollView r13 = this.s;
            r13.t = getScrollX();
        L23:
            int r14 = this.s.J;
            if (r14 == r8) goto L27;
            if (r14 < 0) goto L27;
            setScrollX(MathUtils.clamp(r0 + (r8 - r14), 0, r8));
            goto L27
        L8:
            r7 = 0;
            goto L9
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView
        public final boolean dispatchNestedScroll(int r1, int r2, int r3, int r4, int[] r5, int r6) {
            boolean r7 = super.dispatchNestedScroll(r1, r2, r3, r4, r5, r6);
            if (r7 == false) goto L5;
            AndroidScrollView r8 = this.s;
            int r9 = AndroidScrollView.R;
            r8.m(4);
        L5:
            return r7;
        }
    }

    public class a implements View.OnTouchListener {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return !this.a;
        }
    }

    public interface b {
        void a();

        void b();

        void onFling();

        void onScrollChanged(int r1, int r2, int r3, int r4);

        void onScrollStateChanged(int r1);
    }

    public static class c implements Runnable {
        public final WeakReference<AndroidScrollView> a;

        public final void a() {
            if (this.a.get() == null) goto L33;
            AndroidScrollView r0 = this.a.get();
            int r1 = r0.getScrollY();
            int r2 = r0.r.getScrollX();
            boolean r3 = r0.u;
            if (r3 == true) goto L7;
        L8:
            if (r3 == false) goto L10;
        L12:
            boolean r4 = false;
        L14:
            if (r0.v == true) goto L26;
            if (r4 == false) goto L26;
            r0.g(0);
            ArrayList<b> r5 = r0.y;
            if (r5 == null) goto L25;
            Iterator<b> r6 = r5.iterator();
        L21:
            if (r6.hasNext() == false) goto L25;
            b r7 = r6.next();
            if (r7 == null) goto L21;
            r7.b();
        L25:
            r0.o.z0();
            return;
        L26:
            r0.C = r1;
            r0.D = r2;
            r0.postDelayed(this, 100);
            return;
        L10:
            if ((r0.C - r1) != 0) goto L12;
        L11:
            r4 = true;
            goto L14
        L7:
            if ((r0.D - r2) == 0) goto L11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(AndroidScrollView r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class d implements Runnable {
        public final WeakReference<AndroidScrollView> a;

        public final void a() {
            WeakReference<AndroidScrollView> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() != null) goto L7;
            return;
        L7:
            if (this.a.get().p == null) goto L46;
            AndroidScrollView r1 = this.a.get();
            if (r1.G == false) goto L47;
            int r2 = r1.getRealScrollX();
            int r3 = r1.getRealScrollY();
            int r4 = r1.I;
            g7a.a r5 = r1.p;
            if (r1.u == true) goto L21;
            int r6 = r3 + r4;
            r1.i(r2, r6, false);
            if (r4 >= 0) goto L18;
            if (r3 > 0) goto L16;
            r1.G = false;
            return;
        L16:
            r1.postDelayed(this, 16);
            return;
        L18:
            if ((r6 + r1.getMeasuredHeight()) >= r5.getMeasuredHeight()) goto L20;
            r1.postDelayed(this, 16);
            return;
        L20:
            r1.G = false;
            return;
        L21:
            boolean r9 = true;
            if (ViewCompat.getLayoutDirection(r1) != 1) goto L24;
            int r7 = r2 - r4;
        L25:
            r1.i(r7, r3, false);
            if (r4 < 0) goto L28;
            if (r7 > 0) goto L40;
        L42:
            r1.G = false;
            return;
        L40:
            if ((r7 + r1.getMeasuredWidth()) >= r5.getMeasuredWidth()) goto L42;
            r1.postDelayed(this, 16);
            return;
        L28:
            if (ViewCompat.getLayoutDirection(r1) != 0) goto L32;
            if (r2 <= 0) goto L35;
        L34:
            r9 = false;
        L35:
            if (r9 == false) goto L37;
            r1.G = false;
            return;
        L37:
            r1.postDelayed(this, 16);
            return;
        L32:
            if ((r7 + r1.getMeasuredWidth()) < r5.getMeasuredWidth()) goto L34;
        L24:
            r7 = r2 + r4;
            goto L25
        L47:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(AndroidScrollView r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    public final void d() {
        this.v = true;
        if (this.F != null) goto L5;
    L8:
        UIScrollView r1 = this.o;
        int r2 = this.O;
        if (r1.j == true) goto L14;
        if (r2 != 0) goto L12;
        return;
    L12:
        if (r2 == 3) goto L20;
        r1.recognizeGesturere();
        return;
    L20:
        return;
    L14:
        if (r2 != 1) goto L16;
    L17:
        r1.recognizeGesturere();
        return;
    L16:
        if (r2 == 4) goto L17;
        return;
    L5:
        if (this.O != 2) goto L8;
        g(1);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final boolean f() {
        if (this.o.isEnableNewGesture() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.o.getIncludeNativeGesture() == true) goto L7;
        return true;
    }

    public int getOrientation() {
        return this.p.getOrientation();
    }

    public int getRealScrollX() {
        if (this.u == false) goto L7;
        return this.r.getScrollX();
    L7:
        return getScrollX();
    }

    public int getRealScrollY() {
        if (this.u == false) goto L7;
        return this.r.getScrollY();
    L7:
        return getScrollY();
    }

    public final void j() {
        if (this.O == 1) goto L5;
        return;
    L5:
        if (k(0) == false) goto L9;
        g(2);
        return;
    }

    public final void l() {
        ArrayList<b> r0 = this.y;
        if (r0 == null) goto L11;
        Iterator<b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        b r2 = r1.next();
        if (r2 == null) goto L6;
        r2.a();
    L11:
        if (this.v == false) goto L13;
    L16:
        int r3 = 1;
    L17:
        g(r3);
        this.C = getScrollY();
        this.D = this.r.getScrollX();
        postDelayed(this.B, 100);
        return;
    L13:
        if (this.M == true) goto L16;
        r3 = 3;
        goto L17
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.q == false) goto L5;
        this.p.removeAllViews();
        return;
    L5:
        super.removeAllViews();
        this.q = true;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        UIScrollView r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.u == (-1)) goto L7;
        LLog.i("LynxUIScrollView", "computeScroll: apply mPendingScrollToIndex when computing scroll " + this.o.u);
        setScrollToIndex(this.o.u);
        this.o.u = -1;
    L7:
        this.o.w0();
        if (this.o.isEnableNewGesture() == false) goto L14;
        q7a.b r1 = this.o.getGestureArenaManager();
        if (r1 == null) goto L15;
        r1.b();
        return;
    L15:
        return;
    }

    public int getContentHeight() {
        return this.x;
    }

    public int getContentWidth() {
        return this.w;
    }

    public CustomHorizontalScrollView getHScrollView() {
        return this.r;
    }

    public LinearLayout getLinearLayout() {
        return this.p;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.A;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View r2) {
        if (this.q == false) goto L5;
        this.p.addView(r2);
        return;
    L5:
        super.addView(r2);
        this.q = true;
    }

    public final void b(View r5) {
    L18:
        th = move-exception;
        LLog.w("AndroidScrollView", th.getMessage());
        return;
    L5:
        if ((r5 instanceof HorizontalScrollView) == false) goto L8;
        Field r2 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L18
    L11:
        if (r2 != null) goto L14;
        LLog.w("AndroidScrollView", "did not find mScroller in ".concat(r5.getClass().getName()));     // Catch: Throwable -> L18
        return;
    L14:
        r2.setAccessible(true);     // Catch: Throwable -> L18
        OverScroller r6 = (OverScroller) r2.get(r5);     // Catch: Throwable -> L18
        if (r6.isFinished() == true) goto L22;
        r6.abortAnimation();     // Catch: Throwable -> L18
        return;
    L22:
        return;
    L8:
        if ((r5 instanceof ScrollView) == false) goto L10;
        r2 = ScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L18
        goto L11
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r1) {
        this.z = r1;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r2) {
        if (this.o.isEnableNewGesture() == false) goto L7;
        return super.canScrollVertically(r2);
    L7:
        if (this.N == false) goto L11;
        if (this.u == true) goto L11;
    L12:
        return true;
    L11:
        if (super.canScrollVertically(r2) == true) goto L12;
        return false;
    }

    @Override // android.widget.ScrollView
    public final int computeScrollDeltaToGetChildRectOnScreen(Rect r2) {
        if (this.H == false) goto L5;
        return 0;
    L5:
        return super.computeScrollDeltaToGetChildRectOnScreen(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r11) {
        if (this.A == null) goto L6;
        super.dispatchDraw(r11);
        this.A.a(r11);
        return;
    L6:
        Drawable r0 = getBackground();
        if ((r0 instanceof BackgroundDrawable) == false) goto L17;
        BackgroundDrawable r1 = (BackgroundDrawable) r0;
        RectF r2 = r1.b();
        BorderRadius r3 = r1.A;
        Rect r4 = this.Q;
        if (r4 != null) goto L11;
        r4 = r0.getBounds();
    L11:
        Path r5 = new Path();
        float r6 = r4.left + r2.left;
        float r7 = r4.top + r2.top;
        int r8 = this.s;
        RectF r9 = new RectF(r6, r7 + r8, r4.right - r2.right, (r4.bottom - r2.bottom) + r8);
        if (r3 != null) goto L14;
        r5.addRect(r9, Path.Direction.CW);
    L15:
        int r10 = r11.save();
        r11.clipPath(r5);
        super.dispatchDraw(r11);
        r11.restoreToCount(r10);
        return;
    L14:
        r5.addRoundRect(r9, BackgroundDrawable.RoundRectPath.c(r3.a(), r2, 1.0f), Path.Direction.CW);
        goto L15
    L17:
        if ((getParent() instanceof ViewGroup) == false) goto L29;
        ViewGroup r12 = (ViewGroup) getParent();
        if (getClipBounds() != null) goto L29;
        Rect r13 = this.E;
        int r14 = getScrollX();
        int r15 = getScrollY();
        int r16 = getScrollX();
        Rect r17 = this.Q;
        if (r17 != null) goto L23;
        int r18 = getWidth();
    L24:
        int r19 = r16 + r18;
        int r20 = getScrollY();
        Rect r21 = this.Q;
        if (r21 != null) goto L27;
        int r22 = getHeight();
    L28:
        r13.set(r14, r15, r19, r20 + r22);
        r11.clipRect(this.E);
        goto L29
    L27:
        r22 = r21.height();
        goto L28
    L23:
        r18 = r17.width();
    L29:
        super.dispatchDraw(r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.o.isEnableNewGesture() == false) goto L15;
        if (Boolean.FALSE.equals(this.m) == false) goto L8;
        return true;
    L8:
        if (r4.getActionMasked() != 2) goto L15;
        if (this.m == null) goto L15;
        if (this.l == true) goto L15;
        r4.setAction(0);
        this.l = true;
    L15:
        return super.dispatchTouchEvent(r4);
    }

    public final boolean e(MotionEvent r2) {
        if (this.o.isEnableNewGesture() == false) goto L11;
        Boolean r0 = this.m;
        if (r0 == null) goto L11;
        if (r0.booleanValue() == true) goto L11;
        if (r2.getActionMasked() == 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView
    public final void fling(int r2) {
        if (r2 != 0) goto L4;
    L5:
        super.fling(r2);
    L7:
        if (this.O != 1) goto L9;
        g(2);
    L9:
        ArrayList<b> r3 = this.y;
        if (r3 == null) goto L17;
        Iterator<b> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L23;
        b r0 = r4.next();
        if (r0 == null) goto L13;
        r0.onFling();
        goto L13
    L23:
        return;
    L17:
        return;
    L4:
        if (k(r2) == true) goto L7;
        goto L5
    }

    public final void g(int r3) {
        LLog.i("LynxUIScrollView", "notifyStateChange " + this.O + " -> " + r3);
        int r0 = this.O;
        if (r0 == r3) goto L6;
        this.P = r0;
        this.O = r3;
        m(r3);
        return;
    }

    public final boolean k(int r22) {
        if (this.F != null) goto L6;
        return false;
    L6:
        if (this.u == true) goto L8;
    L10:
        int r1 = r22;
    L11:
        com.lynx.tasm.behavior.ui.scroll.b r3 = this.F;
        r3.getClass();
        ArrayList r4 = new ArrayList();
        com.lynx.tasm.behavior.ui.scroll.d r5 = (com.lynx.tasm.behavior.ui.scroll.d) r3.d;
        r5.getClass();
        ArrayList r6 = new ArrayList();
        int r7 = 0;
    L13:
        if (r7 >= UIScrollView.V(r5.a).size()) goto L34;
        LynxBaseUI r8 = (LynxBaseUI) ListProtector.get(UIScrollView.W(r5.a), r7);
        if (r8 == null) goto L33;
        if ((r8 instanceof UIBounceView) == true) goto L33;
        if (r5.a.a == false) goto L22;
        int r9 = r8.getTop();
    L23:
        UIScrollView r10 = r5.a;
        if (r10.a == true) goto L29;
        if (r10.isRtl() == false) goto L29;
        r9 = (((AndroidScrollView) UIScrollView.Y(r5.a)).getContentWidth() - r8.getLeft()) - r8.getWidth();
    L29:
        if (r5.a.a == false) goto L31;
        int r11 = r8.getHeight();
    L32:
        r6.add(new com.lynx.tasm.behavior.ui.scroll.b.c(r7, r9, r11));
        goto L33
    L31:
        r11 = r8.getWidth();
        goto L32
    L22:
        r9 = r8.getLeft();
    L33:
        r7 = r7 + 1;
        goto L13
    L34:
        Iterator r12 = r6.iterator();
    L36:
        if (r12.hasNext() == false) goto L42;
        com.lynx.tasm.behavior.ui.scroll.b.c r13 = (com.lynx.tasm.behavior.ui.scroll.b.c) r12.next();
        if (r13 == null) goto L36;
        if (r13.c < 0) goto L36;
        r4.add(r13);
        goto L36
    L42:
        r3.d.getClass();
        int r14 = Math.max(0, Math.max(((com.lynx.tasm.behavior.ui.scroll.d) r3.d).a.u0(), 0));
        com.lynx.tasm.behavior.ui.scroll.d r15 = (com.lynx.tasm.behavior.ui.scroll.d) r3.d;
        UIScrollView r16 = r15.a;
        if (r16.a == false) goto L45;
    L47:
        UIScrollView r17 = r15.a;
        if (r17.a == false) goto L50;
        int r18 = ((AndroidScrollView) UIScrollView.T(r17)).getRealScrollY();
    L51:
        int r19 = r18;
    L52:
        int r20 = ((com.lynx.tasm.behavior.ui.scroll.d) r3.d).a.v0();
        List r21 = Collections.unmodifiableList(r4);
        if (r20 > 0) goto L55;
    L168:
        com.lynx.tasm.behavior.ui.scroll.b r23 = r3;
        com.lynx.tasm.behavior.ui.scroll.b.d r2 = new com.lynx.tasm.behavior.ui.scroll.b.d(-1, r19);
    L169:
        com.lynx.tasm.behavior.ui.scroll.b.a r0 = r23.d;
        int r24 = r2.a;
        int r25 = r2.b;
        com.lynx.tasm.behavior.ui.scroll.d r26 = (com.lynx.tasm.behavior.ui.scroll.d) r0;
        if (r26.a.getEvents() == null) goto L182;
        if (r26.a.getEvents().containsKey("snap") == false) goto L182;
        int r27 = ((AndroidScrollView) UIScrollView.Z(r26.a)).getRealScrollX();
        int r28 = ((AndroidScrollView) UIScrollView.a0(r26.a)).getRealScrollY();
        UIScrollView r29 = r26.a;
        if (r29.a == false) goto L177;
        int r30 = r27;
    L180:
        m7a.a r31 = new m7a.a(r26.a.getSign(), "snap");
        r31.a("position", Integer.valueOf(r24));
        r31.a("currentScrollLeft", Float.valueOf(com.lynx.tasm.utils.i.c(r27)));
        r31.a("currentScrollTop", Float.valueOf(com.lynx.tasm.utils.i.c(r19)));
        r31.a("targetScrollLeft", Float.valueOf(com.lynx.tasm.utils.i.c(r30)));
        r31.a("targetScrollTop", Float.valueOf(com.lynx.tasm.utils.i.c(r25)));
        UIScrollView.b0(r26.a).getEventEmitter().sendCustomEvent(r31);
        goto L182
    L177:
        if (r29.isRtl() == false) goto L179;
        int r32 = Math.max(r26.a.u0(), 0);
        r19 = r32 - r19;
        r25 = r32 - r25;
    L179:
        r27 = r19;
        r19 = r28;
        r30 = r25;
        r25 = r19;
    L182:
        if (r2.a == (-1)) goto L184;
        boolean r33 = true;
    L185:
        if (r33 == true) goto L188;
        return true;
    L188:
        int r34 = getRealScrollX();
        int r35 = getRealScrollY();
        if (this.u == false) goto L193;
        r34 = r2.b;
        if (this.o.isRtl() == false) goto L194;
        r34 = Math.max(this.o.u0(), 0) - r2.b;
    L194:
        i(r34, r35, true);
        return true;
    L193:
        r35 = r2.b;
        goto L194
    L184:
        r33 = false;
        goto L185
    L55:
        if (r21.isEmpty() == true) goto L168;
        if (r1 != 0) goto L59;
    L107:
        int r110 = r1;
        r23 = r3;
    L108:
        com.lynx.tasm.behavior.ui.scroll.b.c r36 = null;
    L109:
        if (r36 != null) goto L164;
        ArrayList r37 = new ArrayList();
        Iterator r38 = r21.iterator();
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r39 = null;
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r40 = null;
    L112:
        if (r38.hasNext() == false) goto L125;
        com.lynx.tasm.behavior.ui.scroll.b.c r41 = (com.lynx.tasm.behavior.ui.scroll.b.c) r38.next();
        int r42 = (int) ((((double) r41.b) - (((double) (r20 - r41.c)) * r23.a)) + ((double) r23.b));
        int r111 = Math.max(0, Math.min(r42, r14));
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r112 = new com.lynx.tasm.behavior.ui.scroll.b.C0055b(r41, r42, r111, r111 - r19);
        if (r42 <= 0) goto L115;
        if (r42 >= r14) goto L120;
        r37.add(r112);
        goto L112
    L120:
        if (r40 == null) goto L123;
        if (r42 >= r40.b) goto L112;
    L123:
        r40 = r112;
        goto L112
    L115:
        if (r39 == null) goto L118;
        if (r42 <= r39.b) goto L112;
    L118:
        r39 = r112;
        goto L112
    L125:
        if (r39 == null) goto L127;
        r37.add(r39);
    L127:
        if (r40 == null) goto L129;
        r37.add(r40);
    L129:
        Iterator r43 = r37.iterator();
        int r44 = Integer.MIN_VALUE;
        int r45 = Integer.MAX_VALUE;
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r46 = null;
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r47 = null;
    L131:
        if (r43.hasNext() == false) goto L139;
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r48 = (com.lynx.tasm.behavior.ui.scroll.b.C0055b) r43.next();
        int r113 = r48.d;
        if (r113 > 0) goto L136;
        if (r113 <= r44) goto L136;
        r47 = r48;
        r44 = r113;
    L136:
        if (r113 < 0) goto L131;
        if (r113 >= r45) goto L131;
        r46 = r48;
        r45 = r113;
        goto L131
    L139:
        if (r110 <= 0) goto L141;
        boolean r49 = true;
    L142:
        if (r110 != 0) goto L153;
        if (r46 == null) goto L149;
        if (r47 == null) goto L149;
        if (Math.abs(r45) >= Math.abs(r44)) goto L148;
        com.lynx.tasm.behavior.ui.scroll.b.c r114 = r46.a;
    L165:
        if (r114 == null) goto L167;
        r2 = new com.lynx.tasm.behavior.ui.scroll.b.d(r114.a, Math.max(0, Math.min((int) ((((double) r114.b) - (((double) (r20 - r114.c)) * r23.a)) + ((double) r23.b)), r14)));
        goto L169
    L167:
        r2 = new com.lynx.tasm.behavior.ui.scroll.b.d(-1, r19);
        goto L169
    L148:
        r114 = r47.a;
    L149:
        if (r46 == null) goto L151;
        r114 = r46.a;
        goto L165
    L151:
        if (r47 == null) goto L159;
        r114 = r47.a;
    L159:
        if (r49 == false) goto L161;
        r46 = r47;
    L161:
        if (r46 == null) goto L163;
        com.lynx.tasm.behavior.ui.scroll.b.a r50 = r23.d;
        int r51 = r46.a.a;
        r50.getClass();
    L163:
        r114 = null;
        goto L165
    L153:
        if (r49 == false) goto L156;
        if (r46 == null) goto L156;
        r114 = r46.a;
    L156:
        if (r49 == true) goto L159;
        if (r47 == null) goto L159;
        r114 = r47.a;
        goto L165
    L141:
        r49 = false;
        goto L142
    L164:
        r114 = r36;
        goto L165
    L59:
        if (r3.c <= 1) goto L107;
        if (r1 <= 0) goto L62;
        boolean r115 = true;
    L63:
        double r116 = r20;
        int r117 = (int) Math.round(r116 * Math.log1p(Math.max(((double) Math.abs(r1)) - 2000.0d, 0.0d) / (2.0d * r116)));
        if (r115 == true) goto L67;
        r117 = -r117;
    L67:
        int r118 = r117 + r19;
        ArrayList r119 = new ArrayList();
        Iterator r120 = r21.iterator();
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r121 = null;
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r122 = null;
    L69:
        if (r120.hasNext() == false) goto L89;
        com.lynx.tasm.behavior.ui.scroll.b.c r52 = (com.lynx.tasm.behavior.ui.scroll.b.c) r120.next();
        com.lynx.tasm.behavior.ui.scroll.b r123 = r3;
        int r124 = r1;
        Iterator r210 = r120;
        int r125 = r118;
        int r53 = (int) ((((double) r52.b) - (((double) (r20 - r52.c)) * r123.a)) + ((double) r123.b));
        int r54 = Math.max(0, Math.min(r53, r14));
        int r55 = r54 - r19;
        if (r115 == false) goto L73;
        if (r55 > 0) goto L73;
    L88:
        r3 = r123;
        r118 = r125;
        r1 = r124;
        r120 = r210;
    L73:
        if (r115 == true) goto L76;
        if (r55 >= 0) goto L88;
    L76:
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r56 = new com.lynx.tasm.behavior.ui.scroll.b.C0055b(r52, r53, r54, r55);
        if (r53 > 0) goto L82;
        if (r122 != null) goto L80;
    L81:
        r122 = r56;
        goto L88
    L80:
        if (r53 <= r122.b) goto L88;
    L82:
        if (r53 < r14) goto L87;
        if (r121 != null) goto L85;
    L86:
        r121 = r56;
        goto L88
    L85:
        if (r53 >= r121.b) goto L88;
    L87:
        r119.add(r56);
        goto L88
    L89:
        r110 = r1;
        r23 = r3;
        int r126 = r118;
        if (r122 == null) goto L92;
        r119.add(r122);
    L92:
        if (r121 == null) goto L95;
        r119.add(r121);
    L95:
        if (r119.isEmpty() == true) goto L108;
        Collections.sort(r119, new com.lynx.tasm.behavior.ui.scroll.a());
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r57 = (com.lynx.tasm.behavior.ui.scroll.b.C0055b) ListProtector.get(r119, 0);
        int r58 = Math.abs(r57.c - r126);
        Iterator r59 = r119.iterator();
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r60 = r57;
    L99:
        if (r59.hasNext() == false) goto L106;
        com.lynx.tasm.behavior.ui.scroll.b.C0055b r61 = (com.lynx.tasm.behavior.ui.scroll.b.C0055b) r59.next();
        if ((Math.abs(r61.a.a - r57.a.a) + 1) > r23.c) goto L99;
        int r127 = Math.abs(r61.c - r126);
        if (r127 >= r58) goto L99;
        r60 = r61;
        r58 = r127;
        goto L99
    L106:
        r36 = r60.a;
        goto L109
    L62:
        r115 = false;
        goto L63
    L50:
        r18 = ((AndroidScrollView) UIScrollView.U(r17)).getRealScrollX();
        goto L51
    L45:
        if (r16.isRtl() == false) goto L47;
        r19 = Math.max(r15.a.u0(), 0) - ((AndroidScrollView) UIScrollView.S(r15.a)).getRealScrollX();
        goto L52
    L8:
        if (this.o.isRtl() == false) goto L10;
        r1 = -r22;
        goto L11
    }

    public final void m(int r3) {
        ArrayList<b> r0 = this.y;
        if (r0 == null) goto L10;
        Iterator<b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        b r2 = r1.next();
        if (r2 == null) goto L6;
        r2.onScrollStateChanged(r3);
        goto L6
    L16:
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        if (this.A == null) goto L6;
        this.A.g(r2);
        this.A.c(r2);
        return;
    L6:
        super.onDraw(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        boolean r1 = false;
        if (this.u == false) goto L5;
        return false;
    L5:
        if (this.k == false) goto L8;
        return true;
    L8:
        if (this.o.o == false) goto L11;
        requestDisallowInterceptTouchEvent(true);
    L11:
        if (f() == false) goto L14;
        return false;
    L14:
        if (e(r4) == false) goto L17;
        return false;
    L17:
        if (this.o.isEnableNewGesture() == true) goto L19;
    L21:
        boolean r0 = false;
    L22:
        if (r0 == true) goto L24;
    L26:
        if (r1 == false) goto L30;
        return this.n.booleanValue();
    L30:
        return super.onInterceptTouchEvent(r4);
    L24:
        if (this.n.booleanValue() == false) goto L26;
        r1 = true;
        goto L26
    L19:
        if (this.n == null) goto L21;
        r0 = true;
        goto L22
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (this.u == false) goto L5;
    L78:
        return false;
    L5:
        if (this.j == false) goto L8;
        return false;
    L8:
        if (f() == false) goto L11;
        return false;
    L11:
        if (e(r8) == true) goto L13;
        boolean r1 = false;
    L17:
        if (r1 == false) goto L20;
        return false;
    L20:
        if (this.o.isEnableNewGesture() == true) goto L22;
    L24:
        boolean r2 = false;
    L26:
        if (r2 == false) goto L42;
        if (r8.getActionMasked() != 0) goto L31;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L42
    L31:
        if (r8.getActionMasked() != 2) goto L37;
        getParent().requestDisallowInterceptTouchEvent(this.n.booleanValue());
        boolean r0 = this.n.booleanValue();
        if (this.n.booleanValue() == false) goto L35;
        return r0;
    L35:
        return super.onTouchEvent(r8);
    L37:
        if (r8.getActionMasked() != 1) goto L39;
    L40:
        this.n = null;
        goto L42
    L39:
        if (r8.getActionMasked() == 3) goto L40;
    L42:
        if (r8.getAction() != 2) goto L44;
        boolean r3 = true;
    L45:
        this.M = r3;
        boolean r4 = super.onTouchEvent(r8);     // Catch: IllegalStateException -> L57 Throwable -> L69
        goto L70
    L48:
        if (r8.getAction() != 1) goto L51;
        this.v = false;
        this.M = false;
        j();
        this.o.z0();
        stopNestedScroll(0);
    L56:
        return r4;
    L51:
        if (r8.getAction() != 0) goto L54;
        d();
        goto L56
    L54:
        if (r8.getAction() != 3) goto L56;
        this.M = false;
        stopNestedScroll(0);
    L57:
        e = move-exception;
        LLog.e("LynxUIScrollView", "AndroidScrollView onTouchEvent: " + r8.getAction() + ", " + e.getMessage());     // Catch: Throwable -> L69
        if (r8.getAction() != 1) goto L63;
        this.v = false;
        this.M = false;
        j();
        this.o.z0();
        stopNestedScroll(0);
    L68:
        return false;
    L63:
        if (r8.getAction() != 0) goto L66;
        d();
        goto L68
    L66:
        if (r8.getAction() != 3) goto L68;
        this.M = false;
        stopNestedScroll(0);
    L70:
        if (r8.getAction() != 1) goto L73;
        this.v = false;
        this.M = false;
        j();
        this.o.z0();
        stopNestedScroll(0);
        goto L78
    L73:
        if (r8.getAction() != 0) goto L76;
        d();
        goto L78
    L76:
        if (r8.getAction() != 3) goto L78;
        this.M = false;
        stopNestedScroll(0);
        goto L78
    L44:
        r3 = false;
        goto L45
    L22:
        if (this.n == null) goto L24;
        r2 = true;
        goto L26
    L13:
        if (r8.getActionMasked() != 1) goto L15;
        this.v = false;
    L15:
        r1 = true;
        goto L17
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r2) {
        if (this.q == false) goto L5;
        this.p.removeView(r2);
        return;
    L5:
        super.removeView(r2);
        this.q = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r2) {
        if (this.q == false) goto L5;
        this.p.removeViewAt(r2);
        return;
    L5:
        super.removeViewAt(r2);
        this.q = true;
    }

    public void setBlockDescendantFocusability(boolean r1) {
        this.H = r1;
    }

    @Override // android.view.View
    public void setClipBounds(Rect r1) {
        this.Q = r1;
    }

    public void setEnableScroll(boolean r2) {
        a r0 = new a(r2);
        this.r.setOnTouchListener(r0);
        setOnTouchListener(r0);
    }

    public void setForbidFlingFocusChange(boolean r1) {
        this.L = r1;
    }

    public void setForceCanScroll(boolean r1) {
        this.N = r1;
    }

    public void setOnScrollListener(b r2) {
        if (this.y != null) goto L5;
        this.y = new ArrayList();
    L5:
        if (r2 == null) goto L8;
        this.y.add(r2);
        return;
    }

    public void setOrientation(int r3) {
        if (r3 != 0) goto L5;
        this.p.setOrientation(0);
        this.u = true;
        return;
    L5:
        if (r3 != 1) goto L9;
        this.p.setOrientation(1);
        this.u = false;
        return;
    }

    @Override // x6a.e
    public void setRenderer(i r1) {
        this.A = r1;
    }

    public void setScrollBarEnable(boolean r1) {
        setVerticalScrollBarEnabled(r1);
    }

    public void setScrollSnapHelper(com.lynx.tasm.behavior.ui.scroll.b r1) {
        this.F = r1;
    }

    public void setScrollToIndex(int r5) {
        UIScrollView r0 = this.o;
        if (r0 == null) goto L20;
        int r1 = r0.getChildCount();
        if (r1 == 0) goto L21;
        if (r5 < 0) goto L22;
        if (r5 < r1) goto L9;
        return;
    L9:
        if (this.o.getChildAt(r5) != null) goto L12;
        return;
    L12:
        if (this.u == false) goto L18;
        int r2 = this.r.getScrollY();
        this.r.getScrollX();
        LynxBaseUI r6 = this.o.getChildAt(r5);
        if (ViewCompat.getLayoutDirection(this) != 1) goto L16;
        int r3 = (r6.getLeft() + r6.getWidth()) - this.o.getWidth();
    L17:
        i(r3, r2, false);
        return;
    L16:
        r3 = r6.getLeft();
        goto L17
    L18:
        i(getScrollX(), this.o.getChildAt(r5).getTop(), false);
        return;
    L22:
        return;
    L21:
        return;
    }

    public AndroidScrollView(Context r5, UIScrollView r6) {
        super(r5, r6);
        this.l = true;
        this.m = null;
        this.n = null;
        this.q = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.C = 0;
        this.D = 0;
        this.F = null;
        this.G = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = null;
        this.o = r6;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.E = new Rect();
        this.y = new ArrayList();
        if (this.p != null) goto L5;
        g7a.a r2 = new g7a.a(this, getContext());
        this.p = r2;
        r2.setOrientation(1);
        this.p.setWillNotDraw(true);
        this.p.setFocusableInTouchMode(true);
        CustomHorizontalScrollView r3 = new CustomHorizontalScrollView(this, getContext(), r6);
        this.r = r3;
        r3.setOverScrollMode(2);
        this.r.setFadingEdgeLength(0);
        this.r.setWillNotDraw(true);
        this.r.addView(this.p, new FrameLayout.LayoutParams(-1, -1));
        addView(this.r, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.B = new c(this);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View r2, int r3) {
        if (this.q == false) goto L5;
        this.p.addView(r2, r3);
        return;
    L5:
        super.addView(r2, r3);
        this.q = true;
    }

    public final void c(int r5, boolean r6) {
        boolean r0 = false;
        if (r6 == true) goto L14;
        if (r5 == 0) goto L31;
        setClipChildren(false);
        CustomHorizontalScrollView r7 = this.r;
        if (r7 == null) goto L9;
        r7.setClipChildren(false);
    L9:
        g7a.a r8 = this.p;
        if (r8 == null) goto L30;
        r8.setClipToPadding(false);
        return;
    L30:
        return;
    L31:
        return;
    L14:
        if (r5 == 0) goto L16;
        boolean r9 = true;
    L17:
        boolean r2 = !r9;
        setClipChildren(r2);
        CustomHorizontalScrollView r3 = this.r;
        if (r3 == null) goto L20;
        r3.setClipChildren(r2);
    L20:
        g7a.a r4 = this.p;
        if (r4 == null) goto L32;
        if (r9 == false) goto L24;
        r4.setClipChildren(false);
    L24:
        g7a.a r10 = this.p;
        if (r9 == true) goto L28;
        if (r6 == true) goto L28;
        r0 = true;
    L28:
        r10.setClipToPadding(r0);
        return;
    L32:
        return;
    L16:
        r9 = false;
        goto L17
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r2, int r3) {
        return new i(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.view.View
    public final boolean dispatchNestedPreFling(float r1, float r2) {
        boolean r3 = super.dispatchNestedPreFling(r1, r2);
        if (r3 == false) goto L5;
        m(4);
    L5:
        return r3;
    }

    public final void h(int r17, int r18) {
        boolean r2 = false;
        int r1 = this.o.G0(r17, r18, 0, 0);
        UIScrollView r3 = this.o;
        if (r3.e == true) goto L5;
    L10:
        UIScrollView r10 = this.o;
        if (r10.c == true) goto L13;
    L18:
        UIScrollView r4 = this.o;
        if (r4.f == true) goto L21;
        return;
    L21:
        if ((r1 & 1) == 0) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L26;
        return;
    L26:
        if ((r1 & 2) == 0) goto L28;
        r2 = true;
    L28:
        if (r2 == true) goto L33;
        r4.B0(getScrollX(), getScrollY(), getScrollX(), getScrollY(), "scrolltonormalstate");
        return;
    L33:
        return;
    L23:
        r5 = false;
        goto L24
    L13:
        if ((r1 & 1) == 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L18;
        r10.B0(getScrollX(), getScrollY(), getScrollX(), getScrollY(), "scrolltoupperedge");
        goto L18
    L15:
        r6 = false;
        goto L16
    L5:
        if ((r1 & 2) == 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L10;
        r3.B0(getScrollX(), getScrollY(), getScrollX(), getScrollY(), "scrolltoloweredge");
        goto L10
    L7:
        r7 = false;
        goto L8
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        if (this.q == false) goto L5;
        this.p.addView(r2, r3);
        return;
    L5:
        super.addView(r2, r3);
        this.q = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, int r4) {
        if (this.q == false) goto L5;
        this.p.addView(r2, r3, r4);
        return;
    L5:
        super.addView(r2, r3, r4);
        this.q = true;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.view.View
    public final boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        boolean r4 = super.dispatchNestedFling(r1, r2, r3);
        if (r4 == false) goto L5;
        m(4);
    L5:
        return r4;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        i r0 = this.A;
        if (r0 == null) goto L5;
        r0.b(r2, r3);
    L5:
        boolean r5 = super.drawChild(r2, r3, r4);
        i r6 = this.A;
        if (r6 == null) goto L8;
        r6.getClass();
        r2.restore();
    L8:
        return r5;
    }

    public final void i(int r2, int r3, boolean r4) {
        if (this.t == r2) goto L5;
    L7:
        if (r4 == false) goto L13;
        if (this.u == false) goto L11;
        this.r.setSmoothScrollingEnabled(true);
        this.r.b(r2, r3);
        return;
    L11:
        setSmoothScrollingEnabled(true);
        a(r2, r3);
        return;
    L13:
        if (this.u == false) goto L15;
        b(this.r);
        this.r.scrollTo(r2, r3);
        return;
    L15:
        b(this);
        scrollTo(r2, r3);
        return;
    L5:
        if (this.s != r3) goto L7;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (this.q == false) goto L5;
        this.p.addView(r2, r3, r4);
        return;
    L5:
        super.addView(r2, r3, r4);
        this.q = true;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.view.View
    public final boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
        boolean r5 = super.dispatchNestedPreScroll(r1, r2, r3, r4);
        if (r5 == false) goto L5;
        m(4);
    L5:
        return r5;
    }

    @Override // android.view.View
    public final void onScrollChanged(int r3, int r4, int r5, int r6) {
        super.onScrollChanged(r3, r4, r5, r6);
        if (r4 != this.s) goto L5;
        return;
    L5:
        this.s = getScrollY();
        if (this.O != 0) goto L8;
        l();
    L8:
        ArrayList<b> r0 = this.y;
        if (r0 == null) goto L17;
        Iterator<b> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L17;
        b r2 = r1.next();
        if (r2 == null) goto L12;
        r2.onScrollChanged(r3, r4, r5, r6);
    L17:
        if (this.v == false) goto L19;
    L21:
        h(r3, r4);
        return;
    L19:
        if (this.G == true) goto L21;
        this.o.z0();
        goto L21
    }

    @Override // android.view.View
    public final void setPadding(int r2, int r3, int r4, int r5) {
        this.p.setPadding(r2, r3, r4, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView
    public final boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4, int r5) {
        boolean r6 = super.dispatchNestedPreScroll(r1, r2, r3, r4, r5);
        if (r6 == false) goto L5;
        m(4);
    L5:
        return r6;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.view.View
    public final boolean dispatchNestedScroll(int r1, int r2, int r3, int r4, int[] r5) {
        boolean r6 = super.dispatchNestedScroll(r1, r2, r3, r4, r5);
        if (r6 == false) goto L5;
        m(4);
    L5:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        i r0 = this.A;
        if (r0 == null) goto L7;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L7;
        r1.measure();
    L7:
        super.onLayout(r3, r4, r5, r6, r7);
        if (this.A == null) goto L19;
        if (this.p == null) goto L19;
        int r8 = 0;
    L13:
        if (r8 >= this.p.getChildCount()) goto L19;
        View r9 = this.p.getChildAt(r8);
        if ((r9 instanceof e) == false) goto L17;
        Rect r10 = ((e) r9).getRenderer().a;
        r9.layout(r10.left, r10.top, r10.right, r10.bottom);
    L17:
        r8 = r8 + 1;
    L19:
        if (this.u == true) goto L30;
        int r11 = this.i.f;
        if (this.e == false) goto L31;
        if (r11 > 0) goto L24;
        return;
    L24:
        if (r11 == getScrollY()) goto L33;
        i(getScrollX(), r11, false);
        return;
    L33:
        return;
    L31:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView
    public final boolean dispatchNestedScroll(int r1, int r2, int r3, int r4, int[] r5, int r6) {
        boolean r7 = super.dispatchNestedScroll(r1, r2, r3, r4, r5, r6);
        if (r7 == false) goto L5;
        m(4);
    L5:
        return r7;
    }
}
