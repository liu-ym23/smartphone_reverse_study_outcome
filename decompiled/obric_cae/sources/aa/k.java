package aa;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;
import pe.d0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m[] f204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f215l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f216a = null;

        static {
            f216a = new k();
        }
    }

    public interface b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f221e;

        public c(j r8, float r10, RectF r11, f.a r12, Path r13) {
            this.f220d = r12;
            this.f217a = r8;
            this.f221e = r10;
            this.f219c = r11;
            this.f218b = r13;
        }
    }

    public k() {
        this.f204a = new m[4];
        this.f205b = new Matrix[4];
        this.f206c = new Matrix[4];
        this.f207d = new PointF();
        this.f208e = new Path();
        this.f209f = new Path();
        this.f210g = new m();
        this.f211h = new float[2];
        this.f212i = new float[2];
        this.f213j = new Path();
        this.f214k = new Path();
        this.f215l = true;
        int r8 = 0;
    L3:
        if (r8 >= 4) goto L5;
        this.f204a[r8] = new m();
        this.f205b[r8] = new Matrix();
        this.f206c[r8] = new Matrix();
        r8 = r8 + 1;
        goto L3
    }

    public final void a(j r23, float r24, RectF r25, f.a r26, Path r27) {
        k r8 = this;
        r27.rewind();
        Path r10 = r8.f208e;
        r10.rewind();
        Path r11 = r8.f209f;
        r11.rewind();
        r11.addRect(r25, Path.Direction.CW);
        c r12 = new c(r23, r24, r25, r26, r27);
        int r13 = 0;
    L3:
        int r14 = 4;
        char r15 = 1;
        Matrix[] r16 = r8.f206c;
        float[] r17 = r8.f211h;
        Matrix[] r18 = r8.f205b;
        m[] r19 = r8.f204a;
        float r110 = r12.f221e;
        RectF r111 = r12.f219c;
        j r20 = r12.f217a;
        if (r13 >= 4) goto L31;
        if (r13 == 1) goto L11;
        if (r13 == 2) goto L10;
        if (r13 == 3) goto L9;
        aa.c r21 = r20.f185f;
    L12:
        if (r13 == 1) goto L18;
        if (r13 == 2) goto L17;
        if (r13 == 3) goto L16;
        d0 r22 = r20.f181b;
    L19:
        m r28 = r19[r13];
        r22.getClass();
        r22.b(r110, r21.a(r111), r28);
        int r29 = r13 + 1;
        float r30 = (r29 % 4) * 90;
        r18[r13].reset();
        PointF r31 = r8.f207d;
        if (r13 == 1) goto L28;
        if (r13 != 2) goto L23;
        float r32 = r111.left;
    L29:
        float r112 = r111.bottom;
    L30:
        r31.set(r32, r112);
        r18[r13].setTranslate(r31.x, r31.y);
        r18[r13].preRotate(r30);
        m r33 = r19[r13];
        r17[0] = r33.f226c;
        r17[1] = r33.f227d;
        r18[r13].mapPoints(r17);
        r16[r13].reset();
        r16[r13].setTranslate(r17[0], r17[1]);
        r16[r13].preRotate(r30);
        r13 = r29;
        goto L3
    L23:
        if (r13 == 3) goto L25;
        r32 = r111.right;
    L26:
        r112 = r111.top;
        goto L30
    L25:
        r32 = r111.left;
        goto L26
    L28:
        r32 = r111.right;
        goto L29
    L16:
        r22 = r20.f180a;
        goto L19
    L17:
        r22 = r20.f183d;
        goto L19
    L18:
        r22 = r20.f182c;
        goto L19
    L9:
        r21 = r20.f184e;
        goto L12
    L10:
        r21 = r20.f187h;
        goto L12
    L11:
        r21 = r20.f186g;
        goto L12
    L31:
        char r113 = 0;
        int r34 = 0;
    L32:
        if (r34 >= r14) goto L69;
        m r35 = r19[r34];
        r17[r113] = r35.f224a;
        r17[r15] = r35.f225b;
        r18[r34].mapPoints(r17);
        Path r36 = r12.f218b;
        if (r34 != 0) goto L36;
        r36.moveTo(r17[r113], r17[r15]);
    L37:
        r19[r34].c(r18[r34], r36);
        b r37 = r12.f220d;
        if (r37 == null) goto L41;
        m r38 = r19[r34];
        Matrix r39 = r18[r34];
        f r40 = ((f.a) r37).f155a;
        BitSet r41 = r40.f142n;
        r38.getClass();
        r41.set(r34, false);
        r38.b(r38.f229f);
        r40.f140b[r34] = new l(new ArrayList(r38.f231h), new Matrix(r39));
    L41:
        int r42 = r34 + 1;
        int r43 = r42 % 4;
        m r44 = r19[r34];
        r17[0] = r44.f226c;
        r17[1] = r44.f227d;
        r18[r34].mapPoints(r17);
        m r45 = r19[r43];
        float r46 = r45.f224a;
        float[] r47 = r8.f212i;
        r47[0] = r46;
        r47[1] = r45.f225b;
        r18[r43].mapPoints(r47);
        Path r48 = r10;
        Path r210 = r11;
        float r49 = Math.max(((float) Math.hypot(r17[0] - r47[0], r17[1] - r47[1])) - 0.001f, 0.0f);
        m r50 = r19[r34];
        r17[0] = r50.f226c;
        r17[1] = r50.f227d;
        r18[r34].mapPoints(r17);
        if (r34 != 1) goto L44;
    L46:
        float r51 = r111.centerX();
        float r52 = r17[0];
    L47:
        float r53 = Math.abs(r51 - r52);
        m r54 = r8.f210g;
        r54.e(0.0f, 270.0f, 0.0f);
        if (r34 != 1) goto L50;
        e r55 = r20.f190k;
    L57:
        r55.a(r49, r53, r110, r54);
        Path r56 = r8.f213j;
        r56.reset();
        r54.c(r16[r34], r56);
        if (r8.f215l == true) goto L60;
    L64:
        Path r57 = r210;
        r54.c(r16[r34], r36);
    L65:
        if (r37 == 0) goto L67;
        Matrix r58 = r16[r34];
        f r59 = ((f.a) r37).f155a;
        char r60 = 0;
        r59.f142n.set(r34 + 4, false);
        r54.b(r54.f229f);
        r59.f141m[r34] = new l(new ArrayList(r54.f231h), new Matrix(r58));
    L68:
        r113 = r60;
        r11 = r57;
        r10 = r48;
        r12 = r12;
        r34 = r42;
        r14 = 4;
        r15 = 1;
        r8 = this;
        goto L32
    L67:
        r60 = 0;
        goto L68
    L60:
        if (r8.b(r56, r34) == false) goto L62;
    L63:
        r57 = r210;
        r56.op(r56, r57, Path.Op.DIFFERENCE);
        r17[0] = r54.f224a;
        r17[1] = r54.f225b;
        r16[r34].mapPoints(r17);
        r48.moveTo(r17[0], r17[1]);
        r54.c(r16[r34], r48);
        goto L65
    L62:
        if (r8.b(r56, r43) == false) goto L64;
    L50:
        if (r34 != 2) goto L52;
        r55 = r20.f191l;
        goto L57
    L52:
        if (r34 == 3) goto L54;
        r55 = r20.f189j;
        goto L57
    L54:
        r55 = r20.f188i;
        goto L57
    L44:
        if (r34 == 3) goto L46;
        r51 = r111.centerY();
        r52 = r17[1];
        goto L47
    L36:
        r36.lineTo(r17[r113], r17[r15]);
        goto L37
    L69:
        Path r61 = r10;
        r27.close();
        r61.close();
        if (r61.isEmpty() == true) goto L79;
        r27.op(r61, Path.Op.UNION);
        return;
    }

    public final boolean b(Path r8, int r10) {
        Path r11 = this.f214k;
        r11.reset();
        this.f204a[r10].c(this.f205b[r10], r11);
        RectF r12 = new RectF();
        r8.computeBounds(r12, true);
        r11.computeBounds(r12, true);
        r8.op(r11, Path.Op.INTERSECT);
        r8.computeBounds(r12, true);
        if (r12.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r12.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r12.height() <= 1.0f) goto L9;
        return true;
    }
}
