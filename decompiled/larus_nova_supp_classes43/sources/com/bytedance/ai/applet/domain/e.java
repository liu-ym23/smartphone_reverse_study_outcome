package com.bytedance.ai.applet.domain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int c = 0;
    public final boolean a;
    public final String b;

    public static final class a {
        public static e a() {
            return new e(true, "");
        }

        public static e b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "reason");
            return new e(false, r10);
        }
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "DomainPolicyCheckResult(allowed=" + this.a + ", reason=" + this.b + ')';
    }

    public e(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        this.a = r10;
        this.b = r11;
    }
}
