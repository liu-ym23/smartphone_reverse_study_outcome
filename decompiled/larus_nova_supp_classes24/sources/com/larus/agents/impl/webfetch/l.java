package com.larus.agents.impl.webfetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public static final /* synthetic */ int d = 0;
    public final int a;
    public final String b;
    public final String c;

    public static final class a {
        public static l a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            return new l(r3, null, r2);
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "WebFetchOutcome(httpCode=" + this.a + ", reason=" + this.c + ')';
    }

    public l(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
