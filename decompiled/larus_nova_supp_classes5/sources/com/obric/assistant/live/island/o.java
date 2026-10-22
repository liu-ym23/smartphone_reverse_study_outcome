package com.obric.assistant.live.island;

import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class o implements Function1 {
    public /* synthetic */ o() {
    }

    public final Object invoke(Object r2) {
        DMTaskState r3 = (DMTaskState) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.getTaskId();
    }
}
