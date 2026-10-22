package com.bytedance.ai.utils;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2850a;

    public g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.f2850a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f2850a, ((g) r5).f2850a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f2850a.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("StringResponse(data="), this.f2850a, ')');
    }
}
