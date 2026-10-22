package com.ss.android.lark.custom.repeat.widget.wheelview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h18.e;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import oab.f;
import sab.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WheelView extends View {
    public int A;
    public int B;
    public long C;
    public int D;
    public DividerType E;
    public GestureDetector F;
    public boolean G;
    public final boolean H;
    public ScheduledFuture<?> I;
    public String J;
    public int K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public final float R;
    public boolean S;
    public final Float T;
    public Object[] U;
    public Context a;
    public a b;
    public f c;
    public final ScheduledExecutorService d;
    public Paint e;
    public Paint f;
    public Paint g;
    public mab.a h;
    public int i;
    public int j;
    public int k;
    public float l;
    public Typeface m;
    public int n;
    public int o;
    public int p;
    public float q;
    public boolean r;
    public float s;
    public float t;
    public float u;
    public float v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;
        public static final /* synthetic */ ACTION[] a = null;

        static {
            ACTION r0 = new ACTION("CLICK", 0);
            CLICK = r0;
            ACTION r1 = new ACTION("FLING", 1);
            FLING = r1;
            ACTION r3 = new ACTION("DAGGLE", 2);
            DAGGLE = r3;
            a = new ACTION[]{r0, r1, r3};
        }

        public static ACTION[] values() {
            return (ACTION[]) a.clone();
        }

        public static ACTION valueOf(String r1) {
            return (ACTION) r27.a.a(ACTION.class, r1);
        }

        public ACTION(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum DividerType extends Enum<DividerType> {
        public static final DividerType FILL = null;
        public static final DividerType NONE = null;
        public static final DividerType WRAP = null;
        public static final /* synthetic */ DividerType[] a = null;

        static {
            DividerType r0 = new DividerType("FILL", 0);
            FILL = r0;
            DividerType r1 = new DividerType("WRAP", 1);
            WRAP = r1;
            DividerType r3 = new DividerType("NONE", 2);
            NONE = r3;
            a = new DividerType[]{r0, r1, r3};
        }

        public static DividerType[] values() {
            return (DividerType[]) a.clone();
        }

        public static DividerType valueOf(String r1) {
            return (DividerType) r27.a.a(DividerType.class, r1);
        }

        public DividerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        ScheduledFuture<?> r0 = this.I;     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r0.isCancelled() == true) goto L8;
        this.I.cancel(true);     // Catch: Throwable -> L10
        this.I = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setLoopChangeListener(tab.a r1) {
    }

    public int getItemsCount() {
        mab.a r0 = this.h;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getItemsCount();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final mab.a getAdapter() {
        return this.h;
    }

    public final int getCurrentItem() {
        return this.L;
    }

    public WheelView(Context r2) {
        this(r2, null);
    }

    public final String b(Object r4) {
        if (r4 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if ((r4 instanceof uab.a) == false) goto L10;
        return ((uab.a) r4).a();
    L10:
        if ((r4 instanceof Integer) == false) goto L16;
        if (this.S == false) goto L16;
        return String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(((Integer) r4).intValue())});
    L16:
        return r4.toString();
    }

    public final int c(int r2) {
        if (this.h.getItemsCount() > 0) goto L6;
        return 0;
    L6:
        if (r2 >= 0) goto L9;
        return c(r2 + this.h.getItemsCount());
    L9:
        if (r2 > (this.h.getItemsCount() - 1)) goto L11;
        return r2;
    L11:
        return c(r2 - this.h.getItemsCount());
    }

    public final void d(ACTION r8) {
        a();
        if (r8 != ACTION.FLING) goto L5;
    L6:
        float r9 = this.v;
        float r0 = this.l;
        int r10 = (int) (((r9 % r0) + r0) % r0);
        this.M = r10;
        if (r10 <= (r0 / 2.0f)) goto L9;
        this.M = (int) (r0 - r10);
    L10:
        this.I = this.d.scheduleWithFixedDelay(new b(this, this.M), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.M = -r10;
        goto L10
    L5:
        if (r8 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r19) {
        mab.a r1 = this.h;
        if (r1 != null) goto L5;
        return;
    L5:
        int r8 = 0;
        if (this.w >= 0) goto L9;
        this.w = 0;
    L9:
        if (this.w < r1.getItemsCount()) goto L11;
        this.w = this.h.getItemsCount() - 1;
    L11:
        Object[] r10 = this.U;
        this.x = this.w + (((int) (this.v / this.l)) % this.h.getItemsCount());     // Catch: ArithmeticException -> L14
    L15:
        float r2 = this.v % this.l;
        if (Math.abs(r2) > (this.l - 10.0f)) goto L18;
        float r12 = r2;
    L24:
        if (this.r == true) goto L32;
        if (this.x >= 0) goto L29;
        this.x = 0;
    L29:
        if (this.x <= (this.h.getItemsCount() - 1)) goto L37;
        this.x = this.h.getItemsCount() - 1;
    L37:
        int r3 = 0;
    L38:
        int r4 = this.y;
        if (r3 >= r4) goto L50;
        int r5 = this.x - ((r4 / 2) - r3);
        if (this.r == false) goto L43;
        r10[r3] = this.h.getItem(c(r5));
    L49:
        r3 = r3 + 1;
        goto L38
    L43:
        if (r5 >= 0) goto L46;
        r10[r3] = BuildConfig.FLAVOR;
        goto L49
    L46:
        if (r5 <= (this.h.getItemsCount() - 1)) goto L48;
        r10[r3] = BuildConfig.FLAVOR;
        goto L49
    L48:
        r10[r3] = this.h.getItem(r5);
        goto L49
    L50:
        DividerType r6 = this.E;
        if (r6 != DividerType.WRAP) goto L62;
        if (TextUtils.isEmpty(this.J) == false) goto L55;
        int r7 = (this.A - this.j) / 2;
    L56:
        float r9 = r7 - 12;
        if (r9 > 0.0f) goto L59;
        float r14 = 10.0f;
    L60:
        float r15 = this.A - r14;
        float r11 = this.s;
        float r13 = r14;
        r19.drawLine(r13, r11, r15, r11, this.g);
        float r16 = this.t;
        r19.drawLine(r13, r16, r15, r16, this.g);
    L65:
        if (TextUtils.isEmpty(this.J) == false) goto L67;
    L77:
        int r17 = 0;
    L79:
        if (r17 >= this.y) goto L170;
        r19.save();
        double r18 = ((this.l * r17) - r12) / this.B;
        float r20 = (float) (90.0d - ((r18 / 3.141592653589793d) * 180.0d));
        if (r20 < 90.0f) goto L83;
    L168:
        r19.restore();
    L169:
        r17 = r17 + 1;
        r12 = r12;
        goto L79
    L83:
        if (r20 <= (-90.0f)) goto L168;
        float r21 = (float) Math.pow(Math.abs(r20) / 90.0f, 2.2d);
        if (this.H == false) goto L88;
    L92:
        String r22 = b(r10[r17]);
    L93:
        Rect r110 = new Rect();
        this.f.getTextBounds(r22, r8, r22.length(), r110);
        int r23 = r110.width();
        int r111 = this.i;
    L95:
        if (r23 <= this.A) goto L97;
        r111 = r111 - 1;
        this.f.setTextSize(r111);
        this.f.getTextBounds(r22, r8, r22.length(), r110);
        r23 = r110.width();
        goto L95
    L97:
        this.e.setTextSize(r111);
        Rect r24 = new Rect();
        this.f.getTextBounds(r22, r8, r22.length(), r24);
        int r112 = this.O;
        if (r112 == 3) goto L115;
        if (r112 == 5) goto L113;
        if (r112 == 17) goto L103;
    L114:
        int r25 = 0;
    L116:
        Rect r113 = new Rect();
        this.e.getTextBounds(r22, r25, r22.length(), r113);
        int r26 = this.O;
        if (r26 != 3) goto L119;
        this.Q = 0;
    L136:
        float r27 = (float) (((((double) this.B) - (Math.cos(r18) * ((double) this.B))) - ((Math.sin(r18) * ((double) this.k)) / 2.0d)) + ((Math.sin(r18) - 1.0d) * ((double) this.k)));
        r19.translate(0.0f, r27);
        float r28 = this.s;
        if (r27 <= r28) goto L139;
    L143:
        float r29 = this.t;
        if (r27 > r29) goto L151;
        if ((this.k + r27) < r29) goto L151;
        r19.save();
        r19.clipRect(0.0f, 0.0f, this.A, this.t - r27);
        r19.drawText(r22, this.P, this.k - this.R, this.f);
        r19.restore();
        r19.save();
        r19.clipRect(0.0f, this.t - r27, this.A, (int) this.l);
        r19.drawText(r22, this.Q, this.k, this.e);
        r19.restore();
        float r30 = this.t;
        if ((r30 - r27) <= ((r27 + this.k) - r30)) goto L155;
        this.L = this.h.indexOf(r10[r17]);
    L155:
        r8 = 0;
    L167:
        r19.restore();
        this.f.setTextSize(this.i);
    L151:
        if (r27 >= r28) goto L153;
    L156:
        r19.save();
        r8 = 0;
        r19.clipRect(0, 0, this.A, (int) this.l);
        Paint r31 = this.e;
        int r32 = this.K;
        int r114 = -1;
        if (r32 != 0) goto L159;
        int r33 = 0;
    L163:
        if (r20 > 0.0f) goto L166;
        r114 = 1;
    L166:
        r31.setTextSkewX(((r33 * r114) * 0.5f) * r21);
        this.e.setAlpha((int) ((1.0f - r21) * 255.0f));
        r19.drawText(r22, this.Q + (this.K * r21), this.k, this.e);
        r19.restore();
        goto L167
    L159:
        if (r32 <= 0) goto L161;
        r33 = 1;
        goto L163
    L161:
        r33 = -1;
        goto L163
    L153:
        if ((this.k + r27) > r29) goto L156;
        r19.scale(1.0f, 1.176f);
        r19.drawText(r22, this.P, (this.k * 0.916f) - this.R, this.f);
        this.L = this.h.indexOf(r10[r17]);
        goto L155
    L139:
        if ((this.k + r27) < r28) goto L143;
        r19.save();
        r19.clipRect(0.0f, 0.0f, this.A, this.s - r27);
        r19.drawText(r22, this.Q, this.k, this.e);
        r19.restore();
        r19.save();
        r19.clipRect(0.0f, this.s - r27, this.A, (int) this.l);
        r19.drawText(r22, this.P, this.k - this.R, this.f);
        r19.restore();
        float r34 = this.s;
        if ((r34 - r27) >= ((r27 + this.k) - r34)) goto L155;
        this.L = this.h.indexOf(r10[r17]);
        goto L155
    L119:
        if (r26 != 5) goto L121;
        this.Q = (this.A - r113.width()) - ((int) this.R);
        goto L136
    L121:
        if (r26 != 17) goto L136;
        if (this.G == true) goto L133;
        String r35 = this.J;
        if (r35 == null) goto L133;
        if (r35.equals(BuildConfig.FLAVOR) == true) goto L133;
        if (this.H == false) goto L133;
        this.Q = (int) ((this.A - r113.width()) * 0.25f);
    L133:
        this.Q = (int) ((this.A - r113.width()) * 0.5f);
        goto L136
    L103:
        if (this.G == true) goto L112;
        String r115 = this.J;
        if (r115 == null) goto L112;
        if (r115.equals(BuildConfig.FLAVOR) == true) goto L112;
        if (this.H == false) goto L112;
        this.P = (int) ((this.A - r24.width()) * 0.25f);
    L112:
        this.P = (int) ((this.A - r24.width()) * 0.5f);
        goto L114
    L113:
        this.P = (this.A - r24.width()) - ((int) this.R);
        goto L114
    L115:
        r25 = 0;
        this.P = 0;
        goto L116
    L88:
        if (TextUtils.isEmpty(this.J) == true) goto L92;
        if (TextUtils.isEmpty(b(r10[r17])) == true) goto L92;
        r22 = b(r10[r17]) + this.J;
        goto L93
    L170:
        return;
    L67:
        if (this.H == false) goto L77;
        int r36 = this.A;
        Paint r37 = this.f;
        String r38 = this.J;
        if (r38 != null) goto L71;
    L75:
        int r39 = 0;
    L76:
        r19.drawText(this.J, (r36 - r39) - this.R, this.u, this.f);
        goto L77
    L71:
        if (r38.length() <= 0) goto L75;
        int r40 = r38.length();
        float[] r41 = new float[r40];
        r37.getTextWidths(r38, r41);
        int r42 = 0;
        r39 = 0;
    L73:
        if (r42 >= r40) goto L76;
        r39 = r39 + ((int) Math.ceil(r41[r42]));
        r42 = r42 + 1;
        goto L73
    L59:
        r14 = r9;
        goto L60
    L55:
        r7 = (this.A - this.j) / 4;
        goto L56
    L62:
        if (r6 != DividerType.FILL) goto L65;
        float r43 = this.s;
        r19.drawLine(0.0f, r43, this.A, r43, this.g);
        float r44 = this.t;
        r19.drawLine(0.0f, r44, this.A, r44, this.g);
        goto L65
    L32:
        if (this.x >= 0) goto L35;
        this.x = this.h.getItemsCount() + this.x;
    L35:
        if (this.x <= (this.h.getItemsCount() - 1)) goto L37;
        this.x -= this.h.getItemsCount();
        goto L37
    L18:
        if (r2 <= 0.0f) goto L20;
        this.x++;
    L21:
        r12 = 0.0f;
        goto L24
    L20:
        this.x--;
    L14:
        Log.e("WheelView", "adapter.getItemsCount == 0");
        goto L15
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r11) {
        boolean r0 = this.F.onTouchEvent(r11);
        if (r11.isFromSource(2) == true) goto L5;
    L23:
        invalidate();
        return super.onGenericMotionEvent(r11);
    L5:
        if (r11.getAction() != 8) goto L23;
        float r2 = (-r11.getAxisValue(9)) * this.T.floatValue();
        this.v += r2;
        if (this.r == true) goto L20;
        float r3 = (-this.w) * this.l;
        float r5 = (this.h.getItemsCount() - 1) - this.w;
        float r6 = this.l;
        float r7 = r5 * r6;
        float r8 = this.v;
        if ((r8 - (r6 * 0.25f)) >= r3) goto L12;
        r3 = r8 - r2;
    L15:
        if (r8 >= r3) goto L18;
        this.v = (int) r3;
        goto L20
    L18:
        if (r8 <= r7) goto L20;
        this.v = (int) r7;
        goto L20
    L12:
        if (((r6 * 0.25f) + r8) <= r7) goto L15;
        r7 = r8 - r2;
    L20:
        if (r0 == true) goto L23;
        float r12 = r11.getY();
        int r1 = this.B;
        double r4 = Math.acos((r1 - r12) / r1) * ((double) this.B);
        float r13 = this.l;
        int r9 = (int) ((r4 + ((double) (r13 / 2.0f))) / ((double) r13));
        this.M = (int) (((r9 - (this.y / 2)) * r13) - (((this.v % r13) + r13) % r13));
        d(ACTION.DAGGLE);
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        boolean r0 = this.F.onTouchEvent(r8);
        int r1 = r8.getAction();
        if (r1 != 0) goto L5;
        this.C = System.currentTimeMillis();
        a();
        this.N = r8.getRawY();
    L26:
        invalidate();
        if (getParent() == null) goto L29;
        getParent().requestDisallowInterceptTouchEvent(true);
    L29:
        return true;
    L5:
        if (r1 == 2) goto L11;
        if (r0 == true) goto L26;
        float r9 = r8.getY();
        int r2 = this.B;
        double r3 = Math.acos((r2 - r9) / r2) * ((double) this.B);
        float r10 = this.l;
        this.M = (int) (((((int) ((r3 + ((double) (r10 / 2.0f))) / ((double) r10))) - (this.y / 2)) * r10) - (((this.v % r10) + r10) % r10));
        if ((System.currentTimeMillis() - this.C) <= 120) goto L10;
        d(ACTION.DAGGLE);
        goto L26
    L10:
        d(ACTION.CLICK);
        goto L26
    L11:
        float r4 = this.N - r8.getRawY();
        this.N = r8.getRawY();
        this.v += r4;
        if (this.r == true) goto L26;
        float r11 = (-this.w) * this.l;
        float r5 = (this.h.getItemsCount() - 1) - this.w;
        float r6 = this.l;
        float r7 = r5 * r6;
        float r12 = this.v;
        if ((r12 - (r6 * 0.25f)) >= r11) goto L17;
        r11 = r12 - r4;
    L20:
        if (r12 >= r11) goto L23;
        this.v = (int) r11;
        goto L26
    L23:
        if (r12 <= r7) goto L26;
        this.v = (int) r7;
        goto L26
    L17:
        if (((r6 * 0.25f) + r12) <= r7) goto L20;
        r7 = r12 - r4;
        goto L20
    }

    public final void setAdapter(mab.a r1) {
        this.h = r1;
        invalidate();
    }

    public final void setCurrentItem(int r1) {
        this.L = r1;
        this.w = r1;
        this.v = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r1) {
        this.r = r1;
    }

    public void setDividerColor(int r2) {
        if (r2 == 0) goto L5;
        this.p = r2;
        this.g.setColor(r2);
        return;
    }

    public void setDividerType(DividerType r1) {
        this.E = r1;
    }

    public void setGravity(int r1) {
        this.O = r1;
    }

    public void setIsOptions(boolean r1) {
        this.G = r1;
    }

    public void setItemVisible(int r2) {
        if (r2 == this.y) goto L5;
        this.U = new Object[r2];
    L5:
        this.y = r2;
    }

    public void setLabel(String r1) {
        this.J = r1;
    }

    public void setLineSpacingMultiplier(float r3) {
        if (r3 == 0.0f) goto L11;
        this.q = r3;
        if (r3 >= 1.0f) goto L8;
        this.q = 1.0f;
        return;
    L8:
        if (r3 <= 4.0f) goto L13;
        this.q = 4.0f;
        return;
    L13:
        return;
    }

    public final void setOnItemSelectedListener(f r1) {
        this.c = r1;
    }

    public void setShowTwoFigure(boolean r1) {
        this.S = r1;
    }

    public void setTextColorCenter(int r2) {
        if (r2 == 0) goto L5;
        this.o = r2;
        this.f.setColor(r2);
        return;
    }

    public void setTextColorOut(int r2) {
        if (r2 == 0) goto L5;
        this.n = r2;
        this.e.setColor(r2);
        return;
    }

    public final void setTextSize(float r3) {
        if (r3 <= 0.0f) goto L6;
        Resources r0 = this.a.getResources();
        int r4 = (int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
        this.i = r4;
        this.e.setTextSize(r4);
        this.f.setTextSize(this.i);
        return;
    }

    public void setTextXOffset(int r2) {
        this.K = r2;
        if (r2 == 0) goto L6;
        this.f.setTextScaleX(1.0f);
        return;
    }

    public final void setTypeface(Typeface r2) {
        this.m = r2;
        this.e.setTypeface(r2);
        this.f.setTypeface(this.m);
    }

    public WheelView(Context r12, AttributeSet r13) {
        super(r12, r13);
        this.d = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("iew/WheelView"));
        this.n = -5723992;
        this.o = -14013910;
        this.p = -2763307;
        this.q = 2.5f;
        this.y = 5;
        this.C = 0;
        this.G = false;
        this.H = true;
        this.M = 0;
        this.N = 0.0f;
        this.O = 17;
        this.P = 0;
        this.Q = 0;
        this.U = new Object[5];
        this.T = Float.valueOf(ViewConfigurationCompat.getScaledVerticalScrollFactor(ViewConfiguration.get(r12), r12));
        this.i = (int) getResources().getDimension(2131168247);
        this.o = r12.getResources().getColor(2131106622);
        this.m = e.a(r12);
        Resources r6 = getResources();
        float r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density;
        if (r7 >= 1.0f) goto L6;
        this.R = 2.4f;
    L22:
        if (r13 == null) goto L24;
        TypedArray r14 = r12.obtainStyledAttributes(r13, new int[]{2130973494, 2130973495, 2130973496, 2130973497, 2130973498, 2130973499}, 0, 0);
        this.O = r14.getInt(1, 17);
        this.n = r14.getColor(4, this.n);
        this.o = r14.getColor(3, this.o);
        this.p = r14.getColor(0, this.p);
        this.i = r14.getDimensionPixelOffset(5, this.i);
        this.q = r14.getFloat(2, this.q);
        r14.recycle();
    L24:
        float r15 = this.q;
        if (r15 >= 1.0f) goto L28;
        this.q = 1.0f;
    L30:
        this.a = r12;
        this.b = new a(this);
        GestureDetector r16 = new GestureDetector(r12, new tab.b(this));
        this.F = r16;
        r16.setIsLongpressEnabled(false);
        this.r = true;
        this.v = 0.0f;
        this.w = -1;
        Paint r17 = new Paint();
        this.e = r17;
        r17.setColor(this.n);
        this.e.setAntiAlias(true);
        this.e.setTypeface(this.m);
        this.e.setTextSize(this.i);
        Paint r18 = new Paint();
        this.f = r18;
        r18.setColor(this.o);
        this.f.setAntiAlias(true);
        this.f.setTextScaleX(1.176f);
        this.f.setTypeface(this.m);
        this.f.setTextSize(this.i * 1.176f);
        Paint r19 = new Paint();
        this.g = r19;
        r19.setColor(this.p);
        this.g.setAntiAlias(true);
        setLayerType(1, null);
        return;
    L28:
        if (r15 <= 4.0f) goto L30;
        this.q = 4.0f;
        goto L30
    L6:
        if (1.0f <= r7) goto L8;
    L10:
        if (1.0f > r7) goto L15;
        if (r7 >= 2.0f) goto L15;
        this.R = 4.5f;
    L15:
        if (2.0f > r7) goto L20;
        if (r7 >= 3.0f) goto L20;
        this.R = 6.0f;
    L20:
        if (r7 < 3.0f) goto L22;
        this.R = r7 * 2.5f;
        goto L22
    L8:
        if (r7 >= 2.0f) goto L10;
        this.R = 3.6f;
        goto L22
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        this.D = r8;
        if (this.h == null) goto L22;
        this.f.setTextScaleX(1.176f);
        this.f.setTextSize(this.i * 1.176f);
        Rect r10 = new Rect();
        if (TextUtils.isEmpty(this.h.a()) == true) goto L8;
        this.f.getTextBounds(this.h.a(), 0, this.h.a().length(), r10);
        this.j = r10.width();
    L15:
        this.f.getTextBounds("星期", 0, 2, r10);
        int r11 = r10.height() + 2;
        this.k = r11;
        float r12 = this.q * r11;
        this.l = r12;
        int r13 = (int) (r12 * (this.y - 1));
        this.z = (int) (((double) (r13 * 2)) / 3.141592653589793d);
        this.B = (int) (((double) r13) / 3.141592653589793d);
        this.A = View.MeasureSpec.getSize(this.D);
        float r14 = this.z;
        float r15 = this.l;
        this.s = (r14 - r15) / 2.0f;
        float r16 = (r14 + r15) / 2.0f;
        this.t = r16;
        this.u = (r16 - ((r15 - this.k) / 2.0f)) - this.R;
        if (this.w != (-1)) goto L22;
        if (this.r == false) goto L20;
        this.w = (this.h.getItemsCount() + 1) / 2;
    L21:
        this.x = this.w;
        goto L22
    L20:
        this.w = 0;
        goto L21
    L8:
        int r17 = 0;
    L10:
        if (r17 >= this.h.getItemsCount()) goto L15;
        String r1 = b(this.h.getItem(r17));
        this.f.getTextBounds(r1, 0, r1.length(), r10);
        int r2 = r10.width();
        if (r2 <= this.j) goto L14;
        this.j = r2;
    L14:
        r17 = r17 + 1;
    L22:
        setMeasuredDimension(this.A, this.z);
    }
}
