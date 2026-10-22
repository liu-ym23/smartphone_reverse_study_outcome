package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageRemoteResolver", f = "CreationImageRemoteResolver.kt", i = {0, 0, 0}, l = {34}, m = "resolve", n = {"context", "resourceInput", "$this$resolve_u24lambda_u240"}, s = {"L$0", "L$1", "L$2"})
public final class CreationImageRemoteResolver$resolve$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageRemoteResolver this$0;

    public CreationImageRemoteResolver$resolve$1(CreationImageRemoteResolver r1, Continuation<? super CreationImageRemoteResolver$resolve$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
