package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final int a;
    public final int b;
    public final String c;
    public final MessageMarkdownLinkSource d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "MessageMarkdownLinkSpan(start=" + this.a + ", end=" + this.b + ", url=" + this.c + ", source=" + this.d + ')';
    }

    public g(int r2, int r3, String r4, MessageMarkdownLinkSource r5) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static g a(g r1, int r2, int r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r5 & 8) == 0) goto L14;
        MessageMarkdownLinkSource r6 = r1.d;
    L15:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r6, "source");
        return new g(r2, r3, r4, r6);
    L14:
        r6 = null;
        goto L15
    }
}
