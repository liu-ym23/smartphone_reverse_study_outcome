package com.obric.assistant.authenticationsession;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl", f = "SessionAuthenticationServiceImpl.kt", i = {0, 0, 0}, l = {757}, m = "waitForAiFingerprintUnlock", n = {"cancellationSignal", "startTime", "checkCount"}, s = {"L$0", "J$0", "I$0"})
final class SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionAuthenticationServiceImpl this$0;

    public SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1(SessionAuthenticationServiceImpl r1, Continuation<? super SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SessionAuthenticationServiceImpl.a(this.this$0, null, this);
    }
}
