package com.larus.video.impl.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements Function1<Throwable, Unit> {
    public final /* synthetic */ String a;

    public p(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Throwable r3 = (Throwable) r2;
        TTVideoEngineStaticServiceImpl.b.remove(this.a);
        return Unit.INSTANCE;
    }
}
