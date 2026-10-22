package l0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final UserCreation a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final Integer k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        UserCreation r0 = this.a;
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
        int r7 = 1231;
        if (this.c == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == true) goto L18;
        r7 = 1237;
    L18:
        int r10 = (r9 + r7) * 31;
        String r11 = this.e;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        String r20 = this.h;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (r22 + r24) * 31;
        String r26 = this.j;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.k;
        if (r29 != null) goto L45;
        int r30 = 0;
    L46:
        int r31 = (r28 + r30) * 31;
        String r32 = this.l;
        if (r32 != null) goto L49;
        int r33 = 0;
    L50:
        int r34 = (r31 + r33) * 31;
        String r35 = this.m;
        if (r35 != null) goto L53;
        int r36 = 0;
    L54:
        int r37 = (r34 + r36) * 31;
        String r38 = this.n;
        if (r38 != null) goto L57;
        int r39 = 0;
    L58:
        int r40 = (r37 + r39) * 31;
        String r41 = this.o;
        if (r41 != null) goto L61;
        int r42 = 0;
    L62:
        int r43 = (r40 + r42) * 31;
        String r44 = this.p;
        if (r44 != null) goto L65;
        int r45 = 0;
    L66:
        int r46 = (r43 + r45) * 31;
        String r47 = this.q;
        if (r47 == null) goto L71;
        r1 = r47.hashCode();
    L71:
        return r46 + r1;
    L65:
        r45 = r44.hashCode();
        goto L66
    L61:
        r42 = r41.hashCode();
        goto L62
    L57:
        r39 = r38.hashCode();
        goto L58
    L53:
        r36 = r35.hashCode();
        goto L54
    L49:
        r33 = r32.hashCode();
        goto L50
    L45:
        r30 = r29.hashCode();
        goto L46
    L41:
        r27 = r26.hashCode();
        goto L42
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = r20.hashCode();
        goto L34
    L29:
        r18 = r17.hashCode();
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobDoSameParamsKmp(creation=" + this.a + ", enterFrom=" + this.b + ", isFromCaption=" + this.c + ", ignoreTplInfo=" + this.d + ", botId=" + this.e + ", aiCreationRecommendFrom=" + this.f + ", currentPage=" + this.g + ", previousPage=" + this.h + ", chatType=" + this.i + ", conversationId=" + this.j + ", actionBarTemplateId=" + this.k + ", enterMethod=" + this.l + ", promptType=" + this.m + ", promptFrom=" + this.n + ", visualSize=" + this.o + ", anchorCreationId=" + this.p + ", douyinGid=" + this.q + ')';
    }

    public c(UserCreation r3, boolean r4, boolean r5, String r6, String r7, String r8, String r9, String r10, String r11, Integer r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        this.a = r3;
        this.b = null;
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
        this.o = r16;
        this.p = r17;
        this.q = r18;
    }
}
