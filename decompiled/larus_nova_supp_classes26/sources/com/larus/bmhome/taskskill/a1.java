package com.larus.bmhome.taskskill;

import ic8.w;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a1 implements Function1 {
    public /* synthetic */ a1() {
    }

    public final Object invoke(Object r2) {
        w r3 = (w) r2;
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Set<String> r1 = h2.a;
        return Boolean.valueOf(!h2.d(r3.a()));
    }
}
