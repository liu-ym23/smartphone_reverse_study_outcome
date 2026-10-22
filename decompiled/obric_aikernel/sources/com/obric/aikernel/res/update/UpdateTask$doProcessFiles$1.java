package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask", f = "UpdateTask.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {826, 860}, m = "doProcessFiles", n = {"this", "destination$iv$iv", "it", "installPathPrefix", "decryptRet", "this", "destination$iv$iv", "unzipRet"}, s = {"L$0", "L$1", "L$3", "L$4", "L$5", "L$0", "L$1", "L$3"})
final class UpdateTask$doProcessFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateTask this$0;

    UpdateTask$doProcessFiles$1(UpdateTask r10, Continuation<? super UpdateTask$doProcessFiles$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return UpdateTask.e(this.this$0, this);
    }
}
