package com.larus.bmhome.music.player;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final ad9.b a;
    public final String b;
    public final float c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final boolean h;

    public k() {
        ad9.b r0 = null;
        this(r0, r0, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        ad9.b r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((((r1 * 31) + this.b.hashCode()) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31;
        int r3 = 1231;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((r5 + r6) * 31) + this.g) * 31;
        if (this.h == true) goto L19;
        r3 = 1237;
    L19:
        return r7 + r3;
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "StreamPlayState(playingPlayList=" + this.a + ", chunkUrl=" + this.b + ", currentPlayTime=" + this.c + ", currentProgress=" + this.d + ", playingChunk=" + this.e + ", waitingToVideoEnginePlay=" + this.f + ", waitingResumeTime=" + this.g + ", playingVid=" + this.h + ')';
    }

    public /* synthetic */ k(ad9.b r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r10 = null;
    L5:
        ad9.b r1 = r10;
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        String r2 = r11;
        if ((r12 & 4) == 0) goto L11;
        float r3 = 60000.0f;
    L12:
        this(r1, r2, r3, 0.0f, false, false, 0, false);
        return;
    L11:
        r3 = 0.0f;
        goto L12
    }

    public k(ad9.b r2, String r3, float r4, float r5, boolean r6, boolean r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r3, "chunkUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public static k a(k r9, ad9.b r10, String r11, float r12, float r13, boolean r14, boolean r15, int r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        ad9.b r2 = r9.a;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r3 = r9.b;
    L11:
        if ((r17 & 4) == 0) goto L13;
        float r4 = r9.c;
    L15:
        if ((r17 & 8) == 0) goto L17;
        float r5 = r9.d;
    L19:
        if ((r17 & 16) == 0) goto L21;
        boolean r6 = r9.e;
    L23:
        if ((r17 & 32) == 0) goto L25;
        boolean r7 = r9.f;
    L27:
        if ((r17 & 64) == 0) goto L29;
        int r8 = r9.g;
    L31:
        if ((r17 & 128) == 0) goto L33;
        boolean r1 = r9.h;
    L34:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "chunkUrl");
        return new k(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = false;
        goto L34
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
