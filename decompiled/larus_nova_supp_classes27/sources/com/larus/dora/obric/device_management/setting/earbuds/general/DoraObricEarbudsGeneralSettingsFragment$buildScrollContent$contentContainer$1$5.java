package com.larus.dora.obric.device_management.setting.earbuds.general;

import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$5 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$5(Object r8) {
        super(0, r8, DoraObricEarbudsGeneralSettingsFragment.class, "showUnbindConfirmDialog", "showUnbindConfirmDialog()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m287invoke() {
        final DoraObricEarbudsGeneralSettingsFragment r0 = (DoraObricEarbudsGeneralSettingsFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricEarbudsGeneralSettingsFragment.p;
        r0.getClass();
        int r2 = j49.a.a;
        j49.a.i();
        com.obric.oui.dialog.v2.alert.g r3 = new com.obric.oui.dialog.v2.alert.g(r0.requireContext());
        r3.w = false;
        String r4 = r0.getString(2131902459);
        r3.j = false;
        r3.h = r4;
        r3.i = r0.getString(2131902458);
        r3.m = 0;
        r3.t = true;
        r3.e(r0.getString(2131902465), new c());
        r3.g(r0.getString(2131902418), new d(r0), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r5 = r3.a();
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
        m287invoke();
        return Unit.INSTANCE;
    }
}
