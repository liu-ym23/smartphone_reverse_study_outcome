package jn;

import android.view.View;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f18360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f18361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f18362c;
    public float d;
    public float e;

    @Override // jn.e
    public final void a(View r5) {
        if (r5 == null) goto L5;
        r5.setScaleX(1.0f);
        r5.setScaleY(1.0f);
        r5.setTranslationX(0.0f);
        r5.setTranslationY(0.0f);
        return;
    }

    @Override // jn.e
    public final void b(f r10, View r11, boolean r12, int r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f18362c >= this.f18361b) goto L6;
        return;
    L6:
        if (this.e >= this.d) goto L8;
        return;
    L8:
        if (r10.getChildExpectSize() <= 0) goto L34;
        float r5 = Math.abs(r13);
        int r14 = r10.getChildExpectSize();
        float r15 = this.f18362c;
        float r16 = this.f18361b;
        float r17 = r14;
        float r18 = this.e;
        float r19 = r18 - (((r18 - this.d) * r5) / r17);
        float r20 = MathUtils.clamp(r15 - (((r15 - r16) * r5) / r17), r16, r15);
        float r21 = MathUtils.clamp(r19, this.d, this.e);
        r11.setScaleX(r20);
        r11.setScaleY(r21);
        float r22 = this.f18360a;
        if (r22 > 0.0f) goto L12;
        return;
    L12:
        if (r12 == false) goto L15;
        float r23 = r22 * r17;
        float r24 = 2.0f - this.e;
        float r25 = this.d;
    L14:
        float r26 = ((r24 - r25) * r23) / 2.0f;
        float r27 = Math.min(r5, r17);
        float r28 = r17 / 2.0f;
        float r29 = 1.0f - (Math.abs(r27 - r28) / r28);
        if (r13 > 0) goto L19;
        float r30 = (r29 * 0.5f) * r26;
        if (r27 <= r28) goto L26;
        r30 = r26 - r30;
    L26:
        if (r12 == false) goto L29;
        r11.setTranslationY(r30);
        return;
    L29:
        r11.setTranslationX(r30);
        return;
    L19:
        if (r27 < r28) goto L21;
        r30 = ((r29 * 0.5f) * r26) + (-r26);
        goto L26
    L21:
        r30 = (r29 * (-0.5f)) * r26;
        goto L26
    L15:
        r23 = r22 * r17;
        r24 = 2.0f - this.f18362c;
        r25 = this.f18361b;
        goto L14
    }
}
