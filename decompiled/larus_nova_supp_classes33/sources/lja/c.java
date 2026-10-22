package lja;

import android.graphics.Path;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c extends d {
    public final double c;
    public final float d;
    public final String e;

    @Override // lja.d
    public final boolean c(float r2, float r3) {
        if (r2 >= (r3 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public c() {
        this.c = 0.017453292519943295d;
        this.d = 0.6f;
        this.e = "FigmaSmoothCornerImpl";
    }

    @Override // lja.d
    public String getType() {
        return this.e;
    }

    @Override // lja.d
    public final Path a(float r45, float r46, float r47, float r48, float r49) {
        float r1 = r47 - r45;
        float r2 = Math.min(r1, r48 - r46);
        Path r13 = new Path();
        if (r49 == 0.0f) goto L14;
        if (r49 >= (0.5f * r2)) goto L14;
        float r4 = Math.min(r2 / 2.0f, (this.d + 1.0f) * r49);
        float r3 = r2 / 4.0f;
        if (r49 <= r3) goto L10;
        float r15 = this.d;
        float r14 = 1.0f - ((r49 - r3) / r3);
        float r5 = 90 * (1.0f - (r15 * r14));
        float r6 = 45 * r15;
    L11:
        float r7 = r6 * r14;
        float r16 = (90 - r5) / 2.0f;
        double r8 = r7;
        float r9 = (float) Math.tan(this.c * r8);
        float r10 = ((float) Math.tan(((double) (r16 / 2.0f)) * this.c)) * r49;
        float r11 = (float) ((Math.sin(((double) (r5 / 2.0f)) * this.c) * ((double) r49)) * Math.sqrt(2.0d));
        float r12 = r10 * ((float) Math.cos(r8 * this.c));
        float r17 = r12 * r9;
        float r18 = ((r4 - r11) - ((r9 + 1.0f) * r12)) / 3.0f;
        float r19 = r47 - r4;
        float r20 = r4 - (r18 * 2.0f);
        float r110 = r47 - r20;
        float r21 = r20 - r18;
        float r111 = r47 - r21;
        float r22 = r21 - r12;
        float r23 = r47 - r49;
        float r24 = r46 + r49;
        float r26 = r46 + r21;
        float r27 = r46 + r20;
        float r112 = r46 + r4;
        float r113 = r48 - r4;
        float r29 = r48 - r20;
        float r30 = r48 - r21;
        float r0 = r48 - r49;
        float r25 = r45 + r4;
        float r114 = r45 + r20;
        float r37 = r45 + r21;
        float r38 = r45 + r22;
        float r28 = r45 + r49;
        float r39 = r45 + r17;
        r13.moveTo((r1 / 2.0f) + r45, r46);
        r13.lineTo(r19, r46);
        r13.cubicTo(r110, r46, r111, r46, r47 - r22, r46 + r17);
        d.a.a(r13, new e(r23, r24), r49, r16 + 270.0f, 360.0f - r16);
        r13.cubicTo(r47, r26, r47, r27, r47, r112);
        r13.lineTo(r47, r113);
        r13.cubicTo(r47, r29, r47, r30, r47 - r17, r48 - r22);
        d.a.a(r13, new e(r23, r0), r49, r16, 90.0f - r16);
        r13.cubicTo(r111, r48, r110, r48, r19, r48);
        r13.lineTo(r25, r48);
        r13.cubicTo(r114, r48, r37, r48, r38, r48 - r17);
        d.a.a(r13, new e(r28, r0), r49, r16 + 90.0f, 180.0f - r16);
        r13.cubicTo(r45, r30, r45, r29, r45, r113);
        r13.lineTo(r45, r112);
        r13.cubicTo(r45, r27, r45, r26, r39, r46 + r22);
        d.a.a(r13, new e(r28, r24), r49, r16 + 180.0f, 270.0f - r16);
        r13.cubicTo(r37, r46, r114, r46, r25, r46);
        r13.close();
        return r13;
    L10:
        r14 = this.d;
        r5 = 90 * (1.0f - r14);
        r6 = 45;
    L14:
        return d.b(r45, r46, r47, r48, r49);
    }
}
