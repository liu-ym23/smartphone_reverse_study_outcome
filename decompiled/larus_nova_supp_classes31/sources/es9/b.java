package es9;

import android.app.Activity;
import com.bytedance.praisedialoglib.manager.h;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ds9.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements x57.b {
    public final String a;

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        this.a = r2;
    }

    public final void a(h.a r4) {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        f r1 = new f(r0, this.a);
        r1.k = new a(r4);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }
}
