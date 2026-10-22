package com.obric.aikernel.phx.core.api;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", i = {0}, l = {109}, m = "unload", n = {ActivityLifecycle.NAME}, s = {"L$0"})
final class AbsApi$unload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsApi this$0;

    AbsApi$unload$1(AbsApi r10, Continuation<? super AbsApi$unload$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, null, this);
    }
}
