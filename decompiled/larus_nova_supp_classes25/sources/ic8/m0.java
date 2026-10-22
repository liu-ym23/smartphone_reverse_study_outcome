package ic8;

import com.larus.platform.api.FlowDriveFileType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 {
    public final String a;
    public String b;
    public long c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public final boolean j;
    public final FlowDriveFileType k;
    public mr9.c l;
    public String m;
    public Float n;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r9 = (m0) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L50;
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
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.d;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        int r18 = 1231;
        if (this.g == false) goto L25;
        int r19 = 1231;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.h;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        if (this.i == false) goto L33;
        int r24 = 1231;
    L34:
        int r25 = (r23 + r24) * 31;
        if (this.j == true) goto L38;
        r18 = 1237;
    L38:
        int r26 = (r25 + r18) * 31;
        FlowDriveFileType r27 = this.k;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        mr9.c r30 = this.l;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        String r33 = this.m;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        Float r36 = this.n;
        if (r36 == null) goto L55;
        r1 = r36.hashCode();
    L55:
        return r35 + r1;
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L33:
        r24 = 1237;
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = 1237;
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProcessFileInfo(fileOriginPath=" + this.a + ", fileName=" + this.b + ", fileSize=" + this.c + ", fileType=" + this.d + ", localAppPath=" + this.e + ", fileMD5=" + this.f + ", isMultiFile=" + this.g + ", fileTosKey=" + this.h + ", isMarkedPhoto=" + this.i + ", isCroppedPhoto=" + this.j + ", driveFileType=" + this.k + ", instantUploadPolicy=" + this.l + ", originalImageFormat=" + this.m + ", duration=" + this.n + ')';
    }

    public final FlowDriveFileType b() {
        return this.k;
    }

    public final String c() {
        return this.b;
    }

    public final long d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public static m0 a(m0 r19, String r20, String r21, String r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        String r4 = r19.a;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = r19.b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r2 = r19.c;
    L14:
        long r6 = r2;
        if ((r23 & 8) == 0) goto L17;
        String r8 = r19.d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r9 = r19.e;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r10 = r19.f;
    L27:
        if ((r23 & 64) == 0) goto L29;
        boolean r3 = r19.g;
    L31:
        if ((r23 & 128) == 0) goto L33;
        String r12 = r19.h;
    L35:
        if ((r23 & 256) == 0) goto L37;
        boolean r13 = r19.i;
    L39:
        if ((r23 & 512) == 0) goto L41;
        boolean r14 = r19.j;
    L43:
        if ((r23 & 1024) == 0) goto L45;
        FlowDriveFileType r15 = r19.k;
    L47:
        if ((r23 & 2048) == 0) goto L49;
        mr9.c r16 = r19.l;
    L51:
        if ((r23 & 4096) == 0) goto L53;
        String r17 = r19.m;
    L55:
        if ((r23 & 8192) == 0) goto L57;
        Float r18 = r19.n;
    L59:
        return new m0(r4, r5, r6, r8, r9, r10, r3, r12, r13, r14, r15, r16, r17, r18);
    L57:
        r18 = null;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = false;
        goto L43
    L37:
        r13 = false;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r3 = false;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r2 = 0;
        goto L14
    L9:
        r5 = r21;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }

    public /* synthetic */ m0(String r20, String r21, long r22, String r24, String r25, FlowDriveFileType r26, String r27, int r28) {
        if ((r28 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r28 & 4) == 0) goto L9;
        long r6 = -1;
    L11:
        if ((r28 & 8) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r28 & 16) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r28 & 1024) == 0) goto L21;
        FlowDriveFileType r15 = null;
    L23:
        if ((r28 & 4096) == 0) goto L25;
        String r17 = null;
    L26:
        this(r20, r5, r6, r8, r9, null, false, null, false, false, r15, null, r17, null);
        return;
    L25:
        r17 = r27;
        goto L26
    L21:
        r15 = r26;
        goto L23
    L17:
        r9 = r25;
        goto L19
    L13:
        r8 = r24;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r5 = r21;
        goto L7
    }

    public m0(String r1, String r2, long r3, String r5, String r6, String r7, boolean r8, String r9, boolean r10, boolean r11, FlowDriveFileType r12, mr9.c r13, String r14, Float r15) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
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
