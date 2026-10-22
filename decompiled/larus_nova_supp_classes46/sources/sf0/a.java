package sf0;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import kotlin.jvm.internal.Intrinsics;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public final int d;
    public final LinkMatchType e;
    public boolean f;
    public final String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public tf0.b o;
    public xc.a p;
    public boolean q;
    public int r;
    public boolean s;

    public a() {
        this(0, 0, 0, 0, null, null, null, 0, 0, 0, false, false, 0, null, null, 0, 524287);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L44;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
        return false;
    L32:
        if (this.n == r4.n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (this.q == r4.q) goto L40;
        return false;
    L40:
        if (this.r == r4.r) goto L42;
        return false;
    L42:
        if (this.s == r4.s) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        LinkMatchType r1 = this.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.f;
        ?? r6 = 1;
        ?? r7 = r5;
        if (r5 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r4 + r7) * 31;
        String r9 = this.g;
        if (r9 == null) goto L12;
        int r10 = r9.hashCode();
    L13:
        int r11 = (r8 + r10) * 31;
        String r12 = this.h;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (((((((r11 + r13) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31;
        boolean r15 = this.l;
        ?? r16 = r15;
        if (r15 == false) goto L20;
        r16 = 1;
    L20:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.m;
        ?? r19 = r18;
        if (r18 == false) goto L23;
        r19 = 1;
    L23:
        int r20 = (((r17 + r19) * 31) + this.n) * 31;
        tf0.b r21 = this.o;
        if (r21 == null) goto L26;
        int r22 = r21.hashCode();
    L27:
        int r23 = (r20 + r22) * 31;
        xc.a r24 = this.p;
        if (r24 == null) goto L30;
        r2 = r24.hashCode();
    L30:
        int r25 = (r23 + r2) * 31;
        boolean r26 = this.q;
        ?? r27 = r26;
        if (r26 == false) goto L33;
        r27 = 1;
    L33:
        int r28 = (((r25 + r27) * 31) + this.r) * 31;
        boolean r29 = this.s;
        if (r29 == true) goto L38;
        r6 = r29;
    L38:
        return r28 + r6;
    L26:
        r22 = 0;
        goto L27
    L16:
        r13 = 0;
        goto L17
    L12:
        r10 = 0;
        goto L13
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ApplyParams(position=" + this.a + ", applySource=" + this.b + ", applyType=" + this.c + ", layout=" + this.d + ", matchType=" + this.e + ", isFollowApply=" + this.f + ", taskName=" + this.g + ", fromSource=" + this.h + ", teamId=" + this.i + ", paidCount=" + this.j + ", limitTime=" + this.k + ", isAnonymous=" + this.l + ", useMemberBenefits=" + this.m + ", memberDiscountAmount=" + this.n + ", applyCallback=" + this.o + ", linkmicDiscountInfo=" + this.p + ", jumpFollow=" + this.q + ", linkType=" + this.r + ", isApplyAfterIntercept=" + this.s + ")";
    }

    public a(int r20, int r21, int r22, int r23, LinkMatchType r24, String r25, String r26, int r27, int r28, int r29, boolean r30, boolean r31, int r32, tf0.b r33, xc.a r34, int r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        int r2 = -1;
    L7:
        if ((r36 & 2) == 0) goto L9;
        int r3 = 100;
    L11:
        if ((r36 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r36 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r36 & 16) == 0) goto L21;
        LinkMatchType r7 = LinkMatchType.NONE;
    L22:
        String r9 = "";
        if ((r36 & 64) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r36 & 128) != 0) goto L31;
        r9 = r26;
    L31:
        if ((r36 & 256) == 0) goto L33;
        int r10 = 0;
    L35:
        if ((r36 & 512) == 0) goto L37;
        int r11 = 0;
    L39:
        if ((r36 & 1024) == 0) goto L41;
        int r12 = 0;
    L43:
        if ((r36 & 2048) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r36 & 4096) == 0) goto L49;
        boolean r14 = false;
    L51:
        if ((r36 & 8192) == 0) goto L53;
        int r15 = 0;
    L55:
        if ((r36 & 16384) == 0) goto L57;
        tf0.b r5 = null;
    L59:
        if ((r36 & 32768) == 0) goto L61;
        xc.a r18 = null;
    L63:
        if ((r36 & 131072) == 0) goto L65;
        int r1 = 0;
    L66:
        Intrinsics.checkNotNullParameter(r7, "matchType");
        Intrinsics.checkNotNullParameter(r8, "taskName");
        Intrinsics.checkNotNullParameter(r9, "fromSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = false;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
        this.o = r5;
        this.p = r18;
        this.q = false;
        this.r = r1;
        this.s = false;
        return;
    L65:
        r1 = r35;
        goto L66
    L61:
        r18 = r34;
        goto L63
    L57:
        r5 = r33;
        goto L59
    L53:
        r15 = r32;
        goto L55
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L25:
        r8 = r25;
        goto L27
    L21:
        r7 = r24;
        goto L22
    L17:
        r6 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L7
    }
}
