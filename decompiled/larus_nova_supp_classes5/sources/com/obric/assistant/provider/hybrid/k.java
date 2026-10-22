package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.bytedance.keva.Keva;
import com.larus.settings.value.e10;
import com.larus.settings.value.pb;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k implements a {
    static {
    }

    public k() {
    }

    public Bundle call(String r3, Bundle r4) {
        Keva r5 = xg9.b.a();
        if (kga.b.a().e() == true) goto L12;
        e10 r6 = e10.a;
        int r7 = l0.a;
        int r8 = 1;
        int r0 = ((Number) l0.a(1, new pb())).intValue();
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L9;
    L13:
        int r9 = r5.getInt("dark_mode_flag_new", r8);
        FLogger.a.i("QueryNightModeSettingAbility", "nightMode = " + r9);
        Bundle r10 = new Bundle();
        r10.putInt("night_mode", r9);
        return r10;
    L9:
        if (r0 != 2) goto L13;
        r8 = 2;
    L12:
        r8 = -1;
        goto L13
    }
}
