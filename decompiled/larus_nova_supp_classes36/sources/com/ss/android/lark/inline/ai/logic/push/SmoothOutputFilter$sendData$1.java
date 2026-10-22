package com.ss.android.lark.inline.ai.logic.push;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$sendData$1", f = "SmoothOutputFilter.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class SmoothOutputFilter$sendData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SmoothOutputFilter.b $pushPrintParam;
    int label;
    final /* synthetic */ SmoothOutputFilter this$0;

    public SmoothOutputFilter$sendData$1(SmoothOutputFilter r1, SmoothOutputFilter.b r2, Continuation<? super SmoothOutputFilter$sendData$1> r3) {
        this.this$0 = r1;
        this.$pushPrintParam = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SmoothOutputFilter$sendData$1(this.this$0, this.$pushPrintParam, r4);
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
    L11:
        Log.d("SmoothOutputFilter", "sendData  data");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Channel<SmoothOutputFilter.b> r5 = this.this$0.c;
        SmoothOutputFilter.b r2 = this.$pushPrintParam;
        this.label = 1;
        if (r5.send(r2, this) != r0) goto L11;
        return r0;
    }
}
