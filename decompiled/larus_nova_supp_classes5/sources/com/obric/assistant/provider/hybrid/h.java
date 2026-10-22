package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h implements a {
    static {
    }

    public h() {
    }

    public Bundle call(String r3, Bundle r4) {
        com.obric.assistant.settings.h.a.getClass();
        com.obric.assistant.settings.h.a r5 = com.obric.assistant.settings.h.a();
        FLogger.a.i("QueryCocreationReviewEntryEnabled", "call enabled=" + r5.a + ", resolved=" + r5.b + ", source=" + r5.c);
        Bundle r6 = new Bundle();
        r6.putBoolean("enabled", r5.a);
        r6.putBoolean("resolved", r5.b);
        r6.putString("source", r5.c);
        return r6;
    }
}
