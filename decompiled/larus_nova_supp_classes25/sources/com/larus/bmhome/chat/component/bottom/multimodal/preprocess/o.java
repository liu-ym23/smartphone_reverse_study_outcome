package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ List b;

    public /* synthetic */ o(long r1, List r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r5) {
        long r0 = this.a;
        List r2 = this.b;
        Map.Entry r6 = (Map.Entry) r5;
        Intrinsics.checkNotNullParameter(r6, "<destruct>");
        p$a r7 = (p$a) r6.getValue();
        p.a.getClass();
        if (p.j(r7, r0, r2) != null) goto L5;
        boolean r8 = true;
    L7:
        return Boolean.valueOf(r8);
    L5:
        r8 = false;
        goto L7
    }
}
