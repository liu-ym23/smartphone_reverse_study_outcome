package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaEngine", f = "G2OtaEngine.kt", i = {0, 0, 0}, l = {208}, m = "persist", n = {"state", "reason", "persisted"}, s = {"L$0", "L$1", "Z$0"})
final class G2OtaEngine$persist$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ G2OtaEngine this$0;

    public G2OtaEngine$persist$1(G2OtaEngine r1, Continuation<? super G2OtaEngine$persist$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return G2OtaEngine.i(this.this$0, null, null, this);
    }
}
