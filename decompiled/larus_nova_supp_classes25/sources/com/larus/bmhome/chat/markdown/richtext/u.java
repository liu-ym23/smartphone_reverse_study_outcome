package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u extends t {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final r f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "ResourceReplacement(start=" + this.a + ", end=" + this.b + ", displayText=" + this.c + ", label=" + this.d + ", destination=" + this.e + ", resource=" + this.f + ')';
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final String a() {
        return this.c;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int b() {
        return this.b;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int c() {
        return this.a;
    }

    public u(int r2, int r3, String r4, String r5, String r6, r r7) {
        Intrinsics.checkNotNullParameter(r4, "displayText");
        Intrinsics.checkNotNullParameter(r5, "label");
        Intrinsics.checkNotNullParameter(r6, "destination");
        Intrinsics.checkNotNullParameter(r7, "resource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
