package com.obric.aiagent.assistant.idl;

import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class u0 implements Function1 {
    public /* synthetic */ u0() {
    }

    public final Object invoke(Object r2) {
        Map.Entry r3 = (Map.Entry) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (((WeakReference) r3.getValue()).get() != null) goto L5;
        boolean r4 = true;
    L7:
        return Boolean.valueOf(r4);
    L5:
        r4 = false;
        goto L7
    }
}
