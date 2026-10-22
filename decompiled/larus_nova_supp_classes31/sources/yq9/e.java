package yq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final long d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        long r6 = this.d;
        return ((r4 + r2) * 31) + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowVideoEngineInfos(key=" + this.a + ", usingMDLPlayTaskKey=" + this.b + ", usingMDLPlayFilePath=" + this.c + ", hitCacheSize=" + this.d + ')';
    }

    public e(String r2, String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
