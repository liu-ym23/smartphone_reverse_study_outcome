package com.obric.miniapp.alarm;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final w d;
    public final long e;
    public final int f;
    public final int g;
    public final boolean h;
    public final w i;
    public final Map<String, String> j;
    public final boolean k;
    public final String l;

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.a$a, reason: collision with other inner class name */
    public static final class C0043a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
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
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
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
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f) * 31) + this.g) * 31;
        int r3 = 1231;
        if (this.h == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (((((r2 + r4) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        if (this.k == true) goto L11;
        r3 = 1237;
    L11:
        return ((r5 + r3) * 31) + this.l.hashCode();
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "Alarm(id=" + this.a + ", title=" + this.b + ", content=" + this.c + ", triggerTime=" + this.d + ", intervalMinutes=" + this.e + ", repeatCount=" + this.f + ", currentRepeatCount=" + this.g + ", isActive=" + this.h + ", createdAt=" + this.i + ", extraInfo=" + this.j + ", useSystemClock=" + this.k + ", token=" + this.l + ')';
    }

    public /* synthetic */ a(String r18, String r19, String r20, w r21, long r22, int r24, w r25, Map r26, boolean r27, String r28, int r29) {
        if ((r29 & 16) == 0) goto L5;
        long r8 = 0;
    L7:
        if ((r29 & 32) == 0) goto L9;
        int r10 = 0;
    L11:
        if ((r29 & 128) == 0) goto L13;
        boolean r12 = true;
    L15:
        if ((r29 & 512) == 0) goto L17;
        Map r14 = new LinkedHashMap();
    L19:
        if ((r29 & 1024) == 0) goto L21;
        boolean r15 = false;
    L22:
        this(r18, r19, r20, r21, r8, r10, 0, r12, r25, r14, r15, r28);
        return;
    L21:
        r15 = r27;
        goto L22
    L17:
        r14 = r26;
        goto L19
    L13:
        r12 = false;
        goto L15
    L9:
        r10 = r24;
        goto L11
    L5:
        r8 = r22;
        goto L7
    }

    public static a a(a r17, String r18, String r19, String r20, w r21, long r22, int r24, Map r25, boolean r26, String r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        String r4 = r17.a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r5 = r17.b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = r17.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        w r7 = r17.d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        long r8 = r17.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r10 = r17.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        int r11 = r17.g;
    L31:
        if ((r28 & 128) == 0) goto L33;
        boolean r12 = r17.h;
    L35:
        if ((r28 & 256) == 0) goto L37;
        w r2 = r17.i;
    L38:
        w r13 = r2;
        if ((r28 & 512) == 0) goto L41;
        Map r14 = r17.j;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        boolean r15 = r17.k;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r0 = r17.l;
    L50:
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "content");
        Intrinsics.checkNotNullParameter(r7, "triggerTime");
        Intrinsics.checkNotNullParameter(r13, "createdAt");
        Intrinsics.checkNotNullParameter(r14, "extraInfo");
        Intrinsics.checkNotNullParameter(r0, "token");
        return new a(r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r0);
    L49:
        r0 = r27;
        goto L50
    L45:
        r15 = r26;
        goto L47
    L41:
        r14 = r25;
        goto L43
    L37:
        r2 = null;
        goto L38
    L33:
        r12 = false;
        goto L35
    L29:
        r11 = 0;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public a(String r2, String r3, String r4, w r5, long r6, int r8, int r9, boolean r10, w r11, Map<String, String> r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "triggerTime");
        Intrinsics.checkNotNullParameter(r11, "createdAt");
        Intrinsics.checkNotNullParameter(r12, "extraInfo");
        Intrinsics.checkNotNullParameter(r14, "token");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
