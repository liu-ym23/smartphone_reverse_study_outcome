package com.obric.assistant.obric_action.handler.prompt;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$1 extends FunctionReferenceImpl implements Function1<j, Unit> {
    final /* synthetic */ Ref.BooleanRef $completed;
    final /* synthetic */ kotlinx.coroutines.i<j> $continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$1(Ref.BooleanRef r7, kotlinx.coroutines.i<? super j> r8) {
        this.$completed = r7;
        this.$continuation = r8;
        super(1, Intrinsics.Kotlin.class, "complete", "awaitPromptDialog$lambda$0$complete(Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlinx/coroutines/CancellableContinuation;Lcom/obric/assistant/obric_action/handler/prompt/PromptDialogActionResult;)V", 0);
    }

    public final void invoke(j r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        h.b(this.$completed, this.$continuation, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((j) r1);
        return Unit.INSTANCE;
    }
}
