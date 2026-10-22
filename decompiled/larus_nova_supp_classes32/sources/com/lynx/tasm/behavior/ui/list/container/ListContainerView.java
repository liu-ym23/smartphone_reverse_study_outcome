package com.lynx.tasm.behavior.ui.list.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.g;
import com.lynx.tasm.l;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import x6a.e;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ListContainerView extends NestedScrollContainerView implements IDrawChildHook.IDrawChildHookBinding, e {
    public static final /* synthetic */ int L0 = 0;
    public Boolean A;
    public Boolean B;
    public boolean C;
    public IDrawChildHook D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public i H0;
    public int I;
    public int J;
    public int K;
    public Boolean L;
    public boolean M;
    public d N;
    public c O;
    public boolean P;
    public final ArrayDeque<Runnable> Q;
    public boolean R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean k0;
    public float p0;
    public UIListContainer y;
    public b z;

    public static class a {
        public final boolean a;
        public final float b;

        public a(float r2, boolean r3) {
            this.a = true;
            this.b = 0.0f;
            this.b = r2;
            this.a = r3;
        }
    }

    public class b extends LinearLayout {
        public final /* synthetic */ ListContainerView a;

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas r2) {
            IDrawChildHook r0 = this.a.D;
            if (r0 == null) goto L5;
            r0.beforeDispatchDraw(r2);
        L5:
            super.dispatchDraw(r2);
            IDrawChildHook r1 = this.a.D;
            if (r1 == null) goto L9;
            r1.afterDispatchDraw(r2);
            return;
        }

        public b(ListContainerView r1, Context r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            ListContainerView r4 = this.a;
            UIListContainer r5 = r4.y;
            if (r5 != null) goto L5;
            LLog.e("ListContainerView", "CustomLinearLayout$$onMeasure: mUiListContainer is null: " + this + ", " + this.a);
            setMeasuredDimension(0, 0);
            return;
        L5:
            int r6 = r4.F;
            if (r6 > 0) goto L9;
            r6 = r5.getWidth();
        L9:
            ListContainerView r7 = this.a;
            int r0 = r7.G;
            if (r0 > 0) goto L13;
            r0 = r7.y.getHeight();
        L13:
            setMeasuredDimension(r6, r0);
        }

        @Override // android.view.ViewGroup
        public final boolean drawChild(Canvas r3, View r4, long r5) {
            IDrawChildHook r0 = this.a.D;
            if (r0 == null) goto L5;
            Rect r1 = r0.beforeDrawChild(r3, r4, r5);
        L6:
            if (r1 == null) goto L8;
            r3.save();
            r3.clipRect(r1);
            boolean r2 = super.drawChild(r3, r4, r5);
            r3.restore();
        L9:
            IDrawChildHook r6 = this.a.D;
            if (r6 == null) goto L12;
            r6.afterDrawChild(r3, r4, r5);
        L12:
            return r2;
        L8:
            r2 = super.drawChild(r3, r4, r5);
            goto L9
        L5:
            r1 = null;
            goto L6
        }
    }

    public static class c implements Runnable {
        public final WeakReference<ListContainerView> a;

        @Override // java.lang.Runnable
        public final void run() {
            ListContainerView r0 = this.a.get();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            int r1 = ListContainerView.L0;     // Catch: Throwable -> L6
            r0.j();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(ListContainerView r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class d implements ViewTreeObserver.OnPreDrawListener {
        public final WeakReference<ListContainerView> a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ListContainerView r0 = this.a.get();
            if (r0 == null) goto L10;
            r0.k();
            r0.M = true;
            if (r0.O != null) goto L8;
            r0.O = new c(r0);
        L8:
            if (r0.P == true) goto L10;
            r0.P = true;
            LLog.d("ListContainerView", "post EndDrawTraversalRunnable, this.hashCode=" + r0.hashCode());
            r0.post(r0.O);
        L10:
            return true;
        }

        public d(ListContainerView r2) {
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

    public void setPanInterceptAncestors(boolean r1) {
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView
    public final boolean e() {
        UIListContainer r0 = this.y;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRtl();
    }

    public final void j() {
        LLog.d("ListContainerView", "doWorkEndDrawTraversal, this.hashCode=" + hashCode());
        this.P = false;
        this.M = false;
        if (this.Q.isEmpty() == true) goto L14;
        ArrayDeque r0 = new ArrayDeque(this.Q);
        this.Q.clear();
    L7:
        if (r0.isEmpty() == true) goto L22;
        Runnable r2 = (Runnable) r0.poll();
        if (r2 == null) goto L7;
        r2.run();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        LLog.e("ListContainerView", "Exception occurred while running pending draw task: " + e);
        goto L7
    L22:
        return;
    }

    public final void k() {
        if (this.P == true) goto L5;
        return;
    L5:
        LLog.d("ListContainerView", "force doWorkEndDrawTraversal, this.hashCode=" + hashCode());
        c r0 = this.O;
        if (r0 == null) goto L8;
        removeCallbacks(r0);
    L8:
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        LLog.i("ListContainerView", "onAttachedToWindow: this.hashCode=" + hashCode() + ", ui = " + this.y);
        super.onAttachedToWindow();
        if (Boolean.TRUE.equals(this.L) == false) goto L11;
        ViewTreeObserver r0 = getViewTreeObserver();
        if (this.N != null) goto L12;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isAlive() == false) goto L14;
        d r1 = new d(this);
        this.N = r1;
        r0.addOnPreDrawListener(r1);
        return;
    L14:
        return;
    L12:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        LLog.i("ListContainerView", "onDetachedFromWindow: this.hashCode=" + hashCode() + ", ui = " + this.y);
        if (Boolean.TRUE.equals(this.L) == false) goto L10;
        ViewTreeObserver r0 = getViewTreeObserver();
        if (this.N == null) goto L10;
        if (r0 == null) goto L10;
        if (r0.isAlive() == false) goto L10;
        r0.removeOnPreDrawListener(this.N);
        this.N = null;
    L10:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        b r0 = this.z;
        if (r0 == null) goto L6;
        r0.removeAllViews();
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        UIListContainer r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEnableNewGesture() == false) goto L13;
        q7a.b r1 = this.y.getGestureArenaManager();
        if (r1 == null) goto L12;
        r1.b();
        return;
    L12:
        return;
    }

    public LinearLayout getLinearLayout() {
        return this.z;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.H0;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2) {
        b r0 = this.z;
        if (r0 == null) goto L8;
        if (r0 != r2) goto L6;
        super.addView(r0);
        return;
    L6:
        r0.addView(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r1) {
        this.D = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.View
    public final boolean canScrollHorizontally(int r2) {
        if (this.U == false) goto L7;
        if (this.E == true) goto L7;
    L8:
        return true;
    L7:
        if (super.canScrollHorizontally(r2) == true) goto L8;
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.View
    public final boolean canScrollVertically(int r2) {
        if (this.U == false) goto L7;
        if (this.E == false) goto L7;
    L8:
        return true;
    L7:
        if (super.canScrollVertically(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        i r0 = this.H0;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        UIListContainer r0 = this.y;
        if (r0 != null) goto L7;
        return super.dispatchTouchEvent(r4);
    L7:
        if (r0.isEnableNewGesture() == false) goto L19;
        if (Boolean.FALSE.equals(this.A) == false) goto L12;
        return true;
    L12:
        if (r4.getActionMasked() != 2) goto L19;
        if (this.A == null) goto L19;
        if (this.C == true) goto L19;
        r4.setAction(0);
        this.C = true;
    L19:
        return super.dispatchTouchEvent(r4);
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView
    public final void f(boolean r2) {
        UIListContainer r0 = this.y;
        if (r0 == null) goto L7;
        if (r2 == false) goto L8;
        r0.recognizeGesturere();
        return;
    L8:
        return;
    }

    public final int i(float r2) {
        return (int) Math.max((this.F - r2) - this.y.getWidth(), 0.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        if (this.H0 == null) goto L6;
        this.H0.g(r2);
        return;
    L6:
        super.onDraw(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        UIListContainer r0 = this.y;
        if (r0 == null) goto L5;
        boolean r2 = true;
        if (this.W == false) goto L10;
        return true;
    L10:
        if (r0.isEnableNewGesture() == true) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L18;
        return false;
    L18:
        if (this.y.isEnableNewGesture() == false) goto L26;
        Boolean r3 = this.A;
        if (r3 == null) goto L26;
        if (r3.booleanValue() == true) goto L26;
        if (r4.getActionMasked() == 0) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L30;
        return false;
    L30:
        if (this.y.isEnableNewGesture() == true) goto L32;
    L34:
        boolean r6 = false;
    L35:
        if (r6 == true) goto L37;
    L39:
        r2 = false;
    L40:
        if (r2 == false) goto L44;
        return this.B.booleanValue();
    L44:
        return super.onInterceptTouchEvent(r4);
    L37:
        if (this.B.booleanValue() == false) goto L39;
    L32:
        if (this.B == null) goto L34;
        r6 = true;
    L26:
        r5 = false;
        goto L27
    L12:
        if (this.y.getIncludeNativeGesture() == true) goto L14;
        r1 = true;
        goto L15
    L5:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        UIListContainer r0 = this.y;
        if (r0 == null) goto L5;
        boolean r2 = false;
        if (this.V == false) goto L10;
        return false;
    L10:
        if (r0.isEnableNewGesture() == true) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L18;
        return false;
    L18:
        if (this.y.isEnableNewGesture() == false) goto L26;
        Boolean r3 = this.A;
        if (r3 == null) goto L26;
        if (r3.booleanValue() == true) goto L26;
        if (r4.getActionMasked() == 0) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L30;
        return false;
    L30:
        if (this.y.isEnableNewGesture() == true) goto L32;
    L34:
        if (r2 == false) goto L50;
        if (r4.getAction() != 0) goto L39;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L50
    L39:
        if (r4.getAction() != 2) goto L45;
        getParent().requestDisallowInterceptTouchEvent(this.B.booleanValue());
        boolean r6 = this.B.booleanValue();
        if (this.B.booleanValue() == false) goto L43;
        return r6;
    L43:
        return super.onTouchEvent(r4);
    L45:
        if (r4.getAction() != 1) goto L47;
    L48:
        this.B = null;
        goto L50
    L47:
        if (r4.getAction() == 3) goto L48;
    L50:
        return super.onTouchEvent(r4);
    L32:
        if (this.B == null) goto L34;
        r2 = true;
    L26:
        r5 = false;
        goto L27
    L12:
        if (this.y.getIncludeNativeGesture() == true) goto L14;
        r1 = true;
        goto L15
    L5:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r2) {
        b r0 = this.z;
        if (r0 == null) goto L8;
        if (r0 != r2) goto L6;
        super.removeView(r0);
        return;
    L6:
        r0.removeView(r2);
        return;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r2) {
        b r0 = this.z;
        if (r0 == null) goto L6;
        r0.removeViewAt(r2);
        return;
    }

    public void setForceCanScroll(boolean r1) {
        this.U = r1;
    }

    public void setMaxFlingDistanceRatio(float r1) {
        this.p0 = r1;
    }

    public void setOrientation(int r4) {
        int r0 = 0;
        if (r4 != 1) goto L5;
        boolean r2 = true;
    L6:
        this.E = r2;
        setIsVertical(r2);
        b r3 = this.z;
        if (r3 == null) goto L12;
        if (r4 != 1) goto L10;
        r0 = 1;
    L10:
        r3.setOrientation(r0);
        return;
    L12:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setPanInterceptDescendants(boolean r1) {
        this.W = r1;
    }

    public void setPanInterceptSelf(boolean r1) {
        this.V = r1;
    }

    @Override // x6a.e
    public void setRenderer(i r1) {
        this.H0 = r1;
    }

    public ListContainerView(Context r3, UIListContainer r4) {
        super(r3);
        this.A = null;
        this.B = null;
        this.C = true;
        this.E = true;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = false;
        this.N = null;
        this.O = null;
        this.P = false;
        this.Q = new ArrayDeque();
        this.R = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.k0 = false;
        this.p0 = -1.0f;
        this.y = r4;
        if (this.z != null) goto L5;
        this.z = new b(this, getContext());
        LLog.i("ListContainerView", "Create CustomLinearLayout: " + this.z + ", this.hashCode=" + hashCode());
    L5:
        this.z.setOrientation(1);
        this.z.setWillNotDraw(true);
        this.z.setFocusableInTouchMode(true);
        addView(this.z, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3) {
        b r0 = this.z;
        if (r0 == null) goto L8;
        if (r0 != r2) goto L6;
        super.addView(r0, r3);
        return;
    L6:
        r0.addView(r2, r3);
        return;
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r2, int r3) {
        return new i(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView
    public final float[] d(int r6, int r7) {
        float r0 = this.p0;
        if (r0 <= 0.0f) goto L24;
        boolean r1 = this.E;
        if (r1 == false) goto L7;
        float r8 = r7;
    L8:
        float r3 = Float.MAX_VALUE;
        if (r0 != Float.MAX_VALUE) goto L17;
        a r2 = l(true, r8);
        a r4 = l(false, r8);
        if (r2.a == false) goto L13;
        float r5 = r2.b - r8;
    L15:
        if (r4.a == false) goto L22;
        r3 = r8 - r4.b;
    L22:
        return new float[]{r5, r3};
    L13:
        r5 = Float.MAX_VALUE;
        goto L15
    L17:
        if (r1 == false) goto L19;
        int r9 = getHeight();
    L20:
        r5 = r0 * r9;
        r3 = r5;
        goto L22
    L19:
        r9 = getWidth();
        goto L20
    L7:
        r8 = r6;
        goto L8
    L24:
        return super.d(r6, r7);
    }

    public final a l(boolean r10, float r11) {
        if (getChildCount() <= 0) goto L68;
        if ((getChildAt(0) instanceof ViewGroup) == false) goto L68;
        ViewGroup r2 = (ViewGroup) getChildAt(0);
        if (r2.getChildCount() == 0) goto L9;
        float r12 = 0.0f;
        if (r10 == false) goto L44;
        boolean r13 = this.E;
        if (r13 == false) goto L15;
        int r3 = this.K;
    L16:
        if (r13 == false) goto L18;
        int r14 = r2.getHeight();
    L20:
        if (this.E == false) goto L22;
        int r4 = getHeight();
    L23:
        float r5 = Float.MIN_VALUE;
        int r6 = 0;
    L25:
        if (r6 >= r2.getChildCount()) goto L34;
        View r7 = r2.getChildAt(r6);
        if (this.E == false) goto L29;
        float r8 = r7.getY();
        int r9 = r7.getHeight();
    L30:
        float r15 = r8 + r9;
        if (r5 >= r15) goto L33;
        r5 = r15;
    L33:
        r6 = r6 + 1;
        goto L25
    L29:
        r8 = r7.getX();
        r9 = r7.getWidth();
        goto L30
    L34:
        float r16 = r14;
        if (com.lynx.tasm.utils.b.a(r3 + r5, r16) == false) goto L42;
        if (hasNestedScrollingParent(1) == true) goto L39;
        r5 = r16;
        goto L42
    L39:
        return new a(0.0f, false);
    L42:
        return new a(r5 - r4, true);
    L22:
        r4 = getWidth();
        goto L23
    L18:
        r14 = r2.getWidth();
        goto L20
    L15:
        r3 = this.I;
        goto L16
    L44:
        if (this.E == false) goto L46;
        int r17 = this.J;
    L47:
        float r18 = Float.MAX_VALUE;
        int r19 = 0;
    L49:
        if (r19 >= r2.getChildCount()) goto L59;
        View r20 = r2.getChildAt(r19);
        if (this.E == false) goto L53;
        float r21 = r20.getY();
    L55:
        if (r18 <= r21) goto L57;
        r18 = r21;
    L57:
        r19 = r19 + 1;
        goto L49
    L53:
        r21 = r20.getX();
        goto L55
    L59:
        if (com.lynx.tasm.utils.b.a(r18 - r17, 0.0f) == true) goto L61;
        r12 = r18;
    L66:
        return new a(r12, true);
    L61:
        if (hasNestedScrollingParent(1) == false) goto L66;
        return new a(0.0f, false);
    L46:
        r17 = this.H;
        goto L47
    L9:
        return new a(r11, true);
    L68:
        return new a(r11, true);
    }

    public final void m(int r2, int r3) {
        if (this.F == r2) goto L5;
    L6:
        this.G = r3;
        this.F = r2;
        b r4 = this.z;
        if (r4 == null) goto L11;
        r4.requestLayout();
        return;
    L11:
        return;
    L5:
        if (this.G != r3) goto L6;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        b r0 = this.z;
        if (r0 == null) goto L8;
        if (r0 != r2) goto L6;
        super.addView(r0, r3);
        return;
    L6:
        r0.addView(r2, r3);
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, int r4) {
        b r0 = this.z;
        if (r0 == null) goto L8;
        if (r0 != r2) goto L6;
        super.addView(r0, r3, r4);
        return;
    L6:
        r0.addView(r2, r3, r4);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        i r0 = this.H0;
        if (r0 == null) goto L5;
        r0.b(r2, r3);
    L5:
        boolean r5 = super.drawChild(r2, r3, r4);
        i r6 = this.H0;
        if (r6 == null) goto L8;
        r6.getClass();
        r2.restore();
    L8:
        return r5;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        b r0 = this.z;
        if (r0 == null) goto L8;
        if (r0 != r2) goto L6;
        super.addView(r0, r3, r4);
        return;
    L6:
        r0.addView(r2, r3, r4);
        return;
    }

    @Override // android.view.View
    public final void onScrollChanged(int r8, int r9, int r10, int r11) {
        super.onScrollChanged(r8, r9, r10, r11);
        LLog.i("ListContainerView", "onScrollChanged: " + r11 + " -> " + r9 + ", " + r10 + " -> " + r8);
        if (this.R == true) goto L31;
        UIListContainer r12 = this.y;
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.getLynxContext() == null) goto L36;
        this.T = r9;
        if (this.y.isRtl() == false) goto L11;
        int r13 = i(r8);
    L12:
        this.S = r13;
        UIListContainer r14 = this.y;
        ListContainerProxy r1 = r14.E;
        if (r1 == null) goto L15;
        float r6 = r9;
        r1.b(r14.getSign(), this.S, r6, r8, r6);
    L22:
        UIListContainer r15 = this.y;
        if (r15 == null) goto L37;
        r15.i0();
        this.y.d0();
        Iterator<NestedScrollContainerView.d> r16 = this.t.iterator();
    L26:
        if (r16.hasNext() == false) goto L38;
        NestedScrollContainerView.d r17 = r16.next();
        if (this.y.isRtl() == false) goto L30;
        i(r10);
    L30:
        r17.a();
        goto L26
    L38:
        return;
    L37:
        return;
    L15:
        g r18 = r14.getLynxContext().getListNodeInfoFetcher();
        if (r18 != null) goto L19;
        LLog.e("ListContainerView", "onScrollChanged: listNodeInfoFetcher is nullptr");
        return;
    L19:
        int r2 = this.y.getSign();
        float r3 = this.S;
        float r7 = r9;
        float r5 = r8;
        LynxTemplateRender r4 = ((l) r18).a;
        if (r4 == null) goto L22;
        r4.scrollByListContainer(r2, r3, r7, r5, r7);
        goto L22
    L11:
        r13 = r8;
        goto L12
    L36:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        i r0 = this.H0;
        if (r0 == null) goto L7;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L7;
        r1.measure();
    L7:
        super.onLayout(r2, r3, r4, r5, r6);
        if (this.H0 != null) goto L10;
        return;
    L10:
        if (this.z == null) goto L22;
        int r7 = 0;
    L13:
        if (r7 >= this.z.getChildCount()) goto L23;
        View r8 = this.z.getChildAt(r7);
        if ((r8 instanceof e) == false) goto L17;
        Rect r9 = ((e) r8).getRenderer().a;
        r8.layout(r9.left, r9.top, r9.right, r9.bottom);
    L17:
        r7 = r7 + 1;
        goto L13
    L23:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView
    public final void onNestedScroll(View r3, int r4, int r5, int r6, int r7, int r8) {
        boolean r1 = true;
        if (r8 == 1) goto L6;
        r1 = false;
    L6:
        this.k0 = r1;
        super.onNestedScroll(r3, r4, r5, r6, r7, r8);
        this.k0 = false;
    }
}
