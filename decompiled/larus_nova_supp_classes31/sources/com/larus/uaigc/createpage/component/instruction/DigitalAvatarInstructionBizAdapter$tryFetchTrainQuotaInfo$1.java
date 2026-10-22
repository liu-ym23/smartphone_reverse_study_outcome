package com.larus.uaigc.createpage.component.instruction;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {342}, m = "tryFetchTrainQuotaInfo", n = {}, s = {})
final class DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

    public DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1(DigitalAvatarInstructionBizAdapter r1, Continuation<? super DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DigitalAvatarInstructionBizAdapter.H(this.this$0, this);
    }
}
