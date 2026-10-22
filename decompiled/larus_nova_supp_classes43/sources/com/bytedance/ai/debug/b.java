package com.bytedance.ai.debug;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int d = 0;
    public final boolean a;
    public final boolean b;
    public final String c;

    public static final class a {
        public static b a(String r10) {
            return new b(true, true, r10);
        }
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r11 = (r10 + r1) * 31;
        String r12 = this.c;
        if (r12 != null) goto L13;
        int r13 = 0;
    L15:
        return r11 + r13;
    L13:
        r13 = r12.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIDebugCommandResult(handled=" + this.a + ", success=" + this.b + ", message=" + this.c + ')';
    }

    public b(boolean r1, boolean r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
