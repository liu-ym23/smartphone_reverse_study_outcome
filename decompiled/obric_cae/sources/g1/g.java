package g1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.i;

/* JADX INFO: loaded from: classes.dex */
public final class g extends g1.f {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final PorterDuff.Mode f7562t = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0076g f7563b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuffColorFilter f7564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorFilter f7565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7567p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float[] f7568q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Matrix f7569r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f7570s;

    public static class a extends e {
        public a() {
        }

        public a(a r8) {
            super(r8);
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public z.c f7571e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7572f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public z.c f7573g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7574h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7575i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f7576j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7577k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f7578l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Paint.Cap f7579m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Paint.Join f7580n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f7581o;

        public b() {
            this.f7572f = 0.0f;
            this.f7574h = 1.0f;
            this.f7575i = 1.0f;
            this.f7576j = 0.0f;
            this.f7577k = 1.0f;
            this.f7578l = 0.0f;
            this.f7579m = Paint.Cap.BUTT;
            this.f7580n = Paint.Join.MITER;
            this.f7581o = 4.0f;
        }

        @Override // g1.g.d
        public final boolean a() {
            if (this.f7573g.b() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f7571e.b() == true) goto L8;
            return false;
        }

        @Override // g1.g.d
        public final boolean b(int[] r8) {
            z.c r10 = this.f7573g;
            boolean r11 = true;
            if (r10.b() == false) goto L7;
            ColorStateList r12 = r10.f14132b;
            int r13 = r12.getColorForState(r8, r12.getDefaultColor());
            if (r13 == r10.f14133c) goto L7;
            r10.f14133c = r13;
            boolean r14 = true;
        L8:
            z.c r15 = this.f7571e;
            if (r15.b() == false) goto L13;
            ColorStateList r16 = r15.f14132b;
            int r17 = r16.getColorForState(r8, r16.getDefaultColor());
            if (r17 == r15.f14133c) goto L13;
            r15.f14133c = r17;
        L15:
            return r11 | r14;
        L13:
            r11 = false;
        L7:
            r14 = false;
            goto L8
        }

        public float getFillAlpha() {
            return this.f7575i;
        }

        public int getFillColor() {
            return this.f7573g.f14133c;
        }

        public float getStrokeAlpha() {
            return this.f7574h;
        }

        public int getStrokeColor() {
            return this.f7571e.f14133c;
        }

        public float getStrokeWidth() {
            return this.f7572f;
        }

        public float getTrimPathEnd() {
            return this.f7577k;
        }

        public float getTrimPathOffset() {
            return this.f7578l;
        }

        public float getTrimPathStart() {
            return this.f7576j;
        }

        public void setFillAlpha(float r8) {
            this.f7575i = r8;
        }

        public void setFillColor(int r8) {
            this.f7573g.f14133c = r8;
        }

        public void setStrokeAlpha(float r8) {
            this.f7574h = r8;
        }

        public void setStrokeColor(int r8) {
            this.f7571e.f14133c = r8;
        }

        public void setStrokeWidth(float r8) {
            this.f7572f = r8;
        }

        public void setTrimPathEnd(float r8) {
            this.f7577k = r8;
        }

        public void setTrimPathOffset(float r8) {
            this.f7578l = r8;
        }

        public void setTrimPathStart(float r8) {
            this.f7576j = r8;
        }

        public b(b r8) {
            super(r8);
            this.f7572f = 0.0f;
            this.f7574h = 1.0f;
            this.f7575i = 1.0f;
            this.f7576j = 0.0f;
            this.f7577k = 1.0f;
            this.f7578l = 0.0f;
            this.f7579m = Paint.Cap.BUTT;
            this.f7580n = Paint.Join.MITER;
            this.f7581o = 4.0f;
            this.f7571e = r8.f7571e;
            this.f7572f = r8.f7572f;
            this.f7574h = r8.f7574h;
            this.f7573g = r8.f7573g;
            this.f7596c = r8.f7596c;
            this.f7575i = r8.f7575i;
            this.f7576j = r8.f7576j;
            this.f7577k = r8.f7577k;
            this.f7578l = r8.f7578l;
            this.f7579m = r8.f7579m;
            this.f7580n = r8.f7580n;
            this.f7581o = r8.f7581o;
        }
    }

    public static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f7582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<d> f7583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7588g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7589h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7590i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Matrix f7591j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f7592k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f7593l;

        public c() {
            this.f7582a = new Matrix();
            this.f7583b = new ArrayList();
            this.f7584c = 0.0f;
            this.f7585d = 0.0f;
            this.f7586e = 0.0f;
            this.f7587f = 1.0f;
            this.f7588g = 1.0f;
            this.f7589h = 0.0f;
            this.f7590i = 0.0f;
            this.f7591j = new Matrix();
            this.f7593l = null;
        }

        @Override // g1.g.d
        public final boolean a() {
            int r8 = 0;
        L3:
            ArrayList<d> r10 = this.f7583b;
            if (r8 >= r10.size()) goto L10;
            if (r10.get(r8).a() == true) goto L7;
            r8 = r8 + 1;
            goto L3
        L7:
            return true;
        L10:
            return false;
        }

