package com.obric.assistant.cocreationreview.modules.searchqa;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a;
import com.obric.assistant.cocreationreview.a5;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 extends a {
    public final String a;
    public final ModuleKey b;
    public final long c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final List<s> j;
    public final String k;
    public final a5 l;
    public final String m;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r9 = (c0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
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
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r3 = this.f;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (((((((((r2 + r5) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        String r7 = this.k;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        a5 r10 = this.l;
        if (r10 == null) goto L15;
        r4 = r10.hashCode();
    L15:
        return ((r9 + r4) * 31) + this.m.hashCode();
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchQaUsageRecord(id=" + this.a + ", module=" + this.b + ", createdAt=" + this.c + ", answeredAt=" + this.d + ", searchDomain=" + this.e + ", searchTopic=" + this.f + ", userQuestion=" + this.g + ", answerSummary=" + this.h + ", answerText=" + this.i + ", localReferences=" + this.j + ", logId=" + this.k + ", feedback=" + this.l + ", payload=" + this.m + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.b;
    }

    public /* synthetic */ c0(String r16, ModuleKey r17, long r18, String r20, String r21, String r22, String r23, List r24, String r25, String r26, int r27) {
        if ((r27 & 1024) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r27 & 4096) == 0) goto L9;
        String r14 = r16;
    L10:
        this(r16, r17, r18, r20, "全搜问答", null, r21, r22, r23, r24, r12, null, r14);
        return;
    L9:
        r14 = r26;
        goto L10
    L5:
        r12 = r25;
        goto L7
    }

    public c0(String r2, ModuleKey r3, long r4, String r6, String r7, String r8, String r9, String r10, String r11, List<s> r12, String r13, a5 r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r6, "answeredAt");
        Intrinsics.checkNotNullParameter(r7, "searchDomain");
        Intrinsics.checkNotNullParameter(r9, "userQuestion");
        Intrinsics.checkNotNullParameter(r10, "answerSummary");
        Intrinsics.checkNotNullParameter(r11, "answerText");
        Intrinsics.checkNotNullParameter(r12, "localReferences");
        Intrinsics.checkNotNullParameter(r15, "payload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
    }
}
