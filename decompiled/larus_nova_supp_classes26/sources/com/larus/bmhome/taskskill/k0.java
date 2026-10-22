package com.larus.bmhome.taskskill;

import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ k0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        return r0.w5();
    }
}
