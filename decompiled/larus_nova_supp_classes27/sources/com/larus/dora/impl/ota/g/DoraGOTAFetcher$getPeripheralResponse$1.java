package com.larus.dora.impl.ota.g;

import com.larus.dora.impl.core.DoraLinkServiceStopReason;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAFetcher", f = "DoraGOTAFetcher.kt", i = {1}, l = {DoraLinkServiceStopReason.DEVICE_IS_EMPTY, 49}, m = "getPeripheralResponse", n = {"convertor$iv"}, s = {"L$0"})
public final class DoraGOTAFetcher$getPeripheralResponse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAFetcher this$0;

    public DoraGOTAFetcher$getPeripheralResponse$1(DoraGOTAFetcher r1, Continuation<? super DoraGOTAFetcher$getPeripheralResponse$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
