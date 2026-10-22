package com.obric.assistant.dora;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ IDoraPrivateProtocolCallback a;

    public /* synthetic */ f(IDoraPrivateProtocolCallback r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        IDoraPrivateProtocolCallback r0 = this.a;
        int r1 = DoraPrivateProtocolService.e;
        return Boolean.valueOf(Intrinsics.areEqual(((DoraPrivateProtocolService.a) r3).a.asBinder(), r0.asBinder()));
    }
}
