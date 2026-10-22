package com.obric.aikernel.request;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.request.RequestParser", f = "RequestParser.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 5, 8, 9}, l = {39, 41, 69, 78, 91, 102, 107, 109, 113, 120}, m = "handelRequest", n = {"this", "params", "callback", "biz", "params", "callback", "biz", "this", "callback", "$this$forEach$iv", "callerPid", "callerUid", "this", "callback", "$this$forEach$iv", "callerPid", "callerUid", "params", "params", "callback"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$0", "L$0"})
final class RequestParser$handelRequest$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestParser this$0;

    RequestParser$handelRequest$1(RequestParser r10, Continuation<? super RequestParser$handelRequest$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
