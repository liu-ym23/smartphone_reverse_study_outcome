package com.obric.assistant.task;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public final String a;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final Drawable e;
    public final Drawable f;
    public final TaskStatus g;
    public final int h;
    public final boolean i;
    public final String j;
    public final boolean k;
    public final long l;
    public final Function0<Unit> m;
    public final String n;
    public final Function0<Unit> o;
    public final boolean p;
    public final long q;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
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
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Drawable r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Drawable r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.g.hashCode()) * 31) + this.h) * 31;
        int r8 = 1231;
        if (this.i == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        if (this.k == false) goto L21;
        int r14 = 1231;
    L22:
        long r15 = this.l;
        int r16 = (((r13 + r14) * 31) + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        Function0<Unit> r17 = this.m;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.n;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Function0<Unit> r23 = this.o;
        if (r23 == null) goto L34;
        r2 = r23.hashCode();
    L34:
        int r24 = (r22 + r2) * 31;
        if (this.p == true) goto L39;
        r8 = 1237;
    L39:
        return r24 + r8;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskEntry(id=" + this.a + ", collapsedTitle=" + this.b + ", expandedTitle=" + this.c + ", description=" + this.d + ", collapsedIcon=" + this.e + ", expandedIcon=" + this.f + ", status=" + this.g + ", progress=" + this.h + ", hideProgressWhenCollapsed=" + this.i + ", statusText=" + this.j + ", isHighlight=" + this.k + ", timestamp=" + this.l + ", clickAction=" + this.m + ", swipeBtnText=" + this.n + ", swipeAction=" + this.o + ", completeSuccess=" + this.p + ')';
    }

    public static b a(b r22, String r23, long r24, int r26) {
        if ((r26 & 1) == 0) goto L5;
        String r5 = r22.a;
    L7:
        if ((r26 & 2) == 0) goto L9;
        CharSequence r6 = r22.b;
    L11:
        if ((r26 & 4) == 0) goto L13;
        CharSequence r7 = r22.c;
    L15:
        if ((r26 & 8) == 0) goto L17;
        CharSequence r8 = r22.d;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Drawable r9 = r22.e;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Drawable r10 = r22.f;
    L27:
        if ((r26 & 64) == 0) goto L29;
        TaskStatus r11 = r22.g;
    L31:
        if ((r26 & 128) == 0) goto L33;
        int r12 = r22.h;
    L35:
        if ((r26 & 256) == 0) goto L37;
        boolean r13 = r22.i;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r14 = r22.j;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        boolean r15 = r22.k;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        long r17 = r22.l;
    L51:
        if ((r26 & 4096) == 0) goto L53;
        Function0<Unit> r3 = r22.m;
    L55:
        if ((r26 & 8192) == 0) goto L57;
        String r19 = r22.n;
    L59:
        if ((r26 & 16384) == 0) goto L61;
        Function0<Unit> r20 = r22.o;
    L63:
        if ((r26 & 32768) == 0) goto L65;
        boolean r21 = r22.p;
    L66:
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "collapsedTitle");
        Intrinsics.checkNotNullParameter(r7, "expandedTitle");
        Intrinsics.checkNotNullParameter(r8, "description");
        Intrinsics.checkNotNullParameter(r11, "status");
        return new b(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r3, r19, r20, r21);
    L65:
        r21 = false;
        goto L66
    L61:
        r20 = null;
        goto L63
    L57:
        r19 = null;
        goto L59
    L53:
        r3 = null;
        goto L55
    L49:
        r17 = r24;
        goto L51
    L45:
        r15 = false;
        goto L47
    L41:
        r14 = r23;
        goto L43
    L37:
        r13 = false;
        goto L39
    L33:
        r12 = 0;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
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

    public b(String r8, CharSequence r9, CharSequence r10, CharSequence r11, Drawable r12, Drawable r13, TaskStatus r14, int r15, boolean r16, String r17, boolean r18, long r19, Function0<Unit> r21, String r22, Function0<Unit> r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r8, "id");
        Intrinsics.checkNotNullParameter(r9, "collapsedTitle");
        Intrinsics.checkNotNullParameter(r10, "expandedTitle");
        Intrinsics.checkNotNullParameter(r11, "description");
        Intrinsics.checkNotNullParameter(r14, "status");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r21;
        this.n = r22;
        this.o = r23;
        this.p = r24;
        this.q = SystemClock.elapsedRealtime();
    }
}
