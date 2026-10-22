package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraMinorManager", f = "DoraMinorManager.kt", i = {0}, l = {62, 71}, m = "processMinorModeLogic", n = {"current"}, s = {"L$0"})
public final class DoraMinorManager$processMinorModeLogic$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraMinorManager this$0;

    public DoraMinorManager$processMinorModeLogic$1(DoraMinorManager r1, Continuation<? super DoraMinorManager$processMinorModeLogic$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraMinorManager r3 = this.this$0;
        DoraMinorManager r0 = DoraMinorManager.a;
        return r3.b(this);
    }
}
