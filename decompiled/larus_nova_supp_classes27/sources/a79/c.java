package a79;

import android.content.Context;
import android.os.Build;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.i;
import com.obric.oui.dialog.v2.alert.g;
import g49.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AbstractDialog a(Context r4, final boolean r5, final Function0 r6, final Function0 r7) {
        Intrinsics.checkNotNullParameter(r6, "onConfirm");
        Intrinsics.checkNotNullParameter(r7, "onCancel");
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 30) goto L9;
        d.e("DoraObricRebindDialog", "OUI rebind unavailable: api=" + r1 + " < 30");
        return null;
    L9:
        d.d("DoraObricRebindDialog", "show OUI rebind dialog api=" + r1);
        g r0 = new g(r4);
        ((i) r0).c = false;
        r0.w = false;
        int r2 = j0.a;
        String r3 = j0.d(2131902922);
        r0.j = false;
        r0.h = r3;
        r0.i = j0.d(2131902924);
        g.c(r0);
        r0.e(j0.d(2131902465), new a(r7));
        r0.h(j0.d(2131902418), new b(r6, r5));
        com.obric.oui.dialog.v2.alert.c r8 = r0.a();
        com.obric.oui.dialog.v2.alert.c r9 = r8;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r9);
    L14:
        return r8;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L14
    }
}
