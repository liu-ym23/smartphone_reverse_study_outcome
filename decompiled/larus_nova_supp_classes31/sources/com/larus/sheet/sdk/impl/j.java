package com.larus.sheet.sdk.impl;

import android.content.res.Resources;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import ew4.w;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements w {
    public j() {
    }

    public final Integer E0() {
        Resources r0 = AppHost.a.getApplication().getResources();
        int r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        if (r1 <= i5.L()) goto L5;
        r1 = i5.L();
    L5:
        FLogger.a.i("SheetSdkServiceImplV2", "getDialogMaxWidth: " + r1);
        return Integer.valueOf(r1);
    }

    public final Integer p1() {
        return 2131239539;
    }
}
