package com.larus.chat.job.impl.page;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListViewModel$loader$1 extends FunctionReferenceImpl implements Function1<j, Unit> {
    public ChatJobListViewModel$loader$1(Object r8) {
        super(1, r8, ChatJobListViewModel.class, "render", "render(Lcom/larus/chat/job/impl/page/ChatJobListLoadSnapshot;)V", 0);
    }

    public final void invoke(j r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ChatJobListViewModel.access$render((ChatJobListViewModel) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((j) r1);
        return Unit.INSTANCE;
    }
}
