package com.bytedance.android.live.effect.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class AdjustPercentBar extends View {
    public static Drawable b1;
    public boolean A;
    public boolean B;
    public final Rect C;
    public b D;
    public String E;
    public float F;
    public float G;
    public float H;
    public ValueAnimator H0;
    public float I;
    public float J;
    public int K;
    public int L;
    public float L0;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public final Handler P0;
    public boolean Q;
    public boolean R;
    public ValueAnimator S;
    public boolean T;
    public final int U;
    public final c V;
    public final a V0;
    public int W;
    public int a;
    public int b;
    public final int c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public boolean k0;
    public int l;
    public int m;
    public int n;
    public Paint o;
    public Paint p;
    public String p0;
    public Paint q;
    public Paint r;
    public Paint s;
    public Paint t;
    public Paint u;
    public int v;
    public int w;
    public String x;
    public float y;
    public boolean z;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }

        public a() {
        }
    }

    public class b implements d {
        public final /* synthetic */ d a;
        public final /* synthetic */ AdjustPercentBar b;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
            this.a.b();
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r2) {
            this.a.a(r2);
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r5) {
            AdjustPercentBar r0 = this.b;
            r0.P0.removeCallbacks(r0.V0);
            AdjustPercentBar r1 = this.b;
            if (r1.p0 != null) goto L5;
        L7:
            ValueAnimator r2 = r1.H0;
            if (r2 == null) goto L10;
            r2.cancel();
            this.b.H0 = null;
        L10:
            this.a.onChanged(r5);
            return;
        L5:
            if (r5 != r1.O) goto L7;
            r1.P0.postDelayed(r1.V0, 100);
            goto L10
        }

        public b(AdjustPercentBar r1, d r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ AdjustPercentBar a;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r2) {
                int r3 = (int) ((1.0f - ((Float) r2.getAnimatedValue()).floatValue()) * 255.0f);
                AdjustPercentBar.a(this.a.a, r3);
                this.a.a.invalidate();
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r1) {
                super.onAnimationEnd(r1);
            }
        }

        public final void a() {
            AdjustPercentBar r0 = this.a;
            if (r0.T == true) goto L5;
            return;
        L5:
            ValueAnimator r1 = r0.S;
            if (r1 == null) goto L8;
            r1.removeAllListeners();
            this.a.S.cancel();
        L8:
            AdjustPercentBar r2 = this.a;
            r2.u.setShadowLayer(0.0f, 0.0f, 0.0f, r2.h);
            this.a.S = ValueAnimator.ofFloat(new float[]{1.0f});
            this.a.S.addUpdateListener(new a(this));
            this.a.S.addListener(new b());
            this.a.S.setDuration(300);
            this.a.S.start();
            this.a.T = false;
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

        public c(AdjustPercentBar r1) {
            this.a = r1;
        }
    }

    public interface d {
        void a(int r1);

        void b();

        void onChanged(int r1);
    }

    public void setIsTwoWayMode(boolean r1) {
    }

    public final void b() {
        this.q.setColor(-1);
        Paint r0 = new Paint();
        this.r = r0;
        r0.setStrokeWidth(12.0f);
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setAntiAlias(true);
        Paint r1 = this.r;
        if (this.R == false) goto L5;
        int r2 = this.g;
    L6:
        r1.setColor(r2);
        this.r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.k0 = true;
        invalidate();
        return;
    L5:
        r2 = this.l;
        goto L6
    }

    @Override // android.view.View
    public final void buildDrawingCache() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
    L6:
        super.buildDrawingCache();
        return;
    L5:
        if (((((long) getWidth()) * ((long) getHeight())) * 4) < 838860800) goto L6;
    }

    public final void f() {
        this.i = this.a / 2;
        if (this.k0 == false) goto L5;
        int r0 = this.b / 2;
    L6:
        this.j = r0;
        this.k = (this.a - (this.J * 2.0f)) / this.L;
        this.B = true;
        invalidate();
        return;
    L5:
        r0 = s1.f(32.0f);
        goto L6
    }

    public final void h() {
        removeCallbacks(this.V);
        if (this.k0 == false) goto L5;
        return;
    L5:
        if (this.T == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.x) == true) goto L20;
        ValueAnimator r0 = this.S;
        if (r0 == null) goto L12;
        r0.removeAllListeners();
        this.S.cancel();
    L12:
        Paint r1 = this.u;
        if (this.R == false) goto L15;
        float r2 = 0.0f;
    L16:
        r1.setShadowLayer(s1.f(r2), 0.0f, 0.0f, this.h);
        setTextAlpha(255);
        this.T = true;
        invalidate();
        return;
    L15:
        r2 = 3.0f;
        goto L16
    }

    public int getMaxPercent() {
        return this.M;
    }

    public int getMinPercent() {
        return this.N;
    }

    public int getPercent() {
        return this.v;
    }

    public int getRange() {
        return this.L;
    }

    public AdjustPercentBar(Context r2) {
        this(r2, null);
    }

    private void setTextAlpha(int r2) {
        this.W = r2;
        this.u.setAlpha(r2);
        this.t.setAlpha(r2);
    }

    @Override // android.view.View
    public final void buildDrawingCache(boolean r6) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
    L6:
        super.buildDrawingCache(r6);
        return;
    L5:
        if (((((long) getWidth()) * ((long) getHeight())) * 4) < 838860800) goto L6;
    }

    public final int d(int r6) {
        int r0 = this.K;
        boolean r1 = true;
        if (r0 <= 1) goto L10;
        if ((r6 % r0) < (r0 / 2.0f)) goto L7;
        int r7 = (r6 / r0) + 1;
    L8:
        r6 = r7 * r0;
        goto L10
    L7:
        r7 = r6 / r0;
    L10:
        if (r6 <= this.L) goto L12;
        int r8 = this.M;
    L16:
        if (this.N == 0) goto L18;
    L21:
        if (r1 == false) goto L28;
        int r2 = this.O;
        if (r8 >= (r2 - 2)) goto L25;
        return r8;
    L25:
        if (r8 <= (r2 + 2)) goto L27;
        return r8;
    L27:
        return r2;
    L28:
        return r8;
    L18:
        if (this.O != 0) goto L21;
        r1 = false;
        goto L21
    L12:
        if (r6 > 0) goto L14;
        r8 = this.N;
        goto L16
    L14:
        r8 = r6 + this.N;
        goto L16
    }

    public final void g(boolean r6) {
        this.o.setColor(this.e);
        if (r6 == false) goto L5;
        this.o.setShadowLayer(s1.f(1.0f), 0.0f, 0.0f, this.h);
    L6:
        this.p.setColor(this.f);
        if (r6 == false) goto L9;
        this.p.setShadowLayer(s1.f(1.0f), 0.0f, 0.0f, this.h);
    L10:
        this.q.setColor(this.l);
        if (r6 == false) goto L13;
        this.q.setShadowLayer(s1.f(3.0f), 0.0f, 0.0f, this.h);
    L14:
        this.s.setColor(this.e);
        this.t.setColor(this.m);
        this.u.setColor(this.e);
        setTextAlpha(this.W);
        this.R = false;
        if (b1 != null) goto L17;
        b1 = getResources().getDrawable(2131250444);
    L17:
        invalidate();
        return;
    L13:
        this.q.clearShadowLayer();
        goto L14
    L9:
        this.p.clearShadowLayer();
        goto L10
    L5:
        this.o.clearShadowLayer();
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (this.B == true) goto L5;
        return;
    L5:
        int r0 = this.v;
        int r1 = this.N;
        float r3 = this.J;
        float r2 = this.k;
        float r4 = ((r0 - r1) * r2) + r3;
        float r5 = ((this.O - r1) * r2) + r3;
        float r6 = this.j;
        r14.drawLine(r3, r6, this.a - r3, r6, this.p);
        if (this.P == false) goto L8;
        float r7 = this.J;
        float r8 = this.j;
        r14.drawLine(r7, r8, r4, r8, this.o);
    L9:
        int r9 = 255;
        this.q.setAlpha(255);
        this.s.setAlpha(255);
        this.u.setAlpha(255);
        this.t.setAlpha(255);
        r14.drawCircle(r4, this.j, this.H, this.q);
        Paint r11 = this.r;
        if (r11 == null) goto L12;
        r14.drawCircle(r4, this.j, this.H + 4.0f, r11);
    L12:
        int r12 = this.O;
        int r13 = this.N;
        if (r12 < r13) goto L26;
        if (r12 > this.M) goto L26;
        if (r13 != 0) goto L20;
        if (r12 != 0) goto L20;
        boolean r15 = false;
    L21:
        if (r15 == false) goto L26;
        if (this.k0 == true) goto L26;
        r14.drawCircle(r5, this.j, this.n, this.s);
    L20:
        r15 = true;
    L26:
        if (this.k0 == false) goto L28;
        return;
    L28:
        int r16 = this.U;
        if (r16 != Integer.MIN_VALUE) goto L32;
        r16 = this.v;
    L32:
        if (this.L0 != 0.0f) goto L34;
        String r17 = String.valueOf(r16);
    L38:
        if (TextUtils.isEmpty(this.E) == false) goto L40;
    L43:
        this.x = r17;
    L45:
        if (TextUtils.isEmpty(this.x) == false) goto L48;
        return;
    L48:
        if (this.Q == false) goto L50;
        Paint r18 = this.u;
    L51:
        Paint r19 = this.t;
        String r21 = this.x;
        r19.getTextBounds(r21, 0, r21.length(), this.C);
        int r22 = this.C.width();
        int r23 = s1.f(14.0f);
        if (this.Q == false) goto L54;
        int r24 = this.i;
    L55:
        int r25 = (r24 - (r22 / 2)) - s1.f(1.0f);
        int r26 = (int) ((this.j - r23) - this.F);
        if (this.R == false) goto L58;
        Drawable r27 = null;
    L60:
        if (this.Q == true) goto L70;
        if (r27 == null) goto L70;
        int r110 = r27.getIntrinsicWidth();
        int r28 = Math.max(r22, r110);
        float r111 = this.L0;
        if (r111 != 1.0f) goto L66;
        r9 = this.W;
        r28 = r28 + r110;
    L69:
        float r112 = this.j - s1.f(57.0f);
        r27.setAlpha(r9);
        r27.setBounds(0, 0, r28, r27.getIntrinsicHeight());
        r14.save();
        r14.translate(r24 - (r28 / 2.0f), r112);
        r27.draw(r14);
        r14.restore();
        goto L70
    L66:
        if (r111 <= 0.0f) goto L68;
        float r113 = r110;
        r28 = (int) (((int) (((r28 - r110) * r111) + r113)) + (r113 * r111));
        goto L69
    L68:
        r9 = this.W;
    L70:
        float r29 = this.L0;
        if (r29 > 0.0f) goto L73;
    L75:
        r14.drawText(this.x, r25, r26, r18);
        return;
    L73:
        if (r29 >= 1.0f) goto L75;
        int r31 = r18.getAlpha();
        r18.setAlpha((int) (this.L0 * 255.0f));
        r14.drawText(this.x, r25, r26, r18);
        r18.setAlpha(r31);
        return;
    L58:
        r27 = b1;
        goto L60
    L54:
        r24 = (int) r4;
        goto L55
    L50:
        r18 = this.t;
        goto L51
    L40:
        if (TextUtils.isEmpty(r17) == true) goto L43;
        this.x = this.E + " " + r17;
        goto L45
    L34:
        r17 = this.p0;
        if (r17 != null) goto L38;
        r17 = "";
        goto L38
    L8:
        float r32 = this.j;
        r14.drawLine(r4, r32, r5, r32, this.o);
        goto L9
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        r5.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS);
    L6:
        if (isEnabled() == true) goto L8;
    L13:
        r5.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, this.N, this.M, this.v));
        return;
    L8:
        if (this.v <= this.N) goto L11;
        r5.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    L11:
        if (this.v >= this.M) goto L13;
        r5.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        goto L13
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r4) {
        super.onPopulateAccessibilityEvent(r4);
        r4.setItemCount(this.M - this.N);
        r4.setCurrentItemIndex(this.v);
        if (getTag() == null) goto L5;
        String r5 = getTag().toString();
    L7:
        if (this.v >= 0) goto L9;
        String r0 = "负";
    L11:
        if (this.N >= 0) goto L13;
        setContentDescription("实际效果，" + r0 + Math.abs(this.v) + "，" + r5);
        return;
    L13:
        setContentDescription(r5);
        return;
    L9:
        r0 = " ";
        goto L11
    L5:
        r5 = "";
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r11) {
        if (this.A == true) goto L5;
        return true;
    L5:
        boolean r2 = false;
        if (r11.getAction() != 0) goto L13;
        if (r11.getX() >= (this.J - this.d)) goto L10;
    L11:
        return false;
    L10:
        if (r11.getX() > (s1.y() - (this.J - this.d))) goto L11;
    L13:
        if (r11.getAction() == 0) goto L15;
    L17:
        int r0 = r11.getAction();
        if (r0 != 0) goto L20;
        h();
        this.w = this.v;
        float r1 = r11.getX();
        float r3 = r11.getY();
        if (Math.abs(r1 - (this.J + ((this.v - this.N) * this.k))) <= (((double) this.c) * 2.5d)) goto L43;
    L45:
        this.z = !r2;
        float r12 = r11.getX();
        this.y = r12;
        int r13 = d((int) ((r12 - this.J) / this.k));
        if (this.v == r13) goto L51;
        this.v = r13;
        this.w = r13;
        b r4 = this.D;
        if (r4 == null) goto L50;
        r4.onChanged(r13);
    L50:
        invalidate();
    L51:
        b r14 = this.D;
        if (r14 == null) goto L54;
        r14.b();
    L54:
        return true;
    L43:
        if (Math.abs(r3 - this.j) > (((double) this.c) * 2.5d)) goto L45;
        r2 = true;
        goto L45
    L20:
        if (r0 == 1) goto L29;
        if (r0 != 2) goto L23;
        h();
        setCurrentProgress(d((this.w - this.N) + ((int) ((r11.getX() - this.y) / this.k))));
        goto L51
    L23:
        if (r0 != 3) goto L51;
        b r15 = this.D;
        if (r15 == null) goto L51;
        r15.a(this.v);
        goto L51
    L29:
        float r16 = r11.getX();
        if (this.z == true) goto L32;
    L37:
        b r17 = this.D;
        if (r17 == null) goto L51;
        r17.a(this.v);
        goto L51
    L32:
        if (Math.abs(r16 - this.y) > s1.f(3.0f)) goto L37;
        int r18 = d((int) ((r16 - this.J) / this.k));
        b r5 = this.D;
        if (r5 == null) goto L36;
        this.v = r18;
        r5.onChanged(r18);
        this.D.a(r18);
    L36:
        int r6 = this.v;
        this.A = false;
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r7.setTarget(this);
        r7.addUpdateListener(new com.bytedance.android.live.effect.base.a(this, r6, r18));
        r7.addListener(new com.bytedance.android.live.effect.base.b(this));
        r7.setDuration(50);
        r7.setInterpolator(new AccelerateDecelerateInterpolator());
        r7.start();
        goto L51
    L15:
        if (Math.abs(r11.getY() - this.j) <= (this.b - this.j)) goto L17;
        return false;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r3) {
        Field r0 = View.class.getDeclaredField("mContentDescription");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.set(this, r3);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    L8:
        super.setContentDescription(r3);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void setCurrentProgress(int r3) {
        if (this.D != null) goto L5;
    L7:
        invalidate();
        sendAccessibilityEvent(4);
        return;
    L5:
        if (this.v == r3) goto L7;
        int r4 = Math.min(this.M, Math.max(r3, this.N));
        this.v = r4;
        this.D.onChanged(r4);
        goto L7
    }

    public void setDefaultCircleConfig(int r2) {
        Paint r0 = this.s;
        if (r0 == null) goto L6;
        r0.setColor(s1.h(r2));
        return;
    }

    public void setDefaultCircleRadius(int r1) {
        this.n = r1;
    }

    public void setLevelAdjustBarTitle(String r1) {
        this.E = r1;
    }

    public void setOnLevelChangeListener(d r2) {
        this.D = new b(this, r2);
    }

    public void setPercent(int r1) {
        this.v = r1;
        invalidate();
    }

    public void setTextInCenter(boolean r1) {
        this.Q = r1;
    }

    public AdjustPercentBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ void a(AdjustPercentBar r0, int r1) {
        r0.setTextAlpha(r1);
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r5, Bundle r6) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        Objects.toString(r6);
        if (r5 == 4096) goto L21;
        if (r5 == 8192) goto L21;
        if (r5 == 16908349) goto L13;
        return super.performAccessibilityAction(r5, r6);
    L13:
        if (Build.VERSION.SDK_INT < 24) goto L20;
        if (r6 == null) goto L20;
        if (r6.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") == false) goto L20;
        setCurrentProgress((int) r6.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"));
        return true;
    L20:
        return false;
    L21:
        int r7 = Math.max(1, Math.round((this.M - this.N) / 20.0f));
        if (r5 != 8192) goto L24;
        r7 = -r7;
    L24:
        setCurrentProgress(this.v + r7);
        return true;
    }

    public AdjustPercentBar(Context r9, AttributeSet r11, int r12) {
        super(r9, r11, r12);
        int r13 = s1.f(4.0f);
        int r0 = s1.f(9.0f);
        this.c = r0;
        int r1 = s1.f(2.0f);
        this.d = s1.f(10.0f);
        this.n = r1;
        this.A = true;
        this.B = false;
        this.C = new Rect();
        this.E = null;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = s1.f(40.0f);
        this.P = true;
        this.Q = false;
        this.T = true;
        this.U = Integer.MIN_VALUE;
        this.V = new c(this);
        this.W = 0;
        this.k0 = false;
        this.L0 = 0.1f;
        this.P0 = new Handler(Looper.getMainLooper());
        this.V0 = new a();
        if (r11 == null) goto L14;
        TypedArray r14 = r9.obtainStyledAttributes(r11, new int[]{2130974720, 2130974721, 2130974723, 2130974728, 2130974729, 2130974749, 2130974750, 2130974751, 2130974752});
        String r15 = r14.getString(5);
        if (r15 != null) goto L9;
        r15 = "";
    L9:
        this.E = r15;
        r14.getColor(6, -16777216);
        this.G = r14.getDimension(8, s1.f(14.0f));
        this.F = r14.getDimension(7, 0.0f);
        this.J = r14.getDimension(0, s1.f(40.0f));
        this.H = r14.getDimension(3, r0);
        this.I = r14.getDimension(2, r13);
        this.K = r14.getInt(4, 1);
        this.m = r14.getColor(1, -1);
        r14.recycle();
        setLayerType(1, null);
        this.e = -1;
        this.f = 1040187391;
        this.g = -16777216;
        this.h = 1073741824;
        s1.h(2131106784);
        this.l = s1.i("#ff4e33", -1);
        Paint r16 = new Paint();
        this.o = r16;
        r16.setStyle(Paint.Style.FILL);
        this.o.setStrokeWidth(this.I);
        this.o.setStrokeCap(Paint.Cap.ROUND);
        this.o.setAntiAlias(true);
        Paint r17 = new Paint();
        this.p = r17;
        r17.setStyle(Paint.Style.FILL);
        this.p.setStrokeWidth(this.I);
        this.p.setStrokeCap(Paint.Cap.ROUND);
        this.p.setAntiAlias(true);
        Paint r18 = new Paint();
        this.q = r18;
        r18.setStyle(Paint.Style.FILL);
        this.q.setAntiAlias(true);
        Paint r19 = new Paint();
        this.s = r19;
        r19.setStyle(Paint.Style.FILL);
        this.s.setAntiAlias(true);
        Paint r21 = new Paint();
        this.t = r21;
        r21.setTextSize(this.G);
        this.t.setAntiAlias(true);
        Paint r22 = new Paint();
        this.u = r22;
        r22.setTextSize(this.G);
        this.u.setAntiAlias(true);
        g(true);
        setImportantForAccessibility(1);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        if (Build.VERSION.SDK_INT < 26) goto L13;
        setFocusedByDefault(true);
        return;
    L13:
        return;
    }

    public final void c(int r1, int r2, int r3) {
        this.e = r1;
        this.f = r2;
        this.l = r3;
        g(false);
    }

    public final void e(int r1, int r2, int r3, boolean r4) {
        this.M = r1;
        this.N = r2;
        if (r3 > r1) goto L6;
        if (r3 < r2) goto L6;
        this.O = r3;
    L7:
        this.L = r1 - r2;
        this.P = r4;
        if (this.a > 0) goto L10;
    L12:
        invalidate();
        this.p0 = null;
        ValueAnimator r5 = this.H0;
        if (r5 == null) goto L15;
        r5.cancel();
        this.H0 = null;
    L15:
        this.L0 = 0.0f;
        return;
    L10:
        if (this.b <= 0) goto L12;
        f();
    L6:
        this.O = r1;
        goto L7
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.b == getMeasuredHeight()) goto L5;
    L6:
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
        f();
        return;
    L5:
        if (this.a != getMeasuredWidth()) goto L6;
    }
}
