package com.obric.miniapp.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public final JSONObject a;
    public final JSONObject b;
    public final String c;
    public final String d;
    public final JSONObject e;
    public final JSONObject f;
    public final JSONObject g;
    public final String h;
    public final String i;
    public final String j;
    public final Long k;
    public final Long l;
    public final long m;
    public final String n;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
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
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        JSONObject r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.j.hashCode()) * 31;
        Long r14 = this.k;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.l;
        if (r17 == null) goto L26;
        r2 = r17.hashCode();
    L26:
        long r18 = this.m;
        return ((((r16 + r2) * 31) + ((int) (r18 ^ (r18 >>> 32)))) * 31) + this.n.hashCode();
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveIslandNotifyContext(payload=" + this.a + ", businessJson=" + this.b + ", sessionKey=" + this.c + ", jumpUrl=" + this.d + ", islandBizData=" + this.e + ", collapseData=" + this.f + ", expandData=" + this.g + ", collapseTemplateId=" + this.h + ", expandTemplateId=" + this.i + ", rawLiveIslandData=" + this.j + ", status=" + this.k + ", templateId=" + this.l + ", triggerTs=" + this.m + ", source=" + this.n + ')';
    }

    public m(JSONObject r10, JSONObject r11, String r12, String r13, JSONObject r14, JSONObject r15, JSONObject r16, String r17, String r18, String r19, Long r20, Long r21, long r22, String r24) {
        Intrinsics.checkNotNullParameter(r10, "payload");
        Intrinsics.checkNotNullParameter(r12, "sessionKey");
        Intrinsics.checkNotNullParameter(r14, "islandBizData");
        Intrinsics.checkNotNullParameter(r15, "collapseData");
        Intrinsics.checkNotNullParameter(r16, "expandData");
        Intrinsics.checkNotNullParameter(r19, "rawLiveIslandData");
        Intrinsics.checkNotNullParameter(r24, "source");
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
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r24;
    }
}
