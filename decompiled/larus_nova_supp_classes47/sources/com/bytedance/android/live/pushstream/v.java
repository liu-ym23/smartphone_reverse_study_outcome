package com.bytedance.android.live.pushstream;

import android.text.TextUtils;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.livesdk.s6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public static final IPerfToolsService a = null;
    public static v b;

    public v() {
    }

    static {
        a = jc1.k.f(IPerfToolsService.class);
    }

    public static v b() {
        if (b != null) goto L15;
        monitor-enter(v.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new v();     // Catch: Throwable -> L11
    L9:
        monitor-exit(v.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public static boolean a() {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L9:
        return false;
    L5:
        if (((Boolean) s6.a.getValue()).booleanValue() == false) goto L9;
        if (a == null) goto L9;
        return true;
    }

    public final void c(String r2, String r3) {
        if (a() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return;
    L8:
        a.setData(r2, r3);
    }
}
