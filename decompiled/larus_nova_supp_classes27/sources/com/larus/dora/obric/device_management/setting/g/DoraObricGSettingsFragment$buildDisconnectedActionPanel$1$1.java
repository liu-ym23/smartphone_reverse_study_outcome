package com.larus.dora.obric.device_management.setting.g;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$1(Object r8) {
        super(0, r8, DoraObricGSettingsFragment.class, "checkReadyForReconnect", "checkReadyForReconnect()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m306invoke() {
        DoraObricGSettingsFragment r0 = (DoraObricGSettingsFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricGSettingsFragment.m;
        if (((u) r0.aa0().getUiState().getValue()).b == true) goto L7;
        r0.X90(r0.aa0().onReconnectClicked());
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m306invoke();
        return Unit.INSTANCE;
    }
}
