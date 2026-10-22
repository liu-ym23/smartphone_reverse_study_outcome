package com.obric.oui.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
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
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import com.obric.oui.constraintlayout.motion.widget.b;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.Objects;
import kr.e;
import ym.k;

/* JADX INFO: loaded from: classes3.dex */
public class MotionLabel extends View implements b {
    public float A;
    public float B;
    public Drawable C;
    public Matrix D;
    public Bitmap E;
    public BitmapShader F;
    public Matrix G;
    public float H;
    public float I;
    public float J;
    public float K;
    public final Paint L;
    public int M;
    public Rect N;
    public Paint O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f12952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f12953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12954c;
    public int d;
    public boolean e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewOutlineProvider f12955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f12956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f12962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f12964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12965r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12966t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12967u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f12968v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12969w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12970x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12971y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f12972z;

    public MotionLabel(Context r10) {
        super(r10);
        this.f12952a = new TextPaint();
        this.f12953b = new Path();
        this.f12954c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.f12957j = 48.0f;
        this.f12958k = Float.NaN;
        this.f12961n = 0.0f;
        this.f12962o = "Hello World";
        this.f12963p = true;
        this.f12964q = new Rect();
        this.f12965r = 1;
        this.s = 1;
        this.f12966t = 1;
        this.f12967u = 1;
        this.f12969w = 8388659;
        this.f12970x = 0;
        this.f12971y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        b(r10, null);
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.f12958k) == false) goto L5;
        float r5 = 1.0f;
    L6:
        String r10 = this.f12962o;
        float r11 = this.f12952a.measureText(r10, 0, r10.length()) * r5;
        if (Float.isNaN(this.A) == false) goto L9;
        float r12 = getMeasuredWidth();
    L11:
        return ((this.J + 1.0f) * (((r12 - getPaddingLeft()) - getPaddingRight()) - r11)) / 2.0f;
    L9:
        r12 = this.A;
        goto L11
    L5:
        r5 = this.f12957j / this.f12958k;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.f12958k) == false) goto L5;
        float r5 = 1.0f;
    L6:
        Paint.FontMetrics r10 = this.f12952a.getFontMetrics();
        if (Float.isNaN(this.B) == false) goto L9;
        float r11 = getMeasuredHeight();
    L10:
        float r12 = (r11 - getPaddingTop()) - getPaddingBottom();
        float r13 = r10.descent;
        float r14 = r10.ascent;
        return (((1.0f - this.K) * (r12 - ((r13 - r14) * r5))) / 2.0f) - (r5 * r14);
    L9:
        r11 = this.B;
        goto L10
    L5:
        r5 = this.f12957j / this.f12958k;
        goto L6
    }

    private void setUpTheme(Context r5) {
        TypedValue r10 = new TypedValue();
        r5.getTheme().resolveAttribute(R.attr.colorPrimary, r10, true);
        int r11 = r10.data;
        this.f12954c = r11;
        this.f12952a.setColor(r11);
    }

    public final void a(float r12) {
        if (this.e == false) goto L5;
    L7:
        this.f12953b.reset();
        String r5 = this.f12962o;
        int r10 = r5.length();
        TextPaint r11 = this.f12952a;
        Rect r13 = this.f12964q;
        r11.getTextBounds(r5, 0, r10, r13);
        this.f12952a.getTextPath(r5, 0, r10, 0.0f, 0.0f, this.f12953b);
        if (r12 == 1.0f) goto L10;
        Log.v("MotionLabel", k.e() + " scale " + r12);
        Matrix r14 = new Matrix();
        r14.postScale(r12, r12);
        this.f12953b.transform(r14);
    L10:
        r13.right--;
        r13.left++;
        r13.bottom++;
        r13.top--;
        RectF r15 = new RectF();
        r15.bottom = getHeight();
        r15.right = getWidth();
        this.f12963p = false;
        return;
    L5:
        if (r12 != 1.0f) goto L7;
    }

    public final void b(Context r10, AttributeSet r11) {
        setUpTheme(r10);
        boolean r12 = false;
        if (r11 == null) goto L78;
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R$styleable.MotionLabel);
        int r5 = r13.getIndexCount();
        int r14 = 0;
    L5:
        if (r14 >= r5) goto L76;
        int r15 = r13.getIndex(r14);
        if (r15 != R$styleable.MotionLabel_android_text) goto L10;
        setText(r13.getText(r15));
    L75:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R$styleable.MotionLabel_android_fontFamily) goto L13;
        this.f12968v = r13.getString(r15);
        goto L75
    L13:
        if (r15 != R$styleable.MotionLabel_scaleFromTextSize) goto L16;
        this.f12958k = r13.getDimensionPixelSize(r15, (int) this.f12958k);
        goto L75
    L16:
        if (r15 != R$styleable.MotionLabel_android_textSize) goto L19;
        this.f12957j = r13.getDimensionPixelSize(r15, (int) this.f12957j);
        goto L75
    L19:
        if (r15 != R$styleable.MotionLabel_android_textStyle) goto L22;
        this.f12959l = r13.getInt(r15, this.f12959l);
        goto L75
    L22:
        if (r15 != R$styleable.MotionLabel_android_typeface) goto L25;
        this.f12960m = r13.getInt(r15, this.f12960m);
        goto L75
    L25:
        if (r15 != R$styleable.MotionLabel_android_textColor) goto L28;
        this.f12954c = r13.getColor(r15, this.f12954c);
        goto L75
    L28:
        if (r15 != R$styleable.MotionLabel_borderRound) goto L31;
        float r16 = r13.getDimension(r15, this.g);
        this.g = r16;
        setRound(r16);
        goto L75
    L31:
        if (r15 != R$styleable.MotionLabel_borderRoundPercent) goto L34;
        float r17 = r13.getFloat(r15, this.f);
        this.f = r17;
        setRoundPercent(r17);
        goto L75
    L34:
        if (r15 != R$styleable.MotionLabel_android_gravity) goto L37;
        setGravity(r13.getInt(r15, -1));
        goto L75
    L37:
        if (r15 != R$styleable.MotionLabel_android_autoSizeTextType) goto L40;
        this.f12970x = r13.getInt(r15, 0);
        goto L75
    L40:
        if (r15 != R$styleable.MotionLabel_textOutlineColor) goto L43;
        this.d = r13.getInt(r15, this.d);
        this.e = true;
        goto L75
    L43:
        if (r15 != R$styleable.MotionLabel_textOutlineThickness) goto L46;
        this.f12961n = r13.getDimension(r15, this.f12961n);
        this.e = true;
        goto L75
    L46:
        if (r15 != R$styleable.MotionLabel_textBackground) goto L49;
        this.C = r13.getDrawable(r15);
        this.e = true;
        goto L75
    L49:
        if (r15 != R$styleable.MotionLabel_textBackgroundPanX) goto L52;
        this.Q = r13.getFloat(r15, this.Q);
        goto L75
    L52:
        if (r15 != R$styleable.MotionLabel_textBackgroundPanY) goto L55;
        this.R = r13.getFloat(r15, this.R);
        goto L75
    L55:
        if (r15 != R$styleable.MotionLabel_textPanX) goto L58;
        this.J = r13.getFloat(r15, this.J);
        goto L75
    L58:
        if (r15 != R$styleable.MotionLabel_textPanY) goto L61;
        this.K = r13.getFloat(r15, this.K);
        goto L75
    L61:
        if (r15 != R$styleable.MotionLabel_textBackgroundRotate) goto L64;
        this.T = r13.getFloat(r15, this.T);
        goto L75
    L64:
        if (r15 != R$styleable.MotionLabel_textBackgroundZoom) goto L67;
        this.S = r13.getFloat(r15, this.S);
        goto L75
    L67:
        if (r15 != R$styleable.MotionLabel_textureHeight) goto L70;
        this.H = r13.getDimension(r15, this.H);
        goto L75
    L70:
        if (r15 != R$styleable.MotionLabel_textureWidth) goto L73;
        this.I = r13.getDimension(r15, this.I);
        goto L75
    L73:
        if (r15 != R$styleable.MotionLabel_textureEffect) goto L75;
        this.M = r13.getInt(r15, this.M);
        goto L75
    L76:
        r13.recycle();
    L78:
        if (this.C == null) goto L109;
        this.G = new Matrix();
        int r18 = this.C.getIntrinsicWidth();
        int r19 = this.C.getIntrinsicHeight();
        if (r18 > 0) goto L87;
        r18 = getWidth();
        if (r18 != 0) goto L87;
        if (Float.isNaN(this.I) == false) goto L86;
        r18 = 128;
        goto L87
    L86:
        r18 = (int) this.I;
    L87:
        if (r19 > 0) goto L95;
        r19 = getHeight();
        if (r19 != 0) goto L95;
        if (Float.isNaN(this.H) == false) goto L93;
        r19 = 128;
        goto L95
    L93:
        r19 = (int) this.H;
    L95:
        if (this.M == 0) goto L97;
        r18 = r18 / 2;
        r19 = r19 / 2;
    L97:
        this.E = Bitmap.createBitmap(r18, r19, Bitmap.Config.ARGB_8888);
        Canvas r20 = new Canvas(this.E);
        this.C.setBounds(0, 0, r20.getWidth(), r20.getHeight());
        this.C.setFilterBitmap(true);
        this.C.draw(r20);
        if (this.M == 0) goto L108;
        Bitmap r21 = this.E;
        int r22 = r21.getWidth() / 2;
        int r23 = r21.getHeight() / 2;
        Bitmap r24 = Bitmap.createScaledBitmap(r21, r22, r23, true);
        int r25 = 0;
    L101:
        if (r25 >= 4) goto L107;
        if (r22 < 32) goto L107;
        if (r23 < 32) goto L107;
        r22 = r22 / 2;
        r23 = r23 / 2;
        r24 = Bitmap.createScaledBitmap(r24, r22, r23, true);
        r25 = r25 + 1;
    L107:
        this.E = r24;
    L108:
        Bitmap r26 = this.E;
        Shader.TileMode r27 = Shader.TileMode.REPEAT;
        this.F = new BitmapShader(r26, r27, r27);
    L109:
        this.f12965r = getPaddingLeft();
        this.s = getPaddingRight();
        this.f12966t = getPaddingTop();
        this.f12967u = getPaddingBottom();
        String r28 = this.f12968v;
        int r29 = this.f12960m;
        int r30 = this.f12959l;
        TextPaint r31 = this.f12952a;
        if (r28 == null) goto L114;
        Typeface r32 = Typeface.create(r28, r30);
        if (r32 == null) goto L115;
        setTypeface(r32);
    L140:
        r31.setColor(this.f12954c);
        r31.setStrokeWidth(this.f12961n);
        r31.setStyle(Paint.Style.FILL_AND_STROKE);
        r31.setFlags(128);
        setTextSize(this.f12957j);
        r31.setAntiAlias(true);
        return;
    L115:
        if (r29 == 1) goto L122;
        if (r29 != 2) goto L118;
        r32 = Typeface.SERIF;
    L123:
        float r33 = 0.0f;
        if (r30 <= 0) goto L139;
        if (r32 != null) goto L127;
        Typeface r34 = Typeface.defaultFromStyle(r30);
    L128:
        setTypeface(r34);
        if (r34 == null) goto L131;
        int r35 = r34.getStyle();
    L132:
        int r36 = (~r35) & r30;
        if ((r36 & 1) == 0) goto L135;
        r12 = true;
    L135:
        r31.setFakeBoldText(r12);
        if ((r36 & 2) == 0) goto L138;
        r33 = -0.25f;
    L138:
        r31.setTextSkewX(r33);
        goto L140
    L131:
        r35 = 0;
        goto L132
    L127:
        r34 = Typeface.create(r32, r30);
        goto L128
    L139:
        r31.setFakeBoldText(false);
        r31.setTextSkewX(0.0f);
        setTypeface(r32);
        goto L140
    L118:
        if (r29 != 3) goto L123;
        r32 = Typeface.MONOSPACE;
        goto L123
    L122:
        r32 = Typeface.SANS_SERIF;
        goto L123
    L114:
        r32 = null;
        goto L115
    }

    public final void c(float r10, float r11, float r12, float r13) {
        int r5 = (int) (r10 + 0.5f);
        this.f12972z = r10 - r5;
        int r14 = (int) (r12 + 0.5f);
        int r15 = r14 - r5;
        int r16 = (int) (r13 + 0.5f);
        int r17 = (int) (0.5f + r11);
        int r18 = r16 - r17;
        float r19 = r12 - r10;
        this.A = r19;
        float r110 = r13 - r11;
        this.B = r110;
        if (this.G == null) goto L7;
        this.A = r19;
        this.B = r110;
        d();
    L7:
        if (getMeasuredHeight() == r18) goto L9;
    L12:
        measure(View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r18, BasicMeasure.EXACTLY));
        super.layout(r5, r17, r14, r16);
    L14:
        if (this.f12971y == false) goto L32;
        Rect r20 = this.N;
        TextPaint r21 = this.f12952a;
        if (r20 != null) goto L18;
        this.O = new Paint();
        this.N = new Rect();
        this.O.set(r21);
        this.P = this.O.getTextSize();
    L18:
        this.A = r19;
        this.B = r110;
        Paint r22 = this.O;
        String r23 = this.f12962o;
        r22.getTextBounds(r23, 0, r23.length(), this.N);
        int r24 = this.N.width();
        float r25 = this.N.height() * 1.3f;
        float r26 = (r19 - this.s) - this.f12965r;
        float r111 = (r110 - this.f12967u) - this.f12966t;
        float r27 = r24;
        if ((r27 * r111) <= (r25 * r26)) goto L21;
        r21.setTextSize((this.P * r26) / r27);
    L23:
        if (this.e == true) goto L27;
        if (Float.isNaN(this.f12958k) == false) goto L27;
        return;
    L27:
        if (Float.isNaN(this.f12958k) == false) goto L29;
        float r28 = 1.0f;
    L30:
        a(r28);
        return;
    L29:
        r28 = this.f12957j / this.f12958k;
        goto L30
    L21:
        r21.setTextSize((this.P * r111) / r25);
        goto L23
    L32:
        return;
    L9:
        if (getMeasuredWidth() != r15) goto L12;
        super.layout(r5, r17, r14, r16);
        goto L14
    }

    public final void d() {
        float r5 = 0.0f;
        if (Float.isNaN(this.Q) == false) goto L5;
        float r10 = 0.0f;
    L7:
        if (Float.isNaN(this.R) == false) goto L9;
        float r11 = 0.0f;
    L11:
        if (Float.isNaN(this.S) == false) goto L13;
        float r12 = 1.0f;
    L15:
        if (Float.isNaN(this.T) == true) goto L18;
        r5 = this.T;
    L18:
        this.G.reset();
        float r13 = this.E.getWidth();
        float r14 = this.E.getHeight();
        if (Float.isNaN(this.I) == false) goto L21;
        float r15 = this.A;
    L23:
        if (Float.isNaN(this.H) == false) goto L25;
        float r16 = this.B;
    L27:
        if ((r13 * r16) >= (r14 * r15)) goto L29;
        float r17 = r15 / r13;
    L30:
        float r18 = r12 * r17;
        this.G.postScale(r18, r18);
        float r19 = r13 * r18;
        float r20 = r15 - r19;
        float r21 = r18 * r14;
        float r22 = r16 - r21;
        if (Float.isNaN(this.H) == true) goto L34;
        r22 = this.H / 2.0f;
    L34:
        if (Float.isNaN(this.I) == true) goto L36;
        r20 = this.I / 2.0f;
    L36:
        float r23 = (((r11 * r22) + r16) - r21) * 0.5f;
        this.G.postTranslate((((r10 * r20) + r15) - r19) * 0.5f, r23);
        this.G.postRotate(r5, r15 / 2.0f, r16 / 2.0f);
        this.F.setLocalMatrix(this.G);
        return;
    L29:
        r17 = r16 / r14;
        goto L30
    L25:
        r16 = this.H;
        goto L27
    L21:
        r15 = this.I;
        goto L23
    L13:
        r12 = this.S;
        goto L15
    L9:
        r11 = this.R;
        goto L11
    L5:
        r10 = this.Q;
        goto L7
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getScaleFromTextSize() {
        return this.f12958k;
    }

    public float getTextBackgroundPanX() {
        return this.Q;
    }

    public float getTextBackgroundPanY() {
        return this.R;
    }

    public float getTextBackgroundRotate() {
        return this.T;
    }

    public float getTextBackgroundZoom() {
        return this.S;
    }

    public int getTextOutlineColor() {
        return this.d;
    }

    public float getTextPanX() {
        return this.J;
    }

    public float getTextPanY() {
        return this.K;
    }

    public float getTextureHeight() {
        return this.H;
    }

    public float getTextureWidth() {
        return this.I;
    }

    public Typeface getTypeface() {
        return this.f12952a.getTypeface();
    }

    @Override // android.view.View
    public final void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        boolean r5 = Float.isNaN(this.f12958k);
        if (r5 == false) goto L5;
        float r14 = 1.0f;
    L6:
        this.A = r12 - r10;
        this.B = r13 - r11;
        if (this.f12971y == false) goto L22;
        Rect r15 = this.N;
        TextPaint r16 = this.f12952a;
        if (r15 != null) goto L11;
        this.O = new Paint();
        this.N = new Rect();
        this.O.set(r16);
        this.P = this.O.getTextSize();
    L11:
        Paint r17 = this.O;
        String r18 = this.f12962o;
        r17.getTextBounds(r18, 0, r18.length(), this.N);
        int r19 = this.N.width();
        int r20 = (int) (this.N.height() * 1.3f);
        float r21 = (this.A - this.s) - this.f12965r;
        float r22 = (this.B - this.f12967u) - this.f12966t;
        if (r5 == false) goto L17;
        float r23 = r19;
        float r24 = r20;
        if ((r23 * r22) <= (r24 * r21)) goto L16;
        r16.setTextSize((this.P * r21) / r23);
        goto L22
    L16:
        r16.setTextSize((this.P * r22) / r24);
        goto L22
    L17:
        float r25 = r19;
        float r26 = r20;
        if ((r25 * r22) <= (r26 * r21)) goto L20;
        r14 = r21 / r25;
        goto L22
    L20:
        r14 = r22 / r26;
    L22:
        if (this.e == true) goto L24;
        if (r5 == false) goto L24;
        return;
    L24:
        float r110 = r10;
        float r111 = r11;
        float r112 = r12;
        float r113 = r13;
        if (this.G == null) goto L28;
        this.A = r112 - r110;
        this.B = r113 - r111;
        d();
    L28:
        a(r14);
        return;
    L5:
        r14 = this.f12957j / this.f12958k;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        if (Float.isNaN(this.f12958k) == false) goto L5;
        float r5 = 1.0f;
    L6:
        super.onDraw(r10);
        boolean r11 = this.e;
        TextPaint r12 = this.f12952a;
        if (r11 == true) goto L13;
        if (r5 != 1.0f) goto L13;
        float r13 = this.f12965r + getHorizontalOffset();
        r10.drawText(this.f12962o, this.f12972z + r13, this.f12966t + getVerticalOffset(), r12);
        return;
    L13:
        if (this.f12963p == false) goto L16;
        a(r5);
    L16:
        if (this.D != null) goto L19;
        this.D = new Matrix();
    L19:
        if (this.e == false) goto L28;
        Paint r14 = this.L;
        r14.set(r12);
        this.D.reset();
        float r15 = this.f12965r + getHorizontalOffset();
        float r16 = this.f12966t + getVerticalOffset();
        this.D.postTranslate(r15, r16);
        this.D.preScale(r5, r5);
        this.f12953b.transform(this.D);
        if (this.F == null) goto L23;
        r12.setFilterBitmap(true);
        r12.setShader(this.F);
    L24:
        r12.setStyle(Paint.Style.FILL);
        r12.setStrokeWidth(this.f12961n);
        r10.drawPath(this.f12953b, r12);
        if (this.F == null) goto L27;
        r12.setShader(null);
    L27:
        r12.setColor(this.d);
        r12.setStyle(Paint.Style.STROKE);
        r12.setStrokeWidth(this.f12961n);
        r10.drawPath(this.f12953b, r12);
        this.D.reset();
        this.D.postTranslate(-r15, -r16);
        this.f12953b.transform(this.D);
        r12.set(r14);
        return;
    L23:
        r12.setColor(this.f12954c);
        goto L24
    L28:
        float r17 = this.f12965r + getHorizontalOffset();
        float r18 = this.f12966t + getVerticalOffset();
        this.D.reset();
        this.D.preTranslate(r17, r18);
        this.f12953b.transform(this.D);
        r12.setColor(this.f12954c);
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        r12.setStrokeWidth(this.f12961n);
        r10.drawPath(this.f12953b, r12);
        this.D.reset();
        this.D.preTranslate(-r17, -r18);
        this.f12953b.transform(this.D);
        return;
    L5:
        r5 = this.f12957j / this.f12958k;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        int r5 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getSize(r11);
        this.f12971y = false;
        this.f12965r = getPaddingLeft();
        this.s = getPaddingRight();
        this.f12966t = getPaddingTop();
        this.f12967u = getPaddingBottom();
        if (r5 != 1073741824) goto L9;
        if (r12 != 1073741824) goto L9;
        if (this.f12970x == 0) goto L18;
        this.f12971y = true;
    L18:
        setMeasuredDimension(r13, r14);
        return;
    L9:
        String r15 = this.f12962o;
        int r16 = r15.length();
        TextPaint r17 = this.f12952a;
        Rect r18 = this.f12964q;
        r17.getTextBounds(r15, 0, r16, r18);
        if (r5 == 1073741824) goto L12;
        r13 = (int) (r18.width() + 0.99999f);
    L12:
        r13 = r13 + (this.f12965r + this.s);
        if (r12 == 1073741824) goto L18;
        int r19 = (int) (r17.getFontMetricsInt(null) + 0.99999f);
        if (r12 != Integer.MIN_VALUE) goto L17;
        r19 = Math.min(r14, r19);
    L17:
        r14 = (this.f12966t + this.f12967u) + r19;
        goto L18
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int r10) {
        if ((r10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0) goto L6;
        r10 = r10 | GravityCompat.START;
    L6:
        if ((r10 & 112) != 0) goto L9;
        r10 = r10 | 48;
    L9:
        if (r10 == this.f12969w) goto L11;
        invalidate();
    L11:
        this.f12969w = r10;
        int r5 = r10 & 112;
        if (r5 != 48) goto L14;
        this.K = -1.0f;
    L18:
        int r11 = r10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r11 != 3) goto L21;
    L27:
        this.J = -1.0f;
        return;
    L21:
        if (r11 == 5) goto L26;
        if (r11 == 8388611) goto L27;
        if (r11 == 8388613) goto L26;
        this.J = 0.0f;
        return;
    L26:
        this.J = 1.0f;
        return;
    L14:
        if (r5 == 80) goto L16;
        this.K = 0.0f;
        goto L18
    L16:
        this.K = 1.0f;
        goto L18
    }

    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.g = r5;
        float r10 = this.f;
        this.f = -1.0f;
        setRoundPercent(r10);
        return;
    L7:
        if (this.g == r5) goto L9;
        boolean r11 = true;
    L10:
        this.g = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r11 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f12953b != null) goto L16;
        this.f12953b = new Path();
    L16:
        if (this.f12956i != null) goto L19;
        this.f12956i = new RectF();
    L19:
        if (this.f12955h != null) goto L21;
        e r12 = new e(this, 1);
        this.f12955h = r12;
        setOutlineProvider(r12);
    L21:
        setClipToOutline(true);
        this.f12956i.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f12953b.reset();
        Path r13 = this.f12953b;
        RectF r14 = this.f12956i;
        float r15 = this.g;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        goto L23
    L9:
        r11 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f == r10) goto L5;
        boolean r5 = true;
    L6:
        this.f = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r5 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f12953b != null) goto L12;
        this.f12953b = new Path();
    L12:
        if (this.f12956i != null) goto L15;
        this.f12956i = new RectF();
    L15:
        if (this.f12955h != null) goto L17;
        e r11 = new e(this, 0);
        this.f12955h = r11;
        setOutlineProvider(r11);
    L17:
        setClipToOutline(true);
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.f) / 2.0f;
        this.f12956i.set(0.0f, 0.0f, r12, r13);
        this.f12953b.reset();
        this.f12953b.addRoundRect(this.f12956i, r14, r14, Path.Direction.CW);
        goto L19
    L5:
        r5 = false;
        goto L6
    }

    public void setScaleFromTextSize(float r5) {
        this.f12958k = r5;
    }

    public void setText(CharSequence r5) {
        this.f12962o = r5.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float r5) {
        this.Q = r5;
        d();
        invalidate();
    }

    public void setTextBackgroundPanY(float r5) {
        this.R = r5;
        d();
        invalidate();
    }

    public void setTextBackgroundRotate(float r5) {
        this.T = r5;
        d();
        invalidate();
    }

    public void setTextBackgroundZoom(float r5) {
        this.S = r5;
        d();
        invalidate();
    }

    public void setTextFillColor(int r5) {
        this.f12954c = r5;
        invalidate();
    }

    public void setTextOutlineColor(int r5) {
        this.d = r5;
        this.e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float r5) {
        this.f12961n = r5;
        this.e = true;
        if (Float.isNaN(r5) == false) goto L5;
        this.f12961n = 1.0f;
        this.e = false;
    L5:
        invalidate();
    }

    public void setTextPanX(float r5) {
        this.J = r5;
        invalidate();
    }

    public void setTextPanY(float r5) {
        this.K = r5;
        invalidate();
    }

    public void setTextSize(float r5) {
        this.f12957j = r5;
        if (Float.isNaN(this.f12958k) == true) goto L6;
        r5 = this.f12958k;
    L6:
        this.f12952a.setTextSize(r5);
        if (Float.isNaN(this.f12958k) == false) goto L9;
        float r10 = 1.0f;
    L10:
        a(r10);
        requestLayout();
        invalidate();
        return;
    L9:
        r10 = this.f12957j / this.f12958k;
        goto L10
    }

    public void setTextureHeight(float r5) {
        this.H = r5;
        d();
        invalidate();
    }

    public void setTextureWidth(float r5) {
        this.I = r5;
        d();
        invalidate();
    }

    public void setTypeface(Typeface r5) {
        TextPaint r10 = this.f12952a;
        if (Objects.equals(r10.getTypeface(), r5) == true) goto L6;
        r10.setTypeface(r5);
        return;
    }

    public MotionLabel(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f12952a = new TextPaint();
        this.f12953b = new Path();
        this.f12954c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.f12957j = 48.0f;
        this.f12958k = Float.NaN;
        this.f12961n = 0.0f;
        this.f12962o = "Hello World";
        this.f12963p = true;
        this.f12964q = new Rect();
        this.f12965r = 1;
        this.s = 1;
        this.f12966t = 1;
        this.f12967u = 1;
        this.f12969w = 8388659;
        this.f12970x = 0;
        this.f12971y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        b(r10, r11);
    }

    public MotionLabel(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12952a = new TextPaint();
        this.f12953b = new Path();
        this.f12954c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.f12957j = 48.0f;
        this.f12958k = Float.NaN;
        this.f12961n = 0.0f;
        this.f12962o = "Hello World";
        this.f12963p = true;
        this.f12964q = new Rect();
        this.f12965r = 1;
        this.s = 1;
        this.f12966t = 1;
        this.f12967u = 1;
        this.f12969w = 8388659;
        this.f12970x = 0;
        this.f12971y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        b(r5, r10);
    }
}
