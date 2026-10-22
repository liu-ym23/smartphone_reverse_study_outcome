package com.obric.aiagent.messenger.stub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m1 {
    public final String a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof m1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((m1) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Failure(reason=" + this.a + ')';
    }

    public m1() {
        Intrinsics.checkNotNullParameter("encode_exception", "reason");
        this.a = "encode_exception";
    }
}
