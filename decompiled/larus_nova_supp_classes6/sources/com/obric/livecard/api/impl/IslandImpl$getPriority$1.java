package com.obric.livecard.api.impl;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl", f = "IslandImpl.kt", i = {0}, l = {159}, m = "getPriority", n = {"session"}, s = {"L$0"})
public final class IslandImpl$getPriority$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$getPriority$1(IslandImpl r1, Continuation<? super IslandImpl$getPriority$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IWakeupSessionConstant.RC_ERROR;
        return this.this$0.getPriority(null, this);
    }
}
