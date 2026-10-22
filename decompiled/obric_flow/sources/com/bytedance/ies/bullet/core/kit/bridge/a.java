package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f5334a;

    public a(d r5) {
        Intrinsics.checkNotNullParameter(r5, "otherRegistry");
        this.f5334a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f5334a, ((a) r5).f5334a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5334a.hashCode() * 31;
        return Boolean.hashCode(false) + r5;
    }

    public final String toString() {
        return "BridgeMergeOperation(otherRegistry=" + this.f5334a + ", useOthersOnConflict=false)";
    }
}
