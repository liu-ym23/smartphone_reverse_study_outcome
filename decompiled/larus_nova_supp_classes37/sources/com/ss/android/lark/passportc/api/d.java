package com.ss.android.lark.passportc.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final d g = null;
    public final boolean a;
    public final ExecuteStrategy b;
    public final j0c.a c;
    public Scene d;
    public final ReturnType e;
    public final boolean f;

    public static final class a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        boolean r2 = false;
        Object[] r0 = 0 == true ? 1 : 0;
        this(r2, null, r0, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        j0c.a r3 = this.c;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        Scene r7 = this.d;
        if (r7 == null) goto L14;
        r4 = r7.hashCode();
    L14:
        int r8 = (((r6 + r4) * 31) + this.e.hashCode()) * 31;
        if (this.f == true) goto L19;
        r1 = 1237;
    L19:
        return r8 + r1;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ExecuteMode(executeTask=" + this.a + ", executeStrategy=" + this.b + ", preExecuteTaskResult=" + this.c + ", scene=" + this.d + ", returnType=" + this.e + ", enqueueSynchronously=" + this.f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean r3 = false;
        Object[] r1 = 0 == true ? 1 : 0;
        g = new d(r3, null, r1, 62);
    }

    public static d a(d r7, Scene r8) {
        boolean r1 = r7.a;
        ExecuteStrategy r2 = r7.b;
        j0c.a r3 = r7.c;
        ReturnType r5 = r7.e;
        boolean r6 = r7.f;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "executeStrategy");
        Intrinsics.checkNotNullParameter(r5, "returnType");
        return new d(r1, r2, r3, r8, r5, r6);
    }

    public /* synthetic */ d(boolean r8, Scene r9, ReturnType r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r11 & 2) == 0) goto L9;
        ExecuteStrategy r2 = ExecuteStrategy.NORMAL;
    L11:
        if ((r11 & 8) == 0) goto L13;
        Scene r4 = null;
    L15:
        if ((r11 & 16) == 0) goto L17;
        r10 = ReturnType.All;
    L17:
        this(r1, r2, null, r4, r10, false);
        return;
    L13:
        r4 = r9;
        goto L15
    L9:
        r2 = null;
        goto L11
    L5:
        r1 = r8;
        goto L7
    }

    public d(boolean r2, ExecuteStrategy r3, j0c.a r4, Scene r5, ReturnType r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "executeStrategy");
        Intrinsics.checkNotNullParameter(r6, "returnType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
