package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraSceneManager", f = "DoraSceneManager.kt", i = {0}, l = {117}, m = "clearScene", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class DoraSceneManager$clearScene$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSceneManager this$0;

    public DoraSceneManager$clearScene$1(DoraSceneManager r1, Continuation<? super DoraSceneManager$clearScene$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraSceneManager.a(this.this$0, this);
    }
}
