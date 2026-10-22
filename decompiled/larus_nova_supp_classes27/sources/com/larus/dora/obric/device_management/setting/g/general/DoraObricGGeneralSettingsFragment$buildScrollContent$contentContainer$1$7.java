package com.larus.dora.obric.device_management.setting.g.general;

import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricGGeneralSettingsFragment$buildScrollContent$contentContainer$1$7 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricGGeneralSettingsFragment$buildScrollContent$contentContainer$1$7(Object r8) {
        super(0, r8, DoraObricGGeneralSettingsFragment.class, "showRebootConfirmDialog", "showRebootConfirmDialog()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m327invoke() {
        final DoraObricGGeneralSettingsFragment r0 = (DoraObricGGeneralSettingsFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricGGeneralSettingsFragment.x;
        r0.getClass();
        com.obric.oui.dialog.v2.alert.g r2 = new com.obric.oui.dialog.v2.alert.g(r0.requireContext());
        r2.w = false;
        int r3 = j0.a;
        String r4 = j0.d(2131902592);
        r2.j = false;
        r2.h = r4;
        r2.i = j0.d(2131902591);
        com.obric.oui.dialog.v2.alert.g.c(r2);
        r2.e(j0.d(2131902465), new h());
        r2.h(j0.d(2131902590), new i(r0));
        com.obric.oui.dialog.v2.alert.c r5 = r2.a();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m327invoke();
        return Unit.INSTANCE;
    }
}
