package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final boolean a;
    public final ctc.a b;
    public final ctc.e c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        ctc.a r3 = this.b;
        if (r3 != null) goto L8;
        int r4 = 0;
    L10:
        return ((((r2 + r4) * 31) + this.c.hashCode()) * 31) + this.d;
    L8:
        r4 = r3.hashCode();
        goto L10
    }

    public final String toString() {
        return "CodeBlockScrollableInfo(enableScroll=" + this.a + ", scrollable=" + this.b + ", scrollBarTheme=" + this.c + ", codeTextColor=" + this.d + ')';
    }

    public b(boolean r2, ctc.a r3, ctc.e r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "scrollBarTheme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
