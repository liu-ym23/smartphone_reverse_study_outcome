package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class CronetManifest {
    static final String METRICS_OPT_IN_META_DATA_STR = "com.ttnet.org.chromium.net.CronetMetricsOptIn";

    private CronetManifest() {
    }

    public static boolean isAppOptedInForTelemetry(Context r2, CronetLogger.CronetSource r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ApplicationInfo r5 = r4.getPackageManager().getApplicationInfo(r4.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r5.metaData == null) goto L11;
        return r5.metaData.getBoolean(METRICS_OPT_IN_META_DATA_STR);
    L11:
        return false;
    L12:
        return false;
    }
}
