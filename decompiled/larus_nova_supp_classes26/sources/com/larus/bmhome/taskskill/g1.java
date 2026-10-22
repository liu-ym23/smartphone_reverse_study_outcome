package com.larus.bmhome.taskskill;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g1 implements Function1 {
    public /* synthetic */ g1() {
    }

    public final Object invoke(Object r2) {
        MatchResult r3 = (MatchResult) r2;
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (String) ListProtector.get(r3.getGroupValues(), 1);
    }
}
