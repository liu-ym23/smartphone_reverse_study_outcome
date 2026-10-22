package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public final String a;
    public final x b;
    public final ResourceInputType c;
    public final ResourceMediaType d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final Boolean q;
    public final Long r;
    public final Long s;
    public final Map<String, String> t;

    public t() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof t) == true) goto L8;
        return false;
    L8:
        t r9 = (t) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
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
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r1 = this.h;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.i.hashCode()) * 31;
        String r3 = this.j;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.k;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.l;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        String r13 = this.m;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (r12 + r14) * 31;
        String r16 = this.n;
        if (r16 != null) goto L21;
        int r17 = 0;
    L22:
        int r18 = (r15 + r17) * 31;
        String r19 = this.o;
        if (r19 != null) goto L25;
        int r20 = 0;
    L26:
        int r21 = (r18 + r20) * 31;
        String r22 = this.p;
        if (r22 != null) goto L29;
        int r23 = 0;
    L30:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.q;
        if (r25 != null) goto L33;
        int r26 = 0;
    L34:
        int r27 = (r24 + r26) * 31;
        Long r28 = this.r;
        if (r28 != null) goto L37;
        int r29 = 0;
    L38:
        int r30 = (r27 + r29) * 31;
        Long r31 = this.s;
        if (r31 == null) goto L43;
        r4 = r31.hashCode();
    L43:
        return ((r30 + r4) * 31) + this.t.hashCode();
    L37:
        r29 = r28.hashCode();
        goto L38
    L33:
        r26 = r25.hashCode();
        goto L34
    L29:
        r23 = r22.hashCode();
        goto L30
    L25:
        r20 = r19.hashCode();
        goto L26
    L21:
        r17 = r16.hashCode();
        goto L22
    L17:
        r14 = r13.hashCode();
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceAccessObserveEvent(taskId=" + this.a + ", scene=" + this.b + ", resourceInputType=" + this.c + ", mediaType=" + this.d + ", fileIdentifier=" + this.e + ", nodeKey=" + this.f + ", stage=" + this.g + ", costMs=" + this.h + ", result=" + this.i + ", errorCode=" + this.j + ", policyVersion=" + this.k + ", routeDecision=" + this.l + ", routeReason=" + this.m + ", cacheHit=" + this.n + ", sdkRoute=" + this.o + ", remoteResolve=" + this.p + ", isTaskReused=" + this.q + ", waitCostMs=" + this.r + ", estimatedSavedMs=" + this.s + ", attributes=" + this.t + ')';
    }

    public t(String r23, x r24, ResourceInputType r25, ResourceMediaType r26, String r27, String r28, String r29, long r30, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, Boolean r40, Long r41, Long r42, Map r43, int r44) {
        if ((r44 & 512) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r44 & 1024) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r44 & 2048) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r44 & 4096) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r44 & 8192) == 0) goto L21;
        String r15 = null;
    L23:
        if ((r44 & 16384) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r44 & 32768) == 0) goto L29;
        String r18 = null;
    L31:
        if ((r44 & 65536) == 0) goto L33;
        Boolean r19 = null;
    L35:
        if ((r44 & 131072) == 0) goto L37;
        Long r20 = null;
    L39:
        if ((r44 & 262144) == 0) goto L41;
        Long r21 = null;
    L43:
        if ((r44 & 524288) == 0) goto L45;
        Map r9 = MapsKt.emptyMap();
    L46:
        Intrinsics.checkNotNullParameter(r23, "taskId");
        Intrinsics.checkNotNullParameter(r24, "scene");
        Intrinsics.checkNotNullParameter(r25, "resourceInputType");
        Intrinsics.checkNotNullParameter(r26, "mediaType");
        Intrinsics.checkNotNullParameter(r27, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r28, "nodeKey");
        Intrinsics.checkNotNullParameter(r29, "stage");
        Intrinsics.checkNotNullParameter(r32, "result");
        Intrinsics.checkNotNullParameter(r9, "attributes");
        this.a = r23;
        this.b = r24;
        this.c = r25;
        this.d = r26;
        this.e = r27;
        this.f = r28;
        this.g = r29;
        this.h = r30;
        this.i = r32;
        this.j = r10;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
        this.o = r11;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r9;
        return;
    L45:
        r9 = r43;
        goto L46
    L41:
        r21 = r42;
        goto L43
    L37:
        r20 = r41;
        goto L39
    L33:
        r19 = r40;
        goto L35
    L29:
        r18 = r39;
        goto L31
    L25:
        r11 = r38;
        goto L27
    L21:
        r15 = r37;
        goto L23
    L17:
        r14 = r36;
        goto L19
    L13:
        r13 = r35;
        goto L15
    L9:
        r12 = r34;
        goto L11
    L5:
        r10 = r33;
        goto L7
    }
}
