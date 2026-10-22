package lb;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f9206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f9207d;

    public h() {
        this.f9205b = 128.19f;
        this.f9206c = 83.62f;
        this.f9207d = new b(67.45f, 51.16f, 34.86f, 22.07f, 13.36f, 4.64f);
    }

    @Override // lb.d
    public final Path a(float r58, float r59, float r60, float r61, float r62) {
        Path r11 = new Path();
        float r8 = r60 - r58;
        float r10 = r61 - r59;
        float r12 = Math.min(r8, r10);
        if (r62 == 0.0f) goto L17;
        if (r62 >= (r12 * 0.5f)) goto L17;
        float r13 = r62 / (r12 / 2.0f);
        float r14 = 1.0f;
        if (r13 <= 0.5f) goto L10;
        float r15 = 1.0f - (Math.min(1.0f, (r13 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r13 <= 0.6f) goto L14;
        r14 = 1.0f + (Math.min(1.0f, (r13 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r16 = r62 / 100.0f;
        float r17 = (this.f9205b * r16) * r15;
        float r18 = (this.f9206c * r16) * r14;
        b r19 = this.f9207d;
        float r110 = r19.f9189a * r16;
        float r111 = r19.f9190b * r16;
        float r112 = r19.f9191c * r16;
        float r113 = r19.f9192d * r16;
        float r20 = r19.f9193e * r16;
        float r21 = r16 * r19.f9194f;
        float r22 = (r8 / 2.0f) + r58;
        float r23 = r60 - r17;
        float r114 = Math.max(r22, r23);
        float r115 = r60 - r18;
        float r116 = r60 - r110;
        float r24 = r60 - r111;
        float r25 = r60 - r112;
        float r26 = r60 - r113;
        float r27 = r60 - r20;
        float r29 = r60 - r21;
        float r31 = r59 + r18;
        float r28 = r10 / 2.0f;
        float r117 = Math.min(r28, r17) + r59;
        float r30 = r28 + r59;
        float r32 = r61 - r17;
        float r118 = Math.max(r30, r32);
        float r33 = r61 - r18;
        float r39 = Math.max(r22, r23);
        float r34 = r58 + r17;
        float r119 = Math.min(r22, r34);
        float r40 = r58 + r18;
        float r43 = r58 + r111;
        float r45 = r58 + r112;
        float r47 = r58 + r113;
        float r49 = r58 + r20;
        float r51 = r58 + r21;
        float r35 = Math.max(r30, r32);
        float r36 = Math.min(r30, r17 + r59);
        float r56 = Math.min(r22, r34);
        r11.moveTo(r22, r59);
        r11.lineTo(r114, r59);
        r11.cubicTo(r115, r59, r116, r59 + r21, r24, r59 + r20);
        r11.cubicTo(r25, r59 + r113, r26, r59 + r112, r27, r59 + r111);
        r11.cubicTo(r29, r59 + r110, r60, r31, r60, r117);
        r11.lineTo(r60, r118);
        r11.cubicTo(r60, r33, r29, r61 - r110, r27, r61 - r111);
        r11.cubicTo(r26, r61 - r112, r25, r61 - r113, r24, r61 - r20);
        r11.cubicTo(r116, r61 - r21, r115, r61, r39, r61);
        r11.lineTo(r119, r61);
        r11.cubicTo(r40, r61, r58 + r110, r61 - r21, r43, r61 - r20);
        r11.cubicTo(r45, r61 - r113, r47, r61 - r112, r49, r61 - r111);
        r11.cubicTo(r51, r61 - r110, r58, r33, r58, r35);
        r11.lineTo(r58, r36);
        r11.cubicTo(r58, r31, r51, r59 + r110, r49, r111 + r59);
        r11.cubicTo(r47, r112 + r59, r45, r113 + r59, r43, r59 + r20);
        r11.cubicTo(r110 + r58, r59 + r21, r40, r59, r56, r59);
        r11.close();
        return r11;
    L10:
        r15 = 1.0f;
    L17:
        return d.b(r58, r59, r60, r61, r62);
    }

    @Override // lb.d
    public final boolean c(float r8, float r10) {
        if (r8 >= (r10 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
