package com.larus.common.baidunavi.impl.notification;

import android.app.UiModeManager;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
    }

    public static boolean a() {
        UiModeManager r0 = (UiModeManager) a.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getNightMode() != 2) goto L7;
        return true;
    }
}
