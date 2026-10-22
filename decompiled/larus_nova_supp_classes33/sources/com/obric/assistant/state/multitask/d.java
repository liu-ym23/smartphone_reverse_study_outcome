package com.obric.assistant.state.multitask;

import jha.q;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ q c;

    public /* synthetic */ d(String r1, long r2, q r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final Object invoke() {
        String r0 = this.a;
        long r4 = this.b;
        q r6 = this.c;
        return new a("TaskFlowManager", new a.C0026a("dispatchTaskStateEvent", r0), r4, r6);
    }
}
