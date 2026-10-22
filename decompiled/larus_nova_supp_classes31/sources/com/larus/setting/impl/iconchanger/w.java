package com.larus.setting.impl.iconchanger;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w implements com.larus.platform.api.b {
    public w() {
    }

    public final void a(com.larus.platform.api.c r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Job r4 = ChangeAppIconManager.e;
        if (r4 == null) goto L5;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L5:
        ChangeAppIconManager.d = true;
    }

    public final void b(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ChangeAppIconManager.d = false;
    }
}
