package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tx9.n2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class OfficeTaskDeviceSwitchDialogFragment$taskAdapter$2$1 extends FunctionReferenceImpl implements Function1<w, Unit> {
    public OfficeTaskDeviceSwitchDialogFragment$taskAdapter$2$1(Object r8) {
        super(1, r8, OfficeTaskDeviceSwitchDialogFragment.class, "onTaskItemClicked", "onTaskItemClicked(Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskItem;)V", 0);
    }

    public final void invoke(w r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        OfficeTaskDeviceSwitchDialogFragment r0 = (OfficeTaskDeviceSwitchDialogFragment) ((CallableReference) this).receiver;
        int r1 = OfficeTaskDeviceSwitchDialogFragment.k;
        String r2 = r0.requireArguments().getString("offline_device_id");
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        boolean r3 = r6 instanceof w.b;
        if (r3 == false) goto L9;
        String r4 = "local";
    L11:
        Intrinsics.checkNotNullParameter(r2, "offlineDeviceId");
        Intrinsics.checkNotNullParameter(r4, "computerType");
        n2.a("dispatch_offline_device_click", r2, r4);
        if (r3 == false) goto L17;
        Function1<? super PcDevice, Unit> r5 = r0.d;
        if (r5 == null) goto L26;
        r5.invoke(((w.b) r6).c());
        return;
    L26:
        return;
    L17:
        if ((r6 instanceof w.a) == false) goto L23;
        Function1<? super PcDevice, Unit> r7 = r0.d;
        if (r7 == null) goto L28;
        r7.invoke(null);
        return;
    L28:
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    L9:
        if ((r6 instanceof w.a) == false) goto L25;
        r4 = "cloud";
        goto L11
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((w) r1);
        return Unit.INSTANCE;
    }
}
