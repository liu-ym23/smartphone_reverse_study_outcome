package com.obric.assistant.settings.memory;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f0 {
    public final List<y> a;

    public f0() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((f0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ObricReferenceMemoryUiState(rows=" + this.a + ')';
    }

    public f0(List<y> r2) {
        Intrinsics.checkNotNullParameter(r2, "rows");
        this.a = r2;
    }

    public /* synthetic */ f0(int r1) {
        this(CollectionsKt.emptyList());
    }
}
