package com.ss.android.lark.framework.assembly.appconfig;

import c0c.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends b {
    public a(j r1) {
        super(r1);
    }

    public final void nf(f0c.b r3) {
        Log.i("InitSettingsTask", "onPrepared");
        Scene r4 = r3.b.b;
        if (Scene.FIRST_ONLINE.equals(r4) == false) goto L5;
    L8:
        InitSettingsTask.k();
        return;
    L5:
        if (Scene.FAST_ONLINE.equals(r4) == true) goto L8;
        if (Scene.SWITCH_ONLINE.equals(r4) == true) goto L8;
    }
}
