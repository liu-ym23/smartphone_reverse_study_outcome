package com.obric.matrix.platform.sdk.ones.account;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f5823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f5824k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f5825l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f5826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f5827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f5828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f5829p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f5830q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f5831r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f5832s;

    public a() {
        this(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);
    }

    public a(boolean r14, int r15, String r16, String r17, int r18, String r19, String r20, String r21, int r22, String r23, String r24, String r25, String r26, boolean r27, int r28, boolean r29, String r30, long r31, String r33) {
        Intrinsics.checkNotNullParameter(r16, "secUserId");
        Intrinsics.checkNotNullParameter(r17, "userId");
        Intrinsics.checkNotNullParameter(r19, "xTTToken");
        Intrinsics.checkNotNullParameter(r20, "innerSSOToken");
        Intrinsics.checkNotNullParameter(r21, "avatarUrl");
        Intrinsics.checkNotNullParameter(r23, "userName");
        Intrinsics.checkNotNullParameter(r24, "screenName");
        Intrinsics.checkNotNullParameter(r25, "userEmail");
        Intrinsics.checkNotNullParameter(r26, "userMobile");
        Intrinsics.checkNotNullParameter(r30, "userSession");
        Intrinsics.checkNotNullParameter(r33, "loginPhoneNumber");
        this.f5814a = r14;
        this.f5815b = r15;
        this.f5816c = r16;
        this.f5817d = r17;
        this.f5818e = r18;
        this.f5819f = r19;
        this.f5820g = r20;
        this.f5821h = r21;
        this.f5822i = r22;
        this.f5823j = r23;
        this.f5824k = r24;
        this.f5825l = r25;
        this.f5826m = r26;
        this.f5827n = r27;
        this.f5828o = r28;
        this.f5829p = r29;
        this.f5830q = r30;
        this.f5831r = r31;
        this.f5832s = r33;
    }

    public /* synthetic */ a(boolean r22, int r23, String r24, String r25, int r26, String r27, String r28, String r29, int r30, String r31, String r32, String r33, String r34, boolean r35, int r36, boolean r37, String r38, long r39, String r41, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        int r11 = 0;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r13 = "";
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r14 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r15 = "";
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r16 = "";
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r17 = "";
    L35:
        if ((r42 & 256) == 0) goto L37;
        int r18 = 86;
    L39:
        if ((r42 & 512) == 0) goto L41;
        String r19 = "";
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r110 = "";
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r111 = "";
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r112 = "";
    L55:
        if ((r42 & 8192) == 0) goto L57;
        boolean r20 = false;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        int r21 = 0;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        boolean r113 = false;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r114 = "";
    L71:
        if ((r42 & 131072) == 0) goto L73;
        long r115 = 0;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r40 = "";
    L78:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r113, r114, r115, r40);
        return;
    L77:
        r40 = r41;
        goto L78
    L73:
        r115 = r39;
        goto L75
    L69:
        r114 = r38;
        goto L71
    L65:
        r113 = r37;
        goto L67
    L61:
        r21 = r36;
        goto L63
    L57:
        r20 = r35;
        goto L59
    L53:
        r112 = r34;
        goto L55
    L49:
        r111 = r33;
        goto L51
    L45:
        r110 = r32;
        goto L47
    L41:
        r19 = r31;
        goto L43
    L37:
        r18 = r30;
        goto L39
    L33:
        r17 = r29;
        goto L35
    L29:
        r16 = r28;
        goto L31
    L25:
        r15 = r27;
        goto L27
    L21:
        r14 = r26;
        goto L23
    L17:
        r13 = r25;
        goto L19
    L13:
        r12 = r24;
        goto L15
    L9:
        r11 = r23;
        goto L11
    L5:
        r10 = r22;
        goto L7
    }

    public final boolean a() {
        return this.f5814a;
    }

    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5821h = r10;
    }

    public final void c(int r10) {
        this.f5822i = r10;
    }

    public final void d(boolean r10) {
        this.f5827n = r10;
    }

    public final void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5820g = r10;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f5814a == r11.f5814a) goto L12;
        return false;
    L12:
        if (this.f5815b == r11.f5815b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5816c, r11.f5816c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f5817d, r11.f5817d) == true) goto L21;
        return false;
    L21:
        if (this.f5818e == r11.f5818e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f5819f, r11.f5819f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f5820g, r11.f5820g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f5821h, r11.f5821h) == true) goto L33;
        return false;
    L33:
        if (this.f5822i == r11.f5822i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f5823j, r11.f5823j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f5824k, r11.f5824k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f5825l, r11.f5825l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f5826m, r11.f5826m) == true) goto L48;
        return false;
    L48:
        if (this.f5827n == r11.f5827n) goto L51;
        return false;
    L51:
        if (this.f5828o == r11.f5828o) goto L54;
        return false;
    L54:
        if (this.f5829p == r11.f5829p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f5830q, r11.f5830q) == true) goto L60;
        return false;
    L60:
        if (this.f5831r == r11.f5831r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f5832s, r11.f5832s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final void f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5832s = r10;
    }

    public final void g(boolean r10) {
        this.f5814a = r10;
    }

    public final void h(long r10) {
        this.f5831r = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    public int hashCode() {
        boolean r10 = this.f5814a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = ((((((((((((((((((((((((r12 * 31) + Integer.hashCode(this.f5815b)) * 31) + this.f5816c.hashCode()) * 31) + this.f5817d.hashCode()) * 31) + Integer.hashCode(this.f5818e)) * 31) + this.f5819f.hashCode()) * 31) + this.f5820g.hashCode()) * 31) + this.f5821h.hashCode()) * 31) + Integer.hashCode(this.f5822i)) * 31) + this.f5823j.hashCode()) * 31) + this.f5824k.hashCode()) * 31) + this.f5825l.hashCode()) * 31) + this.f5826m.hashCode()) * 31;
        boolean r14 = this.f5827n;
        ?? r15 = r14;
        if (r14 == false) goto L8;
        r15 = 1;
    L8:
        int r16 = (((r13 + r15) * 31) + Integer.hashCode(this.f5828o)) * 31;
        boolean r17 = this.f5829p;
        if (r17 == true) goto L13;
        r11 = r17;
    L13:
        return ((((((r16 + r11) * 31) + this.f5830q.hashCode()) * 31) + Long.hashCode(this.f5831r)) * 31) + this.f5832s.hashCode();
    }

    public final void i(int r10) {
        this.f5815b = r10;
    }

    public final void j(boolean r10) {
        this.f5829p = r10;
    }

    public final void k(int r10) {
        this.f5818e = r10;
    }

    public final void l(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5824k = r10;
    }

    public final void m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5816c = r10;
    }

    public final void n(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5825l = r10;
    }

    public final void o(int r10) {
        this.f5828o = r10;
    }

    public final void p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5817d = r10;
    }

    public final void q(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5826m = r10;
    }

    public final void r(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5823j = r10;
    }

    public final void s(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5830q = r10;
    }

    public final void t(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5819f = r10;
    }

    public String toString() {
        return "AccountInfo(loginState=" + this.f5814a + ", logoutScene=" + this.f5815b + ", secUserId=" + this.f5816c + ", userId=" + this.f5817d + ", odinUserType=" + this.f5818e + ", xTTToken=" + this.f5819f + ", innerSSOToken=" + this.f5820g + ", avatarUrl=" + this.f5821h + ", countryCode=" + this.f5822i + ", userName=" + this.f5823j + ", screenName=" + this.f5824k + ", userEmail=" + this.f5825l + ", userMobile=" + this.f5826m + ", hasPassword=" + this.f5827n + ", userGender=" + this.f5828o + ", isNewUser=" + this.f5829p + ", userSession=" + this.f5830q + ", loginUtcTime=" + this.f5831r + ", loginPhoneNumber=" + this.f5832s + ')';
    }
}
