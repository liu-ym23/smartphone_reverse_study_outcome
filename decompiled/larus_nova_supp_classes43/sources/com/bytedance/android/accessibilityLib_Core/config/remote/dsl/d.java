package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final List<c> a;

    public static final class a {
    }

    static {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((d) r10).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<c> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "LabelConfigListDsl(labelDslList=" + this.a + ')';
    }

    public /* synthetic */ d(int r1) {
        this(CollectionsKt.emptyList());
    }

    public d(List<c> r1) {
        this.a = r1;
    }
}
