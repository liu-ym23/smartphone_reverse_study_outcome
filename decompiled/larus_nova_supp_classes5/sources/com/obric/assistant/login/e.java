package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements t {
    public e() {
    }

    public final boolean a(ObricLoginType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        if (r2 != ObricLoginType.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "businessScene");
        FLogger.a.i("ObricLoginConsistencyStrategy", "NoneAccountConsistencyStrategy ignore O account consistency recover");
    }
}
