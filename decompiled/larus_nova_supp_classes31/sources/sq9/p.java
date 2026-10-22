package sq9;

import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public final String a;
    public final String b;
    public final String c;
    public final UserCreation d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Boolean j;
    public final boolean k;
    public final String l;
    public final boolean m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final d0 s;
    public final Integer t;
    public final Integer u;
    public final String v;
    public final String w;
    public final Integer x;
    public final Boolean y;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        UserCreation r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.j;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        int r28 = 1231;
        if (this.k == false) goto L41;
        int r29 = 1231;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.l;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        if (this.m == true) goto L50;
        r28 = 1237;
    L50:
        int r34 = (r33 + r28) * 31;
        String r35 = this.n;
        if (r35 != null) goto L53;
        int r36 = 0;
    L54:
        int r37 = (r34 + r36) * 31;
        String r38 = this.o;
        if (r38 != null) goto L57;
        int r39 = 0;
    L58:
        int r40 = (r37 + r39) * 31;
        String r41 = this.p;
        if (r41 != null) goto L61;
        int r42 = 0;
    L62:
        int r43 = (r40 + r42) * 31;
        String r44 = this.q;
        if (r44 != null) goto L65;
        int r45 = 0;
    L66:
        int r46 = (r43 + r45) * 31;
        String r47 = this.r;
        if (r47 != null) goto L69;
        int r48 = 0;
    L70:
        int r49 = (r46 + r48) * 31;
        d0 r50 = this.s;
        if (r50 != null) goto L73;
        int r51 = 0;
    L74:
        int r52 = (r49 + r51) * 31;
        Integer r53 = this.t;
        if (r53 != null) goto L77;
        int r54 = 0;
    L78:
        int r55 = (r52 + r54) * 31;
        Integer r56 = this.u;
        if (r56 != null) goto L81;
        int r57 = 0;
    L82:
        int r58 = (r55 + r57) * 31;
        String r59 = this.v;
        if (r59 != null) goto L85;
        int r60 = 0;
    L86:
        int r61 = (r58 + r60) * 31;
        String r62 = this.w;
        if (r62 != null) goto L89;
        int r63 = 0;
    L90:
        int r64 = (r61 + r63) * 31;
        Integer r65 = this.x;
        if (r65 != null) goto L93;
        int r66 = 0;
    L94:
        int r67 = (r64 + r66) * 31;
        Boolean r68 = this.y;
        if (r68 == null) goto L99;
        r1 = r68.hashCode();
    L99:
        return r67 + r1;
    L93:
        r66 = r65.hashCode();
        goto L94
    L89:
        r63 = r62.hashCode();
        goto L90
    L85:
        r60 = r59.hashCode();
        goto L86
    L81:
        r57 = r56.hashCode();
        goto L82
    L77:
        r54 = r53.hashCode();
        goto L78
    L73:
        r51 = r50.hashCode();
        goto L74
    L69:
        r48 = r47.hashCode();
        goto L70
    L65:
        r45 = r44.hashCode();
        goto L66
    L61:
        r42 = r41.hashCode();
        goto L62
    L57:
        r39 = r38.hashCode();
        goto L58
    L53:
        r36 = r35.hashCode();
        goto L54
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = 1237;
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoSameInitParams(enterFrom=" + this.a + ", previousPageName=" + this.b + ", enterMethod=" + this.c + ", currentCreation=" + this.d + ", recommendFrom=" + this.e + ", fileLocalPath=" + this.f + ", aiCreationRecommendFrom=" + this.g + ", botId=" + this.h + ", cvsId=" + this.i + ", isFromChatDoublePage=" + this.j + ", openNewChatPageOnSend=" + this.k + ", quickMenuItemType=" + this.l + ", forbiddenChangePicture=" + this.m + ", templatePageType=" + this.n + ", currentCreationRefImgUrl=" + this.o + ", currentCreationRefFaceNum=" + this.p + ", currentCreationRefWidth=" + this.q + ", currentCreationRefHeight=" + this.r + ", wcbLogParams=" + this.s + ", selectStartPosition=" + this.t + ", selectEndPosition=" + this.u + ", anchorCreationId=" + this.v + ", douyinGid=" + this.w + ", creationDoSameLandingType=" + this.x + ", isSendFromDetail=" + this.y + ')';
    }

    public p(String r4, String r5, String r6, UserCreation r7, String r8, String r9, String r10, String r11, String r12, Boolean r13, boolean r14, @DoSameQuickMenuType String r15, boolean r16, String r17, String r18, String r19, String r20, String r21, d0 r22, Integer r23, Integer r24, String r25, String r26, Integer r27, Boolean r28) {
        Intrinsics.checkNotNullParameter(r5, "previousPageName");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
    }

    public /* synthetic */ p(String r30, String r31, String r32, UserCreation r33, String r34, String r35, String r36, String r37, String r38, Boolean r39, boolean r40, String r41, boolean r42, String r43, String r44, String r45, String r46, String r47, d0 r48, Integer r49, Integer r50, String r51, String r52, Integer r53, Boolean r54, int r55) {
        if ((r55 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r55 & 8) == 0) goto L9;
        UserCreation r7 = null;
    L11:
        if ((r55 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r55 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r55 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r55 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r55 & 256) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r55 & 512) == 0) goto L33;
        Boolean r13 = Boolean.FALSE;
    L35:
        if ((r55 & 1024) == 0) goto L37;
        boolean r14 = true;
    L39:
        if ((r55 & 2048) == 0) goto L41;
        String r15 = null;
    L43:
        if ((r55 & 4096) == 0) goto L45;
        boolean r16 = false;
    L47:
        if ((r55 & 8192) == 0) goto L49;
        String r17 = null;
    L51:
        if ((r55 & 16384) == 0) goto L53;
        String r18 = null;
    L55:
        if ((32768 & r55) == 0) goto L57;
        String r19 = null;
    L59:
        if ((65536 & r55) == 0) goto L61;
        String r20 = null;
    L63:
        if ((131072 & r55) == 0) goto L65;
        String r21 = null;
    L67:
        if ((262144 & r55) == 0) goto L69;
        d0 r22 = null;
    L71:
        if ((524288 & r55) == 0) goto L73;
        Integer r23 = null;
    L75:
        if ((1048576 & r55) == 0) goto L77;
        Integer r24 = null;
    L79:
        if ((2097152 & r55) == 0) goto L81;
        String r25 = null;
    L83:
        if ((4194304 & r55) == 0) goto L85;
        String r26 = null;
    L87:
        if ((8388608 & r55) == 0) goto L89;
        Integer r27 = null;
    L91:
        if ((r55 & 16777216) == 0) goto L93;
        Boolean r28 = Boolean.FALSE;
    L94:
        this(r4, r31, r32, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return;
    L93:
        r28 = r54;
        goto L94
    L89:
        r27 = r53;
        goto L91
    L85:
        r26 = r52;
        goto L87
    L81:
        r25 = r51;
        goto L83
    L77:
        r24 = r50;
        goto L79
    L73:
        r23 = r49;
        goto L75
    L69:
        r22 = r48;
        goto L71
    L65:
        r21 = r47;
        goto L67
    L61:
        r20 = r46;
        goto L63
    L57:
        r19 = r45;
        goto L59
    L53:
        r18 = r44;
        goto L55
    L49:
        r17 = r43;
        goto L51
    L45:
        r16 = r42;
        goto L47
    L41:
        r15 = r41;
        goto L43
    L37:
        r14 = r40;
        goto L39
    L33:
        r13 = r39;
        goto L35
    L29:
        r12 = r38;
        goto L31
    L25:
        r11 = r37;
        goto L27
    L21:
        r10 = r36;
        goto L23
    L17:
        r9 = r35;
        goto L19
    L13:
        r8 = r34;
        goto L15
    L9:
        r7 = r33;
        goto L11
    L5:
        r4 = r30;
        goto L7
    }
}
