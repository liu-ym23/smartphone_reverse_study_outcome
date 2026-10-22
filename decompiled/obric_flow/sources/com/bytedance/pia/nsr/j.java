package com.bytedance.pia.nsr;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7199b;

    public j(boolean r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        this.f7198a = r5;
        this.f7199b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        if (this.f7198a == r10.f7198a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7199b, r10.f7199b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f7198a) * 31;
        return this.f7199b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Record(once=");
        r5.append(this.f7198a);
        r5.append(", result=");
        return j0.p(r5, this.f7199b, ')');
    }
}
