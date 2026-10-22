package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements Runnable {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public o(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmAINotePanelAnimator r0 = this.a;     // Catch: Throwable -> L4
        r0.G = SystemClock.uptimeMillis() + 700;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
