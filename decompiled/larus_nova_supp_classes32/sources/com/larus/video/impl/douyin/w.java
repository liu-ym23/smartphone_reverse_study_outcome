package com.larus.video.impl.douyin;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w {
    public final String a;
    public final List<String> b;
    public final List<Pair<String, String>> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "EnterDouYinSdkParam(enterItemId=" + this.a + ", enterAids=" + this.b + ", interactiveRecInfoList=" + this.c + ')';
    }

    public w(String r2, List<String> r3, List<Pair<String, String>> r4) {
        Intrinsics.checkNotNullParameter(r2, "enterItemId");
        Intrinsics.checkNotNullParameter(r3, "enterAids");
        Intrinsics.checkNotNullParameter(r4, "interactiveRecInfoList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
