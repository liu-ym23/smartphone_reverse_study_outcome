package com.larus.bmhome.taskskill;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f1 implements Function1 {
    public /* synthetic */ f1() {
    }

    public final Object invoke(Object r2) {
        ouc.e r3 = (ouc.e) r2;
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "$this$Json");
        r3.a = true;
        return Unit.INSTANCE;
    }
}
