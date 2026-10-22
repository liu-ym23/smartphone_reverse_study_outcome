package tda;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b$a {
    public final String a;
    public final long b;
    public final String c;

    public b$a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b$a) == true) goto L8;
        return false;
    L8:
        b$a r9 = (b$a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "Snapshot(token=" + this.a + ", updatedAtMs=" + this.b + ", userId=" + this.c + ')';
    }

    public /* synthetic */ b$a(int r3) {
        this(NameKeys.UnloadStrategy_No_Strategy, 0, NameKeys.UnloadStrategy_No_Strategy);
    }

    public b$a(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r5, "userId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
