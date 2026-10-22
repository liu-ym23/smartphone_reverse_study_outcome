package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends Animation {
    public final /* synthetic */ MaterialProgressDrawable.b a;
    public final /* synthetic */ MaterialProgressDrawable b;

    public a(MaterialProgressDrawable r1, MaterialProgressDrawable.b r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r9, Transformation r10) {
        if (this.b.j == false) goto L5;
        MaterialProgressDrawable.b r11 = this.a;
        MaterialProgressDrawable.c(r9, r11);
        float r2 = (float) (Math.floor(r11.n / 0.8f) + 1.0d);
        float r0 = (float) Math.toRadians(((double) r11.h) / (r11.r * 6.283185307179586d));
        float r1 = r11.l;
        r11.e = r1 + (((r11.m - r0) - r1) * r9);
        r11.a();
        r11.f = r11.m;
        r11.a();
        float r3 = r11.n;
        r11.g = r3 + ((r2 - r3) * r9);
        r11.a();
        return;
    L5:
        MaterialProgressDrawable.b r12 = this.a;
        float r13 = (float) Math.toRadians(((double) r12.h) / (r12.r * 6.283185307179586d));
        MaterialProgressDrawable.b r4 = this.a;
        float r5 = r4.m;
        float r6 = r4.l;
        float r7 = r4.n;
        this.b.getClass();
        MaterialProgressDrawable.c(r9, r4);
        if (r9 > 0.5f) goto L9;
        float r8 = r6 + ((0.8f - r13) * MaterialProgressDrawable.l.getInterpolation(r9 / 0.5f));
        MaterialProgressDrawable.b r14 = this.a;
        r14.e = r8;
        r14.a();
    L9:
        if (r9 <= 0.5f) goto L11;
        float r15 = r5 + ((0.8f - r13) * MaterialProgressDrawable.l.getInterpolation((r9 - 0.5f) / 0.5f));
        MaterialProgressDrawable.b r16 = this.a;
        r16.f = r15;
        r16.a();
    L11:
        MaterialProgressDrawable.b r17 = this.a;
        r17.g = r7 + (0.25f * r9);
        r17.a();
        MaterialProgressDrawable r18 = this.b;
        r18.c = (r9 * 216.0f) + ((r18.g / 5.0f) * 1080.0f);
        r18.invalidateSelf();
    }
}
