package com.obric.aiagent.messenger.stub;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class o0 implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ o0(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return Boolean.valueOf(MessageIDLStub.c(this.a, (MessageIDLStub$b) r2));
    }
}
