package in;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.PathParser;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Matrix f17593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final double f17594j = 0.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f17595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17597c;
    public int d;
    public a[] e;
    public double[] f;
    public com.lynx.tasm.behavior.ui.utils.d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17598h;

    static {
        f17594j = Math.sqrt(2.0d);
    }

    public b(float r5, String r10) {
        this.f17595a = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f17598h = 0;
        this.f17596b = 3;
        this.f17595a = PathParser.createPathFromPathData(r10);     // Catch: RuntimeException -> L5
    L7:
        if (this.f17595a != null) goto L11;
        LynxLog.b(4, "LynxBasicShape", "Invalid path data string: " + r10);
        return;
    L11:
        if (f17593i != null) goto L13;
        f17593i = new Matrix();
    L13:
        f17593i.setScale(r5, r5);
        this.f17595a.transform(f17593i);
        return;
    L5:
        LynxLog.b(4, "LynxBasicShape", "Create path from data string failed. Check the path string. \n" + r10);
        goto L7
    }

    public static double a(a r5, double r10) {
        if (r5 != null) goto L5;
        return 0.0d;
    L5:
        int r11 = r5.f17592b;
        double r12 = r5.f17591a;
        if (r11 == 1) goto L8;
        return r12;
    L8:
        return r12 * r10;
    }

    public static b c(ReadableArray r18, float r19) {
        if (r18 != null) goto L5;
    L55:
        return null;
    L5:
        if (r18.size() <= 1) goto L55;
        int r5 = r18.size();
        int r10 = 0;
        long r11 = r18.getLong(0);
        if (r11 != 3) goto L13;
        if (r5 == 2) goto L12;
        return null;
    L12:
        return new b(r19, r18.getString(1));
    L13:
        int r12 = 4;
        int r13 = 11;
        if (r11 != 4) goto L20;
        if (r5 == 11) goto L17;
        return null;
    L17:
        b r14 = new b(4);
        a[] r15 = new a[4];
        r14.e = r15;
        r15[0] = new a(r18.getDouble(1), r18.getInt(2));
        r14.e[1] = new a(r18.getDouble(3), r18.getInt(4));
        r14.e[2] = new a(r18.getDouble(7), r18.getInt(8));
        r14.e[3] = new a(r18.getDouble(9), r18.getInt(10));
        r14.f = new double[]{r18.getDouble(5), 0.0d};
        r14.f[1] = r18.getDouble(6);
        return r14;
    L20:
        if (r11 != 1) goto L26;
        if (r5 == 7) goto L23;
        return null;
    L23:
        b r16 = new b(1);
        a[] r17 = new a[3];
        r16.e = r17;
        r17[0] = new a(r18.getDouble(1), r18.getInt(2));
        r16.e[1] = new a(r18.getDouble(3), r18.getInt(4));
        r16.e[2] = new a(r18.getDouble(5), r18.getInt(6));
        return r16;
    L26:
        if (r11 != 2) goto L32;
        if (r5 == 9) goto L29;
        return null;
    L29:
        b r20 = new b(2);
        a[] r21 = new a[4];
        r20.e = r21;
        r21[0] = new a(r18.getDouble(1), r18.getInt(2));
        r20.e[1] = new a(r18.getDouble(3), r18.getInt(4));
        r20.e[2] = new a(r18.getDouble(5), r18.getInt(6));
        r20.e[3] = new a(r18.getDouble(7), r18.getInt(8));
        return r20;
    L32:
        if (r11 != 5) goto L55;
        b r22 = new b(5);
        r22.e = new a[4];
        if (r18.size() != 9) goto L37;
        r22.f17598h = 1;
    L42:
        int r23 = 0;
    L43:
        if (r23 >= r12) goto L45;
        int r24 = r23 * 2;
        r22.e[r23] = new a(r18.getDouble(r24 + 1), r18.getInt(r24 + 2));
        r23 = r23 + 1;
        r12 = 4;
        goto L43
    L45:
        int r25 = r22.f17598h;
        if (r25 == 2) goto L50;
        if (r25 != 3) goto L54;
        r22.f = new double[]{r18.getDouble(9), 0.0d};
        r22.f[1] = r18.getDouble(10);
    L51:
        r22.g = new com.lynx.tasm.behavior.ui.utils.d();
    L52:
        if (r10 >= 4) goto L54;
        r22.g.b(r10, com.lynx.tasm.behavior.ui.utils.c.a((r10 * 4) + r13, r18));
        r10 = r10 + 1;
    L54:
        return r22;
    L50:
        r13 = 9;
        goto L51
    L37:
        if (r18.size() != 25) goto L40;
        r22.f17598h = 2;
        goto L42
    L40:
        if (r18.size() != 27) goto L55;
        r22.f17598h = 3;
        goto L42
    }

    public static void d(Path r16, float r17, float r18, float r19, float r20, float r21, float r22, int r23) {
        int r5 = r23;
        float r10 = 1.0f;
        if (r5 != 1) goto L5;
    L8:
        float r11 = 1.0f;
    L9:
        if (r5 != 1) goto L11;
    L14:
        double r12 = 1.5707963267948966d;
        float r13 = (float) (((double) (r5 - 1)) * 1.5707963267948966d);
    L15:
        double r14 = r13;
        if (r14 >= (((double) r5) * r12)) goto L22;
        double r15 = Math.cos(r14) * ((double) r11);
        double r110 = Math.sin(r14) * ((double) r10);
        double r24 = (Math.pow(r15, 2.0f / r21) * ((double) (r11 * r17))) + ((double) r19);
        float r111 = r10;
        double r25 = (Math.pow(r110, 2.0f / r22) * ((double) (r10 * r18))) + ((double) r20);
        if (r13 != 0.0f) goto L20;
        r16.moveTo((float) r24, (float) r25);
    L21:
        r13 = (float) (r14 + 0.01d);
        r5 = r23;
        r10 = r111;
        r12 = 1.5707963267948966d;
        goto L15
    L20:
        r16.lineTo((float) r24, (float) r25);
        goto L21
    L22:
        return;
    L11:
        if (r5 == 2) goto L14;
        r10 = -1.0f;
        goto L14
    L5:
        if (r5 == 4) goto L8;
        r11 = -1.0f;
        goto L9
    }

    public final Path b(int r28, int r29) {
        int r5 = this.f17596b;
        if (r5 == 3) goto L5;
        if (r5 != 0) goto L10;
        return null;
    L10:
        if (r28 == this.f17597c) goto L12;
    L16:
        this.f17597c = r28;
        this.d = r29;
        Path r10 = this.f17595a;
        if (r10 != null) goto L19;
        this.f17595a = new Path();
    L20:
        int r11 = 1;
        if (r5 != 1) goto L23;
        a[] r12 = this.e;
        if (r12 != null) goto L86;
    L90:
        return this.f17595a;
    L86:
        if (r12.length != 3) goto L90;
        float r13 = (float) a(r12[0], Math.sqrt((r29 * r29) + (r28 * r28)) / f17594j);
        this.f17595a.addCircle((float) a(this.e[1], r28), (float) a(this.e[2], r29), r13, Path.Direction.CW);
        goto L90
    L23:
        if (r5 == 2) goto L72;
        if (r5 != 4) goto L26;
        a[] r14 = this.e;
        if (r14 == null) goto L90;
        if (r14.length != 4) goto L90;
        double[] r15 = this.f;
        if (r15 == null) goto L90;
        if (r15.length != 2) goto L90;
        double r16 = r28;
        float r17 = (float) a(r14[0], r16);
        float r18 = (float) a(this.e[1], r16);
        float r19 = (float) a(this.e[2], r16);
        float r20 = (float) a(this.e[3], r29);
        double[] r21 = this.f;
        float r22 = (float) r21[0];
        float r23 = (float) r21[1];
        if (r17 != 0.0f) goto L69;
        if (r18 == 0.0f) goto L90;
    L69:
        if (r11 > 4) goto L71;
        d(this.f17595a, r17, r18, r19, r20, r22, r23, r11);
        r11 = r11 + 1;
        goto L69
    L71:
        this.f17595a.close();
        goto L90
    L26:
        if (r5 != 5) goto L90;
        a[] r24 = this.e;
        if (r24 == null) goto L90;
        if (r24.length != 4) goto L90;
        double r110 = r29;
        double r25 = a(r24[0], r110);
        double r111 = r28;
        double r112 = a(this.e[1], r111);
        double r113 = a(this.e[2], r110);
        double r114 = a(this.e[3], r111);
        double r26 = r25 + r113;
        double r27 = r114 + r112;
        if (r26 == 0.0d) goto L39;
        if (r26 <= r110) goto L39;
        double r210 = r110 / r26;
        r25 = r25 * r210;
        r113 = r113 * r210;
    L39:
        if (r27 != 0.0d) goto L41;
    L43:
        RectF r30 = new RectF((float) r114, (float) r25, (float) (r111 - r112), (float) (r110 - r113));
        int r31 = this.f17598h;
        if (r31 == 1) goto L53;
        if (r31 == 2) goto L52;
        if (r31 != 3) goto L90;
        this.g.a(r30.width(), r30.height());
        float[] r32 = this.g.c();
        if (r32.length < 8) goto L90;
        float r33 = r32[4];
        float r115 = r32[5];
        float r116 = r30.right - r33;
        float r117 = r30.bottom - r115;
        double[] r34 = this.f;
        float r118 = (float) r34[0];
        float r35 = (float) r34[1];
        d(this.f17595a, r33, r115, r116, r117, r118, r35, 1);
        float r119 = r32[6];
        float r120 = r32[7];
        d(this.f17595a, r119, r120, r30.left + r119, r30.bottom - r120, r118, r35, 2);
        float r121 = r32[0];
        float r122 = r32[1];
        d(this.f17595a, r121, r122, r30.left + r121, r30.top + r122, r118, r35, 3);
        float r123 = r32[2];
        float r124 = r32[3];
        d(this.f17595a, r123, r124, r30.right - r123, r30.top + r124, r118, r35, 4);
        this.f17595a.close();
        goto L90
    L52:
        this.g.a(r30.width(), r30.height());
        this.f17595a.addRoundRect(r30, this.g.c(), Path.Direction.CW);
        goto L90
    L53:
        this.f17595a.addRect(r30, Path.Direction.CW);
        goto L90
    L41:
        if (r27 <= r111) goto L43;
        double r211 = r111 / r27;
        r114 = r114 * r211;
        r112 = r112 * r211;
        goto L43
    L72:
        a[] r36 = this.e;
        if (r36 == null) goto L90;
        if (r36.length != 4) goto L90;
        double r37 = r28;
        float r38 = (float) a(r36[0], r37);
        float r39 = (float) a(this.e[1], r37);
        float r40 = (float) a(this.e[2], r37);
        float r41 = (float) a(this.e[3], r29);
        if (r38 == 0.0f) goto L80;
    L82:
        this.f17595a.addOval(r40 - r38, r41 - r39, r40 + r38, r41 + r39, Path.Direction.CW);
        goto L90
    L80:
        if (r39 != 0.0f) goto L82;
    L19:
        r10.reset();
        goto L20
    L12:
        if (r29 != this.d) goto L16;
        Path r42 = this.f17595a;
        if (r42 == null) goto L16;
        return r42;
    L5:
        return this.f17595a;
    }

    public b(int r5) {
        this.f17595a = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f17598h = 0;
        this.f17596b = r5;
    }
}
