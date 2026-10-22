package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedMultiBridgePresenter$doMessageListen$2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public FeedMultiBridgePresenter$doMessageListen$2(FeedMultiBridgePresenter r8) {
        super(1, r8, FeedMultiBridgePresenter.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        FeedMultiBridgePresenter.a((FeedMultiBridgePresenter) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
