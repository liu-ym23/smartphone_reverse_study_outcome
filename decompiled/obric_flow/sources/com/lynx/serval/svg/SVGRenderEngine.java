package com.lynx.serval.svg;

import android.graphics.Matrix;
import android.graphics.Path;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.lynx.serval.svg.model.FillPaintModel;
import com.lynx.serval.svg.model.LinearGradientModel;
import com.lynx.serval.svg.model.RadialGradientModel;
import com.lynx.serval.svg.model.StopModel;
import com.lynx.serval.svg.model.StrokePaintModel;
import kk.a;

/* JADX INFO: loaded from: classes2.dex */
public class SVGRenderEngine {
    public static final String CIRCLE = "circle";
    public static final String CLIP_PATH = "clipPath";
    public static final String DRAW = "draw";
    public static final String ELLIPSE = "ellipse";
    public static final String IMAGE = "image";
    public static final int JNI_OK = 0;
    public static final String LINE = "line";
    public static final String LINEAR_GRADIENT = "linearGradient";
    public static final String PATH = "path";
    public static final String POLYGON = "polygon";
    public static final String POLYLINE = "polyline";
    public static final String RADIAL_GRADIENT = "radialGradient";
    public static final String RECT = "rect";
    public static final String RESTORE = "restore";
    public static final String SAVE = "save";
    public static final String SVG = "svg";
    public static final String TAG = "SrSVGRenderEngine";
    public static final String TRANSLATE = "translate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f9954a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SVGRenderEngine f9955b;

    public SVGRenderEngine() {
        if (f9954a == true) goto L13;
        System.loadLibrary("serval_svg");     // Catch: UnsatisfiedLinkError -> L8
        Log.i(TAG, "Loading native library successfully");
        f9954a = true;
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Loading native library fail: " + e.getMessage());
        return;
    }

    public static void appendSpan(SpannableStringBuilder r5, String r10, int r11, float r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        int r13 = r10.length();
        SpannableString r14 = new SpannableString(r10);
        r14.setSpan(new ForegroundColorSpan(r11), 0, r13, 33);
        r14.setSpan(new AbsoluteSizeSpan((int) r12, true), 0, r13, 33);
        r5.append(r14);
    }

    public static SVGRenderEngine getInstance() {
        if (f9955b != null) goto L16;
        monitor-enter(SVGRenderEngine.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f9955b != null) goto L11;
        f9955b = new SVGRenderEngine();     // Catch: Throwable -> L9
    L11:
        monitor-exit(SVGRenderEngine.class);     // Catch: Throwable -> L9
    L16:
        return f9955b;
    }

    public static void layout(float r5) {
    }

    public static Path makeCirclePath(float r17, float r18, float r19) {
        float r10 = r17 - r19;
        float r11 = r18 - r19;
        float r12 = r17 + r19;
        float r13 = r18 + r19;
        float r14 = r19 * 0.5522848f;
        Path r15 = new Path();
        r15.moveTo(r12, r18);
        float r16 = r18 + r14;
        float r110 = r17 + r14;
        r15.cubicTo(r12, r16, r110, r13, r17, r13);
        float r111 = r17 - r14;
        r15.cubicTo(r111, r13, r10, r16, r10, r18);
        float r112 = r18 - r14;
        r15.cubicTo(r10, r112, r111, r11, r17, r11);
        r15.cubicTo(r110, r11, r12, r112, r12, r18);
        r15.close();
        return r15;
    }

    public static Path makeEllipsePath(float r17, float r18, float r19, float r20) {
        float r10 = r17 - r19;
        float r11 = r18 - r20;
        float r12 = r17 + r19;
        float r13 = r18 + r20;
        float r14 = r19 * 0.5522848f;
        float r15 = r20 * 0.5522848f;
        Path r16 = new Path();
        r16.moveTo(r17, r11);
        float r110 = r17 + r14;
        float r111 = r18 - r15;
        r16.cubicTo(r110, r11, r12, r111, r12, r18);
        float r112 = r18 + r15;
        r16.cubicTo(r12, r112, r110, r13, r17, r13);
        float r113 = r17 - r14;
        r16.cubicTo(r113, r13, r10, r112, r10, r18);
        r16.cubicTo(r10, r111, r113, r11, r17, r11);
        r16.close();
        return r16;
    }

    public static FillPaintModel makeFillPaintModel(int r10, String r11, long r12, int r13, float r14) {
        return new FillPaintModel(r10, r11, r12, r14, r13);
    }

