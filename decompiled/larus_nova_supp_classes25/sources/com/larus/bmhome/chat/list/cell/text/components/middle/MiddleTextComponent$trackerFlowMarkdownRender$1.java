package com.larus.bmhome.chat.list.cell.text.components.middle;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.middle.MiddleTextComponent$trackerFlowMarkdownRender$1", f = "MiddleTextComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiddleTextComponent$trackerFlowMarkdownRender$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $parseCharCount;
    final /* synthetic */ lw8.m $performance;
    int label;

    public MiddleTextComponent$trackerFlowMarkdownRender$1(int r1, lw8.m r2, Continuation<? super MiddleTextComponent$trackerFlowMarkdownRender$1> r3) {
        this.$parseCharCount = r1;
        this.$performance = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MiddleTextComponent$trackerFlowMarkdownRender$1(this.$parseCharCount, this.$performance, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r9);
        Long r2 = Boxing.boxLong(this.$parseCharCount);
        lw8.m r10 = this.$performance;
        if (r10 == null) goto L7;
        Long r4 = r10.a;
    L8:
        if (r10 == null) goto L10;
        Long r5 = r10.b;
    L11:
        x1.a(r2, null, r4, r5, null, DoraCallStateCode.DOUBAO_CMD_14);
        return Unit.INSTANCE;
    L10:
        r5 = null;
        goto L11
    L7:
        r4 = null;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
