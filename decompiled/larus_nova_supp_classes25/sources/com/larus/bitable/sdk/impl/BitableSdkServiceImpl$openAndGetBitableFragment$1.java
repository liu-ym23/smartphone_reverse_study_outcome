package com.larus.bitable.sdk.impl;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bitable.sdk.impl.BitableSdkServiceImpl", f = "BitableSdkServiceImpl.kt", i = {0, 0, 0, 0}, l = {117}, m = "openAndGetBitableFragment", n = {"inputParam", "listener", "hostAbilityProvider", "reloadInterceptor"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class BitableSdkServiceImpl$openAndGetBitableFragment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitableSdkServiceImpl this$0;

    public BitableSdkServiceImpl$openAndGetBitableFragment$1(BitableSdkServiceImpl r1, Continuation<? super BitableSdkServiceImpl$openAndGetBitableFragment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(null, null, null, null, this);
    }
}
