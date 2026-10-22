package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class d0 {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public final int i;
    public final int j;
    public final float k;
    public final float l;
    public final float m;
    public final float n;
    public final TimeInterpolator o;
    public final long p;

    public d0(int r7, int r8, float r9, float r10, float r11, TimeInterpolator r13, TimeInterpolator r14, TimeInterpolator r15, int r16) {
        if ((r16 & 1) == 0) goto L6;
        r7 = g.a;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r8 = g.a;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r9 = 0.6f;
    L12:
        if ((r16 & 8) == 0) goto L14;
        float r0 = 1.0f;
    L16:
        if ((r16 & 16) == 0) goto L19;
        r10 = 0.0f;
    L19:
        if ((r16 & 32) == 0) goto L22;
        r11 = 0.0f;
    L22:
        if ((r16 & 64) == 0) goto L25;
        r13 = new AccelerateDecelerateInterpolator();
    L25:
        if ((r16 & 128) == 0) goto L27;
        r14 = new AccelerateDecelerateInterpolator();
    L27:
        int r3 = 0;
        if ((r16 & 256) == 0) goto L30;
        int r2 = g.b;
    L32:
        if ((r16 & 512) == 0) goto L35;
        r3 = g.b;
    L35:
        if ((r16 & 16384) == 0) goto L38;
        r15 = new AccelerateDecelerateInterpolator();
    L38:
        if ((r16 & 32768) == 0) goto L40;
        long r4 = 1000;
    L41:
        Intrinsics.checkNotNullParameter(r13, "avatarPathInterpolator");
        Intrinsics.checkNotNullParameter(r14, "avatarAlphaInterpolator");
        Intrinsics.checkNotNullParameter(r15, "normalPathInterpolator");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r0;
        this.e = r10;
        this.f = r11;
        this.g = r13;
        this.h = r14;
        this.i = r2;
        this.j = r3;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = r15;
        this.p = r4;
        return;
    L40:
        r4 = 0;
        goto L41
    L30:
        r2 = 0;
        goto L32
    L14:
        r0 = 0.0f;
        goto L16
    }
}
