package com.larus.profile.impl.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility", f = "CreationImageEditAbility.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {350, 351}, m = "buildImageRemoveSendMessageConfig", n = {"mainBotId", "upScreenText", "instructionParamMap", "hitPointData", "targetCvsId", "actionInstruction", "mainBotId", "upScreenText", "instructionParamMap", "hitPointData", "targetCvsId", "actionInstruction"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
final class CreationImageEditAbility$buildImageRemoveSendMessageConfig$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageEditAbility this$0;

    public CreationImageEditAbility$buildImageRemoveSendMessageConfig$1(CreationImageEditAbility r1, Continuation<? super CreationImageEditAbility$buildImageRemoveSendMessageConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return CreationImageEditAbility.a(this.this$0, null, null, null, 0, null, this);
    }
}
