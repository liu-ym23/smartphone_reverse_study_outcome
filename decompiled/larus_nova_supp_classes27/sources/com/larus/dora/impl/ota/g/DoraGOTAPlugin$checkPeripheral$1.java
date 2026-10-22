package com.larus.dora.impl.ota.g;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin", f = "DoraGOTAPlugin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {126, 184}, m = "checkPeripheral", n = {"responseWrapper", "packageInfo", "maxAttemptCount", "attempt", "responseWrapper", "packageInfo", "maxAttemptCount", "attempt"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
public final class DoraGOTAPlugin$checkPeripheral$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAPlugin this$0;

    public DoraGOTAPlugin$checkPeripheral$1(DoraGOTAPlugin r1, Continuation<? super DoraGOTAPlugin$checkPeripheral$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraGOTAPlugin r3 = this.this$0;
        int r0 = DoraGOTAPlugin.c;
        return r3.e(null, this);
    }
}
