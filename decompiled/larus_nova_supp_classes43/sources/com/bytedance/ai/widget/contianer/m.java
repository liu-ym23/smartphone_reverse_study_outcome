package com.bytedance.ai.widget.contianer;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Map<String, String> h;
    public final Map<String, Object> i;
    public final String j;
    public final String k;
    public final String l;
    public final Map<String, Object> m;
    public final Map<String, Object> n;
    public final String o;
    public final String p;
    public final String q;
    public final Function1<? super Boolean, Unit> r;
    public final String s;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r11.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r11.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r11.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r11.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r11.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r11.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r11.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r11.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (((((r0 + r11) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r13 = this.f;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Map<String, String> r19 = this.h;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Map<String, Object> r22 = this.i;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.j;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        String r28 = this.k;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        String r31 = this.l;
        if (r31 != null) goto L33;
        int r32 = 0;
    L34:
        int r33 = (r30 + r32) * 31;
        Map<String, Object> r34 = this.m;
        if (r34 != null) goto L37;
        int r35 = 0;
    L38:
        int r36 = (r33 + r35) * 31;
        Map<String, Object> r37 = this.n;
        if (r37 != null) goto L41;
        int r38 = 0;
    L42:
        int r39 = (r36 + r38) * 31;
        String r40 = this.o;
        if (r40 != null) goto L45;
        int r41 = 0;
    L46:
        int r42 = (r39 + r41) * 31;
        String r43 = this.p;
        if (r43 != null) goto L49;
        int r44 = 0;
    L50:
        int r45 = (r42 + r44) * 31;
        String r46 = this.q;
        if (r46 != null) goto L53;
        int r47 = 0;
    L54:
        int r48 = (r45 + r47) * 31;
        Function1<? super Boolean, Unit> r49 = this.r;
        if (r49 != null) goto L57;
        int r50 = 0;
    L58:
        int r51 = (r48 + r50) * 31;
        String r52 = this.s;
        if (r52 == null) goto L63;
        r10 = r52.hashCode();
    L63:
        return r51 + r10;
    L57:
        r50 = r49.hashCode();
        goto L58
    L53:
        r47 = r46.hashCode();
        goto L54
    L49:
        r44 = r43.hashCode();
        goto L50
    L45:
        r41 = r40.hashCode();
        goto L46
    L41:
        r38 = r37.hashCode();
        goto L42
    L37:
        r35 = r34.hashCode();
        goto L38
    L33:
        r32 = r31.hashCode();
        goto L34
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetContainerData(packageName=" + this.a + ", widgetId=" + this.b + ", widgetData=" + this.c + ", botId=" + this.d + ", messageId=" + this.e + ", sectionId=" + this.f + ", replyId=" + this.g + ", ext=" + this.h + ", params=" + this.i + ", mixtureCardId=" + this.j + ", conversationId=" + this.k + ", liteTemplateUrl=" + this.l + ", globalProps=" + this.m + ", extra=" + this.n + ", mcpName=" + this.o + ", fullScreenRefresh=" + this.p + ", entityId=" + this.q + ", isLongClickable=" + this.r + ", versionTag=" + this.s + ')';
    }

    public final String a() {
        String r0 = this.j;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return this.e;
    L13:
        return this.j;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public /* synthetic */ m(String r24, String r25, String r26, String r27, String r28, String r29, String r30, Map r31, Map r32, String r33, String r34, String r35, Map r36, Map r37, String r38, String r39, String r40, String r41, int r42) {
        if ((r42 & 4) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r42 & 32) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r42 & 64) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r42 & 128) == 0) goto L17;
        Map r13 = null;
    L19:
        if ((r42 & 256) == 0) goto L21;
        Map r14 = null;
    L23:
        if ((r42 & 512) == 0) goto L25;
        String r15 = null;
    L27:
        if ((r42 & 1024) == 0) goto L29;
        String r16 = null;
    L31:
        if ((r42 & 2048) == 0) goto L33;
        String r17 = null;
    L35:
        if ((r42 & 4096) == 0) goto L37;
        Map r18 = null;
    L39:
        if ((r42 & 8192) == 0) goto L41;
        Map r19 = null;
    L43:
        if ((r42 & 16384) == 0) goto L45;
        String r110 = null;
    L47:
        if ((32768 & r42) == 0) goto L49;
        String r111 = null;
    L51:
        if ((65536 & r42) == 0) goto L53;
        String r20 = null;
    L55:
        if ((r42 & 262144) == 0) goto L57;
        String r22 = null;
    L58:
        this(r24, r25, r10, r27, r28, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, null, r22);
        return;
    L57:
        r22 = r41;
        goto L58
    L53:
        r20 = r40;
        goto L55
    L49:
        r111 = r39;
        goto L51
    L45:
        r110 = r38;
        goto L47
    L41:
        r19 = r37;
        goto L43
    L37:
        r18 = r36;
        goto L39
    L33:
        r17 = r35;
        goto L35
    L29:
        r16 = r34;
        goto L31
    L25:
        r15 = r33;
        goto L27
    L21:
        r14 = r32;
        goto L23
    L17:
        r13 = r31;
        goto L19
    L13:
        r12 = r30;
        goto L15
    L9:
        r11 = r29;
        goto L11
    L5:
        r10 = r26;
        goto L7
    }

    public m(String r10, String r11, String r12, String r13, String r14, String r15, String r16, Map<String, String> r17, Map<String, ? extends Object> r18, String r19, String r110, String r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r20, String r21, String r22, String r23, Function1<? super Boolean, Unit> r24, String r25) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r14, "messageId");
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
        this.k = r110;
        this.l = r111;
        this.m = r112;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.s = r25;
    }
}
