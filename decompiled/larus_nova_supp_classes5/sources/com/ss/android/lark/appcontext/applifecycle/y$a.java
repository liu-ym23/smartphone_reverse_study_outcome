package com.ss.android.lark.appcontext.applifecycle;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class y$a {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final long e;

    public y$a() {
        this(null, null, null, 0);
    }

    public final String toString() {
        return String.format("topProc:%s, topAct: %s, appFront: %s, procFront: %s", new Object[]{this.a, this.b, Boolean.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof y$a) == false) goto L12;
        y$a r5 = (y$a) r4;
        if (this.c == r5.c) goto L7;
        return false;
    L7:
        if (this.d == r5.d) goto L9;
        return false;
    L9:
        if (Objects.equals(this.b, r5.b) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public y$a(String r4, String r5, String r6, long r7) {
        this.a = r4;
        boolean r0 = true;
        if (r4 == null) goto L5;
        boolean r2 = true;
    L6:
        this.c = r2;
        this.b = r5;
        if (r6 != null) goto L9;
    L11:
        r0 = false;
    L12:
        this.d = r0;
        this.e = r7;
        return;
    L9:
        if (r6.equals(r4) == false) goto L11;
    L5:
        r2 = false;
        goto L6
    }

    public static y$a a(String r7, String r8, String r9, long r10) {
        return new y$a(r7, r8, r9, r10);
    }
}
