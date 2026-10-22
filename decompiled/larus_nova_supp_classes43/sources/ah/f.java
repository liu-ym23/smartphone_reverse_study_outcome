package ah;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final String a;
    public final int b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final JSONObject g;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == false) goto L20;
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r11.e) goto L16;
        return false;
    L16:
        if (this.f == r11.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = ((r10 * 31) + this.b) * 31;
        boolean r12 = this.c;
        ?? r13 = 1;
        ?? r14 = r12;
        if (r12 == false) goto L9;
        r14 = 1;
    L9:
        int r15 = (r11 + r14) * 31;
        String r16 = this.d;
        if (r16 == null) goto L12;
        int r17 = r16.hashCode();
    L13:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.e;
        ?? r20 = r19;
        if (r19 == false) goto L16;
        r20 = 1;
    L16:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.f;
        if (r22 == true) goto L20;
        r13 = r22;
    L20:
        int r23 = (r21 + r13) * 31;
        JSONObject r24 = this.g;
        if (r24 == null) goto L24;
        r1 = r24.hashCode();
    L24:
        return r23 + r1;
    L12:
        r17 = 0;
        goto L13
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "NotifyCouponStateEvent(state=" + this.a + ", num=" + this.b + ", isSpecialRoom=" + this.c + ", couponShowType=" + this.d + ", animate=" + this.e + ", useNative=" + this.f + ", logData=" + this.g + ")";
    }

    public f() {
        this("HIDE", 0, false, "auto", false, false, null);
    }

    public f(String r10, int r11, boolean r12, String r13, boolean r14, boolean r15, JSONObject r16) {
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r13, "couponShowType");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
    }
}
