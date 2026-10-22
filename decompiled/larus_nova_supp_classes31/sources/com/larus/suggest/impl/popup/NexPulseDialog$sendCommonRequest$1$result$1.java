package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.PopWindowButton;
import com.larus.suggest.impl.popup.model.PopWindowCommonBizData;
import com.larus.suggest.impl.popup.model.PopWindowCommonBizRequest;
import com.larus.suggest.impl.popup.model.PopWindowRepo;
import com.tencent.open.log.TraceLevel;
import dm9.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/suggest/impl/popup/model/PopWindowCommonBizData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.popup.NexPulseDialog$sendCommonRequest$1$result$1", f = "NexPulseDialog.kt", i = {}, l = {435}, m = "invokeSuspend", n = {}, s = {})
public final class NexPulseDialog$sendCommonRequest$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends PopWindowCommonBizData>>, Object> {
    final /* synthetic */ PopWindowButton $buttonConfig;
    int label;

    public NexPulseDialog$sendCommonRequest$1$result$1(PopWindowButton r1, Continuation<? super NexPulseDialog$sendCommonRequest$1$result$1> r2) {
        this.$buttonConfig = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new NexPulseDialog$sendCommonRequest$1$result$1(this.$buttonConfig, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<PopWindowCommonBizData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L17:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        PopWindowRepo r11 = PopWindowRepo.a;
        String r4 = this.$buttonConfig.getBizReqId();
        String r12 = this.$buttonConfig.getParams();
        if (r12 != null) goto L11;
    L13:
        r12 = null;
    L14:
        PopWindowCommonBizRequest r13 = new PopWindowCommonBizRequest(r4, 0, r12, 2, null);
        this.label = 1;
        r10 = PopWindowRepo.c(r13, this);
        if (r10 != r0) goto L17;
        return r0;
    L11:
        if ((!StringsKt.isBlank(r12)) == false) goto L13;
        goto L13
    }
}
