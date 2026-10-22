package com.larus.platform.api;

import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v {
    public final String a;
    public final Boolean b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final List<String> h;
    public final String i;
    public final String j;
    public final String k;
    public final Integer l;
    public final HashMap<String, String> m;

    public v() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
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
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Boolean r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.d) * 31) + this.e) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<String> r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.k;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.l;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        HashMap<String, String> r29 = this.m;
        if (r29 == null) goto L43;
        r2 = r29.hashCode();
    L43:
        return r28 + r2;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
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
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetCachedVideoItemsParams(messageId=" + this.a + ", isLastVideoMessage=" + this.b + ", outerFallbackRequestId=" + this.c + ", outerShowCount=" + this.d + ", clickIndex=" + this.e + ", agentId=" + this.f + ", outerVid=" + this.g + ", outerFallbackVideoItems=" + this.h + ", bizScene=" + this.i + ", botId=" + this.j + ", lastMessageId=" + this.k + ", imprIndex=" + this.l + ", outerFallbackChannelIdMap=" + this.m + ')';
    }

    public v(String r16, Boolean r17, String r18, int r19, int r20, String r21, String r22, List r23, String r24, String r25, String r26, Integer r27, HashMap r28, int r29) {
        HashMap r4 = null;
        if ((r29 & 2) == 0) goto L5;
        Boolean r3 = null;
    L7:
        if ((r29 & 4) == 0) goto L9;
        String r5 = null;
    L10:
        int r7 = 0;
        if ((r29 & 8) == 0) goto L13;
        int r6 = 0;
    L15:
        if ((r29 & 16) != 0) goto L19;
        r7 = r20;
    L19:
        if ((r29 & 32) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r29 & 64) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r29 & 128) == 0) goto L29;
        List r10 = null;
    L31:
        if ((r29 & 256) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r29 & 512) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r29 & 1024) == 0) goto L41;
        String r13 = null;
    L43:
        if ((r29 & 2048) == 0) goto L45;
        Integer r14 = null;
    L47:
        if ((r29 & 4096) != 0) goto L50;
        r4 = r28;
    L50:
        Intrinsics.checkNotNullParameter(r16, "messageId");
        this.a = r16;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r4;
        return;
    L45:
        r14 = r27;
        goto L47
    L41:
        r13 = r26;
        goto L43
    L37:
        r12 = r25;
        goto L39
    L33:
        r11 = r24;
        goto L35
    L29:
        r10 = r23;
        goto L31
    L25:
        r9 = r22;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L10
    L5:
        r3 = r17;
        goto L7
    }
}
