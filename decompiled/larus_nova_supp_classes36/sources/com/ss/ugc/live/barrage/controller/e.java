package com.ss.ugc.live.barrage.controller;

import java.util.Comparator;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Comparator<Integer> {
    public int a;
    public int b;
    public final /* synthetic */ ScrollBarrageController c;

    public e(ScrollBarrageController r1) {
        this.c = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Integer r6, Integer r7) {
        int r8 = r6.intValue();
        int r9 = r7.intValue();
        float r0 = this.c.s(r8);
        float r1 = this.c.s(r9);
        if (r0 >= (this.a - this.c.t())) goto L6;
        r0 = 0.0f;
    L6:
        if (r1 >= (this.a - this.c.t())) goto L9;
        r1 = 0.0f;
    L9:
        if (r0 != r1) goto L28;
        f r2 = this.c.t;
        int r3 = this.b;
        r2.getClass();
        if (r3 < 5) goto L14;
        int r4 = Math.abs(r8 - 2);
    L17:
        int r5 = r3 - r4;
        f r10 = this.c.t;
        int r11 = this.b;
        r10.getClass();
        if (r11 < 5) goto L20;
        int r12 = Math.abs(r9 - 2);
    L23:
        int r13 = r11 - r12;
        if (r5 != r13) goto L27;
        return MathKt.getSign(r8 - r9);
    L27:
        return MathKt.getSign(r13 - r5);
    L20:
        if (r11 < 3) goto L22;
        r12 = Math.abs(r9 - 1);
        goto L23
    L22:
        r12 = r9;
        goto L23
    L14:
        if (r3 < 3) goto L16;
        r4 = Math.abs(r8 - 1);
        goto L17
    L16:
        r4 = r8;
        goto L17
    L28:
        return MathKt.getSign((int) (r0 - r1));
    }
}
