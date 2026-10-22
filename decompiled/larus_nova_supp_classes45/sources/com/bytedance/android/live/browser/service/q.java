package com.bytedance.android.live.browser.service;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements y9.n {
    public q() {
    }

    public final boolean L0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        v60.a r0 = v60.a.a;
        return v60.a.c().containsKey(r2);
    }

    public final boolean u(String r2, String r3, Type r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        v60.a r0 = v60.a.a;
        return v60.a.l(r2, r3, r4);
    }

    public final Object u1(String r9, Type r11, Object r12) {
        Intrinsics.checkNotNullParameter("annie_setting_from_server_key", "key");
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r11, "type");
        return v60.a.a.k(r9, r12, r11, false, com.bytedance.android.live.core.utils.v.a(), false);
    }
}
