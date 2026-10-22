package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.onelogin.c0;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;
import n38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements v {
    public i() {
    }

    public final boolean a(ObricLoginType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        if (r2 != ObricLoginType.O_SYSTEM_ONE_LOGIN) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        f0 r0 = f0.a;
        String r3 = r2.d;
        r0.getClass();
        f0.a(r3);
    }

    public final void c(a r4, u r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "previousContext");
        if (w.a.contains(r4.d) == false) goto L6;
        FLogger.a.i("ObricLoginDoubaoAccountEventStrategy", "OSystemDoubaoAccountEventStrategy ignore offline, scene: " + r4.d);
        return;
    L6:
        a r6 = r5.b;
        String r0 = r6.b;
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
    L19:
        FLogger.a.i("ObricLoginDoubaoAccountEventStrategy", "OSystemDoubaoAccountEventStrategy ignore offline, account not same");
        return;
    L15:
        if (Intrinsics.areEqual(r6.b, r4.b.b) == false) goto L19;
        FLogger.a.i("ObricLoginDoubaoAccountEventStrategy", "OSystemDoubaoAccountEventStrategy one login account offline, logout assistant and O account");
        c0.b(true, "logout_by_o_matrix", new h());
        return;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    }
}
