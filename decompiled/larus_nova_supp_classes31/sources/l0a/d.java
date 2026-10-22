package l0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final boolean a;
    public final boolean b;
    public final UserCreation c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        UserCreation r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L13;
        int r6 = 0;
    L14:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r7 + r9) * 31;
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
        if (r26 == null) goto L43;
        r5 = r26.hashCode();
    L43:
        return r25 + r5;
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
    L17:
        r9 = r8.hashCode();
        goto L18
    L13:
        r6 = r4.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MobLikeActionParamsKmp(currentlyLiked=" + this.a + ", doubleTap=" + this.b + ", creation=" + this.c + ", botId=" + this.d + ", aiCreationRecommendFrom=" + this.e + ", currentPage=" + this.f + ", previousPage=" + this.g + ", chatType=" + this.h + ", conversationId=" + this.i + ", templateShowEnterMethod=" + this.j + ')';
    }

    public d(boolean r1, UserCreation r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        this.a = r1;
        this.b = false;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }
}
