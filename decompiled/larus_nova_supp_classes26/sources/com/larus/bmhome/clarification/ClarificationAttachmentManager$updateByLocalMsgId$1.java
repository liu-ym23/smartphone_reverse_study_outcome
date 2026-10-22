package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$updateByLocalMsgId$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentManager$updateByLocalMsgId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $block;
    final /* synthetic */ int $pageIndex;
    int label;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ClarificationAttachmentManager$updateByLocalMsgId$1(ClarificationAttachmentManager r1, Function1<? super Integer, Unit> r2, int r3, Continuation<? super ClarificationAttachmentManager$updateByLocalMsgId$1> r4) {
        this.this$0 = r1;
        this.$block = r2;
        this.$pageIndex = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ClarificationAttachmentManager$updateByLocalMsgId$1(this.this$0, this.$block, this.$pageIndex, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (this.this$0.j == true) goto L7;
        this.$block.invoke(Boxing.boxInt(this.$pageIndex));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
