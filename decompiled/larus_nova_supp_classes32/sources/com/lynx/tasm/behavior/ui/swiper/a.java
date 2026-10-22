package com.lynx.tasm.behavior.ui.swiper;

import android.view.View;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements ViewPager.e {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;

    public a() {
        this.a = 0.0f;
        this.b = 0.8f;
        this.c = 1.0f;
        this.d = 0.8f;
        this.e = 1.0f;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void a(View r2) {
        if (r2 == null) goto L5;
        r2.setScaleX(1.0f);
        r2.setScaleY(1.0f);
        r2.setTranslationX(0.0f);
        r2.setTranslationY(0.0f);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void b(ViewPager r7, View r8, boolean r9, int r10) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (this.c >= this.b) goto L6;
        return;
    L6:
        if (this.e >= this.d) goto L8;
        return;
    L8:
        if (r7.getChildExpectSize() <= 0) goto L32;
        float r0 = Math.abs(r10);
        int r11 = r7.getChildExpectSize();
        float r1 = this.c;
        float r2 = this.b;
        float r12 = r11;
        float r4 = this.e;
        float r5 = r4 - (((r4 - this.d) * r0) / r12);
        float r3 = MathUtils.clamp(r1 - (((r1 - r2) * r0) / r12), r2, r1);
        float r6 = MathUtils.clamp(r5, this.d, this.e);
        r8.setScaleX(r3);
        r8.setScaleY(r6);
        float r13 = this.a;
        if (r13 > 0.0f) goto L12;
        return;
    L12:
        if (r9 == false) goto L14;
        float r14 = r13 * r12;
        float r15 = 2.0f - this.e;
        float r16 = this.d;
    L15:
        float r17 = (r14 * (r15 - r16)) / 2.0f;
        float r18 = Math.min(r0, r12);
        float r19 = r12 / 2.0f;
        float r20 = 1.0f - (Math.abs(r18 - r19) / r19);
        if (r10 > 0) goto L18;
        float r21 = r20 * 0.5f;
        if (r18 > r19) goto L24;
    L23:
        float r22 = r21 * r17;
    L25:
        if (r9 == false) goto L27;
        r8.setTranslationY(r22);
        return;
    L27:
        r8.setTranslationX(r22);
        return;
    L24:
        r22 = r17 - (r21 * r17);
        goto L25
    L18:
        if (r18 < r19) goto L20;
        r22 = (-r17) + ((r20 * 0.5f) * r17);
        goto L25
    L20:
        r21 = r20 * (-0.5f);
        goto L23
    L14:
        r14 = r13 * r12;
        r15 = 2.0f - this.c;
        r16 = this.b;
        goto L15
    }
}
