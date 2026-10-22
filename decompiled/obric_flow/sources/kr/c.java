package kr;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f19467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorMatrix f19468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorMatrix f19469c;
    public float d;
    public float e;
    public float f;
    public float g;

    public c() {
        this.f19467a = new float[20];
        this.f19468b = new ColorMatrix();
        this.f19469c = new ColorMatrix();
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = 1.0f;
        this.g = 1.0f;
    }

    public final void a(ImageView r31) {
        ColorMatrix r5 = this.f19468b;
        r5.reset();
        float r10 = this.e;
        float r11 = 1.0f;
        float[] r12 = this.f19467a;
        boolean r24 = true;
        if (r10 == 1.0f) goto L5;
        float r13 = 1.0f - r10;
        float r26 = 0.2999f * r13;
        float r27 = 0.587f * r13;
        float r14 = r13 * 0.114f;
        r12[0] = r26 + r10;
        r12[1] = r27;
        r12[2] = r14;
        r12[3] = 0.0f;
        r12[4] = 0.0f;
        r12[5] = r26;
        r12[6] = r27 + r10;
        r12[7] = r14;
        r12[8] = 0.0f;
        r12[9] = 0.0f;
        r12[10] = r26;
        r12[11] = r27;
        r12[12] = r14 + r10;
        r12[13] = 0.0f;
        r12[14] = 0.0f;
        r12[15] = 0.0f;
        r12[16] = 0.0f;
        r12[17] = 0.0f;
        r12[18] = 1.0f;
        r12[19] = 0.0f;
        r5.set(r12);
        boolean r15 = true;
    L6:
        float r16 = this.f;
        ColorMatrix r17 = this.f19469c;
        if (r16 == 1.0f) goto L9;
        r17.setScale(r16, r16, r16, 1.0f);
        r5.postConcat(r17);
        r15 = true;
    L9:
        float r18 = this.g;
        if (r18 != 1.0f) goto L12;
        float[] r19 = r12;
    L27:
        float r20 = this.d;
        if (r20 == r11) goto L30;
        r19[0] = r20;
        r19[1] = 0.0f;
        r19[2] = 0.0f;
        r19[3] = 0.0f;
        r19[4] = 0.0f;
        r19[5] = 0.0f;
        r19[6] = r20;
        r19[7] = 0.0f;
        r19[8] = 0.0f;
        r19[9] = 0.0f;
        r19[10] = 0.0f;
        r19[11] = 0.0f;
        r19[12] = r20;
        r19[13] = 0.0f;
        r19[14] = 0.0f;
        r19[15] = 0.0f;
        r19[16] = 0.0f;
        r19[17] = 0.0f;
        r19[18] = 1.0f;
        r19[19] = 0.0f;
        r17.set(r19);
        r5.postConcat(r17);
    L31:
        if (r24 == false) goto L33;
        r31.setColorFilter(new ColorMatrixColorFilter(r5));
        return;
    L33:
        r31.clearColorFilter();
        return;
    L30:
        r24 = r15;
        goto L31
    L12:
        if (r18 > 0.0f) goto L14;
        r18 = 0.01f;
    L14:
        float r21 = (5000.0f / r18) / 100.0f;
        if (r21 <= 66.0f) goto L17;
        double r22 = r21 - 60.0f;
        float r110 = ((float) Math.pow(r22, -0.13320475816726685d)) * 329.69873f;
        float r23 = ((float) Math.pow(r22, 0.07551485300064087d)) * 288.12216f;
    L19:
        if (r21 < 66.0f) goto L21;
        float r25 = 255.0f;
    L25:
        float r28 = Math.min(255.0f, Math.max(r110, 0.0f));
        float r29 = Math.min(255.0f, Math.max(r23, 0.0f));
        float r30 = Math.min(255.0f, Math.max(r25, 0.0f));
        float r32 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
        float r33 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
        float r34 = Math.min(255.0f, Math.max(255.0f, 0.0f));
        float r111 = Math.min(255.0f, Math.max(r32, 0.0f));
        float r35 = r30 / Math.min(255.0f, Math.max(r33, 0.0f));
        r12[0] = r28 / r34;
        r12[1] = 0.0f;
        r12[2] = 0.0f;
        r12[3] = 0.0f;
        r12[4] = 0.0f;
        r12[5] = 0.0f;
        r12[6] = r29 / r111;
        r12[7] = 0.0f;
        r12[8] = 0.0f;
        r12[9] = 0.0f;
        r12[10] = 0.0f;
        r12[11] = 0.0f;
        r12[12] = r35;
        r12[13] = 0.0f;
        r12[14] = 0.0f;
        r12[15] = 0.0f;
        r12[16] = 0.0f;
        r12[17] = 0.0f;
        r11 = 1.0f;
        r12[18] = 1.0f;
        r12[19] = 0.0f;
        r19 = r12;
        r17.set(r19);
        r5.postConcat(r17);
        r15 = true;
        goto L27
    L21:
        if (r21 <= 19.0f) goto L23;
        r25 = (((float) Math.log(r21 - 10.0f)) * 138.51773f) - 305.0448f;
        goto L25
    L23:
        r25 = 0.0f;
        goto L25
    L17:
        r23 = (((float) Math.log(r21)) * 99.4708f) - 161.11957f;
        r110 = 255.0f;
        goto L19
    L5:
        r15 = false;
        goto L6
    }
}
