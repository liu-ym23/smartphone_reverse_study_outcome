package com.larus.camera.impl.vlm;

import ix8.c;
import ix8.d;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.vlm.VLMIntentDetectRepository$requestDetect$2$1", f = "VLMIntentDetectRepository.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class VLMIntentDetectRepository$requestDetect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ c $request;
    final /* synthetic */ a $tracker;
    int label;

    public VLMIntentDetectRepository$requestDetect$2$1(c r1, a r2, Continuation<? super VLMIntentDetectRepository$requestDetect$2$1> r3) {
        this.$request = r1;
        this.$tracker = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VLMIntentDetectRepository$requestDetect$2$1(this.$request, this.$tracker, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        VLMIntentDetectRepository r6 = VLMIntentDetectRepository.a;
        c r2 = this.$request;
        a r3 = this.$tracker;
        this.label = 1;
        r5 = r6.c(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
