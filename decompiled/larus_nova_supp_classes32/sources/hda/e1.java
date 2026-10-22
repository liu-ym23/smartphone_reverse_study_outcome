package hda;

import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e1 {
    public final String a;
    public final MemoryDataReviewModuleKey b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final List<h0> j;
    public final List<d> k;
    public final List<String> l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final int q;
    public final List<e1> r;
    public final String s;
    public final String t;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r6 = (e1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.g.hashCode()) * 31;
        String r5 = this.h;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.i;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((((r7 + r9) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        String r11 = this.m;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.n;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.o;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.p;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((((((r19 + r21) * 31) + this.q) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31;
        String r23 = this.t;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
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
        return "MemoryReviewUiModel(recordId=" + this.a + ", module=" + this.b + ", title=" + this.c + ", summary=" + this.d + ", previewText=" + this.e + ", sourceEntityId=" + this.f + ", timeLabel=" + this.g + ", sourceAppName=" + this.h + ", sourceAppPackageName=" + this.i + ", imageRefs=" + this.j + ", chatBubbles=" + this.k + ", sourceTexts=" + this.l + ", currentText=" + this.m + ", oldText=" + this.n + ", diffCurrentText=" + this.o + ", diffOldText=" + this.p + ", updateCount=" + this.q + ", versions=" + this.r + ", displayedCardJson=" + this.s + ", traceJson=" + this.t + ')';
    }

    public static e1 a(e1 r25, String r26, String r27, String r28, List r29, int r30) {
        if ((r30 & 1) == 0) goto L5;
        String r5 = r25.a;
    L7:
        if ((r30 & 2) == 0) goto L9;
        MemoryDataReviewModuleKey r6 = r25.b;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r7 = r25.c;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r8 = r25.d;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r9 = r25.e;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r10 = r25.f;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r11 = r25.g;
    L31:
        if ((r30 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r12 = r25.h;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r13 = r25.i;
    L39:
        if ((r30 & 512) == 0) goto L41;
        List<h0> r14 = r25.j;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        List<d> r15 = r25.k;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        List<String> r2 = r25.l;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r17 = r25.m;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r18 = r25.n;
    L59:
        if ((r30 & 16384) == 0) goto L61;
        String r19 = r25.o;
    L63:
        if ((32768 & r30) == 0) goto L65;
        String r20 = r25.p;
    L67:
        if ((65536 & r30) == 0) goto L69;
        int r21 = r25.q;
    L71:
        if ((131072 & r30) == 0) goto L73;
        List r4 = r25.r;
    L75:
        if ((r30 & 262144) == 0) goto L77;
        String r3 = r25.s;
    L79:
        if ((r30 & 524288) == 0) goto L81;
        String r24 = r25.t;
    L82:
        r25.getClass();
        Intrinsics.checkNotNullParameter(r5, "recordId");
        Intrinsics.checkNotNullParameter(r6, "module");
        Intrinsics.checkNotNullParameter(r7, "title");
        Intrinsics.checkNotNullParameter(r8, "summary");
        Intrinsics.checkNotNullParameter(r9, "previewText");
        Intrinsics.checkNotNullParameter(r11, "timeLabel");
        Intrinsics.checkNotNullParameter(r14, "imageRefs");
        Intrinsics.checkNotNullParameter(r15, "chatBubbles");
        Intrinsics.checkNotNullParameter(r2, "sourceTexts");
        Intrinsics.checkNotNullParameter(r4, "versions");
        Intrinsics.checkNotNullParameter(r3, "displayedCardJson");
        List<String> r16 = r2;
        return new e1(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r4, r3, r24);
    L81:
        r24 = null;
        goto L82
    L77:
        r3 = null;
        goto L79
    L73:
        r4 = r29;
        goto L75
    L69:
        r21 = 0;
        goto L71
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = null;
        goto L59
    L53:
        r17 = r28;
        goto L55
    L49:
        r2 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = r27;
        goto L23
    L17:
        r8 = r26;
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

    public e1(String r14, MemoryDataReviewModuleKey r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, List<h0> r23, List<d> r24, List<String> r25, String r26, String r27, String r28, String r29, int r30, List<e1> r31, String r32, String r33) {
        Intrinsics.checkNotNullParameter(r14, "recordId");
        Intrinsics.checkNotNullParameter(r15, "module");
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "summary");
        Intrinsics.checkNotNullParameter(r18, "previewText");
        Intrinsics.checkNotNullParameter(r20, "timeLabel");
        Intrinsics.checkNotNullParameter(r23, "imageRefs");
        Intrinsics.checkNotNullParameter(r24, "chatBubbles");
        Intrinsics.checkNotNullParameter(r25, "sourceTexts");
        Intrinsics.checkNotNullParameter(r31, "versions");
        Intrinsics.checkNotNullParameter(r32, "displayedCardJson");
        this.a = r14;
        this.b = r15;
        this.c = r16;
        this.d = r17;
        this.e = r18;
        this.f = r19;
        this.g = r20;
        this.h = r21;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r30;
        this.r = r31;
        this.s = r32;
        this.t = r33;
    }
}
