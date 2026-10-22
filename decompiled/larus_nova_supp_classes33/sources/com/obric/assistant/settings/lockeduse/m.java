package com.obric.assistant.settings.lockeduse;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public final boolean a;
    public final List<l> b;

    public m() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricLockedUseUiState(enabled=" + this.a + ", rows=" + this.b + ')';
    }

    public /* synthetic */ m(int r2) {
        this(false, CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(boolean r2, List<? extends l> r3) {
        Intrinsics.checkNotNullParameter(r3, "rows");
        this.a = r2;
        this.b = r3;
    }
}
