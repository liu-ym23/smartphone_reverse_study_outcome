package lb;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f9201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9202d;

    public f() {
        this.f9200b = 0.585786f;
        this.f9201c = 0.292893f;
        this.f9202d = 1.175f;
    }

    @Override // lb.d
    public final Path a(float r10, float r11, float r12, float r13, float r14) {
        float r8 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = Math.min(r8, r15);
        float r17 = Math.max(r8, r15);
        if (r14 == 0.0f) goto L25;
        float r18 = r16 * 0.5f;
        if (r14 != r18) goto L25;
        if (r14 != r18) goto L13;
        if (r8 != r15) goto L13;
        return d.b(r10, r11, r12, r13, r14);
    L13:
        if (r8 <= r15) goto L15;
        boolean r19 = true;
    L17:
        if (r14 <= r18) goto L19;
        r14 = r18;
    L19:
        float r20 = Math.min(this.f9202d * r14, r17 * 0.5f);
        float r21 = this.f9201c;
        float r22 = this.f9200b;
        if (r19 == false) goto L22;
        float r23 = r22 * r14;
        float r24 = r21 * r14;
        float r25 = r10 + r20;
        float r110 = r14 * 2.0f;
        RectF r26 = new RectF(r10, r11, r10 + r110, r13);
        RectF r27 = new RectF(r12 - r110, r11, r12, r13);
        float r111 = r12 - r20;
        float r28 = r12 - r23;
        float r112 = r12 - r24;
        float r29 = r11 + r24;
        float r30 = r13 - r24;
        float r31 = r23 + r10;
        float r32 = r10 + r24;
        Path r33 = new Path();
        r33.moveTo(r25, r11);
        r33.lineTo(r111, r11);
        r33.quadTo(r28, r11, r112, r29);
        r33.arcTo(r27, -45.0f, 90.0f);
        r33.quadTo(r28, r13, r111, r13);
        r33.lineTo(r25, r13);
        r33.quadTo(r31, r13, r32, r30);
        r33.arcTo(r26, 135.0f, 90.0f);
        r33.quadTo(r31, r11, r25, r11);
        r33.close();
        return r33;
    L22:
        float r34 = r22 * r14;
        float r35 = r21 * r14;
        float r36 = r11 + r20;
        float r113 = r14 * 2.0f;
        RectF r37 = new RectF(r10, r11, r12, r11 + r113);
        RectF r38 = new RectF(r10, r13 - r113, r12, r13);
        float r114 = r13 - r20;
        float r39 = r13 - r34;
        float r40 = r12 - r35;
        float r115 = r13 - r35;
        float r41 = r10 + r35;
        float r42 = r34 + r11;
        float r116 = r11 + r35;
        Path r43 = new Path();
        r43.moveTo(r12, r36);
        r43.lineTo(r12, r114);
        r43.quadTo(r12, r39, r40, r115);
        r43.arcTo(r38, 45.0f, 90.0f);
        r43.quadTo(r10, r39, r10, r114);
        r43.lineTo(r10, r36);
        r43.quadTo(r10, r42, r41, r116);
        r43.arcTo(r37, 225.0f, 90.0f);
        r43.quadTo(r12, r42, r12, r36);
        r43.close();
        return r43;
    L15:
        r19 = false;
    L25:
        return d.b(r10, r11, r12, r13, r14);
    }

    @Override // lb.d
    public final boolean c(float r8, float r10) {
        if (r8 != (r10 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
