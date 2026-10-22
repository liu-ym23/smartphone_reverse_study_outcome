package com.obric.miniapp.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.QueryPrivilegedImageOperation", f = "QueryPrivilegedImageOperation.kt", i = {0, 0, 0, 0, 1, 1}, l = {72, 82}, m = "encodeImage", n = {"packageName", "uri", "bounds", "maxSize", "options", "maxSize"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "I$0"})
final class QueryPrivilegedImageOperation$encodeImage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryPrivilegedImageOperation this$0;

    public QueryPrivilegedImageOperation$encodeImage$1(QueryPrivilegedImageOperation r1, Continuation<? super QueryPrivilegedImageOperation$encodeImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return QueryPrivilegedImageOperation.a(this.this$0, null, null, 0, this);
    }
}
