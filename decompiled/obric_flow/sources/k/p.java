package k;

import ai.j0;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape$Type;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p implements n, l.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f18542c;
    public final PolystarShape$Type d;
    public final boolean e;
    public final l.f f;
    public final l.d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l.f f18543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l.f f18544i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l.f f18545j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l.f f18546k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l.f f18547l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ym.j f18548m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18549n;

    public p(w r10, r.c r11, q.h r12) {
        this.f18540a = new Path();
        this.f18548m = new ym.j(9);
        this.f18542c = r10;
        this.f18541b = r12.f21414a;
        PolystarShape$Type r13 = r12.f21415b;
        this.d = r13;
        this.e = r12.f21419j;
        l.d r5 = r12.f21416c.d();
        this.f = (l.f) r5;
        l.d r14 = r12.d.d();
        this.g = r14;
        l.d r15 = r12.e.d();
        this.f18543h = (l.f) r15;
        l.d r16 = r12.g.d();
        this.f18545j = (l.f) r16;
        l.d r17 = r12.f21418i.d();
        this.f18547l = (l.f) r17;
        PolystarShape$Type r18 = PolystarShape$Type.STAR;
        if (r13 != r18) goto L5;
        this.f18544i = (l.f) r12.f.d();
        this.f18546k = (l.f) r12.f21417h.d();
    L6:
        r11.f(r5);
        r11.f(r14);
        r11.f(r15);
        r11.f(r16);
        r11.f(r17);
        if (r13 != r18) goto L9;
        r11.f(this.f18544i);
        r11.f(this.f18546k);
    L9:
        r5.a(this);
        r14.a(this);
        r15.a(this);
        r16.a(this);
        r17.a(this);
        if (r13 != r18) goto L13;
        this.f18544i.a(this);
        this.f18546k.a(this);
        return;
    L13:
        return;
    L5:
        this.f18544i = null;
        this.f18546k = null;
        goto L6
    }

    @Override // l.a
    public final void a() {
        this.f18549n = false;
        this.f18542c.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = 0;
    L3:
        ArrayList r12 = (ArrayList) r5;
        if (r11 >= r12.size()) goto L11;
        c r13 = (c) r12.get(r11);
        if ((r13 instanceof u) == false) goto L10;
        u r14 = (u) r13;
        if (r14.f18571c != ShapeTrimPath$Type.SIMULTANEOUSLY) goto L10;
        ((ArrayList) this.f18548m.f23302a).add(r14);
        r14.c(this);
    L10:
        r11 = r11 + 1;
        goto L3
    }

    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        if (r5 != z.f1366o) goto L6;
        this.f.j(r10);
        return;
    L6:
        if (r5 != z.f1367p) goto L9;
        this.f18543h.j(r10);
        return;
    L9:
        if (r5 != z.f) goto L12;
        this.g.j(r10);
        return;
    L12:
        if (r5 != z.f1368q) goto L17;
        l.f r11 = this.f18544i;
        if (r11 == null) goto L17;
        r11.j(r10);
        return;
    L17:
        if (r5 != z.f1369r) goto L20;
        this.f18545j.j(r10);
        return;
    L20:
        if (r5 != z.s) goto L25;
        l.f r12 = this.f18546k;
        if (r12 == null) goto L25;
        r12.j(r10);
        return;
    L25:
        if (r5 != z.f1370t) goto L34;
        this.f18547l.j(r10);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.c
    public final String getName() {
        return this.f18541b;
    }

    @Override // k.n
    public final Path getPath() {
        boolean r5 = this.f18549n;
        Path r10 = this.f18540a;
        if (r5 == false) goto L5;
        return r10;
    L5:
        r10.reset();
        if (this.e == false) goto L9;
        this.f18549n = true;
        return r10;
    L9:
        int r11 = o.f18539a[this.d.ordinal()];
        l.d r12 = this.g;
        l.f r13 = this.f18545j;
        l.f r14 = this.f18547l;
        double r17 = 0.0d;
        l.f r15 = this.f18543h;
        l.f r16 = this.f;
        if (r11 != 1) goto L12;
        float r18 = ((Float) r16.f()).floatValue();
        if (r15 == null) goto L32;
        r17 = ((Float) r15.f()).floatValue();
    L32:
        double r19 = Math.toRadians(r17 - 90.0d);
        double r110 = r18;
        float r111 = (float) (6.283185307179586d / r110);
        float r112 = r111 / 2.0f;
        float r20 = r18 - ((int) r18);
        if (r20 == 0.0f) goto L35;
        r19 = r19 + ((double) ((1.0f - r20) * r112));
    L35:
        float r21 = ((Float) r13.f()).floatValue();
        p r22 = this;
        float r23 = ((Float) r22.f18544i.f()).floatValue();
        l.f r24 = r22.f18546k;
        if (r24 == null) goto L38;
        float r113 = ((Float) r24.f()).floatValue() / 100.0f;
    L39:
        if (r14 == null) goto L41;
        float r114 = ((Float) r14.f()).floatValue() / 100.0f;
    L42:
        if (r20 == 0.0f) goto L44;
        float r25 = j0.b(r21, r23, r20, r23);
        double r26 = r25;
        float r115 = (float) (Math.cos(r19) * r26);
        float r27 = (float) (r26 * Math.sin(r19));
        r10.moveTo(r115, r27);
        double r28 = r19 + ((double) ((r111 * r20) / 2.0f));
        float r29 = r115;
        float r116 = r25;
        float r30 = r27;
        float r117 = r112;
    L45:
        double r118 = Math.ceil(r110) * 2.0d;
        double r210 = r28;
        float r211 = r23;
        int r31 = 0;
        boolean r119 = false;
    L46:
        double r32 = r31;
        if (r32 >= r118) goto L91;
        if (r119 == false) goto L51;
        float r212 = r21;
    L53:
        if (r116 != 0.0f) goto L55;
    L57:
        float r33 = r117;
    L59:
        if (r116 != 0.0f) goto L61;
    L63:
        float r34 = r212;
    L64:
        double r35 = r34;
        float r36 = r116;
        float r37 = r117;
        float r120 = (float) (Math.cos(r210) * r35);
        float r121 = (float) (r35 * Math.sin(r210));
        if (r113 == 0.0f) goto L67;
    L69:
        double r38 = (float) (Math.atan2(r30, r29) - 1.5707963267948966d);
        float r39 = (float) Math.cos(r38);
        float r40 = (float) Math.sin(r38);
        Path r310 = r10;
        double r41 = (float) (Math.atan2(r121, r120) - 1.5707963267948966d);
        float r122 = (float) Math.cos(r41);
        float r42 = (float) Math.sin(r41);
        if (r119 == false) goto L72;
        float r43 = r113;
    L73:
        if (r119 == false) goto L75;
        float r123 = r114;
    L76:
        if (r119 == false) goto L78;
        float r311 = r211;
    L79:
        if (r119 == false) goto L81;
        float r312 = r21;
    L82:
        float r313 = (r311 * r43) * 0.47829f;
        float r44 = r39 * r313;
        float r314 = r313 * r40;
        float r315 = (r312 * r123) * 0.47829f;
        float r124 = r122 * r315;
        float r316 = r315 * r42;
        if (r20 == 0.0f) goto L89;
        if (r31 != 0) goto L87;
        r44 = r44 * r20;
        r314 = r314 * r20;
        goto L89
    L87:
        if (r32 != (r118 - 1.0d)) goto L89;
        r124 = r124 * r20;
        r316 = r316 * r20;
    L89:
        r310.cubicTo(r29 - r44, r30 - r314, r120 + r124, r121 + r316, r120, r121);
    L90:
        r210 = r210 + ((double) r33);
        r119 = !r119;
        r31 = r31 + 1;
        r22 = this;
        r29 = r120;
        r30 = r121;
        r21 = r21;
        r12 = r12;
        r117 = r37;
        r116 = r36;
        r10 = r310;
        r211 = r211;
        r111 = r111;
        goto L46
    L81:
        r312 = r211;
        goto L82
    L78:
        r311 = r21;
        goto L79
    L75:
        r123 = r113;
        goto L76
    L72:
        r43 = r114;
        goto L73
    L67:
        if (r114 != 0.0f) goto L69;
        r10.lineTo(r120, r121);
        r310 = r10;
        goto L90
    L61:
        if (r32 != (r118 - 1.0d)) goto L63;
        r34 = r116;
        goto L64
    L55:
        if (r32 != (r118 - 2.0d)) goto L57;
        r33 = (r111 * r20) / 2.0f;
        goto L59
    L51:
        r212 = r211;
        goto L53
    L91:
        l.d r317 = r12;
        p r125 = r22;
        PointF r45 = (PointF) r317.f();
        Path r46 = r10;
        r46.offset(r45.x, r45.y);
        r46.close();
    L92:
        r46.close();
        r125.f18548m.c(r46);
        r125.f18549n = true;
        return r46;
    L44:
        double r47 = r21;
        float r126 = (float) (Math.cos(r19) * r47);
        float r48 = (float) (r47 * Math.sin(r19));
        r10.moveTo(r126, r48);
        r117 = r112;
        r28 = r19 + ((double) r117);
        r30 = r48;
        r29 = r126;
        r116 = 0.0f;
        goto L45
    L41:
        r114 = 0.0f;
        goto L42
    L38:
        r113 = 0.0f;
        goto L39
    L12:
        if (r11 == 2) goto L15;
        r125 = this;
    L14:
        r46 = r10;
        goto L92
    L15:
        int r49 = (int) Math.floor(((Float) r16.f()).floatValue());
        if (r15 == null) goto L19;
        r17 = ((Float) r15.f()).floatValue();
    L19:
        double r127 = Math.toRadians(r17 - 90.0d);
        double r50 = r49;
        float r128 = ((Float) r14.f()).floatValue() / 100.0f;
        float r129 = ((Float) r13.f()).floatValue();
        double r51 = r129;
        float r52 = (float) (Math.cos(r127) * r51);
        float r53 = (float) (Math.sin(r127) * r51);
        r10.moveTo(r52, r53);
        double r54 = (float) (6.283185307179586d / r50);
        double r130 = r127 + r54;
        double r131 = Math.ceil(r50);
        int r55 = 0;
    L21:
        if (r55 >= r131) goto L27;
        float r132 = (float) (Math.cos(r130) * r51);
        double r213 = r54;
        float r133 = (float) (Math.sin(r130) * r51);
        if (r128 == 0.0f) goto L25;
        double r56 = (float) (Math.atan2(r53, r52) - 1.5707963267948966d);
        float r57 = (float) Math.cos(r56);
        float r58 = (float) Math.sin(r56);
        double r59 = (float) (Math.atan2(r133, r132) - 1.5707963267948966d);
        float r60 = (r129 * r128) * 0.25f;
        r10.cubicTo(r52 - (r57 * r60), r53 - (r58 * r60), r132 + (((float) Math.cos(r59)) * r60), r133 + (r60 * ((float) Math.sin(r59))), r132, r133);
    L26:
        r130 = r130 + r213;
        r54 = r213;
        r55 = r55 + 1;
        r52 = r132;
        r53 = r133;
        r51 = r51;
        goto L21
    L25:
        r10.lineTo(r132, r133);
        goto L26
    L27:
        PointF r61 = (PointF) r12.f();
        r10.offset(r61.x, r61.y);
        r10.close();
        r125 = this;
        goto L14
    }
}
