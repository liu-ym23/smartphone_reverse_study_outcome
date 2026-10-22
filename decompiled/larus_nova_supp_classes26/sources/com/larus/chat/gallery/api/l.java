package com.larus.chat.gallery.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public l() {
        this(false, false, false, false, false, false, false, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.g == true) goto L31;
        r1 = 1237;
    L31:
        return r12 + r1;
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewCapability(canUseInput=" + this.a + ", canSelect=" + this.b + ", canEdit=" + this.c + ", canRemove=" + this.d + ", canApplyOwnerMutation=" + this.e + ", canSend=" + this.f + ", canOpenAlbum=" + this.g + ')';
    }

    public l(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public /* synthetic */ l(boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r15 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r15 & 4) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r15 & 8) == 0) goto L17;
        boolean r4 = false;
    L19:
        if ((r15 & 16) == 0) goto L21;
        boolean r5 = false;
    L23:
        if ((r15 & 32) == 0) goto L25;
        boolean r6 = false;
    L27:
        if ((r15 & 64) == 0) goto L29;
        boolean r16 = false;
    L30:
        this(r0, r2, r3, r4, r5, r6, r16);
        return;
    L29:
        r16 = r14;
        goto L30
    L25:
        r6 = r13;
        goto L27
    L21:
        r5 = r12;
        goto L23
    L17:
        r4 = r11;
        goto L19
    L13:
        r3 = r10;
        goto L15
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }
}
