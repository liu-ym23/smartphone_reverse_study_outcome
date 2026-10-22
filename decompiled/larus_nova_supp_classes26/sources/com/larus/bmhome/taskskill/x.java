package com.larus.bmhome.taskskill;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class x implements Function2 {
    public /* synthetic */ x() {
    }

    public final Object invoke(Object r4, Object r5) {
        wc9.e r6 = (wc9.e) r4;
        wc9.e r7 = (wc9.e) r5;
        Regex r0 = SkillComponent.F2;
        String r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.a;
    L6:
        if (r7 == null) goto L8;
        String r3 = r7.a;
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L27;
        if (r6 == null) goto L13;
        String r8 = r6.r;
    L14:
        if (r7 == null) goto L16;
        String r9 = r7.r;
    L18:
        if (Intrinsics.areEqual(r8, r9) == false) goto L27;
        if (r6 == null) goto L21;
        String r10 = r6.I;
    L22:
        if (r7 == null) goto L25;
        r1 = r7.I;
    L25:
        if (Intrinsics.areEqual(r10, r1) == false) goto L27;
        boolean r11 = true;
    L29:
        return Boolean.valueOf(r11);
    L21:
        r10 = null;
        goto L22
    L16:
        r9 = null;
        goto L18
    L13:
        r8 = null;
    L27:
        r11 = false;
        goto L29
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
