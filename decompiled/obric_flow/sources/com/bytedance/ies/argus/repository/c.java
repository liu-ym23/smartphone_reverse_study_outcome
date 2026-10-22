package com.bytedance.ies.argus.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        ((c) r5).getClass();
        if (Intrinsics.areEqual("host", "host") == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return 99467096 * 31;
    }

    public final String toString() {
        return "AspectConfigInfo(cId=host, config=null, version=null)";
    }
}
