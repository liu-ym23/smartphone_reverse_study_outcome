package com.larus.bmhome.taskskill;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f0 implements Function0 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ f0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        boolean r2 = false;
        if (l2.c() == false) goto L18;
        if (r0.yW() == false) goto L18;
        if (Intrinsics.areEqual(r0.p1.getValue(), Boolean.TRUE) == false) goto L18;
        String r3 = r0.w5();
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L18;
        r2 = true;
        goto L18
    L11:
        if (StringsKt.isBlank(r3) == true) goto L14;
        r4 = false;
    L18:
        return Boolean.valueOf(r2);
    }
}
