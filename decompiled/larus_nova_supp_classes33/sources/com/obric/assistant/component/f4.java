package com.obric.assistant.component;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f4 implements Function1 {
    public final /* synthetic */ ObricSkillComponent a;

    public /* synthetic */ f4(ObricSkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        ObricSkillComponent r0 = this.a;
        ic8.w r6 = (ic8.w) r5;
        ObricSkillComponent.a r1 = ObricSkillComponent.A;
        Intrinsics.checkNotNullParameter(r6, "it");
        boolean r2 = false;
        if ((r6 instanceof ai8.f) == false) goto L33;
        r0.getClass();
        com.obric.assistant.t1 r7 = com.obric.assistant.t1.a;
        if (r7.r() == false) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == false) goto L33;
        if (com.obric.assistant.task.skill.f.d() == true) goto L29;
        com.larus.bmhome.instruction.g r9 = r0.vc();
        if (r9 == null) goto L22;
        ReplyOption r10 = r9.Ql();
        if (r10 == null) goto L22;
        ModelItemIdentity r11 = r10.getModel();
        if (r11 == null) goto L22;
        int r12 = r11.getDeprecatedItemId();
    L23:
        int r3 = wa8.b1.a;
        if (r12 == 0) goto L29;
        if (com.obric.assistant.task.skill.m.j(Integer.valueOf(r12)) == true) goto L29;
        boolean r13 = false;
    L30:
        if (r13 == false) goto L33;
        r2 = true;
    L22:
        int r14 = wa8.b1.a;
        r12 = 0;
    L29:
        r13 = true;
        goto L30
    L7:
        if (r7.o1() == true) goto L10;
        r8 = false;
    L33:
        return Boolean.valueOf(r2);
    }
}
