package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod", f = "DoraBudsTxSyncMethod.kt", i = {}, l = {116}, m = "executeTxSync", n = {}, s = {})
final class DoraBudsTxSyncMethod$executeTxSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBudsTxSyncMethod this$0;

    public DoraBudsTxSyncMethod$executeTxSync$1(DoraBudsTxSyncMethod r1, Continuation<? super DoraBudsTxSyncMethod$executeTxSync$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return DoraBudsTxSyncMethod.a(this.this$0, 0, 0, 0, null, this);
    }
}
