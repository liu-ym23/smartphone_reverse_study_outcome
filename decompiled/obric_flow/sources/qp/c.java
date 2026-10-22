package qp;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f21554c;
    public final float d;

    public c() {
        super(8);
        this.f21554c = 0.017453292519943295d;
        this.d = 0.6f;
    }

    @Override // um.a
    public final Path l(float r43, float r44, float r45, float r46, float r47) {
        float r5 = r45 - r43;
        float r10 = Math.min(r5, r46 - r44);
        Path r12 = new Path();
        if (r47 == 0.0f) goto L14;
        if (r47 >= (0.5f * r10)) goto L14;
        float r11 = this.d;
        float r13 = Math.min(r10 / 2.0f, (r11 + 1.0f) * r47);
        float r14 = r10 / 4.0f;
        if (r47 <= r14) goto L10;
        float r15 = 1.0f - ((r47 - r14) / r14);
        float r16 = (1.0f - (r11 * r15)) * 90;
        float r17 = (45 * r11) * r15;
    L11:
        float r18 = (90 - r16) / 2.0f;
        double r19 = this.f21554c;
        double r110 = ((double) r17) * r19;
        float r20 = (float) Math.tan(r110);
        float r21 = ((float) Math.tan(((double) (r18 / 2.0f)) * r19)) * r47;
        float r22 = (float) (Math.sqrt(2.0d) * (Math.sin(((double) (r16 / 2.0f)) * r19) * ((double) r47)));
        float r23 = r21 * ((float) Math.cos(r110));
        float r24 = r23 * r20;
        float r25 = ((r13 - r22) - ((r20 + 1.0f) * r23)) / 3.0f;
        float r111 = r45 - r13;
        float r26 = r13 - (r25 * 2.0f);
        float r112 = r45 - r26;
        float r27 = r26 - r25;
        float r113 = r45 - r27;
        float r28 = r27 - r23;
        float r114 = r44 + r24;
        float r115 = r45 - r47;
        float r116 = r44 + r47;
        float r29 = r44 + r27;
        float r210 = r44 + r26;
        float r30 = r44 + r13;
        float r31 = r46 - r13;
        float r211 = r46 - r26;
        float r212 = r46 - r27;
        float r32 = r46 - r47;
        float r34 = r46 - r24;
        float r33 = r13 + r43;
        float r35 = r43 + r26;
        float r36 = r43 + r27;
        float r37 = r43 + r47;
        float r38 = r24 + r43;
        r12.moveTo((r5 / 2.0f) + r43, r44);
        r12.lineTo(r111, r44);
        r12.cubicTo(r112, r44, r113, r44, r45 - r28, r114);
        com.lynx.tasm.base.a.j(r12, new d(r115, r116), r47, r18 + 270.0f, 360.0f - r18);
        r12.cubicTo(r45, r29, r45, r210, r45, r30);
        r12.lineTo(r45, r31);
        r12.cubicTo(r45, r211, r45, r212, r45 - r24, r46 - r28);
        com.lynx.tasm.base.a.j(r12, new d(r115, r32), r47, r18, 90.0f - r18);
        r12.cubicTo(r113, r46, r112, r46, r111, r46);
        r12.lineTo(r33, r46);
        r12.cubicTo(r35, r46, r36, r46, r43 + r28, r34);
        com.lynx.tasm.base.a.j(r12, new d(r37, r32), r47, 90.0f + r18, 180.0f - r18);
        r12.cubicTo(r43, r212, r43, r211, r43, r31);
        r12.lineTo(r43, r30);
        r12.cubicTo(r43, r210, r43, r29, r38, r44 + r28);
        com.lynx.tasm.base.a.j(r12, new d(r37, r116), r47, r18 + 180.0f, 270.0f - r18);
        r12.cubicTo(r36, r44, r35, r44, r33, r44);
        r12.close();
        return r12;
    L10:
        r16 = (1.0f - r11) * 90;
        r17 = 45 * r11;
    L14:
        return um.a.m(r43, r44, r45, r46, r47);
    }

    @Override // um.a
    public final boolean n(float r5, float r10) {
        if (r5 >= (r10 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
