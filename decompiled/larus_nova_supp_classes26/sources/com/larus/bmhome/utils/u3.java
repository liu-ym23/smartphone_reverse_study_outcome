package com.larus.bmhome.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u3 {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u3) == true) goto L8;
        return false;
    L8:
        u3 r6 = (u3) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "TaskKey(conversationId=" + this.a + ", pageScopeId=" + this.b + ')';
    }

    public u3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        this.a = r2;
        this.b = r3;
    }
}
