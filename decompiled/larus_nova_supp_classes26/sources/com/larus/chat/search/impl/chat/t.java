package com.larus.chat.search.impl.chat;

import com.larus.im.bean.bot.BotModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public final String a;
    public final int b;
    public final wc9.e c;
    public final BotModel d;
    public final CharSequence e;
    public final CharSequence f;
    public final String g;
    public final List<String> h;
    public final String i;
    public final long j;
    public final boolean k;
    public final boolean l;
    public final Boolean m;
    public final String n;

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
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        wc9.e r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        BotModel r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        CharSequence r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        CharSequence r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + this.h.hashCode()) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        long r19 = this.j;
        int r20 = (((r16 + r18) * 31) + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        int r21 = 1231;
        if (this.k == false) goto L29;
        int r22 = 1231;
    L30:
        int r23 = (r20 + r22) * 31;
        if (this.l == true) goto L34;
        r21 = 1237;
    L34:
        int r24 = (r23 + r21) * 31;
        Boolean r25 = this.m;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.n;
        if (r28 == null) goto L43;
        r2 = r28.hashCode();
    L43:
        return r27 + r2;
    L37:
        r26 = r25.hashCode();
        goto L38
    L29:
        r22 = 1237;
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
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSearchResult(id=" + this.a + ", type=" + this.b + ", conversation=" + this.c + ", botModel=" + this.d + ", title=" + this.e + ", subTitle=" + this.f + ", avatarUrl=" + this.g + ", avatarUrls=" + this.h + ", date=" + this.i + ", localIndex=" + this.j + ", onlyShowDivider=" + this.k + ", hideDivider=" + this.l + ", msgSendFromUser=" + this.m + ", highlightKeyword=" + this.n + ')';
    }

    public final int getType() {
        return this.b;
    }

    public t(String r17, int r18, wc9.e r19, BotModel r20, CharSequence r21, CharSequence r22, String r23, List r24, String r25, long r26, boolean r28, boolean r29, Boolean r30, String r31, int r32) {
        String r4 = null;
        if ((r32 & 4) == 0) goto L5;
        wc9.e r3 = null;
    L7:
        if ((r32 & 8) == 0) goto L9;
        BotModel r5 = null;
    L11:
        if ((r32 & 16) == 0) goto L13;
        CharSequence r6 = null;
    L15:
        if ((r32 & 32) == 0) goto L17;
        CharSequence r7 = null;
    L19:
        if ((r32 & 64) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r32 & 128) == 0) goto L25;
        List r9 = CollectionsKt.emptyList();
    L27:
        if ((r32 & 256) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r32 & 512) == 0) goto L33;
        long r11 = -1;
    L34:
        boolean r14 = false;
        if ((r32 & 1024) == 0) goto L37;
        boolean r13 = false;
    L39:
        if ((r32 & 2048) != 0) goto L43;
        r14 = r29;
    L43:
        if ((r32 & 4096) == 0) goto L45;
        Boolean r15 = null;
    L47:
        if ((r32 & 8192) != 0) goto L50;
        r4 = r31;
    L50:
        Intrinsics.checkNotNullParameter(r17, "id");
        Intrinsics.checkNotNullParameter(r9, "avatarUrls");
        this.a = r17;
        this.b = r18;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r4;
        return;
    L45:
        r15 = r30;
        goto L47
    L37:
        r13 = r28;
        goto L39
    L33:
        r11 = r26;
        goto L34
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r19;
        goto L7
    }
}
