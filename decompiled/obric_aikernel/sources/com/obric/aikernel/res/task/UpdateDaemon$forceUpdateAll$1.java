package com.obric.aikernel.res.task;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.task.UpdateDaemon", f = "UpdateDaemon.kt", i = {0, 0, 0, 0}, l = {44}, m = "forceUpdateAll", n = {"this", "caller", "triggerReason", "onlyFetchConfig"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class UpdateDaemon$forceUpdateAll$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateDaemon this$0;

    UpdateDaemon$forceUpdateAll$1(UpdateDaemon r10, Continuation<? super UpdateDaemon$forceUpdateAll$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return UpdateDaemon.a(this.this$0, false, null, null, this);
    }
}
