package e48;

import com.larus.account.saas.security.model.AccountSecurityEventType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final AccountSecurityEventType a;
    public final String b;
    public final long c;
    public final Map<String, String> d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        String r3 = this.e;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "AccountSecurityEvent(eventType=" + this.a + ", uid=" + this.b + ", timestampMs=" + this.c + ", extra=" + this.d + ", source=" + this.e + ')';
    }

    public d(AccountSecurityEventType r2, String r3, long r4, Map<String, String> r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r6, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
