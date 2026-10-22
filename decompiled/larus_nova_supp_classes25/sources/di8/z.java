package di8;

import com.bytedance.crash.d;
import com.larus.bmhome.chat.nestedmenu.ui.OfficeTaskDeviceSwitchDialogFragment;
import com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z implements PcDeviceSelectionHandler.a {
    public final /* synthetic */ OfficeTaskDeviceSwitchDialogFragment a;
    public final /* synthetic */ be8.a b;

    public final void b(String r1) {
    }

    public final void a(final PcDevice r4) {
        Intrinsics.checkNotNullParameter(r4, "device");
        OfficeTaskDeviceSwitchDialogFragment r0 = this.a;
        final be8.a r1 = this.b;
        r0.S90(true, new y(r1, r4));
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void c(final PcDevice r4) {
        Intrinsics.checkNotNullParameter(r4, "device");
        OfficeTaskDeviceSwitchDialogFragment r0 = this.a;
        final be8.a r1 = this.b;
        r0.S90(true, new x(r1, r4));
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public z(OfficeTaskDeviceSwitchDialogFragment r1, be8.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
