package com.larus.dora.obric.device_management.device_bind;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceBindFragment$buildContentView$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricDeviceBindFragment$buildContentView$2(Object r8) {
        super(0, r8, DoraObricDeviceBindFragment.class, "startBind", "startBind()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m224invoke() {
        DoraObricDeviceBindFragment r0 = (DoraObricDeviceBindFragment) ((CallableReference) this).receiver;
        int[] r1 = DoraObricDeviceBindFragment.o;
        r0.getClass();
        r0.W90("check_from_MAIN", new j(r0));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m224invoke();
        return Unit.INSTANCE;
    }
}
