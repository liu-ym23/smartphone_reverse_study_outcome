package com.bytedance.android.live.core.setting;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d7 {
    public static void a(String r4, Throwable r5) {
        if (r5 != null) goto L6;
        r5 = new Throwable(r4);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        int r6 = d6.a;
        Intrinsics.checkNotNullParameter("ensureNotReachHereTest", "tag");
        Intrinsics.checkNotNullParameter(th, "throwable");
        wa1.a r0 = wa1.d.a;
        Intrinsics.checkNotNullParameter("ensureNotReachHereTest", "tag");
        Intrinsics.checkNotNullParameter(th, "throwable");
        wa1.a r1 = wa1.d.a;
        if (r1 == null) goto L23;
        r1.e("ensureNotReachHereTest", "error occur!", th);
        return;
    L23:
        return;
    L6:
        if (LiveSettingConfig.LIVE_ENABLE_SETTING_MONITOR.getValue().booleanValue() == false) goto L10;
        String r7 = "[SettingGuard]".concat(r4);     // Catch: Throwable -> L14
        int r2 = d6.a;     // Catch: Throwable -> L14
        wa1.a r3 = wa1.d.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        r3.ensureNotReachHere(r5, r7);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L10:
        int r8 = d6.a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("SettingGuard", "tag");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r5, "throwable");     // Catch: Throwable -> L14
        wa1.a r9 = wa1.d.a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("SettingGuard", "tag");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r5, "throwable");     // Catch: Throwable -> L14
        wa1.a r11 = wa1.d.a;     // Catch: Throwable -> L14
        if (r11 == null) goto L22;
        r11.e("SettingGuard", r4, r5);     // Catch: Throwable -> L14
        return;
    }
}
