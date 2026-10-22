package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officewebview.base.OfficeWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements Runnable {
    public final /* synthetic */ MmSummaryWebHelper a;

    public n(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OfficeWebView r0 = this.a.e;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.invalidate();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
