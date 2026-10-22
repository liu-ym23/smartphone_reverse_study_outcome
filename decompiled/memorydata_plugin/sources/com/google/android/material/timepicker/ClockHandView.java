package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueAnimator f4187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4188b;
    private float c;
    private float d;
    private boolean e;
    private int f;
    private final List<b> g;
    private final int h;
    private final float i;
    private final Paint j;
    private final RectF k;
    private final int l;
    private float m;
    private boolean n;
    private a o;
    private double p;
    private int q;

    public interface a {
        void a(float r1, boolean r2);
    }

    public interface b {
        void onRotate(float r1, boolean r2);
    }

    public ClockHandView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.materialClockStyle, "attr", "materialClockStyle"));
    }

    public ClockHandView(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r10, r11, r9);
        this.g = new ArrayList();
        Paint r0 = new Paint();
        this.j = r0;
        this.k = new RectF();
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.ClockHandView, r9, ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_TimePicker_Clock, "style", "Widget_MaterialComponents_TimePicker_Clock"));
        this.q = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ClockHandView_materialCircleRadius, "styleable", "ClockHandView_materialCircleRadius"), 0);
        this.h = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ClockHandView_selectorSize, "styleable", "ClockHandView_selectorSize"), 0);
        Resources r13 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        this.l = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_clock_hand_stroke_width, "dimen", "material_clock_hand_stroke_width"));
        this.i = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_clock_hand_center_dot_radius, "dimen", "material_clock_hand_center_dot_radius"));
        int r14 = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.ClockHandView_clockHandColor, "styleable", "ClockHandView_clockHandColor"), 0);
        r0.setAntiAlias(true);
        r0.setColor(r14);
        a(0.0f);
        this.f = ViewConfiguration.get(r10).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        r12.recycle();
    }

    private int a(float r3, float r4) {
        int r0 = getWidth() / 2;
        int r2 = ((int) Math.toDegrees(Math.atan2(r4 - (getHeight() / 2), r3 - r0))) + 90;
        if (r2 < 0) goto L5;
        return r2;
    L5:
        return r2 + 360;
    }

    private void a(Canvas r11) {
        int r0 = getHeight() / 2;
        int r1 = getWidth() / 2;
        float r8 = r1;
        float r2 = (this.q * ((float) Math.cos(this.p))) + r8;
        float r9 = r0;
        float r3 = (this.q * ((float) Math.sin(this.p))) + r9;
        this.j.setStrokeWidth(0.0f);
        r11.drawCircle(r2, r3, this.h, this.j);
        double r4 = Math.sin(this.p);
        double r5 = Math.cos(this.p);
        double r6 = this.q - this.h;
        this.j.setStrokeWidth(this.l);
        r11.drawLine(r8, r9, r1 + ((int) (r5 * r6)), r0 + ((int) (r6 * r4)), this.j);
        r11.drawCircle(r8, r9, this.i, this.j);
    }

    static /* synthetic */ void a(ClockHandView r0, float r1, boolean r2) {
        r0.b(r1, r2);
    }

    private boolean a(float r3, float r4, boolean r5, boolean r6, boolean r7) {
        float r8 = a(r3, r4);
        boolean r0 = false;
        if (a() == r8) goto L5;
        boolean r9 = true;
    L6:
        if (r6 == false) goto L9;
        if (r9 == false) goto L9;
        return true;
    L9:
        if (r9 == true) goto L13;
        if (r5 == true) goto L13;
        return false;
    L13:
        if (r7 == true) goto L15;
    L17:
        a(r8, r0);
        return true;
    L15:
        if (this.f4188b == false) goto L17;
        r0 = true;
        goto L17
    L5:
        r9 = false;
        goto L6
    }

    private Pair<Float, Float> b(float r4) {
        float r3 = a();
        if (Math.abs(r3 - r4) <= 180.0f) goto L15;
        if (r3 <= 180.0f) goto L10;
        if (r4 >= 180.0f) goto L10;
        r4 = r4 + 360.0f;
    L10:
        if (r3 >= 180.0f) goto L15;
        if (r4 <= 180.0f) goto L15;
        r3 = r3 + 360.0f;
    L15:
        return new Pair(Float.valueOf(r3), Float.valueOf(r4));
    }

    private void b(float r8, boolean r9) {
        float r10 = r8 % 360.0f;
        this.m = r10;
        this.p = Math.toRadians(r10 - 90.0f);
        int r0 = getHeight() / 2;
        float r1 = (getWidth() / 2) + (this.q * ((float) Math.cos(this.p)));
        float r2 = r0 + (this.q * ((float) Math.sin(this.p)));
        RectF r3 = this.k;
        int r4 = this.h;
        r3.set(r1 - r4, r2 - r4, r1 + r4, r2 + r4);
        Iterator<b> r5 = this.g.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin")).onRotate(r10, r9);
        goto L4
    L6:
        invalidate();
    }

    public float a() {
        return this.m;
    }

    public void a(float r2) {
        a(r2, false);
    }

    public void a(float r5, boolean r6) {
        ValueAnimator r0 = this.f4187a;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r6 == true) goto L9;
        b(r5, false);
        return;
    L9:
        Pair<Float, Float> r7 = b(r5);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{((Float) ZeusTransformUtils.preCheckCast(r7.first, Float.class, "com.obric.memorydata.plugin")).floatValue(), ((Float) ZeusTransformUtils.preCheckCast(r7.second, Float.class, "com.obric.memorydata.plugin")).floatValue()});
        this.f4187a = r8;
        r8.setDuration(200);
        this.f4187a.addUpdateListener(new AnonymousClass1(this));
        this.f4187a.addListener(new AnonymousClass2(this));
        this.f4187a.start();
    }

    public void a(int r1) {
        this.q = r1;
        invalidate();
    }

    public void a(a r3) {
        this.o = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.g.add(r4);
    }

    public void a(boolean r1) {
        this.f4188b = r1;
    }

    public RectF b() {
        return this.k;
    }

    public int c() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
        super.onDraw(r1);
        a(r1);
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        a(a());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r11) {
        int r0 = r11.getActionMasked();
        float r7 = r11.getX();
        float r12 = r11.getY();
        if (r0 == 0) goto L17;
        if (r0 != 1) goto L6;
    L8:
        int r2 = (int) (r7 - this.c);
        int r3 = (int) (r12 - this.d);
        if (((r2 * r2) + (r3 * r3)) <= this.f) goto L11;
        boolean r4 = true;
    L12:
        this.e = r4;
        boolean r5 = this.n;
        if (r0 != 1) goto L15;
        boolean r1 = true;
    L16:
        boolean r6 = false;
        boolean r8 = r5;
    L18:
        boolean r9 = a(r7, r12, r8, r6, r1) | this.n;
        this.n = r9;
        if (r9 == false) goto L24;
        if (r1 == false) goto L24;
        a r10 = this.o;
        if (r10 == null) goto L24;
        r10.a(a(r7, r12), this.e);
    L24:
        return true;
    L15:
        r1 = false;
        goto L16
    L11:
        r4 = false;
        goto L12
    L6:
        if (r0 == 2) goto L8;
        r1 = false;
        r8 = false;
        r6 = false;
        goto L18
    L17:
        this.c = r7;
        this.d = r12;
        this.e = true;
        this.n = false;
        r1 = false;
        r8 = false;
        r6 = true;
        goto L18
    }
}
