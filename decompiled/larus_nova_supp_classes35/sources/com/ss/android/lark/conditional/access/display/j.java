package com.ss.android.lark.conditional.access.display;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.b0;
import v7b.n;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements com.ss.android.lark.coremd.base.parse.f {
    public j() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public static void c(s r1, List r2) {
        if ((r1 instanceof n) == false) goto L6;
        return;
    L6:
        if ((r1 instanceof b0) == false) goto L9;
        ((ArrayList) r2).add(r1);
        return;
    L9:
        s r3 = r1.e;
    L10:
        if (r3 == null) goto L12;
        c(r3, r2);
        r3 = r3.h;
        goto L10
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(s r1, Spannable r2) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r13, s r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "node");
        ArrayList r15 = new ArrayList();
        c(r14, r15);
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L48;
        b0 r17 = (b0) r16.next();
        String r0 = r17.j;
        Matcher r1 = k.a.matcher(r0);
        b0 r5 = r17;
        boolean r3 = false;
        int r4 = 0;
    L7:
        if (r1.find() == false) goto L42;
        Intrinsics.checkNotNull(r0);
        int r6 = r1.start();
        int r7 = r1.end();
    L10:
        if (r7 <= r6) goto L29;
        int r9 = r7 - 1;
        char r10 = r0.charAt(r9);
        if (r10 == ')') goto L24;
        if (r10 != ',') goto L16;
    L25:
        boolean r11 = true;
    L27:
        if (r11 == false) goto L29;
        r7 = r9;
        goto L10
    L16:
        if (r10 == '.') goto L25;
        if (r10 == ']') goto L21;
    L26:
        r11 = false;
        goto L27
    L21:
        if (e(r0, r6, r7, ']') <= e(r0, r6, r7, '[')) goto L26;
    L24:
        if (e(r0, r6, r7, ')') <= e(r0, r6, r7, '(')) goto L26;
    L29:
        String r8 = r0.substring(r1.start(), r7);
        if (StringsKt.equals(r8, "http://", true) == false) goto L32;
    L35:
        boolean r12 = true;
    L36:
        if (r12 == true) goto L7;
        if (r1.start() <= r4) goto L41;
        b0 r18 = new b0(r0.substring(r4, r1.start()));
        r5.k(r18);
        r5 = r18;
    L41:
        n r19 = new n(r8, r8);
        r5.k(r19);
        r5 = r19;
        r4 = r7;
        r3 = true;
        goto L7
    L32:
        if (StringsKt.equals(r8, "https://", true) == true) goto L35;
        r12 = false;
        goto L36
    L42:
        if (r3 == false) goto L4;
        if (r4 >= r0.length()) goto L47;
        Intrinsics.checkNotNull(r0);
        r5.k(new b0(r0.substring(r4)));
    L47:
        r17.p();
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(com.ss.android.lark.coremd.impl.parse.d r2, SpannableStringBuilder r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "charSequence");
    }

    public static int e(String r2, int r3, int r4, char r5) {
        int r0 = 0;
    L3:
        if (r3 >= r4) goto L8;
        if (r2.charAt(r3) != r5) goto L7;
        r0 = r0 + 1;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r0;
    }
}
