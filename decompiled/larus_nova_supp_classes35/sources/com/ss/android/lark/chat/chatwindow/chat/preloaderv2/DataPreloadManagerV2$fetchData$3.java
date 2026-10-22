package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.DataPreloadManagerV2$fetchData$3", f = "DataPreloadManagerV2.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
final class DataPreloadManagerV2$fetchData$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Object> $callback;
    final /* synthetic */ w3b.d<Object> $task;
    int label;
    final /* synthetic */ DataPreloadManagerV2 this$0;

    public DataPreloadManagerV2$fetchData$3(DataPreloadManagerV2 r1, w3b.d<Object> r2, IGetDataCallback<Object> r3, Continuation<? super DataPreloadManagerV2$fetchData$3> r4) {
        this.this$0 = r1;
        this.$task = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DataPreloadManagerV2$fetchData$3(this.this$0, this.$task, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L11:
        ErrorResult r2 = null;
        if (Result.isSuccess-impl(r5) == true) goto L14;
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if ((r6 instanceof ErrorResult) == false) goto L26;
        r2 = (ErrorResult) r6;
    L26:
        IGetDataCallback<Object> r7 = this.$callback;
        if (r7 == null) goto L32;
        if (r2 != null) goto L30;
        r2 = new ErrorResult("fetchData failed");
    L30:
        r7.onError(r2);
    L32:
        return Unit.INSTANCE;
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        if (r5 != null) goto L20;
        IGetDataCallback<Object> r8 = this.$callback;
        if (r8 == null) goto L32;
        r8.onError(new ErrorResult("response is null"));
        goto L32
    L20:
        IGetDataCallback<Object> r3 = this.$callback;
        if (r3 == null) goto L32;
        r3.onSuccess(r5);
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DataPreloadManagerV2 r9 = this.this$0;
        w3b.d<Object> r10 = this.$task;
        this.label = 1;
        r5 = r9.B6(r10, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
