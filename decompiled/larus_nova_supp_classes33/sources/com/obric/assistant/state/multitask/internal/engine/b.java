package com.obric.assistant.state.multitask.internal.engine;

import jha.q;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ q d;

    public /* synthetic */ b(Ref.BooleanRef r1, Ref.ObjectRef r2, Long r3, q r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        Ref.BooleanRef r0 = this.a;
        Ref.ObjectRef r1 = this.b;
        Long r2 = this.c;
        q r8 = this.d;
        if (r0.element == false) goto L5;
        String r3 = String.valueOf(r1.element);
    L6:
        com.obric.assistant.state.multitask.a.C0026a r5 = new com.obric.assistant.state.multitask.a.C0026a("interceptor", r3);
        if (r2 == null) goto L9;
        long r4 = r2.longValue();
    L11:
        return new com.obric.assistant.state.multitask.a("TaskFlowPolicyEngine", r5, r4, r8);
    L9:
        r4 = 0;
        goto L11
    L5:
        r3 = "allow";
        goto L6
    }
}
