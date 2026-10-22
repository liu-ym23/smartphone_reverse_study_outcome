package com.obric.aikernel.middleware.api.appcontext.receiver;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener", f = "NetworkStateListener.kt", i = {}, l = {117, 120}, m = "actWhenNetAvail", n = {}, s = {})
final class NetworkStateListener$actWhenNetAvail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkStateListener this$0;

    NetworkStateListener$actWhenNetAvail$1(NetworkStateListener r10, Continuation<? super NetworkStateListener$actWhenNetAvail$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
