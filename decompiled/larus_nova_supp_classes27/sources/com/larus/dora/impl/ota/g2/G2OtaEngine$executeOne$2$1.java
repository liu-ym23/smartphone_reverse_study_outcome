package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class G2OtaEngine$executeOne$2$1 extends FunctionReferenceImpl implements Function1<s, Unit> {
    public G2OtaEngine$executeOne$2$1(Object r8) {
        super(1, r8, G2OtaEngine.class, "send", "send(Lcom/larus/dora/impl/ota/g2/G2OtaEvent;)V", 0);
    }

    public final void invoke(s r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((G2OtaEngine) ((CallableReference) this).receiver).q(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s) r1);
        return Unit.INSTANCE;
    }
}
