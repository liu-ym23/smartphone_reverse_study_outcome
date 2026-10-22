package com.larus.search.impl.combine;

import com.larus.im.bean.bot.BotModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 {
    public final String a;
    public final int b;
    public final boolean c;
    public final wc9.e d;
    public final BotModel e;
    public final CharSequence f;
    public final CharSequence g;
    public final String h;
    public final List<String> i;
    public final String j;
    public final long k;
    public final boolean l;
    public final boolean m;
    public final Boolean n;
    public final i0 o;
    public final String p;
    public final ws9.b q;

    public c0() {
        throw null;
    }

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
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
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
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        wc9.e r4 = this.d;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        BotModel r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        CharSequence r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        CharSequence r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + this.i.hashCode()) * 31;
        String r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        long r22 = this.k;
        int r23 = (((r19 + r21) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31;
        if (this.l == false) goto L33;
        int r24 = 1231;
    L34:
        int r25 = (r23 + r24) * 31;
        if (this.m == true) goto L38;
        r2 = 1237;
    L38:
        int r26 = (r25 + r2) * 31;
        Boolean r27 = this.n;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        i0 r30 = this.o;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        String r33 = this.p;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        ws9.b r36 = this.q;
        if (r36 == null) goto L55;
        r5 = r36.hashCode();
    L55:
        return r35 + r5;
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L33:
        r24 = 1237;
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
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
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CombineSearchResult(id=" + this.a + ", type=" + this.b + ", sectionTypeBot=" + this.c + ", conversation=" + this.d + ", botModel=" + this.e + ", title=" + this.f + ", subTitle=" + this.g + ", avatarUrl=" + this.h + ", avatarUrls=" + this.i + ", date=" + this.j + ", localIndex=" + this.k + ", onlyShowDivider=" + this.l + ", hideDivider=" + this.m + ", msgSendFromUser=" + this.n + ", sectionTitleItem=" + this.o + ", highlightKeyword=" + this.p + ", globalSearchResultItem=" + this.q + ')';
    }

    public final int getType() {
        return this.b;
    }

    public c0(String r18, int r19, boolean r20, wc9.e r21, BotModel r22, CharSequence r23, CharSequence r24, String r25, String r26, long r27, Boolean r29, i0 r30, String r31, ws9.b r32, int r33) {
        ws9.b r4 = null;
        if ((r33 & 8) == 0) goto L5;
        wc9.e r3 = null;
    L7:
        if ((r33 & 16) == 0) goto L9;
        BotModel r5 = null;
    L11:
        if ((r33 & 32) == 0) goto L13;
        CharSequence r6 = null;
    L15:
        if ((r33 & 64) == 0) goto L17;
        CharSequence r7 = null;
    L19:
        if ((r33 & 128) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r33 & 256) == 0) goto L25;
        List<String> r9 = CollectionsKt.emptyList();
    L27:
        if ((r33 & 512) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r33 & 1024) == 0) goto L33;
        long r11 = -1;
    L35:
        if ((r33 & 8192) == 0) goto L37;
        Boolean r13 = null;
    L39:
        if ((r33 & 16384) == 0) goto L41;
        i0 r14 = null;
    L43:
        if ((32768 & r33) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r33 & 65536) != 0) goto L50;
        r4 = r32;
    L50:
        Intrinsics.checkNotNullParameter(r18, "id");
        Intrinsics.checkNotNullParameter(r9, "avatarUrls");
        this.a = r18;
        this.b = r19;
        this.c = r20;
        this.d = r3;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = false;
        this.m = false;
        this.n = r13;
        this.o = r14;
        this.p = r15;
        this.q = r4;
        return;
    L45:
        r15 = r31;
        goto L47
    L41:
        r14 = r30;
        goto L43
    L37:
        r13 = r29;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r7 = r24;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r5 = r22;
        goto L11
    L5:
        r3 = r21;
        goto L7
    }
}
