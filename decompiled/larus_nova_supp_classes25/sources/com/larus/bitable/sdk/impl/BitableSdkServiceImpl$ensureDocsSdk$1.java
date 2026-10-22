package com.larus.bitable.sdk.impl;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bitable.sdk.impl.BitableSdkServiceImpl", f = "BitableSdkServiceImpl.kt", i = {}, l = {206}, m = "ensureDocsSdk", n = {}, s = {})
public final class BitableSdkServiceImpl$ensureDocsSdk$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitableSdkServiceImpl this$0;

    public BitableSdkServiceImpl$ensureDocsSdk$1(BitableSdkServiceImpl r1, Continuation<? super BitableSdkServiceImpl$ensureDocsSdk$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        BitableSdkServiceImpl r3 = this.this$0;
        int r0 = BitableSdkServiceImpl.c;
        return r3.X(this);
    }
}
