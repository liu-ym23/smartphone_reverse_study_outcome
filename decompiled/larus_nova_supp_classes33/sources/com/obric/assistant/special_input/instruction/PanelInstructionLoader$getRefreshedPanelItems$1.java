package com.obric.assistant.special_input.instruction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader", f = "PanelInstructionLoader.kt", i = {0}, l = {73}, m = "getRefreshedPanelItems", n = {"config"}, s = {"L$0"})
public final class PanelInstructionLoader$getRefreshedPanelItems$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$getRefreshedPanelItems$1(PanelInstructionLoader r1, Continuation<? super PanelInstructionLoader$getRefreshedPanelItems$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
