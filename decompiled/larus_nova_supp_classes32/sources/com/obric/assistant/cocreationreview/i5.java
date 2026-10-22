package com.obric.assistant.cocreationreview;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i5 {
    public final l5 a;
    public final List<a> b;
    public final List<a> c;
    public final Map<String, a5> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i5) == true) goto L8;
        return false;
    L8:
        i5 r6 = (i5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "LabelingSnapshot(moduleMeta=" + this.a + ", pendingRecords=" + this.b + ", completedRecords=" + this.c + ", feedbackByRecordId=" + this.d + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i5(l5 r2, List<? extends a> r3, List<? extends a> r4, Map<String, a5> r5) {
        Intrinsics.checkNotNullParameter(r2, "moduleMeta");
        Intrinsics.checkNotNullParameter(r3, "pendingRecords");
        Intrinsics.checkNotNullParameter(r4, "completedRecords");
        Intrinsics.checkNotNullParameter(r5, "feedbackByRecordId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
