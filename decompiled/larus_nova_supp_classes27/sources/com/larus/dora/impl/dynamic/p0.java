package com.larus.dora.impl.dynamic;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.device_v2.DoraDeviceConnectFailedV2Dialog;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0<T> implements FlowCollector {
    public final /* synthetic */ DoraDynamicFragment a;

    public p0(DoraDynamicFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        DoraDynamicViewModelV2.d r8 = (DoraDynamicViewModelV2.d) r6;
        if ((r8 instanceof DoraDynamicViewModelV2.d.a) == false) goto L14;
        final DoraDynamicFragment r9 = this.a;
        final DoraDevice r10 = ((DoraDynamicViewModelV2.d.a) r8).a;
        int r0 = DoraDynamicFragment.C;
        r9.getClass();
        if (o59.a.p(r10) == true) goto L7;
    L12:
        r9.aa0();
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(com.larus.utils.j0.d(2131902447));
        r1.g(com.larus.utils.j0.d(2131902446));
        CommonDialog.a.f(r1, new s0(r9, r10), com.larus.utils.j0.d(2131902418), false, 12);
        CommonDialog.a.e(r1, new t0(r9, r10), com.larus.utils.j0.d(2131902465), 4);
        r1.z = false;
        Function0<Boolean> r11 = new x();
        Intrinsics.checkNotNullParameter(r11, "callback");
        r1.B = r11;
        CommonDialog r12 = r1.a();
        r9.l = r12;
        DoraDynamicFragment.W90(r12, r9.getChildFragmentManager());
    L33:
        return Unit.INSTANCE;
    L7:
        if (o59.a.v(r10) == false) goto L12;
        if (r10.isFactory() == true) goto L11;
        r9.aa0();
        CommonDialog r2 = n69.c.a;
        n69.c.b(r9.getContext(), r9.getChildFragmentManager(), new o(r9, r10), new w(r9, r10), new x());
        goto L33
    L11:
        r9.ba0().replaceBind(r10);
        goto L33
    L14:
        if ((r8 instanceof DoraDynamicViewModelV2.d.b) == false) goto L30;
        DoraDynamicFragment r13 = this.a;
        int r14 = DoraDynamicFragment.C;
        DoraDynamicViewModelV2 r15 = r13.ba0();
        DoraDevice r3 = this.a.p;
        DoraDynamicFragment r4 = this.a;
        DoraDeviceConnectFailedV2Dialog r5 = r13.k;
        if (r5 != null) goto L37;
    L23:
        r13.k = null;
        DoraDeviceConnectFailedV2Dialog r16 = new DoraDeviceConnectFailedV2Dialog(r15, r3);
        FragmentManager r17 = r4.getChildFragmentManager();
        LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, "ConnectFailedDialog", r18);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r16, r18) == false) goto L35;
    L28:
        r13.k = r16;
        goto L33
    L35:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L27:
        r16.show(r17, "ConnectFailedDialog");
        goto L28
    L37:
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r20 = DialogFragmentLancet.sLastShowStack;
        if (r20 == null) goto L23;
        com.bytedance.crash.d.d(r20, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L30:
        if ((r8 instanceof DoraDynamicViewModelV2.d.c) == false) goto L33;
        t19.s r21 = t19.s.a;
        Application r22 = AppHost.a.getApplication();
        String r23 = ((DoraDynamicViewModelV2.d.c) r8).a;
        r21.getClass();
        t19.s.c(r22, r23);
        goto L33
    }
}
