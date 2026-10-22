package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/m;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/m;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class CoreContext$attach$2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m, Unit> {
    public CoreContext$attach$2(CoreContext r8) {
        super(1, r8, CoreContext.class, "onSwitchScene", "onSwitchScene(Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/SwitchSceneEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        CoreContext r0 = (CoreContext) ((CallableReference) this).receiver;
        int r1 = CoreContext.l;
        r0.getClass();
        if (r3.a == false) goto L6;
        r0.b.resetDataForSwitch();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m) r1);
        return Unit.INSTANCE;
    }
}
