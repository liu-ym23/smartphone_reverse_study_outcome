package jz;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final String e;
    public final Map<String, String> f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L30;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r11 = this.d;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Map<String, String> r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r21 = this.g;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        String r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        String r27 = this.i;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        String r31 = this.j;
        if (r31 == null) goto L41;
        int r32 = r31.hashCode();
    L42:
        int r33 = (r29 + r32) * 31;
        String r34 = this.k;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        String r37 = this.l;
        if (r37 == null) goto L50;
        r1 = r37.hashCode();
    L50:
        return r36 + r1;
    L45:
        r35 = 0;
        goto L46
    L41:
        r32 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SoloKtvPublishModel(videoPath=" + this.a + ", shootWay=" + this.b + ", title=" + this.c + ", challenges=" + this.d + ", creationId=" + this.e + ", anchorInfo=" + this.f + ", songName=" + this.g + ", enterFrom=" + this.h + ", recordType=" + this.i + ", templateType=" + this.j + ", mvType=" + this.k + ", mvId=" + this.l + ")";
    }

    public h(String r3, String r4, List r5, String r6, Map r7, String r8, String r9, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r3, "videoPath");
        Intrinsics.checkNotNullParameter("solo_ktv", "shootWay");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "challenges");
        Intrinsics.checkNotNullParameter(r6, "creationId");
        Intrinsics.checkNotNullParameter(r7, "anchorInfo");
        Intrinsics.checkNotNullParameter(r8, "songName");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        Intrinsics.checkNotNullParameter(r11, "recordType");
        Intrinsics.checkNotNullParameter(r12, "templateType");
        Intrinsics.checkNotNullParameter(r13, "mvType");
        Intrinsics.checkNotNullParameter(r14, "mvId");
        this.a = r3;
        this.b = "solo_ktv";
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
