package com.larus.bmhome.chat.trace;

import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final boolean f;
    public final String g;
    public RecommendFrom h;
    public SearchMobParam i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public com.larus.bmhome.chat.component.regen.h n;

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
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        Integer r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.f == true) goto L22;
        r4 = 1237;
    L22:
        int r13 = (r12 + r4) * 31;
        String r14 = this.g;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        RecommendFrom r17 = this.h;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        SearchMobParam r20 = this.i;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        String r23 = this.j;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (r22 + r24) * 31;
        String r26 = this.k;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (r25 + r27) * 31;
        String r29 = this.l;
        if (r29 != null) goto L45;
        int r30 = 0;
    L46:
        int r31 = (r28 + r30) * 31;
        String r32 = this.m;
        if (r32 != null) goto L49;
        int r33 = 0;
    L50:
        int r34 = (r31 + r33) * 31;
        com.larus.bmhome.chat.component.regen.h r35 = this.n;
        if (r35 == null) goto L55;
        r1 = r35.hashCode();
    L55:
        return r34 + r1;
    L49:
        r33 = r32.hashCode();
        goto L50
    L45:
        r30 = r29.hashCode();
        goto L46
    L41:
        r27 = r26.hashCode();
        goto L42
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = r20.hashCode();
        goto L34
    L29:
        r18 = r17.hashCode();
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatBaseData(botId=" + this.a + ", isOwnBot=" + this.b + ", isCallBot=" + this.c + ", botConversationType=" + this.d + ", botType=" + this.e + ", isImmerseStyle=" + this.f + ", conversationId=" + this.g + ", recommendFrom=" + this.h + ", searchMobParam=" + this.i + ", currentPage=" + this.j + ", previousPage=" + this.k + ", fromActivityName=" + this.l + ", fromActivityModule=" + this.m + ", regenAnswersData=" + this.n + ')';
    }

    public final String a() {
        return this.j;
    }

    public final String b() {
        return this.m;
    }

    public final String c() {
        return this.l;
    }

    public final String d() {
        return this.k;
    }

    public final RecommendFrom e() {
        return this.h;
    }

    public final SearchMobParam f() {
        return this.i;
    }

    public final String g() {
        return this.c;
    }

    public a(String r2, boolean r3, String r4, Integer r5, Integer r6, boolean r7, String r8, RecommendFrom r9, SearchMobParam r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r4, "isCallBot");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = "chat";
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = null;
    }
}
