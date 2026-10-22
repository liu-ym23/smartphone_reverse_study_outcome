package com.larus.bmhome.taskskill;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h1 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ h1(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        List r4 = (List) r3;
        Regex r1 = SkillComponent.F2;
        r0.V3();
        if (r0.k4() == true) goto L6;
        r0.f5(r0.Z3());
    L6:
        if (r0.k4() == false) goto L14;
        if (r0.yW() == false) goto L14;
        if (SkillComponent.Q5(r0, r4, 2) == false) goto L14;
        r0.f5(r0.Z3());
        r0.V5(r0.sY());
        r0.W3();
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    }
}
