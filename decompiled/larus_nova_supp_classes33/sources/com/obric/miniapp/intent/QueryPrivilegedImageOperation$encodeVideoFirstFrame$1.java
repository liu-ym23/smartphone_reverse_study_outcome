package com.obric.miniapp.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.QueryPrivilegedImageOperation", f = "QueryPrivilegedImageOperation.kt", i = {0}, l = {93}, m = "encodeVideoFirstFrame", n = {"maxSize"}, s = {"I$0"})
final class QueryPrivilegedImageOperation$encodeVideoFirstFrame$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryPrivilegedImageOperation this$0;

    public QueryPrivilegedImageOperation$encodeVideoFirstFrame$1(QueryPrivilegedImageOperation r1, Continuation<? super QueryPrivilegedImageOperation$encodeVideoFirstFrame$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return QueryPrivilegedImageOperation.b(this.this$0, null, null, 0, this);
    }
}
