package v39;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    public final int e;
    public final byte[] f;

    public final int hashCode() {
        return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d)) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    public final String toString() {
        return "DoraRemoteData(dataId=" + this.a + ", scene=" + this.b + ", type=" + this.c + ", dataSize=" + this.d.length + ", assId=" + this.e + ", assDataSize=" + this.f.length;
    }

    public final int getType() {
        return this.c;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.dora.api.core.DoraRemoteData");
        a r6 = (a) r5;
        if (this.a == r6.a) goto L16;
        return false;
    L16:
        if (this.b == r6.b) goto L19;
        return false;
    L19:
        if (this.c == r6.c) goto L22;
        return false;
    L22:
        if (Arrays.equals(this.d, r6.d) == true) goto L25;
        return false;
    L25:
        if (this.e == r6.e) goto L28;
        return false;
    L28:
        if (Arrays.equals(this.f, r6.f) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public a(int r2, int r3, int r4, byte[] r5, int r6, byte[] r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r7, "assData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
