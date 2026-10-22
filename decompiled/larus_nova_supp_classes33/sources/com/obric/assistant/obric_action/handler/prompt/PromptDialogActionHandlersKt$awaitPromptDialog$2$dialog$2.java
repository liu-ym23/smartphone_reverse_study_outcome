package com.obric.assistant.obric_action.handler.prompt;

import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$2 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $completed;
    final /* synthetic */ kotlinx.coroutines.i<j> $continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$2(Ref.BooleanRef r7, kotlinx.coroutines.i<? super j> r8) {
        this.$completed = r7;
        this.$continuation = r8;
        super(0, Intrinsics.Kotlin.class, "completeDismissed", "awaitPromptDialog$lambda$0$completeDismissed(Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlinx/coroutines/CancellableContinuation;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m8invoke() {
        t0.c(new g(this.$completed, this.$continuation));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m8invoke();
        return Unit.INSTANCE;
    }
}
