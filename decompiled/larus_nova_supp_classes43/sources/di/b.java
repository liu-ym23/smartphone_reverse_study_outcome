package di;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final String i;
    public final Integer j;
    public final String k;
    public final String l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final Integer q;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L40;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r11.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r11.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r11.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r11.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r11.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r11.q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Integer r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.d;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.e;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        Integer r24 = this.f;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.g;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        Integer r30 = this.h;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        String r33 = this.i;
        if (r33 == null) goto L37;
        int r34 = r33.hashCode();
    L38:
        int r35 = (r32 + r34) * 31;
        Integer r36 = this.j;
        if (r36 == null) goto L41;
        int r37 = r36.hashCode();
    L42:
        int r38 = (r35 + r37) * 31;
        String r39 = this.k;
        if (r39 == null) goto L45;
        int r40 = r39.hashCode();
    L46:
        int r41 = (r38 + r40) * 31;
        String r42 = this.l;
        if (r42 == null) goto L49;
        int r43 = r42.hashCode();
    L50:
        int r44 = (r41 + r43) * 31;
        Integer r45 = this.m;
        if (r45 == null) goto L53;
        int r46 = r45.hashCode();
    L54:
        int r47 = (r44 + r46) * 31;
        Integer r48 = this.n;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (r47 + r49) * 31;
        Integer r51 = this.o;
        if (r51 == null) goto L61;
        int r52 = r51.hashCode();
    L62:
        int r53 = (r50 + r52) * 31;
        Integer r54 = this.p;
        if (r54 == null) goto L65;
        int r55 = r54.hashCode();
    L66:
        int r56 = (r53 + r55) * 31;
        Integer r57 = this.q;
        if (r57 == null) goto L70;
        r1 = r57.hashCode();
    L70:
        return r56 + r1;
    L65:
        r55 = 0;
        goto L66
    L61:
        r52 = 0;
        goto L62
    L57:
        r49 = 0;
        goto L58
    L53:
        r46 = 0;
        goto L54
    L49:
        r43 = 0;
        goto L50
    L45:
        r40 = 0;
        goto L46
    L41:
        r37 = 0;
        goto L42
    L37:
        r34 = 0;
        goto L38
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "Dimension(path=" + this.a + ", method=" + this.b + ", code=" + this.c + ", receivedBytes=" + this.d + ", sentBytes=" + this.e + ", socketReused=" + this.f + ", connectionInfo=" + this.g + ", netThreadPriority=" + this.h + ", ttnetVersion=" + this.i + ", priorityLevel=" + this.j + ", requestCompressType=" + this.k + ", responseCompressType=" + this.l + ", downlinkThroughput=" + this.m + ", effectiveNetType=" + this.n + ", httpRtt=" + this.o + ", tcpRtt=" + this.p + ", realNetType=" + this.q + ")";
    }

    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("path", this.a), TuplesKt.to("method", this.b), TuplesKt.to("code", this.c), TuplesKt.to("received_bytes", this.d), TuplesKt.to("sent_bytes", this.e), TuplesKt.to("socket_reused", this.f), TuplesKt.to("connection_info", this.g), TuplesKt.to("net_thread_priority", this.h), TuplesKt.to("ttnet_version", this.i), TuplesKt.to("priority_level", this.j), TuplesKt.to("request_compress_type", this.k), TuplesKt.to("response_compress_type", this.l), TuplesKt.to("downlink_throughput", this.m), TuplesKt.to("effective_net_type", this.n), TuplesKt.to("http_rtt", this.o), TuplesKt.to("tcp_rtt", this.p), TuplesKt.to("real_net_type", this.q)});
    }

    public b(String r10, String r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, String r18, Integer r19, String r110, String r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116) {
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.m = r112;
        this.n = r113;
        this.o = r114;
        this.p = r115;
        this.q = r116;
    }
}
