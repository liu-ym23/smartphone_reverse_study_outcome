package com.obric.assistant.obric_action;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h<T> {
    public static final a d = null;
    public final boolean a;
    public final String b;
    public final T c;

    public static final class a {
        public a() {
        }

        public final h<Unit> b(boolean r3) {
            if (r3 == false) goto L6;
            return c(this, null, null, 3);
        L6:
            return a(this, null, 3);
        }

        public static h a(a r1, String r2, int r3) {
            if ((r3 & 1) == 0) goto L5;
            r2 = "failed";
        L5:
            r1.getClass();
            return new h(false, r2, null);
        }

        public static h c(a r2, Object r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            r2.getClass();
            return new h(true, r4, r3);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        T r6 = this.c;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricActionResult(success=" + this.a + ", msg=" + this.b + ", data=" + this.c + ')';
    }

    static {
        d = new a();
    }

    public h(boolean r1, String r2, T r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
