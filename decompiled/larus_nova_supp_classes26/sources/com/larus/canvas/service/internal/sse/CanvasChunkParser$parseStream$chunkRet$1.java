package com.larus.canvas.service.internal.sse;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/canvas/service/internal/sse/CanvasChunkPackage;", "throwable", "", "job", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.CanvasChunkParser$parseStream$chunkRet$1", f = "CanvasChunkParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasChunkParser$parseStream$chunkRet$1 extends SuspendLambda implements Function3<Throwable, Job, Continuation<? super Result<? extends b>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public CanvasChunkParser$parseStream$chunkRet$1(Continuation<? super CanvasChunkParser$parseStream$chunkRet$1> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((Throwable) r1, (Job) r2, (Continuation) r3);
    }

    public final Object invoke(Throwable r1, Job r2, Continuation<? super Result<b>> r3) {
        CanvasChunkParser$parseStream$chunkRet$1 r4 = new CanvasChunkParser$parseStream$chunkRet$1(r3);
        r4.L$0 = r1;
        return r4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        Throwable r3 = (Throwable) this.L$0;
        if ((r3 instanceof TimeoutCancellationException) == false) goto L10;
        String r4 = r3.getMessage();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r3 = new Exception(r4);
    L10:
        Result.Companion r0 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r3)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
