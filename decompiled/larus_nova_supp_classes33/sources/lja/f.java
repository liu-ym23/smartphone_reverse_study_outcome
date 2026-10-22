package lja;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f extends d {
    public final String c;
    public final float d;
    public final float e;
    public final float f;

    @Override // lja.d
    public final boolean c(float r2, float r3) {
        if (r2 != (r3 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public f() {
        this.c = "QuadraticSmoothCornerExImpl";
        this.d = 0.585786f;
        this.e = 0.292893f;
        this.f = 1.175f;
    }

    @Override // lja.d
    public String getType() {
        return this.c;
    }

    @Override // lja.d
    public final Path a(float r10, float r11, float r12, float r13, float r14) {
        float r0 = r12 - r10;
        float r1 = r13 - r11;
        float r2 = Math.min(r0, r1);
        float r3 = Math.max(r0, r1);
        if (r14 == 0.0f) goto L22;
        float r4 = r2 * 0.5f;
        if (r14 != r4) goto L22;
        if (r14 != r4) goto L13;
        if (r0 != r1) goto L13;
        return d.b(r10, r11, r12, r13, r14);
    L13:
        if (r0 <= r1) goto L15;
        boolean r5 = true;
    L16:
        float r15 = RangesKt.coerceAtMost(r14, r4);
        float r6 = Math.min(this.f * r15, r3 * 0.5f);
        if (r5 == false) goto L19;
        float r7 = this.d * r15;
        float r8 = this.e * r15;
        float r9 = r10 + r6;
        float r16 = r15 * 2.0f;
        RectF r17 = new RectF(r10, r11, r10 + r16, r13);
        RectF r18 = new RectF(r12 - r16, r11, r12, r13);
        float r19 = r12 - r6;
        float r20 = r12 - r7;
        float r110 = r12 - r8;
        float r21 = r11 + r8;
        float r22 = r13 - r8;
        float r23 = r7 + r10;
        float r111 = r10 + r8;
        Path r24 = new Path();
        r24.moveTo(r9, r11);
        r24.lineTo(r19, r11);
        r24.quadTo(r20, r11, r110, r21);
        r24.arcTo(r18, -45.0f, 90.0f);
        r24.quadTo(r20, r13, r19, r13);
        r24.lineTo(r9, r13);
        r24.quadTo(r23, r13, r111, r22);
        r24.arcTo(r17, 135.0f, 90.0f);
        r24.quadTo(r23, r11, r9, r11);
        r24.close();
        return r24;
    L19:
        float r25 = this.d * r15;
        float r26 = this.e * r15;
        float r27 = r11 + r6;
        float r112 = r15 * 2.0f;
        RectF r28 = new RectF(r10, r11, r12, r11 + r112);
        RectF r29 = new RectF(r10, r13 - r112, r12, r13);
        float r113 = r13 - r6;
        float r30 = r13 - r25;
        float r31 = r12 - r26;
        float r114 = r13 - r26;
        float r32 = r10 + r26;
        float r33 = r25 + r11;
        float r115 = r11 + r26;
        Path r34 = new Path();
        r34.moveTo(r12, r27);
        r34.lineTo(r12, r113);
        r34.quadTo(r12, r30, r31, r114);
        r34.arcTo(r29, 45.0f, 90.0f);
        r34.quadTo(r10, r30, r10, r113);
        r34.lineTo(r10, r27);
        r34.quadTo(r10, r33, r32, r115);
        r34.arcTo(r28, 225.0f, 90.0f);
        r34.quadTo(r12, r33, r12, r27);
        r34.close();
        return r34;
    L15:
        r5 = false;
    L22:
        return d.b(r10, r11, r12, r13, r14);
    }
}
