package com.bytedance.sdk.xbridge.cn.optimize;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f7356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashSet f7357b;

    public c(HashSet r5, HashSet r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        r10 = null;
    L8:
        this.f7356a = r5;
        this.f7357b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        if (Intrinsics.areEqual(this.f7356a, r10.f7356a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f7357b, r10.f7357b) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        HashSet r5 = this.f7356a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 961;
        HashSet r13 = this.f7357b;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return (r12 + r10) * 961;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "ThreadOptConfig(threadOptSchemas=" + this.f7356a + ", syncMethods=null, asyncMethods=" + this.f7357b + ", mainThreadMethods=null, mainThreadOptMethods=null)";
    }
}
