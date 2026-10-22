package com.larus.sheet.sdk.impl;

import android.net.Uri;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements rw4.a {
    public final /* synthetic */ Function5<Boolean, Uri, Throwable, Integer, String, Unit> a;

    public final void onDismiss() {
    }

    public final void onDownloading(int r1) {
    }

    public final void onExportStart() {
    }

    public final void onPolling(int r1) {
    }

    public final void onStartDownload() {
    }

    public final void onStartPolling() {
    }

    public l(com.larus.sheet.operation.download.b r1) {
        this.a = r1;
    }

    public final void onSuccess(Uri r10) {
        FLogger.a.i("SheetSdkServiceImplV2", "export onSuccess: uri:" + r10);
        this.a.invoke(Boolean.TRUE, r10, null, null, null);
    }

    public final void onFail(int r10, Throwable r11) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("export onFail: error:");
        if (r11 == null) goto L5;
        String r2 = r11.getMessage();
    L6:
        r1.append(r2);
        r0.i("SheetSdkServiceImplV2", r1.toString());
        Function5<Boolean, Uri, Throwable, Integer, String, Unit> r3 = this.a;
        Boolean r4 = Boolean.FALSE;
        Integer r7 = Integer.valueOf(r10);
        if (r11 == null) goto L10;
        String r12 = r11.getMessage();
        if (r12 == null) goto L10;
    L11:
        r3.invoke(r4, null, r11, r7, r12);
        return;
    L10:
        r12 = "";
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
