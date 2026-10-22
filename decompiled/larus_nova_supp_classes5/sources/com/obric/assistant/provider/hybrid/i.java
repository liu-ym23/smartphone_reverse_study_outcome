package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements a {
    static {
    }

    public i() {
    }

    public Bundle call(String r3, Bundle r4) {
        Lazy r5 = we8.e.a;
        int r6 = we8.e.d;
        FLogger.a.i("QueryFontLevelSettingFunctionality", "fontLevel = " + r6);
        Bundle r7 = new Bundle();
        r7.putInt("font_level", r6);
        return r7;
    }
}
