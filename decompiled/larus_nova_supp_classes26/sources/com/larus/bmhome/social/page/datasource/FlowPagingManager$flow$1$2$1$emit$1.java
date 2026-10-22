package com.larus.bmhome.social.page.datasource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2$1", f = "FlowPagingManager.kt", i = {0, 0}, l = {298}, m = "emit", n = {"$this$withLock_u24default$iv", "refresh"}, s = {"L$0", "Z$0"})
public final class FlowPagingManager$flow$1$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowPagingManager$flow$1.AnonymousClass2.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowPagingManager$flow$1$2$1$emit$1(FlowPagingManager$flow$1.AnonymousClass2.AnonymousClass1<? super T> r1, Continuation<? super FlowPagingManager$flow$1$2$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, (Continuation<? super Unit>) this);
    }
}