    public static Path makeLinePath(float r5, float r10, float r11, float r12) {
        Path r13 = new Path();
        r13.moveTo(r5, r10);
        r13.lineTo(r11, r12);
        return r13;
    }

    public static void makeLinearGradient(SVGRender r5, String r10, String r11, int r12, float r13, float r14, float r15, float r16, int r17, StopModel[] r18) {
        if (r5 == null) goto L5;
        LinearGradientModel r19 = new LinearGradientModel();
        r19.mType = r17;
        r19.mTransform = r11;
        r19.mStopModels = r18;
        r19.mX1 = r13;
        r19.mX2 = r14;
        r19.mY1 = r15;
        r19.mY2 = r16;
        r19.mSpreadMode = r12;
        r5.addGradientModel(r10, LINEAR_GRADIENT, r19);
        return;
    }

    public static Path makeMutablePath() {
        return new Path();
    }

    public static Path makePath(byte[] r41, float[] r42) {
        Path r10 = new Path();
        int r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r41.length) goto L86;
        byte r12 = r41[r11];
        if (r12 == 0) goto L83;
        boolean r13 = true;
        if (r12 != 1) goto L10;
        r10 = r10;
        r11 = r11;
        int r14 = r5 + 1;
        float r15 = r42[r5];
        r5 = r5 + 2;
        r10.lineTo(r15, r42[r14]);
    L84:
        r11 = r11 + 1;
        r10 = r10;
        goto L4
    L10:
        if (r12 != 2) goto L12;
        r10 = r10;
        r11 = r11;
        r10.cubicTo(r42[r5], r42[r5 + 1], r42[r5 + 2], r42[r5 + 3], r42[r5 + 4], r42[r5 + 5]);
        r5 = r5 + 6;
        goto L84
    L12:
        if (r12 != 3) goto L14;
        r10 = r10;
        r11 = r11;
        float r16 = r42[r5];
        float r17 = r42[r5 + 1];
        int r18 = r5 + 3;
        float r19 = r42[r5 + 2];
        r5 = r5 + 4;
        r10.quadTo(r16, r17, r19, r42[r18]);
        goto L84
    L14:
        if (r12 == 5) goto L79;
        float r20 = r42[r5];
        float r21 = r42[r5 + 1];
        float r22 = r42[r5 + 2];
        float r23 = r42[r5 + 3];
        float r24 = r42[r5 + 4];
        int r110 = r5 + 6;
        if (((int) r42[r5 + 5]) == 0) goto L18;
        boolean r111 = true;
    L19:
        int r112 = r5 + 7;
        if (((int) r42[r110]) != 0) goto L23;
        r13 = false;
    L23:
        float r113 = r42[r112];
        int r114 = r5 + 9;
        float r25 = r42[r5 + 8];
        if (r20 != r113) goto L29;
        if (r21 != r25) goto L29;
        r10 = r10;
        r11 = r11;
        r114 = r114;
    L78:
        r5 = r114;
    L29:
        if (r22 != 0.0f) goto L31;
        float r26 = r25;
    L77:
        r10.lineTo(r113, r26);
        goto L78
    L31:
        if (r23 != 0.0f) goto L33;
        r26 = r25;
        goto L77
    L33:
        float r27 = Math.abs(r22);
        float r28 = Math.abs(r23);
        double r29 = Math.toRadians(((double) r24) % 360.0d);
        double r115 = Math.cos(r29);
        double r30 = Math.sin(r29);
        r114 = r114;
        r11 = r11;
        double r116 = ((double) (r20 - r113)) / 2.0d;
        Path r210 = r10;
        double r31 = ((double) (r21 - r25)) / 2.0d;
        double r32 = (r30 * r31) + (r115 * r116);
        double r33 = (r31 * r115) + ((-r30) * r116);
        double r117 = r27 * r27;
        double r118 = r28 * r28;
        double r211 = r32 * r32;
        double r212 = r33 * r33;
        double r34 = (r212 / r118) + (r211 / r117);
        if (r34 <= 0.99999d) goto L37;
        double r119 = Math.sqrt(r34) * 1.00001d;
        r27 = (float) (((double) r27) * r119);
        r28 = (float) (r119 * ((double) r28));
        r117 = r27 * r27;
        r118 = r28 * r28;
    L37:
        if (r111 != r13) goto L39;
        double r35 = -1.0d;
    L40:
        double r36 = r117 * r118;
        double r120 = r117 * r212;
        double r121 = r118 * r211;
        double r37 = ((r36 - r120) - r121) / (r120 + r121);
        if (r37 >= 0.0d) goto L43;
        r37 = 0.0d;
    L43:
        double r122 = Math.sqrt(r37) * r35;
        double r123 = r27;
        double r213 = r123 * r33;
        double r38 = r28;
        double r214 = (r213 / r38) * r122;
        float r124 = r27;
        float r39 = r28;
        double r125 = r122 * (-((r38 * r32) / r123));
        boolean r40 = r13;
        double r43 = ((r115 * r214) - (r30 * r125)) + (((double) (r20 + r113)) / 2.0d);
        double r44 = ((r115 * r125) + (r30 * r214)) + (((double) (r21 + r25)) / 2.0d);
        double r45 = (r32 - r214) / r123;
        double r126 = (r33 - r125) / r38;
        double r46 = ((-r32) - r214) / r123;
        double r127 = ((-r33) - r125) / r38;
        double r128 = (r126 * r126) + (r45 * r45);
        double r47 = Math.sqrt(r128);
        if (r126 >= 0.0d) goto L46;
        double r215 = -1.0d;
    L47:
        double r48 = Math.acos(r45 / r47) * r215;
        double r129 = Math.sqrt(((r127 * r127) + (r46 * r46)) * r128);
        double r310 = (r126 * r127) + (r45 * r46);
        if (((r45 * r127) - (r126 * r46)) >= 0.0d) goto L50;
        double r49 = -1.0d;
    L51:
        double r311 = r310 / r129;
        if (r311 >= (-1.0d)) goto L55;
        double r130 = 3.141592653589793d;
    L58:
        double r50 = r49 * r130;
        if (r50 != 0.0d) goto L61;
        r210.lineTo(r113, r25);
        r10 = r210;
        goto L78
    L61:
        Path r131 = r210;
        float r132 = r113;
        float r133 = r25;
        if (r40 == true) goto L65;
        if (r50 <= 0.0d) goto L65;
        r50 = r50 - 6.283185307179586d;
    L69:
        double r51 = r50 % 6.283185307179586d;
        double r52 = r48 % 6.283185307179586d;
        int r53 = (int) Math.ceil((Math.abs(r51) * 2.0d) / 3.141592653589793d);
        double r54 = r51 / ((double) r53);
        double r55 = r54 / 2.0d;
        double r134 = (Math.sin(r55) * 1.3333333333333333d) / (Math.cos(r55) + 1.0d);
        int r56 = r53 * 6;
        float[] r135 = new float[r56];
        int r136 = 0;
        int r216 = 0;
    L70:
        if (r136 >= r53) goto L72;
        float r217 = r133;
        double r137 = (((double) r136) * r54) + r52;
        double r218 = Math.cos(r137);
        double r219 = Math.sin(r137);
        double r312 = r52;
        int r57 = r53;
        r135[r216] = (float) (r218 - (r134 * r219));
        r135[r216 + 1] = (float) ((r218 * r134) + r219);
        double r138 = r137 + r54;
        double r58 = Math.cos(r138);
        double r139 = Math.sin(r138);
        r135[r216 + 2] = (float) ((r134 * r139) + r58);
        r135[r216 + 3] = (float) (r139 - (r134 * r58));
        int r59 = r216 + 5;
        r135[r216 + 4] = (float) r58;
        r216 = r216 + 6;
        r135[r59] = (float) r139;
        r136 = r136 + 1;
        r132 = r132;
        r124 = r124;
        r53 = r57;
        r133 = r217;
        r54 = r54;
        r131 = r131;
        r52 = r312;
        goto L70
    L72:
        Path r313 = r131;
        Matrix r60 = new Matrix();
        r60.postScale(r124, r39);
        r60.postRotate(r24);
        r60.postTranslate((float) r43, (float) r44);
        r60.mapPoints(r135);
        r135[r56 - 2] = r132;
        r135[r56 - 1] = r133;
        int r61 = 0;
    L73:
        if (r61 >= r56) goto L75;
        r313.cubicTo(r135[r61], r135[r61 + 1], r135[r61 + 2], r135[r61 + 3], r135[r61 + 4], r135[r61 + 5]);
        r61 = r61 + 6;
        goto L73
    L75:
        r10 = r313;
    L65:
        if (r40 == false) goto L69;
        if (r50 >= 0.0d) goto L69;
        r50 = r50 + 6.283185307179586d;
        goto L69
    L55:
        if (r311 <= 1.0d) goto L57;
        r130 = 0.0d;
        goto L58
    L57:
        r130 = Math.acos(r311);
        goto L58
    L50:
        r49 = 1.0d;
        goto L51
    L46:
        r215 = 1.0d;
        goto L47
    L39:
        r35 = 1.0d;
        goto L40
    L18:
        r111 = false;
        goto L19
    L79:
        r10 = r10;
        r11 = r11;
        r10.close();
        goto L84
    L83:
        r10 = r10;
        r11 = r11;
        int r62 = r5 + 1;
        float r63 = r42[r5];
        r5 = r5 + 2;
        r10.moveTo(r63, r42[r62]);
        goto L84
    L86:
        return r10;
    }

    public static Path makePolyLinePath(float[] r5) {
        return a.d(r5, false);
    }

    public static Path makePolygonPath(float[] r5) {
        return a.d(r5, true);
    }

    public static void makeRadialGradient(SVGRender r5, String r10, String r11, int r12, float r13, float r14, float r15, float r16, float r17, int r18, StopModel[] r19) {
        if (r5 == null) goto L5;
        RadialGradientModel r20 = new RadialGradientModel();
        r20.mType = r18;
        r20.mTransform = r11;
        r20.mStopModels = r19;
        r20.mSpreadMode = r12;
        r20.mCx = r13;
        r20.mCy = r14;
        r20.mFr = r15;
        r20.mFx = r16;
        r20.mFy = r17;
        r5.addGradientModel(r10, RADIAL_GRADIENT, r20);
        return;
    }

    public static Path makeRectPath(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r10 = r17 + r21;
        float r11 = r18 + r22;
        Path r12 = new Path();
        if (r19 == 0.0f) goto L9;
        if (r20 == 0.0f) goto L9;
        float r13 = r19 * 0.5522848f;
        float r14 = r20 * 0.5522848f;
        float r15 = r18 + r20;
        r12.moveTo(r17, r15);
        float r16 = r15 - r14;
        float r23 = r17 + r19;
        float r110 = r23 - r13;
        r12.cubicTo(r17, r16, r110, r18, r23, r18);
        float r24 = r10 - r19;
        r12.lineTo(r24, r18);
        float r111 = r13 + r24;
        r12.cubicTo(r111, r18, r10, r16, r10, r15);
        float r112 = r11 - r20;
        r12.lineTo(r10, r112);
        float r113 = r14 + r112;
        r12.cubicTo(r10, r113, r111, r11, r24, r11);
        r12.lineTo(r23, r11);
        r12.cubicTo(r110, r11, r17, r113, r17, r112);
        r12.lineTo(r17, r15);
        r12.close();
        return r12;
    L9:
        r12.addRect(r17, r18, r10, r11, Path.Direction.CW);
        return r12;
    }

    public static StopModel makeStopModel(float r5, long r10, float r11) {
        return new StopModel(r5, r10, r11);
    }

    public static SpannableStringBuilder makeStringBuilder() {
        return new SpannableStringBuilder();
    }

    public static StrokePaintModel makeStrokePaintModel(int r13, String r14, long r15, float r17, float r18, int r19, int r20, float r21, float r22, float[] r23) {
        return new StrokePaintModel(r13, r14, r15, r17, r18, r19, r20, r21, r22, r23);
    }

    public static void op(Path r5, Path r10, int r11) {
        Path.Op r12 = Path.Op.UNION;
        if (r11 != 0) goto L5;
        r12 = Path.Op.DIFFERENCE;
    L15:
        r5.op(r10, r12);
        return;
    L5:
        if (r11 != 1) goto L7;
        r12 = Path.Op.INTERSECT;
        goto L15
    L7:
        if (r11 != 3) goto L9;
        r12 = Path.Op.XOR;
        goto L15
    L9:
        if (r11 != 4) goto L15;
        r12 = Path.Op.REVERSE_DIFFERENCE;
        goto L15
    }

    public native float[] calculateViewBoxTransform(float r5, float r10, float r11, float r12, float r13, float r14, float r15, float r16, int r17, int r18, int r19);

    public native int render(SVGRender r5, String r10, float r11, float r12, float r13, float r14);
}
