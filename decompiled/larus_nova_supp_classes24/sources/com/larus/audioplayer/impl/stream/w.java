package com.larus.audioplayer.impl.stream;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w {
    public int a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (this.a == r6.a) goto L12;
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
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "StreamChunkPackage(id=" + this.a + ", event=" + this.b + ", data=" + this.c + ')';
    }

    public w() {
        Intrinsics.checkNotNullParameter("json", "event");
        Intrinsics.checkNotNullParameter("", "data");
        this.a = -1;
        this.b = "json";
        this.c = "";
    }
}
