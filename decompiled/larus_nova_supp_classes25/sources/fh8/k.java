package fh8;

import io.noties.markwon.core.spans.CustomLinkSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public final CustomLinkSpan a;
    public final lw8.k b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "MarkdownLinkSpanRecord(span=" + this.a + ", linkInfo=" + this.b + ')';
    }

    public k(CustomLinkSpan r2, lw8.k r3) {
        Intrinsics.checkNotNullParameter(r2, "span");
        Intrinsics.checkNotNullParameter(r3, "linkInfo");
        this.a = r2;
        this.b = r3;
    }
}
