package com.obric.aikernel.res.update;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask", f = "UpdateTask.kt", i = {0, 1}, l = {TypedValues.MotionType.TYPE_EASING, 614}, m = "doUpdate", n = {"this", "this"}, s = {"L$0", "L$0"})
final class UpdateTask$doUpdate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateTask this$0;

    UpdateTask$doUpdate$1(UpdateTask r10, Continuation<? super UpdateTask$doUpdate$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.D(this);
    }
}
