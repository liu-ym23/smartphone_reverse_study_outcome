package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$4$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$4$3(Object r8) {
        super(0, r8, DoraObricEarbudsBroadcastSettingFragment.class, "openServiceNoticeSheet", "openServiceNoticeSheet()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m261invoke() {
        DoraObricEarbudsBroadcastSettingFragment r0 = (DoraObricEarbudsBroadcastSettingFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricEarbudsBroadcastSettingFragment.F;
        r0.getClass();
        DoraObricEarbudsServiceNotificationSheet r2 = new DoraObricEarbudsServiceNotificationSheet();
        FragmentManager r3 = r0.getParentFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DoraObricEarbudsServiceNotificationSheet", r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r4) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DoraObricEarbudsServiceNotificationSheet");
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m261invoke();
        return Unit.INSTANCE;
    }
}
