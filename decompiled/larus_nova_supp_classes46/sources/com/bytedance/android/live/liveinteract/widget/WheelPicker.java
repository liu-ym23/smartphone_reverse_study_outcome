package com.bytedance.android.live.liveinteract.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class WheelPicker extends View implements Runnable {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean H0;
    public final int I;
    public final int J;
    public int K;
    public int L;
    public boolean L0;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public final int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public final Handler a;
    public final Paint b;
    public final Scroller c;
    public VelocityTracker d;
    public final Rect e;
    public final Rect f;
    public final Rect g;
    public final Rect h;
    public final Camera i;
    public final Matrix j;
    public final Matrix k;
    public boolean k0;
    public List l;
    public String m;
    public int n;
    public int o;
    public int p;
    public boolean p0;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public interface a {
    }

    public interface b {
    }

    public final void f() {
        boolean r0 = false;
        this.q = 0;
        this.r = 0;
        if (this.T == false) goto L5;
        this.q = (int) this.b.measureText(String.valueOf(ListProtector.get(this.l, 0)));
    L19:
        Paint.FontMetrics r1 = this.b.getFontMetrics();
        this.r = (int) (r1.bottom - r1.top);
        return;
    L5:
        int r2 = this.P;
        if (r2 >= 0) goto L8;
    L10:
        if (r0 == false) goto L13;
        this.q = (int) this.b.measureText(String.valueOf(ListProtector.get(this.l, this.P)));
        goto L19
    L13:
        if (TextUtils.isEmpty(this.m) == true) goto L15;
        this.q = (int) this.b.measureText(this.m);
        goto L19
    L15:
        Iterator r3 = this.l.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        String r4 = String.valueOf(r3.next());
        int r5 = (int) this.b.measureText(r4);
        this.q = Math.max(this.q, r5);
        goto L17
    L8:
        if (r2 >= this.l.size()) goto L10;
        r0 = true;
        goto L10
    }

    public void setOnItemSelectedListener(a r1) {
    }

    public void setOnWheelChangeListener(b r1) {
    }

    public final void a() {
        List r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() != 0) goto L8;
        return;
    L8:
        if (this.c.isFinished() == false) goto L19;
        if (this.L0 == true) goto L19;
        int r1 = this.B;
        if (r1 != 0) goto L14;
        return;
    L14:
        int r2 = (((-this.O) / r1) + this.E) % this.l.size();
        if (r2 >= 0) goto L17;
        r2 = r2 + this.l.size();
    L17:
        this.F = r2;
    L19:
        if (this.c.computeScrollOffset() == false) goto L23;
        this.O = this.c.getCurrY();
        postInvalidate();
        this.a.postDelayed(this, 16);
        return;
    }

    public final void b() {
        if (this.V == false) goto L5;
    L7:
        Rect r0 = this.h;
        Rect r1 = this.e;
        int r2 = r1.left;
        int r3 = this.L;
        int r4 = this.C;
        r0.set(r2, r3 - r4, r1.right, r3 + r4);
        return;
    L5:
        if (this.t != (-1)) goto L7;
    }

    public final void c() {
        int r0 = this.A;
        if (r0 != 1) goto L5;
        this.M = this.e.left;
    L9:
        this.N = (int) (this.L - ((this.b.ascent() + this.b.descent()) / 2.0f));
        return;
    L5:
        if (r0 == 2) goto L7;
        this.M = this.K;
        goto L9
    L7:
        this.M = this.e.right;
        goto L9
    }

    public final void d() {
        int r0 = this.E;
        int r1 = this.B;
        int r2 = r0 * r1;
        if (this.k0 == false) goto L5;
        int r3 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
    L6:
        this.G = r3;
        if (this.k0 == false) goto L9;
        r2 = Integer.MAX_VALUE;
    L9:
        this.H = r2;
        return;
    L5:
        r3 = ((-r1) * (this.l.size() - 1)) + r2;
        goto L6
    }

    public final void e() {
        if (this.U == true) goto L5;
        return;
    L5:
        int r0 = this.w / 2;
        int r1 = this.L;
        int r2 = this.C;
        int r3 = r1 + r2;
        int r4 = r1 - r2;
        Rect r5 = this.f;
        Rect r6 = this.e;
        r5.set(r6.left, r3 - r0, r6.right, r3 + r0);
        Rect r7 = this.g;
        Rect r8 = this.e;
        r7.set(r8.left, r4 - r0, r8.right, r4 + r0);
    }

    public Typeface getTypeface() {
        Paint r0 = this.b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTypeface();
    }

    public final void h() {
        int r0 = this.A;
        if (r0 != 1) goto L5;
        this.b.setTextAlign(Paint.Align.LEFT);
        return;
    L5:
        if (r0 == 2) goto L7;
        this.b.setTextAlign(Paint.Align.CENTER);
        return;
    L7:
        this.b.setTextAlign(Paint.Align.RIGHT);
    }

    public final void i() {
        int r0 = this.n;
        if (r0 < 2) goto L10;
        if ((r0 % 2) != 0) goto L7;
        this.n = r0 + 1;
    L7:
        int r1 = this.n + 2;
        this.o = r1;
        this.p = r1 / 2;
        return;
    L10:
        throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
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

    static {
    }

    public int getCurrentItemPosition() {
        return this.F;
    }

    public int getCurtainColor() {
        return this.y;
    }

    public List getData() {
        return this.l;
    }

    public int getIndicatorColor() {
        return this.x;
    }

    public int getIndicatorSize() {
        return this.w;
    }

    public int getItemAlign() {
        return this.A;
    }

    public int getItemSpace() {
        return this.z;
    }

    public int getItemTextColor() {
        return this.s;
    }

    public int getItemTextSize() {
        return this.u;
    }

    public String getMaximumWidthText() {
        return this.m;
    }

    public int getMaximumWidthTextPosition() {
        return this.P;
    }

    public int getSelectedItemPosition() {
        return this.E;
    }

    public int getSelectedItemTextColor() {
        return this.t;
    }

    public int getVisibleItemCount() {
        return this.n;
    }

    public WheelPicker(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r23) {
        int r2 = (-this.O) / this.B;
        int r3 = this.p;
        int r4 = r2 - r3;
        int r5 = this.E + r4;
        int r6 = -r3;
    L4:
        if (r5 >= ((this.E + r4) + this.o)) goto L70;
        if (this.k0 == false) goto L11;
        int r7 = r5 % this.l.size();
        if (r7 >= 0) goto L10;
        r7 = r7 + this.l.size();
    L10:
        String r8 = String.valueOf(ListProtector.get(this.l, r7));
    L19:
        this.b.setColor(this.s);
        this.b.setTextSize(this.u);
        this.b.setStyle(Paint.Style.FILL);
        int r9 = this.N;
        int r10 = this.B;
        int r11 = ((r6 * r10) + r9) + (this.O % r10);
        if (this.p0 == false) goto L41;
        int r12 = r9 - Math.abs(r9 - r11);
        int r13 = this.e.top;
        int r15 = this.N;
        float r14 = ((r12 - r13) * 1.0f) / (r15 - r13);
        if (r11 <= r15) goto L24;
        int r16 = 1;
    L27:
        float r17 = 90.0f;
        float r18 = ((-(1.0f - r14)) * 90.0f) * r16;
        if (r18 >= (-90.0f)) goto L31;
        r18 = -90.0f;
    L31:
        if (r18 > 90.0f) goto L34;
        r17 = r18;
    L34:
        double r19 = (int) r17;
        int r20 = (int) (((double) this.D) * Math.sin(Math.toRadians(r19)));
        int r110 = this.K;
        int r111 = this.A;
        if (r111 == 1) goto L39;
        if (r111 != 2) goto L40;
        r110 = this.e.right;
    L40:
        int r21 = this.L - r20;
        this.i.save();
        this.i.rotateX(r17);
        this.i.getMatrix(this.j);
        this.i.restore();
        float r112 = -r110;
        float r113 = -r21;
        this.j.preTranslate(r112, r113);
        float r114 = r110;
        float r22 = r21;
        this.j.postTranslate(r114, r22);
        this.i.save();
        this.i.translate(0.0f, 0.0f, (int) (((double) this.D) - (Math.cos(Math.toRadians(r19)) * ((double) this.D))));
        this.i.getMatrix(this.k);
        this.i.restore();
        this.k.preTranslate(r112, r113);
        this.k.postTranslate(r114, r22);
        this.j.postConcat(this.k);
    L43:
        if (this.W == false) goto L49;
        int r24 = this.N;
        int r25 = (int) ((((r24 - Math.abs(r24 - r11)) * 1.0f) / this.N) * 255.0f);
        if (r25 >= 0) goto L47;
        r25 = 0;
    L47:
        this.b.setAlpha(r25);
    L49:
        if (this.p0 == false) goto L52;
        r11 = this.N - r20;
    L52:
        if (this.t == (-1)) goto L64;
        r23.save();
        if (this.p0 == false) goto L57;
        r23.concat(this.j);
    L57:
        if (r11 >= this.h.bottom) goto L59;
        RectF r26 = new RectF(this.h);
        r26.bottom = r26.top;
        r26.top = 0.0f;
        r23.clipRect(r26);
    L60:
        r23.clipRect(this.h, Region.Op.DIFFERENCE);
        float r27 = r11;
        String r28 = r8;
        r23.drawText(r28, this.M, r27, this.b);
        r23.restore();
        this.b.setColor(this.t);
        this.b.setTextSize(this.v);
        r23.save();
        if (this.p0 == false) goto L63;
        r23.concat(this.j);
    L63:
        r23.clipRect(this.h);
        r23.drawText(r28, this.M, (int) (r27 + (((this.b.descent() - this.b.ascent()) / 2.0f) - (this.r / 2))), this.b);
        r23.restore();
    L68:
        r5 = r5 + 1;
        r6 = r6 + 1;
        r4 = r4;
        goto L4
    L59:
        RectF r29 = new RectF(this.h);
        r29.top = r29.bottom;
        r29.bottom = getBottom();
        r23.clipRect(r29);
        goto L60
    L64:
        String r30 = r8;
        r23.save();
        r23.clipRect(this.e);
        if (this.p0 == false) goto L67;
        r23.concat(this.j);
    L67:
        r23.drawText(r30, this.M, r11, this.b);
        r23.restore();
        goto L68
    L39:
        r110 = this.e.left;
        goto L40
    L24:
        if (r11 >= r15) goto L26;
        r16 = -1;
        goto L27
    L26:
        r16 = 0;
        goto L27
    L41:
        r20 = 0;
        goto L43
    L11:
        if (r5 >= 0) goto L13;
    L15:
        boolean r31 = false;
    L16:
        if (r31 == false) goto L18;
        r8 = String.valueOf(ListProtector.get(this.l, r5));
        goto L19
    L18:
        r8 = "";
        goto L19
    L13:
        if (r5 >= this.l.size()) goto L15;
        r31 = true;
        goto L16
    L70:
        if (this.V == false) goto L73;
        this.b.setColor(this.y);
        this.b.setStyle(Paint.Style.FILL);
        r23.drawRect(this.h, this.b);
    L73:
        if (this.U == false) goto L79;
        this.b.setColor(this.x);
        this.b.setStyle(Paint.Style.FILL);
        r23.drawRect(this.f, this.b);
        r23.drawRect(this.g, this.b);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r14) {
        int r0 = r14.getAction();
        if (r0 == 0) goto L64;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L12;
    L74:
        return true;
    L12:
        if (getParent() == null) goto L14;
        getParent().requestDisallowInterceptTouchEvent(false);
    L14:
        VelocityTracker r15 = this.d;
        if (r15 == null) goto L74;
        r15.recycle();
        this.d = null;
        goto L74
    L18:
        if (Math.abs(this.R - r14.getY()) >= this.S) goto L20;
        this.H0 = true;
        goto L74
    L20:
        this.H0 = false;
        this.d.addMovement(r14);
        float r1 = r14.getY() - this.Q;
        if (Math.abs(r1) < 1.0f) goto L74;
        this.O = (int) (this.O + r1);
        this.Q = (int) r14.getY();
        invalidate();
        goto L74
    L25:
        if (getParent() == null) goto L28;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        if (this.H0 == true) goto L30;
    L32:
        this.d.addMovement(r14);
        this.d.computeCurrentVelocity(1000, this.J);
        this.L0 = false;
        int r8 = (int) this.d.getYVelocity();
        if (Math.abs(r8) <= this.I) goto L43;
        this.c.fling(0, this.O, 0, r8, 0, 0, this.G, this.H);
        Scroller r16 = this.c;
        int r2 = r16.getFinalY();
        int r3 = this.c.getFinalY() % this.B;
        if (Math.abs(r3) > this.C) goto L37;
        int r4 = -r3;
    L42:
        r16.setFinalY(r2 + r4);
    L53:
        if (this.k0 == true) goto L60;
        int r17 = this.c.getFinalY();
        int r5 = this.H;
        if (r17 <= r5) goto L57;
        this.c.setFinalY(r5);
        goto L60
    L57:
        int r18 = this.c.getFinalY();
        int r6 = this.G;
        if (r18 >= r6) goto L60;
        this.c.setFinalY(r6);
    L60:
        this.a.post(this);
        VelocityTracker r19 = this.d;
        if (r19 == null) goto L74;
        r19.recycle();
        this.d = null;
        goto L74
    L37:
        if (this.O >= 0) goto L39;
        int r7 = -this.B;
    L40:
        r4 = r7 - r3;
        goto L42
    L39:
        r7 = this.B;
        goto L40
    L43:
        Scroller r110 = this.c;
        int r9 = this.O;
        int r10 = r9 % this.B;
        if (Math.abs(r10) > this.C) goto L46;
        int r11 = -r10;
    L51:
        r110.startScroll(0, r9, 0, r11);
        goto L53
    L46:
        if (this.O >= 0) goto L48;
        int r12 = -this.B;
    L49:
        r11 = r12 - r10;
        goto L51
    L48:
        r12 = this.B;
        goto L49
    L30:
        if (this.L0 == true) goto L32;
    L64:
        if (getParent() == null) goto L66;
        getParent().requestDisallowInterceptTouchEvent(true);
    L66:
        VelocityTracker r13 = this.d;
        if (r13 != null) goto L69;
        this.d = VelocityTracker.obtain();
    L70:
        this.d.addMovement(r14);
        if (this.c.isFinished() == true) goto L73;
        this.c.abortAnimation();
        this.L0 = true;
    L73:
        int r111 = (int) r14.getY();
        this.Q = r111;
        this.R = r111;
        goto L74
    L69:
        r13.clear();
        goto L70
    }

    public void setAtmospheric(boolean r1) {
        this.W = r1;
        invalidate();
    }

    public void setCurtain(boolean r1) {
        this.V = r1;
        b();
        invalidate();
    }

    public void setCurtainColor(int r1) {
        this.y = r1;
        invalidate();
    }

    public void setCurved(boolean r1) {
        this.p0 = r1;
        requestLayout();
        invalidate();
    }

    public void setCyclic(boolean r1) {
        this.k0 = r1;
        d();
        invalidate();
    }

    public void setData(List r3) {
        if (r3 == null) goto L13;
        this.l = r3;
        if (this.E <= (r3.size() - 1)) goto L6;
    L9:
        int r4 = r3.size() - 1;
        this.F = r4;
        this.E = r4;
    L10:
        this.O = 0;
        f();
        d();
        requestLayout();
        invalidate();
        return;
    L6:
        if (this.F > (r3.size() - 1)) goto L9;
        this.E = this.F;
        goto L10
    L13:
        throw new NullPointerException("WheelPicker's data can not be null!");
    }

    public void setIndicator(boolean r1) {
        this.U = r1;
        e();
        invalidate();
    }

    public void setIndicatorColor(int r1) {
        this.x = r1;
        invalidate();
    }

    public void setIndicatorSize(int r1) {
        this.w = r1;
        e();
        invalidate();
    }

    public void setItemAlign(int r1) {
        this.A = r1;
        h();
        c();
        invalidate();
    }

    public void setItemSpace(int r1) {
        this.z = r1;
        requestLayout();
        invalidate();
    }

    public void setItemTextColor(int r1) {
        this.s = r1;
        invalidate();
    }

    public void setItemTextSize(int r2) {
        this.u = r2;
        this.b.setTextSize(r2);
        f();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthText(String r2) {
        if (r2 == null) goto L6;
        this.m = r2;
        f();
        requestLayout();
        invalidate();
        return;
    L6:
        throw new NullPointerException("Maximum width text can not be null!");
    }

    public void setMaximumWidthTextPosition(int r4) {
        if (r4 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L11;
        this.P = r4;
        f();
        requestLayout();
        invalidate();
        return;
    L11:
        throw new ArrayIndexOutOfBoundsException("Maximum width text Position must in [0, " + this.l.size() + "), but current is " + r4);
    L4:
        if (r4 >= this.l.size()) goto L6;
        r0 = true;
        goto L7
    }

    public void setSameWidth(boolean r1) {
        this.T = r1;
        f();
        requestLayout();
        invalidate();
    }

    public void setSelectItemTextSize(int r1) {
        this.v = r1;
    }

    public void setSelectedItemPosition(int r2) {
        g(r2, true);
    }

    public void setSelectedItemTextColor(int r1) {
        this.t = r1;
        b();
        invalidate();
    }

    public void setTypeface(Typeface r2) {
        Paint r0 = this.b;
        if (r0 == null) goto L5;
        r0.setTypeface(r2);
    L5:
        f();
        requestLayout();
        invalidate();
    }

    public void setVisibleItemCount(int r1) {
        this.n = r1;
        i();
        requestLayout();
    }

    public WheelPicker(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.a = new Handler();
        this.I = 50;
        this.J = 8000;
        this.S = 8;
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130974813, 2130974814, 2130975110, 2130975111, 2130975112, 2130975113, 2130975114, 2130975115, 2130975116, 2130975117, 2130975118, 2130975119, 2130975120, 2130975121, 2130975122, 2130975123, 2130975124, 2130975125, 2130975126, 2130975127, 2130975128});
        int r3 = r8.getResourceId(7, 0);
        if (r3 != 0) goto L5;
        this.l = new ArrayList();
    L6:
        this.n = r8.getInt(20, 7);
        this.E = r8.getInt(17, 0);
        this.T = r8.getBoolean(16, false);
        this.P = r8.getInt(15, -1);
        this.m = r8.getString(14);
        this.t = r8.getColor(18, -1);
        this.s = r8.getColor(12, -7829368);
        this.k0 = r8.getBoolean(6, false);
        this.U = r8.getBoolean(8, false);
        this.x = r8.getColor(9, -2105377);
        this.V = r8.getBoolean(3, false);
        this.y = r8.getColor(4, -1996488705);
        this.W = r8.getBoolean(2, false);
        this.p0 = r8.getBoolean(5, false);
        this.A = r8.getInt(1, 0);
        String r0 = r8.getString(0);
        r8.recycle();
        i();
        Paint r9 = new Paint(69);
        this.b = r9;
        r9.setTextSize(this.u);
        if (r0 == null) goto L9;
        setTypeface(Typeface.createFromAsset(r6.getAssets(), r0));
    L9:
        h();
        f();
        this.c = new Scroller(getContext());
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        this.I = r10.getScaledMinimumFlingVelocity();
        this.J = r10.getScaledMaximumFlingVelocity();
        this.S = r10.getScaledTouchSlop();
        this.e = new Rect();
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Camera();
        this.j = new Matrix();
        this.k = new Matrix();
        return;
    L5:
        this.l = Arrays.asList(getResources().getStringArray(r3));
        goto L6
    }

    public final void g(int r4, boolean r5) {
        if (r5 == false) goto L18;
        if (this.c.isFinished() == false) goto L18;
        int r6 = getData().size();
        int r7 = r4 - this.F;
        if (r7 != 0) goto L10;
        return;
    L10:
        if (this.k0 == true) goto L12;
    L16:
        Scroller r8 = this.c;
        r8.startScroll(0, r8.getCurrY(), 0, (-r7) * this.B);
        this.a.post(this);
        return;
    L12:
        if (Math.abs(r7) <= (r6 / 2)) goto L16;
        if (r7 <= 0) goto L15;
        r6 = -r6;
    L15:
        r7 = r7 + r6;
    L18:
        if (this.c.isFinished() == true) goto L20;
        this.c.abortAnimation();
    L20:
        int r9 = Math.max(Math.min(r4, this.l.size() - 1), 0);
        this.E = r9;
        this.F = r9;
        this.O = 0;
        d();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getMode(r8);
        int r1 = View.MeasureSpec.getMode(r9);
        int r10 = View.MeasureSpec.getSize(r8);
        int r11 = View.MeasureSpec.getSize(r9);
        int r2 = this.q;
        int r3 = this.r;
        int r4 = this.n;
        int r5 = (r3 * r4) + (this.z * (r4 - 1));
        if (this.p0 == false) goto L5;
        r5 = (int) (((double) (r5 * 2)) / 3.141592653589793d);
    L5:
        int r6 = r2 + (getPaddingLeft() + getPaddingRight());
        int r7 = r5 + (getPaddingTop() + getPaddingBottom());
        if (r0 == 1073741824) goto L11;
        if (r0 != Integer.MIN_VALUE) goto L10;
        r10 = Math.min(r6, r10);
        goto L11
    L10:
        r10 = r6;
    L11:
        if (r1 == 1073741824) goto L16;
        if (r1 != Integer.MIN_VALUE) goto L15;
        r11 = Math.min(r7, r11);
        goto L16
    L15:
        r11 = r7;
    L16:
        setMeasuredDimension(r10, r11);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        this.e.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.K = this.e.centerX();
        this.L = this.e.centerY();
        c();
        this.D = this.e.height() / 2;
        int r7 = this.e.height() / this.n;
        this.B = r7;
        this.C = r7 / 2;
        d();
        e();
        b();
    }
}
