package com.obric.aikernel.phx.sdk.api;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$ipcJob$1", f = "AIKernelApi.kt", i = {}, l = {392, 393}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$wrapApiCall$ipcJob$1<T> extends SuspendLambda implements Function2<al, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ RequestParams $params;
    Object L$0;
    int label;

    AIKernelApi$wrapApiCall$ipcJob$1(RequestParams r3, Function1<? super Continuation<? super T>, ? extends Object> r4, Continuation<? super AIKernelApi$wrapApiCall$ipcJob$1> r5) {
        Function1<Continuation<? super T>, Object> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$params = r3;
        this.$block = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$ipcJob$1(this.$params, this.$block, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Object r4) {
        return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(al r3, Continuation<? super T> r4) {
        return ((AIKernelApi$wrapApiCall$ipcJob$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelApi$wrapApiCall$ipcJob$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L22
    L20:
        Object r6 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r6);
        if (r8 == null) goto L28;
        AIKLog.INSTANCE.w(AIKernelApi.TAG, "asyncTransact got exception: " + r8);
    L28:
        if (Result.m1427isFailureimpl(r6) == false) goto L31;
        return null;
    L31:
        return r6;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Function1<Continuation<? super T>, Object> r2 = (Function1) ZeusTransformUtils.preCheckCast(this.L$0, Function1.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L22
    L17:
        this.L$0 = null;     // Catch: Throwable -> L22
        this.label = 2;     // Catch: Throwable -> L22
        r7 = r2.invoke(this);     // Catch: Throwable -> L22
        if (r7 != r0) goto L20;
        return r0;
    L13:
        ResultKt.throwOnFailure(r7);
        RequestParams r9 = this.$params;
        r2 = this.$block;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        ParamsCompat r10 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L22
        this.L$0 = r2;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        if (r10.startCompat(r9, this) != r0) goto L17;
        return r0;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
