package com.larus.bmhome.chat.layout.widget;

import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Fragment g;
    public final int h;
    public final Map<String, String> i;
    public final Map<String, Object> j;
    public final String k;
    public final boolean l;
    public final String m;
    public final kc8.n n;
    public final kc8.e0 o;
    public final String p;
    public final String q;
    public final Map<String, Object> r;

    public u() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
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
        if (this.h == r6.h) goto L33;
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
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
        return false;
    L62:
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
        Fragment r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + this.h) * 31;
        Map<String, String> r20 = this.i;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Map<String, Object> r23 = this.j;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.k;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        if (this.l == false) goto L41;
        int r29 = 1231;
    L42:
        int r30 = (r28 + r29) * 31;
        String r31 = this.m;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        kc8.n r34 = this.n;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        kc8.e0 r37 = this.o;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.p;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.q;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Map<String, Object> r46 = this.r;
        if (r46 == null) goto L67;
        r2 = r46.hashCode();
    L67:
        return r45 + r2;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
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
        r29 = 1237;
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
        return "AppletBindData(msgId=" + this.a + ", botId=" + this.b + ", convId=" + this.c + ", sectionId=" + this.d + ", replyId=" + this.e + ", renderData=" + this.f + ", hostFragment=" + this.g + ", layoutPosition=" + this.h + ", ext=" + this.i + ", params=" + this.j + ", cardId=" + this.k + ", enableCache=" + this.l + ", templateUrl=" + this.m + ", containerPadding=" + this.n + ", menuInterceptor=" + this.o + ", originMessageId=" + this.p + ", widgetTheme=" + this.q + ", extra=" + this.r + ')';
    }

    public u(String r15, String r16, String r17, String r18, String r19, String r20, Fragment r21, int r22, Map r23, Map r24, String r25, boolean r26, String r27, kc8.n r28, kc8.e0 r29, String r30, String r31, Map r32, int r33) {
        Map r4 = null;
        if ((r33 & 256) == 0) goto L5;
        Map r3 = null;
    L7:
        if ((r33 & 512) == 0) goto L9;
        Map r5 = null;
    L11:
        if ((r33 & 1024) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r33 & 2048) == 0) goto L17;
        boolean r7 = true;
    L19:
        if ((r33 & 4096) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r33 & 8192) == 0) goto L25;
        kc8.n r9 = null;
    L27:
        if ((r33 & 16384) == 0) goto L29;
        kc8.e0 r10 = null;
    L31:
        if ((32768 & r33) == 0) goto L33;
        String r11 = null;
    L35:
        if ((65536 & r33) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r33 & 131072) != 0) goto L42;
        r4 = r32;
    L42:
        Intrinsics.checkNotNullParameter(r15, "msgId");
        this.a = r15;
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r22;
        this.i = r3;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r12;
        this.r = r4;
        return;
    L37:
        r12 = r31;
        goto L39
    L33:
        r11 = r30;
        goto L35
    L29:
        r10 = r29;
        goto L31
    L25:
        r9 = r28;
        goto L27
    L21:
        r8 = r27;
        goto L23
    L17:
        r7 = r26;
        goto L19
    L13:
        r6 = r25;
        goto L15
    L9:
        r5 = r24;
        goto L11
    L5:
        r3 = r23;
        goto L7
    }
}
