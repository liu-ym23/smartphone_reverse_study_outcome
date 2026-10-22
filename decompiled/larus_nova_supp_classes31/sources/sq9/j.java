package sq9;

import com.larus.bmhome.share.ShareScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final com.larus.bmhome.share.panel.d f;
    public final com.larus.bmhome.share.panel.h g;
    public final ShareScene h;
    public final long i;
    public final long j;
    public final i k;
    public final Map<String, String> l;
    public final int m;
    public final String n;
    public final Integer o;
    public final String p;
    public final String q;

    public j() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
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
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r4 = this.d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.larus.bmhome.share.panel.d r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        com.larus.bmhome.share.panel.h r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((r12 + r14) * 31) + this.h.hashCode()) * 31;
        long r16 = this.i;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.j;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        i r20 = this.k;
        if (r20 != null) goto L25;
        int r21 = 0;
    L26:
        int r22 = (r19 + r21) * 31;
        Map<String, String> r23 = this.l;
        if (r23 != null) goto L29;
        int r24 = 0;
    L30:
        int r25 = (((r22 + r24) * 31) + this.m) * 31;
        String r26 = this.n;
        if (r26 != null) goto L33;
        int r27 = 0;
    L34:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.o;
        if (r29 != null) goto L37;
        int r30 = 0;
    L38:
        int r31 = (r28 + r30) * 31;
        String r32 = this.p;
        if (r32 != null) goto L41;
        int r33 = 0;
    L42:
        int r34 = (r31 + r33) * 31;
        String r35 = this.q;
        if (r35 == null) goto L47;
        r1 = r35.hashCode();
    L47:
        return r34 + r1;
    L41:
        r33 = r32.hashCode();
        goto L42
    L37:
        r30 = r29.hashCode();
        goto L38
    L33:
        r27 = r26.hashCode();
        goto L34
    L29:
        r24 = r23.hashCode();
        goto L30
    L25:
        r21 = r20.hashCode();
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
        return "CreationImageShareModel(creationId=" + this.a + ", previewImageUrl=" + this.b + ", downloadImageUrl=" + this.c + ", rawImageUrl=" + this.d + ", refImageUrl=" + this.e + ", callback=" + this.f + ", sharePanelEventParam=" + this.g + ", shareScene=" + this.h + ", defaultImageWidth=" + this.i + ", defaultImageHeight=" + this.j + ", creationImageShareEventModel=" + this.k + ", metaDataExifMap=" + this.l + ", videoDuration=" + this.m + ", videoDownloadFilehash=" + this.n + ", taskType=" + this.o + ", vid=" + this.p + ", imageKey=" + this.q + ')';
    }

    public j(String r19, String r20, String r21, String r22, String r23, com.larus.bmhome.share.panel.d r24, com.larus.bmhome.share.panel.h r25, ShareScene r26, long r27, long r29, i r31, Map r32, int r33, String r34, Integer r35, String r36, String r37, int r38) {
        if ((r38 & 1) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r38 & 32) == 0) goto L9;
        com.larus.bmhome.share.panel.d r7 = null;
    L10:
        long r9 = -1;
        if ((r38 & 256) == 0) goto L13;
        long r11 = -1;
    L15:
        if ((r38 & 512) != 0) goto L19;
        r9 = r29;
    L19:
        if ((r38 & 1024) == 0) goto L21;
        i r8 = null;
    L23:
        if ((r38 & 4096) == 0) goto L25;
        int r13 = 0;
    L27:
        if ((r38 & 8192) == 0) goto L29;
        String r14 = null;
    L31:
        if ((r38 & 16384) == 0) goto L33;
        Integer r15 = null;
    L35:
        if ((r38 & 32768) == 0) goto L37;
        String r6 = null;
    L39:
        if ((r38 & 65536) == 0) goto L41;
        String r16 = null;
    L42:
        Intrinsics.checkNotNullParameter(r20, "previewImageUrl");
        Intrinsics.checkNotNullParameter(r21, "downloadImageUrl");
        Intrinsics.checkNotNullParameter(r26, "shareScene");
        this.a = r5;
        this.b = r20;
        this.c = r21;
        this.d = r22;
        this.e = r23;
        this.f = r7;
        this.g = r25;
        this.h = r26;
        this.i = r11;
        this.j = r9;
        this.k = r8;
        this.l = r32;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.p = r6;
        this.q = r16;
        return;
    L41:
        r16 = r37;
        goto L42
    L37:
        r6 = r36;
        goto L39
    L33:
        r15 = r35;
        goto L35
    L29:
        r14 = r34;
        goto L31
    L25:
        r13 = r33;
        goto L27
    L21:
        r8 = r31;
        goto L23
    L13:
        r11 = r27;
        goto L15
    L9:
        r7 = r24;
        goto L10
    L5:
        r5 = r19;
        goto L7
    }
}
