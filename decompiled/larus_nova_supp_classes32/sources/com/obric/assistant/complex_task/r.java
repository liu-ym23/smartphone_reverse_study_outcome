package com.obric.assistant.complex_task;

import kl9.u;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ r(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return Boolean.valueOf(MultiComplexTaskManager.dmStateListener.1.a(this.a, (u) r2));
    }
}
