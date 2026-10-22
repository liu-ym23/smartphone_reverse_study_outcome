package sob;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        String r5 = this.d;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r4 + r7) * 31) + this.e) * 31;
        String r9 = this.f;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.g;
        if (r12 == null) goto L23;
        r6 = r12.hashCode();
    L23:
        return r11 + r6;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrUserInfo(eventId=" + this.a + ", isNameSearched=" + this.b + ", isAccept=" + this.c + ", resultCat=" + this.d + ", resultCatRank=" + this.e + ", asrUserId=" + this.f + ", clientUserId=" + this.g + ')';
    }

    public b(boolean r3, boolean r4, String r5, int r6, String r7, String r8) {
        String r0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r0, "eventId");
        this.a = r0;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
