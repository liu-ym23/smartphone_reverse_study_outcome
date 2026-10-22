package com.larus.dora.impl.ota.g2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ AndroidG2OtaRuntime a;
    public final /* synthetic */ q.c b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ a(AndroidG2OtaRuntime r1, q.c r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        AndroidG2OtaRuntime r0 = this.a;
        q.c r1 = this.b;
        Function1 r5 = this.c;
        r0.l(r1.a(), r1.d(), r1.c(), r5);
        return Unit.INSTANCE;
    }
}
