package com.larus.camera.impl.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public final Map<String, String> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof q) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((q) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RouteSign(sdkInfo=" + this.a + ')';
    }

    public q(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "sdkInfo");
        this.a = r2;
    }
}
