package com.larus.chat.job.impl.page.edit;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Set<ChatJobEditWeekday> e;
    public final String f;
    public final String g;
    public final h h;
    public final e0 i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final d0 q;
    public final int r;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
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
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n) * 31;
        int r2 = 1231;
        if (this.o == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.p == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        d0 r5 = this.q;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return ((r4 + r6) * 31) + this.r;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatJobEditUiState(title=" + this.a + ", prompt=" + this.b + ", repeat=" + this.c + ", frequency=" + this.d + ", selectedWeekdays=" + this.e + ", customFrequencyInput=" + this.f + ", customFrequencyResult=" + this.g + ", date=" + this.h + ", time=" + this.i + ", runTime=" + this.j + ", model=" + this.k + ", environment=" + this.l + ", project=" + this.m + ", status=" + this.n + ", isDirty=" + this.o + ", isSaving=" + this.p + ", subPage=" + this.q + ", jobType=" + this.r + ')';
    }

    public final boolean b() {
        if (this.o == true) goto L5;
    L13:
        return false;
    L5:
        if (this.p == true) goto L13;
        if ((!StringsKt.isBlank(this.a)) == false) goto L13;
        if ((!StringsKt.isBlank(this.b)) == false) goto L13;
        int r0 = com.larus.chat.job.impl.page.g0.a;
        if (com.larus.chat.job.impl.page.g0.b(this.r) == false) goto L13;
        return true;
    }

    public final boolean c() {
        if (this.r == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(String r16, String r17, String r18, String r19, Set<? extends ChatJobEditWeekday> r20, String r21, String r22, h r23, e0 r24, String r25, String r26, String r27, String r28, int r29, boolean r30, boolean r31, d0 r32, int r33) {
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "prompt");
        Intrinsics.checkNotNullParameter(r18, "repeat");
        Intrinsics.checkNotNullParameter(r19, "frequency");
        Intrinsics.checkNotNullParameter(r20, "selectedWeekdays");
        Intrinsics.checkNotNullParameter(r21, "customFrequencyInput");
        Intrinsics.checkNotNullParameter(r22, "customFrequencyResult");
        Intrinsics.checkNotNullParameter(r23, "date");
        Intrinsics.checkNotNullParameter(r24, "time");
        Intrinsics.checkNotNullParameter(r25, "runTime");
        Intrinsics.checkNotNullParameter(r26, "model");
        Intrinsics.checkNotNullParameter(r27, "environment");
        Intrinsics.checkNotNullParameter(r28, "project");
        this.a = r16;
        this.b = r17;
        this.c = r18;
        this.d = r19;
        this.e = r20;
        this.f = r21;
        this.g = r22;
        this.h = r23;
        this.i = r24;
        this.j = r25;
        this.k = r26;
        this.l = r27;
        this.m = r28;
        this.n = r29;
        this.o = r30;
        this.p = r31;
        this.q = r32;
        this.r = r33;
    }

    public static f0 a(f0 r17, String r18, String r19, String r20, String r21, Set r22, String r23, String r24, h r25, e0 r26, String r27, String r28, String r29, String r30, int r31, boolean r32, boolean r33, d0 r34, int r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = r17.a;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r17.b;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = r17.c;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = r17.d;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Set r6 = r17.e;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r7 = r17.f;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r8 = r17.g;
    L31:
        if ((r36 & 128) == 0) goto L33;
        h r9 = r17.h;
    L35:
        if ((r36 & 256) == 0) goto L37;
        e0 r10 = r17.i;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r11 = r17.j;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r12 = r17.k;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r13 = r17.l;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        String r14 = r17.m;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        int r15 = r17.n;
    L58:
        int r37 = r15;
        if ((r36 & 16384) == 0) goto L61;
        boolean r16 = r17.o;
    L62:
        boolean r38 = r16;
        if ((r36 & 32768) == 0) goto L65;
        boolean r110 = r17.p;
    L66:
        boolean r39 = r110;
        if ((r36 & 65536) == 0) goto L69;
        d0 r111 = r17.q;
    L71:
        if ((r36 & 131072) == 0) goto L73;
        int r1 = r17.r;
    L74:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "prompt");
        Intrinsics.checkNotNullParameter(r4, "repeat");
        Intrinsics.checkNotNullParameter(r5, "frequency");
        Intrinsics.checkNotNullParameter(r6, "selectedWeekdays");
        Intrinsics.checkNotNullParameter(r7, "customFrequencyInput");
        Intrinsics.checkNotNullParameter(r8, "customFrequencyResult");
        Intrinsics.checkNotNullParameter(r9, "date");
        Intrinsics.checkNotNullParameter(r10, "time");
        Intrinsics.checkNotNullParameter(r11, "runTime");
        Intrinsics.checkNotNullParameter(r12, "model");
        Intrinsics.checkNotNullParameter(r13, "environment");
        Intrinsics.checkNotNullParameter(r14, "project");
        return new f0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r39, r111, r1);
    L73:
        r1 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