        @Override // g1.g.d
        public final boolean b(int[] r8) {
            int r10 = 0;
            boolean r11 = false;
        L3:
            ArrayList<d> r12 = this.f7583b;
            if (r10 >= r12.size()) goto L6;
            r11 = r11 | r12.get(r10).b(r8);
            r10 = r10 + 1;
            goto L3
        L6:
            return r11;
        }

        public final void c() {
            Matrix r8 = this.f7591j;
            r8.reset();
            r8.postTranslate(-this.f7585d, -this.f7586e);
            r8.postScale(this.f7587f, this.f7588g);
            r8.postRotate(this.f7584c, 0.0f, 0.0f);
            r8.postTranslate(this.f7589h + this.f7585d, this.f7590i + this.f7586e);
        }

        public String getGroupName() {
            return this.f7593l;
        }

        public Matrix getLocalMatrix() {
            return this.f7591j;
        }

        public float getPivotX() {
            return this.f7585d;
        }

        public float getPivotY() {
            return this.f7586e;
        }

        public float getRotation() {
            return this.f7584c;
        }

        public float getScaleX() {
            return this.f7587f;
        }

        public float getScaleY() {
            return this.f7588g;
        }

        public float getTranslateX() {
            return this.f7589h;
        }

        public float getTranslateY() {
            return this.f7590i;
        }

        public void setPivotX(float r8) {
            if (r8 == this.f7585d) goto L6;
            this.f7585d = r8;
            c();
            return;
        }

        public void setPivotY(float r8) {
            if (r8 == this.f7586e) goto L6;
            this.f7586e = r8;
            c();
            return;
        }

        public void setRotation(float r8) {
            if (r8 == this.f7584c) goto L6;
            this.f7584c = r8;
            c();
            return;
        }

        public void setScaleX(float r8) {
            if (r8 == this.f7587f) goto L6;
            this.f7587f = r8;
            c();
            return;
        }

        public void setScaleY(float r8) {
            if (r8 == this.f7588g) goto L6;
            this.f7588g = r8;
            c();
            return;
        }

        public void setTranslateX(float r8) {
            if (r8 == this.f7589h) goto L6;
            this.f7589h = r8;
            c();
            return;
        }

        public void setTranslateY(float r8) {
            if (r8 == this.f7590i) goto L6;
            this.f7590i = r8;
            c();
            return;
        }

        public c(c r8, n.b<String, Object> r10) {
            this.f7582a = new Matrix();
            this.f7583b = new ArrayList();
            this.f7584c = 0.0f;
            this.f7585d = 0.0f;
            this.f7586e = 0.0f;
            this.f7587f = 1.0f;
            this.f7588g = 1.0f;
            this.f7589h = 0.0f;
            this.f7590i = 0.0f;
            Matrix r11 = new Matrix();
            this.f7591j = r11;
            this.f7593l = null;
            this.f7584c = r8.f7584c;
            this.f7585d = r8.f7585d;
            this.f7586e = r8.f7586e;
            this.f7587f = r8.f7587f;
            this.f7588g = r8.f7588g;
            this.f7589h = r8.f7589h;
            this.f7590i = r8.f7590i;
            String r12 = r8.f7593l;
            this.f7593l = r12;
            this.f7592k = r8.f7592k;
            if (r12 == null) goto L5;
            r10.put(r12, this);
        L5:
            r11.set(r8.f7591j);
            ArrayList<d> r13 = r8.f7583b;
            int r14 = 0;
        L7:
            if (r14 >= r13.size()) goto L23;
            d r15 = r13.get(r14);
            if ((r15 instanceof c) == false) goto L12;
            this.f7583b.add(new c((c) r15, r10));
        L20:
            r14 = r14 + 1;
            goto L7
        L12:
            if ((r15 instanceof b) == false) goto L15;
            e r16 = new b((b) r15);
        L17:
            this.f7583b.add(r16);
            String r17 = r16.f7595b;
            if (r17 == null) goto L20;
            r10.put(r17, r16);
            goto L20
        L15:
            if ((r15 instanceof a) == false) goto L22;
            r16 = new a((a) r15);
            goto L17
        L22:
            throw new IllegalStateException("Unknown object in the tree!");
        }
    }

