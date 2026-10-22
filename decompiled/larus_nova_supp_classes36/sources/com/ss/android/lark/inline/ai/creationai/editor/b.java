package com.ss.android.lark.inline.ai.creationai.editor;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inline.ai.creationai.d0;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("CreationAIEditorBridge", "mOvertimeRunnable");     // Catch: Throwable -> L4
        int r0 = d0.b;     // Catch: Throwable -> L4
        d0.a.a(405, "overtime", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
