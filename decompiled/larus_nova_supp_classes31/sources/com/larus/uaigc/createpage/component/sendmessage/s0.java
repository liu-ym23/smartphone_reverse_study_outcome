package com.larus.uaigc.createpage.component.sendmessage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s0 {
    public static final s0 c = null;
    public final CreationPendingResourceInputType a;
    public final String b;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r6 = (s0) r5;
        if (this.a == r6.a) goto L12;
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
        return "CreationPendingResourceInput(type=" + this.a + ", value=" + this.b + ')';
    }

    static {
        c = new s0(CreationPendingResourceInputType.INVALID, "");
    }

    public final CreationPendingResourceInputType getType() {
        return this.a;
    }

    public s0(CreationPendingResourceInputType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a = r2;
        this.b = r3;
    }
}
