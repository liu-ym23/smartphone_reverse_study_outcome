package k0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final long c;
    public final long d;
    public final UserCreation e;
    public final boolean f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        long r6 = this.c;
        int r7 = (((r3 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.d;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        UserCreation r10 = this.e;
        if (r10 == null) goto L14;
        r1 = r10.hashCode();
    L14:
        int r11 = (r9 + r1) * 31;
        if (this.f == true) goto L19;
        r4 = 1237;
    L19:
        return r11 + r4;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationDetailBottomToolsUiState(creationId=" + this.a + ", liked=" + this.b + ", likeCount=" + this.c + ", commentCount=" + this.d + ", creation=" + this.e + ", showLikeAnimation=" + this.f + ')';
    }

    public /* synthetic */ a(int r10) {
        this(null, false, 0, 0, null, false);
    }

    public a(String r1, boolean r2, long r3, long r5, UserCreation r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }

    public static a a(a r9, boolean r10, long r11, long r13, UserCreation r15, boolean r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        String r1 = r9.a;
    L7:
        if ((r17 & 2) == 0) goto L9;
        boolean r2 = r9.b;
    L11:
        if ((r17 & 4) == 0) goto L13;
        long r3 = r9.c;
    L15:
        if ((r17 & 8) == 0) goto L17;
        long r5 = r9.d;
    L19:
        if ((r17 & 16) == 0) goto L21;
        UserCreation r7 = r9.e;
    L23:
        if ((r17 & 32) == 0) goto L25;
        boolean r8 = r9.f;
    L26:
        r9.getClass();
        return new a(r1, r2, r3, r5, r7, r8);
    L25:
        r8 = r16;
        goto L26
    L21:
        r7 = r15;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r1 = null;
        goto L7
    }
}
