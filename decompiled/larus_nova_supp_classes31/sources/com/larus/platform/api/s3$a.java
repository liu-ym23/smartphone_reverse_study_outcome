package com.larus.platform.api;

import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s3$a {
    public static /* synthetic */ void b() {
        i3.a.g(TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS);
    }

    public static /* synthetic */ void a(TriggerLoginScene r1, int r2) {
        i3 r0 = i3.a;
        if ((r2 & 1) == 0) goto L5;
        r1 = TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS;
    L5:
        r0.d(r1, null);
    }
}
