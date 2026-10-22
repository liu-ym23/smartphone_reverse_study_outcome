package com.larus.chat.job.impl.component;

import com.larus.im.bean.job.AIJob;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListComponent$onViewCreated$listAdapter$1 extends FunctionReferenceImpl implements Function2<AIJob, Integer, Unit> {
    public ChatJobListComponent$onViewCreated$listAdapter$1(Object r8) {
        super(2, r8, ChatJobListComponent.class, "handleTaskClick", "handleTaskClick(Lcom/larus/im/bean/job/AIJob;I)V", 0);
    }

    public final void invoke(AIJob r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ChatJobListComponent r0 = (ChatJobListComponent) ((CallableReference) this).receiver;
        int r1 = ChatJobListComponent.w;
        r0.getClass();
        ez8.a.a.getClass();
        ez8.a.i(r3, r4);
        r0.h3(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((AIJob) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
