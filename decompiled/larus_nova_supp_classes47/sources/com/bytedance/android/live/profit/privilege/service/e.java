package com.bytedance.android.live.profit.privilege.service;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends b7.a {
    public final void onRelease() {
        ALogger.e("PrivilegePreloadService", "card released");
    }

    public e() {
    }

    public final void onLoadSuccess(View r2) {
        ALogger.w("PrivilegePreloadService", "load succeed");
    }

    public final void onContainerError(View r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        ALogger.e("PrivilegePreloadService", "load error: code=" + r3 + ", reason=" + r4);
    }

    public final void onLoadFail(View r2, String r3, String r4) {
        ALogger.e("PrivilegePreloadService", "load error: url=" + r3 + ", reason=" + r4);
    }
}
