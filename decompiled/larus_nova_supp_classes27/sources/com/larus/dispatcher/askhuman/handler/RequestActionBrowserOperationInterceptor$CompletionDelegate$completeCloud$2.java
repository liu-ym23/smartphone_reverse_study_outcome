package com.larus.dispatcher.askhuman.handler;

import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dispatcher.api.UploadToolCallResultApi;
import com.larus.network.FlowHttpConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2", f = "RequestActionBrowserOperationInterceptor.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
final class RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ hv8.a $request;
    int label;

    public RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2(hv8.a r1, Continuation<? super RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2(this.$request, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        dm9.a.b r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.b) == true) goto L14;
    L16:
        r2 = false;
    L18:
        return Boxing.boxBoolean(r2);
    L14:
        if (r14.a.isSuccess() == false) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        UploadToolCallResultApi.a r15 = UploadToolCallResultApi.a;
        RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2$result$1 r5 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2$result$1(this.$request, null);
        this.label = 1;
        r15.getClass();
        FlowHttpConnection r16 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("MainBot", UploadToolCallResultApi.class, r5, true, null, null, null, this, BaiduNaviStatus.NO_PERMISSION);
        if (r13 != r0) goto L11;
        return r0;
    }
}
