package com.larus.bmhome.taskskill;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k1 implements Function1 {
    public /* synthetic */ k1() {
    }

    public final Object invoke(Object r2) {
        String r3 = (String) r2;
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return StringsKt.trim(r3).toString();
    }
}
