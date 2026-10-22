package com.larus.dora.impl.device.settings.unbind;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.unbind.DoraUnbindStep$API", f = "DoraUnbindViewModel.kt", i = {}, l = {54}, m = "step", n = {}, s = {})
public final class DoraUnbindStep$API$step$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraUnbindStep.API this$0;

    public DoraUnbindStep$API$step$1(DoraUnbindStep.API r1, Continuation<? super DoraUnbindStep$API$step$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.step(null, this);
    }
}
