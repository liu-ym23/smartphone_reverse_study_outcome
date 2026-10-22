package com.larus.slides.sdk.impl;

import android.net.Uri;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements rw4.a {
    public final /* synthetic */ Function4<Boolean, Uri, Integer, String, Unit> a;

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

    public d(com.larus.slides.operation.download.a r1) {
        this.a = r1;
    }

    public final void onSuccess(Uri r4) {
        FLogger.a.i("SlidesSdkServiceImplV2", "export onSuccess: uri:" + r4);
        this.a.invoke(Boolean.TRUE, r4, null, null);
    }

    public final void onFail(int r5, Throwable r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("export onFail: error:");
        if (r6 == null) goto L5;
        String r3 = r6.getMessage();
    L6:
        r1.append(r3);
        r0.i("SlidesSdkServiceImplV2", r1.toString());
        Function4<Boolean, Uri, Integer, String, Unit> r2 = this.a;
        Boolean r4 = Boolean.FALSE;
        Integer r7 = Integer.valueOf(r5);
        if (r6 == null) goto L10;
        String r8 = r6.getMessage();
        if (r8 == null) goto L10;
    L11:
        r2.invoke(r4, null, r7, r8);
        return;
    L10:
        r8 = "";
        goto L11
    L5:
        r3 = null;
        goto L6
    }
}
