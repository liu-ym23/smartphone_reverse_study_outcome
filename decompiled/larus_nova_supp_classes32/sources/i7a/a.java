package i7a;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.PathParser;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static Matrix i;
    public static final double j = 0.0d;
    public Path a;
    public final int b;
    public int c;
    public int d;
    public C0093a[] e;
    public double[] f;
    public BorderRadius g;
    public int h;

    /* JADX INFO: renamed from: i7a.a$a, reason: collision with other inner class name */
    public static class C0093a {
        public final double a;
        public final int b;

        public C0093a(double r1, int r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    static {
        j = Math.sqrt(2.0d);
    }

    public a(int r2) {
        this.a = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.b = r2;
    }

    public a(String r4, float r5) {
        this.a = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.b = 3;
        this.a = PathParser.createPathFromPathData(r4);     // Catch: RuntimeException -> L5
    L7:
        if (this.a != null) goto L11;
        LLog.e("LynxBasicShape", "Invalid path data string: " + r4);
        return;
    L11:
        if (i != null) goto L13;
        i = new Matrix();
    L13:
        i.setScale(r5, r5);
        this.a.transform(i);
        return;
    L5:
        LLog.e("LynxBasicShape", "Create path from data string failed. Check the path string. \n" + r4);
        goto L7
    }

    public static a a(ReadableArray r17, float r18) {
        if (r17 != null) goto L5;
        return null;
    L5:
        if (r17.size() <= 1) goto L61;
        int r2 = r17.size();
        int r4 = 0;
        long r5 = r17.getLong(0);
        if (r5 != 3) goto L12;
        if (r2 == 2) goto L55;
        return null;
    L55:
        return new a(r17.getString(1), r18);
    L12:
        int r12 = 11;
        int r10 = 4;
        if (r5 != 4) goto L18;
        if (r2 == 11) goto L16;
        return null;
    L16:
        a r1 = new a(4);
        C0093a[] r3 = new C0093a[4];
        r1.e = r3;
        r3[0] = new C0093a(r17.getDouble(1), r17.getInt(2));
        r1.e[1] = new C0093a(r17.getDouble(3), r17.getInt(4));
        r1.e[2] = new C0093a(r17.getDouble(7), r17.getInt(8));
        r1.e[3] = new C0093a(r17.getDouble(9), r17.getInt(10));
        r1.f = new double[]{r17.getDouble(5), 0.0d};
        r1.f[1] = r17.getDouble(6);
        return r1;
    L18:
        if (r5 != 1) goto L23;
        if (r2 == 7) goto L21;
        return null;
    L21:
        a r6 = new a(1);
        C0093a[] r7 = new C0093a[3];
        r6.e = r7;
        r7[0] = new C0093a(r17.getDouble(1), r17.getInt(2));
        r6.e[1] = new C0093a(r17.getDouble(3), r17.getInt(4));
        r6.e[2] = new C0093a(r17.getDouble(5), r17.getInt(6));
        return r6;
    L23:
        if (r5 != 2) goto L28;
        if (r2 == 9) goto L26;
        return null;
    L26:
        a r8 = new a(2);
        C0093a[] r9 = new C0093a[4];
        r8.e = r9;
        r9[0] = new C0093a(r17.getDouble(1), r17.getInt(2));
        r8.e[1] = new C0093a(r17.getDouble(3), r17.getInt(4));
        r8.e[2] = new C0093a(r17.getDouble(5), r17.getInt(6));
        r8.e[3] = new C0093a(r17.getDouble(7), r17.getInt(8));
        return r8;
    L28:
        if (r5 != 5) goto L59;
        a r11 = new a(5);
        r11.e = new C0093a[4];
        if (r17.size() != 9) goto L33;
        r11.h = 1;
    L38:
        int r13 = 0;
    L39:
        if (r13 >= r10) goto L41;
        int r14 = r13 * 2;
        r11.e[r13] = new C0093a(r17.getDouble(r14 + 1), r17.getInt(r14 + 2));
        r13 = r13 + 1;
        r10 = 4;
        goto L39
    L41:
        int r15 = r11.h;
        if (r15 == 2) goto L46;
        if (r15 != 3) goto L51;
        r11.f = new double[]{r17.getDouble(9), 0.0d};
        r11.f[1] = r17.getDouble(10);
    L47:
        r11.g = new BorderRadius();
    L48:
        if (r4 >= 4) goto L51;
        r11.g.c(r4, BorderRadius.a.a(r17, (r4 * 4) + r12));
        r4 = r4 + 1;
    L51:
        return r11;
    L46:
        r12 = 9;
        goto L47
    L33:
        if (r17.size() != 25) goto L36;
        r11.h = 2;
        goto L38
    L36:
        if (r17.size() != 27) goto L60;
        r11.h = 3;
        goto L38
    L60:
        return null;
    L59:
        return null;
    L61:
        return null;
    }

    public static double d(C0093a r2, double r3) {
        if (r2 != null) goto L6;
        return 0.0d;
    L6:
        if (r2.b != 1) goto L9;
        return r2.a * r3;
    L9:
        return r2.a;
    }

    public final Path c(int r28, int r29) {
        int r3 = this.b;
        if (r3 == 3) goto L5;
        if (r3 != 0) goto L10;
        return null;
    L10:
        if (r28 == this.c) goto L12;
    L16:
        this.c = r28;
        this.d = r29;
        Path r4 = this.a;
        if (r4 != null) goto L19;
        this.a = new Path();
    L20:
        int r5 = this.b;
        int r6 = 1;
        if (r5 != 1) goto L23;
        C0093a[] r7 = this.e;
        if (r7 != null) goto L86;
    L90:
        return this.a;
    L86:
        if (r7.length != 3) goto L90;
        float r8 = (float) d(r7[0], Math.sqrt((r28 * r28) + (r29 * r29)) / j);
        this.a.addCircle((float) d(this.e[1], r28), (float) d(this.e[2], r29), r8, Path.Direction.CW);
        goto L90
    L23:
        if (r5 == 2) goto L72;
        if (r5 != 4) goto L26;
        C0093a[] r9 = this.e;
        if (r9 == null) goto L90;
        if (r9.length != 4) goto L90;
        double[] r10 = this.f;
        if (r10 == null) goto L90;
        if (r10.length != 2) goto L90;
        double r11 = r28;
        float r1 = (float) d(r9[0], r11);
        float r12 = (float) d(this.e[1], r11);
        float r13 = (float) d(this.e[2], r11);
        float r2 = (float) d(this.e[3], r29);
        double[] r14 = this.f;
        float r15 = (float) r14[0];
        float r16 = (float) r14[1];
        if (r1 != 0.0f) goto L69;
        if (r12 == 0.0f) goto L90;
    L69:
        if (r6 > 4) goto L71;
        b(this.a, r1, r12, r13, r2, r15, r16, r6);
        r6 = r6 + 1;
        goto L69
    L71:
        this.a.close();
        goto L90
    L26:
        if (r5 != 5) goto L90;
        C0093a[] r17 = this.e;
        if (r17 == null) goto L90;
        if (r17.length != 4) goto L90;
        double r18 = r29;
        double r19 = d(r17[0], r18);
        double r110 = r28;
        double r111 = d(this.e[1], r110);
        double r112 = d(this.e[2], r18);
        double r113 = d(this.e[3], r110);
        double r21 = r19 + r112;
        double r23 = r113 + r111;
        if (r21 == 0.0d) goto L39;
        if (r21 <= r18) goto L39;
        double r22 = r18 / r21;
        r19 = r19 * r22;
        r112 = r112 * r22;
    L39:
        if (r23 != 0.0d) goto L41;
    L43:
        RectF r20 = new RectF((float) r113, (float) r19, (float) (r110 - r111), (float) (r18 - r112));
        int r24 = this.h;
        if (r24 == 1) goto L53;
        if (r24 == 2) goto L52;
        if (r24 != 3) goto L90;
        this.g.d(r20.width(), r20.height());
        float[] r25 = this.g.a();
        if (r25.length < 8) goto L90;
        float r26 = r25[4];
        float r114 = r25[5];
        float r115 = r20.right - r26;
        float r116 = r20.bottom - r114;
        double[] r27 = this.f;
        float r117 = (float) r27[0];
        float r30 = (float) r27[1];
        b(this.a, r26, r114, r115, r116, r117, r30, 1);
        float r118 = r25[6];
        float r119 = r25[7];
        b(this.a, r118, r119, r20.left + r118, r20.bottom - r119, r117, r30, 2);
        float r120 = r25[0];
        float r121 = r25[1];
        b(this.a, r120, r121, r20.left + r120, r20.top + r121, r117, r30, 3);
        float r122 = r25[2];
        float r123 = r25[3];
        b(this.a, r122, r123, r20.right - r122, r20.top + r123, r117, r30, 4);
        this.a.close();
        goto L90
    L52:
        this.g.d(r20.width(), r20.height());
        this.a.addRoundRect(r20, this.g.a(), Path.Direction.CW);
        goto L90
    L53:
        this.a.addRect(r20, Path.Direction.CW);
        goto L90
    L41:
        if (r23 <= r110) goto L43;
        double r210 = r110 / r23;
        r113 = r113 * r210;
        r111 = r111 * r210;
        goto L43
    L72:
        C0093a[] r31 = this.e;
        if (r31 == null) goto L90;
        if (r31.length != 4) goto L90;
        double r124 = r28;
        float r32 = (float) d(r31[0], r124);
        float r33 = (float) d(this.e[1], r124);
        float r34 = (float) d(this.e[2], r124);
        float r35 = (float) d(this.e[3], r29);
        if (r32 == 0.0f) goto L80;
    L82:
        this.a.addOval(r34 - r32, r35 - r33, r34 + r32, r35 + r33, Path.Direction.CW);
        goto L90
    L80:
        if (r33 != 0.0f) goto L82;
    L19:
        r4.reset();
        goto L20
    L12:
        if (r29 != this.d) goto L16;
        Path r36 = this.a;
        if (r36 == null) goto L16;
        return r36;
    L5:
        return this.a;
    }

    public static void b(Path r16, float r17, float r18, float r19, float r20, float r21, float r22, int r23) {
        int r1 = r23;
        float r2 = -1.0f;
        if (r1 != 1) goto L5;
    L8:
        float r5 = 1.0f;
    L9:
        if (r1 != 1) goto L11;
    L12:
        r2 = 1.0f;
    L13:
        double r6 = 1.5707963267948966d;
        float r3 = (float) (((double) (r1 - 1)) * 1.5707963267948966d);
    L14:
        double r8 = r3;
        if (r8 >= (((double) r1) * r6)) goto L21;
        double r10 = ((double) r5) * Math.cos(r8);
        double r12 = ((double) r2) * Math.sin(r8);
        double r14 = (((double) (r5 * r17)) * Math.pow(r10, 2.0f / r21)) + ((double) r19);
        float r7 = r2;
        double r11 = ((r2 * r18) * Math.pow(r12, 2.0f / r22)) + ((double) r20);
        if (r3 != 0.0f) goto L19;
        r16.moveTo((float) r14, (float) r11);
    L20:
        r3 = (float) (r8 + 0.01d);
        r1 = r23;
        r2 = r7;
        r6 = 1.5707963267948966d;
        goto L14
    L19:
        r16.lineTo((float) r14, (float) r11);
        goto L20
    L21:
        return;
    L11:
        if (r1 != 2) goto L13;
    L5:
        if (r1 == 4) goto L8;
        r5 = -1.0f;
        goto L9
    }
}
