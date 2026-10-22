package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 {
    public static final /* synthetic */ int d = 0;
    public final boolean a;
    public final boolean b;
    public final SelectResultReason c;

    public static final class a {
        public static a0 a(boolean r2, SelectResultReason r3) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            return new a0(false, r2, r3);
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectResult(success=" + this.a + ", selected=" + this.b + ", reason=" + this.c + ')';
    }

    public a0(boolean r2, boolean r3, SelectResultReason r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
