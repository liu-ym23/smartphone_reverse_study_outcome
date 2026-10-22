package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJobRequestType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListLoader$refresh$1 extends FunctionReferenceImpl implements Function1<AIJobRequestType, Unit> {
    public ChatJobListLoader$refresh$1(Object r8) {
        super(1, r8, ChatJobListLoader.class, "finishPullRefreshRequest", "finishPullRefreshRequest(Lcom/larus/im/bean/job/AIJobRequestType;)V", 0);
    }

    public final void invoke(AIJobRequestType r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ChatJobListLoader r0 = (ChatJobListLoader) ((CallableReference) this).receiver;
        int r1 = ChatJobListLoader.t;
        r0.e(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((AIJobRequestType) r1);
        return Unit.INSTANCE;
    }
}
