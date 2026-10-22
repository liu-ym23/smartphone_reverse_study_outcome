package com.larus.uaigc.creation.gallery.providers;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$setCreationPrivacy$2", f = "CreationBottomView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationBottomView$setCreationPrivacy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $buttonStatus;
    int label;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$setCreationPrivacy$2(CreationBottomView r1, int r2, Continuation<? super CreationBottomView$setCreationPrivacy$2> r3) {
        this.this$0 = r1;
        this.$buttonStatus = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationBottomView$setCreationPrivacy$2(this.this$0, this.$buttonStatus, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        CreationBottomView r5 = this.this$0;
        Integer r0 = Boxing.boxInt(this.$buttonStatus);
        int r1 = CreationBottomView.i;
        r5.k6(r0, "setCreationPrivacy");
        m0.c(this.this$0.getItemName(), CreationBottomView.T5(this.this$0), "picture_detail", "chat_list");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
