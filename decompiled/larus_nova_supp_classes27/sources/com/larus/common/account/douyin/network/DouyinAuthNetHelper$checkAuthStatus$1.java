package com.larus.common.account.douyin.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.network.DouyinAuthNetHelper", f = "DouyinAuthNetHelper.kt", i = {}, l = {63}, m = "checkAuthStatus", n = {}, s = {})
public final class DouyinAuthNetHelper$checkAuthStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinAuthNetHelper this$0;

    public DouyinAuthNetHelper$checkAuthStatus$1(DouyinAuthNetHelper r1, Continuation<? super DouyinAuthNetHelper$checkAuthStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
