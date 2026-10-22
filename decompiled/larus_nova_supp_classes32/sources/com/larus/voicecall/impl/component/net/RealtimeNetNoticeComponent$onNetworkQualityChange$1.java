package com.larus.voicecall.impl.component.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class RealtimeNetNoticeComponent$onNetworkQualityChange$1 extends FunctionReferenceImpl implements Function1<a, Unit> {
    public RealtimeNetNoticeComponent$onNetworkQualityChange$1(Object r8) {
        super(1, r8, RealtimeNetNoticeComponent.class, "transitionTo", "transitionTo(Lcom/larus/voicecall/impl/component/net/INetworkViewState;)V", 0);
    }

    public final void invoke(a r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        RealtimeNetNoticeComponent r0 = (RealtimeNetNoticeComponent) ((CallableReference) this).receiver;
        int r1 = RealtimeNetNoticeComponent.y;
        r0.B3(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
