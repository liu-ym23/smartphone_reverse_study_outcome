package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h2 a(DoraObricEnvironmentMemoryClickAction r1, DoraObricEnvironmentMemoryState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "requestedAction");
        Intrinsics.checkNotNullParameter(r2, "latestState");
        if (r1 == DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH_WITH_OVERRIDE) goto L5;
    L8:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        DoraObricEnvironmentMemoryToastType r5 = DoraObricEnvironmentMemoryToastType.TEMPORARY_OVERRIDE;
    L14:
        return new h2(r4, r5);
    L12:
        r5 = DoraObricEnvironmentMemoryToastType.ENABLED;
        goto L14
    L5:
        if (r2 != DoraObricEnvironmentMemoryState.OFF) goto L8;
        if (r3 == true) goto L8;
        r4 = true;
        goto L10
    }
}
