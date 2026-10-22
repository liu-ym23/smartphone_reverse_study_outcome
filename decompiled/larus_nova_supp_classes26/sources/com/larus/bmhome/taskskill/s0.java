package com.larus.bmhome.taskskill;

import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class s0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ s0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        c2 r4 = SkillComponent.D3(r0);
        if (r4 == null) goto L7;
        Integer r5 = r4.c;
        if (r5 == null) goto L7;
        return r5.toString();
    L7:
        return null;
    }
}
