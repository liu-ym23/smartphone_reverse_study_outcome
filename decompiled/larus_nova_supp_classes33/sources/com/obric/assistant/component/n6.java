package com.obric.assistant.component;

import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n6 implements Function1 {
    public final /* synthetic */ Set a;

    public /* synthetic */ n6(Set r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Set r0 = this.a;
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) r4;
        int r1 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter(r5, "it");
        Integer r2 = r5.g;
        int r3 = ActionBarExecutionType.OBRIC_ACTION.getValue();
        if (r2 == null) goto L8;
        if (r2.intValue() != r3) goto L8;
    L10:
        boolean r6 = false;
    L12:
        return Boolean.valueOf(r6);
    L8:
        if (CollectionsKt.contains(r0, r5.b) == true) goto L10;
        r6 = true;
        goto L12
    }
}
