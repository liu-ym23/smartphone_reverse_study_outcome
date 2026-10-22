package com.lynx.serval.svg;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
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
import android.util.Log;
import androidx.core.util.Pair;
import com.lynx.serval.svg.model.FillPaintModel;
import com.lynx.serval.svg.model.GradientModel;
import com.lynx.serval.svg.model.LinearGradientModel;
import com.lynx.serval.svg.model.PaintRef;
import com.lynx.serval.svg.model.RadialGradientModel;
import com.lynx.serval.svg.model.StopModel;
import com.lynx.serval.svg.model.StrokePaintModel;
import java.util.HashMap;
import lm.e;
import rm.a;
import rm.b;
import td.d;
import w8.f;

/* JADX INFO: loaded from: classes2.dex */
public class SVGRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f9951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f9952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SVGRenderEngine f9953c;
    public b d;

    public SVGRender() {
        this.f9953c = SVGRenderEngine.getInstance();
        this.f9952b = new HashMap();
    }

    public static void applyTransform(Path r13, float[] r14) {
        if (r13 == null) goto L6;
        float[] r12 = {r14[0], r14[2], r14[4], r14[1], r14[3], r14[5], 0.0f, 0.0f, 1.0f};
        Matrix r15 = new Matrix();
        r15.setValues(r12);
        r13.transform(r15);
        return;
    }

    public static float[] calculatePathBoundsArray(Path r10) {
        RectF r5 = new RectF();
        r10.computeBounds(r5, true);
        return new float[]{r5.left, r5.top, r5.width(), r5.height()};
    }

    public static int clampOpacity(float r5) {
        return Math.max(0, Math.min((int) (r5 * 256.0f), 255));
    }

    public static int getColorWithOpacity(long r5, float r10) {
        int r11 = Math.round(((int) ((r5 >> 24) & 255)) * r10);
        if (r11 >= 0) goto L5;
        int r12 = 0;
    L7:
        return ((int) (r5 & 16777215)) | (r12 << 24);
    L5:
        r12 = Math.min(r11, 255);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Canvas r18, Path r19, PaintRef r20) {
        if (r20.mType == 2) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r20.mIri) == true) goto L94;
        Pair r5 = (Pair) this.f9952b.get(r20.mIri);
        float r10 = -1.0f;
        int r11 = 0;
        Paint r12 = null;
        if (r5 == null) goto L46;
        S r13 = r5.second;
        if ((r13 instanceof LinearGradientModel) == false) goto L46;
        LinearGradientModel r14 = (LinearGradientModel) r13;
        int r15 = r14.mStopModels.length;
        if (r15 != 0) goto L14;
    L84:
        if (r12 == null) goto L95;
        r18.drawPath(r19, r12);
        return;
    L95:
        return;
    L14:
        if ((r20 instanceof FillPaintModel) == false) goto L17;
        FillPaintModel r16 = (FillPaintModel) r20;
        Paint r17 = new Paint();
        r17.setStyle(Paint.Style.FILL);
        r17.setTypeface(Typeface.DEFAULT);
        r17.setFlags(193);
        r17.setHinting(0);
        r17.setColor(getColorWithOpacity(r16.mColor, r16.mOpacity));
        r12 = r17;
    L19:
        r12.setAlpha(clampOpacity(r20.mOpacity));
        float[] r110 = new float[r15];
        int[] r111 = new int[r15];
    L20:
        if (r11 >= r15) goto L29;
        StopModel r21 = r14.mStopModels[r11];
        float r22 = r21.mOffset;
        if (r11 != 0) goto L24;
    L27:
        r110[r11] = r22;
        r10 = r22;
    L28:
        r111[r11] = getColorWithOpacity(r21.mColor, r21.mStopOpacity);
        r11 = r11 + 1;
        goto L20
    L24:
        if (r22 >= r10) goto L27;
        r110[r11] = r10;
        goto L28
    L29:
        float r23 = r14.mX1;
        float r24 = r14.mY1;
        float r25 = r14.mX2;
        float r26 = r14.mY2;
        RectF r27 = new RectF();
        r19.computeBounds(r27, true);
        if (r14.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L32;
        float r112 = r27.left;
        float r113 = r27.top;
        float r114 = r27.width();
        float r28 = r27.height();
        r23 = (r23 * r114) + r112;
        r24 = (r24 * r28) + r113;
        r25 = (r25 * r114) + r112;
        r26 = (r26 * r28) + r113;
    L32:
        float r115 = r23;
        float r116 = r24;
        float r117 = r25;
        float r118 = r26;
        if (r115 == r117) goto L35;
    L36:
        if (r15 != 1) goto L38;
    L37:
        r12.setColor(r111[r15 - 1]);
        goto L84
    L38:
        Shader.TileMode r29 = Shader.TileMode.CLAMP;
        int r30 = r14.mSpreadMode;
        if (r30 != GradientModel.GRADIENT_SPREAD_REFLECT) goto L43;
        r29 = Shader.TileMode.MIRROR;
    L45:
        r12.setShader(new LinearGradient(r115, r116, r117, r118, r111, r110, r29));
        goto L84
    L43:
        if (r30 != GradientModel.GRADIENT_SPREAD_REPEAT) goto L45;
        r29 = Shader.TileMode.REPEAT;
        goto L45
    L35:
        if (r116 == r118) goto L37;
    L17:
        if ((r20 instanceof StrokePaintModel) == false) goto L19;
        r12 = a((StrokePaintModel) r20);
    L46:
        if (r5 == null) goto L84;
        S r31 = r5.second;
        if ((r31 instanceof RadialGradientModel) == false) goto L84;
        RadialGradientModel r32 = (RadialGradientModel) r31;
        int r33 = r32.mStopModels.length;
        if (r33 == 0) goto L84;
        if ((r20 instanceof FillPaintModel) == false) goto L56;
        FillPaintModel r34 = (FillPaintModel) r20;
        Paint r35 = new Paint();
        r35.setStyle(Paint.Style.FILL);
        r35.setTypeface(Typeface.DEFAULT);
        r35.setFlags(193);
        r35.setHinting(0);
        r35.setColor(getColorWithOpacity(r34.mColor, r34.mOpacity));
        r12 = r35;
    L58:
        r12.setAlpha(clampOpacity(r20.mOpacity));
        float[] r119 = new float[r33];
        int[] r120 = new int[r33];
    L59:
        if (r11 >= r33) goto L68;
        StopModel r36 = r32.mStopModels[r11];
        float r37 = r36.mOffset;
        if (r11 != 0) goto L63;
    L66:
        r119[r11] = r37;
        r10 = r37;
    L67:
        r120[r11] = getColorWithOpacity(r36.mColor, r36.mStopOpacity);
        r11 = r11 + 1;
        goto L59
    L63:
        if (r37 >= r10) goto L66;
        r119[r11] = r10;
        goto L67
    L68:
        RectF r38 = new RectF();
        r19.computeBounds(r38, true);
        float r39 = r32.mFr;
        float r40 = r32.mCx;
        float r41 = r32.mCy;
        if (r32.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L71;
        float r42 = Math.max(r38.width(), r38.height());
        r39 = r39 * r42;
        float r43 = r40 * r42;
        r40 = r43 + r38.left;
        float r44 = r41 * r42;
        r41 = r44 + r38.top;
    L71:
        float r121 = r39;
        float r122 = r40;
        float r123 = r41;
        if (r121 == 0.0f) goto L83;
        if (r33 == 1) goto L83;
        Shader.TileMode r45 = Shader.TileMode.CLAMP;
        int r46 = r32.mSpreadMode;
        if (r46 != GradientModel.GRADIENT_SPREAD_REFLECT) goto L80;
        r45 = Shader.TileMode.MIRROR;
    L82:
        r12.setShader(new RadialGradient(r122, r123, r121, r120, r119, r45));
        goto L84
    L80:
        if (r46 != GradientModel.GRADIENT_SPREAD_REPEAT) goto L82;
        r45 = Shader.TileMode.REPEAT;
    L83:
        r12.setColor(r120[r33 - 1]);
        goto L84
    L56:
        if ((r20 instanceof StrokePaintModel) == false) goto L58;
        r12 = a((StrokePaintModel) r20);
        goto L58
    }

    public void addGradientModel(String r5, String r10, GradientModel r11) {
        this.f9952b.put(d.b("#", r5), new Pair(r10, r11));
    }

    public void clipPath(Path r5, int r10) {
        if (this.f9951a == null) goto L11;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r10 != 1) goto L8;
        r5.setFillType(Path.FillType.EVEN_ODD);
    L9:
        this.f9951a.clipPath(r5);
        return;
    L8:
        r5.setFillType(Path.FillType.WINDING);
        goto L9
    }

    public void draw(Path r10, FillPaintModel r11, StrokePaintModel r12) {
        Canvas r5 = this.f9951a;
        if (r5 == null) goto L26;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r11 != null) goto L8;
        Paint r13 = new Paint();
        r13.setStyle(Paint.Style.FILL);
        r13.setTypeface(Typeface.DEFAULT);
        r13.setFlags(193);
        r13.setHinting(0);
        r5.drawPath(r10, r13);
    L17:
        Canvas r14 = this.f9951a;
        if (r12 == null) goto L28;
        int r15 = r12.mType;
        if (r15 != 2) goto L23;
        a(r14, r10, r12);
        return;
    L23:
        if (r15 != 1) goto L29;
        r14.drawPath(r10, a(r12));
        return;
    L29:
        return;
    L28:
        return;
    L8:
        if (r11.mFillRule != 1) goto L10;
        r10.setFillType(Path.FillType.EVEN_ODD);
    L11:
        int r16 = r11.mType;
        if (r16 != 2) goto L14;
        a(r5, r10, r11);
        goto L17
    L14:
        if (r16 != 1) goto L17;
        Paint r17 = new Paint();
        r17.setStyle(Paint.Style.FILL);
        r17.setTypeface(Typeface.DEFAULT);
        r17.setFlags(193);
        r17.setHinting(0);
        r17.setColor(getColorWithOpacity(r11.mColor, r11.mOpacity));
        r5.drawPath(r10, r17);
        goto L17
    L10:
        r10.setFillType(Path.FillType.WINDING);
        goto L11
    }

    public void drawImage(String r13, float r14, float r15, float r16, float r17, int r18, int r19, int r20) {
        if (TextUtils.isEmpty(r13) == true) goto L9;
        b r10 = this.d;
        if (r10 == null) goto L10;
        a r11 = new a(this, r16, r17, r14, r15, r18, r19, r20);
        ((e) ((f) r10).f22816a).f19681b.f9726c.r(r13, new ug.e(r11, 10));
        return;
    L10:
        return;
    }

    public void drawText(SpannableStringBuilder r12, int r13, float r14, float r15) {
        TextPaint r5 = new TextPaint();
        r5.setAntiAlias(true);
        BoringLayout.Metrics r10 = BoringLayout.isBoring(r12, r5);
        if (r10 != null) goto L15;
        StaticLayout r11 = new StaticLayout(r12, r5, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int r16 = r11.getWidth();
        if (r13 != 1) goto L8;
        r16 = r16 / 2;
    L7:
        r14 = r14 - r16;
    L11:
        if (r11.getLineCount() <= 0) goto L13;
        this.f9951a.translate(r14, r15 + ((r11.getLineAscent(0) - r11.getLineDescent(0)) / 2));
    L13:
        r11.draw(this.f9951a);
        return;
    L8:
        if (r13 != 2) goto L11;
    L15:
        BoringLayout r17 = BoringLayout.make(r12, r5, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, r10, false);
        if (r13 != 1) goto L19;
        int r18 = r10.width / 2;
    L18:
        r14 = r14 - r18;
    L21:
        this.f9951a.translate(r14, r15 + ((r10.ascent - r10.descent) / 2));
        r17.draw(this.f9951a);
        return;
    L19:
        if (r13 != 2) goto L21;
        r18 = r10.width;
        goto L18
    }

    public Picture renderPicture(String r10, Rect r11) {
        Picture r5 = new Picture();
        this.f9951a = r5.beginRecording(r11.width(), r11.height());
        SVGRenderEngine r12 = this.f9953c;
        if (r12 == null) goto L5;
        r12.render(this, r10, r11.left, r11.top, r11.width(), r11.height());
    L5:
        r5.endRecording();
        return r5;
    }

    public void restore() {
        Canvas r5 = this.f9951a;
        if (r5 == null) goto L6;
        r5.restore();
        return;
    }

    public void save() {
        Canvas r5 = this.f9951a;
        if (r5 == null) goto L6;
        r5.save();
        return;
    }

    public void setResourceManager(b r5) {
        this.d = r5;
    }

    public void setViewBox(float r5, float r10, float r11, float r12) {
        Log.i("SrSVGRender", "setViewBox: " + r5 + ", " + r10 + ", " + r11 + ", " + r12);
    }

    public void transform(float[] r15) {
        if (this.f9951a == null) goto L9;
        if (r15 != null) goto L6;
        return;
    L6:
        if (r15.length != 6) goto L11;
        float[] r13 = {r15[0], r15[2], r15[4], r15[1], r15[3], r15[5], 0.0f, 0.0f, 1.0f};
        Matrix r16 = new Matrix();
        r16.setValues(r13);
        this.f9951a.concat(r16);
        return;
    L11:
        return;
    }

    public void translate(float r5, float r10) {
        Canvas r11 = this.f9951a;
        if (r11 == null) goto L6;
        r11.translate(r5, r10);
        return;
    }

    public static Paint a(StrokePaintModel r10) {
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.STROKE);
        r5.setTypeface(Typeface.DEFAULT);
        r5.setFlags(193);
        int r11 = 0;
        r5.setHinting(0);
        if (r10 == null) goto L42;
        r5.setColor(getColorWithOpacity(r10.mColor, r10.mOpacity));
        r5.setStrokeWidth(r10.mWith);
        int r12 = r10.mStrokeLineCap;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L12;
        r5.setStrokeCap(Paint.Cap.SQUARE);
    L12:
        int r13 = r10.mStrokeLineJoin;
        if (r13 == 0) goto L19;
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L20;
        r5.setStrokeJoin(Paint.Join.BEVEL);
    L20:
        r5.setStrokeMiter(r10.mStrokeMiterLimit);
        float[] r14 = r10.mStrokeDashArray;
        if (r14 != null) goto L23;
    L41:
        r5.setPathEffect(null);
        goto L42
    L23:
        if (r14.length == 0) goto L41;
        int r15 = r14.length;
        if ((r15 % 2) != 0) goto L28;
        int r16 = r15;
    L29:
        float[] r17 = new float[r16];
        float r18 = 0.0f;
    L30:
        if (r11 >= r16) goto L33;
        float r19 = r14[r11 % r15];
        r17[r11] = r19;
        r18 = r18 + r19;
        r11 = r11 + 1;
        goto L30
    L33:
        if (r18 != 0.0f) goto L36;
        r5.setPathEffect(null);
        return r5;
    L36:
        float r110 = r10.mStrokeDashOffset;
        if (r110 >= 0.0f) goto L39;
        r110 = (r110 % r18) + r18;
    L39:
        r5.setPathEffect(new DashPathEffect(r17, r110));
        return r5;
    L28:
        r16 = r15 * 2;
        goto L29
    L18:
        r5.setStrokeJoin(Paint.Join.ROUND);
        goto L20
    L19:
        r5.setStrokeJoin(Paint.Join.MITER);
        goto L20
    L10:
        r5.setStrokeCap(Paint.Cap.ROUND);
        goto L12
    L11:
        r5.setStrokeCap(Paint.Cap.BUTT);
    L42:
        return r5;
    }
}
