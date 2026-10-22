package mh8;

import jc8.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements l {
    public final int a;
    public final int b;
    public final Integer c;

    public c() {
        this(0);
    }

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownEmbeddedBlockLayoutConfig(contentPaddingStart=" + this.a + ", contentPaddingEnd=" + this.b + ", contentMaxWidth=" + this.c + ')';
    }

    public /* synthetic */ c(int r2) {
        this(0, 0, null);
    }

    public c(int r1, int r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
