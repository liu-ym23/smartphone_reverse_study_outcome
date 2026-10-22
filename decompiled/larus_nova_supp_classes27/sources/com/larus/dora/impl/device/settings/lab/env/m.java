package com.larus.dora.impl.device.settings.lab.env;

import com.bytedance.keva.Keva;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Function0 {
    public /* synthetic */ m() {
    }

    public final Object invoke() {
        int r2 = 720;
        Integer r0 = Integer.valueOf(((Keva) g49.b.a.getValue()).getInt("key_env_observe_temporary_override_minutes", 720));
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        r2 = r0.intValue();
    L12:
        return Long.valueOf(((long) r2) * 60000);
    L5:
        r1 = false;
        goto L6
    }
}
