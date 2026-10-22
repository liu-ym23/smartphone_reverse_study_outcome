package com.larus.bmhome.chat.api;

import android.view.ViewGroup;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final ViewGroup g;
    public final ic8.x h;
    public final int i;
    public final int j;
    public final Map<String, String> k;
    public final Map<String, Object> l;
    public final boolean m;
    public final boolean n;
    public final String o;
    public final String p;
    public final Map<String, Object> q;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r6 = (v0) r5;
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
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        ViewGroup r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        ic8.x r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((((r19 + r21) * 31) + this.i) * 31) + this.j) * 31;
        Map<String, String> r23 = this.k;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Map<String, Object> r26 = this.l;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        int r29 = 1231;
        if (this.m == false) goto L41;
        int r30 = 1231;
    L42:
        int r31 = (r28 + r30) * 31;
        if (this.n == true) goto L46;
        r29 = 1237;
    L46:
        int r32 = (r31 + r29) * 31;
        String r33 = this.o;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        String r36 = this.p;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        Map<String, Object> r39 = this.q;
        if (r39 == null) goto L59;
        r2 = r39.hashCode();
    L59:
        return r38 + r2;
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L41:
        r30 = 1237;
        goto L42
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
        return "WidgetRenderData(msgId=" + this.a + ", botId=" + this.b + ", convId=" + this.c + ", sectionId=" + this.d + ", replyId=" + this.e + ", renderData=" + this.f + ", parent=" + this.g + ", widgetLifeObserver=" + this.h + ", currentPosition=" + this.i + ", maxWidth=" + this.j + ", ext=" + this.k + ", params=" + this.l + ", enableCache=" + this.m + ", enableRecycler=" + this.n + ", templateUrl=" + this.o + ", widgetTheme=" + this.p + ", extra=" + this.q + ')';
    }

    public static v0 a(v0 r22, String r23, int r24) {
        Map<String, Object> r3 = null;
        if ((r24 & 1) == 0) goto L5;
        String r5 = r22.a;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r6 = r22.b;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r7 = r22.c;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r8 = r22.d;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r9 = r22.e;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r10 = r22.f;
    L27:
        if ((r24 & 64) == 0) goto L29;
        ViewGroup r11 = r22.g;
    L31:
        if ((r24 & 128) == 0) goto L33;
        ic8.x r12 = r22.h;
    L35:
        if ((r24 & 256) == 0) goto L37;
        int r13 = r22.i;
    L39:
        if ((r24 & 512) == 0) goto L41;
        int r14 = r22.j;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Map<String, String> r15 = r22.k;
    L47:
        if ((r24 & 2048) == 0) goto L49;
        Map<String, Object> r16 = r22.l;
    L51:
        if ((r24 & 4096) == 0) goto L53;
        boolean r17 = r22.m;
    L55:
        if ((r24 & 8192) == 0) goto L57;
        boolean r18 = r22.n;
    L59:
        if ((r24 & 16384) == 0) goto L61;
        String r19 = r22.o;
    L63:
        if ((32768 & r24) == 0) goto L65;
        String r20 = r22.p;
    L67:
        if ((r24 & 65536) == 0) goto L69;
        r3 = r22.q;
    L69:
        Intrinsics.checkNotNullParameter(r5, "msgId");
        return new v0(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r3);
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = false;
        goto L59
    L53:
        r17 = false;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = 0;
        goto L43
    L37:
        r13 = 0;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public v0(String r4, String r5, String r6, String r7, String r8, String r9, ViewGroup r10, ic8.x r11, int r12, int r13, Map<String, String> r14, Map<String, ? extends Object> r15, boolean r16, boolean r17, String r18, String r19, Map<String, ? extends Object> r20) {
        Intrinsics.checkNotNullParameter(r4, "msgId");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
    }

    public /* synthetic */ v0(String r22, String r23, String r24, String r25, String r26, String r27, ViewGroup r28, ic8.x r29, int r30, int r31, Map r32, Map r33, boolean r34, boolean r35, String r36, String r37, Map r38, int r39) {
        if ((r39 & 4096) == 0) goto L5;
        boolean r16 = true;
    L7:
        if ((r39 & 8192) == 0) goto L9;
        boolean r17 = true;
    L11:
        if ((r39 & 16384) == 0) goto L13;
        String r18 = null;
    L15:
        if ((32768 & r39) == 0) goto L17;
        String r19 = null;
    L19:
        if ((r39 & 65536) == 0) goto L21;
        Map r20 = null;
    L22:
        this(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r16, r17, r18, r19, r20);
        return;
    L21:
        r20 = r38;
        goto L22
    L17:
        r19 = r37;
        goto L19
    L13:
        r18 = r36;
        goto L15
    L9:
        r17 = r35;
        goto L11
    L5:
        r16 = r34;
        goto L7
    }
}
