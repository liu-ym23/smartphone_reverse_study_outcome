package qp;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f21559c;
    public final float d;
    public final b e;

    public g() {
        super(8);
        this.f21559c = 128.19f;
        this.d = 83.62f;
        this.e = new b();
    }

    @Override // um.a
    public final Path l(float r45, float r46, float r47, float r48, float r49) {
        Path r11 = new Path();
        float r5 = r47 - r45;
        float r10 = r48 - r46;
        float r12 = Math.min(r5, r10);
        if (r49 == 0.0f) goto L17;
        if (r49 >= (r12 * 0.5f)) goto L17;
        float r13 = r49 / (r12 / 2.0f);
        float r14 = 1.0f;
        if (r13 <= 0.5f) goto L10;
        float r15 = 1.0f - (Math.min(1.0f, (r13 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r13 <= 0.6f) goto L14;
        r14 = 1.0f + (Math.min(1.0f, (r13 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r16 = r49 / 100.0f;
        float r17 = (this.f21559c * r16) * r15;
        float r18 = (this.d * r16) * r14;
        this.e.getClass();
        float r19 = 67.45f * r16;
        float r110 = 51.16f * r16;
        float r111 = 34.86f * r16;
        float r112 = 22.07f * r16;
        float r113 = 13.36f * r16;
        float r20 = r16 * 4.64f;
        float r21 = (r5 / 2.0f) + r45;
        float r22 = r47 - r17;
        float r114 = Math.max(r21, r22);
        float r115 = r47 - r18;
        float r116 = r47 - r19;
        float r23 = r46 + r20;
        float r24 = r47 - r110;
        float r25 = r46 + r113;
        float r26 = r47 - r111;
        float r27 = r46 + r112;
        float r28 = r47 - r112;
        float r29 = r46 + r111;
        float r210 = r47 - r113;
        float r211 = r46 + r110;
        float r212 = r47 - r20;
        float r30 = r46 + r19;
        float r31 = r46 + r18;
        float r32 = r10 / 2.0f;
        float r117 = Math.min(r32, r17) + r46;
        float r33 = r32 + r46;
        float r34 = r48 - r17;
        float r118 = Math.max(r33, r34);
        float r35 = r48 - r18;
        float r36 = r48 - r19;
        float r37 = r48 - r110;
        float r38 = r48 - r111;
        float r39 = r48 - r112;
        float r310 = r48 - r113;
        float r311 = r48 - r20;
        float r312 = Math.max(r21, r22);
        float r40 = r45 + r17;
        float r119 = Math.min(r21, r40);
        float r41 = r45 + r18;
        float r42 = r45 + r19;
        float r120 = r110 + r45;
        float r121 = r111 + r45;
        float r122 = r112 + r45;
        float r123 = r113 + r45;
        float r43 = r45 + r20;
        float r44 = Math.max(r33, r34);
        float r50 = Math.min(r33, r46 + r17);
        float r410 = Math.min(r21, r40);
        r11.moveTo(r21, r46);
        r11.lineTo(r114, r46);
        r11.cubicTo(r115, r46, r116, r23, r24, r25);
        r11.cubicTo(r26, r27, r28, r29, r210, r211);
        r11.cubicTo(r212, r30, r47, r31, r47, r117);
        r11.lineTo(r47, r118);
        r11.cubicTo(r47, r35, r212, r36, r210, r37);
        r11.cubicTo(r28, r38, r26, r39, r24, r310);
        r11.cubicTo(r116, r311, r115, r48, r312, r48);
        r11.lineTo(r119, r48);
        r11.cubicTo(r41, r48, r42, r311, r120, r310);
        r11.cubicTo(r121, r39, r122, r38, r123, r37);
        r11.cubicTo(r43, r36, r45, r35, r45, r44);
        r11.lineTo(r45, r50);
        r11.cubicTo(r45, r31, r43, r30, r123, r211);
        r11.cubicTo(r122, r29, r121, r27, r120, r25);
        r11.cubicTo(r42, r23, r41, r46, r410, r46);
        r11.close();
        return r11;
    L10:
        r15 = 1.0f;
    L17:
        return um.a.m(r45, r46, r47, r48, r49);
    }

    @Override // um.a
    public final boolean n(float r5, float r10) {
        if (r5 >= (r10 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
