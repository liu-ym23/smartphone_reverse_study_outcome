package com.lynx.serval.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.lynx.serval.svg.model.FillPaintModel;
import com.lynx.serval.svg.model.GradientModel;
import com.lynx.serval.svg.model.LinearGradientModel;
import com.lynx.serval.svg.model.PaintRef;
import com.lynx.serval.svg.model.RadialGradientModel;
import com.lynx.serval.svg.model.StopModel;
import com.lynx.serval.svg.model.StrokePaintModel;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SVGRender {
    public static final float[] h = null;
    public Canvas a;
    public final HashMap<String, Pair<String, GradientModel>> b;
    public final SVGRenderEngine c;
    public c d;
    public String e;
    public boolean f;
    public boolean g;

    public class a implements b {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ SVGRender h;

        public final void a(Bitmap r14) {
            if (r14 != null) goto L4;
            return;
        L4:
            float r8 = r14.getWidth();
            float r9 = r14.getHeight();
            float r4 = this.a;
            if (r4 <= 0.0f) goto L22;
            float r5 = this.b;
            if (r5 > 0.0f) goto L9;
            return;
        L9:
            if (r8 > 0.0f) goto L11;
            return;
        L11:
            if (r9 <= 0.0f) goto L25;
            SVGRenderEngine r1 = this.h.c;
            if (r1 == null) goto L26;
            float[] r2 = r1.calculateViewBoxTransform(this.c, this.d, r4, r5, 0.0f, 0.0f, r8, r9, this.e, this.f, this.g);
            if (r2 != null) goto L17;
            return;
        L17:
            if (r2.length == 6) goto L19;
            return;
        L19:
            if (this.h.a == null) goto L29;
            float[] r3 = {r2[0], r2[2], r2[4], r2[1], r2[3], r2[5], 0.0f, 0.0f, 1.0f};
            Matrix r6 = new Matrix();
            r6.setValues(r3);
            this.h.a.concat(r6);
            this.h.a.drawBitmap(r14, 0.0f, 0.0f, new Paint(2));
            return;
        L29:
            return;
        L26:
            return;
        L25:
            return;
        }

        public a(SVGRender r1, float r2, float r3, float r4, float r5, int r6, int r7, int r8) {
            this.h = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public interface b {
    }

    public interface c {
        void a(String r1, a r2);
    }

    public void applyLuminanceToAlpha() {
    }

    public void setViewBox(float r1, float r2, float r3, float r4) {
    }

    static {
        h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f};
    }

    public void restore() {
        Canvas r0 = this.a;
        if (r0 == null) goto L6;
        r0.restore();
        return;
    }

    public void restoreLayer() {
        Canvas r0 = this.a;
        if (r0 == null) goto L6;
        r0.restore();
        return;
    }

    public void save() {
        Canvas r0 = this.a;
        if (r0 == null) goto L6;
        r0.save();
        return;
    }

    public SVGRender() {
        this.e = null;
        this.f = false;
        this.g = false;
        this.c = SVGRenderEngine.getInstance();
        this.b = new HashMap();
    }

    public String getColor() {
        return this.e;
    }

    public static Paint a(FillPaintModel r3) {
        Paint r0 = new Paint();
        r0.setStyle(Paint.Style.FILL);
        r0.setTypeface(Typeface.DEFAULT);
        r0.setFlags(193);
        r0.setHinting(0);
        if (r3 == null) goto L5;
        r0.setColor(getColorWithOpacity(r3.mColor, r3.mOpacity));
    L5:
        return r0;
    }

    public static float[] calculatePathBoundsArray(Path r4) {
        RectF r0 = new RectF();
        r4.computeBounds(r0, true);
        return new float[]{r0.left, r0.top, r0.width(), r0.height()};
    }

    public static int clampOpacity(float r1) {
        return Math.max(0, Math.min((int) (r1 * 256.0f), 255));
    }

    public static Paint d(StrokePaintModel r10) {
        Paint r0 = new Paint();
        r0.setStyle(Paint.Style.STROKE);
        r0.setTypeface(Typeface.DEFAULT);
        r0.setFlags(193);
        int r1 = 0;
        r0.setHinting(0);
        if (r10 == null) goto L40;
        r0.setColor(getColorWithOpacity(r10.mColor, r10.mOpacity));
        r0.setStrokeWidth(r10.mWith);
        int r2 = r10.mStrokeLineCap;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L12;
        r0.setStrokeCap(Paint.Cap.SQUARE);
    L12:
        int r3 = r10.mStrokeLineJoin;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 != 2) goto L20;
        r0.setStrokeJoin(Paint.Join.BEVEL);
    L20:
        r0.setStrokeMiter(r10.mStrokeMiterLimit);
        float[] r4 = r10.mStrokeDashArray;
        if (r4 != null) goto L23;
    L39:
        r0.setPathEffect(null);
        goto L40
    L23:
        if (r4.length == 0) goto L39;
        int r5 = r4.length;
        if ((r5 % 2) != 0) goto L28;
        int r6 = r5;
    L29:
        float[] r7 = new float[r6];
        float r8 = 0.0f;
    L30:
        if (r1 >= r6) goto L33;
        float r9 = r4[r1 % r5];
        r7[r1] = r9;
        r8 = r8 + r9;
        r1 = r1 + 1;
        goto L30
    L33:
        if (r8 != 0.0f) goto L35;
        r0.setPathEffect(null);
        goto L40
    L35:
        float r11 = r10.mStrokeDashOffset;
        if (r11 >= 0.0f) goto L38;
        r11 = (r11 % r8) + r8;
    L38:
        r0.setPathEffect(new DashPathEffect(r7, r11));
        goto L40
    L28:
        r6 = r5 * 2;
        goto L29
    L18:
        r0.setStrokeJoin(Paint.Join.ROUND);
        goto L20
    L19:
        r0.setStrokeJoin(Paint.Join.MITER);
        goto L20
    L10:
        r0.setStrokeCap(Paint.Cap.ROUND);
        goto L12
    L11:
        r0.setStrokeCap(Paint.Cap.BUTT);
    L40:
        return r0;
    }

    public void setBlendMode(int r5) {
        Canvas r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == 1) goto L7;
    L12:
        if (r5 == 0) goto L14;
        return;
    L14:
        if (this.f == false) goto L20;
        r0.restore();
        this.f = false;
        return;
    L20:
        return;
    L7:
        if (this.f == true) goto L12;
        boolean r6 = this.g;
        Paint r1 = new Paint();
        r1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        if (r6 == false) goto L11;
        r1.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(h)));
    L11:
        this.a.saveLayer(null, r1);
        this.f = true;
    }

    public void setColor(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        this.e = null;
        return;
    L6:
        this.e = r2.trim();
    }

    public void setMaskIsLuminance(boolean r1) {
        this.g = r1;
    }

    public void setResourceManager(c r1) {
        this.d = r1;
    }

    public void transform(float[] r7) {
        if (this.a == null) goto L9;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.length != 6) goto L11;
        float[] r0 = {r7[0], r7[2], r7[4], r7[1], r7[3], r7[5], 0.0f, 0.0f, 1.0f};
        Matrix r8 = new Matrix();
        r8.setValues(r0);
        this.a.concat(r8);
        return;
    L11:
        return;
    }

    public static void applyTransform(Path r5, float[] r6) {
        if (r5 == null) goto L5;
        float[] r0 = {r6[0], r6[2], r6[4], r6[1], r6[3], r6[5], 0.0f, 0.0f, 1.0f};
        Matrix r7 = new Matrix();
        r7.setValues(r0);
        r5.transform(r7);
        return;
    }

    public static float[] e(float[] r16, float[] r17) {
        float r1 = r16[0];
        float r2 = r17[0];
        float r5 = r16[2];
        float r7 = r17[1];
        float r3 = (r1 * r2) + (r5 * r7);
        float r8 = r16[1];
        float r10 = r16[3];
        float r4 = (r2 * r8) + (r7 * r10);
        float r9 = r17[2];
        float r12 = r17[3];
        float r13 = r17[4];
        float r15 = r17[5];
        return new float[]{r3, r4, (r1 * r9) + (r5 * r12), (r9 * r8) + (r12 * r10), ((r1 * r13) + (r5 * r15)) + r16[4], ((r8 * r13) + (r10 * r15)) + r16[5]};
    }

    public static int getColorWithOpacity(long r5, float r7) {
        int r8 = Math.round(((int) ((r5 >> 24) & 255)) * r7);
        if (r8 >= 0) goto L5;
        int r9 = 0;
    L7:
        return (r9 << 24) | ((int) (r5 & 16777215));
    L5:
        r9 = Math.min(r8, 255);
        goto L7
    }

    public void clipPath(Path r2, int r3) {
        if (this.a == null) goto L11;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r3 != 1) goto L8;
        r2.setFillType(Path.FillType.EVEN_ODD);
    L9:
        this.a.clipPath(r2);
        return;
    L8:
        r2.setFillType(Path.FillType.WINDING);
        goto L9
    }

    public Picture renderPicture(String r11, Rect r12) {
        Picture r0 = new Picture();
        this.a = r0.beginRecording(r12.width(), r12.height());
        SVGRenderEngine r2 = this.c;
        if (r2 == null) goto L5;
        float r5 = r12.left;
        float r6 = r12.top;
        float r7 = r12.width();
        float r8 = r12.height();
        r2.getClass();
        r2.render(this, r11, r5, r6, r7, r8, getColor());
    L5:
        r0.endRecording();
        return r0;
    }

    public void translate(float r2, float r3) {
        Canvas r0 = this.a;
        if (r0 == null) goto L6;
        r0.translate(r2, r3);
        return;
    }

    public static Paint b(LinearGradientModel r18, Path r19, PaintRef r20) {
        int r2 = r18.mStopModels.length;
        Paint r3 = null;
        if (r2 != 0) goto L6;
        return null;
    L6:
        if ((r20 instanceof FillPaintModel) == false) goto L9;
        r3 = a((FillPaintModel) r20);
    L11:
        r3.setAlpha(clampOpacity(r20.mOpacity));
        float[] r10 = new float[r2];
        int[] r9 = new int[r2];
        float r4 = -1.0f;
        int r5 = 0;
    L12:
        if (r5 >= r2) goto L21;
        StopModel r6 = r18.mStopModels[r5];
        float r7 = r6.mOffset;
        if (r5 != 0) goto L16;
    L19:
        r10[r5] = r7;
        r4 = r7;
    L20:
        r9[r5] = getColorWithOpacity(r6.mColor, r6.mStopOpacity);
        r5 = r5 + 1;
        goto L12
    L16:
        if (r7 >= r4) goto L19;
        r10[r5] = r4;
        goto L20
    L21:
        float r8 = r18.mX1;
        float r11 = r18.mY1;
        float r12 = r18.mX2;
        float r13 = r18.mY2;
        RectF r14 = new RectF();
        r19.computeBounds(r14, true);
        if (r18.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L24;
        float r15 = r14.left;
        float r16 = r14.top;
        float r17 = r14.width();
        float r110 = r14.height();
        r8 = (r8 * r17) + r15;
        float r21 = (r11 * r110) + r16;
        float r22 = r15 + (r12 * r17);
        float r111 = r16 + (r13 * r110);
        float r23 = r21;
        float r24 = r22;
        float r25 = r111;
    L25:
        float r26 = r8;
        if (r26 == r24) goto L28;
    L29:
        if (r2 != 1) goto L32;
    L30:
        r3.setColor(r9[r2 - 1]);
        return r3;
    L32:
        Shader.TileMode r27 = Shader.TileMode.CLAMP;
        int r28 = r18.mSpreadMode;
        if (r28 != GradientModel.GRADIENT_SPREAD_REFLECT) goto L36;
        r27 = Shader.TileMode.MIRROR;
    L38:
        LinearGradient r29 = new LinearGradient(r26, r23, r24, r25, r9, r10, r27);
        float[] r30 = r18.mTransform;
        if (r30 != null) goto L41;
    L52:
        r3.setShader(r29);
        return r3;
    L41:
        if (r18.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L51;
        float r0 = r14.left;
        float r31 = r14.top;
        float r112 = r14.width();
        float r113 = r14.height();
        if (r30.length != 6) goto L51;
        if (r112 == 0.0f) goto L51;
        if (r113 == 0.0f) goto L51;
        float[] r32 = {1.0f / r112, 0.0f, 0.0f, 1.0f / r113, (-r0) / r112, (-r31) / r113};
        r30 = e(e(new float[]{r112, 0.0f, 0.0f, r113, r0, r31}, r30), r32);
    L51:
        Matrix r1 = new Matrix();
        r1.setValues(new float[]{r30[0], r30[2], r30[4], r30[1], r30[3], r30[5], 0.0f, 0.0f, 1.0f});
        r29.setLocalMatrix(r1);
        goto L52
    L36:
        if (r28 != GradientModel.GRADIENT_SPREAD_REPEAT) goto L38;
        r27 = Shader.TileMode.REPEAT;
        goto L38
    L28:
        if (r23 == r25) goto L30;
    L24:
        r25 = r13;
        r24 = r12;
        r23 = r11;
        goto L25
    L9:
        if ((r20 instanceof StrokePaintModel) == false) goto L11;
        r3 = d((StrokePaintModel) r20);
        goto L11
    }

    public static Paint c(RadialGradientModel r26, Path r27, PaintRef r28) {
        int r2 = r26.mStopModels.length;
        Paint r3 = null;
        if (r2 != 0) goto L6;
        return null;
    L6:
        if ((r28 instanceof FillPaintModel) == false) goto L9;
        r3 = a((FillPaintModel) r28);
    L11:
        r3.setAlpha(clampOpacity(r28.mOpacity));
        float[] r9 = new float[r2];
        int[] r8 = new int[r2];
        float r4 = -1.0f;
        int r5 = 0;
    L12:
        if (r5 >= r2) goto L21;
        StopModel r6 = r26.mStopModels[r5];
        float r7 = r6.mOffset;
        if (r5 != 0) goto L16;
    L19:
        r9[r5] = r7;
        r4 = r7;
    L20:
        r8[r5] = getColorWithOpacity(r6.mColor, r6.mStopOpacity);
        r5 = r5 + 1;
        goto L12
    L16:
        if (r7 >= r4) goto L19;
        r9[r5] = r4;
        goto L20
    L21:
        RectF r11 = new RectF();
        r27.computeBounds(r11, true);
        Shader.TileMode r10 = Shader.TileMode.CLAMP;
        int r12 = r26.mSpreadMode;
        if (r12 != GradientModel.GRADIENT_SPREAD_REFLECT) goto L25;
        r10 = Shader.TileMode.MIRROR;
    L27:
        Shader.TileMode r13 = r10;
        float[] r14 = r26.mTransform;
        if (r26.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L47;
        float r24 = r11.width();
        float r25 = r11.height();
        if (r24 != 0.0f) goto L32;
    L45:
        r3.setColor(r8[r2 - 1]);
        return r3;
    L32:
        if (r25 == 0.0f) goto L45;
        float r15 = r26.mFr;
        if (r15 == 0.0f) goto L43;
        if (r2 == 1) goto L43;
        RadialGradient r16 = new RadialGradient(r26.mCx, r26.mCy, r15, r8, r9, r13);
        Matrix r0 = new Matrix();
        r0.setValues(new float[]{r24, 0.0f, r11.left, 0.0f, r25, r11.top, 0.0f, 0.0f, 1.0f});
        if (r14 == null) goto L41;
        Matrix r17 = new Matrix();
        r17.setValues(new float[]{r14[0], r14[2], r14[4], r14[1], r14[3], r14[5], 0.0f, 0.0f, 1.0f});
        r0.preConcat(r17);
    L41:
        r16.setLocalMatrix(r0);
        r3.setShader(r16);
        return r3;
    L43:
        r3.setColor(r8[r2 - 1]);
        return r3;
    L47:
        float r18 = r26.mFr;
        if (r18 == 0.0f) goto L56;
        if (r2 == 1) goto L56;
        RadialGradient r19 = new RadialGradient(r26.mCx, r26.mCy, r18, r8, r9, r13);
        if (r14 == null) goto L54;
        Matrix r1 = new Matrix();
        r1.setValues(new float[]{r14[0], r14[2], r14[4], r14[1], r14[3], r14[5], 0.0f, 0.0f, 1.0f});
        r19.setLocalMatrix(r1);
    L54:
        r3.setShader(r19);
        return r3;
    L56:
        r3.setColor(r8[r2 - 1]);
        return r3;
    L25:
        if (r12 != GradientModel.GRADIENT_SPREAD_REPEAT) goto L27;
        r10 = Shader.TileMode.REPEAT;
        goto L27
    L9:
        if ((r28 instanceof StrokePaintModel) == false) goto L11;
        r3 = d((StrokePaintModel) r28);
        goto L11
    }

    public void addGradientModel(String r4, String r5, GradientModel r6) {
        this.b.put("#" + r4, new Pair(r5, r6));
    }

    public void draw(Path r9, FillPaintModel r10, StrokePaintModel r11) {
        Canvas r0 = this.a;
        if (r0 == null) goto L65;
        if (r9 == null) goto L66;
        boolean r1 = false;
        Matrix r2 = null;
        if (r10 != null) goto L8;
        Paint r12 = new Paint();
        r12.setStyle(Paint.Style.FILL);
        r12.setTypeface(Typeface.DEFAULT);
        r12.setFlags(193);
        r12.setHinting(0);
        r0.drawPath(r9, r12);
    L31:
        Canvas r13 = this.a;
        if (r11 == null) goto L67;
        int r3 = r11.mType;
        if (r3 != 2) goto L44;
        Pair<String, GradientModel> r4 = this.b.get(r11.mIri);
        if (r4 == null) goto L40;
        Object r5 = r4.second;
        if ((r5 instanceof LinearGradientModel) == false) goto L40;
        Paint r6 = b((LinearGradientModel) r5, r9, r11);
    L47:
        if (r6 != null) goto L49;
        return;
    L49:
        if (r11.mVectorEffect != 1) goto L63;
        Matrix r14 = r13.getMatrix();
        Path r7 = new Path();
        r9.transform(r14, r7);
        Shader r15 = r6.getShader();
        if (r15 == null) goto L57;
        r2 = new Matrix();
        r1 = r15.getLocalMatrix(r2);
        if (r1 == false) goto L55;
        Matrix r8 = new Matrix(r2);
    L56:
        r8.postConcat(r14);
        r15.setLocalMatrix(r8);
        goto L57
    L55:
        r8 = new Matrix();
    L57:
        r13.save();
        r13.setMatrix(new Matrix());
        r13.drawPath(r7, r6);
        r13.restore();
        if (r15 == null) goto L69;
        if (r1 == true) goto L62;
        r2 = new Matrix();
    L62:
        r15.setLocalMatrix(r2);
        return;
    L69:
        return;
    L63:
        r13.drawPath(r9, r6);
        return;
    L40:
        if (r4 == null) goto L46;
        Object r16 = r4.second;
        if ((r16 instanceof RadialGradientModel) == false) goto L46;
        r6 = c((RadialGradientModel) r16, r9, r11);
    L46:
        r6 = null;
        goto L47
    L44:
        if (r3 != 1) goto L46;
        r6 = d(r11);
        goto L47
    L67:
        return;
    L8:
        if (r10.mFillRule != 1) goto L10;
        r9.setFillType(Path.FillType.EVEN_ODD);
    L11:
        int r17 = r10.mType;
        if (r17 != 2) goto L28;
        if (r17 != 2) goto L31;
        if (TextUtils.isEmpty(r10.mIri) == true) goto L31;
        Pair<String, GradientModel> r18 = this.b.get(r10.mIri);
        if (r18 == null) goto L21;
        Object r19 = r18.second;
        if ((r19 instanceof LinearGradientModel) == false) goto L21;
        Paint r110 = b((LinearGradientModel) r19, r9, r10);
    L26:
        if (r110 == null) goto L31;
        r0.drawPath(r9, r110);
    L21:
        if (r18 == null) goto L25;
        Object r20 = r18.second;
        if ((r20 instanceof RadialGradientModel) == false) goto L25;
        r110 = c((RadialGradientModel) r20, r9, r10);
    L25:
        r110 = null;
        goto L26
    L28:
        if (r17 != 1) goto L31;
        r0.drawPath(r9, a(r10));
        goto L31
    L10:
        r9.setFillType(Path.FillType.WINDING);
        goto L11
    L66:
        return;
    }

    public void clipRect(float r2, float r3, float r4, float r5) {
        Canvas r0 = this.a;
        if (r0 == null) goto L6;
        r0.clipRect(r2, r3, r4, r5);
        return;
    }

    public void drawText(SpannableStringBuilder r12, int r13, float r14, float r15) {
        TextPaint r2 = new TextPaint();
        r2.setAntiAlias(true);
        BoringLayout.Metrics r9 = BoringLayout.isBoring(r12, r2);
        if (r9 != null) goto L14;
        StaticLayout r10 = new StaticLayout(r12, r2, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int r16 = r10.getWidth();
        if (r13 != 1) goto L8;
        r16 = r16 / 2;
    L7:
        r14 = r14 - r16;
    L11:
        if (r10.getLineCount() <= 0) goto L13;
        this.a.translate(r14, r15 + ((r10.getLineAscent(0) - r10.getLineDescent(0)) / 2));
    L13:
        r10.draw(this.a);
        return;
    L8:
        if (r13 != 2) goto L11;
    L14:
        BoringLayout r17 = BoringLayout.make(r12, r2, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, r9, false);
        if (r13 != 1) goto L18;
        int r18 = r9.width / 2;
    L17:
        r14 = r14 - r18;
    L20:
        this.a.translate(r14, r15 + ((r9.ascent - r9.descent) / 2));
        r17.draw(this.a);
        return;
    L18:
        if (r13 != 2) goto L20;
        r18 = r9.width;
        goto L17
    }

    public void saveLayer(float r5, float r6, float r7, float r8) {
        Canvas r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == 0.0f) goto L7;
    L13:
        RectF r1 = new RectF(r5, r6, r7, r8);
        this.a.saveLayer(r1, null);
        return;
    L7:
        if (r6 != 0.0f) goto L13;
        if (r7 != 0.0f) goto L13;
        if (r8 != 0.0f) goto L13;
        r0.saveLayer(null, null);
    }

    public void drawImage(String r13, float r14, float r15, float r16, float r17, int r18, int r19, int r20) {
        if (TextUtils.isEmpty(r13) == true) goto L10;
        c r10 = this.d;
        if (r10 == null) goto L11;
        r10.a(r13, new a(this, r16, r17, r14, r15, r18, r19, r20));
        return;
    L11:
        return;
    }
}
