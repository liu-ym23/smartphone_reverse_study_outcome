package com.larus.dora.impl.device.manage;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import com.larus.dora.impl.device.manage.widget.DoraDeviceManagementConnectFailedDialog;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0<T> implements FlowCollector {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public g0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        com.larus.dora.impl.device.manage.viewmodel.a r9 = (com.larus.dora.impl.device.manage.viewmodel.a) r7;
        String r0 = null;
        if ((r9 instanceof com.larus.dora.impl.device.manage.viewmodel.a.C0038a) == false) goto L18;
        final DoraGDeviceManagementFragment r10 = this.a;
        final DoraDevice r11 = ((com.larus.dora.impl.device.manage.viewmodel.a.C0038a) r9).a;
        int r1 = DoraGDeviceManagementFragment.q;
        r10.getClass();
        if (o59.a.p(r11) == true) goto L7;
    L12:
        r10.X90();
        CommonDialog.a r2 = new CommonDialog.a();
        int r3 = com.larus.utils.j0.a;
        r2.i(com.larus.utils.j0.d(2131902447));
        r2.g(com.larus.utils.j0.d(2131902446));
        CommonDialog.a.f(r2, new m0(r10, r11), com.larus.utils.j0.d(2131902418), false, 12);
        CommonDialog.a.e(r2, new n0(r10, r11), com.larus.utils.j0.d(2131902465), 4);
        r2.z = false;
        Function0<Boolean> r12 = new s();
        Intrinsics.checkNotNullParameter(r12, "callback");
        r2.B = r12;
        CommonDialog r13 = r2.a();
        r10.m = r13;
        FragmentManager r14 = r10.getChildFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, null, r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r13, r4) == true) goto L47;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L16:
        r13.show(r14, null);
    L47:
        return Unit.INSTANCE;
    L7:
        if (o59.a.v(r11) == false) goto L12;
        if (r11.isFactory() == true) goto L11;
        r10.X90();
        CommonDialog r5 = n69.c.a;
        n69.c.b(r10.getContext(), r10.getChildFragmentManager(), new a0(r10, r11), new b0(r10, r11), new s());
        goto L47
    L11:
        r10.Y90().replaceBind(r11);
        goto L47
    L18:
        if ((r9 instanceof com.larus.dora.impl.device.manage.viewmodel.a.b) == false) goto L37;
        DoraGDeviceManagementFragment r15 = this.a;
        int r16 = DoraGDeviceManagementFragment.q;
        DoraDevice r17 = ((DoraGDeviceManagementViewModel.c) r15.Y90().getUiState().getValue()).b;
        DoraGDeviceManagementFragment r6 = this.a;
        DoraDeviceManagementConnectFailedDialog r18 = r15.n;
        if (r18 != null) goto L56;
    L27:
        r15.n = null;
        int r20 = DoraDeviceManagementConnectFailedDialog.h;
        if (r17 == null) goto L30;
        r0 = r17.mac;
    L30:
        DoraDeviceManagementConnectFailedDialog r21 = new DoraDeviceManagementConnectFailedDialog();
        Bundle r22 = new Bundle();
        r22.putString("arg_device_mac", r0);
        r21.setArguments(r22);
        FragmentManager r23 = r6.getChildFragmentManager();
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r21, "ConnectFailedDialog", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r21, r24) == false) goto L54;
    L35:
        r15.n = r21;
        goto L47
    L54:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L34:
        r21.show(r23, "ConnectFailedDialog");
        goto L35
    L56:
        r18.dismissAllowingStateLoss();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r25 = DialogFragmentLancet.sLastShowStack;
        if (r25 == null) goto L27;
        com.bytedance.crash.d.d(r25, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L27
    L37:
        if ((r9 instanceof com.larus.dora.impl.device.manage.viewmodel.a.d) == false) goto L45;
        DoraGDeviceManagementFragment r26 = this.a;
        DoraDevice r27 = ((com.larus.dora.impl.device.manage.viewmodel.a.d) r9).a;
        int r28 = DoraGDeviceManagementFragment.q;
        r26.getClass();
        g49.d.d("DoraGDeviceManagementFragment", "openDynamicManagementPage mac=" + r27.mac);
        Context r30 = r26.getContext();
        if (r30 != null) goto L41;
        r30 = AppHost.a.getApplication();
    L41:
        com.bytedance.router.i r31 = SmartRouter.buildRoute(r30, "//dora_dynamic_list");
        r31.d = 2130772401;
        r31.e = 2130772399;
        r31.c.putExtra("product_id", n1.c(r27));
        r31.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r27.model);
        r31.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r27.mac);
        r31.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r31.d();
        FragmentActivity r32 = r26.getActivity();
        if (r32 == null) goto L47;
        r32.finish();
        goto L47
    L45:
        if ((r9 instanceof com.larus.dora.impl.device.manage.viewmodel.a.c) == false) goto L47;
        t19.s r33 = t19.s.a;
        Application r34 = AppHost.a.getApplication();
        ((com.larus.dora.impl.device.manage.viewmodel.a.c) r9).getClass();
        r33.getClass();
        t19.s.c(r34, null);
        throw null;
    }
}
