package com.larus.dora.obric.device_management.setting.common.name;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h<T> implements FlowCollector {
    public final /* synthetic */ DoraObricDeviceNameFragment a;

    public h(DoraObricDeviceNameFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r5, Continuation r6) {
        a r7 = (a) r5;
        if (Intrinsics.areEqual(r7, a.C0102a.a) == false) goto L8;
        FragmentActivity r8 = this.a.getActivity();
        if (r8 == null) goto L30;
        r8.finish();
    L30:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r7, a.b.a) == false) goto L11;
        DoraObricDeviceNameFragment r9 = this.a;
        int r10 = DoraObricDeviceNameFragment.k;
        r9.getClass();
        WeakReference<com.obric.oui.toast.f> r11 = DoraObricToastUtils.a;
        DoraObricToastUtils.e(r9.requireContext(), 2131904032);
        goto L30
    L11:
        if (Intrinsics.areEqual(r7, a.c.a) == false) goto L27;
        DoraObricDeviceNameFragment r12 = this.a;
        int r13 = DoraObricDeviceNameFragment.k;
        Bundle r14 = r12.getArguments();
        if (r14 != null) goto L15;
    L17:
        boolean r15 = false;
    L19:
        if (r15 == true) goto L21;
        WeakReference<com.obric.oui.toast.f> r16 = DoraObricToastUtils.a;
        DoraObricToastUtils.e(r12.requireContext(), 2131902507);
        goto L30
    L21:
        com.obric.oui.dialog.v2.alert.g r17 = new com.obric.oui.dialog.v2.alert.g(r12.requireContext());
        String r3 = r12.getString(2131903979);
        r17.j = false;
        r17.h = r3;
        r17.i = r12.getString(2131902507);
        r17.m = 0;
        r17.t = true;
        r17.h(r12.getString(2131902173), new f());
        com.obric.oui.dialog.v2.alert.c r18 = r17.a();
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L34;
        DialogLancet.handleBlockedDialogShow(r18);
        goto L30
    L34:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
    L25:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L30
    L15:
        if (r14.getBoolean("key_use_earbuds_name_style", false) != true) goto L17;
        r15 = true;
        goto L19
    L27:
        if (Intrinsics.areEqual(r7, a.d.a) == false) goto L32;
        DoraObricDeviceNameFragment r20 = this.a;
        int r21 = DoraObricDeviceNameFragment.k;
        r20.getClass();
        WeakReference<com.obric.oui.toast.f> r22 = DoraObricToastUtils.a;
        DoraObricToastUtils.e(r20.requireContext(), 2131904037);
        goto L30
    L32:
        throw new NoWhenBranchMatchedException();
    }
}
