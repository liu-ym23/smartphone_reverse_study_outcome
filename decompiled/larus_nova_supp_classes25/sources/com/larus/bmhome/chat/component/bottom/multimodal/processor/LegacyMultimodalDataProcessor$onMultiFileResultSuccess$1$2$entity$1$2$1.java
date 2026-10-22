package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.FlowDriveSdkService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1", f = "LegacyMultimodalDataProcessor.kt", i = {}, l = {1257}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    public LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1(String r1, Continuation<? super LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1> r2) {
        this.$token = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1 r0 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1(this.$token, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl((String) r4);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r5) == false) goto L23;
        return null;
    L23:
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = this.$token;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        FlowDriveSdkService r3 = FlowDriveSdkService.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r4 = r3.b(r7, this);     // Catch: Throwable -> L15
        if (r4 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
