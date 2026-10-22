package com.larus.bmhome.music.save_video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    public final String a;
    public final Exception b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
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
        return "MuxingError(message=" + this.a + ", exception=" + this.b + ')';
    }

    public s(Exception r3) {
        Intrinsics.checkNotNullParameter("Start encoder failed", "message");
        Intrinsics.checkNotNullParameter(r3, "exception");
        this.a = "Start encoder failed";
        this.b = r3;
    }
}
