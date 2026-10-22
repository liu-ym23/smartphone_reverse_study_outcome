package com.larus.bmhome.video;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.RecommendVideoApi$tryPrefetchInnerStreamData$1", f = "RecommendVideoApi.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
final class RecommendVideoApi$tryPrefetchInnerStreamData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public RecommendVideoApi$tryPrefetchInnerStreamData$1(Continuation<? super RecommendVideoApi$tryPrefetchInnerStreamData$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new RecommendVideoApi$tryPrefetchInnerStreamData$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        RecommendVideoData r9 = (RecommendVideoData) r8;
        if (r9 == null) goto L17;
        List<Content> r10 = r9.getItemLists();
        if (r10 == null) goto L17;
        ArrayList r2 = (ArrayList) RecommendVideoApi.k;
        r2.addAll(r10);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        RecommendVideoApi r3 = RecommendVideoApi.a;
        SortScene r11 = SortScene.InnerStream;
        SortRequestType r4 = SortRequestType.PreLoad;
        int r5 = RecommendVideoApi.g;
        this.label = 1;
        r8 = RecommendVideoApi.f(r3, r11, r4, r5, true, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
