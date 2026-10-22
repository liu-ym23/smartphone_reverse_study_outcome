package com.larus.chat.gallery.impl.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;
    public final boolean g;
    public final Boolean h;
    public final boolean i;
    public final boolean j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
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
        Boolean r11 = this.f;
        int r12 = 0;
        if (r11 != null) goto L25;
        int r13 = 0;
    L26:
        int r14 = (r10 + r13) * 31;
        if (this.g == false) goto L29;
        int r15 = 1231;
    L30:
        int r16 = (r14 + r15) * 31;
        Boolean r17 = this.h;
        if (r17 == null) goto L34;
        r12 = r17.hashCode();
    L34:
        int r18 = (r16 + r12) * 31;
        if (this.i == false) goto L37;
        int r19 = 1231;
    L38:
        int r20 = (r18 + r19) * 31;
        if (this.j == true) goto L43;
        r1 = 1237;
    L43:
        return r20 + r1;
    L37:
        r19 = 1237;
        goto L38
    L29:
        r15 = 1237;
        goto L30
    L25:
        r13 = r11.hashCode();
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
        return "PreviewAlbumFlowPolicy(showPlusButton=" + this.a + ", includeCurrentImage=" + this.b + ", includeCurrentVideo=" + this.c + ", fallbackToOriginImage=" + this.d + ", includeCurrentRawImage=" + this.e + ", supportVideo=" + this.f + ", injectCurrentDraft=" + this.g + ", useUnifiedPreview=" + this.h + ", registerSingleResult=" + this.i + ", closeOnAlbumSend=" + this.j + ')';
    }

    public c(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, Boolean r6, boolean r7, Boolean r8, boolean r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
