package com.bytedance.android.anniex.utils;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3502a;

    public d() {
        this.f3502a = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f3502a, ((d) r5).f3502a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f3502a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("PageOptContainer(pageOpt="), this.f3502a, ')');
    }
}
