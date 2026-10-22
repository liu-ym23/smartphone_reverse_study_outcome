package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends com.obric.assistant.cocreationreview.a {
    public final String a;
    public final ModuleKey b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final List<a> m;
    public final List<h> n;
    public final List<String> o;
    public final String p;
    public final String q;
    public final String r;
    public final int s;
    public final String t;
    public final a5 u;
    public final String v;
    public final String w;
    public final double x;
    public final String y;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r9 = (q) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
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
        if (this.s == r9.s) goto L66;
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
        if (Double.compare(this.x, r9.x) == 0) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long r1 = this.f;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String r3 = this.i;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (((((((((((((r2 + r5) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31;
        String r7 = this.p;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.q;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        String r13 = this.r;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (((r12 + r14) * 31) + this.s) * 31;
        String r16 = this.t;
        if (r16 != null) goto L21;
        int r17 = 0;
    L22:
        int r18 = (r15 + r17) * 31;
        a5 r19 = this.u;
        if (r19 == null) goto L26;
        r4 = r19.hashCode();
    L26:
        int r20 = (((((r18 + r4) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31;
        long r21 = Double.doubleToLongBits(this.x);
        return ((r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31) + this.y.hashCode();
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
        return "ProactiveAgentUsageRecord(id=" + this.a + ", module=" + this.b + ", recommendId=" + this.c + ", inspirationId=" + this.d + ", taskId=" + this.e + ", createdAt=" + this.f + ", triggeredAt=" + this.g + ", triggerDomain=" + this.h + ", triggerScenario=" + this.i + ", triggerTitle=" + this.j + ", triggerSummary=" + this.k + ", suggestionText=" + this.l + ", recommendedActions=" + this.m + ", triggerMeasures=" + this.n + ", sourcePackages=" + this.o + ", actionContext=" + this.p + ", evidence=" + this.q + ", actionExecuteInstruction=" + this.r + ", recommendStatus=" + this.s + ", feedbackAction=" + this.t + ", feedback=" + this.u + ", status=" + this.v + ", type=" + this.w + ", score=" + this.x + ", payload=" + this.y + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.b;
    }

    public final String getType() {
        return this.w;
    }

    public q(String r17, ModuleKey r18, String r19, String r20, String r21, long r22, String r24, String r25, String r26, String r27, String r28, List r29, List r30, List r31, String r32, String r33, String r34, int r35, String r36, a5 r37, String r38, String r39, double r40, String r42) {
        Intrinsics.checkNotNullParameter(r17, "id");
        Intrinsics.checkNotNullParameter(r18, "module");
        Intrinsics.checkNotNullParameter(r19, "recommendId");
        Intrinsics.checkNotNullParameter(r20, "inspirationId");
        Intrinsics.checkNotNullParameter(r21, "taskId");
        Intrinsics.checkNotNullParameter(r24, "triggeredAt");
        Intrinsics.checkNotNullParameter("主动智能", "triggerDomain");
        Intrinsics.checkNotNullParameter(r26, "triggerTitle");
        Intrinsics.checkNotNullParameter(r27, "triggerSummary");
        Intrinsics.checkNotNullParameter(r28, "suggestionText");
        Intrinsics.checkNotNullParameter(r29, "recommendedActions");
        Intrinsics.checkNotNullParameter(r30, "triggerMeasures");
        Intrinsics.checkNotNullParameter(r31, "sourcePackages");
        Intrinsics.checkNotNullParameter(r38, "status");
        Intrinsics.checkNotNullParameter(r39, "type");
        Intrinsics.checkNotNullParameter(r42, "payload");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r24;
        this.h = "主动智能";
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
        this.y = r42;
    }
}
