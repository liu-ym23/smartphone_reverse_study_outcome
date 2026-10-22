package com.larus.doc.impl.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final String a;
    public final long b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final Boolean g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31;
        String r3 = this.e;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.f;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.g;
        if (r10 == null) goto L15;
        r4 = r10.hashCode();
    L15:
        return r9 + r4;
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateDocByMessageSnapshot(conversationId=" + this.a + ", messageId=" + this.b + ", resourceType=" + this.c + ", sourceType=" + this.d + ", artifactVersionId=" + this.e + ", docRealToken=" + this.f + ", useMessageContent=" + this.g + ')';
    }

    public static a a(a r9, String r10, Boolean r11) {
        String r1 = r9.a;
        long r2 = r9.b;
        int r4 = r9.c;
        int r5 = r9.d;
        String r6 = r9.e;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        return new a(r1, r2, r4, r5, r6, r10, r11);
    }

    public a(String r2, long r3, int r5, int r6, String r7, String r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
