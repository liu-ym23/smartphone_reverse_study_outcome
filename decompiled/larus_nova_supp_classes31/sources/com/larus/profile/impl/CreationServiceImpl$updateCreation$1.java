package com.larus.profile.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.CreationServiceImpl", f = "CreationServiceImpl.kt", i = {0, 0}, l = {196, 198}, m = "updateCreation", n = {"creationId", "creationPrivateStatus"}, s = {"L$0", "I$0"})
public final class CreationServiceImpl$updateCreation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationServiceImpl this$0;

    public CreationServiceImpl$updateCreation$1(CreationServiceImpl r1, Continuation<? super CreationServiceImpl$updateCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, 0, this);
    }
}
