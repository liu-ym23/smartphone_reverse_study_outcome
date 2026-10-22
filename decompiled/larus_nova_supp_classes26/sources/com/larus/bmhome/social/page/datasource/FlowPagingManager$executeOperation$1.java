package com.larus.bmhome.social.page.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager", f = "FlowPagingManager.kt", i = {}, l = {177}, m = "executeOperation", n = {}, s = {})
final class FlowPagingManager$executeOperation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowPagingManager<Object, Object, com.larus.bmhome.social.page.datasource.event.a<Object>> this$0;

    public FlowPagingManager$executeOperation$1(FlowPagingManager<Object, Object, com.larus.bmhome.social.page.datasource.event.a<Object>> r1, Continuation<? super FlowPagingManager$executeOperation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return FlowPagingManager.a(this.this$0, null, this);
    }
}
