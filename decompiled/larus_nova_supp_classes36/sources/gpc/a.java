package gpc;

import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final TenantNameStatus b;
    public final boolean c;
    public final boolean d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        TenantNameStatus r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.c == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == true) goto L18;
        r7 = 1237;
    L18:
        int r10 = (r9 + r7) * 31;
        String r11 = this.e;
        if (r11 == null) goto L23;
        r1 = r11.hashCode();
    L23:
        return r10 + r1;
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TenantNameData(tenantName=" + this.a + ", tenantNameStatus=" + this.b + ", isFriend=" + this.c + ", ignoreTenantNameStatus=" + this.d + ", chatterId=" + this.e + ')';
    }

    public a(String r1, TenantNameStatus r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = false;
        this.e = r4;
    }
}
