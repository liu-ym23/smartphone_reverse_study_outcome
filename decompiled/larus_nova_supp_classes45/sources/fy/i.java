package fy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public final int a;
    public final long b;
    public final int c;
    public final long d;
    public final String e;
    public final String f;
    public final LinkerInviteContent g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L20;
        i r7 = (i) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31;
        long r3 = this.d;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.e;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.f;
        if (r9 == null) goto L9;
        int r11 = r9.hashCode();
    L10:
        int r12 = (r8 + r11) * 31;
        LinkerInviteContent r13 = this.g;
        if (r13 == null) goto L14;
        r6 = r13.hashCode();
    L14:
        return r12 + r6;
    L9:
        r11 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final String toString() {
        return "PermitParams(scene=" + this.a + ", channelId=" + this.b + ", permitStatus=" + this.c + ", roomId=" + this.d + ", applyUserId=" + this.e + ", applyAnchorSecId=" + this.f + ", applyContent=" + this.g + ")";
    }

    public i(int r2, long r3, int r5, long r6, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "applyUserId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        this.g = null;
    }
}
