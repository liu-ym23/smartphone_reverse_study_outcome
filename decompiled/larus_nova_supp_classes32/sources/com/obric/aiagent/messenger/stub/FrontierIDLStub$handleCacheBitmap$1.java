package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FrontierIDLStub", f = "FrontierIDLStub.kt", i = {0}, l = {85}, m = "handleCacheBitmap", n = {"payload"}, s = {"L$0"})
public final class FrontierIDLStub$handleCacheBitmap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrontierIDLStub this$0;

    public FrontierIDLStub$handleCacheBitmap$1(FrontierIDLStub r1, Continuation<? super FrontierIDLStub$handleCacheBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return FrontierIDLStub.access$handleCacheBitmap(this.this$0, null, null, null, this);
    }
}
