package com.larus.bmhome.taskskill;

import ic8.n;
import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class j0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ j0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        com.larus.bmhome.chat.component.cvs.y r4 = r0.d4();
        if (r4 == null) goto L5;
        wc9.e r5 = r4.h();
    L6:
        if (r5 != null) goto L8;
    L11:
        boolean r6 = false;
    L13:
        return Boolean.valueOf(r6);
    L8:
        if (n.r(r5) == false) goto L11;
        r6 = r0.B4(r5);
        goto L13
    L5:
        r5 = null;
        goto L6
    }
}
