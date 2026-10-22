package com.obric.aikernel.middleware.impl.obric;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final i a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        return new i(r10, r10 + ".AIKernelService", true);
    }

    public static final e b(com.obric.aikernel.api.base.a r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "appConfigs");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r12, "currentProcessName");
        return new e(r10.l(r11, r12), false);
    }
}
