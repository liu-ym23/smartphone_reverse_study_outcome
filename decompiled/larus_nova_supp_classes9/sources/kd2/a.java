package kd2;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final long a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L16;
        a r7 = (a) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        boolean r6 = this.c;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L9;
        r8 = 1;
    L9:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.d;
        if (r10 == true) goto L13;
        r7 = r10;
    L13:
        int r11 = (r9 + r7) * 31;
        String r13 = this.e;
        if (r13 == null) goto L17;
        r3 = r13.hashCode();
    L17:
        return r11 + r3;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "RecognitionParams(source=" + this.a + ", appId=" + this.b + ", isRetry=" + this.c + ", anchorIsSinger=" + this.d + ", userId=" + this.e + ")";
    }

    public a(String r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        this.a = 0;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ a(boolean r2, boolean r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 16) == 0) goto L11;
        r4 = BuildConfig.FLAVOR;
    L11:
        this(null, r2, r3, r4);
    }
}
