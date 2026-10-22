package com.ss.android.lark.inline.ai.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.myai.export.MyAIService;
import com.ss.android.lark.pb.ai_engine.FeedsbackRequest;
import com.ss.android.lark.pb.ai_engine.FeedsbackResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.InlineAIPanelController$initListeners$2$1$onFeedback$1", f = "InlineAIPanelController.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, s = {})
public final class InlineAIPanelController$initListeners$2$1$onFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedsbackRequest $request;
    int label;

    public InlineAIPanelController$initListeners$2$1$onFeedback$1(FeedsbackRequest r1, Continuation<? super InlineAIPanelController$initListeners$2$1$onFeedback$1> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InlineAIPanelController$initListeners$2$1$onFeedback$1(this.$request, r3);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl((FeedsbackResponse) r4);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r5) == false) goto L20;
        Object r2 = null;
    L21:
        FeedsbackResponse r3 = (FeedsbackResponse) r2;
        if (r3 == null) goto L24;
        Log.i("InlineAIPanelController", "code: " + r3.mcode + ", message: " + r3.mmessage);
    L26:
        return Unit.INSTANCE;
    L24:
        Log.e("InlineAIPanelController", Result.exceptionOrNull-impl(r5));
        goto L26
    L20:
        r2 = r5;
        goto L21
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        FeedsbackRequest r6 = this.$request;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L15
        MyAIService.a.getClass();     // Catch: Throwable -> L15
        MyAIService r8 = (MyAIService) MyAIService.Companion.b.getValue();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r4 = r8.a();     // Catch: Throwable -> L15
        if (r4 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
