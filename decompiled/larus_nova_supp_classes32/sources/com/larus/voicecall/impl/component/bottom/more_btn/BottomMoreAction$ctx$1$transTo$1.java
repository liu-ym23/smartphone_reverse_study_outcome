package com.larus.voicecall.impl.component.bottom.more_btn;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BottomMoreAction$ctx$1$transTo$1 extends FunctionReferenceImpl implements Function1<c, Unit> {
    public BottomMoreAction$ctx$1$transTo$1(Object r8) {
        super(1, r8, b.class, "transTo", "transTo(Lcom/larus/voicecall/impl/component/bottom/more_btn/IBaseMoreBtnState;)V", 0);
    }

    public final void invoke(c r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        b r0 = (b) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "state");
        FLogger.a.i("BottomMoreAction", "transTo old_state=[" + r0.g.b() + "] new_state=[" + r5.b() + ']');
        r0.g.f();
        r0.g = r5;
        r5.e();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
