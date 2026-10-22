package com.larus.dora.obric.device_management.device_home;

import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceHomeFragment$setupQuickActionGrid$adapter$1 extends FunctionReferenceImpl implements Function1<DoraObricDeviceHomeQuickActionType, Unit> {
    public DoraObricDeviceHomeFragment$setupQuickActionGrid$adapter$1(Object r8) {
        super(1, r8, DoraObricDeviceHomeFragment.class, "onQuickActionClicked", "onQuickActionClicked(Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionType;)V", 0);
    }

    public final void invoke(DoraObricDeviceHomeQuickActionType r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        DoraObricDeviceHomeFragment r0 = (DoraObricDeviceHomeFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricDeviceHomeFragment.R;
        r0.getClass();
        int r2 = DoraObricDeviceHomeFragment.g.e[r5.ordinal()];
        boolean r3 = true;
        if (r2 != 1) goto L5;
        String r4 = "quicknote";
    L19:
        if (r4 == null) goto L22;
        y69.a.c(r4);
    L22:
        if (r5 != DoraObricDeviceHomeQuickActionType.RECORD_MINUTES) goto L32;
        IObricDoraService r6 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r6 != null) goto L26;
    L28:
        r3 = false;
    L29:
        g49.d.d("DoraObricDeviceHomeFragment", "record minutes quick action clicked, handledByObric=" + r3);
        if (r3 == false) goto L32;
        return;
    L26:
        if (r6.i(r0.requireContext()) != true) goto L28;
    L32:
        r0.ia0().onQuickActionClicked(r5);
        return;
    L5:
        if (r2 != 2) goto L7;
        r4 = "recording";
        goto L19
    L7:
        if (r2 != 3) goto L9;
        r4 = "translation";
        goto L19
    L9:
        if (r2 != 4) goto L11;
    L15:
        r4 = null;
        goto L19
    L11:
        if (r2 == 5) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((DoraObricDeviceHomeQuickActionType) r1);
        return Unit.INSTANCE;
    }
}
