package com.larus.bmhome.chat.referenceicon;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final List<String> a;
    public final Integer b;

    public b() {
        this(null, null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Integer r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "AttachmentReferenceVisual(thumbnailSources=" + this.a + ", fileIconRes=" + this.b + ')';
    }

    public b(List r2, Integer r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "thumbnailSources");
        this.a = r2;
        this.b = r3;
    }
}
