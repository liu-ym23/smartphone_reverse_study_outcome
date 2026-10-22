package com.larus.bmhome.taskskill;

import com.larus.connector.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class o1 implements Function1 {
    public /* synthetic */ o1() {
    }

    public final Object invoke(Object r2) {
        n r3 = (n) r2;
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.b;
    }
}
