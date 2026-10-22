package com.lark.kmp.rustclient.api;

import com.bytedance.lark.sdk.InvokeResponse;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface g {
    <Resp> Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a(h<Resp> r1);

    <Resp> Object b(h<Resp> r1, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r2);
}
