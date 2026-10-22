package com.larus.platform.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final int e;
    public final FlowDriveFileType f;
    public final String g;
    public final int h;
    public final long i;
    public final long j;
    public final String k;
    public final int l;
    public final Map<String, String> m;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof u) == true) goto L8;
        return false;
    L8:
        u r9 = (u) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
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
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        String r3 = this.g;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (((r2 + r5) * 31) + this.h) * 31;
        long r7 = this.i;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.j;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r11 = this.k;
        if (r11 != null) goto L9;
        int r12 = 0;
    L10:
        int r13 = (((r10 + r12) * 31) + this.l) * 31;
        Map<String, String> r14 = this.m;
        if (r14 == null) goto L15;
        r4 = r14.hashCode();
    L15:
        return r13 + r4;
    L9:
        r12 = r11.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowSelectedFileItem(fileUri=" + this.a + ", fileName=" + this.b + ", fileSize=" + this.c + ", visitTime=" + this.d + ", iconRes=" + this.e + ", fileType=" + this.f + ", fileUrl=" + this.g + ", ccmType=" + this.h + ", openTime=" + this.i + ", editTime=" + this.j + ", iconInfo=" + this.k + ", isOwner=" + this.l + ", extra=" + this.m + ')';
    }

    public static u a(u r21, long r22, Map r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        String r5 = r21.a;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r6 = r21.b;
    L11:
        if ((r25 & 4) == 0) goto L13;
        long r7 = r21.c;
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r9 = r21.d;
    L19:
        if ((r25 & 16) == 0) goto L21;
        int r10 = r21.e;
    L23:
        if ((r25 & 32) == 0) goto L25;
        FlowDriveFileType r11 = r21.f;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r12 = r21.g;
    L31:
        if ((r25 & 128) == 0) goto L33;
        int r13 = r21.h;
    L35:
        if ((r25 & 256) == 0) goto L37;
        long r16 = r21.i;
    L39:
        if ((r25 & 512) == 0) goto L41;
        long r18 = r21.j;
    L43:
        if ((r25 & 1024) == 0) goto L45;
        String r2 = r21.k;
    L47:
        if ((r25 & 2048) == 0) goto L49;
        int r3 = r21.l;
    L51:
        if ((r25 & 4096) == 0) goto L53;
        Map r20 = r21.m;
    L54:
        r21.getClass();
        Intrinsics.checkNotNullParameter(r5, "fileUri");
        Intrinsics.checkNotNullParameter(r6, "fileName");
        Intrinsics.checkNotNullParameter(r9, "visitTime");
        Intrinsics.checkNotNullParameter(r11, "fileType");
        return new u(r5, r6, r7, r9, r10, r11, r12, r13, r16, r18, r2, r3, r20);
    L53:
        r20 = r24;
        goto L54
    L49:
        r3 = 0;
        goto L51
    L45:
        r2 = null;
        goto L47
    L41:
        r18 = 0;
        goto L43
    L37:
        r16 = 0;
        goto L39
    L33:
        r13 = 0;
        goto L35
    L29:
        r12 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r10 = 0;
        goto L23
    L17:
        r9 = null;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ u(String r21, String r22, long r23, String r25, int r26, FlowDriveFileType r27, String r28, int r29, Map r30, int r31) {
        if ((r31 & 4) == 0) goto L5;
        long r6 = 0;
    L7:
        if ((r31 & 32) == 0) goto L9;
        FlowDriveFileType r10 = FlowDriveFileType.FILE;
    L11:
        if ((r31 & 64) == 0) goto L13;
        String r11 = null;
    L15:
        if ((r31 & 128) == 0) goto L17;
        int r12 = 12;
    L19:
        if ((r31 & 2048) == 0) goto L21;
        int r18 = 1;
    L23:
        if ((r31 & 4096) == 0) goto L25;
        Map r19 = null;
    L26:
        this(r21, r22, r6, r25, r26, r10, r11, r12, 0, 0, null, r18, r19);
        return;
    L25:
        r19 = r30;
        goto L26
    L21:
        r18 = 0;
        goto L23
    L17:
        r12 = r29;
        goto L19
    L13:
        r11 = r28;
        goto L15
    L9:
        r10 = r27;
        goto L11
    L5:
        r6 = r23;
        goto L7
    }

    public u(String r7, String r8, long r9, String r11, int r12, FlowDriveFileType r13, String r14, int r15, long r16, long r18, String r20, int r21, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r7, "fileUri");
        Intrinsics.checkNotNullParameter(r8, "fileName");
        Intrinsics.checkNotNullParameter(r11, "visitTime");
        Intrinsics.checkNotNullParameter(r13, "fileType");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r18;
        this.k = r20;
        this.l = r21;
        this.m = r22;
    }
}
