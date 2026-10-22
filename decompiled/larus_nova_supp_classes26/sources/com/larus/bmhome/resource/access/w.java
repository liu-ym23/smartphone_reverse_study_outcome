package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w {
    public final x a;
    public final j0 b;
    public final ResourceMediaType c;
    public final g0 d;

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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "ResourceAccessRequest(scene=" + this.a + ", resourceInput=" + this.b + ", mediaType=" + this.c + ", bizContext=" + this.d + ')';
    }

    public static w a(w r2, j0.b r3, g0 r4) {
        x r0 = r2.a;
        ResourceMediaType r5 = r2.c;
        Intrinsics.checkNotNullParameter(r0, "scene");
        Intrinsics.checkNotNullParameter(r3, "resourceInput");
        Intrinsics.checkNotNullParameter(r5, "mediaType");
        Intrinsics.checkNotNullParameter(r4, "bizContext");
        return new w(r0, r3, r5, r4);
    }

    public w(x r2, j0 r3, ResourceMediaType r4, g0 r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "resourceInput");
        Intrinsics.checkNotNullParameter(r4, "mediaType");
        Intrinsics.checkNotNullParameter(r5, "bizContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
