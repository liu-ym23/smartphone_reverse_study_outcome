package com.larus.bmhome.taskskill;

import ic8.w;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class w0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ w0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        w r4 = (w) r3;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r4, "strategy");
        Set<String> r2 = h2.a;
        if (h2.d(r4.a()) == false) goto L5;
    L7:
        boolean r5 = false;
    L9:
        return Boolean.valueOf(r5);
    L5:
        if (SkillComponent.D3(r0) == null) goto L7;
        r5 = true;
        goto L9
    }
}
