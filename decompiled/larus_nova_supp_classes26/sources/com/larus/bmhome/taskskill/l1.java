package com.larus.bmhome.taskskill;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class l1 implements Function1 {
    public /* synthetic */ l1() {
    }

    public final Object invoke(Object r2) {
        String r3 = (String) r2;
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L7:
        return Boolean.valueOf(r4);
    L5:
        r4 = false;
        goto L7
    }
}
