package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Runnable {
    public final /* synthetic */ MmRecordingContentController a;

    public c(MmRecordingContentController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmRecordingContentController.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
