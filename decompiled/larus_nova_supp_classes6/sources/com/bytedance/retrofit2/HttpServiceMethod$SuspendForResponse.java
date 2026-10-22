package com.bytedance.retrofit2;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class HttpServiceMethod$SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
    private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

    public HttpServiceMethod$SuspendForResponse(RequestFactory r1, CallAdapter<ResponseT, Call<ResponseT>> r2) {
        super(r1);
        this.callAdapter = r2;
    }

    public Object adapt(Call<ResponseT> r2, Object[] r3) {
        Call r4 = (Call) this.callAdapter.adapt(r2);
        Continuation r5 = (Continuation) r3[r3.length - 1];
        return KotlinExtensions.awaitResponse(r4, r5);
    L5:
        e = move-exception;
        return KotlinExtensions.suspendAndThrow(e, r5);
    }
}
