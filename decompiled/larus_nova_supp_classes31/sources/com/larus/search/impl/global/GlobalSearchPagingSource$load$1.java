package com.larus.search.impl.global;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchPagingSource", f = "GlobalSearchRepo.kt", i = {0, 0}, l = {77}, m = "load", n = {"currentQuery", "offset"}, s = {"L$0", "I$0"})
public final class GlobalSearchPagingSource$load$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlobalSearchPagingSource this$0;

    public GlobalSearchPagingSource$load$1(GlobalSearchPagingSource r1, Continuation<? super GlobalSearchPagingSource$load$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
