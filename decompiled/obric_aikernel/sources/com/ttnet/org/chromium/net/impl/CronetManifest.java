package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class CronetManifest {
    static final String METRICS_OPT_IN_META_DATA_STR = "com.ttnet.org.chromium.net.CronetMetricsOptIn";

    private CronetManifest() {
    }

    @VisibleForTesting
    public static boolean isAppOptedInForTelemetry(Context r10, CronetLogger.CronetSource r11) {
        Bundle r12 = r10.getPackageManager().getApplicationInfo(r10.getPackageName(), 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r12 == null) goto L11;
        return r12.getBoolean(METRICS_OPT_IN_META_DATA_STR);
    L11:
        return false;
    L12:
        return false;
    }
}
