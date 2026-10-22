package z29;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final MembershipQuotaRowKind a;
    public final String b;
    public final boolean c;
    public final double d;
    public final double e;
    public final MembershipQuotaBarTier f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final String j;
    public final String k;
    public final Long l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r9.d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.e, r9.e) == 0) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
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
        int r5 = 1231;
        if (this.c == false) goto L9;
        int r6 = 1231;
    L10:
        long r7 = Double.doubleToLongBits(this.d);
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = Double.doubleToLongBits(this.e);
        int r10 = (((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L13;
        int r11 = 1231;
    L14:
        int r12 = (r10 + r11) * 31;
        if (this.h == false) goto L17;
        int r13 = 1231;
    L18:
        int r14 = (r12 + r13) * 31;
        if (this.i == true) goto L22;
        r5 = 1237;
    L22:
        int r15 = (r14 + r5) * 31;
        String r16 = this.j;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r20 = this.k;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        Long r23 = this.l;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L17:
        r13 = 1237;
        goto L18
    L13:
        r11 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MembershipQuotaRow(kind=" + this.a + ", serverLabel=" + this.b + ", isTeamSubscription=" + this.c + ", usedPercent=" + this.d + ", barPercent=" + this.e + ", barTier=" + this.f + ", lessThanOnePercent=" + this.g + ", exhausted=" + this.h + ", unlimited=" + this.i + ", usedAmount=" + this.j + ", totalAmount=" + this.k + ", refreshAt=" + this.l + ')';
    }

    public b(MembershipQuotaRowKind r2, String r3, boolean r4, double r5, double r7, MembershipQuotaBarTier r9, boolean r10, boolean r11, boolean r12, String r13, String r14, Long r15) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        Intrinsics.checkNotNullParameter(r9, "barTier");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
    }
}
