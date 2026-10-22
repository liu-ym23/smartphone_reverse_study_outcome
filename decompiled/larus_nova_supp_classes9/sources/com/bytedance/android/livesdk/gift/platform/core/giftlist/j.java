package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.b3;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.model.z2;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public final int a;
    public final String b;
    public final boolean c;
    public final String d;
    public final py.k e;
    public final py.k f;
    public final py.k g;
    public final List<s> h;
    public final x2 i;
    public final b3 j;
    public final z2 k;
    public List<Long> l;
    public final List<c1> m;
    public final List<d2> n;
    public final int o;
    public final List<o2> p;
    public final Map<Integer, Long> q;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L40;
        j r4 = (j) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
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
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (this.o == r4.o) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v57 */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.c;
        ?? r6 = r5;
        if (r5 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        py.k r11 = this.e;
        if (r11 == null) goto L16;
        int r13 = r11.hashCode();
    L17:
        int r14 = (r10 + r13) * 31;
        py.k r15 = this.f;
        if (r15 == null) goto L20;
        int r16 = r15.hashCode();
    L21:
        int r17 = (r14 + r16) * 31;
        py.k r18 = this.g;
        if (r18 == null) goto L24;
        int r19 = r18.hashCode();
    L25:
        int r20 = (r17 + r19) * 31;
        List<s> r21 = this.h;
        if (r21 == null) goto L28;
        int r23 = r21.hashCode();
    L29:
        int r24 = (r20 + r23) * 31;
        x2 r25 = this.i;
        if (r25 == null) goto L32;
        int r26 = r25.hashCode();
    L33:
        int r27 = (r24 + r26) * 31;
        b3 r28 = this.j;
        if (r28 == null) goto L36;
        int r29 = r28.hashCode();
    L37:
        int r30 = (r27 + r29) * 31;
        z2 r31 = this.k;
        if (r31 == null) goto L40;
        int r33 = r31.hashCode();
    L41:
        int r34 = (r30 + r33) * 31;
        List<Long> r35 = this.l;
        if (r35 == null) goto L44;
        int r36 = r35.hashCode();
    L45:
        int r37 = (r34 + r36) * 31;
        List<c1> r38 = this.m;
        if (r38 == null) goto L48;
        int r39 = r38.hashCode();
    L49:
        int r40 = (r37 + r39) * 31;
        List<d2> r41 = this.n;
        if (r41 == null) goto L52;
        int r43 = r41.hashCode();
    L53:
        int r44 = (((r40 + r43) * 31) + this.o) * 31;
        List<o2> r45 = this.p;
        if (r45 == null) goto L56;
        int r46 = r45.hashCode();
    L57:
        int r47 = (r44 + r46) * 31;
        Map<Integer, Long> r48 = this.q;
        if (r48 == null) goto L61;
        r2 = r48.hashCode();
    L61:
        return r47 + r2;
    L56:
        r46 = 0;
        goto L57
    L52:
        r43 = 0;
        goto L53
    L48:
        r39 = 0;
        goto L49
    L44:
        r36 = 0;
        goto L45
    L40:
        r33 = 0;
        goto L41
    L36:
        r29 = 0;
        goto L37
    L32:
        r26 = 0;
        goto L33
    L28:
        r23 = 0;
        goto L29
    L24:
        r19 = 0;
        goto L25
    L20:
        r16 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "PageModel(pageType=" + this.a + ", pageName=" + this.b + ", display=" + this.c + ", eventName=" + this.d + ", backgroundImage=" + this.e + ", receiversModBg=" + this.f + ", receiversLongModBg=" + this.g + ", sectionList=" + this.h + ", pageInfo=" + this.i + ", pageNameStyleInfo=" + this.j + ", lynxConfig=" + this.k + ", gifts=" + this.l + ", baseGifts=" + this.m + ", topicList=" + this.n + ", sortStrategy=" + this.o + ", scrollPageNames=" + this.p + ", forceInsertMap=" + this.q + ")";
    }

    public final boolean a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(int r6, String r7, boolean r8, String r9, py.k r10, py.k r11, py.k r13, List<s> r14, x2 r15, b3 r16, z2 r17, List<Long> r18, List<? extends c1> r19, List<? extends d2> r110, int r20, List<? extends o2> r21, Map<Integer, Long> r23) {
        Intrinsics.checkNotNullParameter(r7, "pageName");
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r18, "gifts");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r110;
        this.o = r20;
        this.p = r21;
        this.q = r23;
    }
}
