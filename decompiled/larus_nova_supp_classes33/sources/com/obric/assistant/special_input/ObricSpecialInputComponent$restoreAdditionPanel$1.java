package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent", f = "ObricSpecialInputComponent.kt", i = {0, 0}, l = {1728}, m = "restoreAdditionPanel", n = {"panelContext", "refMessageId"}, s = {"L$0", "L$1"})
public final class ObricSpecialInputComponent$restoreAdditionPanel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricSpecialInputComponent this$0;

    public ObricSpecialInputComponent$restoreAdditionPanel$1(ObricSpecialInputComponent r1, Continuation<? super ObricSpecialInputComponent$restoreAdditionPanel$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ObricSpecialInputComponent r3 = this.this$0;
        int r0 = ObricSpecialInputComponent.G1;
        return r3.Q5(null, this);
    }
}
