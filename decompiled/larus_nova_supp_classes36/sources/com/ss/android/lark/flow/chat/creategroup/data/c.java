package com.ss.android.lark.flow.chat.creategroup.data;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Comparator {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r9, Object r10) {
        a r11 = (a) r9;
        a r12 = (a) r10;
        int r0 = d.a;
        String r1 = d.c(r11.e);
        String r2 = d.c(r12.e);
        boolean r3 = Intrinsics.areEqual(r1, "#");
        if ((Intrinsics.areEqual(r2, "#") ^ r3) == false) goto L8;
        if (r3 == false) goto L6;
        return 1;
    L6:
        return -1;
    L8:
        if (Intrinsics.areEqual(r1, r2) == false) goto L29;
        String r13 = r11.e;
        String r14 = r12.e;
        int r4 = r13.length();
        int r5 = r14.length();
        int r6 = Math.min(r4, r5);
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L19;
        char r8 = Character.toLowerCase(r13.charAt(r7));
        char r15 = Character.toLowerCase(r14.charAt(r7));
        if (r8 == r15) goto L17;
        int r16 = d.a;
        int r17 = d.b(r8);
        int r18 = d.b(r15);
        if (r17 == r18) goto L17;
        return -(r17 - r18);
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
