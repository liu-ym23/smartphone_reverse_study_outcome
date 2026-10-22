package z58;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends b {
    public final x58.a a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final int g;
    public String h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final boolean l;
    public final Map<String, String> m;
    public final String n;
    public final float o;
    public final int p;
    public final int q;
    public final int r;
    public final String s;
    public final String t;
    public final int u;
    public final String v;

    /* JADX INFO: renamed from: z58.a$a, reason: collision with other inner class name */
    public static final class C0140a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, false, false, null, null, 0.0f, 0, 0, null, 4194303);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Float.compare(this.o, r6.o) == 0) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (this.u == r6.u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        x58.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r4 = 1231;
        if (this.f == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((((r3 + r5) * 31) + this.g) * 31) + this.h.hashCode()) * 31;
        if (this.i == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.j == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((r8 + r9) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L22;
        r4 = 1237;
    L22:
        int r11 = (r10 + r4) * 31;
        Map<String, String> r12 = this.m;
        if (r12 != null) goto L25;
        int r13 = 0;
    L26:
        int r14 = (((((((((((((((((r11 + r13) * 31) + this.n.hashCode()) * 31) + Float.floatToIntBits(this.o)) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u) * 31;
        String r15 = this.v;
        if (r15 == null) goto L31;
        r1 = r15.hashCode();
    L31:
        return r14 + r1;
    L25:
        r13 = r12.hashCode();
        goto L26
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TtsConfig(taskId=" + this.b + ", conversationId=" + this.d + ", messageId=" + this.c + ", styleId=" + this.e + ", payloadChatExtParams=" + this.m + ')';
    }

    public a(x58.a r25, String r26, String r27, String r29, String r210, String r30, boolean r31, boolean r32, Map r33, String r34, float r35, int r36, int r37, String r38, int r39) {
        if ((r39 & 1) == 0) goto L5;
        x58.a r2 = null;
    L6:
        String r5 = "";
        if ((r39 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r39 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r39 & 64) == 0) goto L25;
        int r9 = 32000;
    L27:
        if ((r39 & 128) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r39 & 512) == 0) goto L33;
        boolean r12 = false;
    L35:
        if ((r39 & 1024) == 0) goto L37;
        String r13 = "";
    L39:
        if ((r39 & 2048) == 0) goto L41;
        boolean r14 = false;
    L43:
        if ((r39 & 4096) == 0) goto L45;
        Map r15 = null;
    L47:
        if ((r39 & 8192) != 0) goto L51;
        r5 = r34;
    L51:
        if ((r39 & 16384) == 0) goto L53;
        float r3 = 0.0f;
    L55:
        if ((r39 & 32768) == 0) goto L57;
        int r19 = 0;
    L59:
        if ((r39 & 65536) == 0) goto L61;
        int r110 = 0;
    L63:
        if ((r39 & 131072) == 0) goto L65;
        int r20 = 24000;
    L67:
        if ((r39 & 262144) == 0) goto L69;
        String r10 = "pcm";
    L71:
        if ((r39 & 524288) == 0) goto L73;
        String r16 = "{}";
    L75:
        if ((r39 & 1048576) == 0) goto L77;
        int r22 = 1;
    L79:
        if ((r39 & 2097152) == 0) goto L81;
        String r17 = null;
    L82:
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "styleId");
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r13, "payloadSessionExtra");
        Intrinsics.checkNotNullParameter(r5, "audioMetrics");
        Intrinsics.checkNotNullParameter(r10, "format");
        Intrinsics.checkNotNullParameter(r16, "extraJsonConfig");
        super(r10, r16);
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = false;
        this.g = r9;
        this.h = r11;
        this.i = false;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r5;
        this.o = r3;
        this.p = r19;
        this.q = r110;
        this.r = r20;
        this.s = r10;
        this.t = r16;
        this.u = r22;
        this.v = r17;
        return;
    L81:
        r17 = r38;
        goto L82
    L77:
        r22 = 0;
        goto L79
    L73:
        r16 = null;
        goto L75
    L69:
        r10 = null;
        goto L71
    L65:
        r20 = 0;
        goto L67
    L61:
        r110 = r37;
        goto L63
    L57:
        r19 = r36;
        goto L59
    L53:
        r3 = r35;
        goto L55
    L45:
        r15 = r33;
        goto L47
    L41:
        r14 = r32;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = r31;
        goto L35
    L29:
        r11 = r30;
        goto L31
    L25:
        r9 = 0;
        goto L27
    L21:
        r8 = r210;
        goto L23
    L17:
        r7 = r29;
        goto L19
    L13:
        r6 = r27;
        goto L15
    L9:
        r4 = r26;
        goto L11
    L5:
        r2 = r25;
        goto L6
    }
}
