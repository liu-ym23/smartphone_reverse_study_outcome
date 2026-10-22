package com.larus.bmhome.chat.component.bottom.voice.service;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService", f = "VoiceMixInputService.kt", i = {0}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_TIMEOUT}, m = "configTextStream", n = {"textContext"}, s = {"L$0"})
final class VoiceMixInputService$configTextStream$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceMixInputService this$0;

    public VoiceMixInputService$configTextStream$1(VoiceMixInputService r1, Continuation<? super VoiceMixInputService$configTextStream$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return VoiceMixInputService.a(this.this$0, null, false, this);
    }
}
