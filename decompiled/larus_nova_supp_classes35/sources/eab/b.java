package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends s {
    public final long j;
    public final String k;
    public final int l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.j == r9.j) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L15;
        return false;
    L15:
        if (this.l == r9.l) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.j;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.k.hashCode()) * 31) + this.l;
    }

    @Override // v7b.s
    public final String toString() {
        return "AtUserGroupNode(userGroupId=" + this.j + ", userGroupName=" + this.k + ", permissionStatus=" + this.l + ')';
    }

    @Override // v7b.s
    public final s h() {
        return new b(this.j, this.k, this.l);
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }

    public b(long r2, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "userGroupName");
        this.j = r2;
        this.k = r4;
        this.l = r5;
    }
}
