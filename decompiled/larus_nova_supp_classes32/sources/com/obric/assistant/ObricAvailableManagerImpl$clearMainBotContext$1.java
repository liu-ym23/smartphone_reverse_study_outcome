package com.obric.assistant;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ObricAvailableManagerImpl", f = "ObricAvailableManagerImpl.kt", i = {}, l = {165, 169}, m = "clearMainBotContext", n = {}, s = {})
final class ObricAvailableManagerImpl$clearMainBotContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAvailableManagerImpl this$0;

    public ObricAvailableManagerImpl$clearMainBotContext$1(ObricAvailableManagerImpl r1, Continuation<? super ObricAvailableManagerImpl$clearMainBotContext$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ObricAvailableManagerImpl.c(this.this$0, this);
    }
}
