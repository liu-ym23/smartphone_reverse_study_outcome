package lja;

import android.graphics.Path;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h extends d {
    public final float c;
    public final float d;
    public final b e;
    public final String f;

    @Override // lja.d
    public final boolean c(float r2, float r3) {
        if (r2 >= (r3 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public h() {
        this.c = 128.19f;
        this.d = 83.62f;
        this.e = new b();
        this.f = "SketchSmoothCornerImpl";
    }

    @Override // lja.d
    public String getType() {
        return this.f;
    }

    @Override // lja.d
    public final Path a(float r45, float r46, float r47, float r48, float r49) {
        Path r12 = new Path();
        float r1 = r47 - r45;
        float r2 = r48 - r46;
        float r3 = Math.min(r1, r2);
        if (r49 == 0.0f) goto L17;
        if (r49 >= (r3 * 0.5f)) goto L17;
        float r4 = r49 / (r3 / 2.0f);
        float r6 = 1.0f;
        if (r4 <= 0.5f) goto L10;
        float r5 = 1.0f - (Math.min(1.0f, (r4 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r4 <= 0.6f) goto L14;
        r6 = 1.0f + (Math.min(1.0f, (r4 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r7 = r49 / 100.0f;
        float r8 = (this.c * r7) * r5;
        float r9 = (this.d * r7) * r6;
        b r10 = this.e;
        float r13 = r10.a * r7;
        float r14 = r10.b * r7;
        float r15 = r10.c * r7;
        float r11 = r10.d * r7;
        float r0 = r10.e * r7;
        float r16 = r7 * r10.f;
        float r17 = (r1 / 2.0f) + r45;
        float r18 = r47 - r8;
        float r19 = Math.max(r17, r18);
        float r110 = r47 - r9;
        float r111 = r47 - r13;
        float r20 = r46 + r16;
        float r21 = r47 - r14;
        float r22 = r46 + r0;
        float r23 = r47 - r15;
        float r24 = r46 + r11;
        float r25 = r47 - r11;
        float r26 = r46 + r15;
        float r27 = r47 - r0;
        float r28 = r46 + r14;
        float r29 = r47 - r16;
        float r30 = r46 + r13;
        float r31 = r46 + r9;
        float r32 = r2 / 2.0f;
        float r112 = r46 + Math.min(r32, r8);
        float r33 = r32 + r46;
        float r113 = r48 - r8;
        float r114 = Math.max(r33, r113);
        float r34 = r48 - r9;
        float r35 = r48 - r13;
        float r36 = r48 - r14;
        float r37 = r48 - r15;
        float r38 = r48 - r11;
        float r39 = r48 - r0;
        float r310 = r48 - r16;
        float r311 = Math.max(r17, r18);
        float r40 = r45 + r8;
        float r115 = Math.min(r17, r40);
        float r41 = r45 + r9;
        float r116 = r13 + r45;
        float r117 = r14 + r45;
        float r118 = r15 + r45;
        float r42 = r45 + r11;
        float r43 = r0 + r45;
        float r44 = r45 + r16;
        float r119 = Math.max(r33, r113);
        float r50 = Math.min(r33, r8 + r46);
        float r410 = Math.min(r17, r40);
        r12.moveTo(r17, r46);
        r12.lineTo(r19, r46);
        r12.cubicTo(r110, r46, r111, r20, r21, r22);
        r12.cubicTo(r23, r24, r25, r26, r27, r28);
        r12.cubicTo(r29, r30, r47, r31, r47, r112);
        r12.lineTo(r47, r114);
        r12.cubicTo(r47, r34, r29, r35, r27, r36);
        r12.cubicTo(r25, r37, r23, r38, r21, r39);
        r12.cubicTo(r111, r310, r110, r48, r311, r48);
        r12.lineTo(r115, r48);
        r12.cubicTo(r41, r48, r116, r310, r117, r39);
        r12.cubicTo(r118, r38, r42, r37, r43, r36);
        r12.cubicTo(r44, r35, r45, r34, r45, r119);
        r12.lineTo(r45, r50);
        r12.cubicTo(r45, r31, r44, r30, r43, r28);
        r12.cubicTo(r42, r26, r118, r24, r117, r22);
        r12.cubicTo(r116, r20, r41, r46, r410, r46);
        r12.close();
        return r12;
    L10:
        r5 = 1.0f;
    L17:
        return d.b(r45, r46, r47, r48, r49);
    }
}
