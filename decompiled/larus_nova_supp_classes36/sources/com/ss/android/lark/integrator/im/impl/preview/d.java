package com.ss.android.lark.integrator.im.impl.preview;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ OfficeUrlPreviewSessionImpl a;
    public final /* synthetic */ List<String> b;

    public d(OfficeUrlPreviewSessionImpl r1, List<String> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.a.h.get() == true) goto L11;
        sza.d r0 = this.a.d;     // Catch: Throwable -> L8
        if (r0 == null) goto L15;
        r0.a(this.b);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }
}
