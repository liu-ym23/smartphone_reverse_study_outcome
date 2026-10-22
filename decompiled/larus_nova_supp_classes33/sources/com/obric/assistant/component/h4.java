package com.obric.assistant.component;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h4 implements Function1 {
    public final /* synthetic */ ObricSkillComponent a;

    public /* synthetic */ h4(ObricSkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ObricSkillComponent r0 = this.a;
        com.larus.bmhome.actionbar.model.b2 r4 = (com.larus.bmhome.actionbar.model.b2) r3;
        ObricSkillComponent.a r1 = ObricSkillComponent.A;
        Intrinsics.checkNotNullParameter(r4, "it");
        ModelItemIdentity r5 = r4.b();
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.getDeprecatedItemId());
    L6:
        r0.getClass();
        return Boolean.valueOf(com.obric.assistant.task.skill.m.j(r6));
    L5:
        r6 = null;
        goto L6
    }
}
