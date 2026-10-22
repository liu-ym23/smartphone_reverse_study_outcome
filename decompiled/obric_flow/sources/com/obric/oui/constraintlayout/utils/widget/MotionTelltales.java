package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.a0;
import com.obric.oui.constraintlayout.motion.widget.q;
import com.obric.oui.constraintlayout.motion.widget.r;
import com.obric.oui.constraintlayout.widget.R$styleable;
import gr.b;
import gr.n;
import java.util.HashMap;
import jr.g;
import jr.l;

/* JADX INFO: loaded from: classes3.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f12973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MotionLayout f12974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f12975n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Matrix f12976o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12977p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12978q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12979r;

    public MotionTelltales(Context r5) {
        super(r5);
        this.f12973l = new Paint();
        this.f12975n = new float[2];
        this.f12976o = new Matrix();
        this.f12977p = 0;
        this.f12978q = -65281;
        this.f12979r = 0.25f;
        b(r5, null);
    }

    public final void b(Context r5, AttributeSet r10) {
        if (r10 == null) goto L16;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.MotionTelltales);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L15;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.MotionTelltales_telltales_tailColor) goto L9;
        this.f12978q = r11.getColor(r14, this.f12978q);
    L14:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.MotionTelltales_telltales_velocityMode) goto L12;
        this.f12977p = r11.getInt(r14, this.f12977p);
        goto L14
    L12:
        if (r14 != R$styleable.MotionTelltales_telltales_tailScale) goto L14;
        this.f12979r = r11.getFloat(r14, this.f12979r);
        goto L14
    L15:
        r11.recycle();
    L16:
        int r15 = this.f12978q;
        Paint r16 = this.f12973l;
        r16.setColor(r15);
        r16.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.obric.oui.constraintlayout.utils.widget.MockView, android.view.View
    public final void onDraw(Canvas r33) {
        MotionTelltales r5 = this;
        int r10 = 5;
        super.onDraw(r33);
        Matrix r11 = getMatrix();
        Matrix r12 = r5.f12976o;
        r11.invert(r12);
        if (r5.f12974m != null) goto L8;
        ViewParent r13 = getParent();
        if ((r13 instanceof MotionLayout) == false) goto L134;
        r5.f12974m = (MotionLayout) r13;
        return;
    L134:
        return;
    L8:
        int r14 = getWidth();
        int r15 = getHeight();
        float[] r16 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r17 = 0;
    L9:
        if (r17 >= r10) goto L128;
        float r18 = r16[r17];
        int r19 = 0;
    L11:
        if (r19 >= r10) goto L127;
        float r110 = r16[r19];
        MotionLayout r20 = r5.f12974m;
        int r111 = r5.f12977p;
        float r112 = r20.f12681t;
        float r113 = r20.E;
        if (r20.f12678r == null) goto L15;
        float r21 = Math.signum(r20.G - r113);
        float r114 = r20.f12678r.getInterpolation(r20.E + 1.0E-5f);
        r113 = r20.f12678r.getInterpolation(r20.E);
        r112 = (((r114 - r113) / 1.0E-5f) * r21) / r20.C;
    L15:
        r r22 = r20.f12678r;
        if (r22 == null) goto L18;
        r112 = r22.a();
    L18:
        float r23 = r112;
        q r24 = (q) r20.A.get(r5);
        int r25 = r111 & 1;
        float[] r115 = r5.f12975n;
        if (r25 != 0) goto L122;
        int r116 = getWidth();
        int r117 = getHeight();
        float[] r26 = r24.f12889v;
        float r118 = r24.b(r113, r26);
        HashMap r27 = r24.f12892y;
        float[] r119 = r16;
        g r120 = null;
        if (r27 != null) goto L23;
        l r28 = null;
    L24:
        HashMap r121 = r24.f12892y;
        if (r121 != null) goto L27;
        l r122 = null;
    L28:
        HashMap r123 = r24.f12892y;
        int r29 = r17;
        if (r123 != null) goto L31;
        l r124 = null;
    L32:
        HashMap r30 = r24.f12892y;
        int r210 = r14;
        if (r30 != null) goto L35;
        l r31 = null;
    L36:
        HashMap r32 = r24.f12892y;
        if (r32 != null) goto L39;
        l r34 = null;
    L40:
        HashMap r35 = r24.f12893z;
        if (r35 != null) goto L43;
        g r36 = null;
    L44:
        HashMap r37 = r24.f12893z;
        if (r37 != null) goto L47;
        g r38 = null;
    L48:
        HashMap r125 = r24.f12893z;
        if (r125 != null) goto L51;
        g r39 = null;
    L52:
        HashMap r126 = r24.f12893z;
        if (r126 != null) goto L55;
        g r40 = null;
    L56:
        HashMap r127 = r24.f12893z;
        if (r127 != null) goto L59;
    L58:
        g r41 = r120;
        n r128 = new n();
        r128.e = 0.0f;
        r128.d = 0.0f;
        r128.f17172c = 0.0f;
        r128.f17171b = 0.0f;
        r128.f17170a = 0.0f;
        if (r124 == null) goto L64;
        r128.e = (float) r124.f18438a.y(r118);
        r128.f = r124.a(r118);
    L64:
        if (r28 == null) goto L67;
        r128.f17172c = (float) r28.f18438a.y(r118);
    L67:
        if (r122 == null) goto L69;
        r128.d = (float) r122.f18438a.y(r118);
    L69:
        if (r31 == null) goto L71;
        r128.f17170a = (float) r31.f18438a.y(r118);
    L71:
        if (r34 == null) goto L73;
        r128.f17171b = (float) r34.f18438a.y(r118);
    L73:
        if (r39 == null) goto L75;
        r128.e = r39.b(r118);
    L75:
        if (r36 == null) goto L77;
        r128.f17172c = r36.b(r118);
    L77:
        g r42 = r38;
        if (r38 == null) goto L80;
        r128.d = r42.b(r118);
    L80:
        if (r40 == null) goto L82;
        r128.f17170a = r40.b(r118);
    L82:
        if (r41 == null) goto L84;
        r128.f17171b = r41.b(r118);
    L84:
        b r129 = r24.f12879k;
        if (r129 == null) goto L92;
        double[] r43 = r24.f12884p;
        if (r43.length <= 0) goto L89;
        double r44 = r118;
        r129.w(r44, r43);
        r24.f12879k.z(r44, r24.f12885q);
        int[] r45 = r24.f12883o;
        double[] r46 = r24.f12885q;
        double[] r47 = r24.f12884p;
        r24.f.getClass();
        float[] r48 = r115;
        a0.f(r110, r18, r48, r45, r46, r47);
    L90:
        r128.a(r110, r18, r116, r117, r48);
        float r49 = r110;
        int r50 = r111;
    L91:
        r48 = r48;
    L124:
        if (r50 >= 2) goto L126;
        r48[0] = r48[0] * r23;
        r48[1] = r48[1] * r23;
    L126:
        r5 = this;
        float[] r51 = r5.f12975n;
        Matrix r52 = r12;
        r52.mapVectors(r51);
        int r53 = r210;
        float r54 = r53 * r49;
        int r55 = r15;
        float r130 = r55 * r18;
        float r56 = r51[0];
        float r57 = r5.f12979r;
        float r131 = r130 - (r51[1] * r57);
        r52.mapVectors(r51);
        r33.drawLine(r54, r130, r54 - (r56 * r57), r131, r5.f12973l);
        r19 = r19 + 1;
        r15 = r55;
        r18 = r18;
        r16 = r119;
        r17 = r29;
        r10 = 5;
        r12 = r52;
        r14 = r53;
        goto L11
    L89:
        r48 = r115;
        goto L90
    L92:
        r48 = r115;
        r19 = r19;
        if (r24.f12878j == null) goto L99;
        double r58 = r24.b(r118, r26);
        r24.f12878j[0].z(r58, r24.f12885q);
        r24.f12878j[0].w(r58, r24.f12884p);
        float r59 = r26[0];
        int r60 = 0;
    L95:
        double[] r61 = r24.f12885q;
        if (r60 >= r61.length) goto L98;
        r61[r60] = r61[r60] * ((double) r59);
        r60 = r60 + 1;
        goto L95
    L98:
        int[] r132 = r24.f12883o;
        double[] r62 = r24.f12884p;
        r24.f.getClass();
        a0.f(r110, r18, r48, r132, r61, r62);
        r128.a(r110, r18, r116, r117, r48);
        r50 = r111;
        r49 = r110;
        goto L91
    L99:
        a0 r133 = r24.g;
        float r63 = r133.e;
        a0 r134 = r24.f;
        g r211 = r40;
        float r64 = r63 - r134.e;
        float r65 = r133.f - r134.f;
        g r310 = r36;
        float r66 = r133.g - r134.g;
        float r67 = (r133.f12700h - r134.f12700h) + r65;
        r48[0] = ((r66 + r64) * r110) + ((1.0f - r110) * r64);
        r48[1] = (r67 * r18) + ((1.0f - r18) * r65);
        r128.e = 0.0f;
        r128.d = 0.0f;
        r128.f17172c = 0.0f;
        r128.f17171b = 0.0f;
        r128.f17170a = 0.0f;
        if (r124 == 0) goto L103;
        r128.e = (float) r124.f18438a.y(r118);
        r128.f = r124.a(r118);
    L103:
        if (r28 == null) goto L105;
        r128.f17172c = (float) r28.f18438a.y(r118);
    L105:
        if (r122 == null) goto L107;
        r128.d = (float) r122.f18438a.y(r118);
    L107:
        if (r31 == null) goto L109;
        r128.f17170a = (float) r31.f18438a.y(r118);
    L109:
        if (r34 == null) goto L111;
        r128.f17171b = (float) r34.f18438a.y(r118);
    L111:
        if (r39 == null) goto L113;
        r128.e = r39.b(r118);
    L113:
        if (r310 == null) goto L115;
        r128.f17172c = r310.b(r118);
    L115:
        if (r42 == null) goto L117;
        r128.d = r42.b(r118);
    L117:
        if (r211 == null) goto L119;
        r128.f17170a = r211.b(r118);
    L119:
        if (r41 == null) goto L121;
        r128.f17171b = r41.b(r118);
    L121:
        r50 = r111;
        r49 = r110;
        r128.a(r110, r18, r116, r117, r48);
        goto L124
    L59:
        r120 = (g) r127.get("scaleY");
        goto L58
    L55:
        r40 = (g) r126.get("scaleX");
        goto L56
    L51:
        r39 = (g) r125.get("rotation");
        goto L52
    L47:
        r38 = (g) r37.get("translationY");
        goto L48
    L43:
        r36 = (g) r35.get("translationX");
        goto L44
    L39:
        r34 = (l) r32.get("scaleY");
        goto L40
    L35:
        r31 = (l) r30.get("scaleX");
        goto L36
    L31:
        r124 = (l) r123.get("rotation");
        goto L32
    L27:
        r122 = (l) r121.get("translationY");
        goto L28
    L23:
        r28 = (l) r27.get("translationX");
        goto L24
    L122:
        r23 = r23;
        r210 = r14;
        r12 = r12;
        r15 = r15;
        r119 = r16;
        r29 = r17;
        r48 = r115;
        r50 = r111;
        r49 = r110;
        r19 = r19;
        r18 = r18;
        r24.d(r113, r49, r18, r48);
        goto L124
    L127:
        r17 = r17 + 1;
        r15 = r15;
        r10 = 5;
        r12 = r12;
        r14 = r14;
        goto L9
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        postInvalidate();
    }

    public void setText(CharSequence r5) {
        this.f = r5.toString();
        requestLayout();
    }

    public MotionTelltales(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12973l = new Paint();
        this.f12975n = new float[2];
        this.f12976o = new Matrix();
        this.f12977p = 0;
        this.f12978q = -65281;
        this.f12979r = 0.25f;
        b(r5, r10);
    }

    public MotionTelltales(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12973l = new Paint();
        this.f12975n = new float[2];
        this.f12976o = new Matrix();
        this.f12977p = 0;
        this.f12978q = -65281;
        this.f12979r = 0.25f;
        b(r5, r10);
    }
}
