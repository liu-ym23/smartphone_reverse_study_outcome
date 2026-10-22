package be8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final int g;
    public final String h;
    public final String i;
    public final Long j;
    public final boolean k;
    public final Integer l;
    public final Integer m;

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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r5 = 1231;
        if (this.f == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((r4 + r6) * 31) + this.g) * 31;
        String r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.j;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.k == true) goto L26;
        r5 = 1237;
    L26:
        int r17 = (r16 + r5) * 31;
        Integer r18 = this.l;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.m;
        if (r21 == null) goto L35;
        r2 = r21.hashCode();
    L35:
        return r20 + r2;
    L29:
        r19 = r18.hashCode();
        goto L30
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
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SkillAbilitySkill(skillId=" + this.a + ", name=" + this.b + ", externalSkillId=" + this.c + ", description=" + this.d + ", iconUrl=" + this.e + ", recommend=" + this.f + ", type=" + this.g + ", path=" + this.h + ", categoryName=" + this.i + ", lastUsedAtMs=" + this.j + ", isSuggestionRecommended=" + this.k + ", suggestionPosition=" + this.l + ", suggestionSkillsLimit=" + this.m + ')';
    }

    public final int getType() {
        return this.g;
    }

    public b(String r2, String r3, String r4, String r5, String r6, boolean r7, int r8, String r9, String r10, Long r11, boolean r12, Integer r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r2, "skillId");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r5, "description");
        Intrinsics.checkNotNullParameter(r6, "iconUrl");
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
    }
}
