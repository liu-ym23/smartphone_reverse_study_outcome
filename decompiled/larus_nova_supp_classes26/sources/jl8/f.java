package jl8;

import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final GenericToolViewStage d;
    public final Pair<Integer, Integer> e;
    public final String f;
    public final int g;
    public final Integer h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final int m;
    public final int n;

    public f() {
        this(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L50;
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.d.hashCode()) * 31;
        Pair<Integer, Integer> r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((r12 + r14) * 31) + this.g) * 31;
        Integer r16 = this.h;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        int r18 = 1231;
        if (this.i == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r17 + r19) * 31;
        if (this.j == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.k == true) goto L39;
        r18 = 1237;
    L39:
        return ((((((r22 + r18) * 31) + this.l) * 31) + this.m) * 31) + this.n;
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
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
        return "GenericToolViewInput(iconUrl=" + this.a + ", iconUrlDark=" + this.b + ", title=" + this.c + ", stage=" + this.d + ", topAndBottomMarginPair=" + this.e + ", messageId=" + this.f + ", cardPosition=" + this.g + ", backgroundRes=" + this.h + ", showArrow=" + this.i + ", arrowExpanded=" + this.j + ", iconRoundAsCircle=" + this.k + ", iconSize=" + this.l + ", iconStartPadding=" + this.m + ", iconTitleSpacing=" + this.n + ')';
    }

    public f(String r17, String r18, String r19, GenericToolViewStage r20, Pair r21, String r22, int r23, Integer r24, boolean r25, boolean r26, boolean r27, int r28, int r29, int r30, int r31) {
        Integer r3 = null;
        if ((r31 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        GenericToolViewStage r6 = GenericToolViewStage.LOADING;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Pair r7 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r8 = null;
    L26:
        int r10 = 0;
        if ((r31 & 64) == 0) goto L29;
        int r9 = 0;
    L31:
        if ((r31 & 128) != 0) goto L35;
        r3 = r24;
    L35:
        if ((r31 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r31 & 512) == 0) goto L41;
        boolean r12 = false;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        int r14 = i5.E();
    L51:
        if ((r31 & 4096) != 0) goto L55;
        r10 = r29;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        int r1 = i5.Y();
    L58:
        Intrinsics.checkNotNullParameter(r6, "stage");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r3;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r10;
        this.n = r1;
        return;
    L57:
        r1 = r30;
        goto L58
    L49:
        r14 = r28;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L26
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
