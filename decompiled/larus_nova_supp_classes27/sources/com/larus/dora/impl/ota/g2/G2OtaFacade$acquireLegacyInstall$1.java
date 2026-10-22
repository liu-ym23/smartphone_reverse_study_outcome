package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaFacade", f = "G2OtaFacade.kt", i = {0, 0, 1, 1, 1}, l = {1757, 506}, m = "acquireLegacyInstall", n = {"device", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "requestId", "key"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class G2OtaFacade$acquireLegacyInstall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ G2OtaFacade this$0;

    public G2OtaFacade$acquireLegacyInstall$1(G2OtaFacade r1, Continuation<? super G2OtaFacade$acquireLegacyInstall$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
