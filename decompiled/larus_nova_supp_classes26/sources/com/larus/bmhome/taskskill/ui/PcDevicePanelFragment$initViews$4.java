package com.larus.bmhome.taskskill.ui;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PcDevicePanelFragment$initViews$4 extends FunctionReferenceImpl implements Function1<i, Unit> {
    public PcDevicePanelFragment$initViews$4(Object r8) {
        super(1, r8, PcDevicePanelFragment.class, "handleItemClick", "handleItemClick(Lcom/larus/bmhome/taskskill/ui/PcDevicePanelItem;)V", 0);
    }

    public final void invoke(i r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        PcDevicePanelFragment r0 = (PcDevicePanelFragment) ((CallableReference) this).receiver;
        int r1 = PcDevicePanelFragment.o;
        r0.getClass();
        if ((r5 instanceof i.b) == false) goto L21;
        i.b r6 = (i.b) r5;
        PcDevice r2 = r6.a;
        if (r2.a == true) goto L34;
        Boolean r3 = r2.r();
        Boolean r4 = Boolean.FALSE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L10;
        String r7 = "offline_pc";
    L16:
        PcDevicePanelFragment.Z90(r7);
        PcDevice r8 = r6.a;
        Context r9 = r0.getContext();
        if (r9 == null) goto L44;
        ((PcDeviceSelectionHandler) r0.n.getValue()).b(r9, LifecycleOwnerKt.getLifecycleScope(r0.getViewLifecycleOwner()), r8);
        return;
    L44:
        return;
    L10:
        if (Intrinsics.areEqual(r2.g(), r4) == false) goto L13;
        r7 = "not_controlled_pc";
        goto L16
    L13:
        if (Intrinsics.areEqual(r2.c(), r4) == false) goto L15;
        r7 = "not_authorized_pc";
        goto L16
    L15:
        r7 = "online_pc";
        goto L16
    L34:
        return;
    L21:
        if (Intrinsics.areEqual(r5, i.a.a) == false) goto L24;
        PcDevicePanelFragment.Z90("connect_to_new");
        r0.X90("add_computer", null);
        return;
    L24:
        if ((r5 instanceof i.c) == false) goto L33;
        PcDevicePanelFragment.Z90("dont_use");
        r0.X90("do_not_use_computer", null);
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L41;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L41:
        return;
    L33:
        if (Intrinsics.areEqual(r5, i.d.a) == false) goto L36;
        return;
    L36:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i) r1);
        return Unit.INSTANCE;
    }
}
