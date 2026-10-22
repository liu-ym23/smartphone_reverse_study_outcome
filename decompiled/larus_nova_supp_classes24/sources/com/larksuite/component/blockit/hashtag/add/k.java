package com.larksuite.component.blockit.hashtag.add;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public final List<oy7.e> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((k) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<oy7.e> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "InitData(hashTagList=" + this.a + ')';
    }

    public k(List<oy7.e> r1) {
        this.a = r1;
    }
}