    public static abstract class d {
        public d() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] r8) {
            return false;
        }
    }

    public static abstract class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a0.d.b[] f7594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f7597d;

        public e() {
            this.f7594a = null;
            this.f7596c = 0;
        }

        public a0.d.b[] getPathData() {
            return this.f7594a;
        }

        public String getPathName() {
            return this.f7595b;
        }

        public void setPathData(a0.d.b[] r8) {
            if (a0.d.a(this.f7594a, r8) == true) goto L5;
            this.f7594a = a0.d.e(r8);
            return;
        L5:
            a0.d.b[] r10 = this.f7594a;
            int r11 = 0;
        L7:
            if (r11 >= r8.length) goto L16;
            r10[r11].f10a = r8[r11].f10a;
            int r12 = 0;
        L9:
            float[] r13 = r8[r11].f11b;
            if (r12 >= r13.length) goto L12;
            r10[r11].f11b[r12] = r13[r12];
            r12 = r12 + 1;
            goto L9
        L12:
            r11 = r11 + 1;
            goto L7
        }

        public e(e r8) {
            this.f7594a = null;
            this.f7596c = 0;
            this.f7595b = r8.f7595b;
            this.f7597d = r8.f7597d;
            this.f7594a = a0.d.e(r8.f7594a);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Matrix f7598p = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f7599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f7600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f7601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f7602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f7603e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PathMeasure f7604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f7605g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7606h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7607i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f7608j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7609k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7610l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f7611m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Boolean f7612n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final n.b<String, Object> f7613o;

        static {
            f7598p = new Matrix();
        }

        public f() {
            this.f7601c = new Matrix();
            this.f7606h = 0.0f;
            this.f7607i = 0.0f;
            this.f7608j = 0.0f;
            this.f7609k = 0.0f;
            this.f7610l = 255;
            this.f7611m = null;
            this.f7612n = null;
            this.f7613o = new n.b();
            this.f7605g = new c();
            this.f7599a = new Path();
            this.f7600b = new Path();
        }

        public final void a(c r20, Matrix r21, Canvas r22, int r23, int r24) {
            r20.f7582a.set(r21);
            Matrix r10 = r20.f7582a;
            r10.preConcat(r20.f7591j);
            r22.save();
            char r11 = 0;
            int r12 = 0;
        L3:
            ArrayList<d> r8 = r20.f7583b;
            if (r12 >= r8.size()) goto L97;
            d r13 = r8.get(r12);
            if ((r13 instanceof c) == false) goto L9;
            a((c) r13, r10, r22, r23, r24);
        L95:
            int r17 = r12;
        L96:
            r12 = r17 + 1;
            r11 = 0;
            goto L3
        L9:
            if ((r13 instanceof e) == false) goto L95;
            e r14 = (e) r13;
            float r15 = r23 / this.f7608j;
            float r16 = r24 / this.f7609k;
            float r18 = Math.min(r15, r16);
            Matrix r19 = this.f7601c;
            r19.set(r10);
            r19.postScale(r15, r16);
            float[] r25 = {0.0f, 1.0f, 1.0f, 0.0f};
            r10.mapVectors(r25);
            float r26 = (float) Math.hypot(r25[r11], r25[1]);
            r17 = r12;
            float r27 = (float) Math.hypot(r25[2], r25[3]);
            float r110 = (r25[0] * r25[3]) - (r25[1] * r25[2]);
            float r28 = Math.max(r26, r27);
            if (r28 <= 0.0f) goto L13;
            float r29 = Math.abs(r110) / r28;
        L15:
            if (r29 == 0.0f) goto L96;
            r14.getClass();
            Path r30 = this.f7599a;
            r30.reset();
            a0.d.b[] r111 = r14.f7594a;
            if (r111 == null) goto L20;
            a0.d.b.b(r111, r30);
        L20:
            Path r112 = this.f7600b;
            r112.reset();
            if ((r14 instanceof a) == true) goto L23;
            b r31 = (b) r14;
            float r113 = r31.f7576j;
            if (r113 == 0.0f) goto L30;
        L31:
            float r114 = r31.f7578l;
            float r115 = (r113 + r114) % 1.0f;
            float r116 = (r31.f7577k + r114) % 1.0f;
            if (this.f7604f != null) goto L34;
            this.f7604f = new PathMeasure();
        L34:
            this.f7604f.setPath(r30, false);
            float r117 = this.f7604f.getLength();
            float r118 = r115 * r117;
            float r119 = r116 * r117;
            r30.reset();
            if (r118 <= r119) goto L37;
            this.f7604f.getSegment(r118, r117, r30, true);
            float r120 = 0.0f;
            this.f7604f.getSegment(0.0f, r119, r30, true);
        L38:
            r30.rLineTo(r120, r120);
        L39:
            r112.addPath(r30, r19);
            z.c r32 = r31.f7573g;
            if (r32.f14131a == null) goto L42;
            boolean r33 = true;
        L43:
            if (r33 == false) goto L45;
        L48:
            boolean r34 = true;
        L50:
            if (r34 == true) goto L52;
        L66:
            z.c r35 = r31.f7571e;
            if (r35.f14131a == null) goto L69;
            boolean r36 = true;
        L70:
            if (r36 == false) goto L72;
        L75:
            boolean r37 = true;
        L76:
            if (r37 == false) goto L96;
            if (this.f7602d != null) goto L80;
            boolean r121 = true;
            Paint r38 = new Paint(1);
            this.f7602d = r38;
            r38.setStyle(Paint.Style.STROKE);
        L81:
            Paint r39 = this.f7602d;
            Paint.Join r122 = r31.f7580n;
            if (r122 == null) goto L84;
            r39.setStrokeJoin(r122);
        L84:
            Paint.Cap r123 = r31.f7579m;
            if (r123 == null) goto L87;
            r39.setStrokeCap(r123);
        L87:
            r39.setStrokeMiter(r31.f7581o);
            Shader r124 = r35.f14131a;
            if (r124 != null) goto L91;
            r121 = false;
        L91:
            if (r121 == false) goto L93;
            r124.setLocalMatrix(r19);
            r39.setShader(r124);
            r39.setAlpha(Math.round(r31.f7574h * 255.0f));
        L94:
            r39.setColorFilter(null);
            r39.setStrokeWidth(r31.f7572f * (r29 * r18));
            r22.drawPath(r112, r39);
            goto L96
        L93:
            r39.setShader(null);
            r39.setAlpha(255);
            int r40 = r35.f14133c;
            float r125 = r31.f7574h;
            PorterDuff.Mode r126 = g.f7562t;
            r39.setColor((r40 & 16777215) | (((int) (Color.alpha(r40) * r125)) << 24));
            goto L94
        L80:
            r121 = true;
            goto L81
        L72:
            if (r35.f14133c != 0) goto L75;
            r37 = false;
            goto L76
        L69:
            r36 = false;
            goto L70
        L52:
            if (this.f7603e != null) goto L54;
            Paint r41 = new Paint(1);
            this.f7603e = r41;
            r41.setStyle(Paint.Style.FILL);
        L54:
            Paint r42 = this.f7603e;
            Shader r127 = r32.f14131a;
            if (r127 == null) goto L57;
            boolean r128 = true;
        L58:
            if (r128 == false) goto L60;
            r127.setLocalMatrix(r19);
            r42.setShader(r127);
            r42.setAlpha(Math.round(r31.f7575i * 255.0f));
        L61:
            r42.setColorFilter(null);
            if (r31.f7596c != 0) goto L64;
            Path.FillType r43 = Path.FillType.WINDING;
        L65:
            r112.setFillType(r43);
            r22.drawPath(r112, r42);
            goto L66
        L64:
            r43 = Path.FillType.EVEN_ODD;
            goto L65
        L60:
            r42.setShader(null);
            r42.setAlpha(255);
            int r44 = r32.f14133c;
            float r129 = r31.f7575i;
            PorterDuff.Mode r130 = g.f7562t;
            r42.setColor((r44 & 16777215) | (((int) (Color.alpha(r44) * r129)) << 24));
            goto L61
        L57:
            r128 = false;
            goto L58
        L45:
            if (r32.f14133c != 0) goto L48;
            r34 = false;
            goto L50
        L42:
            r33 = false;
            goto L43
        L37:
            r120 = 0.0f;
            this.f7604f.getSegment(r118, r119, r30, true);
            goto L38
        L30:
            if (r31.f7577k == 1.0f) goto L39;
        L23:
            if (r14.f7596c != 0) goto L25;
            Path.FillType r45 = Path.FillType.WINDING;
        L26:
            r112.setFillType(r45);
            r112.addPath(r30, r19);
            r22.clipPath(r112);
            goto L96
        L25:
            r45 = Path.FillType.EVEN_ODD;
            goto L26
        L13:
            r29 = 0.0f;
            goto L15
        L97:
            r22.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f7610l;
        }

        public void setAlpha(float r8) {
            setRootAlpha((int) (r8 * 255.0f));
        }

        public void setRootAlpha(int r8) {
            this.f7610l = r8;
        }

        public f(f r8) {
            this.f7601c = new Matrix();
            this.f7606h = 0.0f;
            this.f7607i = 0.0f;
            this.f7608j = 0.0f;
            this.f7609k = 0.0f;
            this.f7610l = 255;
            this.f7611m = null;
            this.f7612n = null;
            n.b<String, Object> r10 = new n.b();
            this.f7613o = r10;
            this.f7605g = new c(r8.f7605g, r10);
            this.f7599a = new Path(r8.f7599a);
            this.f7600b = new Path(r8.f7600b);
            this.f7606h = r8.f7606h;
            this.f7607i = r8.f7607i;
            this.f7608j = r8.f7608j;
            this.f7609k = r8.f7609k;
            this.f7610l = r8.f7610l;
            this.f7611m = r8.f7611m;
            String r11 = r8.f7611m;
            if (r11 == null) goto L5;
            r10.put(r11, this);
        L5:
            this.f7612n = r8.f7612n;
        }
    }

    /* JADX INFO: renamed from: g1.g$g, reason: collision with other inner class name */
    public static class C0076g extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f7615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f7616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f7617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f7619f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f7620g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f7621h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7622i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f7623j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f7624k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Paint f7625l;

        public C0076g() {
            this.f7616c = null;
            this.f7617d = g.f7562t;
            this.f7615b = new f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f7614a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new g(this);
        }

        public C0076g(C0076g r8) {
            this.f7616c = null;
            this.f7617d = g.f7562t;
            if (r8 == null) goto L12;
            this.f7614a = r8.f7614a;
            f r10 = new f(r8.f7615b);
            this.f7615b = r10;
            if (r8.f7615b.f7603e == null) goto L8;
            r10.f7603e = new Paint(r8.f7615b.f7603e);
        L8:
            if (r8.f7615b.f7602d == null) goto L10;
            f r11 = this.f7615b;
            r11.f7602d = new Paint(r8.f7615b.f7602d);
        L10:
            this.f7616c = r8.f7616c;
            this.f7617d = r8.f7617d;
            this.f7618e = r8.f7618e;
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources r8) {
            return new g(this);
        }
    }

    public static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f7626a;

        public h(Drawable.ConstantState r8) {
            this.f7626a = r8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f7626a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f7626a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            g r8 = new g();
            r8.f7561a = (VectorDrawable) this.f7626a.newDrawable();
            return r8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources r8) {
            g r10 = new g();
            r10.f7561a = (VectorDrawable) this.f7626a.newDrawable(r8);
            return r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources r8, Resources.Theme r10) {
            g r11 = new g();
            r11.f7561a = (VectorDrawable) this.f7626a.newDrawable(r8, r10);
            return r11;
        }
    }

    static {
        f7562t = PorterDuff.Mode.SRC_IN;
    }

    public g() {
        this.f7567p = true;
        this.f7568q = new float[9];
        this.f7569r = new Matrix();
        this.f7570s = new Rect();
        this.f7563b = new C0076g();
    }

    public final PorterDuffColorFilter a(ColorStateList r8, PorterDuff.Mode r10) {
        if (r8 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r8.getColorForState(getState(), 0), r10);
    L7:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        b0.a.b.b(r8);
        return false;
    L7:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r19) {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        r8.draw(r19);
        return;
    L6:
        Rect r10 = this.f7570s;
        copyBounds(r10);
        if (r10.width() > 0) goto L9;
        return;
    L9:
        if (r10.height() <= 0) goto L73;
        ColorFilter r11 = this.f7565n;
        if (r11 != null) goto L14;
        r11 = this.f7564m;
    L14:
        Matrix r12 = this.f7569r;
        r19.getMatrix(r12);
        float[] r13 = this.f7568q;
        r12.getValues(r13);
        boolean r14 = false;
        float r15 = Math.abs(r13[0]);
        float r16 = Math.abs(r13[4]);
        float r17 = Math.abs(r13[1]);
        float r18 = Math.abs(r13[3]);
        if (r17 == 0.0f) goto L17;
    L18:
        r15 = 1.0f;
        r16 = 1.0f;
    L19:
        int r20 = (int) (r10.width() * r15);
        int r21 = (int) (r10.height() * r16);
        int r22 = Math.min(2048, r20);
        int r23 = Math.min(2048, r21);
        if (r22 <= 0) goto L72;
        if (r23 <= 0) goto L74;
        int r24 = r19.save();
        r19.translate(r10.left, r10.top);
        if (isAutoMirrored() == true) goto L26;
    L28:
        boolean r25 = false;
    L29:
        if (r25 == false) goto L31;
        r19.translate(r10.width(), 0.0f);
        r19.scale(-1.0f, 1.0f);
    L31:
        r10.offsetTo(0, 0);
        C0076g r26 = this.f7563b;
        Bitmap r110 = r26.f7619f;
        if (r110 != null) goto L34;
    L40:
        r26.f7619f = Bitmap.createBitmap(r22, r23, Bitmap.Config.ARGB_8888);
        r26.f7624k = true;
    L42:
        if (this.f7567p == true) goto L44;
        C0076g r27 = this.f7563b;
        r27.f7619f.eraseColor(0);
        Canvas r111 = new Canvas(r27.f7619f);
        f r112 = r27.f7615b;
        r112.a(r112.f7605g, f.f7598p, r111, r22, r23);
    L58:
        C0076g r28 = this.f7563b;
        if (r28.f7615b.getRootAlpha() >= 255) goto L62;
        r14 = true;
    L62:
        if (r14 == true) goto L66;
        if (r11 != null) goto L66;
        Paint r29 = null;
    L69:
        r19.drawBitmap(r28.f7619f, null, r10, r29);
        r19.restoreToCount(r24);
        return;
    L66:
        if (r28.f7625l != null) goto L68;
        Paint r30 = new Paint();
        r28.f7625l = r30;
        r30.setFilterBitmap(true);
    L68:
        r28.f7625l.setAlpha(r28.f7615b.getRootAlpha());
        r28.f7625l.setColorFilter(r11);
        r29 = r28.f7625l;
        goto L69
    L44:
        C0076g r31 = this.f7563b;
        if (r31.f7624k == false) goto L47;
    L55:
        boolean r32 = false;
    L56:
        if (r32 == true) goto L58;
        C0076g r33 = this.f7563b;
        r33.f7619f.eraseColor(0);
        Canvas r113 = new Canvas(r33.f7619f);
        f r114 = r33.f7615b;
        r114.a(r114.f7605g, f.f7598p, r113, r22, r23);
        C0076g r34 = this.f7563b;
        r34.f7620g = r34.f7616c;
        r34.f7621h = r34.f7617d;
        r34.f7622i = r34.f7615b.getRootAlpha();
        r34.f7623j = r34.f7618e;
        r34.f7624k = false;
        goto L58
    L47:
        if (r31.f7620g != r31.f7616c) goto L55;
        if (r31.f7621h != r31.f7617d) goto L55;
        if (r31.f7623j != r31.f7618e) goto L55;
        if (r31.f7622i != r31.f7615b.getRootAlpha()) goto L55;
        r32 = true;
        goto L56
    L34:
        if (r22 == r110.getWidth()) goto L36;
    L38:
        boolean r115 = false;
    L39:
        if (r115 == true) goto L42;
    L36:
        if (r23 != r26.f7619f.getHeight()) goto L38;
        r115 = true;
        goto L39
    L26:
        if (b0.a.c.a(this) != 1) goto L28;
        r25 = true;
        goto L29
    L74:
        return;
    L72:
        return;
    L17:
        if (r18 == 0.0f) goto L19;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return b0.a.C0028a.a(r8);
    L7:
        return this.f7563b.f7615b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable r8 = this.f7561a;
        if (r8 != null) goto L5;
        int r10 = super.getChangingConfigurations();
        return this.f7563b.getChangingConfigurations() | r10;
    L5:
        return r8.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return b0.a.b.c(r8);
    L7:
        return this.f7565n;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f7561a != null) goto L5;
        C0076g r8 = this.f7563b;
        r8.f7614a = getChangingConfigurations();
        return this.f7563b;
    L5:
        return new h(this.f7561a.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getIntrinsicHeight();
    L7:
        return (int) this.f7563b.f7615b.f7607i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getIntrinsicWidth();
    L7:
        return (int) this.f7563b.f7615b.f7606h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable r8 = this.f7561a;
        if (r8 != null) goto L5;
        return -3;
    L5:
        return r8.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources r8, XmlPullParser r10, AttributeSet r11) {
        Drawable r12 = this.f7561a;
        if (r12 == null) goto L6;
        r12.inflate(r8, r10, r11);
        return;
    L6:
        inflate(r8, r10, r11, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        r8.invalidateSelf();
        return;
    L6:
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return b0.a.C0028a.d(r8);
    L7:
        return this.f7563b.f7618e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.isStateful();
    L7:
        if (super.isStateful() == true) goto L21;
        C0076g r10 = this.f7563b;
        if (r10 == null) goto L20;
        f r11 = r10.f7615b;
        if (r11.f7612n != null) goto L14;
        r11.f7612n = Boolean.valueOf(r11.f7605g.a());
    L14:
        if (r11.f7612n.booleanValue() == true) goto L21;
        ColorStateList r12 = this.f7563b.f7616c;
        if (r12 == null) goto L20;
        if (r12.isStateful() == true) goto L21;
    L20:
        return false;
    L21:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        r8.mutate();
        return this;
    L7:
        if (this.f7566o == false) goto L9;
    L11:
        return this;
    L9:
        if (super.mutate() != this) goto L11;
        this.f7563b = new C0076g(this.f7563b);
        this.f7566o = true;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setBounds(r8);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r8) {
        Drawable r10 = this.f7561a;
        if (r10 != null) goto L5;
        C0076g r11 = this.f7563b;
        ColorStateList r12 = r11.f7616c;
        if (r12 == null) goto L11;
        PorterDuff.Mode r13 = r11.f7617d;
        if (r13 == null) goto L11;
        this.f7564m = a(r12, r13);
        invalidateSelf();
        boolean r14 = true;
    L12:
        f r15 = r11.f7615b;
        if (r15.f7612n != null) goto L16;
        r15.f7612n = Boolean.valueOf(r15.f7605g.a());
    L16:
        if (r15.f7612n.booleanValue() == false) goto L21;
        boolean r16 = r11.f7615b.f7605g.b(r8);
        r11.f7624k |= r16;
        if (r16 == false) goto L21;
        invalidateSelf();
        return true;
    L21:
        return r14;
    L11:
        r14 = false;
        goto L12
    L5:
        return r10.setState(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable r8, long r10) {
        Drawable r11 = this.f7561a;
        if (r11 == null) goto L6;
        r11.scheduleSelf(r8, r10);
        return;
    L6:
        super.scheduleSelf(r8, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L7;
        r10.setAlpha(r8);
        return;
    L7:
        if (this.f7563b.f7615b.getRootAlpha() == r8) goto L10;
        this.f7563b.f7615b.setRootAlpha(r8);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.C0028a.e(r10, r8);
        return;
    L6:
        this.f7563b.f7618e = r8;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setColorFilter(r8);
        return;
    L6:
        this.f7565n = r8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.a(r10, r8);
        return;
    L6:
        setTintList(ColorStateList.valueOf(r8));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.b.h(r10, r8);
        return;
    L6:
        C0076g r11 = this.f7563b;
        if (r11.f7616c == r8) goto L10;
        r11.f7616c = r8;
        this.f7564m = a(r8, r11.f7617d);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.b.i(r10, r8);
        return;
    L6:
        C0076g r11 = this.f7563b;
        if (r11.f7617d == r8) goto L10;
        r11.f7617d = r8;
        this.f7564m = a(r11.f7616c, r8);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r8, boolean r10) {
        Drawable r11 = this.f7561a;
        if (r11 == null) goto L7;
        return r11.setVisible(r8, r10);
    L7:
        return super.setVisible(r8, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.unscheduleSelf(r8);
        return;
    L6:
        super.unscheduleSelf(r8);
    }

    public g(C0076g r8) {
        this.f7567p = true;
        this.f7568q = new float[9];
        this.f7569r = new Matrix();
        this.f7570s = new Rect();
        this.f7563b = r8;
        this.f7564m = a(r8.f7616c, r8.f7617d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources r23, XmlPullParser r24, AttributeSet r25, Resources.Theme r26) {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        b0.a.b.d(r8, r23, r24, r25, r26);
        return;
    L6:
        C0076g r10 = this.f7563b;
        r10.f7615b = new f();
        TypedArray r11 = i.e(r23, r26, r25, g1.a.f7541a);
        C0076g r12 = this.f7563b;
        f r13 = r12.f7615b;
        int r14 = i.c(r11, r24, "tintMode", 6, -1);
        PorterDuff.Mode r15 = PorterDuff.Mode.SRC_IN;
        int r16 = 3;
        if (r14 == 3) goto L16;
        if (r14 == 5) goto L17;
        if (r14 == 9) goto L15;
        switch(r14) {
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            default: goto L17;
        };
    L12:
        r15 = PorterDuff.Mode.ADD;
        goto L17
    L13:
        r15 = PorterDuff.Mode.SCREEN;
        goto L17
    L14:
        r15 = PorterDuff.Mode.MULTIPLY;
        goto L17
    L15:
        r15 = PorterDuff.Mode.SRC_ATOP;
    L17:
        r12.f7617d = r15;
        boolean r17 = false;
        int r18 = 1;
        if (i.d(r24, "tint") == false) goto L33;
        TypedValue r19 = new TypedValue();
        r11.getValue(1, r19);
        int r110 = r19.type;
        if (r110 == 2) goto L32;
        if (r110 >= 28) goto L24;
    L26:
        Resources r20 = r11.getResources();
        int r111 = r11.getResourceId(1, 0);
        ThreadLocal<TypedValue> r112 = z.b.f14130a;
        ColorStateList r21 = z.b.a(r20, r20.getXml(r111), r26);     // Catch: Exception -> L29
    L34:
        if (r21 == null) goto L36;
        r12.f7616c = r21;
    L36:
        boolean r22 = r12.f7618e;
        if (i.d(r24, "autoMirrored") == false) goto L40;
        r22 = r11.getBoolean(5, r22);
    L40:
        r12.f7618e = r22;
        r13.f7608j = i.b(r11, r24, "viewportWidth", 7, r13.f7608j);
        float r27 = i.b(r11, r24, "viewportHeight", 8, r13.f7609k);
        r13.f7609k = r27;
        if (r13.f7608j <= 0.0f) goto L139;
        if (r27 <= 0.0f) goto L137;
        r13.f7606h = r11.getDimension(3, r13.f7606h);
        float r28 = r11.getDimension(2, r13.f7607i);
        r13.f7607i = r28;
        if (r13.f7606h <= 0.0f) goto L135;
        if (r28 <= 0.0f) goto L133;
        r13.setAlpha(i.b(r11, r24, "alpha", 4, r13.getAlpha()));
        String r29 = r11.getString(0);
        if (r29 == null) goto L51;
        r13.f7611m = r29;
        r13.f7613o.put(r29, r13);
    L51:
        r11.recycle();
        r10.f7614a = getChangingConfigurations();
        r10.f7624k = true;
        C0076g r30 = this.f7563b;
        f r31 = r30.f7615b;
        ArrayDeque r32 = new ArrayDeque();
        r32.push(r31.f7605g);
        int r33 = r24.getEventType();
        int r113 = r24.getDepth() + 1;
        boolean r114 = true;
    L52:
        if (r33 == r18) goto L127;
        if (r24.getDepth() >= r113) goto L57;
        if (r33 == r16) goto L127;
    L57:
        if (r33 != 2) goto L121;
        String r34 = r24.getName();
        c r115 = (c) r32.peek();
        boolean r116 = "path".equals(r34);
        int r210 = r113;
        n.b<String, Object> r117 = r31.f7613o;
        if (r116 == false) goto L94;
        b r35 = new b();
        TypedArray r118 = i.e(r23, r26, r25, g1.a.f7543c);
        if (i.d(r24, "pathData") == false) goto L90;
        String r119 = r118.getString(0);
        if (r119 == null) goto L66;
        r35.f7595b = r119;
    L66:
        String r120 = r118.getString(2);
        if (r120 == null) goto L69;
        r35.f7594a = a0.d.c(r120);
    L69:
        r35.f7573g = i.a(r118, r24, r26, "fillColor", 1);
        r35.f7575i = i.b(r118, r24, "fillAlpha", 12, r35.f7575i);
        int r36 = i.c(r118, r24, "strokeLineCap", 8, -1);
        Paint.Cap r121 = r35.f7579m;
        if (r36 != 0) goto L72;
        r121 = Paint.Cap.BUTT;
    L79:
        r35.f7579m = r121;
        int r37 = i.c(r118, r24, "strokeLineJoin", 9, -1);
        Paint.Join r122 = r35.f7580n;
        if (r37 != 0) goto L82;
        r122 = Paint.Join.MITER;
    L89:
        r35.f7580n = r122;
        r35.f7581o = i.b(r118, r24, "strokeMiterLimit", 10, r35.f7581o);
        r35.f7571e = i.a(r118, r24, r26, "strokeColor", 3);
        r35.f7574h = i.b(r118, r24, "strokeAlpha", 11, r35.f7574h);
        r35.f7572f = i.b(r118, r24, "strokeWidth", 4, r35.f7572f);
        r35.f7577k = i.b(r118, r24, "trimPathEnd", 6, r35.f7577k);
        r35.f7578l = i.b(r118, r24, "trimPathOffset", 7, r35.f7578l);
        r35.f7576j = i.b(r118, r24, "trimPathStart", 5, r35.f7576j);
        r35.f7596c = i.c(r118, r24, "fillType", 13, r35.f7596c);
        goto L90
    L82:
        if (r37 != 1) goto L84;
        r122 = Paint.Join.ROUND;
        goto L89
    L84:
        if (r37 != 2) goto L89;
        r122 = Paint.Join.BEVEL;
        goto L89
    L72:
        if (r36 != 1) goto L74;
        r121 = Paint.Cap.ROUND;
        goto L79
    L74:
        if (r36 != 2) goto L79;
        r121 = Paint.Cap.SQUARE;
    L90:
        r118.recycle();
        r115.f7583b.add(r35);
        if (r35.getPathName() == null) goto L93;
        r117.put(r35.getPathName(), r35);
    L93:
        r30.f7614a |= r35.f7597d;
        boolean r123 = false;
        char r124 = 5;
        r114 = false;
    L120:
        int r125 = 3;
    L126:
        r33 = r24.next();
        r17 = r123;
        r16 = r125;
        r113 = r210;
        r31 = r31;
        r18 = 1;
        goto L52
    L94:
        r31 = r31;
        if ("clip-path".equals(r34) == false) goto L111;
        a r38 = new a();
        if (i.d(r24, "pathData") == false) goto L106;
        TypedArray r39 = i.e(r23, r26, r25, g1.a.f7544d);
        String r126 = r39.getString(0);
        if (r126 == null) goto L102;
        r38.f7595b = r126;
    L102:
        String r127 = r39.getString(1);
        if (r127 == null) goto L105;
        r38.f7594a = a0.d.c(r127);
    L105:
        r38.f7596c = i.c(r39, r24, "fillType", 2, 0);
        r39.recycle();
    L106:
        r115.f7583b.add(r38);
        if (r38.getPathName() == null) goto L109;
        r117.put(r38.getPathName(), r38);
    L109:
        r30.f7614a = r38.f7597d | r30.f7614a;
    L119:
        r123 = false;
        r124 = 5;
        goto L120
    L111:
        if ("group".equals(r34) == false) goto L119;
        c r40 = new c();
        TypedArray r41 = i.e(r23, r26, r25, g1.a.f7542b);
        r124 = 5;
        r40.f7584c = i.b(r41, r24, "rotation", 5, r40.f7584c);
        r40.f7585d = r41.getFloat(1, r40.f7585d);
        r40.f7586e = r41.getFloat(2, r40.f7586e);
        r40.f7587f = i.b(r41, r24, "scaleX", 3, r40.f7587f);
        r40.f7588g = i.b(r41, r24, "scaleY", 4, r40.f7588g);
        r40.f7589h = i.b(r41, r24, "translateX", 6, r40.f7589h);
        r40.f7590i = i.b(r41, r24, "translateY", 7, r40.f7590i);
        r123 = false;
        String r128 = r41.getString(0);
        if (r128 == null) goto L115;
        r40.f7593l = r128;
    L115:
        r40.c();
        r41.recycle();
        r115.f7583b.add(r40);
        r32.push(r40);
        if (r40.getGroupName() == null) goto L118;
        r117.put(r40.getGroupName(), r40);
    L118:
        r30.f7614a = r40.f7592k | r30.f7614a;
        goto L120
    L121:
        r31 = r31;
        r210 = r113;
        r123 = r17;
        r125 = 3;
        if (r33 != 3) goto L126;
        if ("group".equals(r24.getName()) == false) goto L126;
        r32.pop();
    L127:
        if (r114 == true) goto L131;
        this.f7564m = a(r10.f7616c, r10.f7617d);
        return;
    L131:
        throw new XmlPullParserException("no path defined");
    L133:
        throw new XmlPullParserException(r11.getPositionDescription() + "<vector> tag requires height > 0");
    L135:
        throw new XmlPullParserException(r11.getPositionDescription() + "<vector> tag requires width > 0");
    L137:
        throw new XmlPullParserException(r11.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    L139:
        throw new XmlPullParserException(r11.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    L29:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        goto L33
    L24:
        if (r110 > 31) goto L26;
        r21 = ColorStateList.valueOf(r19.data);
        goto L34
    L32:
        throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + r19);
    L33:
        r21 = null;
        goto L34
    L16:
        r15 = PorterDuff.Mode.SRC_OVER;
        goto L17
    }
}
