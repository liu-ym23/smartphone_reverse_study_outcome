package com.obric.assistant.session.singleton;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.singleton.SessionEndpointMgr", f = "SessionEndpointMgr.kt", i = {0, 0, 0}, l = {90}, m = "onSessionProcess", n = {"args", "listSize", "i"}, s = {"L$0", "I$0", "I$1"})
public final class SessionEndpointMgr$onSessionProcess$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionEndpointMgr this$0;

    public SessionEndpointMgr$onSessionProcess$1(SessionEndpointMgr r1, Continuation<? super SessionEndpointMgr$onSessionProcess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
