package com.obric.assistant.component;

import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class s6 implements Function1 {
    public final /* synthetic */ List a;

    public /* synthetic */ s6(List r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        List r0 = this.a;
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) r4;
        int r1 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter(r5, "it");
        String r2 = r5.b;
        Integer r6 = r5.g;
        int r3 = ActionBarExecutionType.OBRIC_ACTION.getValue();
        if (r6 != null) goto L6;
    L7:
        List r7 = r0;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L12;
        r8.add(((qha.e) r9.next()).k());
        goto L9
    L12:
        if (CollectionsKt.contains(CollectionsKt.toSet(r8), r2) == true) goto L14;
        boolean r10 = true;
    L16:
        return Boolean.valueOf(r10);
    L14:
        r10 = false;
        goto L16
    L6:
        if (r6.intValue() == r3) goto L14;
        goto L7
    }
}
