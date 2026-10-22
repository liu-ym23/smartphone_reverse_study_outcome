package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/model/DeepResearchResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper$getBlockListFlattenText$2$content$1$1", f = "MessageCopyHelper.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
public final class MessageCopyHelper$getBlockListFlattenText$2$content$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mf9.c>, Object> {
    final /* synthetic */ String $resourceId;
    int label;

    public MessageCopyHelper$getBlockListFlattenText$2$content$1$1(String r1, Continuation<? super MessageCopyHelper$getBlockListFlattenText$2$content$1$1> r2) {
        this.$resourceId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageCopyHelper$getBlockListFlattenText$2$content$1$1(this.$resourceId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super mf9.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L13:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MessageCopyHelper r6 = MessageCopyHelper.a;
        String r2 = this.$resourceId;
        this.label = 1;
        r6.getClass();
        kotlinx.coroutines.j r7 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r7.C();
        com.larus.im.e r3 = com.larus.im.c.a;
        com.larus.im.internal.research.a.a.a(r2, new o1(r7));
        r5 = r7.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r5 != r0) goto L13;
        return r0;
    }
}
