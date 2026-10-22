package com.larus.voicecall.impl.autostop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AutoStopAsrServiceImpl$controller$1 extends FunctionReferenceImpl implements Function1<a3a.a.d, Unit> {
    public AutoStopAsrServiceImpl$controller$1(Object r8) {
        super(1, r8, AutoStopAsrServiceImpl.class, "handleFailure", "handleFailure(Lcom/larus/voicecall/api/autostop/AutoStopAsrEvent$Error;)V", 0);
    }

    public final void invoke(a3a.a.d r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((AutoStopAsrServiceImpl) ((CallableReference) this).receiver).b(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a3a.a.d) r1);
        return Unit.INSTANCE;
    }
}
