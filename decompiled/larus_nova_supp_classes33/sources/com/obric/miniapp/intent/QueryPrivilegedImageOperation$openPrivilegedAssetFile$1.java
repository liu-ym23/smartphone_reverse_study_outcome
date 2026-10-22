package com.obric.miniapp.intent;

import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.QueryPrivilegedImageOperation", f = "QueryPrivilegedImageOperation.kt", i = {}, l = {ErrorCode.PERMISSION_ERROR}, m = "openPrivilegedAssetFile", n = {}, s = {})
public final class QueryPrivilegedImageOperation$openPrivilegedAssetFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryPrivilegedImageOperation this$0;

    public QueryPrivilegedImageOperation$openPrivilegedAssetFile$1(QueryPrivilegedImageOperation r1, Continuation<? super QueryPrivilegedImageOperation$openPrivilegedAssetFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        QueryPrivilegedImageOperation r3 = this.this$0;
        QueryPrivilegedImageOperation r0 = QueryPrivilegedImageOperation.a;
        return r3.f(null, null, this);
    }
}
