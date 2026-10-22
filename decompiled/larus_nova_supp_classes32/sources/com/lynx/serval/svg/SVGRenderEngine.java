package com.lynx.serval.svg;

import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.model.FillPaintModel;
import com.lynx.serval.svg.model.LinearGradientModel;
import com.lynx.serval.svg.model.RadialGradientModel;
import com.lynx.serval.svg.model.StopModel;
import com.lynx.serval.svg.model.StrokePaintModel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
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
    public static volatile boolean a;
    public static SVGRenderEngine b;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static void layout(float r0) {
    }

    public native float[] calculateViewBoxTransform(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, int r9, int r10, int r11);

    public native int render(SVGRender r1, String r2, float r3, float r4, float r5, float r6, String r7);

    public static SVGRenderEngine getInstance() {
        if (b != null) goto L15;
        monitor-enter(SVGRenderEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new SVGRenderEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SVGRenderEngine.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public static Path makeMutablePath() {
        return new Path();
    }

    public static SpannableStringBuilder makeStringBuilder() {
        return new SpannableStringBuilder();
    }

    public SVGRenderEngine() {
        if (a == true) goto L13;
        INVOKESTATIC_com_lynx_serval_svg_SVGRenderEngine_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("serval_svg");     // Catch: UnsatisfiedLinkError -> L7
        a = true;
        return;
    L7:
        e = move-exception;
        e.getMessage();
        return;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_serval_svg_SVGRenderEngine_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static Path makePolyLinePath(float[] r1) {
        return k6a.a.a(r1, false);
    }

    public static Path makePolygonPath(float[] r1) {
        return k6a.a.a(r1, true);
    }

    public static Path makePath(byte[] r41, float[] r42) {
        Path r8 = new Path();
        int r1 = 0;
        int r10 = 0;
    L4:
        if (r10 >= r41.length) goto L87;
        byte r2 = r41[r10];
        if (r2 == 0) goto L83;
        boolean r3 = true;
        if (r2 != 1) goto L10;
        r8 = r8;
        int r4 = r1 + 1;
        int r5 = r4 + 1;
        r8.lineTo(r42[r1], r42[r4]);
    L84:
        r1 = r5;
    L85:
        r10 = r10 + 1;
        r8 = r8;
        goto L4
    L10:
        if (r2 != 2) goto L12;
        r8 = r8;
        r10 = r10;
        int r6 = r1 + 1;
        float r7 = r42[r1];
        int r9 = r6 + 1;
        float r11 = r42[r6];
        int r12 = r9 + 1;
        float r13 = r42[r9];
        int r14 = r12 + 1;
        float r15 = r42[r12];
        int r16 = r14 + 1;
        r8.cubicTo(r7, r11, r13, r15, r42[r14], r42[r16]);
        r1 = r16 + 1;
        goto L85
    L12:
        if (r2 != 3) goto L14;
        r8 = r8;
        r10 = r10;
        int r17 = r1 + 1;
        int r18 = r17 + 1;
        int r19 = r18 + 1;
        r8.quadTo(r42[r1], r42[r17], r42[r18], r42[r19]);
        r1 = r19 + 1;
        goto L85
    L14:
        if (r2 == 5) goto L79;
        int r20 = r1 + 1;
        float r21 = r42[r1];
        int r22 = r20 + 1;
        float r23 = r42[r20];
        int r24 = r22 + 1;
        float r25 = r42[r22];
        int r26 = r24 + 1;
        float r27 = r42[r24];
        int r28 = r26 + 1;
        float r29 = r42[r26];
        int r110 = r28 + 1;
        if (((int) r42[r28]) == 0) goto L18;
        boolean r30 = true;
    L19:
        int r111 = r110 + 1;
        if (((int) r42[r110]) != 0) goto L23;
        r3 = false;
    L23:
        int r112 = r111 + 1;
        float r113 = r42[r111];
        int r114 = r112 + 1;
        float r115 = r42[r112];
        if (r21 != r113) goto L29;
        if (r23 != r115) goto L29;
        r8 = r8;
        r10 = r10;
        r114 = r114;
    L78:
        r1 = r114;
    L29:
        if (r25 == 0.0f) goto L77;
        if (r27 == 0.0f) goto L77;
        float r31 = Math.abs(r25);
        float r32 = Math.abs(r27);
        double r116 = Math.toRadians(((double) r29) % 360.0d);
        double r117 = Math.cos(r116);
        double r118 = Math.sin(r116);
        r10 = r10;
        double r33 = ((double) (r21 - r113)) / 2.0d;
        double r0 = ((double) (r23 - r115)) / 2.0d;
        double r119 = (r117 * r33) + (r118 * r0);
        boolean r210 = r3;
        double r34 = ((-r118) * r33) + (r0 * r117);
        double r35 = r31 * r31;
        double r36 = r32 * r32;
        double r211 = r119 * r119;
        double r212 = r34 * r34;
        double r37 = (r211 / r35) + (r212 / r36);
        if (r37 <= 0.99999d) goto L36;
        double r38 = Math.sqrt(r37) * 1.00001d;
        r31 = (float) (((double) r31) * r38);
        r32 = (float) (r38 * ((double) r32));
        r35 = r31 * r31;
        r36 = r32 * r32;
    L36:
        r114 = r114;
        if (r30 != r210) goto L39;
        double r39 = -1.0d;
    L40:
        double r310 = r35 * r36;
        double r40 = r35 * r212;
        double r43 = r36 * r211;
        double r311 = ((r310 - r40) - r43) / (r40 + r43);
        if (r311 >= 0.0d) goto L43;
        r311 = 0.0d;
    L43:
        double r312 = r39 * Math.sqrt(r311);
        double r44 = r31;
        double r45 = r32;
        double r213 = ((r44 * r34) / r45) * r312;
        double r313 = r312 * (-((r45 * r119) / r44));
        float r214 = r31;
        float r215 = r32;
        double r46 = (((double) (r21 + r113)) / 2.0d) + ((r117 * r213) - (r118 * r313));
        double r47 = (((double) (r23 + r115)) / 2.0d) + ((r118 * r213) + (r117 * r313));
        double r120 = (r119 - r213) / r44;
        double r121 = (r34 - r313) / r45;
        double r122 = ((-r119) - r213) / r44;
        double r48 = ((-r34) - r313) / r45;
        double r49 = (r120 * r120) + (r121 * r121);
        double r50 = Math.sqrt(r49);
        if (r121 >= 0.0d) goto L46;
        double r216 = -1.0d;
    L47:
        double r217 = r216 * Math.acos(r120 / r50);
        double r51 = Math.sqrt(r49 * ((r122 * r122) + (r48 * r48)));
        double r52 = (r120 * r122) + (r121 * r48);
        if (((r120 * r48) - (r121 * r122)) >= 0.0d) goto L50;
        double r53 = -1.0d;
    L51:
        double r54 = r52 / r51;
        if (r54 >= (-1.0d)) goto L55;
        double r55 = 3.141592653589793d;
    L58:
        double r56 = r53 * r55;
        if (r56 != 0.0d) goto L61;
        r8.lineTo(r113, r115);
        r8 = r8;
        goto L78
    L61:
        float r57 = r113;
        float r123 = r115;
        if (r210 == true) goto L65;
        if (r56 <= 0.0d) goto L65;
        r56 = r56 - 6.283185307179586d;
    L69:
        double r58 = r56 % 6.283185307179586d;
        double r218 = r217 % 6.283185307179586d;
        int r59 = (int) Math.ceil((Math.abs(r58) * 2.0d) / 3.141592653589793d);
        double r60 = r58 / ((double) r59);
        double r124 = r60 / 2.0d;
        double r125 = (Math.sin(r124) * 1.3333333333333333d) / (Math.cos(r124) + 1.0d);
        int r126 = r59 * 6;
        float[] r127 = new float[r126];
        int r61 = 0;
        int r128 = 0;
    L70:
        if (r61 >= r59) goto L72;
        Path r129 = r8;
        double r62 = (((double) r61) * r60) + r218;
        double r130 = Math.cos(r62);
        double r219 = Math.sin(r62);
        int r131 = r128 + 1;
        float r314 = r123;
        int r315 = r126;
        r127[r128] = (float) (r130 - (r125 * r219));
        int r132 = r131 + 1;
        double r220 = r47;
        r127[r131] = (float) (r219 + (r130 * r125));
        double r63 = r62 + r60;
        double r64 = Math.cos(r63);
        double r65 = Math.sin(r63);
        int r133 = r132 + 1;
        double r221 = r60;
        r127[r132] = (float) ((r125 * r65) + r64);
        int r66 = r133 + 1;
        r127[r133] = (float) (r65 - (r125 * r64));
        int r67 = r66 + 1;
        r127[r66] = (float) r64;
        r128 = r67 + 1;
        r127[r67] = (float) r65;
        r61 = r61 + 1;
        r8 = r129;
        r57 = r57;
        r60 = r221;
        r47 = r220;
        r123 = r314;
        r126 = r315;
        r125 = r125;
        goto L70
    L72:
        Path r134 = r8;
        int r316 = r126;
        Matrix r68 = new Matrix();
        r68.postScale(r214, r215);
        r68.postRotate(r29);
        r68.postTranslate((float) r46, (float) r47);
        r68.mapPoints(r127);
        r127[r316 - 2] = r57;
        r127[r316 - 1] = r123;
        int r69 = 0;
    L73:
        if (r69 >= r316) goto L75;
        r134.cubicTo(r127[r69], r127[r69 + 1], r127[r69 + 2], r127[r69 + 3], r127[r69 + 4], r127[r69 + 5]);
        r69 = r69 + 6;
        goto L73
    L75:
        r8 = r134;
    L65:
        if (r210 == false) goto L69;
        if (r56 >= 0.0d) goto L69;
        r56 = r56 + 6.283185307179586d;
        goto L69
    L55:
        if (r54 <= 1.0d) goto L57;
        r55 = 0.0d;
        goto L58
    L57:
        r55 = Math.acos(r54);
        goto L58
    L50:
        r53 = 1.0d;
        goto L51
    L46:
        r216 = 1.0d;
        goto L47
    L39:
        r39 = 1.0d;
    L77:
        r8.lineTo(r113, r115);
        goto L78
    L18:
        r30 = false;
        goto L19
    L79:
        r8 = r8;
        r10 = r10;
        r8.close();
        goto L85
    L83:
        r8 = r8;
        int r70 = r1 + 1;
        r5 = r70 + 1;
        r8.moveTo(r42[r1], r42[r70]);
        goto L84
    L87:
        return r8;
    }

    public static void setFillType(Path r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != 1) goto L6;
        Path.FillType r3 = Path.FillType.EVEN_ODD;
    L7:
        r1.setFillType(r3);
        return;
    L6:
        r3 = Path.FillType.WINDING;
        goto L7
    }

    public static Path makeCirclePath(float r17, float r18, float r19) {
        float r8 = r17 - r19;
        float r9 = r18 - r19;
        float r10 = r17 + r19;
        float r11 = r18 + r19;
        float r12 = r19 * 0.5522848f;
        Path r13 = new Path();
        r13.moveTo(r10, r18);
        float r14 = r18 + r12;
        float r15 = r17 + r12;
        r13.cubicTo(r10, r14, r15, r11, r17, r11);
        float r16 = r17 - r12;
        r13.cubicTo(r16, r11, r8, r14, r8, r18);
        float r110 = r18 - r12;
        r13.cubicTo(r8, r110, r16, r9, r17, r9);
        r13.cubicTo(r15, r9, r10, r110, r10, r18);
        r13.close();
        return r13;
    }

    public static StopModel makeStopModel(float r1, long r2, float r4) {
        return new StopModel(r1, r2, r4);
    }

    public static void op(Path r2, Path r3, int r4) {
        Path.Op r0 = Path.Op.UNION;
        if (r4 != 0) goto L5;
        r0 = Path.Op.DIFFERENCE;
    L17:
        r2.op(r3, r0);
        return;
    L5:
        if (r4 != 1) goto L7;
        r0 = Path.Op.INTERSECT;
        goto L17
    L7:
        if (r4 == 2) goto L17;
        if (r4 != 3) goto L11;
        r0 = Path.Op.XOR;
        goto L17
    L11:
        if (r4 != 4) goto L17;
        r0 = Path.Op.REVERSE_DIFFERENCE;
        goto L17
    }

    public static void appendSpan(SpannableStringBuilder r4, String r5, int r6, float r7) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        int r0 = r5.length();
        SpannableString r1 = new SpannableString(r5);
        r1.setSpan(new ForegroundColorSpan(r6), 0, r0, 33);
        r1.setSpan(new AbsoluteSizeSpan((int) r7, true), 0, r0, 33);
        r4.append(r1);
    }

    public static Path makeEllipsePath(float r17, float r18, float r19, float r20) {
        float r8 = r17 - r19;
        float r9 = r18 - r20;
        float r10 = r17 + r19;
        float r11 = r18 + r20;
        float r12 = r19 * 0.5522848f;
        float r13 = r20 * 0.5522848f;
        Path r14 = new Path();
        r14.moveTo(r17, r9);
        float r15 = r17 + r12;
        float r16 = r18 - r13;
        r14.cubicTo(r15, r9, r10, r16, r10, r18);
        float r110 = r18 + r13;
        r14.cubicTo(r10, r110, r15, r11, r17, r11);
        float r111 = r17 - r12;
        r14.cubicTo(r111, r11, r8, r110, r8, r18);
        r14.cubicTo(r8, r16, r111, r9, r17, r9);
        r14.close();
        return r14;
    }

    public static Path makeLinePath(float r1, float r2, float r3, float r4) {
        Path r0 = new Path();
        r0.moveTo(r1, r2);
        r0.lineTo(r3, r4);
        return r0;
    }

    public static FillPaintModel makeFillPaintModel(int r8, String r9, long r10, int r12, float r13) {
        return new FillPaintModel(r8, r9, r10, r13, r12);
    }

    public static Path makeRectPath(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r9 = r17 + r21;
        float r10 = r18 + r22;
        Path r11 = new Path();
        if (r19 != 0.0f) goto L5;
    L8:
        r11.moveTo(r17, r18);
        r11.lineTo(r9, r18);
        r11.lineTo(r9, r10);
        r11.lineTo(r17, r10);
        r11.close();
    L9:
        return r11;
    L5:
        if (r20 == 0.0f) goto L8;
        float r12 = r19 * 0.5522848f;
        float r13 = r20 * 0.5522848f;
        float r14 = r18 + r20;
        r11.moveTo(r17, r14);
        float r15 = r14 - r13;
        float r6 = r17 + r19;
        float r16 = r6 - r12;
        r11.cubicTo(r17, r15, r16, r18, r6, r18);
        float r7 = r9 - r19;
        r11.lineTo(r7, r18);
        float r110 = r12 + r7;
        r11.cubicTo(r110, r18, r9, r15, r9, r14);
        float r111 = r10 - r20;
        r11.lineTo(r9, r111);
        float r112 = r13 + r111;
        r11.cubicTo(r9, r112, r110, r10, r7, r10);
        r11.lineTo(r6, r10);
        r11.cubicTo(r16, r10, r17, r112, r17, r111);
        r11.lineTo(r17, r14);
        r11.close();
        goto L9
    }

    public static Path makeStrokePath(Path r2, float r3, int r4, int r5, float r6, float r7, float[] r8) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Paint r0 = new Paint();
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeWidth(r3);
        if (r4 != 0) goto L8;
        r0.setStrokeCap(Paint.Cap.BUTT);
    L11:
        if (r5 != 0) goto L13;
        r0.setStrokeJoin(Paint.Join.MITER);
    L16:
        r0.setStrokeMiter(r6);
        if (r8 != null) goto L19;
    L21:
        Path r9 = new Path();
        r0.getFillPath(r2, r9);
        return r9;
    L19:
        if (r8.length <= 0) goto L21;
        r0.setPathEffect(new DashPathEffect(r8, r7));
        goto L21
    L13:
        if (r5 != 1) goto L15;
        r0.setStrokeJoin(Paint.Join.ROUND);
        goto L16
    L15:
        r0.setStrokeJoin(Paint.Join.BEVEL);
        goto L16
    L8:
        if (r4 != 1) goto L10;
        r0.setStrokeCap(Paint.Cap.ROUND);
        goto L11
    L10:
        r0.setStrokeCap(Paint.Cap.SQUARE);
        goto L11
    }

    public static void makeLinearGradient(SVGRender r1, String r2, float[] r3, int r4, float r5, float r6, float r7, float r8, int r9, StopModel[] r10) {
        if (r1 == null) goto L5;
        LinearGradientModel r0 = new LinearGradientModel();
        r0.mType = r9;
        r0.mTransform = r3;
        r0.mStopModels = r10;
        r0.mX1 = r5;
        r0.mX2 = r6;
        r0.mY1 = r7;
        r0.mY2 = r8;
        r0.mSpreadMode = r4;
        r1.addGradientModel(r2, LINEAR_GRADIENT, r0);
        return;
    }

    public static void makeRadialGradient(SVGRender r1, String r2, float[] r3, int r4, float r5, float r6, float r7, float r8, float r9, int r10, StopModel[] r11) {
        if (r1 == null) goto L5;
        RadialGradientModel r0 = new RadialGradientModel();
        r0.mType = r10;
        r0.mTransform = r3;
        r0.mStopModels = r11;
        r0.mSpreadMode = r4;
        r0.mCx = r5;
        r0.mCy = r6;
        r0.mFr = r7;
        r0.mFx = r8;
        r0.mFy = r9;
        r1.addGradientModel(r2, RADIAL_GRADIENT, r0);
        return;
    }

    public static StrokePaintModel makeStrokePaintModel(int r14, String r15, long r16, float r18, float r19, int r20, int r21, float r22, float r23, float[] r24, int r25) {
        return new StrokePaintModel(r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25);
    }
}
