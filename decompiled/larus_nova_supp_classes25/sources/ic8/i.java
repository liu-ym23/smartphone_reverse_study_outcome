package ic8;

import com.larus.common.apphost.AppHost;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old link data")
public final class i {
    public final String A;
    public final Long a;
    public final String b;
    public final long c;
    public final Long d;
    public final String e;
    public final int f;
    public final Integer g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final Integer m;
    public final Integer n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final Integer t;
    public final Integer u;
    public final String v;
    public final String w;
    public final Integer x;
    public final b0 y;
    public final String z;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r9.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r9.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r9.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r9.A) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        long r4 = this.c;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        Long r6 = this.d;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (((((r5 + r7) * 31) + this.e.hashCode()) * 31) + this.f) * 31;
        Integer r9 = this.g;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.h;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.i;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        String r18 = this.j;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.k;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        String r24 = this.l;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.m;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        Integer r30 = this.n;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.o;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.p;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        String r39 = this.q;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        String r42 = this.r;
        if (r42 != null) goto L57;
        int r43 = 0;
    L58:
        int r44 = (r41 + r43) * 31;
        String r45 = this.s;
        if (r45 != null) goto L61;
        int r46 = 0;
    L62:
        int r47 = (r44 + r46) * 31;
        Integer r48 = this.t;
        if (r48 != null) goto L65;
        int r49 = 0;
    L66:
        int r50 = (r47 + r49) * 31;
        Integer r51 = this.u;
        if (r51 != null) goto L69;
        int r52 = 0;
    L70:
        int r53 = (r50 + r52) * 31;
        String r54 = this.v;
        if (r54 != null) goto L73;
        int r55 = 0;
    L74:
        int r56 = (r53 + r55) * 31;
        String r57 = this.w;
        if (r57 != null) goto L77;
        int r58 = 0;
    L78:
        int r59 = (r56 + r58) * 31;
        Integer r60 = this.x;
        if (r60 != null) goto L81;
        int r61 = 0;
    L82:
        int r62 = (r59 + r61) * 31;
        b0 r63 = this.y;
        if (r63 != null) goto L85;
        int r64 = 0;
    L86:
        int r65 = (r62 + r64) * 31;
        String r66 = this.z;
        if (r66 != null) goto L89;
        int r67 = 0;
    L90:
        int r68 = (r65 + r67) * 31;
        String r69 = this.A;
        if (r69 == null) goto L95;
        r1 = r69.hashCode();
    L95:
        return r68 + r1;
    L89:
        r67 = r66.hashCode();
        goto L90
    L85:
        r64 = r63.hashCode();
        goto L86
    L81:
        r61 = r60.hashCode();
        goto L82
    L77:
        r58 = r57.hashCode();
        goto L78
    L73:
        r55 = r54.hashCode();
        goto L74
    L69:
        r52 = r51.hashCode();
        goto L70
    L65:
        r49 = r48.hashCode();
        goto L66
    L61:
        r46 = r45.hashCode();
        goto L62
    L57:
        r43 = r42.hashCode();
        goto L58
    L53:
        r40 = r39.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatMessage(id=" + this.a + ", messageId=" + this.b + ", time=" + this.c + ", updateTime=" + this.d + ", type=" + this.e + ", status=" + this.f + ", index=" + this.g + ", sender=" + this.h + ", conversationId=" + this.i + ", localConversationId=" + this.j + ", sourceConversationId=" + this.k + ", botId=" + this.l + ", sourceStartIndex=" + this.m + ", sourceEndIndex=" + this.n + ", sectionId=" + this.o + ", replyFor=" + this.p + ", content=" + this.q + ", ttsContent=" + this.r + ", extras=" + this.s + ", feedback=" + this.t + ", onBoarding=" + this.u + ", msgBrief=" + this.v + ", metaInfo=" + this.w + ", isConnectCallerName=" + this.x + ", intentionMsg=" + this.y + ", referenceInfo=" + this.z + ", promptContent=" + this.A + ')';
    }

    static {
        new i();
    }

    public i() {
        long r0 = AppHost.a.getAppClock().currentTimeMillis();
        Intrinsics.checkNotNullParameter("", "messageId");
        Intrinsics.checkNotNullParameter("", "type");
        this.a = null;
        this.b = "";
        this.c = r0;
        this.d = null;
        this.e = "";
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0;
        this.u = 0;
        this.v = null;
        this.w = null;
        this.x = 0;
        this.y = null;
        this.z = null;
        this.A = null;
    }

    public final String getType() {
        return this.e;
    }
}
