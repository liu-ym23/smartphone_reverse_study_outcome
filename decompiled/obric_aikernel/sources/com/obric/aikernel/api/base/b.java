package com.obric.aikernel.api.base;

import com.obric.aikernel.middleware.api.appcontext.IAppConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final String a(String r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        Intrinsics.checkNotNullParameter(r12, "project");
        if (r11 == false) goto L5;
        return r10;
    L5:
        if (IAppConfig.f4504a.a().contains(r10) == true) goto L8;
        return r10;
    L8:
        return r10 + '_' + r12;
    }
}
