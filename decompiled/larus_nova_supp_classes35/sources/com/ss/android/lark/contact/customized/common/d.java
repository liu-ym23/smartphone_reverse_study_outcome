package com.ss.android.lark.contact.customized.common;

import java.util.Comparator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements Comparator {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r8, Object r9) {
        mtb.d r10 = (mtb.d) r8;
        mtb.d r11 = (mtb.d) r9;
        Lazy r0 = OfficeContactUtils.a;
        String r1 = OfficeContactUtils.c(r10.f);
        String r2 = OfficeContactUtils.c(r11.f);
        boolean r3 = Intrinsics.areEqual(r1, "#");
        if ((Intrinsics.areEqual(r2, "#") ^ r3) == false) goto L8;
        if (r3 == false) goto L6;
        return 1;
    L6:
        return -1;
    L8:
        if (Intrinsics.areEqual(r1, r2) == false) goto L29;
        String r12 = r10.f;
        String r13 = r11.f;
        int r4 = r12.length();
        int r5 = r13.length();
        int r6 = Math.min(r4, r5);
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L19;
        char r14 = Character.toLowerCase(r12.charAt(r7));
        char r15 = Character.toLowerCase(r13.charAt(r7));
        if (r14 == r15) goto L17;
        int r16 = OfficeContactUtils.b(r14);
        int r17 = OfficeContactUtils.b(r15);
        if (r16 == r17) goto L17;
        return -(r16 - r17);
    L17:
        r7 = r7 + 1;
        goto L11
    L19:
        if (r4 != r5) goto L22;
        return 0;
    L22:
        return r4 - r5;
    L29:
        return r1.charAt(0) - r2.charAt(0);
    }
}
