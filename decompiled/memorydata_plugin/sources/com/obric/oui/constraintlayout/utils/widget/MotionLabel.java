package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.view.GravityCompat;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.motion.widget.a;
import com.obric.oui.constraintlayout.motion.widget.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class MotionLabel extends View implements c {
    private int A;
    private int B;
    private int C;
    private int D;
    private String E;
    private Layout F;
    private int G;
    private int H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f13733J;
    private float K;
    private float L;
    private Drawable M;
    private Bitmap N;
    private BitmapShader O;
    private Matrix P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private int U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextPaint f13734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Path f13735b;
    ViewOutlineProvider c;
    RectF d;
    boolean e;
    Matrix f;
    Paint g;
    Rect h;
    Paint i;
    float j;
    float k;
    float l;
    float m;
    float n;
    private int o;
    private int p;
    private boolean q;
    private float r;
    private float s;
    private float t;
    private float u;
    private int v;
    private int w;
    private float x;
    private String y;
    private Rect z;

    public MotionLabel(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        super(r7);
        this.f13734a = new TextPaint();
        this.f13735b = new Path();
        this.o = 65535;
        this.p = 65535;
        this.q = false;
        this.r = 0.0f;
        this.s = Float.NaN;
        this.t = 48.0f;
        this.u = Float.NaN;
        this.x = 0.0f;
        this.y = "Hello World";
        this.e = true;
        this.z = new Rect();
        this.A = 1;
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.G = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.H = 0;
        this.I = false;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = 0.0f;
        this.T = 0.0f;
        this.g = new Paint();
        this.U = 0;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        a(r7, null);
    }

    public MotionLabel(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r8, r9);
        this.f13734a = new TextPaint();
        this.f13735b = new Path();
        this.o = 65535;
        this.p = 65535;
        this.q = false;
        this.r = 0.0f;
        this.s = Float.NaN;
        this.t = 48.0f;
        this.u = Float.NaN;
        this.x = 0.0f;
        this.y = "Hello World";
        this.e = true;
        this.z = new Rect();
        this.A = 1;
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.G = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.H = 0;
        this.I = false;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = 0.0f;
        this.T = 0.0f;
        this.g = new Paint();
        this.U = 0;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        a(r8, r9);
    }

    public MotionLabel(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r8, r9, r7);
        this.f13734a = new TextPaint();
        this.f13735b = new Path();
        this.o = 65535;
        this.p = 65535;
        this.q = false;
        this.r = 0.0f;
        this.s = Float.NaN;
        this.t = 48.0f;
        this.u = Float.NaN;
        this.x = 0.0f;
        this.y = "Hello World";
        this.e = true;
        this.z = new Rect();
        this.A = 1;
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.G = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.H = 0;
        this.I = false;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = 0.0f;
        this.T = 0.0f;
        this.g = new Paint();
        this.U = 0;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        a(r8, r9);
    }

    static /* synthetic */ float a(MotionLabel r0) {
        return r0.r;
    }

    private void a(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        setUpTheme(r10);
        if (r11 == null) goto L78;
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r11, R.styleable.MotionLabel);
        int r13 = r12.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r13) goto L77;
        int r2 = r12.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_text, "styleable", "MotionLabel_android_text")) goto L10;
        setText(r12.getText(r2));
    L76:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_fontFamily, "styleable", "MotionLabel_android_fontFamily")) goto L13;
        this.E = r12.getString(r2);
        goto L76
    L13:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_scaleFromTextSize, "styleable", "MotionLabel_scaleFromTextSize")) goto L16;
        this.u = r12.getDimensionPixelSize(r2, (int) this.u);
        goto L76
    L16:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_textSize, "styleable", "MotionLabel_android_textSize")) goto L19;
        this.t = r12.getDimensionPixelSize(r2, (int) this.t);
        goto L76
    L19:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_textStyle, "styleable", "MotionLabel_android_textStyle")) goto L22;
        this.v = r12.getInt(r2, this.v);
        goto L76
    L22:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_typeface, "styleable", "MotionLabel_android_typeface")) goto L25;
        this.w = r12.getInt(r2, this.w);
        goto L76
    L25:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_textColor, "styleable", "MotionLabel_android_textColor")) goto L28;
        this.o = r12.getColor(r2, this.o);
        goto L76
    L28:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_borderRound, "styleable", "MotionLabel_borderRound")) goto L31;
        float r3 = r12.getDimension(r2, this.s);
        this.s = r3;
        setRound(r3);
        goto L76
    L31:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_borderRoundPercent, "styleable", "MotionLabel_borderRoundPercent")) goto L34;
        float r4 = r12.getFloat(r2, this.r);
        this.r = r4;
        setRoundPercent(r4);
        goto L76
    L34:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_gravity, "styleable", "MotionLabel_android_gravity")) goto L37;
        setGravity(r12.getInt(r2, -1));
        goto L76
    L37:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_autoSizeTextType, "styleable", "MotionLabel_android_autoSizeTextType")) goto L40;
        this.H = r12.getInt(r2, 0);
        goto L76
    L40:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textOutlineColor, "styleable", "MotionLabel_textOutlineColor")) goto L44;
        this.p = r12.getInt(r2, this.p);
    L42:
        this.q = true;
        goto L76
    L44:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textOutlineThickness, "styleable", "MotionLabel_textOutlineThickness")) goto L47;
        this.x = r12.getDimension(r2, this.x);
        goto L42
    L47:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackground, "styleable", "MotionLabel_textBackground")) goto L50;
        this.M = r12.getDrawable(r2);
        goto L42
    L50:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundPanX, "styleable", "MotionLabel_textBackgroundPanX")) goto L53;
        this.k = r12.getFloat(r2, this.k);
        goto L76
    L53:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundPanY, "styleable", "MotionLabel_textBackgroundPanY")) goto L56;
        this.l = r12.getFloat(r2, this.l);
        goto L76
    L56:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textPanX, "styleable", "MotionLabel_textPanX")) goto L59;
        this.S = r12.getFloat(r2, this.S);
        goto L76
    L59:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textPanY, "styleable", "MotionLabel_textPanY")) goto L62;
        this.T = r12.getFloat(r2, this.T);
        goto L76
    L62:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundRotate, "styleable", "MotionLabel_textBackgroundRotate")) goto L65;
        this.n = r12.getFloat(r2, this.n);
        goto L76
    L65:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundZoom, "styleable", "MotionLabel_textBackgroundZoom")) goto L68;
        this.m = r12.getFloat(r2, this.m);
        goto L76
    L68:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textureHeight, "styleable", "MotionLabel_textureHeight")) goto L71;
        this.Q = r12.getDimension(r2, this.Q);
        goto L76
    L71:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textureWidth, "styleable", "MotionLabel_textureWidth")) goto L74;
        this.R = r12.getDimension(r2, this.R);
        goto L76
    L74:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textureEffect, "styleable", "MotionLabel_textureEffect")) goto L76;
        this.U = r12.getInt(r2, this.U);
        goto L76
    L77:
        r12.recycle();
    L78:
        b();
        a();
    }

    private void a(String r5, int r6, int r7) {
        if (r5 == null) goto L7;
        Typeface r8 = Typeface.create(r5, r7);
        if (r8 == null) goto L8;
        setTypeface(r8);
        return;
    L8:
        boolean r1 = true;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L12;
        r8 = Typeface.SERIF;
    L17:
        float r9 = 0.0f;
        if (r7 <= 0) goto L34;
        if (r8 != null) goto L21;
        Typeface r10 = Typeface.defaultFromStyle(r7);
    L22:
        setTypeface(r10);
        if (r10 == null) goto L25;
        int r11 = r10.getStyle();
    L26:
        int r12 = (~r11) & r7;
        TextPaint r13 = this.f13734a;
        if ((r12 & 1) != 0) goto L30;
        r1 = false;
    L30:
        r13.setFakeBoldText(r1);
        TextPaint r4 = this.f13734a;
        if ((r12 & 2) == 0) goto L33;
        r9 = -0.25f;
    L33:
        r4.setTextSkewX(r9);
        return;
    L25:
        r11 = 0;
        goto L26
    L21:
        r10 = Typeface.create(r8, r7);
        goto L22
    L34:
        this.f13734a.setFakeBoldText(false);
        this.f13734a.setTextSkewX(0.0f);
        setTypeface(r8);
        return;
    L12:
        if (r6 != 3) goto L17;
        r8 = Typeface.MONOSPACE;
        goto L17
    L16:
        r8 = Typeface.SANS_SERIF;
        goto L17
    L7:
        r8 = null;
        goto L8
    }

    static /* synthetic */ float b(MotionLabel r0) {
        return r0.s;
    }

    private void b() {
        if (this.M == null) goto L28;
        this.P = new Matrix();
        int r0 = this.M.getIntrinsicWidth();
        int r1 = this.M.getIntrinsicHeight();
        int r2 = 128;
        if (r0 > 0) goto L12;
        r0 = getWidth();
        if (r0 != 0) goto L12;
        if (Float.isNaN(this.R) == false) goto L11;
        r0 = 128;
        goto L12
    L11:
        r0 = (int) this.R;
    L12:
        if (r1 > 0) goto L21;
        r1 = getHeight();
        if (r1 != 0) goto L21;
        if (Float.isNaN(this.Q) == true) goto L19;
        r2 = (int) this.Q;
    L19:
        r1 = r2;
    L21:
        if (this.U == 0) goto L23;
        r0 = r0 / 2;
        r1 = r1 / 2;
    L23:
        this.N = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(this.N);
        this.M.setBounds(0, 0, r3.getWidth(), r3.getHeight());
        this.M.setFilterBitmap(true);
        this.M.draw(r3);
        if (this.U == 0) goto L26;
        this.N = a(this.N, 4);
    L26:
        this.O = new BitmapShader(this.N, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        return;
    }

    private void b(float r2, float r3, float r4, float r5) {
        if (this.P != null) goto L5;
        return;
    L5:
        this.K = r4 - r2;
        this.L = r5 - r3;
        c();
    }

    private void c() {
        float r1 = 0.0f;
        if (Float.isNaN(this.k) == false) goto L5;
        float r0 = 0.0f;
    L7:
        if (Float.isNaN(this.l) == false) goto L9;
        float r2 = 0.0f;
    L11:
        if (Float.isNaN(this.m) == false) goto L13;
        float r3 = 1.0f;
    L15:
        if (Float.isNaN(this.n) == true) goto L18;
        r1 = this.n;
    L18:
        this.P.reset();
        float r4 = this.N.getWidth();
        float r5 = this.N.getHeight();
        if (Float.isNaN(this.R) == false) goto L21;
        float r6 = this.K;
    L23:
        if (Float.isNaN(this.Q) == false) goto L25;
        float r7 = this.L;
    L27:
        if ((r4 * r7) >= (r5 * r6)) goto L29;
        float r8 = r6 / r4;
    L30:
        float r9 = r3 * r8;
        this.P.postScale(r9, r9);
        float r10 = r4 * r9;
        float r11 = r6 - r10;
        float r12 = r9 * r5;
        float r13 = r7 - r12;
        if (Float.isNaN(this.Q) == true) goto L34;
        r13 = this.Q / 2.0f;
    L34:
        if (Float.isNaN(this.R) == true) goto L36;
        r11 = this.R / 2.0f;
    L36:
        float r14 = (((r2 * r13) + r7) - r12) * 0.5f;
        this.P.postTranslate((((r0 * r11) + r6) - r10) * 0.5f, r14);
        this.P.postRotate(r1, r6 / 2.0f, r7 / 2.0f);
        this.O.setLocalMatrix(this.P);
        return;
    L29:
        r8 = r7 / r5;
        goto L30
    L25:
        r7 = this.Q;
        goto L27
    L21:
        r6 = this.R;
        goto L23
    L13:
        r3 = this.m;
        goto L15
    L9:
        r2 = this.l;
        goto L11
    L5:
        r0 = this.k;
        goto L7
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.u) == false) goto L5;
        float r0 = 1.0f;
    L6:
        TextPaint r2 = this.f13734a;
        String r3 = this.y;
        float r1 = r0 * r2.measureText(r3, 0, r3.length());
        if (Float.isNaN(this.K) == false) goto L9;
        float r4 = getMeasuredWidth();
    L11:
        return ((((r4 - getPaddingLeft()) - getPaddingRight()) - r1) * (this.S + 1.0f)) / 2.0f;
    L9:
        r4 = this.K;
        goto L11
    L5:
        r0 = this.t / this.u;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.u) == false) goto L5;
        float r0 = 1.0f;
    L6:
        Paint.FontMetrics r2 = this.f13734a.getFontMetrics();
        if (Float.isNaN(this.L) == false) goto L9;
        float r3 = getMeasuredHeight();
    L11:
        return (((((r3 - getPaddingTop()) - getPaddingBottom()) - ((r2.descent - r2.ascent) * r0)) * (1.0f - this.T)) / 2.0f) - (r0 * r2.ascent);
    L9:
        r3 = this.L;
        goto L11
    L5:
        r0 = this.t / this.u;
        goto L6
    }

    private void setUpTheme(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        TypedValue r0 = new TypedValue();
        r6.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"), r0, true);
        TextPaint r7 = this.f13734a;
        int r1 = r0.data;
        this.o = r1;
        r7.setColor(r1);
    }

    Bitmap a(Bitmap r5, int r6) {
        int r4 = r5.getWidth();
        int r7 = r4 / 2;
        int r0 = r5.getHeight() / 2;
        Bitmap r8 = Bitmap.createScaledBitmap(r5, r7, r0, true);
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        if (r7 < 32) goto L9;
        if (r0 < 32) goto L9;
        r7 = r7 / 2;
        r0 = r0 / 2;
        r8 = Bitmap.createScaledBitmap(r8, r7, r0, true);
        r2 = r2 + 1;
    L9:
        return r8;
    }

    void a() {
        this.A = getPaddingLeft();
        this.B = getPaddingRight();
        this.C = getPaddingTop();
        this.D = getPaddingBottom();
        a(this.E, this.w, this.v);
        this.f13734a.setColor(this.o);
        this.f13734a.setStrokeWidth(this.x);
        this.f13734a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f13734a.setFlags(128);
        setTextSize(this.t);
        this.f13734a.setAntiAlias(true);
    }

    void a(float r11) {
        if (this.q == false) goto L5;
    L7:
        this.f13735b.reset();
        String r3 = this.y;
        int r5 = r3.length();
        this.f13734a.getTextBounds(r3, 0, r5, this.z);
        this.f13734a.getTextPath(r3, 0, r5, 0.0f, 0.0f, this.f13735b);
        if (r11 == 1.0f) goto L10;
        Log.v("MotionLabel", a.b() + " scale " + r11);
        Matrix r0 = new Matrix();
        r0.postScale(r11, r11);
        this.f13735b.transform(r0);
    L10:
        this.z.right--;
        this.z.left++;
        this.z.bottom++;
        this.z.top--;
        RectF r12 = new RectF();
        r12.bottom = getHeight();
        r12.right = getWidth();
        this.e = false;
        return;
    L5:
        if (r11 != 1.0f) goto L7;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void a(float r9, float r10, float r11, float r12) {
        int r1 = (int) (r9 + 0.5f);
        this.f13733J = r9 - r1;
        int r2 = (int) (r11 + 0.5f);
        int r3 = r2 - r1;
        int r4 = (int) (r12 + 0.5f);
        int r0 = (int) (0.5f + r10);
        int r5 = r4 - r0;
        float r6 = r11 - r9;
        this.K = r6;
        float r7 = r12 - r10;
        this.L = r7;
        b(r9, r10, r11, r12);
        if (getMeasuredHeight() == r5) goto L5;
    L6:
        measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(r5, 1073741824));
    L7:
        super.layout(r1, r0, r2, r4);
        if (this.I == true) goto L10;
        return;
    L10:
        if (this.h != null) goto L12;
        this.i = new Paint();
        this.h = new Rect();
        this.i.set(this.f13734a);
        this.j = this.i.getTextSize();
    L12:
        this.K = r6;
        this.L = r7;
        Paint r13 = this.i;
        String r14 = this.y;
        r13.getTextBounds(r14, 0, r14.length(), this.h);
        int r15 = this.h.width();
        float r16 = this.h.height() * 1.3f;
        float r8 = (r6 - this.B) - this.A;
        float r17 = (r7 - this.D) - this.C;
        float r18 = r15;
        if ((r18 * r17) <= (r16 * r8)) goto L15;
        this.f13734a.setTextSize((this.j * r8) / r18);
    L17:
        if (this.q == true) goto L21;
        if (Float.isNaN(this.u) == false) goto L21;
        return;
    L21:
        if (Float.isNaN(this.u) == false) goto L23;
        float r19 = 1.0f;
    L24:
        a(r19);
        return;
    L23:
        r19 = this.t / this.u;
        goto L24
    L15:
        this.f13734a.setTextSize((this.j * r17) / r16);
        goto L17
    L5:
        if (getMeasuredWidth() == r3) goto L7;
        goto L6
    }

    public float getRound() {
        return this.s;
    }

    public float getRoundPercent() {
        return this.r;
    }

    public float getScaleFromTextSize() {
        return this.u;
    }

    public float getTextBackgroundPanX() {
        return this.k;
    }

    public float getTextBackgroundPanY() {
        return this.l;
    }

    public float getTextBackgroundRotate() {
        return this.n;
    }

    public float getTextBackgroundZoom() {
        return this.m;
    }

    public int getTextOutlineColor() {
        return this.p;
    }

    public float getTextPanX() {
        return this.S;
    }

    public float getTextPanY() {
        return this.T;
    }

    public float getTextureHeight() {
        return this.Q;
    }

    public float getTextureWidth() {
        return this.R;
    }

    public Typeface getTypeface() {
        return this.f13734a.getTypeface();
    }

    @Override // android.view.View
    public void layout(int r9, int r10, int r11, int r12) {
        super.layout(r9, r10, r11, r12);
        boolean r0 = Float.isNaN(this.u);
        if (r0 == false) goto L5;
        float r1 = 1.0f;
    L6:
        this.K = r11 - r9;
        this.L = r12 - r10;
        if (this.I == false) goto L22;
        if (this.h != null) goto L11;
        this.i = new Paint();
        this.h = new Rect();
        this.i.set(this.f13734a);
        this.j = this.i.getTextSize();
    L11:
        Paint r2 = this.i;
        String r3 = this.y;
        r2.getTextBounds(r3, 0, r3.length(), this.h);
        int r4 = this.h.width();
        int r5 = (int) (this.h.height() * 1.3f);
        float r6 = (this.K - this.B) - this.A;
        float r7 = (this.L - this.D) - this.C;
        if (r0 == false) goto L17;
        float r8 = r4;
        float r13 = r5;
        if ((r8 * r7) <= (r13 * r6)) goto L16;
        this.f13734a.setTextSize((this.j * r6) / r8);
        goto L22
    L16:
        this.f13734a.setTextSize((this.j * r7) / r13);
        goto L22
    L17:
        float r14 = r4;
        float r15 = r5;
        if ((r14 * r7) <= (r15 * r6)) goto L20;
        r1 = r6 / r14;
        goto L22
    L20:
        r1 = r7 / r15;
    L22:
        if (this.q == true) goto L24;
        if (r0 == false) goto L24;
        return;
    L24:
        b(r9, r10, r11, r12);
        a(r1);
        return;
    L5:
        r1 = this.t / this.u;
        goto L6
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        if (Float.isNaN(this.u) == false) goto L5;
        float r0 = 1.0f;
    L6:
        super.onDraw(r5);
        if (this.q == true) goto L13;
        if (r0 != 1.0f) goto L13;
        float r1 = this.A + getHorizontalOffset();
        r5.drawText(this.y, this.f13733J + r1, this.C + getVerticalOffset(), this.f13734a);
        return;
    L13:
        if (this.e == false) goto L16;
        a(r0);
    L16:
        if (this.f != null) goto L19;
        this.f = new Matrix();
    L19:
        if (this.q == false) goto L28;
        this.g.set(this.f13734a);
        this.f.reset();
        float r2 = this.A + getHorizontalOffset();
        float r3 = this.C + getVerticalOffset();
        this.f.postTranslate(r2, r3);
        this.f.preScale(r0, r0);
        this.f13735b.transform(this.f);
        if (this.O == null) goto L23;
        this.f13734a.setFilterBitmap(true);
        this.f13734a.setShader(this.O);
    L24:
        this.f13734a.setStyle(Paint.Style.FILL);
        this.f13734a.setStrokeWidth(this.x);
        r5.drawPath(this.f13735b, this.f13734a);
        if (this.O == null) goto L27;
        this.f13734a.setShader(null);
    L27:
        this.f13734a.setColor(this.p);
        this.f13734a.setStyle(Paint.Style.STROKE);
        this.f13734a.setStrokeWidth(this.x);
        r5.drawPath(this.f13735b, this.f13734a);
        this.f.reset();
        this.f.postTranslate(-r2, -r3);
        this.f13735b.transform(this.f);
        this.f13734a.set(this.g);
        return;
    L23:
        this.f13734a.setColor(this.o);
        goto L24
    L28:
        float r4 = this.A + getHorizontalOffset();
        float r6 = this.C + getVerticalOffset();
        this.f.reset();
        this.f.preTranslate(r4, r6);
        this.f13735b.transform(this.f);
        this.f13734a.setColor(this.o);
        this.f13734a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f13734a.setStrokeWidth(this.x);
        r5.drawPath(this.f13735b, this.f13734a);
        this.f.reset();
        this.f.preTranslate(-r4, -r6);
        this.f13735b.transform(this.f);
        return;
    L5:
        r0 = this.t / this.u;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getMode(r9);
        int r1 = View.MeasureSpec.getMode(r10);
        int r11 = View.MeasureSpec.getSize(r9);
        int r12 = View.MeasureSpec.getSize(r10);
        this.I = false;
        this.A = getPaddingLeft();
        this.B = getPaddingRight();
        this.C = getPaddingTop();
        this.D = getPaddingBottom();
        if (r0 != 1073741824) goto L9;
        if (r1 != 1073741824) goto L9;
        if (this.H == 0) goto L18;
        this.I = true;
    L18:
        setMeasuredDimension(r11, r12);
        return;
    L9:
        TextPaint r4 = this.f13734a;
        String r5 = this.y;
        r4.getTextBounds(r5, 0, r5.length(), this.z);
        if (r0 == 1073741824) goto L12;
        r11 = (int) (this.z.width() + 0.99999f);
    L12:
        r11 = r11 + (this.A + this.B);
        if (r1 == 1073741824) goto L18;
        int r2 = (int) (this.f13734a.getFontMetricsInt(null) + 0.99999f);
        if (r1 != Integer.MIN_VALUE) goto L17;
        r2 = Math.min(r12, r2);
    L17:
        r12 = (this.C + this.D) + r2;
        goto L18
    }

    public void setGravity(int r8) {
        if ((r8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0) goto L6;
        r8 = r8 | GravityCompat.START;
    L6:
        if ((r8 & 112) != 0) goto L8;
        r8 = r8 | 48;
    L8:
        int r1 = r8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r3 = this.G;
        int r4 = r3 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r8 == r3) goto L11;
        invalidate();
    L11:
        this.G = r8;
        int r2 = r8 & 112;
        if (r2 != 48) goto L14;
        this.T = -1.0f;
    L18:
        int r9 = r8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r9 != 3) goto L21;
    L27:
        this.S = -1.0f;
        return;
    L21:
        if (r9 == 5) goto L26;
        if (r9 == 8388611) goto L27;
        if (r9 == 8388613) goto L26;
        this.S = 0.0f;
        return;
    L26:
        this.S = 1.0f;
        return;
    L14:
        if (r2 == 80) goto L16;
        this.T = 0.0f;
        goto L18
    L16:
        this.T = 1.0f;
        goto L18
    }

    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.s = r5;
        float r6 = this.r;
        this.r = -1.0f;
        setRoundPercent(r6);
        return;
    L7:
        if (this.s == r5) goto L9;
        boolean r0 = true;
    L10:
        this.s = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r0 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f13735b != null) goto L16;
        this.f13735b = new Path();
    L16:
        if (this.d != null) goto L19;
        this.d = new RectF();
    L19:
        if (this.c != null) goto L21;
        ViewOutlineProvider r7 = new AnonymousClass2(this);
        this.c = r7;
        setOutlineProvider(r7);
    L21:
        setClipToOutline(true);
        this.d.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f13735b.reset();
        Path r8 = this.f13735b;
        RectF r1 = this.d;
        float r2 = this.s;
        r8.addRoundRect(r1, r2, r2, Path.Direction.CW);
        goto L23
    L9:
        r0 = false;
        goto L10
    }

    public void setRoundPercent(float r6) {
        if (this.r == r6) goto L5;
        boolean r0 = true;
    L6:
        this.r = r6;
        if (r6 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r0 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f13735b != null) goto L12;
        this.f13735b = new Path();
    L12:
        if (this.d != null) goto L15;
        this.d = new RectF();
    L15:
        if (this.c != null) goto L17;
        ViewOutlineProvider r7 = new AnonymousClass1(this);
        this.c = r7;
        setOutlineProvider(r7);
    L17:
        setClipToOutline(true);
        int r8 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r8, r1) * this.r) / 2.0f;
        this.d.set(0.0f, 0.0f, r8, r1);
        this.f13735b.reset();
        this.f13735b.addRoundRect(this.d, r2, r2, Path.Direction.CW);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public void setScaleFromTextSize(float r1) {
        this.u = r1;
    }

    public void setText(CharSequence r3) {
        this.y = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float r1) {
        this.k = r1;
        c();
        invalidate();
    }

    public void setTextBackgroundPanY(float r1) {
        this.l = r1;
        c();
        invalidate();
    }

    public void setTextBackgroundRotate(float r1) {
        this.n = r1;
        c();
        invalidate();
    }

    public void setTextBackgroundZoom(float r1) {
        this.m = r1;
        c();
        invalidate();
    }

    public void setTextFillColor(int r1) {
        this.o = r1;
        invalidate();
    }

    public void setTextOutlineColor(int r1) {
        this.p = r1;
        this.q = true;
        invalidate();
    }

    public void setTextOutlineThickness(float r2) {
        this.x = r2;
        this.q = true;
        if (Float.isNaN(r2) == false) goto L5;
        this.x = 1.0f;
        this.q = false;
    L5:
        invalidate();
    }

    public void setTextPanX(float r1) {
        this.S = r1;
        invalidate();
    }

    public void setTextPanY(float r1) {
        this.T = r1;
        invalidate();
    }

    public void setTextSize(float r3) {
        this.t = r3;
        TextPaint r0 = this.f13734a;
        if (Float.isNaN(this.u) == true) goto L6;
        r3 = this.u;
    L6:
        r0.setTextSize(r3);
        if (Float.isNaN(this.u) == false) goto L9;
        float r4 = 1.0f;
    L10:
        a(r4);
        requestLayout();
        invalidate();
        return;
    L9:
        r4 = this.t / this.u;
        goto L10
    }

    public void setTextureHeight(float r1) {
        this.Q = r1;
        c();
        invalidate();
    }

    public void setTextureWidth(float r1) {
        this.R = r1;
        c();
        invalidate();
    }

    public void setTypeface(Typeface r2) {
        if (Objects.equals(this.f13734a.getTypeface(), r2) == true) goto L8;
        this.f13734a.setTypeface(r2);
        if (this.F == null) goto L9;
        this.F = null;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }
}
