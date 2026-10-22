package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraSceneManager", f = "DoraSceneManager.kt", i = {0, 0}, l = {117}, m = "addScene", n = {"scene", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class DoraSceneManager$addScene$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSceneManager this$0;

    public DoraSceneManager$addScene$1(DoraSceneManager r1, Continuation<? super DoraSceneManager$addScene$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
