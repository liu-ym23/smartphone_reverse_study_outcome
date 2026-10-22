package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 {
    public final String a;
    public final String b;
    public final InputReferenceType c;
    public final String d;
    public final String e;
    public final i0 f;
    public final String g;
    public final com.larus.bmhome.chat.referenceicon.b h;
    public final String i;
    public final String j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r6 = (d0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        i0 r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        com.larus.bmhome.chat.referenceicon.b r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.j;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InputReference(id=" + this.a + ", name=" + this.b + ", type=" + this.c + ", protocolDestination=" + this.d + ", iconUrl=" + this.e + ", documentIcon=" + this.f + ", rawProtocolText=" + this.g + ", attachmentVisual=" + this.h + ", avatarKey=" + this.i + ", avatarEntityId=" + this.j + ')';
    }

    public final InputReferenceType getType() {
        return this.c;
    }

    public static d0 a(d0 r15, String r16, String r17, int r18) {
        String r3 = null;
        if ((r18 & 1) == 0) goto L5;
        String r5 = r15.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r6 = r15.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        InputReferenceType r7 = r15.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r8 = r15.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r9 = r15.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        i0 r10 = r15.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r11 = r15.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        com.larus.bmhome.chat.referenceicon.b r12 = r15.h;
    L35:
        if ((r18 & 256) == 0) goto L37;
        String r13 = r15.i;
    L39:
        if ((r18 & 512) == 0) goto L41;
        r3 = r15.j;
    L41:
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, "type");
        return new d0(r5, r6, r7, r8, r9, r10, r11, r12, r13, r3);
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public d0(String r2, String r3, InputReferenceType r4, String r5, String r6, i0 r7, String r8, com.larus.bmhome.chat.referenceicon.b r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public /* synthetic */ d0(String r15, String r16, InputReferenceType r17, String r18, String r19, i0 r20, String r21, com.larus.bmhome.chat.referenceicon.b r22, String r23, String r24, int r25) {
        if ((r25 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r25 & 32) == 0) goto L13;
        i0 r9 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r25 & 128) == 0) goto L21;
        com.larus.bmhome.chat.referenceicon.b r11 = null;
    L23:
        if ((r25 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r25 & 512) == 0) goto L29;
        String r13 = null;
    L30:
        this(r15, r16, r17, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r24;
        goto L30
    L25:
        r12 = r23;
        goto L27
    L21:
        r11 = r22;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }
}
