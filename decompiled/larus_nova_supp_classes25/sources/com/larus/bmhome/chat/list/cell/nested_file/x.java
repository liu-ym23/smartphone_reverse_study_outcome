package com.larus.bmhome.chat.list.cell.nested_file;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x implements Function0 {
    public final /* synthetic */ NewNestedFileCell a;

    public /* synthetic */ x(NewNestedFileCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        NewNestedFileCell r0 = this.a;
        int r1 = NewNestedFileCell.s;
        com.larus.bmhome.instruction.g r2 = (com.larus.bmhome.instruction.g) r0.j.getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.N8();
    }
}
