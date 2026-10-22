package com.larus.bmhome.taskskill;

import ic8.w;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class y0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ y0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        w r4 = (w) r3;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r4, "strategy");
        Set<String> r2 = h2.a;
        if (h2.d(r4.a()) == true) goto L7;
        boolean r5 = r0.z5().isEmpty();
        boolean r6 = true;
        if ((!r5) == false) goto L7;
    L9:
        return Boolean.valueOf(r6);
    L7:
        r6 = false;
        goto L9
    }
}
