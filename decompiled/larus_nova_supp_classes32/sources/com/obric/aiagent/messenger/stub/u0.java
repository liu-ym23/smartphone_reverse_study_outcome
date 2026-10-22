package com.obric.aiagent.messenger.stub;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class u0 implements Function1 {
    public final /* synthetic */ Map a;

    public /* synthetic */ u0(Map r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return MessageIDLStub.f(this.a, (String) r2);
    }
}
