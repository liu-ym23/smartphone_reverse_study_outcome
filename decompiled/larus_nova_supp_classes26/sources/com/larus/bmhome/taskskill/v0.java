package com.larus.bmhome.taskskill;

import ic8.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class v0 implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ v0(f0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function0 r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        return Boolean.valueOf(((Boolean) r0.invoke()).booleanValue());
    }
}
