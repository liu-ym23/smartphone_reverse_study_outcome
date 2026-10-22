package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenter", f = "ResourceCenter.kt", i = {0}, l = {199}, m = "register", n = {"resourceList"}, s = {"L$0"})
public final class ResourceCenter$register$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenter this$0;

    public ResourceCenter$register$1(ResourceCenter r1, Continuation<? super ResourceCenter$register$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, null, null, this);
    }
}
