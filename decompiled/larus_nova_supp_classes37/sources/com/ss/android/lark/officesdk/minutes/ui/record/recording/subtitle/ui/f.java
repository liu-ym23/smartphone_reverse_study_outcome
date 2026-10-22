package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Runnable {
    public final /* synthetic */ MmSubtitleAdapter a;
    public final /* synthetic */ long b;

    public f(MmSubtitleAdapter r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Long r0 = this.a.l;     // Catch: Throwable -> L10
        long r1 = this.b;     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.longValue() != r1) goto L17;
        MmSubtitleAdapter r2 = this.a;     // Catch: Throwable -> L10
        r2.l = null;     // Catch: Throwable -> L10
        r2.z2(Long.valueOf(this.b));     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
