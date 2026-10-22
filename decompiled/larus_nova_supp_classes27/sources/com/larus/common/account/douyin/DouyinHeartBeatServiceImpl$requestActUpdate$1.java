package com.larus.common.account.douyin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {234}, m = "requestActUpdate", n = {}, s = {})
public final class DouyinHeartBeatServiceImpl$requestActUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$requestActUpdate$1(DouyinHeartBeatServiceImpl r1, Continuation<? super DouyinHeartBeatServiceImpl$requestActUpdate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        DouyinHeartBeatServiceImpl r4 = this.this$0;
        int r0 = DouyinHeartBeatServiceImpl.d;
        return r4.h(null, false, null, this);
    }
}
