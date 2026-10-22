package com.lynx.tasm.behavior.ui.utils;

import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static final int[] e = null;
    public final float[] a;
    public int b;
    public final float c;
    public boolean d;

    public k() {
        this(0.0f);
    }

    static {
        e = new int[]{1, 2, 4, 8, 16, 32, 64, LynxTouchEvent.kPseudoStateFocusTransition, 256};
    }

    public k(float r2) {
        this.a = new float[]{1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f};
        this.b = 0;
        this.c = r2;
    }

    public final float a(int r5) {
        if (r5 != 4) goto L5;
    L8:
        float r0 = 1.0E21f;
    L9:
        int r1 = this.b;
        if (r1 != 0) goto L12;
        return r0;
    L12:
        int[] r2 = e;
        if ((r2[r5] & r1) == 0) goto L17;
        return this.a[r5];
    L17:
        if (this.d == true) goto L19;
    L33:
        return r0;
    L19:
        if (r5 != 1) goto L21;
    L24:
        char r6 = 7;
    L26:
        if ((r2[r6] & r1) == 0) goto L30;
        return this.a[r6];
    L30:
        if ((r1 & r2[8]) == 0) goto L33;
        return this.a[8];
    L21:
        if (r5 == 3) goto L24;
        r6 = 6;
        goto L26
    L5:
        if (r5 == 5) goto L8;
        r0 = this.c;
        goto L9
    }

    public final boolean b(int r4, float r5) {
        boolean r1 = false;
        if (com.lynx.tasm.utils.b.a(this.a[r4], r5) == true) goto L17;
        this.a[r4] = r5;
        boolean r6 = y6a.l.a(r5);
        int[] r0 = e;
        if (r6 == false) goto L7;
        int r7 = this.b;
        this.b = (~r0[r4]) & r7;
    L8:
        int r8 = this.b;
        if ((r0[8] & r8) == 0) goto L11;
    L14:
        r1 = true;
    L15:
        this.d = r1;
        return true;
    L11:
        if ((r0[7] & r8) != 0) goto L14;
        if ((r8 & r0[6]) == 0) goto L15;
    L7:
        int r9 = this.b;
        this.b = r0[r4] | r9;
        goto L8
    L17:
        return false;
    }
}
