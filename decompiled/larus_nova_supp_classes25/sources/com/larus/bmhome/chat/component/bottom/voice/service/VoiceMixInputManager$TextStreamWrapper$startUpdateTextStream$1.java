package com.larus.bmhome.chat.component.bottom.voice.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputManager$TextStreamWrapper", f = "VoiceMixInputManager.kt", i = {}, l = {291}, m = "startUpdateTextStream", n = {}, s = {})
public final class VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceMixInputManager.TextStreamWrapper this$0;

    public VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1(VoiceMixInputManager.TextStreamWrapper r1, Continuation<? super VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
