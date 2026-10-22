package com.larus.bmhome.taskskill;

import ic8.w;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class x0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ x0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        Set<String> r4 = h2.a;
        return h2.a(r0.z5());
    }
}
