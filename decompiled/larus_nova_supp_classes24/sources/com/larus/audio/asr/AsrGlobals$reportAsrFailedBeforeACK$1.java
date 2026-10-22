package com.larus.audio.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.api.AppreciableTraceDelegate;
import com.larus.bmhome.chat.api.IAppreciableTraceService;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.asr.AsrGlobals$reportAsrFailedBeforeACK$1", f = "AsrGlobals.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AsrGlobals$reportAsrFailedBeforeACK$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorType;
    final /* synthetic */ int $status;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;

    public AsrGlobals$reportAsrFailedBeforeACK$1(String r1, String r2, int r3, Continuation<? super AsrGlobals$reportAsrFailedBeforeACK$1> r4) {
        this.$taskId = r1;
        this.$errorType = r2;
        this.$status = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AsrGlobals$reportAsrFailedBeforeACK$1 r0 = new AsrGlobals$reportAsrFailedBeforeACK$1(this.$taskId, this.$errorType, this.$status, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        String r1 = this.$taskId;
        String r4 = this.$errorType;
        int r5 = this.$status;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        AsrGlobals r11 = AsrGlobals.a;     // Catch: Throwable -> L7
        IAppreciableTraceService.a.a(AppreciableTraceDelegate.b, r1, "speak", 0, r4, r5, 4);     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L13;
        FLogger.a.e("AsrGlobals", "reportAsrFailedBeforeACK async failed", r13);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
