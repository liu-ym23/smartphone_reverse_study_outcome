package com.obric.assistant.onelogin;

import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z implements n38.h {
    public final /* synthetic */ Function0<Unit> a;

    public z(w r1) {
        this.a = r1;
    }

    public final void b(LoginPlatform r1, String r2, Boolean r3) {
        FLogger.a.i("ObricOneLoginUtils", "doubaoLogout success");
        this.a.invoke();
    }

    public final void a(LoginPlatform r1, int r2, String r3, String r4, String r5, Integer r6, String r7, Map r8) {
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("doubaoLogout failed, errorCode: ");
        r10.append(r2);
        r10.append(", errorMessage: ");
        if (r3 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        g2a.e r11 = g2a.e.a;
        String r12 = g2a.f.a(r3, false, false);
    L6:
        r10.append(r12);
        r9.e("ObricOneLoginUtils", r10.toString());
        this.a.invoke();
        return;
    L5:
        r12 = null;
        goto L6
    }
}
