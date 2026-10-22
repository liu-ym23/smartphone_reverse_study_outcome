package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements Runnable {
    public final /* synthetic */ hwb.c a;

    public h(hwb.c r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "autoHide", "collapse float, recordingId=" + this.a.a, null, 8);
        tfb.a.b r1 = tfb.a.a;
        String r2 = this.a.a;
        Intrinsics.checkNotNullParameter(r2, "tag");
        AppFloatManager r3 = com.ss.android.lark.floating.widget.appfloat.c.a(r2);
        if (r3 == null) goto L6;
        r3.c(false);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
