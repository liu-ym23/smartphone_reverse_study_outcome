package com.obric.assistant.remote_card_container;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$init$1", f = "RemoteCardImpl.kt", i = {0}, l = {379}, m = "isMessageValid", n = {"messageId"}, s = {"L$0"})
public final class RemoteCardImpl$init$1$isMessageValid$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteCardImpl.init.1 this$0;

    public RemoteCardImpl$init$1$isMessageValid$1(RemoteCardImpl.init.1 r1, Continuation<? super RemoteCardImpl$init$1$isMessageValid$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
