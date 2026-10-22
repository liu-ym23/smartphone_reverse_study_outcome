package com.larus.dora.obric.device_management.device_bind;

import com.larus.dora.impl.onboarding.q0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricSmartDeviceBindFragment$buildContentView$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricSmartDeviceBindFragment$buildContentView$2(Object r8) {
        super(0, r8, DoraObricSmartDeviceBindFragment.class, "onBindButtonClicked", "onBindButtonClicked()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m225invoke() {
        DoraObricSmartDeviceBindFragment r0 = (DoraObricSmartDeviceBindFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricSmartDeviceBindFragment.v;
        q0 r2 = (q0) r0.ba0().getUiStateFlow().getValue();
        if ((r2 instanceof q0.d) == false) goto L6;
        r0.ba0().bindAndConnect(((q0.d) r2).a);
        return;
    L6:
        if ((r2 instanceof q0.a) == false) goto L8;
        r0.ba0().bindAndConnect(((q0.a) r2).a);
        return;
    L8:
        r0.aa0("check_from_main", new n(r0));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m225invoke();
        return Unit.INSTANCE;
    }
}
