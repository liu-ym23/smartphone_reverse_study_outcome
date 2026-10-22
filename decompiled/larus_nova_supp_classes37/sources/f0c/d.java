package f0c;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements Comparable<d> {
    public final UserSession a;
    public final String b;
    public h c;
    public boolean d;
    public final g0 e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "[userId=" + this.b + ", userState=" + this.c + ", isForegroundUser=" + this.d + ", session=" + this.a + "]\n";
    }

    @Override // java.lang.Comparable
    public final int compareTo(d r3) {
        d r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "other");
        boolean r0 = this.d;
        if (r0 == true) goto L5;
    L7:
        if (r0 == true) goto L12;
        if (r4.d == false) goto L12;
        return 1;
    L12:
        return this.b.compareTo(r4.b);
    L5:
        if (r4.d == true) goto L7;
        return -1;
    }

    public static d a(d r8, h r9, int r10) {
        g0 r1 = null;
        if ((r10 & 1) == 0) goto L5;
        UserSession r3 = r8.a;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r4 = r8.b;
    L11:
        if ((r10 & 4) == 0) goto L13;
        r9 = r8.c;
    L13:
        h r5 = r9;
        if ((r10 & 8) == 0) goto L16;
        boolean r6 = r8.d;
    L18:
        if ((r10 & 16) == 0) goto L20;
        r1 = r8.e;
    L20:
        g0 r7 = r1;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "userState");
        Intrinsics.checkNotNullParameter(r7, "userDelegate");
        return new d(r3, r4, r5, r6, r7);
    L16:
        r6 = false;
        goto L18
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public d(UserSession r2, String r3, h r4, boolean r5, g0 r6) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "userState");
        Intrinsics.checkNotNullParameter(r6, "userDelegate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
