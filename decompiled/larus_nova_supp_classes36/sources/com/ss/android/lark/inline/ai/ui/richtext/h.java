package com.ss.android.lark.inline.ai.ui.richtext;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("RichtextPreviewBridge", "mOvertimeRunnable");     // Catch: Throwable -> L4
        int r0 = zlb.a.d;     // Catch: Throwable -> L4
        zlb.a.C0355a.e(405, "overtime", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
