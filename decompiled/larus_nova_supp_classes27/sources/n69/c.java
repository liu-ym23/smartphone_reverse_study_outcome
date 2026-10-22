package n69;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static CommonDialog a;

    static {
    }

    public static void a() {
        CommonDialog r0 = a;
        if (r0 != null) goto L5;
    L12:
        a = null;
        return;
    L5:
        if (r0.isAdded() == false) goto L12;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L12;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public static void b(Context r8, FragmentManager r9, Function0 r10, Function0 r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r9, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, "confirm");
        Intrinsics.checkNotNullParameter(r11, "cancel");
        Intrinsics.checkNotNullParameter(r12, "backListener");
        if (r8 != null) goto L5;
        return;
    L5:
        a();
        CommonDialog.a r0 = new CommonDialog.a();
        int r1 = j0.a;
        r0.i(j0.d(2131902922));
        r0.g(j0.d(2131902924));
        f0 r2 = new f0(15, Integer.valueOf(ContextCompat.getColor(r8, 2131103143)), null, 4);
        Intrinsics.checkNotNullParameter(r2, "commonDialogTextStyleConfig");
        r0.C = r2;
        boolean r6 = false;
        CommonDialog.a.f(r0, new a(r10), j0.d(2131902930), false, 12);
        f0 r3 = new f0(17, Integer.valueOf(ContextCompat.getColor(r8, 2131103203)), null, 4);
        Intrinsics.checkNotNullParameter(r3, "commonDialogTextStyleConfig");
        r0.D = r3;
        CommonDialog.a.e(r0, new b(r11), j0.d(2131902465), 4);
        f0 r13 = new f0(17, Integer.valueOf(ContextCompat.getColor(r8, 2131103684)), null, 4);
        Intrinsics.checkNotNullParameter(r13, "commonDialogTextStyleConfig");
        r0.E = r13;
        r0.z = false;
        Intrinsics.checkNotNullParameter(r12, "callback");
        r0.B = r12;
        CommonDialog r14 = r0.a();
        a = r14;
        if (r14.isVisible() != true) goto L8;
        r6 = true;
    L8:
        if (r6 == true) goto L20;
        CommonDialog r15 = a;
        if (r15 == null) goto L21;
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, null, r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r15, r16) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r15.show(r9, null);
        return;
    L22:
        return;
    L21:
        return;
    }
}
