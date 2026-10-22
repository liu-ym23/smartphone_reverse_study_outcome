package com.larus.dora.impl.device.manage.settings;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u<T> implements FlowCollector {
    public final /* synthetic */ DoraDeviceSettingsFragment a;

    public u(DoraDeviceSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r12, Continuation r13) {
        DoraDeviceSettingsViewModel.c r14 = (DoraDeviceSettingsViewModel.c) r12;
        if ((r14 instanceof DoraDeviceSettingsViewModel.c.b) == false) goto L14;
        final DoraDeviceSettingsFragment r15 = this.a;
        final DoraDevice r16 = ((DoraDeviceSettingsViewModel.c.b) r14).a;
        int r0 = DoraDeviceSettingsFragment.w;
        r15.getClass();
        if (o59.a.p(r16) == true) goto L7;
    L12:
        r15.X90();
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(j0.d(2131902447));
        r1.g(j0.d(2131902446));
        CommonDialog.a.f(r1, new x(r15, r16), j0.d(2131902418), false, 12);
        CommonDialog.a.e(r1, new y(r15, r16), j0.d(2131902465), 4);
        r1.z = false;
        Function0<Boolean> r17 = new i();
        Intrinsics.checkNotNullParameter(r17, "callback");
        r1.B = r17;
        CommonDialog r18 = r1.a();
        r15.l = r18;
        DoraDeviceSettingsFragment.W90(r18, r15.getChildFragmentManager());
    L35:
        return Unit.INSTANCE;
    L7:
        if (o59.a.v(r16) == false) goto L12;
        if (r16.isFactory() == true) goto L11;
        r15.X90();
        CommonDialog r2 = n69.c.a;
        n69.c.b(r15.getContext(), r15.getChildFragmentManager(), new l(r15, r16), new m(r15, r16), new i());
        goto L35
    L11:
        r15.Y90().replaceBind(r16);
        goto L35
    L14:
        if ((r14 instanceof DoraDeviceSettingsViewModel.c.C0036c) == false) goto L30;
        DoraDeviceSettingsFragment r110 = this.a;
        int r111 = DoraDeviceSettingsFragment.w;
        final DoraDeviceSettingsViewModel r112 = r110.Y90();
        final DoraDevice r3 = this.a.p;
        DoraDeviceSettingsFragment r4 = this.a;
        DoraDeviceSettingsConnectFailedDialog r5 = r110.k;
        if (r5 != null) goto L41;
    L23:
        r110.k = null;
        DoraDeviceSettingsConnectFailedDialog r6 = new DoraDeviceSettingsConnectFailedDialog(r112, r3);
        r6.h = new j(r112, r3);
        FragmentManager r113 = r4.getChildFragmentManager();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "ConnectFailedDialog", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r113, r6, r7) == false) goto L39;
    L28:
        r110.k = r6;
        goto L35
    L39:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L27:
        r6.show(r113, "ConnectFailedDialog");
        goto L28
    L41:
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L23;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L30:
        if ((r14 instanceof DoraDeviceSettingsViewModel.c.d) == false) goto L32;
        t19.s r114 = t19.s.a;
        Application r9 = AppHost.a.getApplication();
        ((DoraDeviceSettingsViewModel.c.d) r14).getClass();
        r114.getClass();
        t19.s.c(r9, null);
        throw null;
    L32:
        if ((r14 instanceof DoraDeviceSettingsViewModel.c.a) == false) goto L35;
        DoraDeviceSettingsFragment r10 = this.a;
        String r11 = ((DoraDeviceSettingsViewModel.c.a) r14).a;
        t r20 = new t(r14, r10);
        int r115 = DoraDeviceSettingsFragment.w;
        r10.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new DoraDeviceSettingsFragment$checkReady$1(true, r10, r11, r20, null), 3, null);
        goto L35
    }
}
