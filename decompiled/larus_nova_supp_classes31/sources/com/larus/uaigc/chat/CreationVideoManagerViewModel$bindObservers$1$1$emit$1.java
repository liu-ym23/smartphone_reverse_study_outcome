package com.larus.uaigc.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationVideoManagerViewModel$bindObservers$1$1", f = "CreationVideoManagerViewModel.kt", i = {0}, l = {130}, m = "emit", n = {"needAutoPlayVid"}, s = {"L$1"})
public final class CreationVideoManagerViewModel$bindObservers$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationVideoManagerViewModel$bindObservers$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationVideoManagerViewModel$bindObservers$1$1$emit$1(CreationVideoManagerViewModel$bindObservers$1.AnonymousClass1<? super T> r1, Continuation<? super CreationVideoManagerViewModel$bindObservers$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
