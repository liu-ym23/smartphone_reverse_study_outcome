package com.bytedance.android.livesdk.chatroom.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveSwitchButton extends View implements Checkable {
    public static final int H0 = 0;
    public static final int L0 = 0;
    public float A;
    public Paint B;
    public Paint C;
    public g D;
    public g E;
    public g F;
    public int G;
    public ValueAnimator H;
    public final ArgbEvaluator I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public e S;
    public View.OnClickListener T;
    public f U;
    public long V;
    public final b W;
    public int a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public int k;
    public final c k0;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public final d p0;
    public float q;
    public int r;
    public int s;
    public float t;
    public float u;
    public float v;
    public float w;
    public int x;
    public int y;
    public float z;

    public class a extends AccessibilityDelegateCompat {
        public final /* synthetic */ LiveSwitchButton a;

        public a(LiveSwitchButton r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            r2.setCheckable(true);
            r2.setChecked(this.a.J);
            r2.setClassName(ToggleButton.class.getName());
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ LiveSwitchButton a;

        public final void a() {
            LiveSwitchButton r0 = this.a;
            int r1 = LiveSwitchButton.H0;
            int r2 = r0.G;
            boolean r3 = false;
            if (r2 == 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == true) goto L26;
            if (r2 == 0) goto L9;
            r3 = true;
        L9:
            if (r3 == false) goto L12;
            return;
        L12:
            if (r0.O == true) goto L15;
            return;
        L15:
            if (r0.L == true) goto L18;
            return;
        L18:
            if (r0.H.isRunning() == false) goto L20;
            r0.H.cancel();
        L20:
            r0.G = 1;
            g.a(r0.E, r0.D);
            g.a(r0.F, r0.D);
            if (r0.isChecked() == false) goto L23;
            g r5 = r0.F;
            int r6 = r0.m;
            r5.b = r6;
            r5.a = r0.A;
            r5.c = r6;
        L24:
            r0.H.start();
            return;
        L23:
            g r7 = r0.F;
            r7.b = r0.l;
            r7.a = r0.z;
            r7.d = r0.d;
            goto L24
        L26:
            return;
        L5:
            r4 = false;
            goto L6
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

        public b(LiveSwitchButton r1) {
            this.a = r1;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LiveSwitchButton a;

        public c(LiveSwitchButton r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            float r9 = ((Float) r8.getAnimatedValue()).floatValue();
            LiveSwitchButton r0 = this.a;
            int r1 = r0.G;
            if (r1 != 1) goto L5;
        L12:
            g r2 = r0.D;
            r2.c = ((Integer) r0.I.evaluate(r9, Integer.valueOf(r0.E.c), Integer.valueOf(this.a.F.c))).intValue();
            LiveSwitchButton r3 = this.a;
            g r4 = r3.D;
            g r5 = r3.E;
            float r6 = r5.d;
            g r7 = r3.F;
            r4.d = r6 + ((r7.d - r6) * r9);
            if (r3.G == 1) goto L15;
            float r10 = r5.a;
            r4.a = r10 + ((r7.a - r10) * r9);
        L15:
            r4.b = ((Integer) r3.I.evaluate(r9, Integer.valueOf(r5.b), Integer.valueOf(this.a.F.b))).intValue();
        L16:
            this.a.postInvalidate();
            return;
        L5:
            if (r1 == 3) goto L12;
            if (r1 == 4) goto L12;
            if (r1 != 5) goto L16;
            g r11 = r0.D;
            float r12 = r0.E.a;
            float r13 = r12 + ((r0.F.a - r12) * r9);
            r11.a = r13;
            float r14 = r0.z;
            float r15 = (r13 - r14) / (r0.A - r14);
            r11.b = ((Integer) r0.I.evaluate(r15, Integer.valueOf(r0.l), Integer.valueOf(this.a.m))).intValue();
            LiveSwitchButton r16 = this.a;
            g r17 = r16.D;
            r17.d = r16.d * r15;
            r17.c = ((Integer) r16.I.evaluate(r15, 0, Integer.valueOf(this.a.o))).intValue();
            goto L16
        }
    }

    public class d implements Animator.AnimatorListener {
        public final /* synthetic */ LiveSwitchButton a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public d(LiveSwitchButton r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            LiveSwitchButton r6 = this.a;
            int r0 = r6.G;
            if (r0 != 1) goto L5;
            r6.G = 2;
            g r1 = r6.D;
            r1.c = 0;
            r1.d = r6.d;
            r6.postInvalidate();
            return;
        L5:
            if (r0 != 3) goto L7;
            r6.G = 0;
            r6.postInvalidate();
            return;
        L7:
            if (r0 != 4) goto L9;
            r6.G = 0;
            r6.postInvalidate();
            this.a.a();
            return;
        L9:
            if (r0 != 5) goto L19;
            r6.J = !r6.J;
            r6.G = 0;
            r6.postInvalidate();
            this.a.a();
            return;
        }
    }

    public interface e {
        void d0(LiveSwitchButton r1, boolean r2);
    }

    public interface f {
        Boolean a(boolean r1);
    }

    public static class g {
        public float a;
        public int b;
        public int c;
        public float d;

        public g() {
        }

        public static void a(g r1, g r2) {
            r1.getClass();
            r1.a = r2.a;
            r1.b = r2.b;
            r1.c = r2.c;
            r1.d = r2.d;
        }
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener r1) {
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        f(true, true);
    }

    static {
        H0 = (int) b(58.0f);
        L0 = (int) b(36.0f);
    }

    public final void a() {
        e r0 = this.S;
        if (r0 == null) goto L5;
        this.Q = true;
        r0.d0(this, isChecked());
    L5:
        this.Q = false;
    }

    public final void e() {
        int r0 = this.G;
        boolean r2 = true;
        if (r0 != 2) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L14;
        if (r0 == 1) goto L12;
        if (r0 == 3) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        if (this.H.isRunning() == false) goto L16;
        this.H.cancel();
    L16:
        this.G = 3;
        g.a(this.E, this.D);
        if (isChecked() == false) goto L19;
        setCheckedViewState(this.F);
    L20:
        this.H.start();
        return;
    L19:
        setUncheckViewState(this.F);
        goto L20
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (((Boolean) j40.m3.a.getValue()).booleanValue() == false) goto L8;
        if (this.T != null) goto L8;
        toggle();
    L8:
        return super.performClick();
    }

    public boolean getEnableTouchEvent() {
        return this.R;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.J;
    }

    public LiveSwitchButton(Context r3) {
        super(r3);
        new RectF();
        this.G = 0;
        this.I = new ArgbEvaluator();
        this.L = true;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.W = new b(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        c(r3, null);
    }

    public static float b(float r2) {
        return TypedValue.applyDimension(1, r2, com.bytedance.android.live.core.utils.s1.l());
    }

    private void setCheckedViewState(g r2) {
        r2.d = this.d;
        r2.b = this.m;
        r2.c = this.o;
        r2.a = this.A;
        this.B.setColor(this.y);
    }

    private void setUncheckViewState(g r2) {
        r2.d = 0.0f;
        r2.b = this.l;
        r2.c = 0;
        r2.a = this.z;
        this.B.setColor(this.x);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        this.C.setStrokeWidth(this.n);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setColor(this.k);
        float r3 = this.f;
        float r4 = this.g;
        float r5 = this.h;
        float r6 = this.i;
        float r8 = this.d;
        r14.drawRoundRect(r3, r4, r5, r6, r8, r8, this.C);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setColor(this.l);
        float r7 = this.f;
        float r9 = this.g;
        float r10 = this.h;
        float r11 = this.i;
        float r12 = this.d;
        r14.drawRoundRect(r7, r9, r10, r11, r12, r12, this.C);
        if (this.N == false) goto L5;
        int r0 = this.r;
        float r1 = this.s;
        float r2 = this.h - this.t;
        float r13 = this.j;
        float r15 = this.u;
        Paint r16 = this.C;
        r16.setStyle(Paint.Style.STROKE);
        r16.setColor(r0);
        r16.setStrokeWidth(r1);
        r14.drawCircle(r2, r13, r15, r16);
    L5:
        float r17 = this.D.d * 0.5f;
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setColor(this.D.b);
        this.C.setStrokeWidth(this.n + (r17 * 2.0f));
        float r18 = this.f + r17;
        float r19 = this.g + r17;
        float r20 = this.h - r17;
        float r21 = this.i - r17;
        float r110 = this.d;
        r14.drawRoundRect(r18, r19, r20, r21, r110, r110, this.C);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setStrokeWidth(1.0f);
        float r22 = this.f;
        float r23 = this.g;
        float r24 = this.d * 2.0f;
        r14.drawArc(r22, r23, r22 + r24, r23 + r24, 90.0f, 180.0f, true, this.C);
        float r25 = this.f;
        float r26 = this.d;
        float r27 = this.g;
        r14.drawRect(r25 + r26, r27, this.D.a, r27 + (r26 * 2.0f), this.C);
        if (this.N == false) goto L8;
        int r28 = this.D.c;
        float r29 = this.p;
        float r30 = this.f + this.d;
        float r31 = r30 - this.v;
        float r32 = this.j;
        float r33 = this.q;
        Paint r111 = this.C;
        r111.setStyle(Paint.Style.STROKE);
        r111.setColor(r28);
        r111.setStrokeWidth(r29);
        r14.drawLine(r31, r32 - r33, r30 - this.w, r32 + r33, r111);
    L8:
        float r34 = this.D.a;
        float r35 = this.j;
        r14.drawCircle(r34, r35, this.e, this.B);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(1.0f);
        this.C.setColor(-2236963);
        r14.drawCircle(r34, r35, this.e, this.C);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r12) {
        boolean r1 = false;
        if (isEnabled() == true) goto L6;
        return false;
    L6:
        if (this.R == false) goto L8;
        return false;
    L8:
        View.OnClickListener r0 = this.T;
        if (r0 == null) goto L12;
        r0.onClick(this);
        return false;
    L12:
        int r2 = r12.getActionMasked();
        if (r2 != 0) goto L15;
        this.O = true;
        this.V = System.currentTimeMillis();
        removeCallbacks(this.W);
        postDelayed(this.W, 100);
    L73:
        return true;
    L15:
        if (r2 == 1) goto L42;
        if (r2 == 2) goto L30;
        if (r2 != 3) goto L73;
        this.O = false;
        removeCallbacks(this.W);
        int r13 = this.G;
        if (r13 == 1) goto L24;
        if (r13 == 3) goto L24;
        boolean r3 = false;
    L25:
        if (r3 == true) goto L29;
        if (r13 != 2) goto L28;
        r1 = true;
    L28:
        if (r1 == false) goto L73;
    L29:
        e();
    L24:
        r3 = true;
        goto L25
    L30:
        float r14 = r12.getX();
        int r4 = this.G;
        if (r4 == 1) goto L35;
        if (r4 == 3) goto L35;
        boolean r5 = false;
    L36:
        if (r5 == false) goto L38;
        float r15 = Math.max(0.0f, Math.min(1.0f, r14 / getWidth()));
        g r6 = this.D;
        float r7 = this.z;
        r6.a = r7 + ((this.A - r7) * r15);
        goto L73
    L38:
        if (r4 != 2) goto L40;
        r1 = true;
    L40:
        if (r1 == false) goto L73;
        float r16 = Math.max(0.0f, Math.min(1.0f, r14 / getWidth()));
        g r8 = this.D;
        float r9 = this.z;
        r8.a = r9 + ((this.A - r9) * r16);
        r8.b = ((Integer) this.I.evaluate(r16, Integer.valueOf(this.l), Integer.valueOf(this.m))).intValue();
        postInvalidate();
    L35:
        r5 = true;
        goto L36
    L42:
        this.O = false;
        removeCallbacks(this.W);
        if ((System.currentTimeMillis() - this.V) <= 300) goto L45;
        int r10 = this.G;
        if (r10 != 2) goto L51;
        boolean r11 = true;
    L52:
        if (r11 == true) goto L54;
        if (r10 == 1) goto L69;
        if (r10 == 3) goto L69;
    L70:
        if (r1 == false) goto L73;
        e();
    L69:
        r1 = true;
        goto L70
    L54:
        if (Math.max(0.0f, Math.min(1.0f, r12.getX() / getWidth())) <= 0.5f) goto L57;
        r1 = true;
    L57:
        if (r1 != isChecked()) goto L59;
        e();
        goto L73
    L59:
        this.J = r1;
        if (this.H.isRunning() == false) goto L62;
        this.H.cancel();
    L62:
        this.G = 4;
        g.a(this.E, this.D);
        if (isChecked() == false) goto L65;
        setCheckedViewState(this.F);
    L66:
        this.H.start();
        goto L73
    L65:
        setUncheckViewState(this.F);
        goto L66
    L51:
        r11 = false;
        goto L52
    L45:
        if (((Boolean) j40.m3.a.getValue()).booleanValue() == false) goto L47;
        performClick();
        goto L73
    L47:
        toggle();
        goto L73
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (r2 != isChecked()) goto L6;
        postInvalidate();
        return;
    L6:
        f(this.K, false);
    }

    public void setCheckedButtonColor(int r1) {
        this.y = r1;
    }

    public void setEnableDrag(boolean r1) {
        this.L = r1;
    }

    public void setEnableEffect(boolean r1) {
        this.K = r1;
    }

    public void setEnableTouchEvent(boolean r1) {
        this.R = r1;
    }

    public void setOnCheckedChangeListener(e r1) {
        this.S = r1;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
        this.T = r1;
    }

    public void setShadowEffect(boolean r5) {
        if (this.M != r5) goto L5;
        return;
    L5:
        this.M = r5;
        if (r5 == false) goto L8;
        this.B.setShadowLayer(this.a, 0.0f, this.b, this.c);
        return;
    L8:
        this.B.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    public void setSwitchBackgroundColor(int r1) {
        this.k = r1;
    }

    public void setToggleEventInterceptor(f r1) {
        this.U = r1;
    }

    public void setUncheckButtonColor(int r1) {
        this.x = r1;
    }

    public LiveSwitchButton(Context r3, AttributeSet r4) {
        super(r3, r4);
        new RectF();
        this.G = 0;
        this.I = new ArgbEvaluator();
        this.L = true;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.W = new b(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        c(r3, r4);
    }

    public final void c(Context r9, AttributeSet r10) {
        if (r10 == null) goto L5;
        TypedArray r11 = r9.obtainStyledAttributes(r10, new int[]{2130972637, 2130972638, 2130972639, 2130972640, 2130972641, 2130972643, 2130972644, 2130972645, 2130972646, 2130972647, 2130972649, 2130972650, 2130972651, 2130972652, 2130972653, 2130972654, 2130972655, 2130972656, 2130972657, 2130972658});
    L7:
        if (r11 != null) goto L9;
        boolean r1 = true;
    L10:
        this.M = r1;
        this.r = d(r11, 17, -5592406);
        int r2 = (int) b(1.5f);
        if (r11 == null) goto L14;
        r2 = r11.getDimensionPixelOffset(19, r2);
    L14:
        this.s = r2;
        this.t = b(10.0f);
        float r3 = b(4.0f);
        if (r11 == null) goto L18;
        r3 = r11.getDimension(18, r3);
    L18:
        this.u = r3;
        this.v = b(4.0f);
        this.w = b(4.0f);
        int r4 = (int) b(2.5f);
        if (r11 == null) goto L22;
        r4 = r11.getDimensionPixelOffset(13, r4);
    L22:
        this.a = r4;
        int r5 = (int) b(1.5f);
        if (r11 == null) goto L26;
        r5 = r11.getDimensionPixelOffset(12, r5);
    L26:
        this.b = r5;
        this.c = d(r11, 10, 855638016);
        this.l = d(r11, 15, -2236963);
        this.m = d(r11, 4, -11414681);
        int r6 = (int) b(1.0f);
        if (r11 == null) goto L30;
        r6 = r11.getDimensionPixelOffset(1, r6);
    L30:
        this.n = r6;
        this.o = d(r11, 6, -1);
        int r7 = (int) b(1.0f);
        if (r11 == null) goto L34;
        r7 = r11.getDimensionPixelOffset(7, r7);
    L34:
        this.p = r7;
        this.q = b(6.0f);
        int r8 = d(r11, 2, -1);
        this.x = d(r11, 16, r8);
        this.y = d(r11, 5, r8);
        int r12 = 300;
        if (r11 == null) goto L39;
        r12 = r11.getInt(8, 300);
    L39:
        if (r11 != null) goto L41;
        boolean r13 = false;
    L42:
        this.J = r13;
        if (r11 != null) goto L45;
        boolean r14 = true;
    L46:
        this.N = r14;
        this.k = d(r11, 0, -1);
        if (r11 != null) goto L49;
        boolean r15 = true;
    L50:
        this.K = r15;
        if (r11 == null) goto L53;
        r11.recycle();
    L53:
        this.C = new Paint(1);
        Paint r16 = new Paint(1);
        this.B = r16;
        r16.setColor(r8);
        if (this.M == false) goto L56;
        this.B.setShadowLayer(this.a, 0.0f, this.b, this.c);
    L56:
        this.D = new g();
        this.E = new g();
        this.F = new g();
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.H = r17;
        r17.setDuration(r12);
        this.H.setRepeatCount(0);
        this.H.addUpdateListener(this.k0);
        this.H.addListener(this.p0);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, null);
        com.bytedance.android.livesdk.r3.e(this, new a(this));
        return;
    L49:
        r15 = r11.getBoolean(9, true);
        goto L50
    L45:
        r14 = r11.getBoolean(14, true);
        goto L46
    L41:
        r13 = r11.getBoolean(3, false);
        goto L42
    L9:
        r1 = r11.getBoolean(11, true);
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    public final void f(boolean r3, boolean r4) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        if (r4 == false) goto L12;
        f r0 = this.U;
        if (r0 == null) goto L12;
        if (r0.a(!this.J).booleanValue() == false) goto L12;
        return;
    L12:
        if (this.Q == true) goto L41;
        if (this.P == true) goto L20;
        this.J = !this.J;
        if (r4 == false) goto L42;
        a();
        return;
    L42:
        return;
    L20:
        if (this.H.isRunning() == false) goto L23;
        this.H.cancel();
    L23:
        if (this.K == false) goto L32;
        if (r3 == false) goto L32;
        this.G = 5;
        g.a(this.E, this.D);
        if (isChecked() == false) goto L29;
        setUncheckViewState(this.F);
    L30:
        this.H.start();
        return;
    L29:
        setCheckedViewState(this.F);
    L32:
        this.J = !this.J;
        if (isChecked() == false) goto L35;
        setCheckedViewState(this.D);
    L36:
        postInvalidate();
        if (r4 == false) goto L43;
        a();
        return;
    L43:
        return;
    L35:
        setUncheckViewState(this.D);
        goto L36
    L41:
        throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getMode(r6);
        if (r0 == 0) goto L5;
        if (r0 == Integer.MIN_VALUE) goto L5;
    L6:
        if (r1 == 0) goto L8;
        if (r1 == Integer.MIN_VALUE) goto L8;
    L9:
        super.onMeasure(r5, r6);
        return;
    L8:
        r6 = View.MeasureSpec.makeMeasureSpec(L0, 1073741824);
    L5:
        r5 = View.MeasureSpec.makeMeasureSpec(H0, 1073741824);
        goto L6
    }

    public LiveSwitchButton(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        new RectF();
        this.G = 0;
        this.I = new ArgbEvaluator();
        this.L = true;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.W = new b(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        c(r2, r3);
    }

    public static int d(TypedArray r0, int r1, int r2) {
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0.getColor(r1, r2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        float r7 = Math.max(this.a + this.b, this.n);
        float r8 = r4 - r7;
        float r9 = r3 - r7;
        float r10 = (r8 - r7) * 0.5f;
        this.d = r10;
        this.e = r10 - this.n;
        this.f = r7;
        this.g = r7;
        this.h = r9;
        this.i = r8;
        this.j = (r8 + r7) * 0.5f;
        this.z = r7 + r10;
        this.A = r9 - r10;
        if (isChecked() == false) goto L5;
        setCheckedViewState(this.D);
    L6:
        this.P = true;
        postInvalidate();
        return;
    L5:
        setUncheckViewState(this.D);
        goto L6
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(0, 0, 0, 0);
    }
}
