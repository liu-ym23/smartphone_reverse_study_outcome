package ilb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final a j;

    public b() {
        this(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1023);
    }

    public b(int r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = 0.0f;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = 0.0f;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = 0.0f;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r7 = 0.0f;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r8 = 0.0f;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r9 = 0.0f;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r10 = 0.0f;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r11 = 0.0f;
    L30:
        if ((r12 & 512) == 0) goto L32;
        a r13 = new a(0);
    L33:
        Intrinsics.checkNotNullParameter(r13, "state");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
        return;
    L32:
        r13 = null;
        goto L33
    }
}
