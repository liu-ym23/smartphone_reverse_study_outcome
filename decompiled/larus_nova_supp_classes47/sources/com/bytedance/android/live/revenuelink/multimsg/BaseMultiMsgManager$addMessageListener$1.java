package com.bytedance.android.live.revenuelink.multimsg;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u00012\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "T", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class BaseMultiMsgManager$addMessageListener$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public BaseMultiMsgManager$addMessageListener$1(a r8) {
        super(1, r8, a.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        a r0 = (a) ((CallableReference) this).receiver;
        int r1 = a.j;
        r0.k(0, r4, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
