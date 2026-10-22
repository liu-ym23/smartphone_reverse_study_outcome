package com.obric.aiagent.messenger.stub;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class t0 implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public /* synthetic */ t0(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return Boolean.valueOf(MessageIDLStub.b(this.a, this.b, (Map.Entry) r3));
    }
}
