package com.larus.dora.impl.onboarding.othersmart.archive;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements Runnable {
    public final /* synthetic */ CustomBarCountAudioVisualizer a;
    public final /* synthetic */ byte[] b;

    public i(CustomBarCountAudioVisualizer r1, byte[] r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.a.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        this.a.setAudioData(this.b);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
