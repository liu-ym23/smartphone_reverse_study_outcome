package com.larus.bmhome.taskskill;

import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d1 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ d1(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        boolean r2 = false;
        if (r0.yW() == false) goto L14;
        String r4 = r0.G1;
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L14;
        r2 = true;
        goto L14
    L7:
        if (StringsKt.isBlank(r4) == true) goto L10;
        r5 = false;
    L14:
        return Boolean.valueOf(r2);
    }
}
