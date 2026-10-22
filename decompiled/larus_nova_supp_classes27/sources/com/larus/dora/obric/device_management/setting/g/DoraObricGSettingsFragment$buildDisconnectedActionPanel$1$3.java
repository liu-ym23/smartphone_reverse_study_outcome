package com.larus.dora.obric.device_management.setting.g;

import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$3(Object r8) {
        super(0, r8, DoraObricGSettingsFragment.class, "showDisconnectedUnbindDialog", "showDisconnectedUnbindDialog()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m307invoke() {
        final DoraObricGSettingsFragment r0 = (DoraObricGSettingsFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricGSettingsFragment.m;
        r0.getClass();
        int r2 = j49.a.a;
        j49.a.i();
        com.obric.oui.dialog.v2.alert.g r3 = new com.obric.oui.dialog.v2.alert.g(r0.requireContext());
        r3.w = false;
        int r4 = j0.a;
        String r5 = j0.d(2131902946);
        r3.j = false;
        r3.h = r5;
        r3.i = j0.d(2131902983);
        com.obric.oui.dialog.v2.alert.g.c(r3);
        r3.e(j0.d(2131902465), new i());
        r3.h(j0.d(2131902418), new j(r0));
        com.obric.oui.dialog.v2.alert.c r6 = r3.a();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m307invoke();
        return Unit.INSTANCE;
    }
}
