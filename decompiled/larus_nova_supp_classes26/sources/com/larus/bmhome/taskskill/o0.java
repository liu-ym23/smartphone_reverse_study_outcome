package com.larus.bmhome.taskskill;

import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class o0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ o0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        be8.e r4 = r0.getSelectedFolder();
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.b;
    }
}
