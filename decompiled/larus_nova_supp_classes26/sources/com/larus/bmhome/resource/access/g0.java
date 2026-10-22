package com.larus.bmhome.resource.access;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final CountDownLatch g;
    public final mr9.h h;
    public final mr9.c i;
    public final Long j;
    public final v k;
    public final d0 l;
    public final Map<String, String> m;
    public final Map<String, String> n;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
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
        if (this.f == r6.f) goto L27;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.f == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        CountDownLatch r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((r12 + r14) * 31) + this.h.hashCode()) * 31;
        mr9.c r16 = this.i;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.j;
        if (r19 == null) goto L31;
        r2 = r19.hashCode();
    L31:
        return ((((((((r18 + r2) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode();
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = 1237;
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
        return "ResourceBizContext(fileIdentifier=" + this.a + ", uploadBizScene=" + this.b + ", bizScope=" + this.c + ", uploadSourceScene=" + this.d + ", fileExtension=" + this.e + ", limitUploaderCount=" + this.f + ", latch=" + this.g + ", resourceCenterUploadParam=" + this.h + ", instantUploadPolicy=" + this.i + ", uploadFileSize=" + this.j + ", options=" + this.k + ", timeoutConfig=" + this.l + ", ext=" + this.m + ", runtimeExt=" + this.n + ')';
    }

    public static g0 a(g0 r19, mr9.c r20, Long r21, int r22) {
        Map<String, String> r3 = null;
        if ((r22 & 1) == 0) goto L5;
        String r5 = r19.a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = r19.b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r7 = r19.c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r8 = r19.d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r9 = r19.e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r10 = r19.f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        CountDownLatch r11 = r19.g;
    L31:
        if ((r22 & 128) == 0) goto L33;
        mr9.h r12 = r19.h;
    L35:
        if ((r22 & 256) == 0) goto L37;
        mr9.c r13 = r19.i;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Long r14 = r19.j;
    L43:
        if ((r22 & 1024) == 0) goto L45;
        v r15 = r19.k;
    L47:
        if ((r22 & 2048) == 0) goto L49;
        d0 r2 = r19.l;
    L51:
        if ((r22 & 4096) == 0) goto L53;
        Map<String, String> r4 = r19.m;
    L55:
        if ((r22 & 8192) == 0) goto L57;
        r3 = r19.n;
    L57:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r6, "uploadBizScene");
        Intrinsics.checkNotNullParameter(r12, "resourceCenterUploadParam");
        Intrinsics.checkNotNullParameter(r15, "options");
        Intrinsics.checkNotNullParameter(r2, "timeoutConfig");
        Intrinsics.checkNotNullParameter(r4, "ext");
        Intrinsics.checkNotNullParameter(r3, "runtimeExt");
        return new g0(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r4, r3);
    L53:
        r4 = null;
        goto L55
    L49:
        r2 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = r21;
        goto L43
    L37:
        r13 = r20;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = false;
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

    public g0(String r2, String r3, String r4, String r5, String r6, boolean r7, CountDownLatch r8, mr9.h r9, mr9.c r10, Long r11, v r12, d0 r13, Map<String, String> r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r3, "uploadBizScene");
        Intrinsics.checkNotNullParameter(r9, "resourceCenterUploadParam");
        Intrinsics.checkNotNullParameter(r12, "options");
        Intrinsics.checkNotNullParameter(r13, "timeoutConfig");
        Intrinsics.checkNotNullParameter(r14, "ext");
        Intrinsics.checkNotNullParameter(r15, "runtimeExt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}
