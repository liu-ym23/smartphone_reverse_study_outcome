package com.ss.android.lark.reaction.widget.detailwindow.scroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ScrollableLayout extends FrameLayout {
    public static final /* synthetic */ int G = 0;
    public d A;
    public int B;
    public int C;
    public View D;
    public final a E;
    public final b F;
    public final Rect a;
    public final List<com.ss.android.lark.reaction.widget.detailwindow.scroller.i> b;
    public k c;
    public GestureDetector d;
    public GestureDetector e;
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.a f;
    public int g;
    public boolean h;
    public boolean i;
    public f j;
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.b k;
    public ValueAnimator l;
    public ValueAnimator.AnimatorUpdateListener m;
    public boolean n;
    public boolean o;
    public boolean p;
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.d q;
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.c r;
    public View s;
    public boolean t;
    public long u;
    public boolean v;
    public float w;
    public float x;
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.h y;
    public boolean z;

    public static class ScrollableLayoutSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<ScrollableLayoutSavedState> CREATOR = null;
        public int a;
        public boolean b;

        public class a implements Parcelable.Creator<ScrollableLayoutSavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ScrollableLayoutSavedState createFromParcel(Parcel r2) {
                return new ScrollableLayoutSavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final ScrollableLayoutSavedState[] newArray(int r1) {
                return new ScrollableLayoutSavedState[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public ScrollableLayoutSavedState(Parcel r2) {
            super(r2);
            this.a = r2.readInt();
            boolean r0 = true;
            if (r2.readByte() == 1) goto L6;
            r0 = false;
        L6:
            this.b = r0;
        }

        public ScrollableLayoutSavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.a);
            r1.writeByte(this.b ? 1 : 0);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ ScrollableLayout a;

        @Override // java.lang.Runnable
        public final void run() {
            boolean r0 = this.a.c.a();     // Catch: Throwable -> L9
            ScrollableLayout r1 = this.a;     // Catch: Throwable -> L9
            r1.o = r0;     // Catch: Throwable -> L9
            if (r0 == false) goto L12;
            int r2 = r1.c.m;     // Catch: Throwable -> L9
            if ((r2 - r1.getScrollY()) == 0) goto L7;
            this.a.scrollTo(0, r2);     // Catch: Throwable -> L9
        L7:
            this.a.post(this);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(ScrollableLayout r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ScrollableLayout a;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ b c;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r4) {
                this.c.a.scrollTo(0, (int) ((this.a + (this.b * r4.getAnimatedFraction())) + 0.5f));
            }

            public a(b r1, int r2, int r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public final void a() {
            ScrollableLayout r0 = this.a;
            ValueAnimator r1 = r0.l;
            if (r1 != null) goto L5;
        L10:
            ScrollableLayout r2 = this.a;
            if (r2.n == false) goto L13;
            return;
        L13:
            if (r2.o == true) goto L43;
            int r3 = r2.getScrollY();
            if (r3 == 0) goto L42;
            ScrollableLayout r4 = this.a;
            int r5 = r4.g;
            if (r3 == r5) goto L44;
            int r6 = r4.k.b(r3, r5);
            if (r3 != r6) goto L23;
            return;
        L23:
            ScrollableLayout r7 = this.a;
            ValueAnimator r8 = r7.l;
            if (r8 != null) goto L26;
            r7.l = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.a.l.setEvaluator(new FloatEvaluator());
            this.a.l.addListener(new i(this.a));
        L32:
            ScrollableLayout r9 = this.a;
            a r10 = new a(this, r3, r6 - r3);
            r9.m = r10;
            r9.l.addUpdateListener(r10);
            ScrollableLayout r11 = this.a;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.d r12 = r11.q;
            if (r12 == null) goto L35;
            long r13 = ((l) r12).a;
        L36:
            r11.l.setDuration(r13);
            ScrollableLayout r14 = this.a;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.c r15 = r14.r;
            if (r15 == null) goto L39;
            r14.l.setInterpolator(((com.ss.android.lark.reaction.widget.detailwindow.scroller.g) r15).a);
        L39:
            this.a.l.start();
            return;
        L35:
            r13 = 200;
            goto L36
        L26:
            ValueAnimator.AnimatorUpdateListener r16 = r7.m;
            if (r16 == null) goto L30;
            r8.removeUpdateListener(r16);
        L30:
            if (this.a.l.isRunning() == false) goto L32;
            this.a.l.end();
            goto L32
        L44:
            return;
        L42:
            return;
        L43:
            return;
        L5:
            if (r1.isRunning() == false) goto L10;
            ValueAnimator.AnimatorUpdateListener r17 = r0.m;
            if (r17 == null) goto L9;
            r0.l.removeUpdateListener(r17);
        L9:
            r0.l.end();
            goto L10
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

        public b(ScrollableLayout r1) {
            this.a = r1;
        }
    }

    public class c implements g {
        public final /* synthetic */ ScrollableLayout a;

        public c(ScrollableLayout r1) {
            this.a = r1;
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ScrollableLayout b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ScrollableLayout r0 = this.b;
            r0.g = this.a.getMeasuredHeight();
        }

        public d(ScrollableLayout r1, View r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class e extends com.ss.android.lark.reaction.widget.detailwindow.scroller.f {
        public final int a;
        public final float b;
        public final /* synthetic */ ScrollableLayout c;

        public e(ScrollableLayout r1, Context r2) {
            this.c = r1;
            this.a = UIHelper.dp2px(12.0f);
            this.b = ViewConfiguration.get(r2).getScaledMinimumFlingVelocity();
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.f, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r11, MotionEvent r12, float r13, float r14) {
            if (Math.abs(r14) >= this.b) goto L6;
            return false;
        L6:
            if (Math.abs(r13) <= Math.abs(r14)) goto L8;
            return false;
        L8:
            int r15 = this.c.getScrollY();
            if (r15 < 0) goto L46;
            ScrollableLayout r16 = this.c;
            int r17 = r16.g;
            if (r15 > r17) goto L50;
            int r1 = -((int) (0.5f + r14));
            if (r16.t == false) goto L16;
        L26:
            ScrollableLayout r18 = this.c;
            r18.c.b(r15, r1, r18.g);
            if (this.c.c.a() == false) goto L47;
            int r19 = this.c.c.g;
            if (Math.abs(r15 - r19) >= this.a) goto L32;
            k r110 = this.c.c;
            r110.l = r110.f;
            r110.m = r110.g;
            r110.q = true;
            return false;
        L32:
            if (r19 == r15) goto L41;
            ScrollableLayout r111 = this.c;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.b r112 = r111.k;
            if (r112 == null) goto L41;
            if ((r19 - r15) >= 0) goto L39;
            boolean r113 = true;
        L40:
            r19 = r112.a(r113, r15, r111.g);
            k r114 = this.c.c;
            r114.g = r19;
            r114.p = r19 - r114.e;
            r114.q = false;
            goto L41
        L39:
            r113 = false;
        L41:
            int r115 = this.c.b(r19);
            if (r19 == r15) goto L48;
            if (r115 < 0) goto L49;
            return true;
        L49:
            return false;
        L48:
            return false;
        L47:
            return false;
        L16:
            if (r16.y == null) goto L26;
            if (r17 == r16.getScrollY()) goto L26;
            if (r1 <= 0) goto L26;
            if (((n2c.h) this.c.f).a(1) == false) goto L26;
            this.c.c.b(r15, r1, Integer.MAX_VALUE);
            k r116 = this.c.c;
            int r117 = r116.g;
            Math.exp(Math.log((Math.abs(r14) * 0.35f) / (r116.v * r116.x)) / (((double) k.z) - 1.0d));
            ScrollableLayout r118 = this.c;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.h r119 = r118.y;
            int r120 = r117 - r118.g;
            RecyclerView r121 = ((n2c.i) r119).a.r;
            if (r121 == null) goto L25;
            r121.smoothScrollBy(0, r120);
        L25:
            k r122 = this.c.c;
            r122.l = r122.f;
            r122.m = r122.g;
            r122.q = true;
            goto L26
        L50:
            return false;
        L46:
            return false;
        }
    }

    public static class f {
        public final g a;

        public f(c r1) {
            this.a = r1;
        }
    }

    public interface g {
    }

    public class h extends com.ss.android.lark.reaction.widget.detailwindow.scroller.f {
        public final int a;
        public final /* synthetic */ ScrollableLayout b;

        public h(ScrollableLayout r1) {
            this.b = r1;
            this.a = ViewConfiguration.get(r1.getContext()).getScaledTouchSlop();
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.f, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            float r6 = Math.abs(r4);
            if (r6 <= Math.abs(r5)) goto L5;
            return false;
        L5:
            if (r6 > this.a) goto L13;
            int r7 = this.b.getScrollY();
            int r8 = (int) (r5 + 0.5f);
            ScrollableLayout r9 = this.b;
            int r0 = ScrollableLayout.G;
            r9.getClass();
            this.b.scrollTo(0, r8 + r7);
            if (r7 == this.b.getScrollY()) goto L12;
            return true;
        L12:
            return false;
        L13:
            return false;
        }
    }

    public class i extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ ScrollableLayout b;

        public i(ScrollableLayout r1) {
            this.b = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            ScrollableLayout r3 = this.b;
            r3.n = this.a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            ScrollableLayout r3 = this.b;
            r3.n = this.a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            ScrollableLayout r3 = this.b;
            this.a = r3.n;
            r3.n = true;
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r1) {
        return false;
    }

    public void setOverScrollListener(j r1) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.l.cancel();
        goto L7
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (this.z == false) goto L5;
        d(true);
    L5:
        int r0 = this.C;
        if (r0 == 0) goto L9;
        View r1 = findViewById(r0);
    L12:
        this.D = r1;
        return;
    L9:
        if (getChildCount() <= 0) goto L11;
        r1 = getChildAt(0);
        goto L12
    L11:
        r1 = null;
        goto L12
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ScrollableLayoutSavedState r1 = new ScrollableLayoutSavedState(super.onSaveInstanceState());
        r1.a = getScrollY();
        r1.b = this.z;
        return r1;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        return this.g;
    }

    public long getConsiderIdleMillis() {
        return this.u;
    }

    public int getMaxScrollY() {
        return this.g;
    }

    public ScrollableLayout(Context r3) {
        super(r3);
        this.a = new Rect();
        this.b = new ArrayList(3);
        this.E = new a(this);
        this.F = new b(this);
        c(r3, null);
    }

    public final int b(int r8) {
        int r0 = getScrollY();
        if (r0 != r8) goto L5;
        return -1;
    L5:
        int r2 = r8 - r0;
        boolean r3 = true;
        if (r2 >= 0) goto L8;
        boolean r5 = true;
    L9:
        com.ss.android.lark.reaction.widget.detailwindow.scroller.a r6 = this.f;
        if (r6 == null) goto L35;
        if (r5 == false) goto L20;
        if (this.t == true) goto L35;
        if (this.n == true) goto L35;
        if (((n2c.h) r6).a(r2) == false) goto L35;
        return -1;
    L20:
        if (this.t == true) goto L31;
        if (this.n == true) goto L31;
        View r7 = this.D;
        if (r7 != null) goto L26;
    L28:
        r3 = false;
    L29:
        if (r3 == false) goto L31;
    L34:
        return -1;
    L26:
        if (r7.canScrollVertically(r2) == false) goto L28;
    L31:
        if (r0 != this.g) goto L35;
        if (((n2c.h) this.f).a(r2) == false) goto L34;
    L35:
        if (r8 >= 0) goto L37;
        return 0;
    L37:
        int r1 = this.g;
        if (r8 > r1) goto L40;
        return r8;
    L40:
        return r1;
    L8:
        r5 = false;
        goto L9
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r2) {
        if (r2 < 0) goto L4;
    L5:
        if (r2 > 0) goto L7;
    L9:
        return false;
    L7:
        if (((n2c.h) this.f).a(r2) == false) goto L9;
    L8:
        return true;
    L4:
        if (getScrollY() > 0) goto L8;
        goto L5
    }

    public final void d(boolean r3) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        int r0 = this.B;
        if (r0 == 0) goto L8;
        View r1 = findViewById(r0);
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        if (r3 == true) goto L20;
        d r4 = this.A;
        if (r4 == null) goto L23;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2.isAlive() == false) goto L18;
        r2.removeOnGlobalLayoutListener(r4);
    L18:
        this.A = null;
        return;
    L23:
        return;
    L20:
        if (this.A != null) goto L25;
        this.A = new d(this, r1);
        r1.getViewTreeObserver().addOnGlobalLayoutListener(this.A);
        return;
    L25:
        return;
    L8:
        r1 = getChildAt(0);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        if (this.n == false) goto L6;
        this.p = false;
        this.t = false;
        this.h = false;
        this.i = false;
        removeCallbacks(this.F);
        removeCallbacks(this.E);
        return super.dispatchTouchEvent(r8);
    L6:
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L14;
        this.p = true;
        k r4 = this.c;
        r4.l = r4.f;
        r4.m = r4.g;
        r4.q = true;
        View r5 = this.s;
        if (r5 != null) goto L11;
    L13:
        this.t = false;
    L26:
        boolean r6 = this.h;
        boolean r7 = this.i;
        this.i = this.e.onTouchEvent(r8);
        this.h = this.d.onTouchEvent(r8);
        removeCallbacks(this.E);
        post(this.E);
        if (this.h == false) goto L29;
    L32:
        boolean r9 = true;
    L33:
        if (r6 == true) goto L37;
        if (r7 == true) goto L37;
        boolean r10 = false;
    L39:
        if (r0 != 2) goto L45;
        if (r9 == true) goto L45;
        if (r10 == false) goto L45;
        if (getScrollY() != this.g) goto L45;
        boolean r1 = true;
    L46:
        if (r9 == true) goto L48;
        if (r10 == true) goto L48;
    L51:
        if (r1 == false) goto L53;
        f r2 = this.j;
        r2.getClass();
        int r3 = r8.getAction();
        r8.setAction(0);
        a(((c) r2.a).a, r8);
        r8.setAction(r3);
        this.w = r8.getRawY();
        this.v = true;
    L53:
        super.dispatchTouchEvent(r8);
        return true;
    L48:
        f r11 = this.j;
        r11.getClass();
        int r12 = r8.getAction();
        r8.setAction(3);
        a(((c) r11.a).a, r8);
        r8.setAction(r12);
        if (r10 == true) goto L51;
        return true;
    L45:
        r1 = false;
    L37:
        r10 = true;
        goto L39
    L29:
        if (this.i == true) goto L32;
        r9 = false;
        goto L33
    L11:
        if (r5.getGlobalVisibleRect(this.a) == false) goto L13;
        int r13 = (int) (r8.getRawX() + 0.5f);
        int r14 = (int) (r8.getRawY() + 0.5f);
        this.t = this.a.contains(r13, r14);
        goto L26
    L14:
        if (r0 == 1) goto L16;
        if (r0 != 3) goto L26;
    L16:
        this.p = false;
        if (this.k == null) goto L20;
        removeCallbacks(this.F);
        postDelayed(this.F, this.u);
    L20:
        if (this.v == false) goto L26;
        if (r0 == 1) goto L23;
    L25:
        this.v = false;
        goto L26
    L23:
        if (Float.compare(Math.abs(r8.getRawY() - this.w), this.x) >= 0) goto L25;
        r8.setAction(3);
        goto L25
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof ScrollableLayoutSavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        ScrollableLayoutSavedState r3 = (ScrollableLayoutSavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setScrollY(r3.a);
        boolean r4 = r3.b;
        this.z = r4;
        d(r4);
    }

    public void setAutoMaxScroll(boolean r1) {
        this.z = r1;
        d(r1);
    }

    public void setCanScrollVerticallyDelegate(com.ss.android.lark.reaction.widget.detailwindow.scroller.a r1) {
        this.f = r1;
    }

    public void setCloseAnimatorConfigurator(com.ss.android.lark.reaction.widget.detailwindow.scroller.c r1) {
        this.r = r1;
    }

    public void setCloseUpAlgorithm(com.ss.android.lark.reaction.widget.detailwindow.scroller.b r1) {
        this.k = r1;
    }

    public void setCloseUpIdleAnimationTime(com.ss.android.lark.reaction.widget.detailwindow.scroller.d r1) {
        this.q = r1;
    }

    public void setConsiderIdleMillis(long r1) {
        this.u = r1;
    }

    public void setDraggableView(View r1) {
        this.s = r1;
    }

    public void setFriction(float r4) {
        k r0 = this.c;
        r0.w = (r0.b * 386.0878f) * r4;
        r0.v = r4;
    }

    public void setMaxScrollY(int r1) {
        this.g = r1;
        d(false);
    }

    public void setOnFlingOverListener(com.ss.android.lark.reaction.widget.detailwindow.scroller.h r1) {
        this.y = r1;
    }

    public void setOnScrollChangedListener(com.ss.android.lark.reaction.widget.detailwindow.scroller.i r2) {
        ((ArrayList) this.b).clear();
        if (r2 == null) goto L6;
        ((ArrayList) this.b).add(r2);
        return;
    }

    public void setSelfUpdateScroll(boolean r1) {
        this.n = r1;
    }

    public ScrollableLayout(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.a = new Rect();
        this.b = new ArrayList(3);
        this.E = new a(this);
        this.F = new b(this);
        c(r3, r4);
    }

    public static /* synthetic */ void a(ScrollableLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    public final void c(Context r6, AttributeSet r7) {
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130973938, 2130973939, 2130973940, 2130973941, 2130973942, 2130973943, 2130973944, 2130973945, 2130973946, 2130973947, 2130974462});
        this.c = new k(r6, r8.getBoolean(8, false));     // Catch: Throwable -> L19
        setFriction(r8.getFloat(6, 0.0565f));     // Catch: Throwable -> L19
        int r0 = r8.getDimensionPixelSize(7, 0);     // Catch: Throwable -> L19
        this.g = r0;     // Catch: Throwable -> L19
        if (r0 != 0) goto L6;
        boolean r1 = true;
    L7:
        this.z = r8.getBoolean(0, r1);     // Catch: Throwable -> L19
        this.B = r8.getResourceId(1, 0);     // Catch: Throwable -> L19
        setConsiderIdleMillis(r8.getInteger(4, 100));     // Catch: Throwable -> L19
        if (r8.getBoolean(5, false) == false) goto L10;
        setCloseUpAlgorithm(new com.ss.android.lark.reaction.widget.detailwindow.scroller.e());     // Catch: Throwable -> L19
    L10:
        int r2 = r8.getInteger(2, -1);     // Catch: Throwable -> L19
        if (r2 == (-1)) goto L13;
        setCloseUpIdleAnimationTime(new l(r2));     // Catch: Throwable -> L19
    L13:
        int r3 = r8.getResourceId(3, 0);     // Catch: Throwable -> L19
        if (r3 == 0) goto L16;
        setCloseAnimatorConfigurator(new com.ss.android.lark.reaction.widget.detailwindow.scroller.g(AnimationUtils.loadInterpolator(r6, r3)));     // Catch: Throwable -> L19
    L16:
        this.C = r8.getResourceId(9, 0);     // Catch: Throwable -> L19
        r8.recycle();
        this.d = new GestureDetector(r6, new h(this));
        this.e = new GestureDetector(r6, new e(this, r6));
        this.j = new f(new c(this));
        this.x = ViewConfiguration.get(r6).getScaledTouchSlop();
        return;
    L6:
        r1 = false;
    L19:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    @Override // android.view.View
    public final void scrollTo(int r1, int r2) {
        int r3 = b(r2);
        if (r3 >= 0) goto L5;
        return;
    L5:
        super.scrollTo(0, r3);
    }

    public ScrollableLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = new Rect();
        this.b = new ArrayList(3);
        this.E = new a(this);
        this.F = new b(this);
        c(r2, r3);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r6, int r7, int r8, int r9) {
        int r0 = 0;
        if (r7 == r9) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r2 = ((ArrayList) this.b).size();
    L9:
        if (r2 <= 0) goto L13;
    L10:
        if (r0 >= r2) goto L13;
        ((com.ss.android.lark.reaction.widget.detailwindow.scroller.i) ListProtector.get(this.b, r0)).a(r7, this.g);
        r0 = r0 + 1;
    L13:
        if (this.k == null) goto L20;
        removeCallbacks(this.F);
        if (this.n == true) goto L20;
        if (r1 == false) goto L20;
        if (this.p == true) goto L20;
        postDelayed(this.F, this.u);
    L20:
        super.onScrollChanged(r6, r7, r8, r9);
        return;
    L8:
        r2 = 0;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getChildCount();
        if (r8 <= 0) goto L7;
        int r9 = 0;
        int r10 = 0;
    L5:
        if (r9 >= r8) goto L9;
        View r0 = getChildAt(r9);
        r0.layout(r4, r10, r6, r0.getMeasuredHeight() + r10);
        r10 = r10 + r0.getMeasuredHeight();
        r9 = r9 + 1;
        goto L5
    L9:
        return;
    }
}
