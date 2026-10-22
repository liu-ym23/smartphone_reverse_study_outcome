package com.larus.bmhome.share.panel;

import android.graphics.Bitmap;
import com.larus.im.bean.message.CreationTaskType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public Function1<? super String, Unit> A;
    public Function2<? super String, ? super Boolean, Unit> B;
    public final String a;
    public final Bitmap b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final m o;
    public final Map<String, String> p;
    public final boolean q;
    public final boolean r;
    public final String s;
    public final Job t;
    public final boolean u;
    public final boolean v;
    public final Integer w;
    public final boolean x;
    public final f y;
    public final c z;

    public b() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108863);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (this.u == r6.u) goto L72;
        return false;
    L72:
        if (this.v == r6.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r6.x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Bitmap r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        m r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Map<String, String> r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        int r49 = 1231;
        if (this.q == false) goto L69;
        int r50 = 1231;
    L70:
        int r51 = (r48 + r50) * 31;
        if (this.r == false) goto L73;
        int r52 = 1231;
    L74:
        int r53 = (r51 + r52) * 31;
        String r54 = this.s;
        if (r54 != null) goto L77;
        int r55 = 0;
    L78:
        int r56 = (r53 + r55) * 31;
        Job r57 = this.t;
        if (r57 != null) goto L81;
        int r58 = 0;
    L82:
        int r59 = (r56 + r58) * 31;
        if (this.u == false) goto L85;
        int r60 = 1231;
    L86:
        int r61 = (r59 + r60) * 31;
        if (this.v == false) goto L89;
        int r62 = 1231;
    L90:
        int r63 = (r61 + r62) * 31;
        Integer r64 = this.w;
        if (r64 != null) goto L93;
        int r65 = 0;
    L94:
        int r66 = (r63 + r65) * 31;
        if (this.x == true) goto L98;
        r49 = 1237;
    L98:
        int r67 = (r66 + r49) * 31;
        f r68 = this.y;
        if (r68 != null) goto L101;
        int r69 = 0;
    L102:
        int r70 = (r67 + r69) * 31;
        c r71 = this.z;
        if (r71 == null) goto L107;
        r1 = r71.hashCode();
    L107:
        return r70 + r1;
    L101:
        r69 = r68.hashCode();
        goto L102
    L93:
        r65 = r64.hashCode();
        goto L94
    L89:
        r62 = 1237;
        goto L90
    L85:
        r60 = 1237;
        goto L86
    L81:
        r58 = r57.hashCode();
        goto L82
    L77:
        r55 = r54.hashCode();
        goto L78
    L73:
        r52 = 1237;
        goto L74
    L69:
        r50 = 1237;
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
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
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
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
        return "FlowShareContent(imageUrl=" + this.a + ", imageBitmap=" + this.b + ", linkUrl=" + this.c + ", linkImageUrl=" + this.d + ", videoUrl=" + this.e + ", videoDownloadFilehash=" + this.f + ", vid=" + this.g + ", title=" + this.h + ", text=" + this.i + ", miniAppTitle=" + this.j + ", shareId=" + this.k + ", fileUrl=" + this.l + ", fileName=" + this.m + ", textContent=" + this.n + ", shareToast=" + this.o + ", exifMap=" + this.p + ", isAIGC=" + this.q + ", isShareOriginImage=" + this.r + ", imageKey=" + this.s + ", waitingJob=" + this.t + ", canScaleSize=" + this.u + ", dismissAfterLocalPathDownload=" + this.v + ", taskType=" + this.w + ", preferImageUrlForImageShare=" + this.x + ", manualImageMetadataInfo=" + this.y + ", hostForwardFile=" + this.z + ')';
    }

    public static b a(b r30, String r31, Bitmap r32, String r33, String r34, String r35, String r36, boolean r37, int r38) {
        if ((r38 & 1) == 0) goto L5;
        String r4 = r30.a;
    L7:
        if ((r38 & 2) == 0) goto L9;
        Bitmap r5 = r30.b;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r6 = r30.c;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r7 = r30.d;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r8 = r30.e;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r9 = r30.f;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r10 = r30.g;
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r11 = r30.h;
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r12 = r30.i;
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r13 = r30.j;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r14 = r30.k;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r15 = r30.l;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r16 = r30.m;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r17 = r30.n;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        m r18 = r30.o;
    L63:
        if ((32768 & r38) == 0) goto L65;
        Map<String, String> r19 = r30.p;
    L67:
        if ((65536 & r38) == 0) goto L69;
        boolean r20 = r30.q;
    L71:
        if ((131072 & r38) == 0) goto L73;
        boolean r2 = r30.r;
    L75:
        if ((r38 & 262144) == 0) goto L77;
        String r22 = r30.s;
    L79:
        if ((524288 & r38) == 0) goto L81;
        Job r23 = r30.t;
    L83:
        if ((1048576 & r38) == 0) goto L85;
        boolean r24 = r30.u;
    L87:
        if ((2097152 & r38) == 0) goto L89;
        boolean r25 = r30.v;
    L91:
        if ((4194304 & r38) == 0) goto L93;
        Integer r26 = r30.w;
    L95:
        if ((8388608 & r38) == 0) goto L97;
        boolean r27 = r30.x;
    L99:
        if ((16777216 & r38) == 0) goto L101;
        f r28 = r30.y;
    L103:
        if ((r38 & 33554432) == 0) goto L105;
        c r29 = r30.z;
    L106:
        r30.getClass();
        return new b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r2, r22, r23, r24, r25, r26, r27, r28, r29);
    L105:
        r29 = null;
        goto L106
    L101:
        r28 = null;
        goto L103
    L97:
        r27 = false;
        goto L99
    L93:
        r26 = null;
        goto L95
    L89:
        r25 = false;
        goto L91
    L85:
        r24 = false;
        goto L87
    L81:
        r23 = null;
        goto L83
    L77:
        r22 = null;
        goto L79
    L73:
        r2 = false;
        goto L75
    L69:
        r20 = r37;
        goto L71
    L65:
        r19 = null;
        goto L67
    L61:
        r18 = null;
        goto L63
    L57:
        r17 = null;
        goto L59
    L53:
        r16 = null;
        goto L55
    L49:
        r15 = null;
        goto L51
    L45:
        r14 = null;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = r36;
        goto L39
    L33:
        r11 = r35;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = r34;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r33;
        goto L15
    L9:
        r5 = r32;
        goto L11
    L5:
        r4 = r31;
        goto L7
    }

    public b(String r3, Bitmap r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, m r17, Map<String, String> r18, boolean r19, boolean r20, String r21, Job r22, boolean r23, boolean r24, @CreationTaskType Integer r25, boolean r26, f r27, c r28) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
    }

    public /* synthetic */ b(String r29, Bitmap r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, m r43, Map r44, boolean r45, boolean r46, String r47, Job r48, boolean r49, boolean r50, Integer r51, boolean r52, f r53, c r54, int r55) {
        if ((r55 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r55 & 2) == 0) goto L9;
        Bitmap r3 = null;
    L11:
        if ((r55 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r55 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r55 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r55 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r55 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r55 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r55 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r55 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r55 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r55 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r55 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r55 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r55 & 16384) == 0) goto L61;
        m r2 = null;
    L63:
        if ((r55 & 32768) == 0) goto L65;
        Map r17 = null;
    L66:
        boolean r19 = false;
        if ((r55 & 65536) == 0) goto L69;
        boolean r18 = false;
    L71:
        if ((r55 & 131072) == 0) goto L73;
        boolean r20 = false;
    L75:
        if ((r55 & 262144) == 0) goto L77;
        String r21 = null;
    L79:
        if ((r55 & 524288) == 0) goto L81;
        Job r22 = null;
    L83:
        if ((r55 & 1048576) == 0) goto L85;
        boolean r23 = true;
    L87:
        if ((r55 & 2097152) == 0) goto L89;
        boolean r24 = false;
    L91:
        if ((r55 & 4194304) == 0) goto L93;
        Integer r25 = null;
    L95:
        if ((r55 & 8388608) != 0) goto L99;
        r19 = r52;
    L99:
        if ((r55 & 16777216) == 0) goto L101;
        f r26 = null;
    L103:
        if ((r55 & 33554432) == 0) goto L105;
        c r16 = null;
    L106:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17, r18, r20, r21, r22, r23, r24, r25, r19, r26, r16);
        return;
    L105:
        r16 = r54;
        goto L106
    L101:
        r26 = r53;
        goto L103
    L93:
        r25 = r51;
        goto L95
    L89:
        r24 = r50;
        goto L91
    L85:
        r23 = r49;
        goto L87
    L81:
        r22 = r48;
        goto L83
    L77:
        r21 = r47;
        goto L79
    L73:
        r20 = r46;
        goto L75
    L69:
        r18 = r45;
        goto L71
    L65:
        r17 = r44;
        goto L66
    L61:
        r2 = r43;
        goto L63
    L57:
        r15 = r42;
        goto L59
    L53:
        r14 = r41;
        goto L55
    L49:
        r13 = r40;
        goto L51
    L45:
        r12 = r39;
        goto L47
    L41:
        r11 = r38;
        goto L43
    L37:
        r10 = r37;
        goto L39
    L33:
        r9 = r36;
        goto L35
    L29:
        r8 = r35;
        goto L31
    L25:
        r7 = r34;
        goto L27
    L21:
        r6 = r33;
        goto L23
    L17:
        r5 = r32;
        goto L19
    L13:
        r4 = r31;
        goto L15
    L9:
        r3 = r30;
        goto L11
    L5:
        r1 = r29;
        goto L7
    }
}
