package com.obric.assistant.login;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.onelogin.c0;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k implements t {
    public k() {
    }

    public final boolean a(ObricLoginType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        if (r2 != ObricLoginType.O_SYSTEM_ONE_LOGIN) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "businessScene");
        u.d.getClass();
        u r0 = u.e;
        g r1 = u.a.b();
        a r2 = r0.b;
        if (r2.a == true) goto L6;
        FLogger.a.i("ObricLoginConsistencyStrategy", "OSystemOneLoginConsistencyStrategy assistant no login, ignore consistency check");
        return;
    L6:
        String r3 = r2.b;
        boolean r4 = true;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L26;
        String r6 = r1.b;
        if (r6 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L26;
        if (Intrinsics.areEqual(r2.b, r1.b) == false) goto L26;
        r4 = false;
        goto L26
    L17:
        if (r6.length() == 0) goto L20;
        r8 = false;
    L26:
        if (r4 == true) goto L30;
        FLogger.a.i("ObricLoginConsistencyStrategy", "OSystemOneLoginConsistencyStrategy account same, no need recover");
        return;
    L30:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L33;
        FLogger.a.i("ObricLoginConsistencyStrategy", "OSystemOneLoginConsistencyStrategy account not same, network unavailable, skip recover");
        return;
    L33:
        FLogger.a.i("ObricLoginConsistencyStrategy", "OSystemOneLoginConsistencyStrategy account not same, try to relogin");
        c0.b(false, r7, new j());
        return;
    L9:
        if (r3.length() == 0) goto L12;
        r5 = false;
        goto L13
    }
}
