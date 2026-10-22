package com.ss.android.lark.chat.base.model.dispatch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final f f = null;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public static final class a {
    }

    static {
        f = new f(false, false, false, true, false);
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == true) goto L23;
        r1 = 1237;
    L23:
        return r8 + r1;
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        if (this.a == false) goto L6;
        return "{ bizEnablePreUpload: " + this.a + " }";
    L6:
        if (Intrinsics.areEqual(this, f) == false) goto L9;
        return "{ default }";
    L9:
        return "{ isChat: " + this.b + ", isThreadChat: " + this.c + ", isSecretChat: " + this.d + ", isPostInputState: " + this.e + " }";
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof f) == false) goto L5;
        f r5 = (f) r4;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (this.a == r5.a) goto L12;
        return false;
    L12:
        if (this.b == r5.b) goto L14;
        return false;
    L14:
        if (this.c == r5.c) goto L16;
        return false;
    L16:
        if (this.d == r5.d) goto L18;
        return false;
    L18:
        if (this.e != r5.e) goto L25;
        return true;
    L25:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public f(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
