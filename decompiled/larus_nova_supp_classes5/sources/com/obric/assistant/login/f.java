package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;
import n38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements v {
    public f() {
    }

    public final boolean a(ObricLoginType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        if (r2 != ObricLoginType.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        FLogger.a.i("ObricLoginDoubaoAccountEventStrategy", "NoneDoubaoAccountEventStrategy ignore doubao account online");
    }

    public final void c(a r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "previousContext");
        FLogger.a.i("ObricLoginDoubaoAccountEventStrategy", "NoneDoubaoAccountEventStrategy ignore doubao account offline");
    }
}
