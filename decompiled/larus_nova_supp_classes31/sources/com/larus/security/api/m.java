package com.larus.security.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public final String toString() {
        return "TtCnpaManualWriteParams(inputFilePath=" + this.a + ", outputFilePath=" + this.b + ", label=" + this.c + ", contentProducer=" + this.d + ", produceId=" + this.e + ", reservedCode1=" + this.f + ", contentPropagator=" + this.g + ", propagateId=" + this.h + ", reservedCode2=" + this.i + ')';
    }

    public m(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "inputFilePath");
        Intrinsics.checkNotNullParameter(r6, "outputFilePath");
        Intrinsics.checkNotNullParameter("1", "label");
        Intrinsics.checkNotNullParameter("001191110102MACQD9K64010000", "contentProducer");
        Intrinsics.checkNotNullParameter(r7, "produceId");
        Intrinsics.checkNotNullParameter("", "reservedCode1");
        Intrinsics.checkNotNullParameter("", "contentPropagator");
        Intrinsics.checkNotNullParameter("", "propagateId");
        Intrinsics.checkNotNullParameter("", "reservedCode2");
        this.a = r5;
        this.b = r6;
        this.c = "1";
        this.d = "001191110102MACQD9K64010000";
        this.e = r7;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
    }
}
