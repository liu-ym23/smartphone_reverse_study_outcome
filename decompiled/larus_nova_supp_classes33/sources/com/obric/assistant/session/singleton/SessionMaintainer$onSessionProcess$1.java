package com.obric.assistant.session.singleton;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.singleton.SessionMaintainer", f = "SessionMaintainer.kt", i = {0}, l = {1158}, m = "onSessionProcess", n = {"startupAttemptId"}, s = {"L$0"})
public final class SessionMaintainer$onSessionProcess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionMaintainer this$0;

    public SessionMaintainer$onSessionProcess$1(SessionMaintainer r1, Continuation<? super SessionMaintainer$onSessionProcess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
