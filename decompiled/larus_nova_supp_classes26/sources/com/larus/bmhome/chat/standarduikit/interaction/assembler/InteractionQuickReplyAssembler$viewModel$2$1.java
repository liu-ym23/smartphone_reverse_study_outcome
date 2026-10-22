package com.larus.bmhome.chat.standarduikit.interaction.assembler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InteractionQuickReplyAssembler$viewModel$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public InteractionQuickReplyAssembler$viewModel$2$1(Object r8) {
        super(0, r8, InteractionQuickReplyAssembler.class, "render", "render()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m0invoke() {
        ((InteractionQuickReplyAssembler) ((CallableReference) this).receiver).a();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m0invoke();
        return Unit.INSTANCE;
    }
}
