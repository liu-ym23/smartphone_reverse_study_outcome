package com.larus.bmhome.utils;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c4 {
    public final String a;
    public final String b;
    public final String c;
    public final BotModel d;
    public final wc9.e e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;
    public final String j;
    public final Boolean k;
    public final Message l;
    public final JSONObject m;
    public final String n;

    public c4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c4) == true) goto L8;
        return false;
    L8:
        c4 r6 = (c4) r5;
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
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        BotModel r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        wc9.e r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Message r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        JSONObject r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return r39 + r1;
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoDetailEventParams(botId=" + this.a + ", messageId=" + this.b + ", previousPage=" + this.c + ", botModel=" + this.d + ", conversation=" + this.e + ", enterMethod=" + this.f + ", isUploadVideo=" + this.g + ", creationTaskId=" + this.h + ", position=" + this.i + ", aiCreateShowMode=" + this.j + ", isDeepThinking=" + this.k + ", message=" + this.l + ", customParams=" + this.m + ", currentPage=" + this.n + ')';
    }

    public static c4 a(c4 r16, JSONObject r17) {
        String r1 = r16.a;
        String r2 = r16.b;
        String r3 = r16.c;
        BotModel r4 = r16.d;
        wc9.e r5 = r16.e;
        String r6 = r16.f;
        String r7 = r16.g;
        String r8 = r16.h;
        Integer r9 = r16.i;
        String r10 = r16.j;
        Boolean r11 = r16.k;
        Message r12 = r16.l;
        String r14 = r16.n;
        r16.getClass();
        return new c4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r17, r14);
    }

    public c4(String r1, String r2, String r3, BotModel r4, wc9.e r5, String r6, String r7, String r8, Integer r9, String r10, Boolean r11, Message r12, JSONObject r13, String r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }

    public /* synthetic */ c4(String r16, String r17, String r18, BotModel r19, wc9.e r20, String r21, String r22, String r23, Integer r24, String r25, Boolean r26, Message r27, JSONObject r28, String r29, int r30) {
        String r2 = null;
        if ((r30 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        BotModel r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        wc9.e r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Message r13 = null;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        JSONObject r14 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r2 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
        return;
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
