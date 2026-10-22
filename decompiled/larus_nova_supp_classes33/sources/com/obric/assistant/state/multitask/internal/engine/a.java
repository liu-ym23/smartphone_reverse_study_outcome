package com.obric.assistant.state.multitask.internal.engine;

import jha.q;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ q d;

    public /* synthetic */ a(String r1, String r2, Long r3, q r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        Long r2 = this.c;
        q r8 = this.d;
        com.obric.assistant.state.multitask.a.C0026a r5 = new com.obric.assistant.state.multitask.a.C0026a(r0, r1);
        if (r2 == null) goto L5;
        long r3 = r2.longValue();
    L7:
        return new com.obric.assistant.state.multitask.a("TaskFlowEventBus", r5, r3, r8);
    L5:
        r3 = 0;
        goto L7
    }
}
