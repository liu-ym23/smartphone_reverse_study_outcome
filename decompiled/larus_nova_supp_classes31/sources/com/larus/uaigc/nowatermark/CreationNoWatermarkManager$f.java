package com.larus.uaigc.nowatermark;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationNoWatermarkManager$f {
    public final Set<String> a;
    public final Set<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationNoWatermarkManager$f) == true) goto L8;
        return false;
    L8:
        CreationNoWatermarkManager$f r6 = (CreationNoWatermarkManager$f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ResourceKeys(imageKeys=" + this.a + ", videoVids=" + this.b + ')';
    }

    public final boolean a() {
        if (this.a.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b.isEmpty() == false) goto L7;
        return true;
    }

    public CreationNoWatermarkManager$f(Set<String> r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "imageKeys");
        Intrinsics.checkNotNullParameter(r3, "videoVids");
        this.a = r2;
        this.b = r3;
    }
}
