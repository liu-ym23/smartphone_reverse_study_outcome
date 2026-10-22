package com.obric.assistant.chatcontext;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl", f = "ClearContextInKeyguardServiceImpl.kt", i = {}, l = {144}, m = "clearContext", n = {}, s = {})
public final class ClearContextInKeyguardServiceImpl$clearContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClearContextInKeyguardServiceImpl this$0;

    public ClearContextInKeyguardServiceImpl$clearContext$1(ClearContextInKeyguardServiceImpl r1, Continuation<? super ClearContextInKeyguardServiceImpl$clearContext$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
