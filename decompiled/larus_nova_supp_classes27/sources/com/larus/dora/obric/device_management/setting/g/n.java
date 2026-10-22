package com.larus.dora.obric.device_management.setting.g;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.obric.device_v2.ObricDoraGConnectFailedDialogFragment;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGSettingsFragment a;

    public n(DoraObricGSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r5, Continuation r6) {
        a r7 = (a) r5;
        if ((r7 instanceof a.c) == false) goto L6;
        WeakReference<com.obric.oui.toast.f> r8 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), ((a.c) r7).a);
    L37:
        return Unit.INSTANCE;
    L6:
        if ((r7 instanceof a.d) == false) goto L9;
        WeakReference<com.obric.oui.toast.f> r9 = DoraObricToastUtils.a;
        DoraObricToastUtils.b(this.a.requireContext(), ((a.d) r7).a);
        goto L37
    L9:
        if ((r7 instanceof a.C0105a) == false) goto L12;
        final DoraObricGSettingsFragment r10 = this.a;
        final DoraDevice r11 = ((a.C0105a) r7).a;
        int r0 = DoraObricGSettingsFragment.m;
        r10.getClass();
        CommonDialog r1 = n69.c.a;
        n69.c.b(r10.getContext(), r10.getChildFragmentManager(), new k(r10, r11), new l(r10, r11), new m());
        goto L37
    L12:
        if ((r7 instanceof a.b) == false) goto L32;
        final DoraObricGSettingsFragment r12 = this.a;
        final DoraDevice r13 = ((a.b) r7).a;
        int r2 = DoraObricGSettingsFragment.m;
        ObricDoraGConnectFailedDialogFragment r3 = r12.j;
        if (r3 != null) goto L41;
    L21:
        r12.j = null;
        ObricDoraGConnectFailedDialogFragment r4 = new ObricDoraGConnectFailedDialogFragment();
        if (r13 != null) goto L24;
        DoraDevice r14 = r12.aa0().targetDevice();
    L25:
        r4.d = r14;
        r4.e = new b(r12, r13);
        FragmentManager r15 = r12.getChildFragmentManager();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "ConnectFailedDialog", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r4, r16) == false) goto L43;
    L30:
        r12.j = r4;
        goto L37
    L43:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L29:
        r4.show(r15, "ConnectFailedDialog");
        goto L30
    L24:
        r14 = r13;
        goto L25
    L41:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L21;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L21
    L32:
        if (Intrinsics.areEqual(r7, a.e.a) == false) goto L39;
        DoraObricGSettingsFragment r18 = this.a;
        int r20 = DoraObricGSettingsFragment.m;
        com.bytedance.router.i r21 = SmartRouter.buildRoute(r18.getContext(), "//flow/dora/obric_device_home");
        r21.c.addFlags(603979776);
        r21.d = 2130772401;
        r21.e = 2130772399;
        r21.d();
        FragmentActivity r22 = this.a.getActivity();
        if (r22 == null) goto L37;
        r22.finish();
        goto L37
    L39:
        throw new NoWhenBranchMatchedException();
    }
}
