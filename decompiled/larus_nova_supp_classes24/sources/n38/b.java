package n38;

import com.larus.account.base.api.AccountSwitchReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final q38.b a;
    public final q38.b b;
    public final boolean c;
    public final int d;
    public final String e;
    public final AccountSwitchReason f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        q38.b r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        q38.b r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((r6 + r7) * 31) + this.d) * 31;
        String r9 = this.e;
        if (r9 == null) goto L19;
        r1 = r9.hashCode();
    L19:
        return ((r8 + r1) * 31) + this.f.hashCode();
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountSwitchResult(fromAccount=" + this.a + ", toAccount=" + this.b + ", success=" + this.c + ", errorCode=" + this.d + ", errorMessage=" + this.e + ", reason=" + this.f + ')';
    }

    public /* synthetic */ b(q38.b r8, q38.b r9, boolean r10, int r11, String r12) {
        this(r8, r9, r10, r11, r12, AccountSwitchReason.UNKNOWN);
    }

    public b(q38.b r2, q38.b r3, boolean r4, int r5, String r6, AccountSwitchReason r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
