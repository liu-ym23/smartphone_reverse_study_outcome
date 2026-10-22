package com.larus.bmhome.chat.model.strategy.block;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static boolean a() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isPlugin() == false) goto L7;
        z2.a.w3();
        return false;
    L7:
        if (r0.isOversea() == true) goto L10;
        return true;
    L10:
        return ((Boolean) a.getValue()).booleanValue();
    }
}
