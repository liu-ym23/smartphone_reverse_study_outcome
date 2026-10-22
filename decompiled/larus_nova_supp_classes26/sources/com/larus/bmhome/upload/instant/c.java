package com.larus.bmhome.upload.instant;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final String a;
    public final String b;
    public final Integer c;
    public final Map<String, String> d;
    public final String e;

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageInstantUploadPolicyId(family=" + this.a + ", digest=" + this.b + ", schemaVersion=" + this.c + ", definition=" + this.d + ')';
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.e;
    }

    public c(String r2, String r3, Integer r4, Map<String, String> r5) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        StringBuilder r6 = new StringBuilder("standard:");
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r6.append(r2);
        r6.append(':');
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r6.append(r3);
        r6.append(":v");
        if (r4 == null) goto L11;
        int r7 = r4.intValue();
    L12:
        r6.append(r7);
        this.e = r6.toString();
        return;
    L11:
        r7 = 0;
        goto L12
    }
}
