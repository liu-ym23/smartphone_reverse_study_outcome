package ga8;

import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.larus.avlink.simulInterpret.settings.TimbreCloneFragment;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.DoraConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ TimbreCloneFragment a;

    public /* synthetic */ a(TimbreCloneFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8) {
        final TimbreCloneFragment r0 = this.a;
        final boolean r9 = ((Boolean) r8).booleanValue();
        int r1 = TimbreCloneFragment.i;
        FLogger.a.i(r0.f, "Timbre Clone Switch checked: " + r9);
        if (ha8.d.a == false) goto L19;
        CommonDialog r2 = r0.g;
        if (r2 != null) goto L25;
    L13:
        CommonDialog.a r3 = new CommonDialog.a();
        r3.i(r0.getString(2131904006));
        r3.g(r0.getString(2131904005));
        CommonDialog.a.f(r3, new f(r0, r9), r0.getString(2131905619), false, 12);
        CommonDialog.a.e(r3, new g(r0, r9), r0.getString(2131902465), 4);
        r3.z = false;
        Function0 r4 = new d(r0, r9);
        Intrinsics.checkNotNullParameter(r4, "callback");
        r3.B = r4;
        CommonDialog r10 = r3.a();
        r0.g = r10;
        FragmentManager r5 = r0.getChildFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, null, r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r10, r6) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L17:
        r10.show(r5, null);
    L23:
        return Unit.INSTANCE;
    L25:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L12:
        r0.g = null;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L12;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    L19:
        if (r9 == false) goto L21;
        Keva r11 = DoraConfig.a;
        Intrinsics.checkNotNullParameter("clone", "speaker");
        DoraConfig.a.storeString("key_timbre_clone", "clone");
        goto L23
    L21:
        Keva r12 = DoraConfig.a;
        Intrinsics.checkNotNullParameter("", "speaker");
        DoraConfig.a.storeString("key_timbre_clone", "");
        goto L23
    }
}
