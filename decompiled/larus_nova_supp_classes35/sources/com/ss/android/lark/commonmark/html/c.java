package com.ss.android.lark.commonmark.html;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.l;
import v7b.n;
import v7b.s;
import w7b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements e {
    public final boolean a;

    public c(boolean r1) {
        this.a = r1;
    }

    @Override // w7b.e
    public final s a(s r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        c(r2, this.a);
        return r2;
    }

    public static void b(s r1, StringBuilder r2) {
        if ((r1 instanceof b0) == false) goto L6;
        r2.append(((b0) r1).j);
        return;
    L6:
        s r3 = r1.e;
    L7:
        if (r3 == null) goto L9;
        s r0 = r3.h;
        b(r3, r2);
        r3 = r0;
        goto L7
    }

    public static void c(s r3, boolean r4) {
        if (r4 == false) goto L36;
        boolean r1 = true;
        if ((r3 instanceof l) == false) goto L20;
        l r5 = (l) r3;
        String r0 = r5.k;
        if (r0 != null) goto L8;
    L11:
        if (r1 == false) goto L16;
        StringBuilder r2 = new StringBuilder();
        s r6 = r3.e;
    L13:
        if (r6 == null) goto L15;
        b(r6, r2);
        r6 = r6.h;
        goto L13
    L15:
        r5.k = r2.toString();
    L16:
        s r7 = r3.e;
    L17:
        if (r7 == null) goto L70;
        s r8 = r7.h;
        r7.p();
        r7 = r8;
        goto L17
    L70:
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L11
    L20:
        if ((r3 instanceof n) == false) goto L32;
        n r9 = (n) r3;
        String r10 = r9.k;
        if (r10 != null) goto L24;
    L27:
        if (r1 == false) goto L35;
        StringBuilder r11 = new StringBuilder();
        s r12 = r3.e;
    L29:
        if (r12 == null) goto L31;
        b(r12, r11);
        r12 = r12.h;
        goto L29
    L31:
        r9.k = r11.toString();
        return;
    L35:
        return;
    L24:
        if (r10.length() == 0) goto L27;
        r1 = false;
        goto L27
    L32:
        s r13 = r3.e;
    L33:
        if (r13 == null) goto L71;
        c(r13, r4);
        r13 = r13.h;
        goto L33
    L71:
        return;
    L36:
        boolean r14 = r3 instanceof l;
        String r15 = BuildConfig.FLAVOR;
        if (r14 == false) goto L46;
        l r16 = (l) r3;
        s r17 = r3.e;
    L39:
        if (r17 == null) goto L44;
        if ((r17 instanceof b0) == false) goto L43;
        r15 = ((b0) r17).j;
    L43:
        r17.p();
        r17 = r3.e;
        goto L39
    L44:
        r16.k = r15;
        return;
    L46:
        if ((r3 instanceof n) == false) goto L54;
        n r18 = (n) r3;
        s r19 = r3.e;
    L48:
        if (r19 == null) goto L53;
        if ((r19 instanceof b0) == false) goto L52;
        r15 = ((b0) r19).j;
    L52:
        r19.p();
        r19 = r3.e;
        goto L48
    L53:
        r18.k = r15;
        return;
    L54:
        s r20 = r3.e;
    L55:
        if (r20 == null) goto L73;
        c(r20, r4);
        r20 = r20.h;
        goto L55
    }
}
