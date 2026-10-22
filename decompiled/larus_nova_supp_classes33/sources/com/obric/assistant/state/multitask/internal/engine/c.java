package com.obric.assistant.state.multitask.internal.engine;

import jha.q;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ q d;

    public /* synthetic */ c(String r1, String r2, long r3, q r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        long r5 = this.c;
        q r7 = this.d;
        return new com.obric.assistant.state.multitask.a("TaskFlowPolicyEngine", new com.obric.assistant.state.multitask.a.C0026a(r0, r1), r5, r7);
    }
}
