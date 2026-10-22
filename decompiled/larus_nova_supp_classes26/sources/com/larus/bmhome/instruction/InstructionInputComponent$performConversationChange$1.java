package com.larus.bmhome.instruction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent", f = "InstructionInputComponent.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1295, 1546}, m = "performConversationChange", n = {"currentConversation", "bot", "chartParam", "startTime", "usePreloadBot", "currentConversation", "bot", "chartParam", "initInstructionType", "initActionBarItemId", "initInstructionDefaultParams", "creationId", "creationType", "prompt", "onSendParams", "messageExtMap", "it", "autoSend", "instructionBarShowLeftButton"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "Z$0"})
final class InstructionInputComponent$performConversationChange$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$performConversationChange$1(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$performConversationChange$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return InstructionInputComponent.h3(this.this$0, null, null, this);
    }
}
